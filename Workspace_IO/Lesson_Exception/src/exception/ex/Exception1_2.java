package exception.ex;

public class Exception1_2 {

	public static void main(String[] args) {
		// 난수저장
		int ran = 0;

		// 결과값 저장
		double res = 0.0;

		// 0~9 난수 발생
//		try {
//			for (int i = 0; i < 10; i++) {
//				//(math.random() * ((max - min) + 1)) + min
//				ran = (int)(Math.random()*10);
//				res = 10 / ran;
//				System.out.printf("ran : %d ==> %f \n", ran, res);
//			}
//		} catch (ArithmeticException e) {
//			System.out.println("0으로 나눴어!!");
//		}

		// if 버전
		for (int i = 0; i < 10; i++) {
			ran = (int) (Math.random() * 10);
			if (ran == 0) {
				System.out.println("0으로 나눴어!!");
				ran++;
			}
			res = 10 / ran;
			System.out.printf("ran : %d == > %f \n", ran, res);
		}

	}
}
