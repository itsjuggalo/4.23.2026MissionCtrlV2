package a5;

import a.AbstractC0284a;

/* JADX INFO: renamed from: a5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0290a extends p0 implements I4.d, A {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final I4.i f4105c;

    public AbstractC0290a(I4.i iVar, boolean z6) {
        super(z6);
        x((InterfaceC0295c0) iVar.get(C0318z.f4167b));
        this.f4105c = iVar.plus(this);
    }

    @Override // a5.p0
    public final void F(Object obj) {
        if (!(obj instanceof C0315w)) {
            P(obj);
        } else {
            C0315w c0315w = (C0315w) obj;
            O(c0315w.f4160a, C0315w.f4159b.get(c0315w) != 0);
        }
    }

    public final void Q(B b3, AbstractC0290a abstractC0290a, R4.p pVar) {
        Object objInvoke;
        int iOrdinal = b3.ordinal();
        G4.l lVar = G4.l.f540a;
        if (iOrdinal == 0) {
            try {
                f5.a.h(F1.h.z(F1.h.n(abstractC0290a, this, pVar)), lVar);
                return;
            } finally {
                resumeWith(AbstractC0284a.d(th));
            }
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                kotlin.jvm.internal.j.e(pVar, "<this>");
                F1.h.z(F1.h.n(abstractC0290a, this, pVar)).resumeWith(lVar);
                return;
            }
            if (iOrdinal != 3) {
                throw new G4.e();
            }
            try {
                I4.i iVar = this.f4105c;
                Object objL = f5.a.l(iVar, null);
                try {
                    if (pVar instanceof K4.a) {
                        kotlin.jvm.internal.v.b(2, pVar);
                        objInvoke = pVar.invoke(abstractC0290a, this);
                    } else {
                        objInvoke = F1.h.U(pVar, abstractC0290a, this);
                    }
                    f5.a.g(iVar, objL);
                    if (objInvoke != J4.a.f791a) {
                        resumeWith(objInvoke);
                    }
                } catch (Throwable th) {
                    f5.a.g(iVar, objL);
                    throw th;
                }
            } catch (Throwable th2) {
            }
        }
    }

    @Override // a5.A
    public final I4.i b() {
        return this.f4105c;
    }

    @Override // I4.d
    public final I4.i getContext() {
        return this.f4105c;
    }

    @Override // a5.p0
    public final String l() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // I4.d
    public final void resumeWith(Object obj) {
        Throwable thA = G4.h.a(obj);
        if (thA != null) {
            obj = new C0315w(thA, false);
        }
        Object objB = B(obj);
        if (objB == C.e) {
            return;
        }
        g(objB);
    }

    @Override // a5.p0
    public final void w(G4.e eVar) {
        C.l(this.f4105c, eVar);
    }

    public void P(Object obj) {
    }

    public void O(Throwable th, boolean z6) {
    }
}
