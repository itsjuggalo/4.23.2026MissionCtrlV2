package P3;

/* JADX INFO: loaded from: classes.dex */
public final class F implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E f6373a;

    public F(E e8) {
        this.f6373a = e8;
    }

    public static F a(E e8) {
        return new F(e8);
    }

    public static U4.a c(E e8) {
        return (U4.a) E3.d.e(e8.c());
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public U4.a get() {
        return c(this.f6373a);
    }
}
