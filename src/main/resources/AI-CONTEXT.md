<!-- Parent: ../../AI-CONTEXT.md -->

# src/main/resources

## 목적
애플리케이션의 정적 리소스 및 구성 설정을 관리하는 디렉토리.

## 주요 파일
| 파일명 | 설명 |
|--------|------|
| application.properties | 서버 설정(포트, DB 경로, RabbitMQ 설정 등) |

## 하위 디렉토리
- `templates/` - Mustache 템플릿 파일 저장소 (Kebab-case 권장)
- `static/` - CSS, JS 등 정적 자산 저장소

## AI 작업 지침
- Mustache 파일은 반드시 하이픈(`-`)을 사용한 파일명을 사용한다.
- 디자인 시스템 관련 토큰은 `design-system.md`를 참조하여 일관성을 유지한다.

## 테스트
- 정적 리소스 변경 사항은 브라우저 새로고침(LiveReload 설정 확인)을 통해 검증.
