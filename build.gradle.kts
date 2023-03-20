plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "org.fontys"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(files("./lib/engine.jar"))
    implementation(files("./lib/javabuilder.jar"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}