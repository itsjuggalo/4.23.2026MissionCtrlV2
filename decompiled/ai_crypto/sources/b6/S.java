package b6;

/* JADX INFO: loaded from: classes2.dex */
public abstract class S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f9022a = g6.G.f("kotlinx.coroutines.main.delay", false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final V f9023b = b();

    public static final V a() {
        return f9023b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final V b() {
        if (!f9022a) {
            return Q.f9020i;
        }
        I0 i0C = C1058a0.c();
        return (g6.v.c(i0C) || !(i0C instanceof V)) ? Q.f9020i : (V) i0C;
    }
}
