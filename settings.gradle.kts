include(
    ":app",
//    ":commons:ui",
//    ":commons:views",
//    ":core:common",
//    ":core:data",
//    ":core:domain",
////    ":features:home",
//    ":features:dashboard"
)

pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

enableFeaturePreview("VERSION_CATALOGS")
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}
