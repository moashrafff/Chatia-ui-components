import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.vanniktech.maven.publish") version "0.28.0"
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

group = "io.github.moashrafff"
version = "1.0.0"

mavenPublishing {
    // Publish to the new Central Portal (S01)
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()

    // groupId, artifactId, version
    coordinates(group.toString(), "chatia-ui-components", version.toString())

    pom {
        name.set("Chatia UI Components")
        description.set("Reusable UI components for Kotlin Multiplatform using Jetpack Compose")
        inceptionYear.set("2025")
        url.set("https://github.com/moashrafff/Chatia-ui-components")

        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }

        developers {
            developer {
                id.set("moashrafff")
                name.set("Mohamed Ashraf")
                url.set("https://github.com/moashrafff")
            }
        }

        scm {
            url.set("https://github.com/moashrafff/Chatia-ui-components")
            connection.set("scm:git:git://github.com/moashrafff/Chatia-ui-components.git")
            developerConnection.set("scm:git:ssh://git@github.com/moashrafff/Chatia-ui-components.git")
        }
    }
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeLib"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.chatia.ui.components"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

