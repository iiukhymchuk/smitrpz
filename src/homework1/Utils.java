package homework1;

import java.util.ArrayList;

public class Utils {
    public static String[] getLessThanAverage(String[] strings) {
        if (strings == null) {
            return null;
        }
        if (strings.length == 0) {
            return strings;
        }
        double average = getAverage(strings);
        return getLessThanAverage(strings, average);
    }

    private static double getAverage(String[] strings) {
        int allLength = 0;
        int count = 0;
        for (String str: strings) {
            allLength += str.length();
            count++;
        }
        return allLength / (double) count;
    }

    private static String[] getLessThanAverage(String[] strings, double average) {
        ArrayList<String> list = new ArrayList<String>();
        for (String str: strings) {
            if (str.length() < average) {
                list.add(str);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
