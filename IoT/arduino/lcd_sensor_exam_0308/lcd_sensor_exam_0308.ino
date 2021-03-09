//빛의 세기가 500 이상이면 
//lcd에 현재 측정한 온도와 습도를 쓰기
#include <DHT.h>
#include <LiquidCrystal.h>

DHT mydht11(A1,DHT11);//DHT를 제어하기 위해 DHT11객체 생성

LiquidCrystal lcd(12, 11, 4, 5, 6, 7);

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  lcd.begin(16,2);
  mydht11.begin();
}

void loop() {
  delay(2000);
  float h = mydht11.readHumidity();// 습도
  float t = mydht11.readTemperature();// 섭씨온도
  int photoresistorVal = analogRead(A0); //조도
  Serial.println(photoresistorVal);
  if(photoresistorVal >= 500){
    lcd.setCursor(0,0);//(행,컬럼)
    lcd.print("temp:");
    lcd.print(t);
    lcd.setCursor(0,1);//(행,컬럼)
    lcd.print("humidity:");
    lcd.print(h);
  }else{
    lcd.print("");  
  }
  delay(1000);
}
