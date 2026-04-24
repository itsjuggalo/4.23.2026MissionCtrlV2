package w2;

/* JADX INFO: renamed from: w2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2915d {
    public static void a(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }

    public static int b(int i8, String str) {
        if (i8 >= 0) {
            return i8;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i8);
    }
}
