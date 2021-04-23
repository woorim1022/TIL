
#include <AFMotor.h>

AF_DCMotor motor(1);
float temperature;  
int reading;  
int lm35Pin = A0;

void setup() {
  Serial.begin(9600);
  analogReference(INTERNAL);
  motor.setSpeed(150);
}

void loop() {
  reading = analogRead(lm35Pin);
  temperature = reading / 9.31;
  Serial.println(temperature);
  if (temperature < 35){
    GO_FORWARD();
  }else{
    RELEASE_ALL();
  }
  delay(1000);
}

void GO_FORWARD() {
  motor.run(FORWARD);
  motor.run(FORWARD);
}
//void TURN_LEFT() {
//  motor_R.run(FORWARD);
//  motor_L.run(BACKWARD);
//}
//void TURN_RIGHT() {
//  motor_R.run(BACKWARD);
//  motor_L.run(FORWARD);
//}
//void GO_BACK() {
//  motor_R.run(BACKWARD);
//  motor_L.run(BACKWARD);
//}
void RELEASE_ALL() {
  motor.run(RELEASE);
  motor.run(RELEASE);
}
