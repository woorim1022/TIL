
#include <AFMotor.h>
AF_DCMotor motor(1);

void setup() {
 Serial.begin(9600);    
 Serial.println("Motor party!");
 motor.setSpeed(200);
 motor.run(RELEASE);
}

int i;
void loop() {
  motor.run(FORWARD);
  for (i=0; i<255; i++) {
    motor.setSpeed(i);  
    delay(3);
  }
  
  for (i=255; i!=0; i--) {
    motor.setSpeed(i);  
    delay(3);
  }
  motor.run(BACKWARD);
  for (i=0; i<255; i++) {
    motor.setSpeed(i);  
    delay(3);
  }
  delay(1000);
  for (i=255; i!=0; i--) {
    motor.setSpeed(i);  
    delay(3);
  }
  delay(1000);
} 
