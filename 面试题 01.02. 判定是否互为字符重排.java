class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 != len2)
            return false;
        HashMap<Character, Integer> dic = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            dic.put(s1.charAt(i) , dic.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < len2; i++) {
            dic.put(s2.charAt(i) , dic.getOrDefault(s2.charAt(i), 0) - 1);
        }
        for (int val : dic.values()) {
            if (val != 0)
                return false;
        }
        return true;
    }
}

