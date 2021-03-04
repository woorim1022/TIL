
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(11,OUTPUT);
  pinMode(10,OUTPUT);
  pinMode(9,OUTPUT);
}

void loop() {
  int rednum = random(256);
  int bluenum = random(256); 
  int greennum = random(256);
  analogWrite(11,rednum);
  analogWrite(10,bluenum);
  analogWrite(9,greennum);
  delay(1000);
}
