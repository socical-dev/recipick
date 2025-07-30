# ✨ ProGuard에서 클래스나 메서드를 지우지 말라고 지정하는 룰
# -keep : 지우거나 이름 바꾸지 말고 그대로 유지하라는 뜻
# ** : 하위 모든 패키지/클래스를 의미 (와일드 카드)
# *; : 모든 필드/메서드 포함
# -keepattributes : 주석, 제네릭 타입 등 정보도 보존

# 1. Retrofit (HTTP 요청/응답을 처리하는 네트워크 통신 라이브러리)
-keep class retrofit2.** { *; }
-keep interface retrofit2.** { *; }

# 2. Gson (JSON 데이터를 객체로, 객체를 JSON으로 변환해주는 JSON 파싱 라이브러리)
-keep class com.google.gson.** { *; }
-keepattributes Signature
-keepattributes *Annotation*

# 3. Hilt (객체 생성을 자동으로 도와주는 DI, 즉 의존성 주입 라이브러리)
-keep class dagger.** { *; }
-keep class javax.inject.** { *; }
-keep class androidx.hilt.** { *; }
-keep class com.google.dagger.** { *; }

# 4. Coil (이미지 로딩 라이브러리)
-keep class coil.** { *; }

# 5. AndroidX Compose 관련 (XML 없이 UI를 그릴 수 있는 선언형 Jetpack Compose UI 프레임워크)
-keep class androidx.compose.** { *; }
-keep class androidx.activity.ComponentActivity { *; }
-keep class androidx.lifecycle.ViewModel { *; }

# 6. Hilt ViewModel (Hilt + ViewModel 연동 시)
-keep class **_HiltModules* { *; }

# ✅ 기타 중요한 어트리뷰트
-keepattributes InnerClasses
-keepattributes EnclosingMethod
-keepattributes Signature
-keepattributes Exceptions