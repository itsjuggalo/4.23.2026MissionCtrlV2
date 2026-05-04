package hf;

import cd.h0;
import dd.u0;
import fe.k1;
import fe.s1;
import hf.b;
import xf.a2;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f11348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n f11349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f11350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final n f11351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final n f11352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final n f11353g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final n f11354h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final n f11355i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final n f11356j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final n f11357k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final n f11358l;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: hf.n$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public /* synthetic */ class C0210a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f11359a;

            static {
                int[] iArr = new int[fe.f.values().length];
                try {
                    iArr[fe.f.f9473b.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[fe.f.f9474c.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[fe.f.f9475d.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[fe.f.f9478g.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[fe.f.f9477f.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[fe.f.f9476e.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                f11359a = iArr;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final String a(fe.i classifier) {
            kotlin.jvm.internal.t.f(classifier, "classifier");
            if (classifier instanceof k1) {
                return "typealias";
            }
            if (!(classifier instanceof fe.e)) {
                throw new AssertionError("Unexpected classifier: " + classifier);
            }
            fe.e eVar = (fe.e) classifier;
            if (eVar.y()) {
                return "companion object";
            }
            switch (C0210a.f11359a[eVar.h().ordinal()]) {
                case 1:
                    return "class";
                case 2:
                    return "interface";
                case 3:
                    return "enum class";
                case 4:
                    return "object";
                case 5:
                    return "annotation class";
                case 6:
                    return "enum entry";
                default:
                    throw new cd.o();
            }
        }

        public final n b(pd.k changeOptions) {
            kotlin.jvm.internal.t.f(changeOptions, "changeOptions");
            z zVar = new z();
            changeOptions.invoke(zVar);
            zVar.q0();
            return new u(zVar);
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f11360a = new a();

            @Override // hf.n.b
            public void a(s1 parameter, int i10, int i11, StringBuilder builder) {
                kotlin.jvm.internal.t.f(parameter, "parameter");
                kotlin.jvm.internal.t.f(builder, "builder");
            }

            @Override // hf.n.b
            public void b(int i10, StringBuilder builder) {
                kotlin.jvm.internal.t.f(builder, "builder");
                builder.append("(");
            }

            @Override // hf.n.b
            public void c(s1 parameter, int i10, int i11, StringBuilder builder) {
                kotlin.jvm.internal.t.f(parameter, "parameter");
                kotlin.jvm.internal.t.f(builder, "builder");
                if (i10 != i11 - 1) {
                    builder.append(", ");
                }
            }

            @Override // hf.n.b
            public void d(int i10, StringBuilder builder) {
                kotlin.jvm.internal.t.f(builder, "builder");
                builder.append(")");
            }
        }

        void a(s1 s1Var, int i10, int i11, StringBuilder sb2);

        void b(int i10, StringBuilder sb2);

        void c(s1 s1Var, int i10, int i11, StringBuilder sb2);

        void d(int i10, StringBuilder sb2);
    }

    static {
        a aVar = new a(null);
        f11347a = aVar;
        f11348b = aVar.b(c.f11317a);
        f11349c = aVar.b(e.f11329a);
        f11350d = aVar.b(f.f11335a);
        f11351e = aVar.b(g.f11340a);
        f11352f = aVar.b(h.f11341a);
        f11353g = aVar.b(i.f11342a);
        f11354h = aVar.b(j.f11343a);
        f11355i = aVar.b(k.f11344a);
        f11356j = aVar.b(l.f11345a);
        f11357k = aVar.b(m.f11346a);
        f11358l = aVar.b(d.f11323a);
    }

    public static final h0 A(w withOptions) {
        kotlin.jvm.internal.t.f(withOptions, "$this$withOptions");
        withOptions.c(u0.d());
        return h0.f3852a;
    }

    public static /* synthetic */ String O(n nVar, ge.c cVar, ge.e eVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
        }
        if ((i10 & 2) != 0) {
            eVar = null;
        }
        return nVar.N(cVar, eVar);
    }

    public static final h0 q(w withOptions) {
        kotlin.jvm.internal.t.f(withOptions, "$this$withOptions");
        withOptions.d(false);
        withOptions.c(u0.d());
        return h0.f3852a;
    }

    public static final h0 r(w withOptions) {
        kotlin.jvm.internal.t.f(withOptions, "$this$withOptions");
        withOptions.d(false);
        withOptions.c(u0.d());
        withOptions.h(true);
        return h0.f3852a;
    }

    public static final h0 s(w withOptions) {
        kotlin.jvm.internal.t.f(withOptions, "$this$withOptions");
        withOptions.d(false);
        return h0.f3852a;
    }

    public static final h0 t(w withOptions) {
        kotlin.jvm.internal.t.f(withOptions, "$this$withOptions");
        withOptions.c(u0.d());
        withOptions.e(b.C0209b.f11314a);
        withOptions.g(d0.f11325b);
        return h0.f3852a;
    }

    public static final h0 u(w withOptions) {
        kotlin.jvm.internal.t.f(withOptions, "$this$withOptions");
        withOptions.i(true);
        withOptions.e(b.a.f11313a);
        withOptions.c(v.f11375d);
        return h0.f3852a;
    }

    public static final h0 v(w withOptions) {
        kotlin.jvm.internal.t.f(withOptions, "$this$withOptions");
        withOptions.c(v.f11374c);
        return h0.f3852a;
    }

    public static final h0 w(w withOptions) {
        kotlin.jvm.internal.t.f(withOptions, "$this$withOptions");
        withOptions.c(v.f11375d);
        return h0.f3852a;
    }

    public static final h0 x(w withOptions) {
        kotlin.jvm.internal.t.f(withOptions, "$this$withOptions");
        withOptions.j(f0.f11337b);
        withOptions.c(v.f11375d);
        return h0.f3852a;
    }

    public static final h0 y(w withOptions) {
        kotlin.jvm.internal.t.f(withOptions, "$this$withOptions");
        withOptions.d(false);
        withOptions.c(u0.d());
        withOptions.e(b.C0209b.f11314a);
        withOptions.p(true);
        withOptions.g(d0.f11326c);
        withOptions.l(true);
        withOptions.k(true);
        withOptions.h(true);
        withOptions.b(true);
        return h0.f3852a;
    }

    public static final h0 z(w withOptions) {
        kotlin.jvm.internal.t.f(withOptions, "$this$withOptions");
        withOptions.e(b.C0209b.f11314a);
        withOptions.g(d0.f11325b);
        return h0.f3852a;
    }

    public abstract String M(fe.m mVar);

    public abstract String N(ge.c cVar, ge.e eVar);

    public abstract String P(String str, String str2, ce.i iVar);

    public abstract String Q(ef.d dVar);

    public abstract String R(ef.f fVar, boolean z10);

    public abstract String S(r0 r0Var);

    public abstract String T(a2 a2Var);

    public final n U(pd.k changeOptions) {
        kotlin.jvm.internal.t.f(changeOptions, "changeOptions");
        kotlin.jvm.internal.t.d(this, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        z zVarS = ((u) this).K0().s();
        changeOptions.invoke(zVarS);
        zVarS.q0();
        return new u(zVarS);
    }
}
