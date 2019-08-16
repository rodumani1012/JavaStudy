package io.file;

import java.io.File;

public class FileList {

	public static void main(String[] args) {
		File file = new File("c:\\");
		
		int fileCount = 0;
		int dirCount = 0;

		String[] fileList = file.list(); // String 배열을 리턴하는 .list() 메소드
		
		for(int i = 0; i < file.length(); i++) { // 에러 안나려면 file.length()를 fileList.length 로 써야됨
			System.out.println(fileList[i]);
		}
		
		// listFiles() : 디렉토리의 파일목록을 File배열로 반환한다.
		for(File f : file.listFiles()) {
			if(f.isDirectory()) {
				System.out.println(f);
				dirCount++;
			}
		}
	}
}
