package t2;

import q2.w;
import q2.x;
import s2.AbstractC1771a;
import s2.F;
import x2.C1925a;
import y2.C1946a;

/* JADX INFO: loaded from: classes.dex */
public final class n extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q2.i f14821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q2.e f14822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1925a f14823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x f14824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f14825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f14826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile w f14827g;

    public final class b implements q2.h {
        public b() {
        }
    }

    public static final class c implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C1925a f14829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f14830b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Class f14831c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final q2.i f14832d;

        public c(Object obj, C1925a c1925a, boolean z4, Class cls) {
            q2.i iVar = obj instanceof q2.i ? (q2.i) obj : null;
            this.f14832d = iVar;
            AbstractC1771a.a(iVar != null);
            this.f14829a = c1925a;
            this.f14830b = z4;
            this.f14831c = cls;
        }

        @Override // q2.x
        public w create(q2.e eVar, C1925a c1925a) {
            C1925a c1925a2 = this.f14829a;
            if (c1925a2 != null ? c1925a2.equals(c1925a) || (this.f14830b && this.f14829a.d() == c1925a.c()) : this.f14831c.isAssignableFrom(c1925a.c())) {
                return new n(null, this.f14832d, eVar, c1925a, this);
            }
            return null;
        }
    }

    public n(q2.p pVar, q2.i iVar, q2.e eVar, C1925a c1925a, x xVar, boolean z4) {
        this.f14825e = new b();
        this.f14821a = iVar;
        this.f14822b = eVar;
        this.f14823c = c1925a;
        this.f14824d = xVar;
        this.f14826f = z4;
    }

    private w g() {
        w wVar = this.f14827g;
        if (wVar != null) {
            return wVar;
        }
        w wVarM = this.f14822b.m(this.f14824d, this.f14823c);
        this.f14827g = wVarM;
        return wVarM;
    }

    public static x h(C1925a c1925a, Object obj) {
        return new c(obj, c1925a, c1925a.d() == c1925a.c(), null);
    }

    @Override // q2.w
    public Object c(C1946a c1946a) {
        if (this.f14821a == null) {
            return g().c(c1946a);
        }
        q2.j jVarA = F.a(c1946a);
        if (this.f14826f && jVarA.n()) {
            return null;
        }
        return this.f14821a.a(jVarA, this.f14823c.d(), this.f14825e);
    }

    @Override // q2.w
    public void e(y2.c cVar, Object obj) {
        g().e(cVar, obj);
    }

    @Override // t2.m
    public w f() {
        return g();
    }

    public n(q2.p pVar, q2.i iVar, q2.e eVar, C1925a c1925a, x xVar) {
        this(pVar, iVar, eVar, c1925a, xVar, true);
    }
}
