package io.file.fileByte.run;

import io.file.fileByte.model.dao.FileByteTest;

public class Run {

	public static void main(String[] args) {
		FileByteTest fb = new FileByteTest();
//		fb.fileSave();
		fb.fileRead();
	}
}