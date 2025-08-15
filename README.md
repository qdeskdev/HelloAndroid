# 📜 HelloAndroid Logger Library

[![JitPack](https://jitpack.io/v/qdeskdev/HelloAndroid.svg)](https://jitpack.io/#qdeskdev/HelloAndroid)
![License](https://img.shields.io/badge/license-MIT-blue.svg)
![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg)

A comprehensive Android utility library featuring enhanced logging, beautiful toast notifications, and developer-friendly tools. Built for modern Android development with both Kotlin and Java support.

---

## ✨ Features 

- 📝 **Advanced Logger**: Clean logging API with multiple levels
- 🍞 **Enhanced Toaster**: Beautiful, customizable toast notifications with icons
- 🎨 **Styled Notifications**: Success, error, warning, and info toast variants
- 🏃‍♂️ **Lightweight**: Minimal dependencies, optimized performance
- 📱 **Android Optimized**: Built specifically for Android development
- 🌐 **Cross-Language**: Works seamlessly with Kotlin & Java
- 🔧 **Easy Integration**: Simple API, quick setup
- 🎯 **Production Ready**: Battle-tested and reliable

---

## 🚀 Installation

### Step 1: Add JitPack Repository

Add the JitPack repository to your **root** `build.gradle` (Project level):

```gradle
allprojects {
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

Or if you're using **Gradle 7.0+** with `settings.gradle`:

```gradle
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
```

### Step 2: Add Dependency

Add the dependency to your **module-level** `build.gradle` (app level):

```gradle
dependencies {
    implementation 'com.github.qdeskdev:HelloAndroid:1.0.0'
}
```

---

## 📦 Usage

### 🍞 Toaster - Enhanced Toast Notifications

The Toaster component provides beautiful, styled toast messages with icons and colors:

```java 
import com.qdesk.toasty.Toaster;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Simple toast message
        Toaster.show(this, "Hello from Toaster library!");
        
        // Success toast (green background with checkmark)
        Toaster.success(this, "Operation successful!");
        
        // Error toast (red background with error icon)
        Toaster.error(this, "Something went wrong");
        
        // Warning toast (orange background with warning icon)  
        Toaster.warning(this, "Please check your input");
        
        // Info toast (blue background with info icon)
        Toaster.info(this, "New update available");
    }
}
```

### Kotlin Usage

```kotlin
import com.qdesk.toasty.Toaster

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Simple toast
        Toaster.show(this, "Welcome to the app!")
        
        // Styled toasts
        Toaster.success(this, "Data saved successfully!")
        Toaster.error(this, "Network connection failed")
        Toaster.warning(this, "Battery level is low")
        Toaster.info(this, "Check out our new features")
    }
}
```

### 📝 Logger - Enhanced Logging

```java
import com.qdesk.helloandroid.Logger;

public class NetworkManager {
    public void fetchUserData(String userId) {
        Logger.d("Fetching data for user: " + userId);
        
        try {
            // Network operation
            UserData data = apiClient.getUser(userId);
            Logger.i("User data loaded successfully");
            
            // Show success toast
            Toaster.success(context, "Profile updated!");
            
        } catch (NetworkException e) {
            Logger.e("Network error occurred", e);
            Toaster.error(context, "Failed to load profile");
            
        } catch (Exception e) {
            Logger.e("Unexpected error: " + e.getMessage(), e);
            Toaster.error(context, "Something went wrong");
        }
    }
}
```

### 🎯 Real-World Example

Here's a complete example showing how to use both Logger and Toaster together:

```java
public class ImageLoader {
    private static final String TAG = "ImageLoader";
    
