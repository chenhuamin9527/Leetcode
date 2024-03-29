/*
 * @lc app=leetcode.cn id=1657 lang=java
 *
 * [1657] 确定两个字符串是否接近
 *
 * https://leetcode.cn/problems/determine-if-two-strings-are-close/description/
 *
 * algorithms
 * Medium (47.22%)
 * Likes:    43
 * Dislikes: 0
 * Total Accepted:    9.9K
 * Total Submissions: 21K
 * Testcase Example:  '"abc"\n"bca"'
 *
 * 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
 * 
 * 
 * 操作 1：交换任意两个 现有 字符。
 * 
 * 
 * 例如，abcde -> aecdb
 * 
 * 
 * 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
 * 
 * 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
 * 
 * 
 * 
 * 
 * 你可以根据需要对任意一个字符串多次使用这两种操作。
 * 
 * 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：word1 = "abc", word2 = "bca"
 * 输出：true
 * 解释：2 次操作从 word1 获得 word2 。
 * 执行操作 1："abc" -> "acb"
 * 执行操作 1："acb" -> "bca"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：word1 = "a", word2 = "aa"
 * 输出：false
 * 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
 * 
 * 示例 3：
 * 
 * 
 * 输入：word1 = "cabbba", word2 = "abbccc"
 * 输出：true
 * 解释：3 次操作从 word1 获得 word2 。
 * 执行操作 1："cabbba" -> "caabbb"
 * 执行操作 2："caabbb" -> "baaccc"
 * 执行操作 2："baaccc" -> "abbccc"
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：word1 = "cabbba", word2 = "aabbss"
 * 输出：false
 * 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * word1 和 word2 仅包含小写英文字母
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// ""a"\n"aa""
class Solution {
    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char ch : word1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        for (char ch : word2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            set1.add(entry.getKey());
            list1.add(entry.getValue());
        }
        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            set2.add(entry.getKey());
            list2.add(entry.getValue());
        }
        list1.sort((a, b) -> a - b);
        list2.sort((a, b) -> a - b);

        return list1.equals(list2) && set1.equals(set2);
    }
}
// @lc code=end
