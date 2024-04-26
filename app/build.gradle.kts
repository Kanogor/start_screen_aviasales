plugins {
    id(Plugins.application)
    id(Plugins.android)
    id(Plugins.saveArgs)
}

android {
    namespace = "ru.kanogor.startscreenaviasales"
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = "ru.kanogor.startscreenaviasales"
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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

    implementation(project(":feature_airtickets"))
    implementation(project(":feature_hotels"))
    implementation(project(":feature_bell"))
    implementation(project(":feature_profile"))
    implementation(project(":feature_simply"))
    implementation(project(":db_remote_api"))
    implementation(project(":core"))

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
    implementation("androidx.test.ext:junit-ktx:1.1.5")
    implementation(project(":feature_choose_country"))
    androidTestImplementation("org.junit.jupiter:junit-jupiter:5.8.1")


//    implementation(platform(Dependencies.Network.okHttpBom))
//    implementation(Dependencies.Network.okHttp)
//    implementation(Dependencies.Network.okHttpLogging)
//    implementation(Dependencies.Network.retofit)
//    implementation(Dependencies.Network.retofitConverter)
//
//    implementation(Dependencies.Moshi.moshi)
//    ksp(Dependencies.Moshi.ksp)

}