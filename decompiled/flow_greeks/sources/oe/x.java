package oe;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f18100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f18101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f18102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f18103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map f18104e;

    static {
        c cVar = c.f17946d;
        c cVar2 = c.f17944b;
        c cVar3 = c.f17945c;
        List listN = dd.r.n(cVar, cVar2, cVar3, c.f17948f, c.f17947e);
        f18100a = listN;
        List listE = dd.q.e(cVar3);
        f18101b = listE;
        ef.c cVarK = j0.k();
        we.k kVar = we.k.f23994c;
        Map mapL = dd.o0.l(cd.w.a(cVarK, new w(new we.l(kVar, false, 2, null), listN, false)), cd.w.a(j0.i(), new w(new we.l(kVar, false, 2, null), listN, false)), cd.w.a(j0.j(), new w(new we.l(we.k.f23992a, false, 2, null), listN, false, 4, null)));
        f18102c = mapL;
        Map mapL2 = dd.o0.l(cd.w.a(j0.d(), new w(new we.l(kVar, false, 2, null), listE, false, 4, null)), cd.w.a(j0.e(), new w(new we.l(we.k.f23993b, false, 2, null), listE, false, 4, null)));
        f18103d = mapL2;
        f18104e = dd.o0.p(mapL, mapL2);
    }

    public static final Map a() {
        return f18104e;
    }

    public static final Map b() {
        return f18102c;
    }
}
