package f6;

import E5.E;
import E5.p;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d[] f14187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14189c;

    public final d e() {
        d dVarF;
        synchronized (this) {
            try {
                d[] dVarArrG = this.f14187a;
                if (dVarArrG == null) {
                    dVarArrG = g(2);
                    this.f14187a = dVarArrG;
                } else if (this.f14188b >= dVarArrG.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(dVarArrG, dVarArrG.length * 2);
                    kotlin.jvm.internal.r.e(objArrCopyOf, "copyOf(this, newSize)");
                    this.f14187a = (d[]) objArrCopyOf;
                    dVarArrG = (d[]) objArrCopyOf;
                }
                int i7 = this.f14189c;
                do {
                    dVarF = dVarArrG[i7];
                    if (dVarF == null) {
                        dVarF = f();
                        dVarArrG[i7] = dVarF;
                    }
                    i7++;
                    if (i7 >= dVarArrG.length) {
                        i7 = 0;
                    }
                    kotlin.jvm.internal.r.d(dVarF, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!dVarF.a(this));
                this.f14189c = i7;
                this.f14188b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVarF;
    }

    public abstract d f();

    public abstract d[] g(int i7);

    public final void h(d dVar) {
        int i7;
        H5.d[] dVarArrB;
        synchronized (this) {
            try {
                int i8 = this.f14188b - 1;
                this.f14188b = i8;
                if (i8 == 0) {
                    this.f14189c = 0;
                }
                kotlin.jvm.internal.r.d(dVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                dVarArrB = dVar.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (H5.d dVar2 : dVarArrB) {
            if (dVar2 != null) {
                p.a aVar = E5.p.f1681b;
                dVar2.resumeWith(E5.p.b(E.f1657a));
            }
        }
    }

    public final d[] i() {
        return this.f14187a;
    }
}
