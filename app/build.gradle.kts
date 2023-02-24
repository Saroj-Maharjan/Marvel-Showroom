plugins {
    id("marvel.android.application")
//    id("marvel.android.application.compose")
    id("marvel.android.application.feature")
    id("marvel.android.hilt")
}

android {
    defaultConfig {
        applicationId = "com.sawrose.marvel_showroom"

        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.sawrose.marvel_showroom.core.testing.TestRunner"
        vectorDrawables { useSupportLibrary = true }
    }

    buildTypes {
        val debug by getting {
            applicationIdSuffix = MSBuiltType.DEBUG.applicationIdSuffix
        }
        val release by getting {
            isMinifyEnabled = true
            applicationIdSuffix = MSBuiltType.RELEASE.applicationIdSuffix
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

            // To publish on the Play store a private signing key is required, but to allow anyone
            // who clones the code to sign and run the release variant, use the debug signing key.
            // TODO: Abstract the signing configuration to a separate file to avoid hardcoding this.
            signingConfig = signingConfigs.getByName("debug")
        }
        val benchmark by creating {
            // Enable all the optimizations from release build through initWith(release).
            initWith(release)
            matchingFallbacks.add("release")
            // Debug key signing is available to everyone.
            signingConfig = signingConfigs.getByName("debug")
            // Only use benchmark proguard rules
            proguardFiles("benchmark-rules.pro")
            isMinifyEnabled = true
            applicationIdSuffix = MSBuiltType.BENCHMARK.applicationIdSuffix
        }
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            excludes.add("/META-INF/LICENSE*")
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
    namespace = "com.sawrose.marvel_showroom"
}

dependencies {
    // Project Dependencies
//    implementation(project(":core:domain"))
//    implementation(project(":core:commons"))

    // Dependencies
    // Compose
    implementation(libs.bundles.compose)

    // Hilt
    implementation(libs.hilt.navigation.compose)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // Ktor Engine
    implementation(libs.ktor.core)
    implementation(libs.ktor.engine.android)

    // SplashScreen
    implementation(libs.splashscreen)

    // Datastore
    implementation(libs.datastore.android)

    // Debug Dependencies
    debugImplementation(libs.bundles.compose.debug)

    // Android Test Dependencies
    androidTestImplementation(libs.hilt.test)
    kaptAndroidTest(libs.hilt.test.compiler)

    androidTestImplementation(libs.test.core)
    androidTestImplementation(libs.bundles.compose.test)
    androidTestImplementation(libs.ktor.engine.mock)
//    androidTestImplementation(project(":core:data-test"))

    // Test Dependencies
    testImplementation(libs.bundles.test.core)
    testImplementation(libs.mockk.agent)
    testImplementation(libs.mockk.android)
}
// androidx.test is forcing JUnit, 4.12. This forces it to use 4.13
configurations.configureEach {
    resolutionStrategy {
        force(libs.junit4)
        // Temporary workaround for https://issuetracker.google.com/174733673
        force("org.objenesis:objenesis:2.6")
    }
}
