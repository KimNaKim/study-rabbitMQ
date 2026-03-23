<!-- Parent: ../../../../../AI-CONTEXT.md -->

# com.example.study_rabbitmq

## 목적
애플리케이션의 메인 비즈니스 로직이 위치하는 최상위 패키지.

## 주요 파일
| 파일명 | 설명 |
|--------|------|
| StudyRabbitmqApplication.java | Spring Boot 애플리케이션의 엔트리 포인트 (실행 클래스) |

## 하위 디렉토리
(현재 도메인 디렉토리가 생성되지 않은 상태입니다. `code-rule.md`에 따라 `{domain}/` 패키지 구조를 생성할 예정입니다.)

## AI 작업 지침
- 도메인 중심 구조를 유지한다.
- 공통 기능은 `_core/` 패키지를 생성하여 관리한다.
- Entity, Controller, Service, Repository, Request, Response DTO를 명확히 분리한다.

## 의존성
- Spring Web, Data JPA, Spring Security 등
