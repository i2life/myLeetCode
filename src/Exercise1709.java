import java.util.*;

public class Exercise1709 {
    private Map<Integer, Integer> count = new HashMap<>();

    public int getKthMagicNumber(int k) {

        switch (k) {
            case 1:
                count.put(1, 1);
                return 1;
            case 2:
                count.put(2, 3);
                return 3;
            case 3:
                count.put(3, 5);
                return 5;
            case 4:
                count.put(4, 7);
                return 7;
            case 5:
                count.put(5, 9);
                return 9;
            default:
                if (count.get(k) != null) {
                    return count.get(k);
                }
                int a = getKthMagicNumber(k - 3) * 3;
                int b = getKthMagicNumber(k - 4) * 5;
                int c = getKthMagicNumber(k - 5) * 7;
                List<Integer> datas = new ArrayList<>();
                datas.add(a);
                datas.add(b);
                datas.add(c);
                datas.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                });
                for (int x : datas) {
                    if (x > getKthMagicNumber(k - 1)) {
                        count.put(k, x);
                        return x;
                    }
                }
                return 0;
        }
    }
}
