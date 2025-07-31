class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        String current = "";

        for (int i = 0; i < s.length(); i++) {
            String ch = String.valueOf(s.charAt(i));
            if (current.contains(ch)) {
                int index = current.indexOf(ch);
                current = current.substring(index + 1);
            }
            current += ch;
            max = Math.max(max, current.length());
        }
        return max;
    }
}
