package u7;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: u7.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2820m implements V {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f23680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final W f23681b;

    public C2820m(InputStream input, W timeout) {
        AbstractC2304t.f(input, "input");
        AbstractC2304t.f(timeout, "timeout");
        this.f23680a = input;
        this.f23681b = timeout;
    }

    @Override // u7.V, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f23680a.close();
    }

    @Override // u7.V
    public long o0(C2811d sink, long j8) throws IOException {
        AbstractC2304t.f(sink, "sink");
        if (j8 == 0) {
            return 0L;
        }
        if (j8 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j8).toString());
        }
        try {
            this.f23681b.c();
            P pX0 = sink.x0(1);
            int i8 = this.f23680a.read(pX0.f23595a, pX0.f23597c, (int) Math.min(j8, 8192 - pX0.f23597c));
            if (i8 != -1) {
                pX0.f23597c += i8;
                long j9 = i8;
                sink.r0(sink.s0() + j9);
                return j9;
            }
            if (pX0.f23596b != pX0.f23597c) {
                return -1L;
            }
            sink.f23638a = pX0.b();
            Q.b(pX0);
            return -1L;
        } catch (AssertionError e8) {
            if (H.c(e8)) {
                throw new IOException(e8);
            }
            throw e8;
        }
    }

    public String toString() {
        return "source(" + this.f23680a + ')';
    }
}
