plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.neogradle)
}

group = "io.github.gaming32"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.terraformersmc.com/releases/")
    maven("https://maven.shedaniel.me/")
    maven("https://maven.blamejared.com/")
    mavenLocal()
    maven("https://maven.jemnetworks.com/snapshots")
}

dependencies {
    implementation(libs.minecraft)

    implementation(libs.ktsmc)
    kotlinScriptDef(libs.ktsmc)
}

kotlin {
    jvmToolchain(17)
}
