package x6;

import java.io.EOFException;
import java.io.IOException;
import kotlin.jvm.internal.r;
import w6.AbstractC2800m;
import w6.C2792e;
import w6.Z;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends AbstractC2800m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f25335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f25336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f25337d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Z delegate, long j7, boolean z7) {
        super(delegate);
        r.f(delegate, "delegate");
        this.f25335b = j7;
        this.f25336c = z7;
    }

    public final void i(C2792e c2792e, long j7) throws EOFException {
        C2792e c2792e2 = new C2792e();
        c2792e2.n(c2792e);
        c2792e.L(c2792e2, j7);
        c2792e2.i();
    }

    @Override // w6.AbstractC2800m, w6.Z
    public long z(C2792e sink, long j7) throws IOException {
        r.f(sink, "sink");
        long j8 = this.f25337d;
        long j9 = this.f25335b;
        if (j8 > j9) {
            j7 = 0;
        } else if (this.f25336c) {
            long j10 = j9 - j8;
            if (j10 == 0) {
                return -1L;
            }
            j7 = Math.min(j7, j10);
        }
        long jZ = super.z(sink, j7);
        if (jZ != -1) {
            this.f25337d += jZ;
        }
        long j11 = this.f25337d;
        long j12 = this.f25335b;
        if ((j11 >= j12 || jZ != -1) && j11 <= j12) {
            return jZ;
        }
        if (jZ > 0 && j11 > j12) {
            i(sink, sink.E0() - (this.f25337d - this.f25335b));
        }
        throw new IOException("expected " + this.f25335b + " bytes but got " + this.f25337d);
    }
}
