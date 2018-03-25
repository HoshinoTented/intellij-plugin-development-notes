import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.github.HoshinoTented"
version = "1.0"

plugins {
	id("org.jetbrains.intellij") version "0.2.18"
	kotlin("jvm") version "1.2.30"
}

val kotlinVersion = "1.2.30"

intellij {
	localPath = ext["ideaC_path"].toString()
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(kotlin("stdlib-jdk8", kotlinVersion))
}

tasks.withType<KotlinCompile> {
	kotlinOptions.jvmTarget = "1.8"
}