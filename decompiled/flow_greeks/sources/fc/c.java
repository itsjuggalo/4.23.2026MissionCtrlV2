package fc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static b a() {
        return jc.c.INSTANCE;
    }

    public static b b() {
        return c(kc.a.f14805b);
    }

    public static b c(Runnable runnable) {
        kc.b.d(runnable, "run is null");
        return new e(runnable);
    }
}
