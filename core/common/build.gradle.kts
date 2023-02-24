import dependencies.AnnotationProcessorsDependencies
import dependencies.Dependencies
import extensions.*
import org.gradle.kotlin.dsl.implementation

plugins {
    id("commons.android-library")
}

allOpen {
    // allows mocking for classes w/o directly opening them for release builds
    annotation("com.vmadalin.core.annotations.OpenClass")
}

android {
    buildTypes.forEach {
        try {
            it.buildConfigStringField("MARVEL_API_BASE_URL", "https://gateway.marvel.com/")
            it.buildConfigStringField("MARVEL_API_KEY_PUBLIC", getLocalProperty("marvel.key.public"))
            it.buildConfigStringField("MARVEL_API_KEY_PRIVATE", getLocalProperty("marvel.key.private"))

            it.buildConfigBooleanField("MARVEL_DATABASE_EXPORT_SCHEMA", false)
            it.buildConfigStringField("MARVEL_DATABASE_NAME", "characters-db")
            it.buildConfigIntField("MARVEL_DATABASE_VERSION", 1)
        } catch (ignored: Exception) {
            throw InvalidUserDataException("You should define 'marvel.key.public' and " +
                    "'marvel.key.private' in local.properties. Visit 'https://developer.marvel.com' " +
                    "to obtain them.")
        }
    }
}

dependencies {
    addComposeDependencies()
    implementation(Dependencies.core)
    implementation(Dependencies.lifecycleRuntime)

    implementation(Dependencies.coroutineCore)
    implementation(Dependencies.coroutineAndroid)

    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofitMoshi)
    implementation(Dependencies.loggingInterceptor)

    implementation(Dependencies.room)
    implementation(Dependencies.roomKtx)
    kapt(AnnotationProcessorsDependencies.roomCompiler)

    implementation(Dependencies.coil)

    implementation(Dependencies.daggerHilt)
    kapt(AnnotationProcessorsDependencies.daggerCompiler)
}