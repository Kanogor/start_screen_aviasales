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

rootProject.name = "StartScreenAviasales"
include(":app")
include(":feature_airtickets")
include(":feature_hotels")
include(":feature_bell")
include(":feature_profile")
include(":feature_simply")
include(":core")
include(":delegates")
include(":db_remote_api")
include(":core_ui")
include(":feature_choose_country")
