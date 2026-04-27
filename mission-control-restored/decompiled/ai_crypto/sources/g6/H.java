package g6;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f14274a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f14274a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
