package week;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Week184 {

    public int numOfWays(int n) {

        List<List<Integer>> colorList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j != i) {
                    for (int k = 0; k < 3; k++) {
                        if (k != j) {
                            List<Integer> colors = new ArrayList<>();
                            colors.add(i);
                            colors.add(j);
                            colors.add(k);
                            colorList.add(colors);
                        }
                    }
                }
            }
        }

        int duplicateNum = 0;
        for (List<Integer> a : colorList) {
            for (List<Integer> b : colorList) {
                if (colorsLike(a, b)) {
                    duplicateNum++;
                }
            }
        }

        return (int)getResult(n, duplicateNum);


    }

    public long getResult(long n, long duplicateNum) {
        if (n == 1) {
            return 12;
        }
        long sum = (12 * (getResult(n - 1, duplicateNum)) - duplicateNum);
        return sum % 1000000007;
    }

    public boolean colorsLike(List<Integer> a, List<Integer> b) {
        if ((a.get(0).equals(b.get(0)) || a.get(1).equals(b.get(1)) || a.get(2).equals(b.get(2)))) {
            return true;
        }
        return false;
    }

    public String entityParser(String text) {
        Map<String, String> characters = new HashMap<>();
        characters.put("&quot;", "\"");
        characters.put("&apos;", "\'");
        characters.put("&amp;", "&");
        characters.put("&gt;", ">");
        characters.put("&lt;", "<");
        characters.put("&frasl;", "/");

        String s = text;

        for (String key : characters.keySet()) {
            s = s.replaceAll(key, characters.get(key));
        }
        return s;

    }

    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (j != i && words[j].contains(words[i]) && !result.contains(words[i])) {
                    result.add(words[i]);
                }
            }
        }
        return result;

    }

    public int[] processQueries(int[] queries, int m) {

        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> datas = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            datas.put(i, i - 1);
        }

        for (int i = 0; i < queries.length; i++) {
            int currentPosition = datas.get(queries[i]);
            result.add(datas.get(queries[i]));

            for (Map.Entry<Integer, Integer> data : datas.entrySet()) {
                if (data.getValue() < currentPosition) {
                    int index = data.getValue() + 1;
                    datas.put(data.getKey(), index);
                }
            }

            datas.put(queries[i], 0);
        }
        int[] out = new int[queries.length];
        int index = 0;
        for (Integer x : result) {
            out[index] = x;
            index++;
        }

        return out;
    }
}
