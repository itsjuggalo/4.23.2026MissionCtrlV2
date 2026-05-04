package bh;

import bh.e;
import cd.w;
import dd.a0;
import dd.g0;
import dd.n;
import dd.o0;
import dd.s;
import dh.d1;
import dh.k1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements e, dh.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f3383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f3385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f3386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String[] f3387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e[] f3388g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List[] f3389h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean[] f3390i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map f3391j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e[] f3392k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final cd.k f3393l;

    public h(String serialName, l kind, int i10, List typeParameters, a builder) {
        t.f(serialName, "serialName");
        t.f(kind, "kind");
        t.f(typeParameters, "typeParameters");
        t.f(builder, "builder");
        this.f3382a = serialName;
        this.f3383b = kind;
        this.f3384c = i10;
        this.f3385d = builder.c();
        this.f3386e = a0.G0(builder.f());
        String[] strArr = (String[]) builder.f().toArray(new String[0]);
        this.f3387f = strArr;
        this.f3388g = d1.b(builder.e());
        this.f3389h = (List[]) builder.d().toArray(new List[0]);
        this.f3390i = a0.D0(builder.g());
        Iterable<g0> iterableM0 = n.M0(strArr);
        ArrayList arrayList = new ArrayList(s.u(iterableM0, 10));
        for (g0 g0Var : iterableM0) {
            arrayList.add(w.a(g0Var.d(), Integer.valueOf(g0Var.c())));
        }
        this.f3391j = o0.t(arrayList);
        this.f3392k = d1.b(typeParameters);
        this.f3393l = cd.l.b(new Function0() { // from class: bh.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(h.d(this.f3380a));
            }
        });
    }

    public static final int d(h hVar) {
        return k1.a(hVar, hVar.f3392k);
    }

    public static final CharSequence f(h hVar, int i10) {
        return hVar.m(i10) + ": " + hVar.o(i10).i();
    }

    @Override // dh.l
    public Set a() {
        return this.f3386e;
    }

    public final int e() {
        return ((Number) this.f3393l.getValue()).intValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        e eVar = (e) obj;
        if (!t.b(i(), eVar.i()) || !Arrays.equals(this.f3392k, ((h) obj).f3392k) || l() != eVar.l()) {
            return false;
        }
        int iL = l();
        for (int i10 = 0; i10 < iL; i10++) {
            if (!t.b(o(i10).i(), eVar.o(i10).i()) || !t.b(o(i10).h(), eVar.o(i10).h())) {
                return false;
            }
        }
        return true;
    }

    @Override // bh.e
    public List getAnnotations() {
        return this.f3385d;
    }

    @Override // bh.e
    public l h() {
        return this.f3383b;
    }

    public int hashCode() {
        return e();
    }

    @Override // bh.e
    public String i() {
        return this.f3382a;
    }

    @Override // bh.e
    public boolean isInline() {
        return e.a.b(this);
    }

    @Override // bh.e
    public boolean j() {
        return e.a.c(this);
    }

    @Override // bh.e
    public int k(String name) {
        t.f(name, "name");
        Integer num = (Integer) this.f3391j.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // bh.e
    public int l() {
        return this.f3384c;
    }

    @Override // bh.e
    public String m(int i10) {
        return this.f3387f[i10];
    }

    @Override // bh.e
    public List n(int i10) {
        return this.f3389h[i10];
    }

    @Override // bh.e
    public e o(int i10) {
        return this.f3388g[i10];
    }

    @Override // bh.e
    public boolean p(int i10) {
        return this.f3390i[i10];
    }

    public String toString() {
        return a0.i0(vd.l.l(0, l()), ", ", i() + '(', ")", 0, null, new pd.k() { // from class: bh.g
            @Override // pd.k
            public final Object invoke(Object obj) {
                return h.f(this.f3381a, ((Integer) obj).intValue());
            }
        }, 24, null);
    }
}
