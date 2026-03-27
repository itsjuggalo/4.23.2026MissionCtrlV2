package y3;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f15960a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f15960a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
