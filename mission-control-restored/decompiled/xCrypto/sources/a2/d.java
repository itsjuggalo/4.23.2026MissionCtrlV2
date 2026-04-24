package a2;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static void a(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }

    public static int b(int i4, String str) {
        if (i4 >= 0) {
            return i4;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i4);
    }
}
