package another.group;

public class Exam {
	public static void main(String[] agrs) {
	int x = 2;
	int y = 5;
	char c = 'A'; // 'A' 65 의 문자코드는
	System.out.println(1 + x << 33);
	System.out.println(y >= 5 || x < 0 && x > 2);
	System.out.println(y += 10 - x++);
	System.out.println(x+=2);
	System.out.println( !('A' <= c && c <='Z') );
	System.out.println('C'-c);
	System.out.println('5'-'0');
	System.out.println(c+1);
	System.out.println(++c);
	System.out.println(c++);
	System.out.println(c);
	int z = x+=y++;
	int a = y+=z-14;
	int b = z==a?c>>2:y<<3;
	System.out.println(b);
	}
}
