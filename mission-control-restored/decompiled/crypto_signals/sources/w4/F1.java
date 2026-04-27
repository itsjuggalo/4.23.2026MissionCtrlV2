package w4;

import u4.AbstractC1225g;

/* JADX INFO: loaded from: classes.dex */
public final class F1 extends AbstractC1225g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final K1 f10852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f10853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ G0 f10854d;

    public F1(G0 g02, K1 k12) {
        this.f10854d = g02;
        this.f10852b = k12;
    }

    @Override // u4.AbstractC1225g
    public final void l(long j4) {
        if (this.f10854d.f10877o.f10902f != null) {
            return;
        }
        synchronized (this.f10854d.i) {
            try {
                if (this.f10854d.f10877o.f10902f == null) {
                    K1 k12 = this.f10852b;
                    if (!k12.f10933b) {
                        long j6 = this.f10853c + j4;
                        this.f10853c = j6;
                        G0 g02 = this.f10854d;
                        long j7 = g02.f10882t;
                        if (j6 <= j7) {
                            return;
                        }
                        if (j6 > g02.f10873k) {
                            k12.f10934c = true;
                        } else {
                            long jAddAndGet = g02.f10872j.f11243a.addAndGet(j6 - j7);
                            G0 g03 = this.f10854d;
                            g03.f10882t = this.f10853c;
                            if (jAddAndGet > g03.f10874l) {
                                this.f10852b.f10934c = true;
                            }
                        }
                        K1 k13 = this.f10852b;
                        N1.B0 b0O = k13.f10934c ? this.f10854d.o(k13) : null;
                        if (b0O != null) {
                            b0O.run();
                        }
                    }
                }
            } finally {
            }
        }
    }
}
