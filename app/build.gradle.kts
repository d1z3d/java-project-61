plugins {
    application
    id("java")
    id("checkstyle")
    id("se.patrikerdes.use-latest-versions") version "0.2.18"
    id("com.github.ben-manes.versions") version "0.41.0"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("hexlet.code.App")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.apache.commons:commons-lang3:3.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.compileJava {
    options.release = 20
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}