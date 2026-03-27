package u7;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class K implements T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f23581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final W f23582b;

    public K(OutputStream out, W timeout) {
        AbstractC2304t.f(out, "out");
        AbstractC2304t.f(timeout, "timeout");
        this.f23581a = out;
        this.f23582b = timeout;
    }

    @Override // u7.T
    public void H(C2811d source, long j8) throws IOException {
        AbstractC2304t.f(source, "source");
        AbstractC2809b.b(source.s0(), 0L, j8);
        while (j8 > 0) {
            this.f23582b.c();
            P p8 = source.f23638a;
            AbstractC2304t.c(p8);
            int iMin = (int) Math.min(j8, p8.f23597c - p8.f23596b);
            this.f23581a.write(p8.f23595a, p8.f23596b, iMin);
            p8.f23596b += iMin;
            long j9 = iMin;
            j8 -= j9;
            source.r0(source.s0() - j9);
            if (p8.f23596b == p8.f23597c) {
                source.f23638a = p8.b();
                Q.b(p8);
            }
        }
    }

    @Override // u7.T, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f23581a.close();
    }

    @Override // u7.T, java.io.Flushable
    public void flush() throws IOException {
        this.f23581a.flush();
    }

    public String toString() {
        return "sink(" + this.f23581a + ')';
    }
}
