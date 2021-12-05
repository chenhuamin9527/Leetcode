// 滚动数组版本
class Solution {
public:
    int translateNum(int num) {
        string src = to_string(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < src.size(); ++i) {
            p = q; 
            q = r; 
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }
            auto pre = src.substr(i - 1, 2);
            if (pre <= "25" && pre >= "10") {
                r += p;
            }
        }
        return r;
    }
};

// class Solution {
// public:
//     int translateNum(int num) {
//         string num_str = to_string(num);
//         int n = num_str.size();
//         vector<int> dp(50,0);
//         dp[0] = 1;
//         dp[1] = 1;
//         for(int i = 1; i < n;i++)
//         {
//             dp[i] += dp[i-1];
//             auto str = num_str.substr(i-1,2);
//             if(str <= "25" && str >= "10")
//             {
//                 if(i-2 >= 0) dp[i] += dp[i-2];
//                 else dp[i] += 1;
//             }
//         }
//         return dp[n];
//     }
// };

