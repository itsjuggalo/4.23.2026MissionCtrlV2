package P3;

/* JADX INFO: loaded from: classes.dex */
public final class Q implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final N f6383a;

    public Q(N n8) {
        this.f6383a = n8;
    }

    public static Q a(N n8) {
        return new Q(n8);
    }

    public static P4.r c(N n8) {
        return (P4.r) E3.d.e(n8.c());
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public P4.r get() {
        return c(this.f6383a);
    }
}
