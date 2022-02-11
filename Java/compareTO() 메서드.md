 #  compareTO() 

* compareTo() 함수는 두개의 값을 비교하며 int 값으로 반환해주는 함수이다.
* 문자열의 비교, 숫자의 비교 두 방식이 존재한다.

1. 숫자형 비교

   * 기준값.compareTo(비교대상)

   * 기준 값과 비교대상이 동일한 값일 경우 0
   * 기준 값이 비교대상보다 작은 경우 -1
   * 기준 값이 비교대상보다 큰 경우 1

   ```java
   public class CompareToTest{ 
       public static void main(String[] args){ 
           Integer x = 3; 
           Integer y = 4; 
           Double z = 1.0; 				
           System.out.println( x.compareTo(y) ); // -1 
           System.out.println( x.compareTo(3) ); // 0 	
           System.out.println( x.compareTo(2) ); // 1 			
           System.out.println( z.compareTo(2.7) ); // -1 
       } 
   }
   ```

   

### compareTo() 오버라이딩

* 객체의 compareTo() 함수를 오버라이딩 하여 그 객체만의 정렬 조건을 원하는 대로 재정의 해준다.

* 같은 객체 타입 하나를 받아서 비교해준다.

* 비교 결과를  int 타입으로 리턴해 준다

* int compareTo() 메소드 리턴값

  * 음수 : 두 요소의 위치를 바꿈
  * 양수 : 두 요소의 위치를 그대로 둠

  (인터넷의 대부분의 설명은 양수(1)일 때 위치가 변경되고 음수(-1)나 0일 때 위치를 그대로 둔다고 설명이 되어있지만 사실은 반대이다. -1이 리턴될 때 위치가 바뀐다. 많은 사람들이 1일 때 위치를 바꿔준다고 생각하는 이유는 비교대상으로 들어오는 객체의 순서가 반대로 되어있기 때문이다.)

* 내림차순 정렬 코드 예시

```java
public class Combination {
	public static void main(String[] ar) {
		testComparable test1 = new testComparable(1);
		testComparable test2 = new testComparable(5);
		testComparable[] arr = new testComparable[]  { test1,test2 };
		Arrays.sort(arr);
        // 정렬 전 : 1,5
        // 정렬 후 : 5,1
	}
}

class testComparable implements Comparable<testComparable> {
	private int a;
	public testComparable(int a) {
		super();
		this.a = a;
	}
	@Override
	public int compareTo(testComparable o) {
		if this.a < o.a ? 1 : -1;
	}
}

/*
대부분 이 코드의 해석을 기준값(this.a)인 1이, 비교대상(o.a)인 5보다 작으면(this.a < o.a) 위치를 바꿔라(return 1), 그렇지 않으면 그대로 둬라(return -1)로 알고 있음 -> X
기준값인 this.a는 5, 비교대상인 o.a 즉, compareTo()의 매개변수는 1이다.
1과 5를 비교하면 기준값인 5를 비교대상인 1과 비교한다는 뜻
this.a 가 5 이고 o.a가 1이므로 기준값이 비교대상보다 크다, 따라서 -1을 리턴해준다.
음수를 리턴해 주므로 기준값과 비교대상의 위치를 바꿔준다.(1,5 -> 5,1)
*/
```

