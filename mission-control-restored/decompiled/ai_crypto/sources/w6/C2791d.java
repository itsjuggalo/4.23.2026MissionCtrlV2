package w6;

import java.io.EOFException;

/* JADX INFO: renamed from: w6.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2791d implements X {
    @Override // w6.X
    public void L(C2792e source, long j7) throws EOFException {
        kotlin.jvm.internal.r.f(source, "source");
        source.skip(j7);
    }

    @Override // w6.X
    public a0 f() {
        return a0.f25070e;
    }

    @Override // w6.X, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // w6.X, java.io.Flushable
    public void flush() {
    }
}
