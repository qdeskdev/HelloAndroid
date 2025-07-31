# 📜 Logger

[![JitPack](https://jitpack.io/v/qdeskdev/HelloAndroid.svg)](https://jitpack.io/#qdeskdev/HelloAndroid)

A lightweight and easy-to-use logging library for Android.

---

## 🚀 Installation

### 1️⃣ Add the JitPack repository to your **root** `build.gradle` or `settings.gradle`:

```gradle
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}
2️⃣ Add the dependency in your module-level build.gradle:
gradle
Copy
Edit
dependencies {
    implementation 'com.github.qdeskdev:HelloAndroid:1.0.0'
}
📦 Usage
Here’s a quick example of how to use Logger in your project:

import com.qdeskdev.helloandroid.Logger

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Log a simple message
        Logger.d("Hello from Logger!")

        // Log an error with exception
        try {
            val result = 10 / 0
        } catch (e: Exception) {
            Logger.e("An error occurred", e)
        }
    }
}
🛠 Features
✅ Simple API for logging

✅ Supports multiple log levels (d, i, w, e)

✅ Lightweight and dependency-free

✅ Works with Kotlin & Java

📄 License
This project is licensed under the MIT License.
