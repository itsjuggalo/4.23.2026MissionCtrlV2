package G3;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static int a(int i8) {
        if (i8 < 3) {
            return i8 + 1;
        }
        if (i8 < 1073741824) {
            return (int) ((i8 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static LinkedHashMap b(int i8) {
        return new LinkedHashMap(a(i8));
    }
}
