class Solution {
    public int insertBits(int N, int M, int i, int j) {
        for (int k = i; k <= j; k++) {
            // 用循环将N的i到j位全部变为0
            // example: ~(1 << 2) -> ~(100) -> 011
            // N = N & 011 相当于在第二位变为0
            N &= ~(1 << k);
        }
        // 最后将 M 左移 i 位再直接相加
        return N + (M << i);
    }
}
