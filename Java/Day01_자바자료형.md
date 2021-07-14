# Day01 자바의 자료형

### 자바의 자료형

#### 1. 변수의 타입에 따른 구분

 * 기본형(8가지)

   : 논리(boolean) - true, false

   : 문자(char) - 한글자, '문자', "a" - X(문자가 아니라 문자열)

   char c = 'a';

   char c = 97; // 'A' - 65

   char c = '\u0061'; // \u 뒤에는 유니코드 값 

   

   : 숫자(정수 - byte, short, int, long, 실수 - float, double)

   100(int), 1.1(double)

   

   float f = 1.1; //에러발생

   float f = 1.1f; 

   float f = 1.1F; 

   

   100l, 100L //long 타입으로 강제변환

   

 * 참조형



#### 2. 변수의 선언되는 위치에 따른 분류

 * 멤버변수(전역변수), instance

   : static이 붙은 변수 : 클래스변수(클래스당 하나의 변수 공간이 생성), MethodArea(ClassArea, 공용영역에서 관리)

   : static이 붙지 않은 변수(nonstatic) : 인스턴스변수(인스턴스당 하나의 변수 공간이 생성), Heap(독립영역에서 관리) 

   : 변수의 값의 자동 초기화 진행됨 

 * 로컬변수(지역변수)

   : 블록단위 사용 범위 지정됨

   : 값의 초기화가 자동으로 발생하지 않음	

   ```java
   public class Test01_Variable {
   	//메서드 밖에 선언되는 변수(멤버변수)
   	int val1; // 1
   	String val2; // 2
   	static int sVal; // 3
   	
   	void test() {
   		System.out.println(val1);
   		System.out.println(val2);
   		System.out.println(sVal);
   	}
   	
   	public static void main(String [] args) {
   		//메서드 내에 선언되는 변수(로컬변수)
   		//static 영역에서는 instance 영역을 직접 접근할 수 없다.
   		//System.out.println(val1);		
   		//System.out.println(val2);		
   		System.out.println(sVal);
   		
   		// static 영역에서 instance 영역의 변수에 접근하는 법
   		Test01_Variable tv = new Test01_Variable();
   		System.out.println(tv.val1);
   		System.out.println(tv.val2);
   	}
   }
   
   ```

   

<img src="C:\Users\USER\Desktop\TIL\Java\md-images\캡처.PNG" alt="캡처" style="zoom:20%;" />









#### 유지보수 하기 좋은 코드 짜기

```jAVA

import java.util.Scanner;

public class Test02_Refector {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수 : ");
		int num = sc.nextInt();
		
		/*1.
		if (num % 2 == 0) {
			System.out.println("짝수");
		}else {
			System.out.println("홀수");
		}
		*/
		
		/*2.
		String msg;
		if (num % 2 == 0) {
			msg = "짝수";
		}else {
			msg = "홀수";
		}
		System.out.println(num + "은 " + msg + "입니다.");
		*/
		
		/*3.
		String msg = "홀수";
		if (num % 2 == 0) {
			msg = "짝수";
		}
		System.out.println(num + "은 " + msg + "입니다.");
		*/
		
        //4.
		System.out.println(num + "은 " + (num % 2 == 0 ? "짝수" : "홀수") + "입니다.");
		
        //5.
		System.out.printf("%d은 %s입니다.%n", num, num % 2 == 0 ? "짝수" : "홀수");
		
		System.out.print("월(1 - 12) : ");
		int month = sc.nextInt();
		String season = "";
		switch(month) {
			case 12:
			case 1:
			case 2:
				season = "겨울";
				break;
			case 3:
			case 4:
			case 5:
				season = "봄";
				break;
			case 6:
			case 7:
			case 8:
				season = "여름";
				break;
		}
		System.out.println(season + "입니다.");
	}
}

```

