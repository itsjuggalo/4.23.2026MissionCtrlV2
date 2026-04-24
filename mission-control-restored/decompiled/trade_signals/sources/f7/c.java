package f7;

import Y6.I;
import d7.AbstractC1651l;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f17628i = new c();

    public c() {
        super(j.f17640c, j.f17641d, j.f17642e, j.f17638a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // Y6.I
    public String toString() {
        return "Dispatchers.Default";
    }

    @Override // Y6.I
    public I x0(int i8, String str) {
        AbstractC1651l.a(i8);
        return i8 >= j.f17640c ? AbstractC1651l.b(this, str) : super.x0(i8, str);
    }
}
