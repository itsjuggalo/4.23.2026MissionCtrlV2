package ge;

import cd.w;
import dd.a0;
import dd.o0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f10579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap f10581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set f10583e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set f10585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List f10587g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List f10589h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final List f10591i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final List f10593j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final List f10595k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final List f10597l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final List f10599m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final List f10601n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final List f10603o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final List f10605p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final List f10607q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final List f10609r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final /* synthetic */ r[] f10610r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Map f10611s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final /* synthetic */ jd.a f10612s0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f10621b;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final r f10613t = new r("CLASS", 0, "class", false, 2, null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final r f10614u = new r("ANNOTATION_CLASS", 1, "annotation class", false, 2, null);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final r f10615v = new r("TYPE_PARAMETER", 2, "type parameter", false);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final r f10616w = new r("PROPERTY", 3, "property", false, 2, null);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final r f10617x = new r("FIELD", 4, "field", false, 2, null);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final r f10618y = new r("LOCAL_VARIABLE", 5, "local variable", false, 2, null);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final r f10619z = new r("VALUE_PARAMETER", 6, "value parameter", false, 2, null);
    public static final r A = new r("CONSTRUCTOR", 7, "constructor", false, 2, null);
    public static final r B = new r("FUNCTION", 8, "function", false, 2, null);
    public static final r C = new r("PROPERTY_GETTER", 9, "getter", false, 2, null);
    public static final r D = new r("PROPERTY_SETTER", 10, "setter", false, 2, null);
    public static final r E = new r("TYPE", 11, "type usage", false);
    public static final r F = new r("EXPRESSION", 12, "expression", false);
    public static final r G = new r("FILE", 13, "file", false);
    public static final r H = new r("TYPEALIAS", 14, "typealias", false);
    public static final r I = new r("TYPE_PROJECTION", 15, "type projection", false);
    public static final r Q = new r("STAR_PROJECTION", 16, "star projection", false);
    public static final r R = new r("PROPERTY_PARAMETER", 17, "property constructor parameter", false);
    public static final r S = new r("CLASS_ONLY", 18, "class", false);
    public static final r T = new r("OBJECT", 19, "object", false);
    public static final r U = new r("STANDALONE_OBJECT", 20, "standalone object", false);
    public static final r V = new r("COMPANION_OBJECT", 21, "companion object", false);
    public static final r W = new r("INTERFACE", 22, "interface", false);
    public static final r X = new r("ENUM_CLASS", 23, "enum class", false);
    public static final r Y = new r("ENUM_ENTRY", 24, "enum entry", false);
    public static final r Z = new r("LOCAL_CLASS", 25, "local class", false);

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final r f10577a0 = new r("LOCAL_FUNCTION", 26, "local function", false);

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final r f10578b0 = new r("MEMBER_FUNCTION", 27, "member function", false);

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final r f10580c0 = new r("TOP_LEVEL_FUNCTION", 28, "top level function", false);

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final r f10582d0 = new r("MEMBER_PROPERTY", 29, "member property", false);

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final r f10584e0 = new r("MEMBER_PROPERTY_WITH_BACKING_FIELD", 30, "member property with backing field", false);

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final r f10586f0 = new r("MEMBER_PROPERTY_WITH_DELEGATE", 31, "member property with delegate", false);

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final r f10588g0 = new r("MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 32, "member property without backing field or delegate", false);

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final r f10590h0 = new r("TOP_LEVEL_PROPERTY", 33, "top level property", false);

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final r f10592i0 = new r("TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD", 34, "top level property with backing field", false);

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final r f10594j0 = new r("TOP_LEVEL_PROPERTY_WITH_DELEGATE", 35, "top level property with delegate", false);

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final r f10596k0 = new r("TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 36, "top level property without backing field or delegate", false);

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final r f10598l0 = new r("BACKING_FIELD", 37, "backing field", false, 2, null);

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final r f10600m0 = new r("INITIALIZER", 38, "initializer", false);

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final r f10602n0 = new r("DESTRUCTURING_DECLARATION", 39, "destructuring declaration", false);

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final r f10604o0 = new r("LAMBDA_EXPRESSION", 40, "lambda expression", false);

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final r f10606p0 = new r("ANONYMOUS_FUNCTION", 41, "anonymous function", false);

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final r f10608q0 = new r("OBJECT_LITERAL", 42, "object literal", false);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    static {
        r[] rVarArrA = a();
        f10610r0 = rVarArrA;
        f10612s0 = jd.b.a(rVarArrA);
        f10579c = new a(null);
        f10581d = new HashMap();
        for (r rVar : b()) {
            f10581d.put(rVar.name(), rVar);
        }
        jd.a aVarB = b();
        ArrayList arrayList = new ArrayList();
        for (Object obj : aVarB) {
            if (((r) obj).f10621b) {
                arrayList.add(obj);
            }
        }
        f10583e = a0.N0(arrayList);
        f10585f = a0.N0(b());
        r rVar2 = f10614u;
        r rVar3 = f10613t;
        f10587g = dd.r.n(rVar2, rVar3);
        f10589h = dd.r.n(Z, rVar3);
        f10591i = dd.r.n(S, rVar3);
        r rVar4 = V;
        r rVar5 = T;
        f10593j = dd.r.n(rVar4, rVar5, rVar3);
        f10595k = dd.r.n(U, rVar5, rVar3);
        f10597l = dd.r.n(W, rVar3);
        f10599m = dd.r.n(X, rVar3);
        r rVar6 = Y;
        r rVar7 = f10616w;
        r rVar8 = f10617x;
        f10601n = dd.r.n(rVar6, rVar7, rVar8);
        r rVar9 = D;
        f10603o = dd.q.e(rVar9);
        r rVar10 = C;
        f10605p = dd.q.e(rVar10);
        f10607q = dd.q.e(B);
        r rVar11 = G;
        f10609r = dd.q.e(rVar11);
        e eVar = e.f10545h;
        r rVar12 = f10619z;
        f10611s = o0.l(w.a(eVar, rVar12), w.a(e.f10539b, rVar8), w.a(e.f10541d, rVar7), w.a(e.f10540c, rVar11), w.a(e.f10542e, rVar10), w.a(e.f10543f, rVar9), w.a(e.f10544g, rVar12), w.a(e.f10546i, rVar12), w.a(e.f10547j, rVar8));
    }

    public r(String str, int i10, String str2, boolean z10) {
        this.f10620a = str2;
        this.f10621b = z10;
    }

    public static final /* synthetic */ r[] a() {
        return new r[]{f10613t, f10614u, f10615v, f10616w, f10617x, f10618y, f10619z, A, B, C, D, E, F, G, H, I, Q, R, S, T, U, V, W, X, Y, Z, f10577a0, f10578b0, f10580c0, f10582d0, f10584e0, f10586f0, f10588g0, f10590h0, f10592i0, f10594j0, f10596k0, f10598l0, f10600m0, f10602n0, f10604o0, f10606p0, f10608q0};
    }

    public static jd.a b() {
        return f10612s0;
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) f10610r0.clone();
    }

    public /* synthetic */ r(String str, int i10, String str2, boolean z10, int i11, kotlin.jvm.internal.k kVar) {
        this(str, i10, str2, (i11 & 2) != 0 ? true : z10);
    }
}
