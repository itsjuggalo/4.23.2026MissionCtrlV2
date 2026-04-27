package x3;

import W2.E;
import W2.p;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d[] f15753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15755c;

    public final d c() {
        d dVarD;
        synchronized (this) {
            try {
                d[] dVarArrE = this.f15753a;
                if (dVarArrE == null) {
                    dVarArrE = e(2);
                    this.f15753a = dVarArrE;
                } else if (this.f15754b >= dVarArrE.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(dVarArrE, dVarArrE.length * 2);
                    kotlin.jvm.internal.r.e(objArrCopyOf, "copyOf(this, newSize)");
                    this.f15753a = (d[]) objArrCopyOf;
                    dVarArrE = (d[]) objArrCopyOf;
                }
                int i4 = this.f15755c;
                do {
                    dVarD = dVarArrE[i4];
                    if (dVarD == null) {
                        dVarD = d();
                        dVarArrE[i4] = dVarD;
                    }
                    i4++;
                    if (i4 >= dVarArrE.length) {
                        i4 = 0;
                    }
                    kotlin.jvm.internal.r.d(dVarD, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!dVarD.a(this));
                this.f15755c = i4;
                this.f15754b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVarD;
    }

    public abstract d d();

    public abstract d[] e(int i4);

    public final void f(d dVar) {
        int i4;
        Z2.e[] eVarArrB;
        synchronized (this) {
            try {
                int i5 = this.f15754b - 1;
                this.f15754b = i5;
                if (i5 == 0) {
                    this.f15755c = 0;
                }
                kotlin.jvm.internal.r.d(dVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                eVarArrB = dVar.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Z2.e eVar : eVarArrB) {
            if (eVar != null) {
                p.a aVar = W2.p.f5487b;
                eVar.resumeWith(W2.p.b(E.f5463a));
            }
        }
    }

    public final d[] g() {
        return this.f15753a;
    }
}
