package hh;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class h implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f11483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f11484b;

    public h(InputStream input, u timeout) {
        kotlin.jvm.internal.t.f(input, "input");
        kotlin.jvm.internal.t.f(timeout, "timeout");
        this.f11483a = input;
        this.f11484b = timeout;
    }

    @Override // hh.t
    public long B(d sink, long j10) throws IOException {
        kotlin.jvm.internal.t.f(sink, "sink");
        if (j10 == 0) {
            return 0L;
        }
        if (j10 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
        try {
            this.f11484b.c();
            o oVarI0 = sink.i0(1);
            int i10 = this.f11483a.read(oVarI0.f11495a, oVarI0.f11497c, (int) Math.min(j10, 8192 - oVarI0.f11497c));
            if (i10 != -1) {
                oVarI0.f11497c += i10;
                long j11 = i10;
                sink.f0(sink.size() + j11);
                return j11;
            }
            if (oVarI0.f11496b != oVarI0.f11497c) {
                return -1L;
            }
            sink.f11469a = oVarI0.b();
            p.b(oVarI0);
            return -1L;
        } catch (AssertionError e10) {
            if (i.c(e10)) {
                throw new IOException(e10);
            }
            throw e10;
        }
    }

    @Override // hh.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f11483a.close();
    }

    public String toString() {
        return "source(" + this.f11483a + ')';
    }
}
