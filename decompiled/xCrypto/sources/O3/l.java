package O3;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f3338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f3339b;

    public l(OutputStream out, u timeout) {
        kotlin.jvm.internal.r.f(out, "out");
        kotlin.jvm.internal.r.f(timeout, "timeout");
        this.f3338a = out;
        this.f3339b = timeout;
    }

    @Override // O3.r
    public void c0(d source, long j4) throws IOException {
        kotlin.jvm.internal.r.f(source, "source");
        b.b(source.i0(), 0L, j4);
        while (j4 > 0) {
            this.f3339b.c();
            o oVar = source.f3321a;
            kotlin.jvm.internal.r.c(oVar);
            int iMin = (int) Math.min(j4, oVar.f3349c - oVar.f3348b);
            this.f3338a.write(oVar.f3347a, oVar.f3348b, iMin);
            oVar.f3348b += iMin;
            long j5 = iMin;
            j4 -= j5;
            source.h0(source.i0() - j5);
            if (oVar.f3348b == oVar.f3349c) {
                source.f3321a = oVar.b();
                p.b(oVar);
            }
        }
    }

    @Override // O3.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3338a.close();
    }

    @Override // O3.r, java.io.Flushable
    public void flush() throws IOException {
        this.f3338a.flush();
    }

    public String toString() {
        return "sink(" + this.f3338a + ')';
    }
}
