class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return true;

            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                // can't tell which side is sorted - shrink both ends safely
                l++;
                r--;
            } else if (nums[l] <= nums[mid]) {
                // left half [l..mid] is properly sorted
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // right half [mid..r] is properly sorted
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}