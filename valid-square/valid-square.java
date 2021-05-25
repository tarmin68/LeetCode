class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] corners = new int[4][2];
        
        corners[0] = p1;
        corners[1] = p2;
        corners[2] = p3;
        corners[3] = p4;
        
        Arrays.sort(corners, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int[] a = new int[2];
        a[0] = corners[1][0] - corners[0][0];
        a[1] = corners[1][1] - corners[0][1];
        
        int[] b = new int[2];
        b[0] = corners[2][0] - corners[0][0];
        b[1] = corners[2][1] - corners[0][1];
        
        double aLength = Math.sqrt(Math.pow(a[0],2) + Math.pow(a[1], 2));
        double bLength = Math.sqrt(Math.pow(b[0],2) + Math.pow(b[1], 2));
        
        if(aLength == 0 || aLength != bLength)
            return false;
        
        double angle = Math.acos((a[0] * b[0] + a[1] * b[1]) / (aLength * bLength));
        if(Math.toDegrees(angle) != 90)
            return false;
        
        int[] c = new int[2];
        c[0] = corners[3][0] - corners[1][0];
        c[1] = corners[3][1] - corners[1][1];
        double cLength = Math.sqrt(Math.pow(c[0],2) + Math.pow(c[1], 2));
        if(cLength != aLength)
            return false;
        
        return true;
    }
}