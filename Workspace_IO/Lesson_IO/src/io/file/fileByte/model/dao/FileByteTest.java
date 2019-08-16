package io.file.fileByte.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileByteTest {

	public FileByteTest() {
	
	}
	
	// 바이트 기반스트림으로 바이트 단위 데이터를 전송
	// 종류 : FileInput/OutputStream, ByteArray, Piped, Audio
	
	// 저장
	public void fileSave() {
//		File file = new File("test.txt");
//		try {
//			FileOutputStream fout = new FileOutputStream(file);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream("sample.txt");
			
			//FileOutputStream이 제공해주는 메서드 사용
			//write(); 3가지

			try {
				//write(int)
				fout.write(65); // A
				
				//write(byte[])
				byte[] barr = new byte[] {97, 98};
				fout.write(barr); // ab
				
				//write(byte[], int, int)
				fout.write(barr, 0, 1); // 인덱스 0번부터 1개  // a
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("sample.txt");
			
//			System.out.println(fis.read());
//			System.out.println(fis.read());
//			System.out.println(fis.read());
//			System.out.println(fis.read());
//			System.out.println(fis.read());
			
			// 반복문으로 출력
//			while(fis.read() != -1) { // 첫번째 A 읽고 세번째 b 읽고
//				System.out.println(fis.read()); //두번째 a 읽고 네번째 a 읽고
//			}
			int temp = 0;
			while((temp=fis.read()) != -1) {
				System.out.println(temp);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
