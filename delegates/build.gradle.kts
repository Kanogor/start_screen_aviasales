plugins {
    id(Plugins.library)
    id(Plugins.android)
}

android {
    namespace = "ru.kanogor.delegates"
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

    implementation("androidx.paging:paging-runtime-ktx:3.2.1")
    implementation(Dependencies.Core.coreKtx)
}