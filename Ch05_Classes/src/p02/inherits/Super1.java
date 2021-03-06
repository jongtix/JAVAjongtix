package p02.inherits;

/**
 * 클래스 파일(클래스명.java)에는 public클래스는 하나만 존재 public이 아닌 클래스는 여러개 존재할 수 있다. 상속 - 부모와
 * 자식이 같은 변수이면 자식의 변수를 사용함(부모의 값이 가려짐) 자식에서 동일한 부모의 변수를 사용하려면 super.변수명 자식의
 * 변수에서는 this.가 생략됨. 자식클래스에서 부모의 클래스를 재정의하는 것을 override라고함. override된 매소드는
 * override된 내용으로 실행됨.
 */
public class Super1 {
	public static void main(String[] args) {
		B1 a = new B1();
		a.print();
		a.display();
		System.out.println(a.a);
		System.out.println(a.b);
		B2 b = new B2();
		b.print();
		b.display();
		System.out.println(b.a);
		System.out.println(b.b);
	}
}

class B1 {
	// 필드(속성)
	int a = 7; // B1의 a
	int b = 7;

	// 매소드
	void display() {
		System.out.println("B1의 메소드");
	}

	void print() {
		System.out.println("부모의 메소드");
	}
}

// 부모클래스인 B1클래스를 상속받아서 B2클래스를 만듦.
// 자식클래스(B2) extends 부모클래스(B1)
class B2 extends B1 {
	int a = 10; // B2의 a //자식클래스에서 필드를 재정의하면 부모필들의 값이 가려짐.

	void print() { // 메소드 재정의 - Override
		super.print(); // 부모메소드의 print()메소드를 호출
		System.out.println();
		System.out.println("자식 메소드, a = " + a); // 자식의 필드값 출력
		System.out.println("부모의 필드 a의 값 = " + super.a); // 부모의 필드값 출력
		System.out.println("b의 값 = " + b); // 부모의 필드 b의 값
	}
}