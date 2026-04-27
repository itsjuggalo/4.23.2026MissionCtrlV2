package P3;

/* JADX INFO: loaded from: classes.dex */
public final class P implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final N f6382a;

    public P(N n8) {
        this.f6382a = n8;
    }

    public static P a(N n8) {
        return new P(n8);
    }

    public static P4.r c(N n8) {
        return (P4.r) E3.d.e(n8.b());
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public P4.r get() {
        return c(this.f6382a);
    }
}
