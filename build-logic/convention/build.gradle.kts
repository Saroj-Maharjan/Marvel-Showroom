plugins {
    `kotlin-dsl`
}

group = "com.sawrose.marvel_showroom.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
//        register("androidApplicationCompose"){
//            id = "marvel.android.application.compose"
//            implementationClass = "AndroidApplicationComposeConventionPlugin"
//        }
//
//        register("androidApplication"){
//            id = "marvel.android.application"
//            implementationClass = "AndroidApplicationConventionPlugin"
//        }
//
//        register("androidLibraryCompose"){
//            id = "marvel.android.library.compose"
//            implementationClass = "AndroidLibraryComposeConventionPlugin"
//        }
//
//        register("androidLibrary"){
//            id = "marvel.android.library"
//            implementationClass = "AndroidLibraryConventionPlugin"
//        }
//
//        register("androidFeature") {
//            id = "marvel.android.application.feature"
//            implementationClass = "AndroidFeatureConventionPlugin"
//        }
//
//        register("androidHilt") {
//            id = "marvel.android.hilt"
//            implementationClass = "AndroidHiltConventionPlugin"
//        }
//        register("androidRoom") {
//            id = "marvel.android.room"
//            implementationClass = "AndroidRoomConventionPlugin"
//        }
//        register("androidFlavors") {
//            id = "marvel.android.application.flavors"
//            implementationClass = "AndroidApplicationFlavorsConventionPlugin"
//        }
    }
}