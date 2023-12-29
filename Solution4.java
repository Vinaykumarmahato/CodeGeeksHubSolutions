class Solution4 {
    static boolean match(String wild, String pattern) {
        int len1 = wild.length();
        int len2 = pattern.length();
        boolean flag = recursion(wild, 0, len1, pattern, 0, len2);
        return flag;
    }

    static boolean recursion(String wild, int it1, int len1, String pattern, int it2, int len2) {
        if (it1 == len1 && it2 == len2)
            return true;

        if (it1 >= len1)
            return false;

        if (wild.charAt(it1) == '*') {
            while (it1 + 1 < len1 && wild.charAt(it1 + 1) == '*')
                it1++;
        }

        if (it1 >= len1)
            return false;

        if (it2 >= len2) {
            if (it1 == len1 - 1 && wild.charAt(len1 - 1) == '*')
                return true;
            return false;
        }

        if (wild.charAt(it1) == '*' && it1 + 1 != len1 && it2 == len2)
            return false;

        if (wild.charAt(it1) == '?' || wild.charAt(it1) == pattern.charAt(it2))
            return recursion(wild, it1 + 1, len1, pattern, it2 + 1, len2);

        if (wild.charAt(it1) == '*')
            return (recursion(wild, it1, len1, pattern, it2 + 1, len2)
                    || recursion(wild, it1 + 1, len1, pattern, it2, len2));

        return false;
    }
}