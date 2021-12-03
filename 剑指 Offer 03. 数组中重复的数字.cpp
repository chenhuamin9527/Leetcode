class Solution {
public:
    int findRepeatNumber(vector<int>& nums) {
        int n = nums.size();
        unordered_map<int, int> m1;
        for (int i = 0; i < n; i++)
        {
            m1[nums[i]]++;
            if(m1[nums[i]]>=2)
            {
                return nums[i];
            }
        }
        return NULL;
    }
};