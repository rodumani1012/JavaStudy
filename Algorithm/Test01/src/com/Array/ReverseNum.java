package com.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseNum {
	//자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 
	//배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
	//n은 10,000,000,000이하인 자연수입니다.
	public int[] solution(long n) {
		if(n>0 && n<10000000000L) {
			int[] answer = {};
			List<Long> list = new ArrayList<Long>();
			list.add(n);
			for (int i = 0; i < list.size(); i++) {
				
			}
		}
		
		
		System.out.println(answer);
		return answer;
	}
}