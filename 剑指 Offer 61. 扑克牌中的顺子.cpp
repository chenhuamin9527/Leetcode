class Solution {
public:
    bool isStraight(vector<int>& nums) {
        unordered_set<int> cards;
        int maxCard = 0, minCard = 14;
        for(auto num:nums)
        {
            if(num == 0) continue;
            maxCard = max(maxCard,num);
            minCard = min(minCard,num);
            if(cards.count(num)) return false;
            cards.insert(num);
        }
        return maxCard - minCard < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
};