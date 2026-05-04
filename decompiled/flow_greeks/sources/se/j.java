package se;

import fe.s1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import xf.c1;
import xf.h2;
import xf.m2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements qe.g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ wd.m[] f20262i = {kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(j.class, "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(j.class, "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(j.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final re.k f20263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ve.a f20264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wf.j f20265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final wf.i f20266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ue.a f20267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final wf.i f20268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f20269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f20270h;

    public j(re.k c10, ve.a javaAnnotation, boolean z10) {
        kotlin.jvm.internal.t.f(c10, "c");
        kotlin.jvm.internal.t.f(javaAnnotation, "javaAnnotation");
        this.f20263a = c10;
        this.f20264b = javaAnnotation;
        this.f20265c = c10.e().g(new g(this));
        this.f20266d = c10.e().e(new h(this));
        this.f20267e = c10.a().t().a(javaAnnotation);
        this.f20268f = c10.e().e(new i(this));
        this.f20269g = javaAnnotation.d();
        this.f20270h = javaAnnotation.u() || z10;
    }

    public static final Map g(j jVar) {
        Collection<ve.b> collectionF = jVar.f20264b.f();
        ArrayList arrayList = new ArrayList();
        for (ve.b bVar : collectionF) {
            ef.f name = bVar.getName();
            if (name == null) {
                name = oe.i0.f17983c;
            }
            lf.g gVarN = jVar.n(bVar);
            cd.q qVarA = gVarN != null ? cd.w.a(name, gVarN) : null;
            if (qVarA != null) {
                arrayList.add(qVarA);
            }
        }
        return dd.o0.t(arrayList);
    }

    public static final ef.c i(j jVar) {
        ef.b bVarG = jVar.f20264b.g();
        if (bVarG != null) {
            return bVarG.a();
        }
        return null;
    }

    public static final c1 s(j jVar) {
        ef.c cVarE = jVar.e();
        if (cVarE == null) {
            return zf.l.d(zf.k.M0, jVar.f20264b.toString());
        }
        fe.e eVarF = ee.d.f(ee.d.f8701a, cVarE, jVar.f20263a.d().p(), null, 4, null);
        if (eVarF == null) {
            ve.g gVarY = jVar.f20264b.y();
            eVarF = gVarY != null ? jVar.f20263a.a().n().a(gVarY) : null;
            if (eVarF == null) {
                eVarF = jVar.h(cVarE);
            }
        }
        return eVarF.s();
    }

    @Override // ge.c
    public Map a() {
        return (Map) wf.m.a(this.f20268f, this, f20262i[2]);
    }

    @Override // qe.g
    public boolean d() {
        return this.f20269g;
    }

    @Override // ge.c
    public ef.c e() {
        return (ef.c) wf.m.b(this.f20265c, this, f20262i[0]);
    }

    public final fe.e h(ef.c cVar) {
        return fe.y.d(this.f20263a.d(), ef.b.f8779d.c(cVar), this.f20263a.a().b().f().r());
    }

    @Override // ge.c
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public ue.a j() {
        return this.f20267e;
    }

    @Override // ge.c
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public c1 getType() {
        return (c1) wf.m.a(this.f20266d, this, f20262i[1]);
    }

    public final boolean m() {
        return this.f20270h;
    }

    public final lf.g n(ve.b bVar) {
        if (bVar instanceof ve.o) {
            return lf.i.f(lf.i.f15656a, ((ve.o) bVar).getValue(), null, 2, null);
        }
        if (bVar instanceof ve.m) {
            ve.m mVar = (ve.m) bVar;
            return q(mVar.b(), mVar.d());
        }
        if (!(bVar instanceof ve.e)) {
            if (bVar instanceof ve.c) {
                return o(((ve.c) bVar).a());
            }
            if (bVar instanceof ve.h) {
                return r(((ve.h) bVar).c());
            }
            return null;
        }
        ve.e eVar = (ve.e) bVar;
        ef.f name = eVar.getName();
        if (name == null) {
            name = oe.i0.f17983c;
        }
        kotlin.jvm.internal.t.c(name);
        return p(name, eVar.e());
    }

    public final lf.g o(ve.a aVar) {
        return new lf.a(new j(this.f20263a, aVar, false, 4, null));
    }

    public final lf.g p(ef.f fVar, List list) {
        xf.r0 r0VarM;
        if (xf.v0.a(getType())) {
            return null;
        }
        fe.e eVarL = nf.e.l(this);
        kotlin.jvm.internal.t.c(eVarL);
        s1 s1VarB = pe.a.b(fVar, eVarL);
        if (s1VarB == null || (r0VarM = s1VarB.getType()) == null) {
            r0VarM = this.f20263a.a().m().p().m(m2.f25015e, zf.l.d(zf.k.L0, new String[0]));
            kotlin.jvm.internal.t.e(r0VarM, "getArrayType(...)");
        }
        ArrayList arrayList = new ArrayList(dd.s.u(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            lf.g gVarN = n((ve.b) it.next());
            if (gVarN == null) {
                gVarN = new lf.u();
            }
            arrayList.add(gVarN);
        }
        return lf.i.f15656a.c(arrayList, r0VarM);
    }

    public final lf.g q(ef.b bVar, ef.f fVar) {
        if (bVar == null || fVar == null) {
            return null;
        }
        return new lf.k(bVar, fVar);
    }

    public final lf.g r(ve.x xVar) {
        return lf.s.f15674b.a(this.f20263a.g().p(xVar, te.b.b(h2.f24979b, false, false, null, 7, null)));
    }

    public String toString() {
        return hf.n.O(hf.n.f11354h, this, null, 2, null);
    }

    public /* synthetic */ j(re.k kVar, ve.a aVar, boolean z10, int i10, kotlin.jvm.internal.k kVar2) {
        this(kVar, aVar, (i10 & 4) != 0 ? false : z10);
    }
}
