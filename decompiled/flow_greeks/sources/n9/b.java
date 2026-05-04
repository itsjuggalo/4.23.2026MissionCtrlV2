package n9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static AssertionError a(String str, Object... objArr) {
        throw new AssertionError(c(str, objArr));
    }

    public static AssertionError b(Throwable th, String str, Object... objArr) {
        throw a.b(c(str, objArr), th);
    }

    public static String c(String str, Object... objArr) {
        return "INTERNAL ASSERTION FAILED: " + String.format(str, objArr);
    }

    public static void d(boolean z10, String str, Object... objArr) {
        if (!z10) {
            throw a(str, objArr);
        }
    }

    public static Object e(Object obj, String str, Object... objArr) {
        if (obj != null) {
            return obj;
        }
        throw a(str, objArr);
    }
}
