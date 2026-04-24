package u7;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: u7.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2819l implements V {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2813f f23676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Inflater f23677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f23679d;

    public C2819l(InterfaceC2813f source, Inflater inflater) {
        AbstractC2304t.f(source, "source");
        AbstractC2304t.f(inflater, "inflater");
        this.f23676a = source;
        this.f23677b = inflater;
    }

    public final long a(C2811d sink, long j8) throws IOException {
        AbstractC2304t.f(sink, "sink");
        if (j8 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j8).toString());
        }
        if (!(!this.f23679d)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j8 == 0) {
            return 0L;
        }
        try {
            P pX0 = sink.x0(1);
            int iMin = (int) Math.min(j8, 8192 - pX0.f23597c);
            c();
            int iInflate = this.f23677b.inflate(pX0.f23595a, pX0.f23597c, iMin);
            e();
            if (iInflate > 0) {
                pX0.f23597c += iInflate;
                long j9 = iInflate;
                sink.r0(sink.s0() + j9);
                return j9;
            }
            if (pX0.f23596b == pX0.f23597c) {
                sink.f23638a = pX0.b();
                Q.b(pX0);
            }
            return 0L;
        } catch (DataFormatException e8) {
            throw new IOException(e8);
        }
    }

    public final boolean c() {
        if (!this.f23677b.needsInput()) {
            return false;
        }
        if (this.f23676a.w()) {
            return true;
        }
        P p8 = this.f23676a.v().f23638a;
        AbstractC2304t.c(p8);
        int i8 = p8.f23597c;
        int i9 = p8.f23596b;
        int i10 = i8 - i9;
        this.f23678c = i10;
        this.f23677b.setInput(p8.f23595a, i9, i10);
        return false;
    }

    @Override // u7.V, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f23679d) {
            return;
        }
        this.f23677b.end();
        this.f23679d = true;
        this.f23676a.close();
    }

    public final void e() {
        int i8 = this.f23678c;
        if (i8 == 0) {
            return;
        }
        int remaining = i8 - this.f23677b.getRemaining();
        this.f23678c -= remaining;
        this.f23676a.skip(remaining);
    }

    @Override // u7.V
    public long o0(C2811d sink, long j8) throws IOException {
        AbstractC2304t.f(sink, "sink");
        do {
            long jA = a(sink, j8);
            if (jA > 0) {
                return jA;
            }
            if (this.f23677b.finished() || this.f23677b.needsDictionary()) {
                return -1L;
            }
        } while (!this.f23676a.w());
        throw new EOFException("source exhausted prematurely");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C2819l(V source, Inflater inflater) {
        this(H.b(source), inflater);
        AbstractC2304t.f(source, "source");
        AbstractC2304t.f(inflater, "inflater");
    }
}
