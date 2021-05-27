int sensor=0;
void setup() {
Serial.begin(9600);
}

void loop() {
sensor=digitalRead(A0);
Serial.println(sensor);
}
