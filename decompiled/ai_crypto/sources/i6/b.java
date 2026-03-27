package i6;

import b6.AbstractC1082m0;
import b6.I;
import g6.G;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends AbstractC1082m0 implements Executor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f16467d = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final I f16468e = m.f16488c.A0(g6.I.e("kotlinx.coroutines.io.parallelism", W5.l.b(64, G.a()), 0, 0, 12, null));

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        y0(H5.h.f2671a, runnable);
    }

    @Override // b6.I
    public String toString() {
        return "Dispatchers.IO";
    }

    @Override // b6.I
    public void y0(H5.g gVar, Runnable runnable) {
        f16468e.y0(gVar, runnable);
    }
}
