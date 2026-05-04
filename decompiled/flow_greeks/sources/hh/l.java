package hh;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f11486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f11487b;

    public l(OutputStream out, u timeout) {
        kotlin.jvm.internal.t.f(out, "out");
        kotlin.jvm.internal.t.f(timeout, "timeout");
        this.f11486a = out;
        this.f11487b = timeout;
    }

    @Override // hh.r
    public void L(d source, long j10) throws IOException {
        kotlin.jvm.internal.t.f(source, "source");
        b.b(source.size(), 0L, j10);
        while (j10 > 0) {
            this.f11487b.c();
            o oVar = source.f11469a;
            kotlin.jvm.internal.t.c(oVar);
            int iMin = (int) Math.min(j10, oVar.f11497c - oVar.f11496b);
            this.f11486a.write(oVar.f11495a, oVar.f11496b, iMin);
            oVar.f11496b += iMin;
            long j11 = iMin;
            j10 -= j11;
            source.f0(source.size() - j11);
            if (oVar.f11496b == oVar.f11497c) {
                source.f11469a = oVar.b();
                p.b(oVar);
            }
        }
    }

    @Override // hh.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f11486a.close();
    }

    @Override // hh.r, java.io.Flushable
    public void flush() throws IOException {
        this.f11486a.flush();
    }

    public String toString() {
        return "sink(" + this.f11486a + ')';
    }
}
