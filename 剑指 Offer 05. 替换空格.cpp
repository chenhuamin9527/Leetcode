// 第一种方法：遍历字符串，创建一个新字符串
// class Solution {
// public:
//     string replaceSpace(string s) {
//         string res = "";
//         int n = s.length();
//         for (int i = 0; i < n; i++)
//         {
//             if (s[i] != ' ') {res += s[i];}
//             else
//             {
//                 res += "%20";
//             }
            
//         }
//         return res;
//     }
// };

//第二种方法：原地修改
class Solution {
public:
    string replaceSpace(string s) {
        int count = 0, len = s.size();
        // 统计空格数量
        for (char c : s) {
            if (c == ' ') count++;
        }
        // 修改 s 长度
        s.resize(len + 2 * count);
        // 倒序遍历修改
        for(int i = len - 1, j = s.size() - 1; i < j; i--, j--) {
            if (s[i] != ' ')
                s[j] = s[i];
            else {
                s[j - 2] = '%';
                s[j - 1] = '2';
                s[j] = '0';
                j -= 2;
            }
        }
        return s;
    }
};