package exception.ex;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("영문을 쓰세요(대문자 입력시 오류 발생): ");
		String input = sc.next();

		// 1. input을 살펴본 다음에 대분자가 포함되어 있다면 오류를 발생시키자
		try {
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
					throw new CustomException("오류 발생했어욬"); // CustomException한테 예외 처리 시켜주자
				}
			}
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		}
	}
}
