class Solution {
public:
    string shortestCompletingWord(string licensePlate, vector<string> &words) {
        
        vector<int> cnt(26,0);
        for (char ch : licensePlate) {
            if (isalpha(ch)) {
                ++cnt[tolower(ch) - 'a'];
            }
        }
        int idx = -1;
        for (int i = 0; i < words.size(); ++i) {
            
            vector<int> c(26,0);
            for (char ch : words[i]) {
                ++c[ch - 'a'];
            }
            bool ok = true;
            for (int j = 0; j < 26; ++j) {
                if (c[j] < cnt[j]) {
                    ok = false;
                    break;
                }
            }
            if (ok && (idx < 0 || words[i].length() < words[idx].length())) {
                idx = i;
            }
        }
        return words[idx];
    }
};
