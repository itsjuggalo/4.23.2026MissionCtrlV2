package f7;

import Y6.AbstractC1016l0;
import Y6.I;
import d7.E;
import d7.G;
import java.util.concurrent.Executor;
import s5.C2712j;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends AbstractC1016l0 implements Executor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f17626d = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final I f17627e = I.y0(k.f17644c, G.e("kotlinx.coroutines.io.parallelism", H5.i.b(64, E.a()), 0, 0, 12, null), null, 2, null);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        v0(C2712j.f23116a, runnable);
    }

    @Override // Y6.I
    public String toString() {
        return "Dispatchers.IO";
    }

    @Override // Y6.I
    public void v0(InterfaceC2711i interfaceC2711i, Runnable runnable) {
        f17627e.v0(interfaceC2711i, runnable);
    }

    @Override // Y6.I
    public I x0(int i8, String str) {
        return k.f17644c.x0(i8, str);
    }
}
