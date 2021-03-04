// the setup function runs once when you press reset or power the board
//헤더파일을 등록하거나 핀번호설정
int led[5] = {9, 10, 11, 12, 13};
void setup() {
  //데이터초기화, 한 번만 실행되는 코드
  //아두이노는 기본적으로 전기신호 들어오면 무조건 setup이 제일 먼저 호출
  // initialize digital pin LED_BUILTIN as an output.
  for(int i = 0; i < sizeof(led)/sizeof(int); i++)
    pinMode(led[i], OUTPUT);
}

// the loop function runs over and over again forever
void loop() {
 for(int i = 0; i < sizeof(led)/sizeof(int); i++){
    digitalWrite(led[i], HIGH);
    delay(1000);                       // wait for a second //1초쉰다
 }
  for(int i = 0; i < sizeof(led)/sizeof(int); i++){
    digitalWrite(led[i], LOW);
    delay(1000);                       // wait for a second//1초쉰다
  }
}
