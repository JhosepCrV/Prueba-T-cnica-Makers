package com.makers.qa.tests;

import com.makers.qa.utils.DriverFactory;
import com.makers.qa.utils.TestData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @RegisterExtension
    TestWatcher watcher = new TestWatcher() {
        @Override
        public void testFailed(ExtensionContext context, Throwable e) {
            if (driver == null) {
                return;
            }
            if (!(driver instanceof TakesScreenshot)) {
                return;
            }
            try {
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destDir = new File("target/screenshots");
                destDir.mkdirs();
                String baseName = safeFileName(context.getDisplayName());
                File dest = new File(destDir, baseName + "-" + System.currentTimeMillis() + ".png");
                Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    };

    @BeforeEach
    void setUp() {
        driver = DriverFactory.createChrome();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(TestData.BASE_URL);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private String safeFileName(String name) {
        return name.replaceAll("[^a-zA-Z0-9._-]", "_");
    }
}


