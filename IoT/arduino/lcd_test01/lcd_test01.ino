#include <LiquidCrystal.h>
LiquidCrystal lcd(12, 11, 4, 5, 6, 7);
int count = 0;

void setup() {
  // put your setup code here, to run once:
  lcd.begin(16,2);
  lcd.print("Hello");
}

void loop() {
  // put your main code here, to run repeatedly:
  lcd.setCursor(0,1);//(행,컬럼)
//  lcd.print("1234567");
//  for(int i=0;i<9;i++){
//    lcd.print(i);
//    delay(500);
//  }
  lcd.print(count++);
  delay(1000);
}
