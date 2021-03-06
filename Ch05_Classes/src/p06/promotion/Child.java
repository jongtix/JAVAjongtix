package p06.promotion;
/**
 * 부모-자식 클래스 상속관계에서 자식 클래스에서 재정의 된 메소드는 부모 클래스에서도 자식 메소드가 사용됨.
 * - 자식 클래스에서 추가된 메소드는 부모 클래스로 promotion되면 사용 불가.
 * */
public class Child extends Parent {
	@Override
	public void method2() {
		System.out.println("child-method2()");
	}
	
	// 메소드 추가
	public void method3() {
		System.out.println("child-method3()");
	}
}
