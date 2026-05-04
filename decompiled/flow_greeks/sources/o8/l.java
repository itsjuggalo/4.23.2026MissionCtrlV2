package o8;

import j8.h0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k8.d;
import p8.d;
import r8.m;
import r8.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d.a f17653b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p8.d f17654a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements d.a {
        @Override // p8.d.a
        public m a(r8.h hVar, m mVar, boolean z10) {
            return null;
        }

        @Override // p8.d.a
        public n b(r8.b bVar) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17655a;

        static {
            int[] iArr = new int[d.a.values().length];
            f17655a = iArr;
            try {
                iArr[d.a.Overwrite.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17655a[d.a.Merge.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17655a[d.a.AckUserWrite.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17655a[d.a.ListenComplete.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f17656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f17657b;

        public c(k kVar, List list) {
            this.f17656a = kVar;
            this.f17657b = list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h0 f17658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k f17659b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final n f17660c;

        public d(h0 h0Var, k kVar, n nVar) {
            this.f17658a = h0Var;
            this.f17659b = kVar;
            this.f17660c = nVar;
        }

        @Override // p8.d.a
        public m a(r8.h hVar, m mVar, boolean z10) {
            n nVarB = this.f17660c;
            if (nVarB == null) {
                nVarB = this.f17659b.b();
            }
            return this.f17658a.g(nVarB, mVar, z10, hVar);
        }

        @Override // p8.d.a
        public n b(r8.b bVar) {
            o8.a aVarC = this.f17659b.c();
            if (aVarC.c(bVar)) {
                return aVarC.b().z(bVar);
            }
            n nVar = this.f17660c;
            return this.f17658a.a(bVar, nVar != null ? new o8.a(r8.i.d(nVar, r8.j.j()), true, false) : this.f17659b.d());
        }
    }

    public l(p8.d dVar) {
        this.f17654a = dVar;
    }

    public static boolean g(k kVar, r8.b bVar) {
        return kVar.c().c(bVar);
    }

    public final k a(k kVar, j8.l lVar, m8.d dVar, h0 h0Var, n nVar, p8.a aVar) {
        j8.l lVar2;
        j8.l lVarU;
        if (h0Var.i(lVar) != null) {
            return kVar;
        }
        boolean zE = kVar.d().e();
        o8.a aVarD = kVar.d();
        if (dVar.getValue() != null) {
            if ((lVar.isEmpty() && aVarD.f()) || aVarD.d(lVar)) {
                return d(kVar, lVar, aVarD.b().O(lVar), h0Var, nVar, zE, aVar);
            }
            if (!lVar.isEmpty()) {
                return kVar;
            }
            j8.b bVarQ = j8.b.q();
            j8.b bVarC = bVarQ;
            for (m mVar : aVarD.b()) {
                bVarC = bVarC.c(mVar.c(), mVar.d());
            }
            return c(kVar, lVar, bVarC, h0Var, nVar, zE, aVar);
        }
        j8.b bVarQ2 = j8.b.q();
        Iterator it = dVar.iterator();
        while (true) {
            j8.b bVar = bVarQ2;
            while (it.hasNext()) {
                lVar2 = (j8.l) ((Map.Entry) it.next()).getKey();
                lVarU = lVar.u(lVar2);
                if (aVarD.d(lVarU)) {
                    break;
                }
            }
            return c(kVar, lVar, bVar, h0Var, nVar, zE, aVar);
            bVarQ2 = bVar.a(lVar2, aVarD.b().O(lVarU));
        }
    }

    public c b(k kVar, k8.d dVar, h0 h0Var, n nVar) {
        p8.a aVar;
        k kVar2;
        k kVarD;
        p8.a aVar2 = new p8.a();
        int i10 = b.f17655a[dVar.c().ordinal()];
        if (i10 == 1) {
            k8.f fVar = (k8.f) dVar;
            if (fVar.b().d()) {
                kVar2 = kVar;
                kVarD = f(kVar2, fVar.a(), fVar.e(), h0Var, nVar, aVar2);
            } else {
                m8.m.f(fVar.b().c());
                if (fVar.b().e() || (kVar.d().e() && !fVar.a().isEmpty())) {
                    z = true;
                }
                aVar = aVar2;
                boolean z10 = z;
                kVar2 = kVar;
                kVarD = d(kVar2, fVar.a(), fVar.e(), h0Var, nVar, z10, aVar);
                aVar2 = aVar;
            }
        } else if (i10 == 2) {
            k8.c cVar = (k8.c) dVar;
            if (cVar.b().d()) {
                kVar2 = kVar;
                kVarD = e(kVar2, cVar.a(), cVar.e(), h0Var, nVar, aVar2);
            } else {
                m8.m.f(cVar.b().c());
                aVar = aVar2;
                kVar2 = kVar;
                kVarD = c(kVar2, cVar.a(), cVar.e(), h0Var, nVar, cVar.b().e() || kVar.d().e(), aVar);
                aVar2 = aVar;
            }
        } else if (i10 == 3) {
            kVar2 = kVar;
            k8.a aVar3 = (k8.a) dVar;
            kVarD = !aVar3.f() ? a(kVar2, aVar3.a(), aVar3.e(), h0Var, nVar, aVar2) : k(kVar2, aVar3.a(), h0Var, nVar, aVar2);
        } else {
            if (i10 != 4) {
                throw new AssertionError("Unknown operation: " + dVar.c());
            }
            kVar2 = kVar;
            kVarD = i(kVar2, dVar.a(), h0Var, nVar, aVar2);
        }
        ArrayList arrayList = new ArrayList(aVar2.a());
        j(kVar2, kVarD, arrayList);
        return new c(kVarD, arrayList);
    }

    public final k c(k kVar, j8.l lVar, j8.b bVar, h0 h0Var, n nVar, boolean z10, p8.a aVar) {
        if (kVar.d().b().isEmpty() && !kVar.d().f()) {
            return kVar;
        }
        m8.m.g(bVar.G() == null, "Can't have a merge that is an overwrite");
        j8.b bVarD = lVar.isEmpty() ? bVar : j8.b.q().d(lVar, bVar);
        n nVarB = kVar.d().b();
        Map mapP = bVarD.p();
        k kVarD = kVar;
        for (Map.Entry entry : mapP.entrySet()) {
            r8.b bVar2 = (r8.b) entry.getKey();
            if (nVarB.F(bVar2)) {
                kVarD = d(kVarD, new j8.l(bVar2), ((j8.b) entry.getValue()).e(nVarB.z(bVar2)), h0Var, nVar, z10, aVar);
            }
        }
        k kVarD2 = kVarD;
        for (Map.Entry entry2 : mapP.entrySet()) {
            r8.b bVar3 = (r8.b) entry2.getKey();
            boolean z11 = !kVar.d().c(bVar3) && ((j8.b) entry2.getValue()).G() == null;
            if (!nVarB.F(bVar3) && !z11) {
                kVarD2 = d(kVarD2, new j8.l(bVar3), ((j8.b) entry2.getValue()).e(nVarB.z(bVar3)), h0Var, nVar, z10, aVar);
            }
        }
        return kVarD2;
    }

    public final k d(k kVar, j8.l lVar, n nVar, h0 h0Var, n nVar2, boolean z10, p8.a aVar) {
        r8.i iVarD;
        o8.a aVarD = kVar.d();
        p8.d dVarA = this.f17654a;
        if (!z10) {
            dVarA = dVarA.a();
        }
        p8.d dVar = dVarA;
        boolean z11 = true;
        if (lVar.isEmpty()) {
            iVarD = dVar.c(aVarD.a(), r8.i.d(nVar, dVar.getIndex()), null);
        } else if (!dVar.b() || aVarD.e()) {
            r8.b bVarK = lVar.K();
            if (!aVarD.d(lVar) && lVar.size() > 1) {
                return kVar;
            }
            j8.l lVarS = lVar.S();
            n nVarI = aVarD.b().z(bVarK).I(lVarS, nVar);
            iVarD = bVarK.s() ? dVar.d(aVarD.a(), nVarI) : dVar.e(aVarD.a(), bVarK, nVarI, lVarS, f17653b, null);
        } else {
            m8.m.g(!lVar.isEmpty(), "An empty path should have been caught in the other branch");
            r8.b bVarK2 = lVar.K();
            iVarD = dVar.c(aVarD.a(), aVarD.a().r(bVarK2, aVarD.b().z(bVarK2).I(lVar.S(), nVar)), null);
        }
        if (!aVarD.f() && !lVar.isEmpty()) {
            z11 = false;
        }
        k kVarF = kVar.f(iVarD, z11, dVar.b());
        return h(kVarF, lVar, h0Var, new d(h0Var, kVarF, nVar2), aVar);
    }

    public final k e(k kVar, j8.l lVar, j8.b bVar, h0 h0Var, n nVar, p8.a aVar) {
        m8.m.g(bVar.G() == null, "Can't have a merge that is an overwrite");
        Iterator it = bVar.iterator();
        k kVarF = kVar;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            j8.l lVarU = lVar.u((j8.l) entry.getKey());
            if (g(kVar, lVarU.K())) {
                kVarF = f(kVarF, lVarU, (n) entry.getValue(), h0Var, nVar, aVar);
            }
        }
        Iterator it2 = bVar.iterator();
        k kVarF2 = kVarF;
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            j8.l lVarU2 = lVar.u((j8.l) entry2.getKey());
            if (!g(kVar, lVarU2.K())) {
                kVarF2 = f(kVarF2, lVarU2, (n) entry2.getValue(), h0Var, nVar, aVar);
            }
        }
        return kVarF2;
    }

    public final k f(k kVar, j8.l lVar, n nVar, h0 h0Var, n nVar2, p8.a aVar) {
        n nVar3;
        o8.a aVarC = kVar.c();
        d dVar = new d(h0Var, kVar, nVar2);
        if (lVar.isEmpty()) {
            return kVar.e(this.f17654a.c(kVar.c().a(), r8.i.d(nVar, this.f17654a.getIndex()), aVar), true, this.f17654a.b());
        }
        r8.b bVarK = lVar.K();
        if (bVarK.s()) {
            return kVar.e(this.f17654a.d(kVar.c().a(), nVar), aVarC.f(), aVarC.e());
        }
        j8.l lVarS = lVar.S();
        n nVarZ = aVarC.b().z(bVarK);
        if (lVarS.isEmpty()) {
            nVar3 = nVar;
        } else {
            n nVarB = dVar.b(bVarK);
            if (nVarB == null) {
                nVar = r8.g.y();
            } else if (lVarS.A().s() && nVarB.O(lVarS.L()).isEmpty()) {
                nVar3 = nVarB;
            } else {
                nVar = nVarB.I(lVarS, nVar);
            }
            nVar3 = nVar;
        }
        return !nVarZ.equals(nVar3) ? kVar.e(this.f17654a.e(aVarC.a(), bVarK, nVar3, lVarS, dVar, aVar), aVarC.f(), this.f17654a.b()) : kVar;
    }

    public final k h(k kVar, j8.l lVar, h0 h0Var, d.a aVar, p8.a aVar2) {
        n nVarA;
        r8.i iVarE;
        n nVarB;
        o8.a aVarC = kVar.c();
        if (h0Var.i(lVar) != null) {
            return kVar;
        }
        if (lVar.isEmpty()) {
            m8.m.g(kVar.d().f(), "If change path is empty, we must have complete server data");
            if (kVar.d().e()) {
                n nVarB2 = kVar.b();
                if (!(nVarB2 instanceof r8.c)) {
                    nVarB2 = r8.g.y();
                }
                nVarB = h0Var.e(nVarB2);
            } else {
                nVarB = h0Var.b(kVar.b());
            }
            iVarE = this.f17654a.c(kVar.c().a(), r8.i.d(nVarB, this.f17654a.getIndex()), aVar2);
        } else {
            r8.b bVarK = lVar.K();
            if (bVarK.s()) {
                m8.m.g(lVar.size() == 1, "Can't have a priority with additional path components");
                n nVarF = h0Var.f(lVar, aVarC.b(), kVar.d().b());
                iVarE = nVarF != null ? this.f17654a.d(aVarC.a(), nVarF) : aVarC.a();
            } else {
                j8.l lVarS = lVar.S();
                if (aVarC.c(bVarK)) {
                    n nVarF2 = h0Var.f(lVar, aVarC.b(), kVar.d().b());
                    nVarA = nVarF2 != null ? aVarC.b().z(bVarK).I(lVarS, nVarF2) : aVarC.b().z(bVarK);
                } else {
                    nVarA = h0Var.a(bVarK, kVar.d());
                }
                n nVar = nVarA;
                iVarE = nVar != null ? this.f17654a.e(aVarC.a(), bVarK, nVar, lVarS, aVar, aVar2) : aVarC.a();
            }
        }
        return kVar.e(iVarE, aVarC.f() || lVar.isEmpty(), this.f17654a.b());
    }

    public final k i(k kVar, j8.l lVar, h0 h0Var, n nVar, p8.a aVar) {
        o8.a aVarD = kVar.d();
        return h(kVar.f(aVarD.a(), aVarD.f() || lVar.isEmpty(), aVarD.e()), lVar, h0Var, f17653b, aVar);
    }

    public final void j(k kVar, k kVar2, List list) {
        o8.a aVarC = kVar2.c();
        if (aVarC.f()) {
            boolean z10 = aVarC.b().J() || aVarC.b().isEmpty();
            if (list.isEmpty() && kVar.c().f() && ((!z10 || aVarC.b().equals(kVar.a())) && aVarC.b().n().equals(kVar.a().n()))) {
                return;
            }
            list.add(o8.c.n(aVarC.a()));
        }
    }

    public k k(k kVar, j8.l lVar, h0 h0Var, n nVar, p8.a aVar) {
        p8.a aVar2;
        if (h0Var.i(lVar) != null) {
            return kVar;
        }
        d dVar = new d(h0Var, kVar, nVar);
        r8.i iVarA = kVar.c().a();
        if (lVar.isEmpty() || lVar.K().s()) {
            iVarA = this.f17654a.c(iVarA, r8.i.d(kVar.d().f() ? h0Var.b(kVar.b()) : h0Var.e(kVar.d().b()), this.f17654a.getIndex()), aVar);
        } else {
            r8.b bVarK = lVar.K();
            n nVarA = h0Var.a(bVarK, kVar.d());
            if (nVarA == null && kVar.d().c(bVarK)) {
                nVarA = iVarA.g().z(bVarK);
            }
            n nVar2 = nVarA;
            if (nVar2 != null) {
                aVar2 = aVar;
                iVarA = this.f17654a.e(iVarA, bVarK, nVar2, lVar.S(), dVar, aVar2);
            } else {
                aVar2 = aVar;
                if (nVar2 == null && kVar.c().b().F(bVarK)) {
                    iVarA = this.f17654a.e(iVarA, bVarK, r8.g.y(), lVar.S(), dVar, aVar2);
                }
            }
            if (iVarA.g().isEmpty() && kVar.d().f()) {
                n nVarB = h0Var.b(kVar.b());
                if (nVarB.J()) {
                    iVarA = this.f17654a.c(iVarA, r8.i.d(nVarB, this.f17654a.getIndex()), aVar2);
                }
            }
        }
        return kVar.e(iVarA, kVar.d().f() || h0Var.i(j8.l.G()) != null, this.f17654a.b());
    }
}
