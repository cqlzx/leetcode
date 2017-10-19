package bit;

public class TestBit {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE - 1));
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
		System.out.println(Integer.toBinaryString(-Integer.MIN_VALUE));
		System.out.println();
		System.out.println(Integer.toBinaryString(2));
		System.out.println(Integer.toBinaryString(2 >> 1));
		System.out.println(Integer.toBinaryString(2 >>> 1));
		System.out.println();
		System.out.println(Integer.toBinaryString(-2));
		System.out.println(Integer.toBinaryString(-2 >> 1));	//右移最高位不变
		System.out.println(Integer.toBinaryString(-2 >>> 1));	//右移补0
		System.out.println(Integer.toBinaryString(-2 << 1));	//左移补0
		System.out.println();
		System.out.println(Integer.toBinaryString(-1));
		System.out.println(Integer.toBinaryString(-1 << 1));
		System.out.println();
		System.out.println(Integer.toBinaryString(-2147483600));
		System.out.println(Integer.toBinaryString(-2147483600 << 1));
		System.out.println(-2147483600 << 1);
//		System.out.println(Integer.MAX_VALUE << 1);
	}

}