    public void loadProfileImage(ImageView imageView, String imageUrl) {
        Logger.d("Loading profile image from: " + imageUrl);
        
        Picasso.get()
            .load(imageUrl)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error_placeholder)
            .into(imageView, new Callback() {
                @Override
                public void onSuccess() {
                    Logger.i("Profile image loaded successfully");
                    Toaster.success(context, "Profile picture updated!");
                }
                
                @Override
                public void onError(Exception e) {
                    Logger.e("Failed to load profile image", e);
                    Toaster.error(context, "Failed to load image");
                }
            });
    }
}
```

---

## 🎨 Toaster Styles

| Method | Style | Icon | Background |
|--------|-------|------|------------|
| `Toaster.show()` | Default | None | Gray |
| `Toaster.success()` | Success | ✅ Checkmark | Green |
| `Toaster.error()` | Error | ❌ Error | Red |
| `Toaster.warning()` | Warning | ⚠️ Warning | Orange |
| `Toaster.info()` | Info | ℹ️ Info | Blue 

---

## 🔧 API Reference

### Toaster Methods

```java
// Basic toast
Toaster.show(Context context, String message)

// Styled toasts
Toaster.success(Context context, String message)
Toaster.error(Context context, String message)  
Toaster.warning(Context context, String message)
Toaster.info(Context context, String message)
```

### Logger Methods

```java
// Basic logging
Logger.d(String message)  // Debug
Logger.i(String message)  // Info
Logger.w(String message)  // Warning
Logger.e(String message)  // Error

// Logging with exceptions
Logger.e(String message, Throwable throwable)
Logger.w(String message, Throwable throwable)
```

---

## 🎯 Best Practices

### ✅ Recommended Usage

```java
public class UserAuthManager {
    
    public void loginUser(String email, String password) {
        Logger.d("Starting user authentication");
        
        if (email.isEmpty()) {
            Logger.w("Login attempted with empty email");
            Toaster.warning(context, "Please enter your email");
            return;
        }
        
        try {
            AuthResult result = authService.login(email, password);
            Logger.i("User authenticated successfully");
            Toaster.success(context, "Welcome back!");
            
        } catch (InvalidCredentialsException e) {
            Logger.w("Login failed: Invalid credentials");
            Toaster.error(context, "Invalid email or password");
            
        } catch (NetworkException e) {
            Logger.e("Login failed due to network error", e);
            Toaster.error(context, "Connection problem. Try again.");
        }
    }
}
```

### 🔒 Security Considerations 

- Never log sensitive data (passwords, tokens, personal info)
- Use appropriate log levels for different environments
- Consider toast message content for user privacy

---

## 🏗️ Integration with Popular Libraries

HelloAndroid works seamlessly with popular Android libraries:

```java
// With Retrofit
@Override
public void onResponse(Call<User> call, Response<User> response) {
    if (response.isSuccessful()) {
        Logger.i("API call successful");
        Toaster.success(this, "Data refreshed!");
    } else {
        Logger.w("API call failed with code: " + response.code());
        Toaster.error(this, "Failed to refresh data");
    }
}

// With Room Database
@Override
public void onSuccess() {
    Logger.i("Data saved to local database");
    Toaster.success(this, "Changes saved!");
}
```

---

## 🔧 Requirements

- **Minimum SDK**: API 21 (Android 5.0)
- **Target SDK**: Latest Android version
- **Languages**:Java,Kotlin
- **Dependencies**: Minimal Android framework dependencies

---

## 📱 Compatibility

| Android Version | API Level | Status |
|----------------|-----------|---------|
| Android 5.0+ | API 21+ | ✅ Fully Supported |
| Android 6.0+ | API 23+ | ✅ Recommended |
| Android 7.0+ | API 24+ | ✅ Optimal Performance |

---

## 🤝 Contributing

We welcome contributions! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🆘 Support

- 📚 [Documentation](https://github.com/qdeskdev/HelloAndroid/wiki)
- 🐛 [Issue Tracker](https://github.com/qdeskdev/HelloAndroid/issues)
- 💬 [Discussions](https://github.com/qdeskdev/HelloAndroid/discussions)

---

<div align="center">
  <p>Made with ❤️ by <a href="https://github.com/qdeskdev">QDeskDev</a></p>
  <p>⭐ Star this repository if it helped you!</p>
      <p>Happy Coding! 🚀</p>
</div>
