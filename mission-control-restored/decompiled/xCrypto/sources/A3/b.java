package A3;

import java.util.concurrent.Executor;
import o3.AbstractC1681l;
import t3.AbstractC1827m0;
import t3.I;
import y3.G;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends AbstractC1827m0 implements Executor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f82d = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final I f83e = m.f103c.f0(y3.I.e("kotlinx.coroutines.io.parallelism", AbstractC1681l.b(64, G.a()), 0, 0, 12, null));

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // t3.I
    public void d0(Z2.i iVar, Runnable runnable) {
        f83e.d0(iVar, runnable);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        d0(Z2.j.f6012a, runnable);
    }

    @Override // t3.I
    public I f0(int i4) {
        return m.f103c.f0(i4);
    }

    @Override // t3.I
    public String toString() {
        return "Dispatchers.IO";
    }
}
