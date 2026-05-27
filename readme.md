# Never Another - Eksamensprojekt
### Bralgorithm - Johanne, Kai, Noah og Sylvester

---

## Projektbeskrivelse
Android app opgave til Never Another som en del af eksamensprojekt til 2. semester

---

## Arkitektur
Projektet anvender **MVVM (Model-View-ViewModel)** for at opdele ansvar:

- **Model** – Data og navigation
- **View** – UI (screens og components)
- **ViewModel** – Binder data mellem Model og View

---

## Mappestruktur

```plaintext
never-another/
├── MainActivity.kt
│
├── model/
│   ├── Screen.kt
│   ├── Question.kt / questionlist.kt
│   ├── InfoItem.kt
│   ├── TimeLine.kt
│   ├── labels.kt
│   ├── TrustPilotCardInfo.kt
│   ├── ExploreCardSectionText.kt
│   └── ExploreBraCarrouselPicture.kt
│
├── viewmodel/
│   ├── NeverAnotherViewModel
    ├── TestingViewModel
│   └── FlowViewModel
│
├── view/
│   ├── screens/
│   │   ├── home/
│   │   │    ├── elements/
│   │   │    └── homeScreen.kt
│   │   ├── explore/
│   │   │    ├── elements/
│   │   │    └── exploreScreen.kt
│   │   ├── order/
│   │   │    ├── elements/
│   │   │    ├── subscreens/
│   │   │    └── orderScreen.kt
│   │   └── profile/
│   │        ├── elements/
│   │        ├── subscreens/
│   │        └── profileScreen.kt
│   │
│   └── components/
│       ├── navigationBar.kt
│       └── navigationBarElement.kt
│
└── ui/
    └── theme/
        └── AppTheme.kt
``` 
