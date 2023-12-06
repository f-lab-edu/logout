# logout
## 호텔(숙박)예약 서비스 API
2023.06 ~

### 개요
숙박 예약 플랫폼 API 구현 프로젝트

### 프로젝트 사용기술
* Spring Boot, Java, JPA, MySQL, Mybatis, QueryDSL, Gradle, Docker
* intellij IDEA

### 주요 관심사 
* 코드 리뷰를 통해 고품질의 코드를 작성하는 경험
* 비즈니스 로직을 직접 설계하고 구현하는 경험
* 추후 확장 가능한, 성장 가능한 서비스를 만드는 경험


### 주요 비즈니스 로직

- 광고 커미션을 적용한 검색 기능
- ERD
    
    [전체 ERD](https://www.erdcloud.com/d/ko7oyGmDa37ttopsF)
    
    - 호텔
        
       ![호텔](https://github.com/f-lab-edu/logout/assets/90191707/4a58c107-c660-4a79-8fb4-a53043054427)

        
    - 광고
        
        ![광고](https://github.com/f-lab-edu/logout/assets/90191707/9b4763ff-0314-405e-96b8-0bcd186b8403)

        
    

1) 검색시 상단 노출

- 정책:
    - 상단노출 광고 상품을 구매한 호텔은 검색시에 상단에 노출, 일반 호텔(무료광고상품)은 그 후위에 노출됨
- 로직: 호텔 등록 → 기본 무료광고 라는 상품으로 등록
    
    광고 구매 → 무료광고 삭제(delete아님) → 상단노출 광고 새로 insert 
    
    매일 서비스 기간 체크하여 기간 넘을시에 expired 체크(배치작업)
    
    클라이언트 검색 request → 광고 테이블에서 expired=false 인 상단노출 호텔우위, 무료광고 호텔 후위로 조회하여 페이징
    

2) 파워링크 광고

- 정책 : 파워링크 광고 상품을 구매한 호텔은 검색시에 검색내역 위 파워링크 인벤토리에 광고상품 노출(랜덤 2개)
- 로직 : 호텔 등록 → 기본 무료광고 라는 상품으로 등록
    
    광고 구매 → 무료광고 삭제(delete아님) → 파워링크 광고 새로 insert 
    
    매일 서비스 기간 체크하여 기간 넘을시에 expired 체크(배치작업)
    
    클라이언트 검색 request → 광고 테이블에서 파워링크 구매한 호텔 넘버 체크 → 호텔 테이블에서 정보를 가져옴 limit 2
    
- 플로우차트
    
    ![image](https://github.com/f-lab-edu/logout/assets/90191707/60732c54-b26f-40d3-8682-21032752ba44)

    

3) 오너를 위한 대시보드
