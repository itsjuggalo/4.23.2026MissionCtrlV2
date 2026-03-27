package M2;

/* JADX INFO: loaded from: classes.dex */
public abstract class D {
    public static void a(boolean z7, String str) {
        if (!z7) {
            throw new IllegalArgumentException(str);
        }
    }

    public static Object b(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object c(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static void d(boolean z7, String str) {
        if (!z7) {
            throw new IllegalStateException(str);
        }
    }
}
