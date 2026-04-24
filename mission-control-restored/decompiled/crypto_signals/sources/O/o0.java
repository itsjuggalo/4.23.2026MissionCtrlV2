package O;

import java.io.File;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class o0 extends kotlin.jvm.internal.k implements R4.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2268c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o0(int i, Object obj, Object obj2) {
        super(1);
        this.f2266a = i;
        this.f2267b = obj;
        this.f2268c = obj2;
    }

    @Override // R4.l
    public final Object invoke(Object obj) throws Throwable {
        Object hVar;
        G4.l lVar;
        G4.l lVar2;
        switch (this.f2266a) {
            case 0:
                boolean zA = kotlin.jvm.internal.j.a((String) obj, ((File) this.f2267b).getName());
                G4.l lVar3 = G4.l.f540a;
                if (zA) {
                    c5.r rVar = (c5.r) ((c5.s) this.f2268c);
                    Object objD = rVar.f4967d.d(lVar3);
                    if (objD instanceof c5.i) {
                        Object obj2 = ((c5.j) a5.C.t(new c5.l(rVar, null))).f4957a;
                    }
                }
                return lVar3;
            case 1:
                Throwable th = (Throwable) obj;
                ((N) this.f2267b).invoke(th);
                e3.w wVar = (e3.w) this.f2268c;
                ((c5.c) wVar.f6193d).g(th, false);
                do {
                    c5.c cVar = (c5.c) wVar.f6193d;
                    cVar.getClass();
                    AtomicLongFieldUpdater atomicLongFieldUpdater = c5.c.f4926c;
                    long j4 = atomicLongFieldUpdater.get(cVar);
                    AtomicLongFieldUpdater atomicLongFieldUpdater2 = c5.c.f4925b;
                    long j6 = atomicLongFieldUpdater2.get(cVar);
                    boolean z6 = true;
                    if (cVar.q(j6, true)) {
                        hVar = new c5.h(cVar.l());
                    } else {
                        long j7 = j6 & 1152921504606846975L;
                        c5.i iVar = c5.j.f4956b;
                        if (j4 >= j7) {
                            hVar = iVar;
                        } else {
                            Object obj3 = c5.e.f4943k;
                            c5.k kVar = (c5.k) c5.c.f4929k.get(cVar);
                            while (true) {
                                if (cVar.q(atomicLongFieldUpdater2.get(cVar), z6)) {
                                    hVar = new c5.h(cVar.l());
                                } else {
                                    long andIncrement = atomicLongFieldUpdater.getAndIncrement(cVar);
                                    long j8 = c5.e.f4936b;
                                    c5.i iVar2 = iVar;
                                    long j9 = andIncrement / j8;
                                    int i = (int) (andIncrement % j8);
                                    if (kVar.f6531c != j9) {
                                        c5.k kVarK = cVar.k(j9, kVar);
                                        if (kVarK == null) {
                                            continue;
                                            iVar = iVar2;
                                            z6 = true;
                                        } else {
                                            kVar = kVarK;
                                        }
                                    }
                                    Object objZ = cVar.z(kVar, i, andIncrement, obj3);
                                    if (objZ == c5.e.f4945m) {
                                        a5.D0 d02 = obj3 instanceof a5.D0 ? (a5.D0) obj3 : null;
                                        if (d02 != null) {
                                            d02.b(kVar, i);
                                        }
                                        cVar.B(andIncrement);
                                        kVar.i();
                                        hVar = iVar2;
                                    } else if (objZ == c5.e.f4947o) {
                                        if (andIncrement < cVar.o()) {
                                            kVar.b();
                                        }
                                        iVar = iVar2;
                                        z6 = true;
                                    } else {
                                        if (objZ == c5.e.f4946n) {
                                            throw new IllegalStateException("unexpected");
                                        }
                                        kVar.b();
                                        hVar = objZ;
                                    }
                                }
                            }
                        }
                    }
                    lVar = null;
                    if (hVar instanceof c5.i) {
                        hVar = null;
                    }
                    lVar2 = G4.l.f540a;
                    if (hVar != null) {
                        ((C0181f0) hVar).f2197b.O(th == null ? new CancellationException("DataStore scope was cancelled before updateData could complete") : th);
                        lVar = lVar2;
                    }
                } while (lVar != null);
                return lVar2;
            default:
                Throwable th2 = (Throwable) obj;
                r.i iVar3 = (r.i) this.f2267b;
                if (th2 == null) {
                    Object objQ = ((a5.G) this.f2268c).q();
                    iVar3.f9435d = true;
                    r.k kVar2 = iVar3.f9433b;
                    if (kVar2 != null && kVar2.f9438b.j(objQ)) {
                        iVar3.f9432a = null;
                        iVar3.f9433b = null;
                        iVar3.f9434c = null;
                    }
                } else if (th2 instanceof CancellationException) {
                    iVar3.f9435d = true;
                    r.k kVar3 = iVar3.f9433b;
                    if (kVar3 != null && kVar3.f9438b.cancel(true)) {
                        iVar3.f9432a = null;
                        iVar3.f9433b = null;
                        iVar3.f9434c = null;
                    }
                } else {
                    iVar3.f9435d = true;
                    r.k kVar4 = iVar3.f9433b;
                    if (kVar4 != null && kVar4.f9438b.k(th2)) {
                        iVar3.f9432a = null;
                        iVar3.f9433b = null;
                        iVar3.f9434c = null;
                    }
                }
                return G4.l.f540a;
        }
    }
}
