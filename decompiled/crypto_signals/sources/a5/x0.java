package a5;

/* JADX INFO: loaded from: classes.dex */
public abstract class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f4163a = new ThreadLocal();

    public static V a() {
        ThreadLocal threadLocal = f4163a;
        V v2 = (V) threadLocal.get();
        if (v2 != null) {
            return v2;
        }
        C0302i c0302i = new C0302i(Thread.currentThread());
        threadLocal.set(c0302i);
        return c0302i;
    }
}
