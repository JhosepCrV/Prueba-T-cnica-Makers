# SmokeTest

Proyecto de pruebas automatizadas tipo smoke con Selenium y JUnit 5 sobre la web de ejemplo https://www.saucedemo.com/. Incluye un set básico para validar el flujo de login y una base para crecer el suite.

**Stack**
1. Java 17
2. Maven
3. Selenium 4
4. JUnit 5
5. WebDriverManager

**Estructura**
1. `src/test/java/com/makers/qa/tests`: pruebas de smoke.
2. `src/test/java/com/makers/qa/pages`: Page Objects.
3. `src/test/java/com/makers/qa/utils`: utilidades y datos de prueba.
4. `APITest/Pruebas API.pdf`: evidencias de pruebas de API con las diferentes peticiones.

**Cómo ejecutar**
1. `mvn test`

**Resultados**
1. Capturas en fallos: `target/screenshots`
2. Reporte HTML: `target/site/surefire-report.html`

**Notas**
1. Las credenciales y mensajes esperados están en `src/test/java/com/makers/qa/utils/TestData.java`.
2. El driver de Chrome se gestiona automáticamente con WebDriverManager.