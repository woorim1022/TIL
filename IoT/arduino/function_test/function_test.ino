//함수와 배열
int mynum[5] = {10,20,30,40,50};
int mynumlength = sizeof(mynum)/sizeof(int);
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  sum(10,30);
  delay(2000);
  int result = sum2(10,30);
  int result2 = sumArray(mynum);
  Serial.println("결과:");
  Serial.println(result);
  Serial.println("배열결과:");
  Serial.println(result2);
}

int sumArray(int myarrVal[5]){
  int result = 0;
  for(int i = 0;i < mynumlength;i++){
    result = result + myarrVal[i]; 
  }
  return result;
}

void sum(int num1, int num2){
  int result = 0;
  result = num1 + num2;
  Serial.println(result);
  return;
}

int sum2(int num1, int num2){
  int result = 0;
  result = num1+num2;
  return result;  
}
