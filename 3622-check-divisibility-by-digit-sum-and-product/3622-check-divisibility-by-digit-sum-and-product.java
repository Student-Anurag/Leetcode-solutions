class Solution {
    public boolean checkDivisibility(int n) {
        int digitSum = 0;
        int digitProduct = 1;
        int temp = n;
        while(n != 0) {
            int rem = n % 10;
            digitSum += rem;
            digitProduct *= rem;
            n = n / 10;
        }
        int totalSum = digitSum + digitProduct;
        if(temp % totalSum == 0) return true;
        else return false;
    }
}