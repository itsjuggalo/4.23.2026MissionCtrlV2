package P3;

/* JADX INFO: loaded from: classes.dex */
public final class O implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final N f6381a;

    public O(N n8) {
        this.f6381a = n8;
    }

    public static O a(N n8) {
        return new O(n8);
    }

    public static P4.r c(N n8) {
        return (P4.r) E3.d.e(n8.a());
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public P4.r get() {
        return c(this.f6381a);
    }
}
