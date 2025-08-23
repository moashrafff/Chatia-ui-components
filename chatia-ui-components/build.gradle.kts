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


group = providers.gradleProperty("GROUP").get()
version = providers.gradleProperty("VERSION_NAME").get()

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()

    pom {
        name.set(providers.gradleProperty("POM_NAME").orNull ?: "Chatia UI Components")
        description.set(providers.gradleProperty("POM_DESCRIPTION").orNull ?: "Reusable UI components for KMP")
        inceptionYear.set("2025")
        url.set(providers.gradleProperty("POM_URL").orNull ?: "https://github.com/moashrafff/Chatia-ui-components")
        licenses {
            license {
                name.set(providers.gradleProperty("POM_LICENSE_NAME").orNull ?: "The Apache License, Version 2.0")
                url.set(providers.gradleProperty("POM_LICENSE_URL").orNull ?: "https://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set(providers.gradleProperty("POM_DEVELOPER_ID").orNull ?: "moashrafff")
                name.set(providers.gradleProperty("POM_DEVELOPER_NAME").orNull ?: "Mohamed Ashraf")
                url.set(providers.gradleProperty("POM_DEVELOPER_URL").orNull ?: "https://github.com/moashrafff")
            }
        }
        scm {
            url.set(providers.gradleProperty("POM_SCM_URL").orNull ?: "https://github.com/moashrafff/Chatia-ui-components")
            connection.set(providers.gradleProperty("POM_SCM_CONNECTION").orNull
                ?: "scm:git:git://github.com/moashrafff/Chatia-ui-components.git")
            developerConnection.set(providers.gradleProperty("POM_SCM_DEV_CONNECTION").orNull
                ?: "scm:git:ssh://git@github.com/moashrafff/Chatia-ui-components.git")
        }
    }
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class) compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(), iosArm64(), iosSimulatorArm64()
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

