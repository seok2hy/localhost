# localhost

### Repository 

<br>
<br>
 
## 📌 추진배경
**데이터의 분산**
- 일반 사고는 행정안전부, 결빙은 도로교통공단
- 각 부처의 데이터를 통합해 한 눈에 볼 수 있는 서비스 개발
> 분산된 데이터를 스크래핑, 하나의 데이터베이스에 저장하여 서비스

<br>

## ⚙️ 개발 환경 및 운영 환경
**Frontend**
- language : HTML, CSS, JAVASCRIPT, JQUERY
- IDE : IntelliJ

**Backend**
- Framework: Spring boot (JPA)
- SDK: 11
- IDE: IntelliJ
- OS: Cent OS 7
- DB: MariaDB
- VCS: SVN
<br>
<br>

## :memo: 개발 계획 및 일정
![개발 계획](./images.png)
 <br>
 <br>
  
## ✨ 프로젝트 기능
### 교통사고 조회
- KakaoMap API를 사용 지도 위에 마커로 표시
- 목록 페이지에서 사고 목록을 표시
### 상세 조회
- 지도 위에 마커나 왼쪽 목록을 클릭
- 모달 창을 띄워 자세한 정보를 표시
### 검색 기능
- 목록 페이지 검색 상자에 검색어 입력후 검색
- 왼쪽 목록 페이지와 지도 마커로 정보 표시
### 통계 기능
- 저장한 데이터를 가공해 통계로 표시
- 유형과 연도에 따른 사상자 통계를 제공
### 구현 방법
- Chart.js를 사용하여 막대, 선, 도넛, 레이더 그래프 표시

