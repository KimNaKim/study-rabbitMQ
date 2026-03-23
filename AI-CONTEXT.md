# study-rabbitmq (Root Context)

## 목적
Spring Boot 4.0.3 기반의 RabbitMQ 학습 프로젝트.
기본적인 웹 게시판 구현(Mustache, H2, JPA)과 RabbitMQ를 통한 메시지 큐 통신 실습을 목표로 함.

## 주요 파일
| 파일명 | 설명 |
|--------|------|
| AI-GUIDE.md | 최우선 작업 지침 및 프로젝트 기본 규칙 (한국어 기본, 기술 스택 명시) |
| build.gradle | Spring Boot 4.0.3 및 의존성 관리 (Mustache, Spring Security 등) |
| settings.gradle | 프로젝트 이름 설정 |
| gradlew / gradlew.bat | Gradle 실행 래퍼 |

## 하위 디렉토리
- `src/main/java/` - Java 소스 코드 (도메인 중심 패키지 구조)
- `src/main/resources/` - 설정 파일 및 Mustache 템플릿 (`templates/`)
- `.ai/` - AI 스킬 및 규칙 설정 파일 (`rules/`, `skills/`, `agents/`)
- `.person/` - 작업 보고서(`reports/`) 및 활동 로그(`logs/`)

## AI 작업 지침
- **한국어**를 기본 언어로 사용한다.
- HTTP 메서드는 **GET, POST**만 허용하며, 데이터 전송은 **form 태그**를 우선한다.
- 새로운 기능을 추가할 때는 `plan` 또는 `compound` 스킬을 사용하여 선 계획 후 작업을 수행한다.
- 코드 작성 시 `.ai/rules/code-rule.md`의 컨벤션을 엄격히 준수한다.

## 실행 및 테스트
- 실행: `./gradlew bootRun`
- 테스트: `./gradlew test`

## 의존성
- **내부**: `_core` 패키지 하위의 공통 유틸리티 활용 예정.
- **외부**: Spring Boot 4.0.3, Mustache, JPA, H2, Spring Security, RabbitMQ(추후 추가).
