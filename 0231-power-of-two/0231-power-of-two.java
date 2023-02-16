class Solution {
    public boolean isPowerOfTwo(int n) {
		return n == 1 ? true : n == 0 || n % 2 != 0 ? false : isPowerOfTwo(n / 2);
	}
}