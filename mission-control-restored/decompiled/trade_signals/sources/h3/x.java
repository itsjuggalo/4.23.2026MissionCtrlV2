package h3;

import e3.h;
import f3.C1744a;
import f3.InterfaceC1750g;
import i3.AbstractC1919d;
import i3.C1916a;
import i3.C1917b;
import i3.C1918c;
import i3.C1920e;
import i3.C1921f;
import j3.InterfaceC2212e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import k3.AbstractC2271e;
import k3.AbstractC2279m;
import k3.C2270d;
import k3.C2273g;
import k3.InterfaceC2267a;
import m3.C2374a;
import m3.C2376c;
import m3.C2377d;
import m3.e;
import o3.C2460c;
import p3.C2548b;
import p3.C2550d;
import p3.C2553g;
import p3.C2555i;
import p3.C2559m;
import p3.C2565s;
import p3.InterfaceC2560n;

/* JADX INFO: loaded from: classes.dex */
public class x {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s f18606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final InterfaceC2212e f18607g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C2460c f18608h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f18609i = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C2270d f18601a = C2270d.d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1862F f18602b = new C1862F();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f18603c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f18604d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f18605e = new HashSet();

    public class a implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f18610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ C1875k f18611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f18612c;

        public a(y yVar, C1875k c1875k, Map map) {
            this.f18610a = yVar;
            this.f18611b = c1875k;
            this.f18612c = map;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            m3.i iVarS = x.this.S(this.f18610a);
            if (iVarS == null) {
                return Collections.emptyList();
            }
            C1875k c1875kR = C1875k.R(iVarS.e(), this.f18611b);
            C1866b c1866bH = C1866b.H(this.f18612c);
            x.this.f18607g.n(this.f18611b, c1866bH);
            return x.this.D(iVarS, new C1918c(C1920e.a(iVarS.d()), c1875kR, c1866bH));
        }
    }

    public class b implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m3.i f18614a;

        public b(m3.i iVar) {
            this.f18614a = iVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            x.this.f18607g.p(this.f18614a);
            return null;
        }
    }

    public class c implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC1872h f18616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f18617b;

        public c(AbstractC1872h abstractC1872h, boolean z7) {
            this.f18616a = abstractC1872h;
            this.f18617b = z7;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            C2374a c2374aI;
            InterfaceC2560n interfaceC2560nD;
            m3.i iVarE = this.f18616a.e();
            C1875k c1875kE = iVarE.e();
            C2270d c2270dH = x.this.f18601a;
            InterfaceC2560n interfaceC2560nD2 = null;
            C1875k c1875kS = c1875kE;
            boolean z7 = false;
            while (!c2270dH.isEmpty()) {
                v vVar = (v) c2270dH.getValue();
                if (vVar != null) {
                    if (interfaceC2560nD2 == null) {
                        interfaceC2560nD2 = vVar.d(c1875kS);
                    }
                    z7 = z7 || vVar.h();
                }
                c2270dH = c2270dH.H(c1875kS.isEmpty() ? C2548b.i("") : c1875kS.P());
                c1875kS = c1875kS.S();
            }
            v vVar2 = (v) x.this.f18601a.F(c1875kE);
            if (vVar2 == null) {
                vVar2 = new v(x.this.f18607g);
                x xVar = x.this;
                xVar.f18601a = xVar.f18601a.N(c1875kE, vVar2);
            } else {
                z7 = z7 || vVar2.h();
                if (interfaceC2560nD2 == null) {
                    interfaceC2560nD2 = vVar2.d(C1875k.O());
                }
            }
            x.this.f18607g.p(iVarE);
            if (interfaceC2560nD2 != null) {
                c2374aI = new C2374a(C2555i.e(interfaceC2560nD2, iVarE.c()), true, false);
            } else {
                c2374aI = x.this.f18607g.i(iVarE);
                if (!c2374aI.f()) {
                    InterfaceC2560n interfaceC2560nM = C2553g.M();
                    for (Map.Entry entry : x.this.f18601a.P(c1875kE).I()) {
                        v vVar3 = (v) ((C2270d) entry.getValue()).getValue();
                        if (vVar3 != null && (interfaceC2560nD = vVar3.d(C1875k.O())) != null) {
                            interfaceC2560nM = interfaceC2560nM.A((C2548b) entry.getKey(), interfaceC2560nD);
                        }
                    }
                    for (C2559m c2559m : c2374aI.b()) {
                        if (!interfaceC2560nM.u(c2559m.c())) {
                            interfaceC2560nM = interfaceC2560nM.A(c2559m.c(), c2559m.d());
                        }
                    }
                    c2374aI = new C2374a(C2555i.e(interfaceC2560nM, iVarE.c()), false, false);
                }
            }
            boolean zK = vVar2.k(iVarE);
            if (!zK && !iVarE.g()) {
                AbstractC2279m.g(!x.this.f18604d.containsKey(iVarE), "View does not exist but we have a tag");
                y yVarM = x.this.M();
                x.this.f18604d.put(iVarE, yVarM);
                x.this.f18603c.put(yVarM, iVarE);
            }
            List listA = vVar2.a(this.f18616a, x.this.f18602b.h(c1875kE), c2374aI);
            if (!zK && !z7 && !this.f18617b) {
                x.this.a0(iVarE, vVar2.l(iVarE));
            }
            return listA;
        }
    }

    public class d implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m3.i f18619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractC1872h f18620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c3.c f18621c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f18622d;

        public d(m3.i iVar, AbstractC1872h abstractC1872h, c3.c cVar, boolean z7) {
            this.f18619a = iVar;
            this.f18620b = abstractC1872h;
            this.f18621c = cVar;
            this.f18622d = z7;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            boolean z7;
            C1875k c1875kE = this.f18619a.e();
            v vVar = (v) x.this.f18601a.F(c1875kE);
            List arrayList = new ArrayList();
            if (vVar != null && (this.f18619a.f() || vVar.k(this.f18619a))) {
                C2273g c2273gJ = vVar.j(this.f18619a, this.f18620b, this.f18621c);
                if (vVar.i()) {
                    x xVar = x.this;
                    xVar.f18601a = xVar.f18601a.L(c1875kE);
                }
                List<m3.i> list = (List) c2273gJ.a();
                arrayList = (List) c2273gJ.b();
                loop0: while (true) {
                    for (m3.i iVar : list) {
                        x.this.f18607g.h(this.f18619a);
                        z7 = z7 || iVar.g();
                    }
                }
                if (this.f18622d) {
                    return null;
                }
                C2270d c2270dH = x.this.f18601a;
                boolean z8 = c2270dH.getValue() != null && ((v) c2270dH.getValue()).h();
                Iterator it = c1875kE.iterator();
                while (it.hasNext()) {
                    c2270dH = c2270dH.H((C2548b) it.next());
                    z8 = z8 || (c2270dH.getValue() != null && ((v) c2270dH.getValue()).h());
                    if (z8 || c2270dH.isEmpty()) {
                        break;
                    }
                }
                if (z7 && !z8) {
                    C2270d c2270dP = x.this.f18601a.P(c1875kE);
                    if (!c2270dP.isEmpty()) {
                        for (m3.j jVar : x.this.K(c2270dP)) {
                            r rVar = x.this.new r(jVar);
                            x.this.f18606f.b(x.this.R(jVar.h()), rVar.f18665b, rVar, rVar);
                        }
                    }
                }
                if (!z8 && !list.isEmpty() && this.f18621c == null) {
                    if (z7) {
                        x.this.f18606f.a(x.this.R(this.f18619a), null);
                    } else {
                        for (m3.i iVar2 : list) {
                            y yVarB0 = x.this.b0(iVar2);
                            AbstractC2279m.f(yVarB0 != null);
                            x.this.f18606f.a(x.this.R(iVar2), yVarB0);
                        }
                    }
                }
                x.this.Y(list);
            }
            return arrayList;
        }
    }

    public class e implements C2270d.c {
        public e() {
        }

        @Override // k3.C2270d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(C1875k c1875k, v vVar, Void r52) {
            if (!c1875k.isEmpty() && vVar.h()) {
                m3.i iVarH = vVar.e().h();
                x.this.f18606f.a(x.this.R(iVarH), x.this.b0(iVarH));
                return null;
            }
            Iterator it = vVar.f().iterator();
            while (it.hasNext()) {
                m3.i iVarH2 = ((m3.j) it.next()).h();
                x.this.f18606f.a(x.this.R(iVarH2), x.this.b0(iVarH2));
            }
            return null;
        }
    }

    public class f extends h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC2560n f18625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ C1863G f18626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbstractC1919d f18627c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List f18628d;

        public f(InterfaceC2560n interfaceC2560n, C1863G c1863g, AbstractC1919d abstractC1919d, List list) {
            this.f18625a = interfaceC2560n;
            this.f18626b = c1863g;
            this.f18627c = abstractC1919d;
            this.f18628d = list;
        }

        @Override // e3.h.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C2548b c2548b, C2270d c2270d) {
            InterfaceC2560n interfaceC2560n = this.f18625a;
            InterfaceC2560n interfaceC2560nZ = interfaceC2560n != null ? interfaceC2560n.z(c2548b) : null;
            C1863G c1863gH = this.f18626b.h(c2548b);
            AbstractC1919d abstractC1919dD = this.f18627c.d(c2548b);
            if (abstractC1919dD != null) {
                this.f18628d.addAll(x.this.w(abstractC1919dD, c2270d, interfaceC2560nZ, c1863gH));
            }
        }
    }

    public class g implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ C1875k f18631b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InterfaceC2560n f18632c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f18633d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ InterfaceC2560n f18634e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f18635f;

        public g(boolean z7, C1875k c1875k, InterfaceC2560n interfaceC2560n, long j8, InterfaceC2560n interfaceC2560n2, boolean z8) {
            this.f18630a = z7;
            this.f18631b = c1875k;
            this.f18632c = interfaceC2560n;
            this.f18633d = j8;
            this.f18634e = interfaceC2560n2;
            this.f18635f = z8;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            if (this.f18630a) {
                x.this.f18607g.c(this.f18631b, this.f18632c, this.f18633d);
            }
            x.this.f18602b.b(this.f18631b, this.f18634e, Long.valueOf(this.f18633d), this.f18635f);
            return !this.f18635f ? Collections.emptyList() : x.this.y(new C1921f(C1920e.f18791d, this.f18631b, this.f18634e));
        }
    }

    public class h implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ C1875k f18638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ C1866b f18639c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f18640d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ C1866b f18641e;

        public h(boolean z7, C1875k c1875k, C1866b c1866b, long j8, C1866b c1866b2) {
            this.f18637a = z7;
            this.f18638b = c1875k;
            this.f18639c = c1866b;
            this.f18640d = j8;
            this.f18641e = c1866b2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            if (this.f18637a) {
                x.this.f18607g.d(this.f18638b, this.f18639c, this.f18640d);
            }
            x.this.f18602b.a(this.f18638b, this.f18641e, Long.valueOf(this.f18640d));
            return x.this.y(new C1918c(C1920e.f18791d, this.f18638b, this.f18641e));
        }
    }

    public class i implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f18644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f18645c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ InterfaceC2267a f18646d;

        public i(boolean z7, long j8, boolean z8, InterfaceC2267a interfaceC2267a) {
            this.f18643a = z7;
            this.f18644b = j8;
            this.f18645c = z8;
            this.f18646d = interfaceC2267a;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            if (this.f18643a) {
                x.this.f18607g.b(this.f18644b);
            }
            C1858B c1858bI = x.this.f18602b.i(this.f18644b);
            boolean zM = x.this.f18602b.m(this.f18644b);
            if (c1858bI.f() && !this.f18645c) {
                Map mapC = h3.s.c(this.f18646d);
                if (c1858bI.e()) {
                    x.this.f18607g.l(c1858bI.c(), h3.s.g(c1858bI.b(), x.this, c1858bI.c(), mapC));
                } else {
                    x.this.f18607g.m(c1858bI.c(), h3.s.f(c1858bI.a(), x.this, c1858bI.c(), mapC));
                }
            }
            if (!zM) {
                return Collections.emptyList();
            }
            C2270d c2270dD = C2270d.d();
            if (c1858bI.e()) {
                c2270dD = c2270dD.N(C1875k.O(), Boolean.TRUE);
            } else {
                Iterator it = c1858bI.a().iterator();
                while (it.hasNext()) {
                    c2270dD = c2270dD.N((C1875k) ((Map.Entry) it.next()).getKey(), Boolean.TRUE);
                }
            }
            return x.this.y(new C1916a(c1858bI.c(), c2270dD, this.f18645c));
        }
    }

    public class j implements Callable {
        public j() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            x.this.f18607g.a();
            if (x.this.f18602b.k().isEmpty()) {
                return Collections.emptyList();
            }
            return x.this.y(new C1916a(C1875k.O(), new C2270d(Boolean.TRUE), true));
        }
    }

    public class k implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C1875k f18649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterfaceC2560n f18650b;

        public k(C1875k c1875k, InterfaceC2560n interfaceC2560n) {
            this.f18649a = c1875k;
            this.f18650b = interfaceC2560n;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            x.this.f18607g.g(m3.i.a(this.f18649a), this.f18650b);
            return x.this.y(new C1921f(C1920e.f18792e, this.f18649a, this.f18650b));
        }
    }

    public class l implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f18652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ C1875k f18653b;

        public l(Map map, C1875k c1875k) {
            this.f18652a = map;
            this.f18653b = c1875k;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            C1866b c1866bH = C1866b.H(this.f18652a);
            x.this.f18607g.n(this.f18653b, c1866bH);
            return x.this.y(new C1918c(C1920e.f18792e, this.f18653b, c1866bH));
        }
    }

    public class m implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C1875k f18655a;

        public m(C1875k c1875k) {
            this.f18655a = c1875k;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            x.this.f18607g.k(m3.i.a(this.f18655a));
            return x.this.y(new C1917b(C1920e.f18792e, this.f18655a));
        }
    }

    public class n implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f18657a;

        public n(y yVar) {
            this.f18657a = yVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            m3.i iVarS = x.this.S(this.f18657a);
            if (iVarS == null) {
                return Collections.emptyList();
            }
            x.this.f18607g.k(iVarS);
            return x.this.D(iVarS, new C1917b(C1920e.a(iVarS.d()), C1875k.O()));
        }
    }

    public class o implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f18659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ C1875k f18660b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InterfaceC2560n f18661c;

        public o(y yVar, C1875k c1875k, InterfaceC2560n interfaceC2560n) {
            this.f18659a = yVar;
            this.f18660b = c1875k;
            this.f18661c = interfaceC2560n;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            m3.i iVarS = x.this.S(this.f18659a);
            if (iVarS == null) {
                return Collections.emptyList();
            }
            C1875k c1875kR = C1875k.R(iVarS.e(), this.f18660b);
            x.this.f18607g.g(c1875kR.isEmpty() ? iVarS : m3.i.a(this.f18660b), this.f18661c);
            return x.this.D(iVarS, new C1921f(C1920e.a(iVarS.d()), c1875kR, this.f18661c));
        }
    }

    public interface p {
        List b(c3.c cVar);
    }

    public class r implements InterfaceC1750g, p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m3.j f18664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final y f18665b;

        public r(m3.j jVar) {
            this.f18664a = jVar;
            this.f18665b = x.this.b0(jVar.h());
        }

        @Override // f3.InterfaceC1750g
        public C1744a a() {
            C2550d c2550dB = C2550d.b(this.f18664a.i());
            List listE = c2550dB.e();
            ArrayList arrayList = new ArrayList(listE.size());
            Iterator it = listE.iterator();
            while (it.hasNext()) {
                arrayList.add(((C1875k) it.next()).I());
            }
            return new C1744a(arrayList, c2550dB.d());
        }

        @Override // h3.x.p
        public List b(c3.c cVar) {
            if (cVar == null) {
                m3.i iVarH = this.f18664a.h();
                y yVar = this.f18665b;
                return yVar != null ? x.this.C(yVar) : x.this.v(iVarH.e());
            }
            x.this.f18608h.i("Listen at " + this.f18664a.h().e() + " failed: " + cVar.toString());
            return x.this.T(this.f18664a.h(), cVar);
        }

        @Override // f3.InterfaceC1750g
        public boolean c() {
            return AbstractC2271e.b(this.f18664a.i()) > 1024;
        }

        @Override // f3.InterfaceC1750g
        public String d() {
            return this.f18664a.i().G();
        }
    }

    public interface s {
        void a(m3.i iVar, y yVar);

        void b(m3.i iVar, y yVar, InterfaceC1750g interfaceC1750g, p pVar);
    }

    public x(AbstractC1870f abstractC1870f, InterfaceC2212e interfaceC2212e, s sVar) {
        this.f18606f = sVar;
        this.f18607g = interfaceC2212e;
        this.f18608h = abstractC1870f.q("SyncTree");
    }

    public List A(C1875k c1875k, InterfaceC2560n interfaceC2560n) {
        return (List) this.f18607g.j(new k(c1875k, interfaceC2560n));
    }

    public List B(C1875k c1875k, List list) {
        v vVar = (v) this.f18601a.F(c1875k);
        if (vVar == null) {
            return Collections.emptyList();
        }
        m3.j jVarE = vVar.e();
        if (jVarE == null) {
            return Collections.emptyList();
        }
        InterfaceC2560n interfaceC2560nI = jVarE.i();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            interfaceC2560nI = ((C2565s) it.next()).a(interfaceC2560nI);
        }
        return A(c1875k, interfaceC2560nI);
    }

    public List C(y yVar) {
        return (List) this.f18607g.j(new n(yVar));
    }

    public final List D(m3.i iVar, AbstractC1919d abstractC1919d) {
        C1875k c1875kE = iVar.e();
        v vVar = (v) this.f18601a.F(c1875kE);
        AbstractC2279m.g(vVar != null, "Missing sync point for query tag that we're tracking");
        return vVar.b(abstractC1919d, this.f18602b.h(c1875kE), null);
    }

    public List E(C1875k c1875k, Map map, y yVar) {
        return (List) this.f18607g.j(new a(yVar, c1875k, map));
    }

    public List F(C1875k c1875k, InterfaceC2560n interfaceC2560n, y yVar) {
        return (List) this.f18607g.j(new o(yVar, c1875k, interfaceC2560n));
    }

    public List G(C1875k c1875k, List list, y yVar) {
        m3.i iVarS = S(yVar);
        if (iVarS == null) {
            return Collections.emptyList();
        }
        AbstractC2279m.f(c1875k.equals(iVarS.e()));
        v vVar = (v) this.f18601a.F(iVarS.e());
        AbstractC2279m.g(vVar != null, "Missing sync point for query tag that we're tracking");
        m3.j jVarL = vVar.l(iVarS);
        AbstractC2279m.g(jVarL != null, "Missing view for query tag that we're tracking");
        InterfaceC2560n interfaceC2560nI = jVarL.i();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            interfaceC2560nI = ((C2565s) it.next()).a(interfaceC2560nI);
        }
        return F(c1875k, interfaceC2560nI, yVar);
    }

    public List H(C1875k c1875k, C1866b c1866b, C1866b c1866b2, long j8, boolean z7) {
        return (List) this.f18607g.j(new h(z7, c1875k, c1866b, j8, c1866b2));
    }

    public List I(C1875k c1875k, InterfaceC2560n interfaceC2560n, InterfaceC2560n interfaceC2560n2, long j8, boolean z7, boolean z8) {
        AbstractC2279m.g(z7 || !z8, "We shouldn't be persisting non-visible writes.");
        return (List) this.f18607g.j(new g(z8, c1875k, interfaceC2560n, j8, interfaceC2560n2, z7));
    }

    public InterfaceC2560n J(C1875k c1875k, List list) {
        C2270d c2270dH = this.f18601a;
        C1875k c1875kO = C1875k.O();
        InterfaceC2560n interfaceC2560nD = null;
        C1875k c1875kS = c1875k;
        do {
            C2548b c2548bP = c1875kS.P();
            c1875kS = c1875kS.S();
            c1875kO = c1875kO.K(c2548bP);
            C1875k c1875kR = C1875k.R(c1875kO, c1875k);
            c2270dH = c2548bP != null ? c2270dH.H(c2548bP) : C2270d.d();
            v vVar = (v) c2270dH.getValue();
            if (vVar != null) {
                interfaceC2560nD = vVar.d(c1875kR);
            }
            if (c1875kS.isEmpty()) {
                break;
            }
        } while (interfaceC2560nD == null);
        return this.f18602b.d(c1875k, interfaceC2560nD, list, true);
    }

    public final List K(C2270d c2270d) {
        ArrayList arrayList = new ArrayList();
        L(c2270d, arrayList);
        return arrayList;
    }

    public final void L(C2270d c2270d, List list) {
        v vVar = (v) c2270d.getValue();
        if (vVar != null && vVar.h()) {
            list.add(vVar.e());
            return;
        }
        if (vVar != null) {
            list.addAll(vVar.f());
        }
        Iterator it = c2270d.I().iterator();
        while (it.hasNext()) {
            L((C2270d) ((Map.Entry) it.next()).getValue(), list);
        }
    }

    public final y M() {
        long j8 = this.f18609i;
        this.f18609i = 1 + j8;
        return new y(j8);
    }

    public InterfaceC2560n N(final m3.i iVar) {
        return (InterfaceC2560n) this.f18607g.j(new Callable() { // from class: h3.w
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f18599a.P(iVar);
            }
        });
    }

    public void O(m3.i iVar, boolean z7, boolean z8) {
        if (z7 && !this.f18605e.contains(iVar)) {
            u(new q(iVar), z8);
            this.f18605e.add(iVar);
        } else {
            if (z7 || !this.f18605e.contains(iVar)) {
                return;
            }
            W(new q(iVar), z8);
            this.f18605e.remove(iVar);
        }
    }

    public final /* synthetic */ InterfaceC2560n P(m3.i iVar) {
        C1875k c1875kE = iVar.e();
        C2270d c2270dH = this.f18601a;
        InterfaceC2560n interfaceC2560nD = null;
        C1875k c1875kS = c1875kE;
        boolean z7 = false;
        while (true) {
            if (c2270dH.isEmpty()) {
                break;
            }
            v vVar = (v) c2270dH.getValue();
            if (vVar != null) {
                if (interfaceC2560nD == null) {
                    interfaceC2560nD = vVar.d(c1875kS);
                }
                z7 = z7 || vVar.h();
            }
            c2270dH = c2270dH.H(c1875kS.isEmpty() ? C2548b.i("") : c1875kS.P());
            c1875kS = c1875kS.S();
        }
        v vVar2 = (v) this.f18601a.F(c1875kE);
        if (vVar2 == null) {
            vVar2 = new v(this.f18607g);
            this.f18601a = this.f18601a.N(c1875kE, vVar2);
        } else if (interfaceC2560nD == null) {
            interfaceC2560nD = vVar2.d(C1875k.O());
        }
        return vVar2.g(iVar, this.f18602b.h(c1875kE), new C2374a(C2555i.e(interfaceC2560nD != null ? interfaceC2560nD : C2553g.M(), iVar.c()), interfaceC2560nD != null, false)).d();
    }

    public c3.b Q(c3.p pVar) {
        return c3.k.a(pVar.t(), this.f18607g.i(pVar.u()).a());
    }

    public final m3.i R(m3.i iVar) {
        return (!iVar.g() || iVar.f()) ? iVar : m3.i.a(iVar.e());
    }

    public final m3.i S(y yVar) {
        return (m3.i) this.f18603c.get(yVar);
    }

    public List T(m3.i iVar, c3.c cVar) {
        return X(iVar, null, cVar, false);
    }

    public List U() {
        return (List) this.f18607g.j(new j());
    }

    public List V(AbstractC1872h abstractC1872h) {
        return X(abstractC1872h.e(), abstractC1872h, null, false);
    }

    public List W(AbstractC1872h abstractC1872h, boolean z7) {
        return X(abstractC1872h.e(), abstractC1872h, null, z7);
    }

    public final List X(m3.i iVar, AbstractC1872h abstractC1872h, c3.c cVar, boolean z7) {
        return (List) this.f18607g.j(new d(iVar, abstractC1872h, cVar, z7));
    }

    public final void Y(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m3.i iVar = (m3.i) it.next();
            if (!iVar.g()) {
                y yVarB0 = b0(iVar);
                AbstractC2279m.f(yVarB0 != null);
                this.f18604d.remove(iVar);
                this.f18603c.remove(yVarB0);
            }
        }
    }

    public void Z(m3.i iVar) {
        this.f18607g.j(new b(iVar));
    }

    public final void a0(m3.i iVar, m3.j jVar) {
        C1875k c1875kE = iVar.e();
        y yVarB0 = b0(iVar);
        r rVar = new r(jVar);
        this.f18606f.b(R(iVar), yVarB0, rVar, rVar);
        C2270d c2270dP = this.f18601a.P(c1875kE);
        if (yVarB0 != null) {
            AbstractC2279m.g(!((v) c2270dP.getValue()).h(), "If we're adding a query, it shouldn't be shadowed");
        } else {
            c2270dP.C(new e());
        }
    }

    public y b0(m3.i iVar) {
        return (y) this.f18604d.get(iVar);
    }

    public List s(long j8, boolean z7, boolean z8, InterfaceC2267a interfaceC2267a) {
        return (List) this.f18607g.j(new i(z8, j8, z7, interfaceC2267a));
    }

    public List t(AbstractC1872h abstractC1872h) {
        return u(abstractC1872h, false);
    }

    public List u(AbstractC1872h abstractC1872h, boolean z7) {
        return (List) this.f18607g.j(new c(abstractC1872h, z7));
    }

    public List v(C1875k c1875k) {
        return (List) this.f18607g.j(new m(c1875k));
    }

    public final List w(AbstractC1919d abstractC1919d, C2270d c2270d, InterfaceC2560n interfaceC2560n, C1863G c1863g) {
        v vVar = (v) c2270d.getValue();
        if (interfaceC2560n == null && vVar != null) {
            interfaceC2560n = vVar.d(C1875k.O());
        }
        ArrayList arrayList = new ArrayList();
        c2270d.I().C(new f(interfaceC2560n, c1863g, abstractC1919d, arrayList));
        if (vVar != null) {
            arrayList.addAll(vVar.b(abstractC1919d, c1863g, interfaceC2560n));
        }
        return arrayList;
    }

    public final List x(AbstractC1919d abstractC1919d, C2270d c2270d, InterfaceC2560n interfaceC2560n, C1863G c1863g) {
        if (abstractC1919d.a().isEmpty()) {
            return w(abstractC1919d, c2270d, interfaceC2560n, c1863g);
        }
        v vVar = (v) c2270d.getValue();
        if (interfaceC2560n == null && vVar != null) {
            interfaceC2560n = vVar.d(C1875k.O());
        }
        ArrayList arrayList = new ArrayList();
        C2548b c2548bP = abstractC1919d.a().P();
        AbstractC1919d abstractC1919dD = abstractC1919d.d(c2548bP);
        C2270d c2270d2 = (C2270d) c2270d.I().d(c2548bP);
        if (c2270d2 != null && abstractC1919dD != null) {
            arrayList.addAll(x(abstractC1919dD, c2270d2, interfaceC2560n != null ? interfaceC2560n.z(c2548bP) : null, c1863g.h(c2548bP)));
        }
        if (vVar != null) {
            arrayList.addAll(vVar.b(abstractC1919d, c1863g, interfaceC2560n));
        }
        return arrayList;
    }

    public final List y(AbstractC1919d abstractC1919d) {
        return x(abstractC1919d, this.f18601a, null, this.f18602b.h(C1875k.O()));
    }

    public List z(C1875k c1875k, Map map) {
        return (List) this.f18607g.j(new l(map, c1875k));
    }

    public static class q extends AbstractC1872h {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public m3.i f18663d;

        public q(m3.i iVar) {
            this.f18663d = iVar;
        }

        @Override // h3.AbstractC1872h
        public AbstractC1872h a(m3.i iVar) {
            return new q(iVar);
        }

        @Override // h3.AbstractC1872h
        public C2377d b(C2376c c2376c, m3.i iVar) {
            return null;
        }

        @Override // h3.AbstractC1872h
        public m3.i e() {
            return this.f18663d;
        }

        public boolean equals(Object obj) {
            return (obj instanceof q) && ((q) obj).f18663d.equals(this.f18663d);
        }

        @Override // h3.AbstractC1872h
        public boolean f(AbstractC1872h abstractC1872h) {
            return abstractC1872h instanceof q;
        }

        public int hashCode() {
            return this.f18663d.hashCode();
        }

        @Override // h3.AbstractC1872h
        public boolean i(e.a aVar) {
            return false;
        }

        @Override // h3.AbstractC1872h
        public void c(c3.c cVar) {
        }

        @Override // h3.AbstractC1872h
        public void d(C2377d c2377d) {
        }
    }
}
