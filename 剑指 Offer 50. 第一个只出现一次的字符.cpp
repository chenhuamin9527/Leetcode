class Solution {
public:
    char firstUniqChar(string s) {
        unordered_map<char, int> m1;
        char res = ' ';
        for(char ch:s)
        {
            m1[ch]++;
        }
        for(auto it = m1.begin(); it!=m1.end();it++)
        {
            if(it->second==1) res = it->first;
        }
        return res;
    }
};