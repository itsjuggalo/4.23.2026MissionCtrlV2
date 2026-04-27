package S5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2296k;
import o5.w;
import p5.AbstractC2594p;
import p5.AbstractC2595q;
import p5.M;
import p5.z;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final r f7684A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final r f7685B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final r f7686C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final r f7687D;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f7706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap f7708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set f7710e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set f7712f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List f7714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List f7716h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final List f7718i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final List f7720j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final List f7722k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final r f7723k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final List f7724l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final List f7726m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final List f7728n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final List f7730o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final List f7732p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final List f7734q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final /* synthetic */ r[] f7735q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final List f7736r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f7737r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Map f7738s;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final r f7742w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final r f7743x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final r f7744y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final r f7745z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f7747b;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final r f7739t = new r("CLASS", 0, "class", false, 2, null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final r f7740u = new r("ANNOTATION_CLASS", 1, "annotation class", false, 2, null);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final r f7741v = new r("TYPE_PARAMETER", 2, "type parameter", false);

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final r f7688E = new r("TYPE", 11, "type usage", false);

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final r f7689F = new r("EXPRESSION", 12, "expression", false);

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final r f7690G = new r("FILE", 13, "file", false);

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static final r f7691H = new r("TYPEALIAS", 14, "typealias", false);

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static final r f7692I = new r("TYPE_PROJECTION", 15, "type projection", false);

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public static final r f7693P = new r("STAR_PROJECTION", 16, "star projection", false);

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public static final r f7694Q = new r("PROPERTY_PARAMETER", 17, "property constructor parameter", false);

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public static final r f7695R = new r("CLASS_ONLY", 18, "class", false);

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public static final r f7696S = new r("OBJECT", 19, "object", false);

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public static final r f7697T = new r("STANDALONE_OBJECT", 20, "standalone object", false);

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static final r f7698U = new r("COMPANION_OBJECT", 21, "companion object", false);

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static final r f7699V = new r("INTERFACE", 22, "interface", false);

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public static final r f7700W = new r("ENUM_CLASS", 23, "enum class", false);

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public static final r f7701X = new r("ENUM_ENTRY", 24, "enum entry", false);

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public static final r f7702Y = new r("LOCAL_CLASS", 25, "local class", false);

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public static final r f7703Z = new r("LOCAL_FUNCTION", 26, "local function", false);

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final r f7704a0 = new r("MEMBER_FUNCTION", 27, "member function", false);

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final r f7705b0 = new r("TOP_LEVEL_FUNCTION", 28, "top level function", false);

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final r f7707c0 = new r("MEMBER_PROPERTY", 29, "member property", false);

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final r f7709d0 = new r("MEMBER_PROPERTY_WITH_BACKING_FIELD", 30, "member property with backing field", false);

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final r f7711e0 = new r("MEMBER_PROPERTY_WITH_DELEGATE", 31, "member property with delegate", false);

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final r f7713f0 = new r("MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 32, "member property without backing field or delegate", false);

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final r f7715g0 = new r("TOP_LEVEL_PROPERTY", 33, "top level property", false);

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final r f7717h0 = new r("TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD", 34, "top level property with backing field", false);

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final r f7719i0 = new r("TOP_LEVEL_PROPERTY_WITH_DELEGATE", 35, "top level property with delegate", false);

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final r f7721j0 = new r("TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 36, "top level property without backing field or delegate", false);

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final r f7725l0 = new r("INITIALIZER", 38, "initializer", false);

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final r f7727m0 = new r("DESTRUCTURING_DECLARATION", 39, "destructuring declaration", false);

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final r f7729n0 = new r("LAMBDA_EXPRESSION", 40, "lambda expression", false);

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final r f7731o0 = new r("ANONYMOUS_FUNCTION", 41, "anonymous function", false);

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final r f7733p0 = new r("OBJECT_LITERAL", 42, "object literal", false);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    static {
        int i8 = 2;
        AbstractC2296k abstractC2296k = null;
        boolean z7 = false;
        f7742w = new r("PROPERTY", 3, "property", z7, i8, abstractC2296k);
        int i9 = 2;
        AbstractC2296k abstractC2296k2 = null;
        boolean z8 = false;
        f7743x = new r("FIELD", 4, "field", z8, i9, abstractC2296k2);
        f7744y = new r("LOCAL_VARIABLE", 5, "local variable", z7, i8, abstractC2296k);
        f7745z = new r("VALUE_PARAMETER", 6, "value parameter", z8, i9, abstractC2296k2);
        f7684A = new r("CONSTRUCTOR", 7, "constructor", z7, i8, abstractC2296k);
        f7685B = new r("FUNCTION", 8, "function", z8, i9, abstractC2296k2);
        f7686C = new r("PROPERTY_GETTER", 9, "getter", z7, i8, abstractC2296k);
        f7687D = new r("PROPERTY_SETTER", 10, "setter", z8, i9, abstractC2296k2);
        f7723k0 = new r("BACKING_FIELD", 37, "backing field", z7, i8, abstractC2296k);
        r[] rVarArrA = a();
        f7735q0 = rVarArrA;
        f7737r0 = AbstractC2875b.a(rVarArrA);
        f7706c = new a(null);
        f7708d = new HashMap();
        for (r rVar : b()) {
            f7708d.put(rVar.name(), rVar);
        }
        InterfaceC2874a interfaceC2874aB = b();
        ArrayList arrayList = new ArrayList();
        for (Object obj : interfaceC2874aB) {
            if (((r) obj).f7747b) {
                arrayList.add(obj);
            }
        }
        f7710e = z.K0(arrayList);
        f7712f = z.K0(b());
        r rVar2 = f7740u;
        r rVar3 = f7739t;
        f7714g = AbstractC2595q.l(rVar2, rVar3);
        f7716h = AbstractC2595q.l(f7702Y, rVar3);
        f7718i = AbstractC2595q.l(f7695R, rVar3);
        r rVar4 = f7698U;
        r rVar5 = f7696S;
        f7720j = AbstractC2595q.l(rVar4, rVar5, rVar3);
        f7722k = AbstractC2595q.l(f7697T, rVar5, rVar3);
        f7724l = AbstractC2595q.l(f7699V, rVar3);
        f7726m = AbstractC2595q.l(f7700W, rVar3);
        r rVar6 = f7701X;
        r rVar7 = f7742w;
        r rVar8 = f7743x;
        f7728n = AbstractC2595q.l(rVar6, rVar7, rVar8);
        r rVar9 = f7687D;
        f7730o = AbstractC2594p.e(rVar9);
        r rVar10 = f7686C;
        f7732p = AbstractC2594p.e(rVar10);
        f7734q = AbstractC2594p.e(f7685B);
        r rVar11 = f7690G;
        f7736r = AbstractC2594p.e(rVar11);
        e eVar = e.f7651h;
        r rVar12 = f7745z;
        f7738s = M.k(w.a(eVar, rVar12), w.a(e.f7645b, rVar8), w.a(e.f7647d, rVar7), w.a(e.f7646c, rVar11), w.a(e.f7648e, rVar10), w.a(e.f7649f, rVar9), w.a(e.f7650g, rVar12), w.a(e.f7652i, rVar12), w.a(e.f7653j, rVar8));
    }

    public r(String str, int i8, String str2, boolean z7) {
        this.f7746a = str2;
        this.f7747b = z7;
    }

    public static final /* synthetic */ r[] a() {
        return new r[]{f7739t, f7740u, f7741v, f7742w, f7743x, f7744y, f7745z, f7684A, f7685B, f7686C, f7687D, f7688E, f7689F, f7690G, f7691H, f7692I, f7693P, f7694Q, f7695R, f7696S, f7697T, f7698U, f7699V, f7700W, f7701X, f7702Y, f7703Z, f7704a0, f7705b0, f7707c0, f7709d0, f7711e0, f7713f0, f7715g0, f7717h0, f7719i0, f7721j0, f7723k0, f7725l0, f7727m0, f7729n0, f7731o0, f7733p0};
    }

    public static InterfaceC2874a b() {
        return f7737r0;
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) f7735q0.clone();
    }

    public /* synthetic */ r(String str, int i8, String str2, boolean z7, int i9, AbstractC2296k abstractC2296k) {
        this(str, i8, str2, (i9 & 2) != 0 ? true : z7);
    }
}
