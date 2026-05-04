package de;

import cd.h;
import ce.o;
import dd.a0;
import dd.j0;
import dd.q;
import dd.r;
import dd.s;
import de.f;
import fe.e0;
import fe.g1;
import fe.h0;
import fe.j1;
import fe.l1;
import fe.n0;
import fe.u;
import fe.y;
import ie.t0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import qf.k;
import wf.n;
import xf.c2;
import xf.m2;
import xf.q1;
import xf.u0;
import xf.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends ie.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f8045n = new a(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ef.b f8046o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ef.b f8047p;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n f8048f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n0 f8049g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f8050h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f8051i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final C0148b f8052j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f8053k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List f8054l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f8055m;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: de.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class C0148b extends xf.b {
        public C0148b() {
            super(b.this.f8048f);
        }

        @Override // xf.v, xf.u1
        /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
        public b b() {
            return b.this;
        }

        @Override // xf.u1
        public boolean d() {
            return true;
        }

        @Override // xf.u1
        public List getParameters() {
            return b.this.f8054l;
        }

        @Override // xf.p
        public Collection r() {
            List<ef.b> listN;
            f fVarU0 = b.this.U0();
            f.a aVar = f.a.f8069e;
            if (t.b(fVarU0, aVar)) {
                listN = q.e(b.f8046o);
            } else if (t.b(fVarU0, f.b.f8070e)) {
                listN = r.n(b.f8047p, new ef.b(o.A, aVar.c(b.this.Q0())));
            } else {
                f.d dVar = f.d.f8072e;
                if (t.b(fVarU0, dVar)) {
                    listN = q.e(b.f8046o);
                } else {
                    if (!t.b(fVarU0, f.c.f8071e)) {
                        ig.a.b(null, 1, null);
                        throw new h();
                    }
                    listN = r.n(b.f8047p, new ef.b(o.f3965s, dVar.c(b.this.Q0())));
                }
            }
            h0 h0VarB = b.this.f8049g.b();
            ArrayList arrayList = new ArrayList(s.u(listN, 10));
            for (ef.b bVar : listN) {
                fe.e eVarB = y.b(h0VarB, bVar);
                if (eVarB == null) {
                    throw new IllegalStateException(("Built-in class " + bVar + " not found").toString());
                }
                List listC0 = a0.C0(getParameters(), eVarB.k().getParameters().size());
                ArrayList arrayList2 = new ArrayList(s.u(listC0, 10));
                Iterator it = listC0.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new c2(((l1) it.next()).s()));
                }
                arrayList.add(u0.h(q1.f25042b.k(), eVarB, arrayList2));
            }
            return a0.I0(arrayList);
        }

        public String toString() {
            return b().toString();
        }

        @Override // xf.p
        public j1 v() {
            return j1.a.f9488a;
        }
    }

    static {
        ef.c cVar = o.A;
        ef.f fVarK = ef.f.k("Function");
        t.e(fVarK, "identifier(...)");
        f8046o = new ef.b(cVar, fVarK);
        ef.c cVar2 = o.f3970x;
        ef.f fVarK2 = ef.f.k("KFunction");
        t.e(fVarK2, "identifier(...)");
        f8047p = new ef.b(cVar2, fVarK2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(n storageManager, n0 containingDeclaration, f functionTypeKind, int i10) {
        super(storageManager, functionTypeKind.c(i10));
        t.f(storageManager, "storageManager");
        t.f(containingDeclaration, "containingDeclaration");
        t.f(functionTypeKind, "functionTypeKind");
        this.f8048f = storageManager;
        this.f8049g = containingDeclaration;
        this.f8050h = functionTypeKind;
        this.f8051i = i10;
        this.f8052j = new C0148b();
        this.f8053k = new d(storageManager, this);
        ArrayList arrayList = new ArrayList();
        vd.g gVar = new vd.g(1, i10);
        ArrayList arrayList2 = new ArrayList(s.u(gVar, 10));
        Iterator it = gVar.iterator();
        while (it.hasNext()) {
            int iNextInt = ((j0) it).nextInt();
            m2 m2Var = m2.f25016f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append('P');
            sb2.append(iNextInt);
            K0(arrayList, this, m2Var, sb2.toString());
            arrayList2.add(cd.h0.f3852a);
        }
        K0(arrayList, this, m2.f25017g, "R");
        this.f8054l = a0.I0(arrayList);
        this.f8055m = c.f8057a.a(this.f8050h);
    }

    public static final void K0(ArrayList arrayList, b bVar, m2 m2Var, String str) {
        arrayList.add(t0.R0(bVar, ge.h.L.b(), false, m2Var, ef.f.k(str), arrayList.size(), bVar.f8048f));
    }

    @Override // fe.e
    public boolean E() {
        return false;
    }

    @Override // fe.d0
    public boolean E0() {
        return false;
    }

    @Override // fe.e
    public boolean H0() {
        return false;
    }

    @Override // fe.d0
    public boolean N() {
        return false;
    }

    @Override // fe.i
    public boolean P() {
        return false;
    }

    public final int Q0() {
        return this.f8051i;
    }

    public Void R0() {
        return null;
    }

    @Override // fe.e
    public /* bridge */ /* synthetic */ fe.d S() {
        return (fe.d) Y0();
    }

    @Override // fe.e
    /* JADX INFO: renamed from: S0, reason: merged with bridge method [inline-methods] */
    public List m() {
        return r.k();
    }

    @Override // fe.e, fe.n, fe.m
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
    public n0 b() {
        return this.f8049g;
    }

    public final f U0() {
        return this.f8050h;
    }

    @Override // fe.e
    public /* bridge */ /* synthetic */ fe.e V() {
        return (fe.e) R0();
    }

    @Override // fe.e
    /* JADX INFO: renamed from: V0, reason: merged with bridge method [inline-methods] */
    public List K() {
        return r.k();
    }

    @Override // fe.e
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public k.b T() {
        return k.b.f19087b;
    }

    @Override // ie.z
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public d I(yf.g kotlinTypeRefiner) {
        t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.f8053k;
    }

    public Void Y0() {
        return null;
    }

    @Override // ge.a
    public ge.h getAnnotations() {
        return ge.h.L.b();
    }

    @Override // fe.e, fe.d0, fe.q
    public u getVisibility() {
        u PUBLIC = fe.t.f9511e;
        t.e(PUBLIC, "PUBLIC");
        return PUBLIC;
    }

    @Override // fe.e
    public fe.f h() {
        return fe.f.f9474c;
    }

    @Override // fe.d0
    public boolean isExternal() {
        return false;
    }

    @Override // fe.e
    public boolean isInline() {
        return false;
    }

    @Override // fe.p
    public g1 j() {
        g1 NO_SOURCE = g1.f9483a;
        t.e(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    @Override // fe.h
    public u1 k() {
        return this.f8052j;
    }

    @Override // fe.e, fe.d0
    public e0 l() {
        return e0.f9464e;
    }

    @Override // fe.e
    public boolean n() {
        return false;
    }

    public String toString() {
        String strB = getName().b();
        t.e(strB, "asString(...)");
        return strB;
    }

    @Override // fe.e, fe.i
    public List v() {
        return this.f8054l;
    }

    @Override // fe.e
    public boolean y() {
        return false;
    }

    @Override // fe.e
    public fe.q1 y0() {
        return null;
    }
}
