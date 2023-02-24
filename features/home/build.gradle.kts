import dependencies.AnnotationProcessorsDependencies
import dependencies.Dependencies
import dependencies.Versions
import extensions.addComposeDependencies

plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.HILT)
}

android {
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION
    defaultConfig {
        minSdk = BuildAndroidConfig.MIN_SDK_VERSION
        testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }

    buildFeatures {
        compose =  true
        viewBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE_COMPILER
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(BuildModules.Core.COMMON))
    addComposeDependencies()
    implementation(Dependencies.core)
    implementation(Dependencies.activityX)

    implementation(Dependencies.daggerHilt)
    kapt(AnnotationProcessorsDependencies.daggerCompiler)
}