pluginManagement {
    repositories {
        maven("https://maven.neoforged.net/releases/")
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "ktsmc-workspace"
