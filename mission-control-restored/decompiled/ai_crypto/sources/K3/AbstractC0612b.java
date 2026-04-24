package K3;

/* JADX INFO: renamed from: K3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0612b {
    public static AssertionError a(String str, Object... objArr) {
        throw new AssertionError(c(str, objArr));
    }

    public static AssertionError b(Throwable th, String str, Object... objArr) {
        throw AbstractC0611a.b(c(str, objArr), th);
    }

    public static String c(String str, Object... objArr) {
        return "INTERNAL ASSERTION FAILED: " + String.format(str, objArr);
    }

    public static void d(boolean z7, String str, Object... objArr) {
        if (!z7) {
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
