package P3;

import N3.n1;

/* JADX INFO: renamed from: P3.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0773i implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0768d f6409a;

    public C0773i(C0768d c0768d) {
        this.f6409a = c0768d;
    }

    public static C0773i a(C0768d c0768d) {
        return new C0773i(c0768d);
    }

    public static n1 c(C0768d c0768d) {
        return (n1) E3.d.e(c0768d.e());
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public n1 get() {
        return c(this.f6409a);
    }
}
