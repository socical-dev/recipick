# Recipick (Android)

재료/레시피를 **빠르게 검색**하고 관리하는 개인 프로젝트입니다.  
**Jetpack Compose + Material 3** 기반으로 구현하며, 학습/포트폴리오 겸용으로 진행합니다.

<p align="left">
  <img alt="Kotlin" src="https://img.shields.io/badge/Kotlin-2.0.21-blue?logo=kotlin&logoColor=white" />
  <img alt="Compose" src="https://img.shields.io/badge/Compose-BOM_2025.07.00-000000?logo=jetpackcompose&logoColor=white" />
  <img alt="AGP" src="https://img.shields.io/badge/AGP-8.9.3-3DDC84?logo=android&logoColor=white" />
</p>

---

## ✨ 현재 상태 (증빙용)
- **2025-07-30 (KST)**: MVP 1차
  - `RecipeSearchScreen` 구현: 검색 입력 → 리스트 실시간 필터링
  - **Compose BOM 2025.07.00** 적용, **Version Catalog** 정리
  - Preview 기반 개발/주석 정리
- 스크린샷:
  
  <img width="437" height="904" alt="스크린샷 2025-07-31 오전 1 30 39" src="https://github.com/user-attachments/assets/98a83f6c-6ec1-4a22-b38a-1c116f1155d4" />


---

## 🎯 목표
- 공백기 동안의 실전 학습과 결과물을 **지속 커밋/문서화**하여 포트폴리오로 제시
- 실무형 구조로 확장(모듈화, 데이터/DI/테스트)까지 순차 반영

---

## 🧩 핵심 기능 (진행형)
- [x] 검색 창 + 리스트 필터링(MVP)
- [ ] 상세 화면(네비게이션)
- [ ] 레시피 모델/Repository(가짜 데이터 → 실제 데이터)
- [ ] 즐겨찾기/최근 검색
- [ ] 로컬 저장(Room) + 백업
- [ ] DI(Hilt 또는 Koin) 도입
- [ ] 이미지 로딩(Coil)
- [ ] 테스트(단위/스냅샷)

---

## 🛠 Tech Stack
- **Language**: Kotlin (2.0.21)
- **UI**: Jetpack Compose, Material 3
- **Async**: Kotlin Coroutines
- **Lifecycle**: androidx.lifecycle-runtime-ktx
- **Build**: Gradle(AGP 8.9.3), **Version Catalog**, **Compose BOM(2025.07.00)**
- (추가 예정) Navigation, Hilt/Koin, Room, Coil

---

## 📦 설치 & 실행

### 요구 사항
- Android Studio (JDK 17 지원 버전)
- JDK 17
- Android SDK 24+

### 빌드
```bash
./gradlew assembleDebug
