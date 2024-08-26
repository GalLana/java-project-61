plugins {
    id("java")
    application
    id("checkstyle") // Подключение плагина checkstyle
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

checkstyle {
    toolVersion = "10.12.4" // Укажите версию Checkstyle, соответствующую вашей среде
    configFile = file("$rootDir/config/checkstyle/checkstyle.xml")
}


dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass.set("hexlet.code.App")
}

tasks.test {
    useJUnitPlatform()
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

tasks.withType<Checkstyle>().configureEach {
    reports {
        html.required.set(true)
        xml.required.set(false)
    }
}