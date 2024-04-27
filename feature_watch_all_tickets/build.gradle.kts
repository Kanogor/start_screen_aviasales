plugins {
    id(Plugins.library)
    id(Plugins.android)
    id(Plugins.saveArgs)
}

android {
    namespace = "ru.kanogor.feature_watch_all_tickets"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
    }
    compileOptions {
        targetCompatibility = Config.javaVersion
        sourceCompatibility = Config.javaVersion
    }
    kotlinOptions {
        jvmTarget = Config.jmvTarget
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":delegates"))
    implementation(project(":db_remote_api"))
    implementation(project(":core"))
    implementation(project(":core_ui"))

    implementation(Dependencies.Navigation.fragment)
    implementation(Dependencies.Navigation.ui)

    implementation(Dependencies.Di.koinCore)
    implementation(Dependencies.Di.koinAndroid)

    implementation(Dependencies.Core.coreKtx)
    implementation(Dependencies.Core.appcompat)
    implementation(Dependencies.Core.material)
    implementation(Dependencies.Core.constraintlayout)
    implementation(Dependencies.Core.lifecycle)
    implementation(Dependencies.Core.viewmodel)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.fragment:fragment-ktx:1.6.2")
}