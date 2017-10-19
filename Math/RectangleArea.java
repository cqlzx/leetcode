package math;

public class RectangleArea {
	
	//Solution 1
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int length = 0, width = 0;
        if (C <= E || G <= A) {
            length = 0;
        } else if (G <= C && E >= A || G >= C && E <= A) {
            length = Math.min(G - E, C - A);
        } else {
            length = Math.min(Math.abs(G - A), Math.abs(C - E));
        }
        
        if (B >= H || F >= D) {
            width = 0;
        } else if (H <= D && F >= B || H >= D && F <= B) {
            width = Math.min(H - F, D - B);
        } else {
            width = Math.min(Math.abs(H - B), Math.abs(D - F));
        }
        
        return (C - A) * (D - B) + (G - E) * (H - F) - length * width;
    }
    
    public int computeArea2(int A, int B, int C, int D, int E, int F, int G, int H) {
    	int left = Math.max(A, E), right = Math.max(left, Math.min(C, G));
        int bottom = Math.max(B, F), top = Math.max(bottom, Math.min(D, H));
        return (C - A) * (D - B) + (G - E) * (H - F) - (right - left) * (top - bottom);
    }
}
