val kotlin_version: String  = "1.8.10"
val ktor_version: String = "2.2.4"

plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation(kotlin("gradle-plugin", version = kotlin_version))
    implementation(kotlin("serialization", version = kotlin_version))
    implementation("com.github.johnrengelman.shadow", "com.github.johnrengelman.shadow.gradle.plugin", "7.1.2")
    implementation("io.ktor.plugin", "plugin", ktor_version)
    implementation(gradleApi())
    implementation(localGroovy())
}
