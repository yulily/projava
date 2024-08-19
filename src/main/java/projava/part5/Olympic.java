package projava.part5;

public class Olympic {
    /**
     * 渡された西暦年が夏季近代オリンピック開催年であるかどうか判定する
     * @param year 西暦年
     * @return boolean 夏季オリンピック開催年であれば true
     * @throws IllegalArgumentException まだオリンピック開催が確定していない年を渡した場合
     */
    public boolean isSummerOlympicYear(int year) throws IllegalArgumentException {
        if (1896 > year) {
            return false;
        }

        if(year == 1916 || year == 1940 || year == 1944 || year == 2020) {
            return false;
        }

        if (2021 == year) {
            return true;
        }

        if (2032 < year) {
            throw new IllegalArgumentException("2032年までをサポートしてます。入力: " + year);
        }

        return year % 4 == 0;
    }
}
