package X4;

import V4.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f9391a = new a();

    public static final class a implements c {
    }

    public static int a(int i8, int i9) {
        if (i8 < i9) {
            return -1;
        }
        return i8 > i9 ? 1 : 0;
    }

    public static int b(long j8, long j9) {
        if (j8 < j9) {
            return -1;
        }
        return j8 > j9 ? 1 : 0;
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static Object d(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static int e(int i8, String str) {
        if (i8 > 0) {
            return i8;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i8);
    }
}
