package j8;

import g8.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import m8.d;
import o8.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s f14163f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l8.e f14164g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final q8.c f14165h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f14166i = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m8.d f14158a = m8.d.c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g0 f14159b = new g0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f14160c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f14161d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f14162e = new HashSet();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z f14167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j8.l f14168b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f14169c;

        public a(z zVar, j8.l lVar, Map map) {
            this.f14167a = zVar;
            this.f14168b = lVar;
            this.f14169c = map;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            o8.i iVarR = y.this.R(this.f14167a);
            if (iVarR == null) {
                return Collections.EMPTY_LIST;
            }
            j8.l lVarR = j8.l.R(iVarR.e(), this.f14168b);
            j8.b bVarR = j8.b.r(this.f14169c);
            y.this.f14164g.g(this.f14168b, bVarR);
            return y.this.D(iVarR, new k8.c(k8.e.a(iVarR.d()), lVarR, bVarR));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o8.i f14171a;

        public b(o8.i iVar) {
            this.f14171a = iVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            y.this.f14164g.o(this.f14171a);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j8.i f14173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f14174b;

        public c(j8.i iVar, boolean z10) {
            this.f14173a = iVar;
            this.f14174b = z10;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            o8.a aVarI;
            r8.n nVarD;
            o8.i iVarE = this.f14173a.e();
            j8.l lVarE = iVarE.e();
            m8.d dVarR = y.this.f14158a;
            r8.n nVarD2 = null;
            j8.l lVarS = lVarE;
            boolean z10 = false;
            while (!dVarR.isEmpty()) {
                w wVar = (w) dVarR.getValue();
                if (wVar != null) {
                    if (nVarD2 == null) {
                        nVarD2 = wVar.d(lVarS);
                    }
                    z10 = z10 || wVar.h();
                }
                dVarR = dVarR.r(lVarS.isEmpty() ? r8.b.h("") : lVarS.K());
                lVarS = lVarS.S();
            }
            w wVar2 = (w) y.this.f14158a.q(lVarE);
            if (wVar2 == null) {
                wVar2 = new w(y.this.f14164g);
                y yVar = y.this;
                yVar.f14158a = yVar.f14158a.A(lVarE, wVar2);
            } else {
                z10 = z10 || wVar2.h();
                if (nVarD2 == null) {
                    nVarD2 = wVar2.d(j8.l.G());
                }
            }
            y.this.f14164g.o(iVarE);
            if (nVarD2 != null) {
                aVarI = new o8.a(r8.i.d(nVarD2, iVarE.c()), true, false);
            } else {
                aVarI = y.this.f14164g.i(iVarE);
                if (!aVarI.f()) {
                    r8.n nVarY = r8.g.y();
                    for (Map.Entry entry : y.this.f14158a.K(lVarE).s()) {
                        w wVar3 = (w) ((m8.d) entry.getValue()).getValue();
                        if (wVar3 != null && (nVarD = wVar3.d(j8.l.G())) != null) {
                            nVarY = nVarY.t((r8.b) entry.getKey(), nVarD);
                        }
                    }
                    for (r8.m mVar : aVarI.b()) {
                        if (!nVarY.F(mVar.c())) {
                            nVarY = nVarY.t(mVar.c(), mVar.d());
                        }
                    }
                    aVarI = new o8.a(r8.i.d(nVarY, iVarE.c()), false, false);
                }
            }
            boolean zK = wVar2.k(iVarE);
            if (!zK && !iVarE.g()) {
                m8.m.g(!y.this.f14161d.containsKey(iVarE), "View does not exist but we have a tag");
                z zVarM = y.this.M();
                y.this.f14161d.put(iVarE, zVarM);
                y.this.f14160c.put(zVarM, iVarE);
            }
            List listA = wVar2.a(this.f14173a, y.this.f14159b.h(lVarE), aVarI);
            if (!zK && !z10 && !this.f14174b) {
                y.this.Z(iVarE, wVar2.l(iVarE));
            }
            return listA;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o8.i f14176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j8.i f14177b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e8.c f14178c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f14179d;

        public d(o8.i iVar, j8.i iVar2, e8.c cVar, boolean z10) {
            this.f14176a = iVar;
            this.f14177b = iVar2;
            this.f14178c = cVar;
            this.f14179d = z10;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            boolean z10;
            j8.l lVarE = this.f14176a.e();
            w wVar = (w) y.this.f14158a.q(lVarE);
            List arrayList = new ArrayList();
            if (wVar != null && (this.f14176a.f() || wVar.k(this.f14176a))) {
                m8.g gVarJ = wVar.j(this.f14176a, this.f14177b, this.f14178c);
                if (wVar.i()) {
                    y yVar = y.this;
                    yVar.f14158a = yVar.f14158a.w(lVarE);
                }
                List<o8.i> list = (List) gVarJ.a();
                arrayList = (List) gVarJ.b();
                loop0: while (true) {
                    for (o8.i iVar : list) {
                        y.this.f14164g.l(this.f14176a);
                        z10 = z10 || iVar.g();
                    }
                }
                if (this.f14179d) {
                    return null;
                }
                m8.d dVarR = y.this.f14158a;
                boolean z11 = dVarR.getValue() != null && ((w) dVarR.getValue()).h();
                Iterator it = lVarE.iterator();
                while (it.hasNext()) {
                    dVarR = dVarR.r((r8.b) it.next());
                    z11 = z11 || (dVarR.getValue() != null && ((w) dVarR.getValue()).h());
                    if (z11 || dVarR.isEmpty()) {
                        break;
                    }
                }
                if (z10 && !z11) {
                    m8.d dVarK = y.this.f14158a.K(lVarE);
                    if (!dVarK.isEmpty()) {
                        for (o8.j jVar : y.this.K(dVarK)) {
                            r rVar = y.this.new r(jVar);
                            y.this.f14163f.b(y.this.Q(jVar.h()), rVar.f14222b, rVar, rVar);
                        }
                    }
                }
                if (!z11 && !list.isEmpty() && this.f14178c == null) {
                    if (z10) {
                        y.this.f14163f.a(y.this.Q(this.f14176a), null);
                    } else {
                        for (o8.i iVar2 : list) {
                            z zVarA0 = y.this.a0(iVar2);
                            m8.m.f(zVarA0 != null);
                            y.this.f14163f.a(y.this.Q(iVar2), zVarA0);
                        }
                    }
                }
                y.this.X(list);
            }
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e implements d.c {
        public e() {
        }

        @Override // m8.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(j8.l lVar, w wVar, Void r52) {
            if (!lVar.isEmpty() && wVar.h()) {
                o8.i iVarH = wVar.e().h();
                y.this.f14163f.a(y.this.Q(iVarH), y.this.a0(iVarH));
                return null;
            }
            Iterator it = wVar.f().iterator();
            while (it.hasNext()) {
                o8.i iVarH2 = ((o8.j) it.next()).h();
                y.this.f14163f.a(y.this.Q(iVarH2), y.this.a0(iVarH2));
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class f extends h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r8.n f14182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h0 f14183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k8.d f14184c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List f14185d;

        public f(r8.n nVar, h0 h0Var, k8.d dVar, List list) {
            this.f14182a = nVar;
            this.f14183b = h0Var;
            this.f14184c = dVar;
            this.f14185d = list;
        }

        @Override // g8.h.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(r8.b bVar, m8.d dVar) {
            r8.n nVar = this.f14182a;
            r8.n nVarZ = nVar != null ? nVar.z(bVar) : null;
            h0 h0VarH = this.f14183b.h(bVar);
            k8.d dVarD = this.f14184c.d(bVar);
            if (dVarD != null) {
                this.f14185d.addAll(y.this.w(dVarD, dVar, nVarZ, h0VarH));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class g implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f14187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j8.l f14188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ r8.n f14189c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f14190d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ r8.n f14191e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f14192f;

        public g(boolean z10, j8.l lVar, r8.n nVar, long j10, r8.n nVar2, boolean z11) {
            this.f14187a = z10;
            this.f14188b = lVar;
            this.f14189c = nVar;
            this.f14190d = j10;
            this.f14191e = nVar2;
            this.f14192f = z11;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            if (this.f14187a) {
                y.this.f14164g.c(this.f14188b, this.f14189c, this.f14190d);
            }
            y.this.f14159b.b(this.f14188b, this.f14191e, Long.valueOf(this.f14190d), this.f14192f);
            return !this.f14192f ? Collections.EMPTY_LIST : y.this.y(new k8.f(k8.e.f14760d, this.f14188b, this.f14191e));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class h implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f14194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j8.l f14195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j8.b f14196c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f14197d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ j8.b f14198e;

        public h(boolean z10, j8.l lVar, j8.b bVar, long j10, j8.b bVar2) {
            this.f14194a = z10;
            this.f14195b = lVar;
            this.f14196c = bVar;
            this.f14197d = j10;
            this.f14198e = bVar2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            if (this.f14194a) {
                y.this.f14164g.e(this.f14195b, this.f14196c, this.f14197d);
            }
            y.this.f14159b.a(this.f14195b, this.f14198e, Long.valueOf(this.f14197d));
            return y.this.y(new k8.c(k8.e.f14760d, this.f14195b, this.f14198e));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class i implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f14200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f14201b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f14202c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ m8.a f14203d;

        public i(boolean z10, long j10, boolean z11, m8.a aVar) {
            this.f14200a = z10;
            this.f14201b = j10;
            this.f14202c = z11;
            this.f14203d = aVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            if (this.f14200a) {
                y.this.f14164g.b(this.f14201b);
            }
            c0 c0VarI = y.this.f14159b.i(this.f14201b);
            boolean zM = y.this.f14159b.m(this.f14201b);
            if (c0VarI.f() && !this.f14202c) {
                Map mapC = t.c(this.f14203d);
                if (c0VarI.e()) {
                    y.this.f14164g.k(c0VarI.c(), t.g(c0VarI.b(), y.this, c0VarI.c(), mapC));
                } else {
                    y.this.f14164g.f(c0VarI.c(), t.f(c0VarI.a(), y.this, c0VarI.c(), mapC));
                }
            }
            if (!zM) {
                return Collections.EMPTY_LIST;
            }
            m8.d dVarC = m8.d.c();
            if (c0VarI.e()) {
                dVarC = dVarC.A(j8.l.G(), Boolean.TRUE);
            } else {
                Iterator it = c0VarI.a().iterator();
                while (it.hasNext()) {
                    dVarC = dVarC.A((j8.l) ((Map.Entry) it.next()).getKey(), Boolean.TRUE);
                }
            }
            return y.this.y(new k8.a(c0VarI.c(), dVarC, this.f14202c));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class j implements Callable {
        public j() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            y.this.f14164g.a();
            if (y.this.f14159b.k().isEmpty()) {
                return Collections.EMPTY_LIST;
            }
            return y.this.y(new k8.a(j8.l.G(), new m8.d(Boolean.TRUE), true));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class k implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j8.l f14206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r8.n f14207b;

        public k(j8.l lVar, r8.n nVar) {
            this.f14206a = lVar;
            this.f14207b = nVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            y.this.f14164g.p(o8.i.a(this.f14206a), this.f14207b);
            return y.this.y(new k8.f(k8.e.f14761e, this.f14206a, this.f14207b));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class l implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f14209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j8.l f14210b;

        public l(Map map, j8.l lVar) {
            this.f14209a = map;
            this.f14210b = lVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            j8.b bVarR = j8.b.r(this.f14209a);
            y.this.f14164g.g(this.f14210b, bVarR);
            return y.this.y(new k8.c(k8.e.f14761e, this.f14210b, bVarR));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class m implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j8.l f14212a;

        public m(j8.l lVar) {
            this.f14212a = lVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            y.this.f14164g.n(o8.i.a(this.f14212a));
            return y.this.y(new k8.b(k8.e.f14761e, this.f14212a));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class n implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z f14214a;

        public n(z zVar) {
            this.f14214a = zVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            o8.i iVarR = y.this.R(this.f14214a);
            if (iVarR == null) {
                return Collections.EMPTY_LIST;
            }
            y.this.f14164g.n(iVarR);
            return y.this.D(iVarR, new k8.b(k8.e.a(iVarR.d()), j8.l.G()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class o implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z f14216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j8.l f14217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ r8.n f14218c;

        public o(z zVar, j8.l lVar, r8.n nVar) {
            this.f14216a = zVar;
            this.f14217b = lVar;
            this.f14218c = nVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            o8.i iVarR = y.this.R(this.f14216a);
            if (iVarR == null) {
                return Collections.EMPTY_LIST;
            }
            j8.l lVarR = j8.l.R(iVarR.e(), this.f14217b);
            y.this.f14164g.p(lVarR.isEmpty() ? iVarR : o8.i.a(this.f14217b), this.f14218c);
            return y.this.D(iVarR, new k8.f(k8.e.a(iVarR.d()), lVarR, this.f14218c));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface p {
        List c(e8.c cVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class r implements h8.g, p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o8.j f14221a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z f14222b;

        public r(o8.j jVar) {
            this.f14221a = jVar;
            this.f14222b = y.this.a0(jVar.h());
        }

        @Override // h8.g
        public h8.a a() {
            r8.d dVarB = r8.d.b(this.f14221a.i());
            List listE = dVarB.e();
            ArrayList arrayList = new ArrayList(listE.size());
            Iterator it = listE.iterator();
            while (it.hasNext()) {
                arrayList.add(((j8.l) it.next()).s());
            }
            return new h8.a(arrayList, dVarB.d());
        }

        @Override // h8.g
        public boolean b() {
            return m8.e.b(this.f14221a.i()) > 1024;
        }

        @Override // j8.y.p
        public List c(e8.c cVar) {
            if (cVar == null) {
                o8.i iVarH = this.f14221a.h();
                z zVar = this.f14222b;
                return zVar != null ? y.this.C(zVar) : y.this.v(iVarH.e());
            }
            y.this.f14165h.i("Listen at " + this.f14221a.h().e() + " failed: " + cVar.toString());
            return y.this.S(this.f14221a.h(), cVar);
        }

        @Override // h8.g
        public String d() {
            return this.f14221a.i().Q();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface s {
        void a(o8.i iVar, z zVar);

        void b(o8.i iVar, z zVar, h8.g gVar, p pVar);
    }

    public y(j8.g gVar, l8.e eVar, s sVar) {
        this.f14163f = sVar;
        this.f14164g = eVar;
        this.f14165h = gVar.q("SyncTree");
    }

    public static /* synthetic */ r8.n a(y yVar, o8.i iVar) {
        yVar.getClass();
        j8.l lVarE = iVar.e();
        m8.d dVarR = yVar.f14158a;
        r8.n nVarD = null;
        j8.l lVarS = lVarE;
        boolean z10 = false;
        while (true) {
            if (dVarR.isEmpty()) {
                break;
            }
            w wVar = (w) dVarR.getValue();
            if (wVar != null) {
                if (nVarD == null) {
                    nVarD = wVar.d(lVarS);
                }
                z10 = z10 || wVar.h();
            }
            dVarR = dVarR.r(lVarS.isEmpty() ? r8.b.h("") : lVarS.K());
            lVarS = lVarS.S();
        }
        w wVar2 = (w) yVar.f14158a.q(lVarE);
        if (wVar2 == null) {
            wVar2 = new w(yVar.f14164g);
            yVar.f14158a = yVar.f14158a.A(lVarE, wVar2);
        } else if (nVarD == null) {
            nVarD = wVar2.d(j8.l.G());
        }
        return wVar2.g(iVar, yVar.f14159b.h(lVarE), new o8.a(r8.i.d(nVarD != null ? nVarD : r8.g.y(), iVar.c()), nVarD != null, false)).d();
    }

    public List A(j8.l lVar, r8.n nVar) {
        return (List) this.f14164g.m(new k(lVar, nVar));
    }

    public List B(j8.l lVar, List list) {
        w wVar = (w) this.f14158a.q(lVar);
        if (wVar == null) {
            return Collections.EMPTY_LIST;
        }
        o8.j jVarE = wVar.e();
        if (jVarE == null) {
            return Collections.EMPTY_LIST;
        }
        r8.n nVarI = jVarE.i();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            nVarI = ((r8.s) it.next()).a(nVarI);
        }
        return A(lVar, nVarI);
    }

    public List C(z zVar) {
        return (List) this.f14164g.m(new n(zVar));
    }

    public final List D(o8.i iVar, k8.d dVar) {
        j8.l lVarE = iVar.e();
        w wVar = (w) this.f14158a.q(lVarE);
        m8.m.g(wVar != null, "Missing sync point for query tag that we're tracking");
        return wVar.b(dVar, this.f14159b.h(lVarE), null);
    }

    public List E(j8.l lVar, Map map, z zVar) {
        return (List) this.f14164g.m(new a(zVar, lVar, map));
    }

    public List F(j8.l lVar, r8.n nVar, z zVar) {
        return (List) this.f14164g.m(new o(zVar, lVar, nVar));
    }

    public List G(j8.l lVar, List list, z zVar) {
        o8.i iVarR = R(zVar);
        if (iVarR == null) {
            return Collections.EMPTY_LIST;
        }
        m8.m.f(lVar.equals(iVarR.e()));
        w wVar = (w) this.f14158a.q(iVarR.e());
        m8.m.g(wVar != null, "Missing sync point for query tag that we're tracking");
        o8.j jVarL = wVar.l(iVarR);
        m8.m.g(jVarL != null, "Missing view for query tag that we're tracking");
        r8.n nVarI = jVarL.i();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            nVarI = ((r8.s) it.next()).a(nVarI);
        }
        return F(lVar, nVarI, zVar);
    }

    public List H(j8.l lVar, j8.b bVar, j8.b bVar2, long j10, boolean z10) {
        return (List) this.f14164g.m(new h(z10, lVar, bVar, j10, bVar2));
    }

    public List I(j8.l lVar, r8.n nVar, r8.n nVar2, long j10, boolean z10, boolean z11) {
        m8.m.g(z10 || !z11, "We shouldn't be persisting non-visible writes.");
        return (List) this.f14164g.m(new g(z11, lVar, nVar, j10, nVar2, z10));
    }

    public r8.n J(j8.l lVar, List list) {
        m8.d dVarR = this.f14158a;
        j8.l lVarG = j8.l.G();
        r8.n nVarD = null;
        j8.l lVarS = lVar;
        do {
            r8.b bVarK = lVarS.K();
            lVarS = lVarS.S();
            lVarG = lVarG.v(bVarK);
            j8.l lVarR = j8.l.R(lVarG, lVar);
            dVarR = bVarK != null ? dVarR.r(bVarK) : m8.d.c();
            w wVar = (w) dVarR.getValue();
            if (wVar != null) {
                nVarD = wVar.d(lVarR);
            }
            if (lVarS.isEmpty()) {
                break;
            }
        } while (nVarD == null);
        return this.f14159b.d(lVar, nVarD, list, true);
    }

    public final List K(m8.d dVar) {
        ArrayList arrayList = new ArrayList();
        L(dVar, arrayList);
        return arrayList;
    }

    public final void L(m8.d dVar, List list) {
        w wVar = (w) dVar.getValue();
        if (wVar != null && wVar.h()) {
            list.add(wVar.e());
            return;
        }
        if (wVar != null) {
            list.addAll(wVar.f());
        }
        Iterator it = dVar.s().iterator();
        while (it.hasNext()) {
            L((m8.d) ((Map.Entry) it.next()).getValue(), list);
        }
    }

    public final z M() {
        long j10 = this.f14166i;
        this.f14166i = 1 + j10;
        return new z(j10);
    }

    public r8.n N(final o8.i iVar) {
        return (r8.n) this.f14164g.m(new Callable() { // from class: j8.x
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return y.a(this.f14156a, iVar);
            }
        });
    }

    public void O(o8.i iVar, boolean z10, boolean z11) {
        if (z10 && !this.f14162e.contains(iVar)) {
            u(new q(iVar), z11);
            this.f14162e.add(iVar);
        } else {
            if (z10 || !this.f14162e.contains(iVar)) {
                return;
            }
            V(new q(iVar), z11);
            this.f14162e.remove(iVar);
        }
    }

    public e8.b P(e8.p pVar) {
        return e8.k.a(pVar.t(), this.f14164g.i(pVar.u()).a());
    }

    public final o8.i Q(o8.i iVar) {
        return (!iVar.g() || iVar.f()) ? iVar : o8.i.a(iVar.e());
    }

    public final o8.i R(z zVar) {
        return (o8.i) this.f14160c.get(zVar);
    }

    public List S(o8.i iVar, e8.c cVar) {
        return W(iVar, null, cVar, false);
    }

    public List T() {
        return (List) this.f14164g.m(new j());
    }

    public List U(j8.i iVar) {
        return W(iVar.e(), iVar, null, false);
    }

    public List V(j8.i iVar, boolean z10) {
        return W(iVar.e(), iVar, null, z10);
    }

    public final List W(o8.i iVar, j8.i iVar2, e8.c cVar, boolean z10) {
        return (List) this.f14164g.m(new d(iVar, iVar2, cVar, z10));
    }

    public final void X(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            o8.i iVar = (o8.i) it.next();
            if (!iVar.g()) {
                z zVarA0 = a0(iVar);
                m8.m.f(zVarA0 != null);
                this.f14161d.remove(iVar);
                this.f14160c.remove(zVarA0);
            }
        }
    }

    public void Y(o8.i iVar) {
        this.f14164g.m(new b(iVar));
    }

    public final void Z(o8.i iVar, o8.j jVar) {
        j8.l lVarE = iVar.e();
        z zVarA0 = a0(iVar);
        r rVar = new r(jVar);
        this.f14163f.b(Q(iVar), zVarA0, rVar, rVar);
        m8.d dVarK = this.f14158a.K(lVarE);
        if (zVarA0 != null) {
            m8.m.g(!((w) dVarK.getValue()).h(), "If we're adding a query, it shouldn't be shadowed");
        } else {
            dVarK.p(new e());
        }
    }

    public z a0(o8.i iVar) {
        return (z) this.f14161d.get(iVar);
    }

    public List s(long j10, boolean z10, boolean z11, m8.a aVar) {
        return (List) this.f14164g.m(new i(z11, j10, z10, aVar));
    }

    public List t(j8.i iVar) {
        return u(iVar, false);
    }

    public List u(j8.i iVar, boolean z10) {
        return (List) this.f14164g.m(new c(iVar, z10));
    }

    public List v(j8.l lVar) {
        return (List) this.f14164g.m(new m(lVar));
    }

    public final List w(k8.d dVar, m8.d dVar2, r8.n nVar, h0 h0Var) {
        w wVar = (w) dVar2.getValue();
        if (nVar == null && wVar != null) {
            nVar = wVar.d(j8.l.G());
        }
        r8.n nVar2 = nVar;
        ArrayList arrayList = new ArrayList();
        dVar2.s().p(new f(nVar2, h0Var, dVar, arrayList));
        if (wVar != null) {
            arrayList.addAll(wVar.b(dVar, h0Var, nVar2));
        }
        return arrayList;
    }

    public final List x(k8.d dVar, m8.d dVar2, r8.n nVar, h0 h0Var) {
        if (dVar.a().isEmpty()) {
            return w(dVar, dVar2, nVar, h0Var);
        }
        w wVar = (w) dVar2.getValue();
        if (nVar == null && wVar != null) {
            nVar = wVar.d(j8.l.G());
        }
        ArrayList arrayList = new ArrayList();
        r8.b bVarK = dVar.a().K();
        k8.d dVarD = dVar.d(bVarK);
        m8.d dVar3 = (m8.d) dVar2.s().c(bVarK);
        if (dVar3 != null && dVarD != null) {
            arrayList.addAll(x(dVarD, dVar3, nVar != null ? nVar.z(bVarK) : null, h0Var.h(bVarK)));
        }
        if (wVar != null) {
            arrayList.addAll(wVar.b(dVar, h0Var, nVar));
        }
        return arrayList;
    }

    public final List y(k8.d dVar) {
        return x(dVar, this.f14158a, null, this.f14159b.h(j8.l.G()));
    }

    public List z(j8.l lVar, Map map) {
        return (List) this.f14164g.m(new l(map, lVar));
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class q extends j8.i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public o8.i f14220d;

        public q(o8.i iVar) {
            this.f14220d = iVar;
        }

        @Override // j8.i
        public j8.i a(o8.i iVar) {
            return new q(iVar);
        }

        @Override // j8.i
        public o8.d b(o8.c cVar, o8.i iVar) {
            return null;
        }

        @Override // j8.i
        public o8.i e() {
            return this.f14220d;
        }

        public boolean equals(Object obj) {
            return (obj instanceof q) && ((q) obj).f14220d.equals(this.f14220d);
        }

        @Override // j8.i
        public boolean f(j8.i iVar) {
            return iVar instanceof q;
        }

        public int hashCode() {
            return this.f14220d.hashCode();
        }

        @Override // j8.i
        public boolean i(e.a aVar) {
            return false;
        }

        @Override // j8.i
        public void c(e8.c cVar) {
        }

        @Override // j8.i
        public void d(o8.d dVar) {
        }
    }
}
