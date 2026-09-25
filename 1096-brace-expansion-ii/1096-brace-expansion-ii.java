class Solution {

    public List<String> braceExpansionII(String expression) {

        Set<String> ans = solve(expression, 0, expression.length());

        List<String> come = new ArrayList<>(ans);

        Collections.sort(come);

        return come;
    }

    public Set<String> solve(String s, int start, int end) {

        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();

        current.add("");

        int i = start;

        while (i < end) {

            char ch = s.charAt(i);

            if (ch == ',') {

                result.addAll(current);

                current = new HashSet<>();
                current.add("");

                i++;
            }

            else if (ch == '{') {

                int balance = 1;
                int j = i + 1;

                while (j < end && balance > 0) {

                    if (s.charAt(j) == '{') {
                        balance++;
                    }

                    if (s.charAt(j) == '}') {
                        balance--;
                    }

                    j++;
                }

                Set<String> inside = solve(s, i + 1, j - 1);

                current = concat(current, inside);

                i = j;
            }

            else {

                Set<String> temp = new HashSet<>();

                for (String str : current) {
                    temp.add(str + ch);
                }

                current = temp;

                i++;
            }
        }

        result.addAll(current);

        return result;
    }

    public Set<String> concat(Set<String> a, Set<String> b) {

        Set<String> result = new HashSet<>();

        for (String str1 : a) {
            for (String str2 : b) {
                result.add(str1 + str2);
            }
        }

        return result;
    }
}