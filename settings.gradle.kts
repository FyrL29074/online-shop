pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "online-shop"
include(":app")
include(":features")
include(":features:auth")
include(":features:main")
include(":features:catalog")
include(":features:product")
include(":features:profile")
include(":features:favourites")
include(":navigation")
include(":network")
include(":storage")
include(":state")
