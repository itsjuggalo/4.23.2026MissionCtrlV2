package q5;

/* JADX INFO: renamed from: q5.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2566e implements AutoCloseable {
    public C2566e(String str) {
        h(str);
    }

    public static String A(String str) {
        if (str.length() < 124) {
            return str;
        }
        return str.substring(0, 124) + "...";
    }

    public static void G() {
        H0.a.f();
    }

    public static void H(String str, int i7) {
        H0.a.d(A(str), i7);
    }

    public static C2566e K(String str) {
        return new C2566e(str);
    }

    public static void h(String str) {
        H0.a.c(A(str));
    }

    public static void i(String str, int i7) {
        H0.a.a(A(str), i7);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        G();
    }
}
