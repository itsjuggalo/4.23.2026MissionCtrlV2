package pe;

import cd.w;
import ce.o;
import dd.o0;
import java.util.Map;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ wd.m[] f18607h = {n0.g(new g0(l.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0))};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final wf.i f18608g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(ve.a annotation, re.k c10) {
        super(c10, annotation, o.a.L);
        t.f(annotation, "annotation");
        t.f(c10, "c");
        this.f18608g = c10.e().e(new k(this));
    }

    public static final Map i(l lVar) {
        lf.g gVarB = f.f18598a.b(lVar.c());
        Map mapE = gVarB != null ? dd.n0.e(w.a(d.f18592a.c(), gVarB)) : null;
        return mapE == null ? o0.h() : mapE;
    }

    @Override // pe.c, ge.c
    public Map a() {
        return (Map) wf.m.a(this.f18608g, this, f18607h[0]);
    }
}
