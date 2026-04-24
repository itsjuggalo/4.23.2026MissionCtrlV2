package v7;

import java.io.EOFException;
import java.io.IOException;
import kotlin.jvm.internal.AbstractC2304t;
import u7.AbstractC2818k;
import u7.C2811d;
import u7.V;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends AbstractC2818k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f23917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f23918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f23919d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(V delegate, long j8, boolean z7) {
        super(delegate);
        AbstractC2304t.f(delegate, "delegate");
        this.f23917b = j8;
        this.f23918c = z7;
    }

    public final void a(C2811d c2811d, long j8) throws EOFException {
        C2811d c2811d2 = new C2811d();
        c2811d2.B0(c2811d);
        c2811d.H(c2811d2, j8);
        c2811d2.e();
    }

    @Override // u7.AbstractC2818k, u7.V
    public long o0(C2811d sink, long j8) throws IOException {
        AbstractC2304t.f(sink, "sink");
        long j9 = this.f23919d;
        long j10 = this.f23917b;
        if (j9 > j10) {
            j8 = 0;
        } else if (this.f23918c) {
            long j11 = j10 - j9;
            if (j11 == 0) {
                return -1L;
            }
            j8 = Math.min(j8, j11);
        }
        long jO0 = super.o0(sink, j8);
        if (jO0 != -1) {
            this.f23919d += jO0;
        }
        long j12 = this.f23919d;
        long j13 = this.f23917b;
        if ((j12 >= j13 || jO0 != -1) && j12 <= j13) {
            return jO0;
        }
        if (jO0 > 0 && j12 > j13) {
            a(sink, sink.s0() - (this.f23919d - this.f23917b));
        }
        throw new IOException("expected " + this.f23917b + " bytes but got " + this.f23919d);
    }
}
