# LogBox

LogBox is a lightweight and easy-to-use logging library for Android applications. It provides an overlay widget to display logs in real-time while debugging, allowing developers to monitor logs directly within the app's UI.

---

## Features

- **Floating Widget**: A movable widget that displays logs in real-time.
- **Customizable Log Levels**: Supports `DEBUG`, `INFO`, `WARN`, `ERROR`, etc.
- **No Additional Storage**: Logs are stored in memory to minimize storage impact.
- **Easy Integration**: Add the library and start logging with minimal setup.

---

## Installation

To integrate LogBox into your Android project, add the following dependency to your `build.gradle` file:

```gradle
implementation 'com.github.AsadbekTurgunboyev:LogBox:2.2.2'
```
## Usage

### Step 1: Initialize LogBox

Initialize the LogBox library in your `Application` class or `MainActivity`:

```kotlin
LogBox.init(this) {
    logLevel = LogLevel.DEBUG // Set the minimum log level to display
}
```