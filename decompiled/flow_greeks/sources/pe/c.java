package pe;

import dd.a0;
import dd.o0;
import fe.g1;
import java.util.Collection;
import java.util.Map;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import xf.c1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class c implements qe.g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ wd.m[] f18586f = {n0.g(new g0(c.class, "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ef.c f18587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g1 f18588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wf.i f18589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ve.b f18590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f18591e;

    public c(re.k c10, ve.a aVar, ef.c fqName) {
        g1 NO_SOURCE;
        Collection collectionF;
        t.f(c10, "c");
        t.f(fqName, "fqName");
        this.f18587a = fqName;
        if (aVar == null || (NO_SOURCE = c10.a().t().a(aVar)) == null) {
            NO_SOURCE = g1.f9483a;
            t.e(NO_SOURCE, "NO_SOURCE");
        }
        this.f18588b = NO_SOURCE;
        this.f18589c = c10.e().e(new b(c10, this));
        this.f18590d = (aVar == null || (collectionF = aVar.f()) == null) ? null : (ve.b) a0.a0(collectionF);
        boolean z10 = false;
        if (aVar != null && aVar.d()) {
            z10 = true;
        }
        this.f18591e = z10;
    }

    public static final c1 g(re.k kVar, c cVar) {
        c1 c1VarS = kVar.d().p().p(cVar.e()).s();
        t.e(c1VarS, "getDefaultType(...)");
        return c1VarS;
    }

    @Override // ge.c
    public Map a() {
        return o0.h();
    }

    public final ve.b c() {
        return this.f18590d;
    }

    @Override // qe.g
    public boolean d() {
        return this.f18591e;
    }

    @Override // ge.c
    public ef.c e() {
        return this.f18587a;
    }

    @Override // ge.c
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public c1 getType() {
        return (c1) wf.m.a(this.f18589c, this, f18586f[0]);
    }

    @Override // ge.c
    public g1 j() {
        return this.f18588b;
    }
}
