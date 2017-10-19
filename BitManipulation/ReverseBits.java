package bit;

public class ReverseBits {

	public static void main(String[] args) {
//		int res = reverseBits(Integer.parseUnsignedInt("4294967295"));
		int res = new ReverseBits().reverseBits2(4);
		System.out.println(Integer.toBinaryString(res));
	}
	
	public static int reverseBits(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
//			This is wrong when n = -1
//			if (n % 2 == 1) {
//				res += 1;
//			}
			res += n & 1;	//This is the right way
			n >>>= 1;
			if (i == 31) break;
			res <<= 1;
		}
		
		return res;
	}
	
    public int reverseBits2(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n >> i & 1;
            res = (res << 1) + bit;
        }
        return res;
    }
}
