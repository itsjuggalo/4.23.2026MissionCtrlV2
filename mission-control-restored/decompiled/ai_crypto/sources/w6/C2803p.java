package w6;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: renamed from: w6.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2803p implements Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2794g f25141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Inflater f25142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f25144d;

    public C2803p(InterfaceC2794g source, Inflater inflater) {
        kotlin.jvm.internal.r.f(source, "source");
        kotlin.jvm.internal.r.f(inflater, "inflater");
        this.f25141a = source;
        this.f25142b = inflater;
    }

    public final void A() {
        int i7 = this.f25143c;
        if (i7 == 0) {
            return;
        }
        int remaining = i7 - this.f25142b.getRemaining();
        this.f25143c -= remaining;
        this.f25141a.skip(remaining);
    }

    @Override // w6.Z, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f25144d) {
            return;
        }
        this.f25142b.end();
        this.f25144d = true;
        this.f25141a.close();
    }

    @Override // w6.Z
    public a0 f() {
        return this.f25141a.f();
    }

    public final long h(C2792e sink, long j7) throws IOException {
        kotlin.jvm.internal.r.f(sink, "sink");
        if (j7 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
        }
        if (this.f25144d) {
            throw new IllegalStateException("closed");
        }
        if (j7 == 0) {
            return 0L;
        }
        try {
            U uH0 = sink.H0(1);
            int iMin = (int) Math.min(j7, 8192 - uH0.f25054c);
            i();
            int iInflate = this.f25142b.inflate(uH0.f25052a, uH0.f25054c, iMin);
            A();
            if (iInflate > 0) {
                uH0.f25054c += iInflate;
                long j8 = iInflate;
                sink.D0(sink.E0() + j8);
                return j8;
            }
            if (uH0.f25053b == uH0.f25054c) {
                sink.f25095a = uH0.b();
                V.b(uH0);
            }
            return 0L;
        } catch (DataFormatException e7) {
            throw new IOException(e7);
        }
    }

    public final boolean i() {
        if (!this.f25142b.needsInput()) {
            return false;
        }
        if (this.f25141a.u()) {
            return true;
        }
        U u7 = this.f25141a.t().f25095a;
        kotlin.jvm.internal.r.c(u7);
        int i7 = u7.f25054c;
        int i8 = u7.f25053b;
        int i9 = i7 - i8;
        this.f25143c = i9;
        this.f25142b.setInput(u7.f25052a, i8, i9);
        return false;
    }

    @Override // w6.Z
    public long z(C2792e sink, long j7) {
        kotlin.jvm.internal.r.f(sink, "sink");
        do {
            long jH = h(sink, j7);
            if (jH > 0) {
                return jH;
            }
            if (this.f25142b.finished() || this.f25142b.needsDictionary()) {
                return -1L;
            }
        } while (!this.f25141a.u());
        throw new EOFException("source exhausted prematurely");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C2803p(Z source, Inflater inflater) {
        this(L.d(source), inflater);
        kotlin.jvm.internal.r.f(source, "source");
        kotlin.jvm.internal.r.f(inflater, "inflater");
    }
}
