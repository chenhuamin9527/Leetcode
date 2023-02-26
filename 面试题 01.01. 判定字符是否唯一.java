class Solution {
    boolean isUnique(String str) {
        int len = str.length();
        if (len > 26) { // 字符串超过26必为false
            return false;
        }
        int num = 0;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            int index = c - 'a'; // 取得c的索引，a 对应 0，b 对应 1，z 对应 25
            if ((num & (1 << index)) != 0) { // 不等于 0，表示某个字母已出现过
            // 注意：不能写成 (num & (1 << index)) == 1，因为存在 0000 00010 & 0000 0010 == 2等情况
                return false;
            } else { // 若为0，将 1 << index 对应的字符加入num中，即原来num = 2
            // 表示num中包含字母 b，此时 index = 0， 1 << index 表示字母 a
            // num |= (1 << index) 为 3（... 0000 0011），表示将 a 也加入num中，
            // 此时num中包含 a 和 b ，若再遇到 index = 0 的情况，num & (1 << index) == 1 不等于 0，
            // 表示 a 已存在，返回false
                num |= (1 << index);
            }
        }
        return true;
    }
}
