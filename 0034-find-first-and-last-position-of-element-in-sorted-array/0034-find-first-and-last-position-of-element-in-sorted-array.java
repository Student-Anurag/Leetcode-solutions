class Solution {
    public int findFirstPosition(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int result = -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) {
                result = mid;   // possible answer
                r = mid - 1;    // let's look into left
            }
            else if(nums[mid] > target) {
                r = mid - 1;
            }
            else l = mid + 1;
        }
        return result;
    }
    public int findLastPosition(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int result = -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) {
                result = mid;   // possible answer
                l = mid + 1;    // let's look into right
            }
            else if(nums[mid] < target) {
                l = mid + 1;
            }
            else r = mid - 1;
        }
        return result;
    }
    public int[] searchRange(int[] nums, int target) {
        int firstPosition = findFirstPosition(nums, target);
        int lastPosition = findLastPosition(nums, target);
        return new int[]{firstPosition, lastPosition};
    }
}