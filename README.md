# Toranj v0.1.0 — final-build-ready

نسخه پایه Android با معماری لایه‌ای `core / data / domain / presentation`، Room، Hilt، Navigation Compose و UDF.

## ساختار
- `core`: DI و Room database
- `data`: Entity، DAO و Repository implementation
- `domain`: مدل، Repository contract و UseCaseها
- `presentation`: Dashboard، Tasks و Navigation

## Build
1. پروژه را در Android Studio باز کنید.
2. اجازه دهید Gradle Sync کامل شود.
3. از ترمینال ریشه اجرا کنید: `./gradlew assembleDebug`
4. APK در `app/build/outputs/apk/debug/app-debug.apk` ساخته می‌شود.

## نسخه‌ها
- Android Gradle Plugin: 8.5.2
- Gradle Wrapper: 8.10.2
- Kotlin: 1.9.24
- compileSdk/targetSdk: 35
- minSdk: 26
- Room: 2.6.1
- Hilt: 2.51.1
- Compose BOM: 2024.09.03

## نکته
این محیط فاقد Android SDK و Gradle distribution محلی بود؛ بنابراین بیلد واقعی `assembleDebug` در این محیط قابل اجرا نبود. فایل‌های پروژه و پیکربندی برای اجرای Build در محیط Android Studio/SDK تنظیم شده‌اند.
