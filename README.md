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

### Step 2: Add Logs in Your Application

Use `LogBox.log()` to log messages:

```kotlin
LogBox.log(LogLevel.INFO, "MainActivity", "This is an informational log!")
LogBox.log(LogLevel.ERROR, "MainActivity", "Something went wrong!")
```

### Step 3: Display the Floating Widget

Call `LogBox.showFloatingWidget()` to display the floating widget in your app:

```kotlin
LogBox.showFloatingWidget()
```

You can also hide the widget when it’s no longer needed:

```kotlin
LogBox.hideFloatingWidget()
```

---

## Customization

### Log Levels

LogBox supports the following log levels:

- `LogLevel.DEBUG`
- `LogLevel.INFO`
- `LogLevel.WARN`
- `LogLevel.ERROR`

You can set the minimum log level during initialization:

```kotlin
LogBox.init(this) {
    logLevel = LogLevel.ERROR // Only show ERROR level logs
}
```

### Floating Widget Behavior

Customize the floating widget position and visibility as needed. By default, it appears in the top-left corner of the screen.

---

## Example Project

Check out the [example app](https://github.com/AsadbekTurgunboyev/LogBox/tree/main/example) to see LogBox in action.

---

## Contributions

Contributions, issues, and feature requests are welcome! Feel free to check the [issues page](https://github.com/AsadbekTurgunboyev/LogBox/issues).

---

## License

This project is licensed under the [MIT License](LICENSE).

---

## Author

Developed and maintained by [Asadbek Turgunboyev](https://github.com/AsadbekTurgunboyev).

---

### Special Thanks

Special thanks to everyone who helped in testing and providing feedback for LogBox. ❤️
