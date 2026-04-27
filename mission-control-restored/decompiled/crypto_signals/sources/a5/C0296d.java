package a5;

/* JADX INFO: renamed from: a5.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0296d implements InterfaceC0304k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0294c[] f4112a;

    public C0296d(C0294c[] c0294cArr) {
        this.f4112a = c0294cArr;
    }

    @Override // a5.InterfaceC0304k
    public final void a(Throwable th) {
        b();
    }

    public final void b() {
        for (C0294c c0294c : this.f4112a) {
            M m5 = c0294c.f4110f;
            if (m5 == null) {
                kotlin.jvm.internal.j.h("handle");
                throw null;
            }
            m5.a();
        }
    }

    public final String toString() {
        return "DisposeHandlersOnCancel[" + this.f4112a + ']';
    }
}
