class Solution {
    public int maxProduct(int n) {
        int maxProduct = 1;
        List<Integer> list = new ArrayList<>();
        while(n > 0) {
            int rem = n % 10;
            list.add(rem);
            n = n / 10;
        }
        Collections.sort(list);
        maxProduct = maxProduct * (list.get(list.size()-1) * list.get(list.size()-2));
        return maxProduct;
    }
}