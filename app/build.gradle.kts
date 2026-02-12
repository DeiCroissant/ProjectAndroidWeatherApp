import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.projectandroidweatherapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.projectandroidweatherapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Load API key from .env file
        val envFile = rootProject.file(".env")
        if (!envFile.exists()) {
            throw GradleException(".env file not found in project root. Please create it with OWM_API_KEY=your_key")
        }
        val envProperties = Properties()
        envFile.inputStream().use { envProperties.load(it) }
        val apiKey = envProperties.getProperty("OWM_API_KEY")
            ?: throw GradleException("OWM_API_KEY not found in .env file. Please add OWM_API_KEY=your_key")
        if (apiKey == "your_api_key_here" || apiKey.isBlank()) {
            logger.warn("WARNING: OWM_API_KEY is not set. Please update .env with a valid API key.")
        }
        buildConfigField("String", "OWM_API_KEY", "\"$apiKey\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    // AndroidX Core
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.swiperefreshlayout)

    // Networking
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    implementation(libs.gson)

    // Image Loading
    implementation(libs.glide)
    annotationProcessor(libs.glide.compiler)

    // Lifecycle Components
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.livedata)
    implementation(libs.lifecycle.runtime)
    implementation(libs.lifecycle.common.java8)

    // Room Database (for caching)
    implementation(libs.room.runtime)
    annotationProcessor(libs.room.compiler)

    // Location Services
    implementation(libs.play.services.location)

    // Coroutines (for async operations)
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)

    // Shimmer Effect (loading animation)
    implementation(libs.shimmer)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}