package w6;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class O implements X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f25038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f25039b;

    public O(OutputStream out, a0 timeout) {
        kotlin.jvm.internal.r.f(out, "out");
        kotlin.jvm.internal.r.f(timeout, "timeout");
        this.f25038a = out;
        this.f25039b = timeout;
    }

    @Override // w6.X
    public void L(C2792e source, long j7) throws IOException {
        kotlin.jvm.internal.r.f(source, "source");
        AbstractC2789b.b(source.E0(), 0L, j7);
        while (j7 > 0) {
            this.f25039b.f();
            U u7 = source.f25095a;
            kotlin.jvm.internal.r.c(u7);
            int iMin = (int) Math.min(j7, u7.f25054c - u7.f25053b);
            this.f25038a.write(u7.f25052a, u7.f25053b, iMin);
            u7.f25053b += iMin;
            long j8 = iMin;
            j7 -= j8;
            source.D0(source.E0() - j8);
            if (u7.f25053b == u7.f25054c) {
                source.f25095a = u7.b();
                V.b(u7);
            }
        }
    }

    @Override // w6.X, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f25038a.close();
    }

    @Override // w6.X
    public a0 f() {
        return this.f25039b;
    }

    @Override // w6.X, java.io.Flushable
    public void flush() throws IOException {
        this.f25038a.flush();
    }

    public String toString() {
        return "sink(" + this.f25038a + ')';
    }
}
