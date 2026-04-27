package b6;

import O5.o;
import h6.InterfaceC1892a;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.O;
import o5.w;
import p5.L;
import p5.M;

/* JADX INFO: renamed from: b6.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1236l extends C1227c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ I5.m[] f13208h = {O.g(new G(C1236l.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0))};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final H6.i f13209g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1236l(InterfaceC1892a annotation, d6.k c8) {
        super(c8, annotation, o.a.f6143L);
        AbstractC2304t.f(annotation, "annotation");
        AbstractC2304t.f(c8, "c");
        this.f13209g = c8.e().e(new C1235k(this));
    }

    public static final Map i(C1236l c1236l) {
        w6.g gVarB = C1230f.f13199a.b(c1236l.c());
        Map mapE = gVarB != null ? L.e(w.a(C1228d.f13193a.c(), gVarB)) : null;
        return mapE == null ? M.h() : mapE;
    }

    @Override // b6.C1227c, S5.c
    public Map a() {
        return (Map) H6.m.a(this.f13209g, this, f13208h[0]);
    }
}
