package w6;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: w6.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2804q implements Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f25145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f25146b;

    public C2804q(InputStream input, a0 timeout) {
        kotlin.jvm.internal.r.f(input, "input");
        kotlin.jvm.internal.r.f(timeout, "timeout");
        this.f25145a = input;
        this.f25146b = timeout;
    }

    @Override // w6.Z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f25145a.close();
    }

    @Override // w6.Z
    public a0 f() {
        return this.f25146b;
    }

    public String toString() {
        return "source(" + this.f25145a + ')';
    }

    @Override // w6.Z
    public long z(C2792e sink, long j7) throws IOException {
        kotlin.jvm.internal.r.f(sink, "sink");
        if (j7 == 0) {
            return 0L;
        }
        if (j7 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
        }
        try {
            this.f25146b.f();
            U uH0 = sink.H0(1);
            int i7 = this.f25145a.read(uH0.f25052a, uH0.f25054c, (int) Math.min(j7, 8192 - uH0.f25054c));
            if (i7 != -1) {
                uH0.f25054c += i7;
                long j8 = i7;
                sink.D0(sink.E0() + j8);
                return j8;
            }
            if (uH0.f25053b != uH0.f25054c) {
                return -1L;
            }
            sink.f25095a = uH0.b();
            V.b(uH0);
            return -1L;
        } catch (AssertionError e7) {
            if (L.e(e7)) {
                throw new IOException(e7);
            }
            throw e7;
        }
    }
}
