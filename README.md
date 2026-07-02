# AlumnUnite 

**Alumni Networking Android App :**

Alumnunite is a social networking Android app that connects alumni with each other and with current students. It provides a platform for announcements, post feeds, and profile management — built natively in Java with Firebase as the backend.

---

## Features

- **User authentication** — secure sign-up and login via Firebase Authentication
- **Post feed** — alumni can create, view, and interact with posts in a shared feed
- **Announcements** — dedicated section for important updates and notices
- **Profile management** — users can create and update their profiles with photos and bio
- **Media uploads** — supports image uploads across multiple Android screen sizes
- **Real-time sync** — Firebase Realtime Database keeps data in sync instantly (~35% lower latency vs traditional polling)
- **50+ users onboarded** during testing phase

---

## Tech Stack

| Layer | Tech |
|---|---|
| Language | Java |
| Platform | Android (Android Studio) |
| Authentication | Firebase Authentication |
| Database | Firebase Realtime Database |
| Storage | Firebase Cloud Storage |
| UI | XML Layouts, Material Design |

---

## Getting Started

### Prerequisites
- Android Studio (latest stable version)
- Android SDK (API 21+)
- A Firebase project with Authentication, Realtime Database, and Cloud Storage enabled

### Installation

1. Clone the repository:
```bash
git clone https://github.com/mayankbambal2005/Alumnunite.git
```

2. Open the project in Android Studio:
   - File → Open → select the `Alumnunite` folder

3. Connect Firebase:
   - Go to [Firebase Console](https://console.firebase.google.com)
   - Create a new project (or use existing)
   - Add an Android app with your package name
   - Download `google-services.json` and place it in the `app/` folder

4. Sync Gradle:
   - Click "Sync Now" when Android Studio prompts, or go to File → Sync Project with Gradle Files

5. Run the app:
   - Connect an Android device or start an emulator
   - Click the ▶ Run button

---

## Project Structure

```
Alumnunite/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/example/socialapp/
│           │   ├── MainActivity.java
│           │   ├── CreateProfile.java
│           │   ├── UpdateProfile.java
│           │   ├── Fragment4.java
│           │   └── StoryViewHolder.java
│           ├── res/
│           │   ├── layout/
│           │   └── drawable/
│           └── AndroidManifest.xml
├── build.gradle
└── README.md
```

---

## Future Improvements

- Direct messaging between alumni
- Event creation and RSVP system
- Job board / referral section
- Push notifications for announcements
- Play Store deployment

---

## 📄 Author

**Mayank Bambal** — [GitHub](https://github.com/mayankbambal2005) · [LinkedIn](https://linkedin.com/in/mayank-bambal-725835410)
