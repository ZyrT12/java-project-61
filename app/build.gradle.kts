plugins {
    id("java")
    application
    id("org.sonarqube") version "6.2.0.5505"
    checkstyle
}

sonar {
    properties {
        property("sonar.projectKey", "ZyrT12_java-project-612")
        property("sonar.organization", "zyrt12")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

application {
    mainClass.set("hexlet.code.App")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}


