package m2;

/* JADX INFO: renamed from: m2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2354g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C2361n f21362a;

    public /* synthetic */ C2354g(AbstractC2353f abstractC2353f) {
    }

    public final InterfaceC2352e a() {
        C2361n c2361n = this.f21362a;
        if (c2361n != null) {
            return new C2347E(c2361n, null);
        }
        throw new IllegalStateException(String.valueOf(C2361n.class.getCanonicalName()).concat(" must be set"));
    }

    public final C2354g b(C2361n c2361n) {
        this.f21362a = c2361n;
        return this;
    }
}
