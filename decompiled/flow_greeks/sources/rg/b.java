package rg;

import cd.h0;
import cd.r;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d[] f19882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19884c;

    public final d c() {
        d dVarD;
        synchronized (this) {
            try {
                d[] dVarArrE = this.f19882a;
                if (dVarArrE == null) {
                    dVarArrE = e(2);
                    this.f19882a = dVarArrE;
                } else if (this.f19883b >= dVarArrE.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(dVarArrE, dVarArrE.length * 2);
                    kotlin.jvm.internal.t.e(objArrCopyOf, "copyOf(...)");
                    this.f19882a = (d[]) objArrCopyOf;
                    dVarArrE = (d[]) objArrCopyOf;
                }
                int i10 = this.f19884c;
                do {
                    dVarD = dVarArrE[i10];
                    if (dVarD == null) {
                        dVarD = d();
                        dVarArrE[i10] = dVarD;
                    }
                    i10++;
                    if (i10 >= dVarArrE.length) {
                        i10 = 0;
                    }
                    kotlin.jvm.internal.t.d(dVarD, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!dVarD.a(this));
                this.f19884c = i10;
                this.f19883b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVarD;
    }

    public abstract d d();

    public abstract d[] e(int i10);

    public final void f(d dVar) {
        int i10;
        gd.e[] eVarArrB;
        synchronized (this) {
            try {
                int i11 = this.f19883b - 1;
                this.f19883b = i11;
                if (i11 == 0) {
                    this.f19884c = 0;
                }
                kotlin.jvm.internal.t.d(dVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                eVarArrB = dVar.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (gd.e eVar : eVarArrB) {
            if (eVar != null) {
                r.a aVar = cd.r.f3870b;
                eVar.resumeWith(cd.r.b(h0.f3852a));
            }
        }
    }

    public final d[] g() {
        return this.f19882a;
    }
}
