package exception.ex;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception3 {

	public static void main(String[] args) {
		// 배열 생성 후
		// 배열 크기 입력받기
		Scanner sc = new Scanner(System.in);

		System.out.println("배열을 만들자");
		int arr[];

		while (true) {
			System.out.println("배열 크기를 입력해주세요(양수)");
			int length = sc.nextInt();

			// 음수에 대한 예외 처리
			try {
				arr = new int[length];
				break;
			} catch (NegativeArraySizeException e) {
				System.out.println("양수만 입력해주세요.");
			} catch (InputMismatchException e) {
				System.out.println("문자 ㄴㄴ");
			}
		}
		System.out.println("프로그램 종료!");

		while (true) {
			System.out.println("배열 크기를 입력해주세요(양수)");
			int length = sc.nextInt();

			// 음수에 대한 예외 처리
			if(length > 0) {
				arr = new int[length];
				break;
			} else {
				System.out.println("잘못입력함 ㅋ");
			}
		}
		System.out.println("프로그램 종료!");
	}
}
