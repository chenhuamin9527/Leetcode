class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int count = 0;
        int ans = 0;
        int n = nums.size();
        for(int i = 0;i<n;i++)
        {
            if(nums[i]!=count) 
            {
                ans = count;
            }
            else count++;
        }
        return count;
    }
};