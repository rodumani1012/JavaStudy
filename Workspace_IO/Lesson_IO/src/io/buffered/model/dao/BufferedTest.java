package io.buffered.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedTest {
	public BufferedTest() {}
	
	// BufferedWriter 보조스트림 
	// FileWriter 기반스트림
	// 외부자원 sample2.txt
	
	public void output() {
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("sample2.txt"));){
			// 엔터 칠때 :  1) \n 
			//				2) newLine();
			bw.write("안녕하세요 여러분");
			bw.write(" 홍길동입니다.\n");
			bw.write("언제나 항상 여러분들을 응원합니다.");
			bw.newLine(); // BufferedWriter에만 있는 메소드.
			bw.write("화이팅!!!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void input() {
		try (BufferedReader br = new BufferedReader(new FileReader("sample2.txt"));){
			// readLine()
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());// String 타입이므로 -1 대신 null이 리턴된다
			System.out.println(br.readLine());// String 타입이므로 -1 대신 null이 리턴된다
			System.out.println(br.readLine());// String 타입이므로 -1 대신 null이 리턴된다
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	// null이 안나오게 출력하기
	public void input2() {
		try (BufferedReader br = new BufferedReader(new FileReader("sample2.txt"));){
			// readLine()
			String temp;
			while((temp = br.readLine()) != null) {
				System.out.println(temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	// 기존파일에 이어쓰기
	public void output2() {							// true면 이어쓰기, false면 덮어쓰기
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("sample2.txt", true));){
			bw.write("추가내용 ㅋㅋ");
			bw.newLine();
			bw.write("한줄 더 ㅎㅎ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
