package ug;

import ng.k0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f23018i = new c();

    public c() {
        super(j.f23030c, j.f23031d, j.f23032e, j.f23028a);
    }

    @Override // ng.k0
    public k0 c0(int i10, String str) {
        sg.l.a(i10);
        return i10 >= j.f23030c ? sg.l.b(this, str) : super.c0(i10, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // ng.k0
    public String toString() {
        return "Dispatchers.Default";
    }
}
