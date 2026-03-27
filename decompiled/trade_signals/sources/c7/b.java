package c7;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;
import o5.C2490r;
import s5.InterfaceC2707e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d[] f13577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13579c;

    public final d c() {
        d dVarD;
        synchronized (this) {
            try {
                d[] dVarArrE = this.f13577a;
                if (dVarArrE == null) {
                    dVarArrE = e(2);
                    this.f13577a = dVarArrE;
                } else if (this.f13578b >= dVarArrE.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(dVarArrE, dVarArrE.length * 2);
                    AbstractC2304t.e(objArrCopyOf, "copyOf(...)");
                    this.f13577a = (d[]) objArrCopyOf;
                    dVarArrE = (d[]) objArrCopyOf;
                }
                int i8 = this.f13579c;
                do {
                    dVarD = dVarArrE[i8];
                    if (dVarD == null) {
                        dVarD = d();
                        dVarArrE[i8] = dVarD;
                    }
                    i8++;
                    if (i8 >= dVarArrE.length) {
                        i8 = 0;
                    }
                    AbstractC2304t.d(dVarD, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!dVarD.a(this));
                this.f13579c = i8;
                this.f13578b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVarD;
    }

    public abstract d d();

    public abstract d[] e(int i8);

    public final void f(d dVar) {
        int i8;
        InterfaceC2707e[] interfaceC2707eArrB;
        synchronized (this) {
            try {
                int i9 = this.f13578b - 1;
                this.f13578b = i9;
                if (i9 == 0) {
                    this.f13579c = 0;
                }
                AbstractC2304t.d(dVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                interfaceC2707eArrB = dVar.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (InterfaceC2707e interfaceC2707e : interfaceC2707eArrB) {
            if (interfaceC2707e != null) {
                C2490r.a aVar = C2490r.f21981b;
                interfaceC2707e.resumeWith(C2490r.b(C2470H.f21956a));
            }
        }
    }

    public final d[] g() {
        return this.f13577a;
    }
}
