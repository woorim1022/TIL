# Permission

#### 종류

* 일반권한 : 앱을 설치할 때 권한을 설정
* 위험권한 : 앱을 사용할 때 권한을 설정



#### 위험권한

액티비티를 실행하거나 어떤 기능을 사용할 때 권한에 대한 처리를 할 수 있도록 구현해야 한다.



1. 사용메소드

   * checkSelfPermission : 퍼미션의 현재 상태를 확인하는 메소드
     * PERMISSION_GRANTED : 퍼미션이 설정된 상태
     * PERMISSION_DENIED : 퍼미션이 설정되어 있지 않은 상태
   * requestPermissions : 리턴값이 PERMISSION_DENIED인 경우 즉, 권한이 체크되어 있지 않은 경우 권한을 요청해서 사용자가 설정할 수 있도록 제공되는 메소드가 더 있음
     * Context : 체크해야 하는 권한 리스트 - 현재 액티비티를 사용하기 위해 처리해야 하는 권한을 넘김(ArrayList나 배열로 관리) 요청코드(요청을 구분하기 위한 코드 - 임의값을 넘김)
   * onRequestPermissionsResult(requestCode : Int, permissions : Array<out String>, grantResults : IntArray)
     * requestPermissions의 결과로 호출되는 메소드
     * 퍼미션 설정 관련 정보를 매개변수로 전달
     * requestCode - 요청할 때 넘긴 코드
     * premissions - 요청할 퍼미션 목록
     * grantResults - 퍼미션 설정 성공 결과

2. 처리과정

   1. 현재 사용하려고 하는 권한이 설정되어 있는지 체크

      * checkSelfPermission을 이용

   2. 1번에서 리턴값이 PERMISSION_DENIED인 경우 사용자가 권한을 설정할 수 있도록 대화상자를 표시

      * requestPermissions

   3. 권한 요청 처리 후 자동으로 호출되는 메소드를 통해 다음에 어떤 처리르 할 것인지 정의

      => 권한 승인 성공 : 기능이 실행되도록

      => 권한 실패 : Preference를 통해 설정할 수 있도록 액티비티를 이동하거나 안내 메시지 출력