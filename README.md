# PleaseDeusch

Android-прототип приложения с карточками слов: перевод, примеры и жесты для повторения или отметки изученного слова. Внутреннее имя Gradle-проекта — `PleaseDeutch`, namespace — `com.vladimir.pleasedeutch`; имена сохранены как в исходниках.

Сейчас `WordGiver` создаёт десять демонстрационных слов в памяти. Интеграция с внешним словарным сервером в этой версии не подключена; в AndroidManifest нет разрешения `INTERNET`.

## Требования

- Android Studio или установленный Android SDK с API 32.
- JDK 11 для Gradle/Android Gradle Plugin.
- Gradle Wrapper 7.6 и Android Gradle Plugin 7.4.1 — версии закреплены в проекте.
- Устройство или эмулятор с API 29 или новее; `compileSdk` и `targetSdk` — 32.

Исходники компилируются с уровнем Java 8. При работе через командную строку настройте путь к локальному Android SDK для Gradle; машинный путь не требуется сохранять в Git.

## Сборка и запуск

Откройте корень проекта в Android Studio, выполните Gradle Sync и запустите модуль `app` на устройстве/эмуляторе. Главная Activity указана в manifest как `.activities.MainActivity`.

Из корня проекта в PowerShell можно собрать debug APK и запустить существующие локальные unit-тесты:

```powershell
.\gradlew.bat :app:assembleDebug
.\gradlew.bat :app:testDebugUnitTest
```

APK появится в `app/build/outputs/apk/debug/`. Instrumentation-тесты находятся в `app/src/androidTest/` и требуют подключённого Android-устройства или эмулятора.

Java-код приложения находится в `app/src/main/java/`, интерфейс и анимации — в `app/src/main/res/`. Основные компоненты: `MainActivity`, `WordModelChanger`, `WordCardChanger` и представления карточек.
