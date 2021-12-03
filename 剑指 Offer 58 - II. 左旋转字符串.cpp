// 输入: s = "abcdefg", k = 2
// 输出: "cdefgab"
// 第一次反转 s = "bacdefg"
// 第二次反转 s = "gfedcab"
// 第三次反转 s = "cdefgab"
class Solution {
public:
    string reverseLeftWords(string s, int n) {
        reverse(s.begin(), s.begin()+n);
        reverse(s.begin(),s.end());
        reverse(s.begin(),s.end()-n);
        return s;
    }
};