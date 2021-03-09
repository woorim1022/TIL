#include <DHT.h>
DHT mydht11(A1,DHT11);//DHT를 제어하기 위해 DHT11객체 생성
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  mydht11.begin();
}

void loop() {
  delay(2000);// 측정 시 2초이상 간격필요
  // DHT11온습도센서 읽기
  float h = mydht11.readHumidity();// 습도
  float t = mydht11.readTemperature();// 섭씨온도
  float ft = mydht11.readTemperature(true);// 화씨온도
  Serial.print("Humidity: ");
  Serial.print(h);
  Serial.print(" %\t");
  Serial.print("Temperature: ");
  Serial.print(t);
  Serial.print(" 'C ");
  Serial.print(ft);
  Serial.println(" 'F\t");
  Serial.println("=====================================================");
  
}
