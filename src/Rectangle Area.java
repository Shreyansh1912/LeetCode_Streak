class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long area1 = ((long) C- (long) A) * ((long) D - (long) B);
        long area2 = ((long) G- (long) E) * ((long) H - (long) F);
        
        //0 and Math.max in outer case is used for if rectangles are not overalpped i.e overlapped area is zero
        long overlapped = Math.max((long) Math.min(C, G) - (long) Math.max(A, E), 0L) * 
            Math.max((long) Math.min(D, H) - (long) Math.max(B,F), 0L);
        
        return (int) (area1 + area2 - overlapped);
    }
}
