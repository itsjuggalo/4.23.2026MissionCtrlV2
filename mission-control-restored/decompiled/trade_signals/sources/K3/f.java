package K3;

/* JADX INFO: loaded from: classes.dex */
public final class f implements G3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f4739a;

    public f(e eVar) {
        this.f4739a = eVar;
    }

    public static f a(e eVar) {
        return new f(eVar);
    }

    public static D3.q c(e eVar) {
        return (D3.q) G3.d.d(eVar.a());
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public D3.q get() {
        return c(this.f4739a);
    }
}
