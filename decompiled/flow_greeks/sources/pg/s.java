package pg;

import cd.h0;
import kotlin.jvm.internal.n0;
import pg.k;
import sg.p0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class s extends e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f18679m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f18680n;

    public s(int i10, a aVar, pd.k kVar) {
        super(i10, kVar);
        this.f18679m = i10;
        this.f18680n = aVar;
        if (aVar == a.f18621a) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + n0.b(e.class).c() + " instead").toString());
        }
        if (i10 >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i10 + " was specified").toString());
    }

    public static /* synthetic */ Object c1(s sVar, Object obj, gd.e eVar) throws Throwable {
        p0 p0VarC;
        Object objE1 = sVar.e1(obj, true);
        if (!(objE1 instanceof k.a)) {
            return h0.f3852a;
        }
        k.e(objE1);
        pd.k kVar = sVar.f18641b;
        if (kVar == null || (p0VarC = sg.w.c(kVar, obj, null, 2, null)) == null) {
            throw sVar.b0();
        }
        cd.e.a(p0VarC, sVar.b0());
        throw p0VarC;
    }

    public final Object d1(Object obj, boolean z10) {
        pd.k kVar;
        p0 p0VarC;
        Object objL = super.l(obj);
        if (k.i(objL) || k.h(objL)) {
            return objL;
        }
        if (!z10 || (kVar = this.f18641b) == null || (p0VarC = sg.w.c(kVar, obj, null, 2, null)) == null) {
            return k.f18669b.c(h0.f3852a);
        }
        throw p0VarC;
    }

    public final Object e1(Object obj, boolean z10) {
        return this.f18680n == a.f18623c ? d1(obj, z10) : S0(obj);
    }

    @Override // pg.e, pg.x
    public Object i(Object obj, gd.e eVar) {
        return c1(this, obj, eVar);
    }

    @Override // pg.e, pg.x
    public Object l(Object obj) {
        return e1(obj, false);
    }

    @Override // pg.e
    public boolean p0() {
        return this.f18680n == a.f18622b;
    }
}
