package A3;

import t3.I;
import y3.AbstractC1960n;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f84i = new c();

    public c() {
        super(l.f97c, l.f98d, l.f99e, l.f95a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // t3.I
    public I f0(int i4) {
        AbstractC1960n.a(i4);
        return i4 >= l.f97c ? this : super.f0(i4);
    }

    @Override // t3.I
    public String toString() {
        return "Dispatchers.Default";
    }
}
