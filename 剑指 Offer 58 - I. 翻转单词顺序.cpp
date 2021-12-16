class Solution {
public:
    string reverseWords(string s) {
        string res;
        int n = s.size();
        if(n == 0) return res;
        int right = n - 1;
        while(right >= 0){
            //从后往前寻找第一字符
            while(right >= 0 && s[right] == ' ') right--;
            if(right < 0) break;

            //从后往前寻找第一个空格
            int left = right;
            while( left >= 0 && s[left] != ' ' ) left--;

            //添加单词到结果
            res += s.substr(left + 1, right - left);
            res += ' ';

            //继续往前分割单词
            right = left;
        }
        //去除最后一个字符空格
        if (!res.empty()) res.pop_back();
        return res;
    }
};