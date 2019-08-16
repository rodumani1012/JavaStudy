package io.conversion.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ByteToCharTest {

	// 매개변수로 외부자원을 선택한다면 기반 스트림.
	// 매개변수로 다른스트림을 선택한다면 보조 스트림.
	// -> 보조는 기반이 없으면 단독사용 할 수 없다.
	
	public ByteToCharTest() {}
	
	public void input() {
		// 키보드로 입력 방식 2가지 => Scanner, BufferedReader
		
		// 1. Scanner -> sc.nextInt(), sc.nextDouble(), ... 등
		// 자료형에 맞춰서 다른 메소드를 실행해야 한다.
		Scanner sc = new Scanner(System.in);
		
		// 2. BufferedReader -> br.readLine()
		// 어떠한 값이든 하나로 입력한다. (String 으로)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		// 기반스트림인 System.in을 보조스트림으로 변환. new 보조(new 보조(new 기반)) 
		// System.in은 바이트 기반의 표준 입력 스트림이다.
								
		
		System.out.println("값을 입력하세요: ");
		try {
			String value = br.readLine();
			
			System.out.println("value : " + value);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		BufferedReader br2 = null;
		BufferedInputStream br3 = null;
		try {
			br2 = new BufferedReader(new InputStreamReader(new FileInputStream("sample.txt")));
//		    br2 = new BufferedReader(new FileReader("sample.txt"));
			br3 = new BufferedInputStream(new FileInputStream("sample.txt"));
			String value = br2.readLine();
			int value2 = br3.read();
			System.out.println("value : " + value);
			System.out.println("valye : " + value2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void output() {
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 75번 라인을 풀어쓴 것
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			bw.write("hello everyone");
			bw.flush(); // flush() : 버퍼에 담긴 hello everyone을 빼오는 역할.
						// finally 부분에 close 대신 써줘도 같은 역할
		} catch (IOException e) {
			e.printStackTrace();
		} 
//		finally {  //flush() 가 역할을 대신해줌
//			try {
//				bw.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
	
	// try with resources 문은 close도 자동으로 해준다.
	public void trywithresources() {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
			bw.write("hello everyone");
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
