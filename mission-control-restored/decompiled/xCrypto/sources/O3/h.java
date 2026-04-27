package O3;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class h implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f3335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f3336b;

    public h(InputStream input, u timeout) {
        kotlin.jvm.internal.r.f(input, "input");
        kotlin.jvm.internal.r.f(timeout, "timeout");
        this.f3335a = input;
        this.f3336b = timeout;
    }

    @Override // O3.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3335a.close();
    }

    public String toString() {
        return "source(" + this.f3335a + ')';
    }

    @Override // O3.t
    public long v(d sink, long j4) throws IOException {
        kotlin.jvm.internal.r.f(sink, "sink");
        if (j4 == 0) {
            return 0L;
        }
        if (j4 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        }
        try {
            this.f3336b.c();
            o oVarL0 = sink.l0(1);
            int i4 = this.f3335a.read(oVarL0.f3347a, oVarL0.f3349c, (int) Math.min(j4, 8192 - oVarL0.f3349c));
            if (i4 != -1) {
                oVarL0.f3349c += i4;
                long j5 = i4;
                sink.h0(sink.i0() + j5);
                return j5;
            }
            if (oVarL0.f3348b != oVarL0.f3349c) {
                return -1L;
            }
            sink.f3321a = oVarL0.b();
            p.b(oVarL0);
            return -1L;
        } catch (AssertionError e4) {
            if (i.c(e4)) {
                throw new IOException(e4);
            }
            throw e4;
        }
    }
}
