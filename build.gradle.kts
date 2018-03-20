import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.github.HoshinoTented"
version = "1.0"

plugins {
    kotlin("jvm") version "1.2.30"
}

val kotlinVersion = "1.2.30"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8", kotlinVersion))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}