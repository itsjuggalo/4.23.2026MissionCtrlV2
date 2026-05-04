package pe;

import cd.w;
import ce.o;
import java.util.Map;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import lf.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ wd.m[] f18602h = {n0.g(new g0(h.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0))};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final wf.i f18603g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(ve.a aVar, re.k c10) {
        super(c10, aVar, o.a.f4021y);
        t.f(c10, "c");
        this.f18603g = c10.e().e(g.f18601a);
    }

    public static final Map i() {
        return dd.n0.e(w.a(d.f18592a.b(), new x("Deprecated in Java")));
    }

    @Override // pe.c, ge.c
    public Map a() {
        return (Map) wf.m.a(this.f18603g, this, f18602h[0]);
    }
}
