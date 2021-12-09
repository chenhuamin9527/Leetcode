class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int i = 0, j = nums.size() - 1;
        vector<int> ans;
        while(i < j)
        {
            int sum = nums[i] + nums[j];
            if(sum == target)
            {
                ans.push_back(nums[i]);
                ans.push_back(nums[j]);
                return ans;
            }
            if(sum > target)
            {
                j--;
            }
            if(sum < target)
            {
                i++;
            }
        }
        return ans;
    }
};