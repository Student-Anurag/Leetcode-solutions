class Solution {
    public int countEven(int num) {
        int sod = 0;
        int tmp = num;
        while(tmp > 0) {
            sod += (tmp % 10);
            tmp = tmp / 10;
        }
        if(sod % 2 == 1) {
            return (num - 1) / 2;
        }
        else return num / 2;
    }
}