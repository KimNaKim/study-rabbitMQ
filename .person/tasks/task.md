# 🐰 RabbitMQ 학습 체크리스트 (Learning Checklist)

이 파일은 학습 진도를 관리하기 위한 문서입니다. 완료된 항목은 `[x]`로 표시해 주세요!

---

## 🏗️ 1단계: 환경 구축 (Environment Setup)
- [x] **Erlang 설치**: RabbitMQ 구동을 위한 필수 런타임 설치
- [x] **RabbitMQ 설치**: Windows용 서비스 설치 완료
- [x] **관리 플러그인 활성화**: `rabbitmq-plugins enable rabbitmq_management` 실행
- [x] **접속 확인**: `http://localhost:15672` (guest/guest) 로그인 성공

---

## ⚙️ 2단계: 프로젝트 설정 (Project Configuration)
- [x] **의존성 추가**: `build.gradle`에 `spring-boot-starter-amqp` 반영
- [x] **애플리케이션 설정**: `application.properties`에 RabbitMQ 연결 정보 기입
- [x] **RabbitMQ Config**: 큐(Queue)와 교환기(Exchange) 설정을 위한 Java Config 작성

---

## 📬 3단계: 기본형 실습 (Simple Queue - 1:1)
- [ ] **도메인 설계**: `Post` (id, title, content) Entity 및 Repository 생성
- [ ] **메시지 발행 (Producer)**: 게시글 저장 시 큐에 메시지 전송 로직 구현
- [ ] **메시지 수신 (Consumer)**: `@RabbitListener`를 이용한 비동기 로그 출력
- [ ] **동작 테스트**: 게시글 작성 후 콘솔에 로그가 비동기로 찍히는지 확인

---

## 📢 4단계: 배포형 실습 (Fanout - 1:N)
- [ ] **Fanout Exchange 설정**: 하나의 메시지를 여러 큐로 뿌려주는 설정 추가
- [ ] **다중 리스너 구현**: 
  - [ ] 로그 저장 리스너 (Log Service)
  - [ ] 알림 발송 리스너 (Notification Service)
- [ ] **동작 테스트**: 게시글 하나 작성 시 두 서비스가 동시에 반응하는지 확인

---

## 🎯 5단계: 분류형 실습 (Topic/Direct - 선택적 전달)
- [ ] **Routing Key 설계**: 메시지 성격에 따른 라우팅 키 정의 (예: `post.created`, `post.deleted`)
- [ ] **조건별 수신**: 특정 키가 포함된 메시지만 골라서 처리하는 리스너 구현
- [ ] **동작 테스트**: 원하는 리스너만 메시지를 받는지 최종 검증

---

## 📝 학습 메모 (Notes)
- (여기에 학습하며 깨달은 점이나 메모를 자유롭게 적어보세요!)
- 
