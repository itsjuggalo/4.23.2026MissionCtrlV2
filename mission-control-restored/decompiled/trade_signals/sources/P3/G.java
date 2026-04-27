package P3;

import N3.O0;

/* JADX INFO: loaded from: classes.dex */
public final class G implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E f6374a;

    public G(E e8) {
        this.f6374a = e8;
    }

    public static G a(E e8) {
        return new G(e8);
    }

    public static O0 c(E e8) {
        return (O0) E3.d.e(e8.d());
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public O0 get() {
        return c(this.f6374a);
    }
}
