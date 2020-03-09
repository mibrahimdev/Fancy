plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "io.github.mohamedisoliman.fancy"
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    val lifecycle_version = "2.2.0"
    val room_version = "2.2.4"
    val retrofit = "2.7.2"
    val okHttp = "4.4.0"

    implementation(
        fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar")))
    )
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$embeddedKotlinVersion")
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.core:core-ktx:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.0-beta4")
    implementation("androidx.coordinatorlayout:coordinatorlayout:1.1.0")
    testImplementation("junit:junit:4.13")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")


    //coroutines + rx
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.3")
    implementation("io.reactivex.rxjava3:rxjava:3.0.0")

    //ui
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("com.google.android.material:material:1.1.0")
    //navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.0-alpha03")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.0-alpha03")


    //network
    implementation("com.squareup.retrofit2:retrofit:$retrofit")
    implementation("com.squareup.retrofit2:converter-moshi:$retrofit")
    implementation("com.squareup.okhttp3:logging-interceptor:$okHttp")
    implementation("com.squareup.okhttp3:okhttp:$okHttp")

    //arch components
    implementation("androidx.lifecycle:lifecycle-extensions:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-process:$lifecycle_version")
    //Room
    implementation("androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:$room_version")

    //logging
    implementation("com.jakewharton.timber:timber:4.7.1")

    implementation("com.squareup.picasso:picasso:2.71828")

}
