import dependencies.Dependencies
import extensions.addComposeDependencies

plugins {
   id("commons.android-library")
}

dependencies {
    addComposeDependencies()
    implementation(Dependencies.core)
}