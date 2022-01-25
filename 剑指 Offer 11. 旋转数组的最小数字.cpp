class Solution {
public:
    int minArray(vector<int>& numbers) {
        int min_num = numbers[0];
        for(auto num: numbers)
        {
            if(num < min_num)
            {
                min_num = num;
            }
        }
        return min_num;
    }
};