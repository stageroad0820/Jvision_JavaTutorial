package jvision.exam.std1_2g_final2;

/*
 * [문제]
 * 다음 프로그램을 작성하시오.
 * 
 * [배점]
 * 총 25점, 각 문항당 5점
 * 
 * [다음]
 * 1) Car 라는 클래스를 정의하고 멤버 변수로 model(차종) 과 price(금액)을 지정하시오.
 * 2) 멤버 변수를 매개 변수로 초기화하는 생성자를 작성하시오.
 * 3) 각 멤버 변수에 대하여 설정자와 조회자를 생성하시오.
 * 4) Car 클래스로 객체를 생성할 때 마다 생성된 객체의 개수를 세고자 한다. Car 클래스 안에 적당한 멤버 변수를 추가로 선언하시오.
 * 5) Car 클래스를 이용하여 객체를 생성하고, 몇 번째로 생성된 객체인지 출력하시오. 변수와 출력 형식은 임의대로 하시오.
 * 
 * [제출 파일 정보]
 * - 파일 형식: ZIP, *.zip
 * - 파일 이름: 1_{자신의 학번}_{자신의 이름}
 * 
 * [답변 작성 시간]
 * ~5분
 */
public class Question_01 {
	// 1)
	private String model = "";
	private int price = 0;
	private int count = 0;
	
	// 2)
	public Question_01(String model, int price) {
		this.model = model;
		this.price = price;
		count++;
	}

	// 3)
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	// 4)
	public int getCount() {
		return this.count;
	}
	
	// 5)
	public static void main(String[] args) {
		Question_01 cls = new Question_01("자동차", 10000);
		System.out.println("해당 인스턴스는 " + cls.getCount() + " 번째로 실행된 객체입니다.");
	}
}
