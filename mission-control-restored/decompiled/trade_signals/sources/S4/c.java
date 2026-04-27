package S4;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    public static b a() {
        return W4.c.INSTANCE;
    }

    public static b b() {
        return c(X4.a.f9376b);
    }

    public static b c(Runnable runnable) {
        X4.b.d(runnable, "run is null");
        return new e(runnable);
    }
}
