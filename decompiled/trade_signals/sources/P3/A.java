package P3;

/* JADX INFO: loaded from: classes.dex */
public final class A implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f6366a;

    public A(z zVar) {
        this.f6366a = zVar;
    }

    public static A a(z zVar) {
        return new A(zVar);
    }

    public static F4.X c(z zVar) {
        return (F4.X) E3.d.e(zVar.b());
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public F4.X get() {
        return c(this.f6366a);
    }
}
