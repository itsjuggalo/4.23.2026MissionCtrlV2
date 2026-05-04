package zf;

import dd.r;
import dd.u0;
import fe.g0;
import fe.h0;
import fe.o;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f26468a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ef.f f26469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List f26470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List f26471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set f26472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final cd.k f26473f;

    static {
        ef.f fVarO = ef.f.o(b.f26459e.b());
        t.e(fVarO, "special(...)");
        f26469b = fVarO;
        f26470c = r.k();
        f26471d = r.k();
        f26472e = u0.d();
        f26473f = cd.l.b(d.f26467a);
    }

    public static final ce.g I() {
        return ce.g.f3898h.a();
    }

    @Override // fe.h0
    public boolean A0(h0 targetModule) {
        t.f(targetModule, "targetModule");
        return false;
    }

    @Override // fe.h0
    public Object B(g0 capability) {
        t.f(capability, "capability");
        return null;
    }

    @Override // fe.h0
    public fe.u0 I0(ef.c fqName) {
        t.f(fqName, "fqName");
        throw new IllegalStateException("Should not be called!");
    }

    @Override // fe.m
    public fe.m b() {
        return null;
    }

    @Override // ge.a
    public ge.h getAnnotations() {
        return ge.h.L.b();
    }

    @Override // fe.j0
    public ef.f getName() {
        return z0();
    }

    @Override // fe.h0
    public ce.i p() {
        return (ce.i) f26473f.getValue();
    }

    @Override // fe.h0
    public List r0() {
        return f26471d;
    }

    @Override // fe.h0
    public Collection t(ef.c fqName, pd.k nameFilter) {
        t.f(fqName, "fqName");
        t.f(nameFilter, "nameFilter");
        return r.k();
    }

    @Override // fe.m
    public Object t0(o visitor, Object obj) {
        t.f(visitor, "visitor");
        return null;
    }

    public ef.f z0() {
        return f26469b;
    }

    @Override // fe.m
    public fe.m a() {
        return this;
    }
}
