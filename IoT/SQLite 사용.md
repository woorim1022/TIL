# SQLite

#### 사용방법

* SQLiteOpenHelper를 상속받은 클래스를 만들어야 한다.

* SQLiteOpenHelper를 통해 SQLiteDatabase객체를 생성한다.

* select, insert, update, delete 명령문을 SQLiteDatabase의 명령어를 통해서 실행

  * sql문으로 실행

  * 클래스의 제공되는 기능으로 사용

    * 안드로이드에서 SQLite에 직접 sql문을 작성해서 실행하는 방법외에 클래스 이용해서 접근할 수 있도록 지원 

    * 쿼리를 작성하지 않고 클래스의 기능을 이용해서 작업

      * ContentValues클래스

        * 값을 관리하는 객체 

        * 컬럼에 저장할 값을 관리하도록 설정

        * 외부에서 프로그램 실행중에 전달되는 값을 ContentValues에 저장해서 각 insert, delete, select, update에 관련된 메소드의 매개변수로 전달

          1) 데이터를 저장

      ```kotlin
      put("name",값)
      	  -----
      		컬럼명
      
      SQLiteDatabase의 insert(테이블명, null, ContentValues객체)
      -----------------
      	insert메소드 내부에서 ContentValues 객체에 저장된 값을 sql에 전달할 값으로 인지하고 내부에서 sql문을 만들어서 실행
      ```

    ​			

  

  

1. SQLiteOpenHelper

   * 데이터베이스 파일생성, 테이블생성

   * 데이터베이스 이름설정
   * 버전관리

   1) onCreate

   	* 앱이 설치되고 SQLiteOpenHelper가 최초로 호출될 때 한번만 실행
   	* 최신버전의 테이블 생성하는 코드
   	* onCreate를 호출하면 앱의 내부저장소에 db파일이 생성된다.
   	* 앱을 삭제하면 db파일도 같이 삭제되므로 삭제하고 실행하면 onCreate가 호출된다.

2. SQLiteDatabase

   * 로컬디비연동을 위한 핵심클래스
   * DB처리를 위한 기능이 모두 있다.