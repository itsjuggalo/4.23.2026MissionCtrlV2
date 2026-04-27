package t6;

import I6.B0;
import R5.EnumC0849f;
import R5.InterfaceC0848e;
import R5.InterfaceC0852i;
import R5.InterfaceC0856m;
import R5.l0;
import R5.t0;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;
import o5.C2487o;
import p5.S;
import t6.InterfaceC2754b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f23380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n f23381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f23382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final n f23383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final n f23384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final n f23385g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final n f23386h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final n f23387i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final n f23388j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final n f23389k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final n f23390l;

    public static final class a {

        /* JADX INFO: renamed from: t6.n$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0406a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f23391a;

            static {
                int[] iArr = new int[EnumC0849f.values().length];
                try {
                    iArr[EnumC0849f.f7234b.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC0849f.f7235c.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC0849f.f7236d.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[EnumC0849f.f7239g.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[EnumC0849f.f7238f.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[EnumC0849f.f7237e.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                f23391a = iArr;
            }
        }

        public a() {
        }

        public final String a(InterfaceC0852i classifier) {
            AbstractC2304t.f(classifier, "classifier");
            if (classifier instanceof l0) {
                return "typealias";
            }
            if (!(classifier instanceof InterfaceC0848e)) {
                throw new AssertionError("Unexpected classifier: " + classifier);
            }
            InterfaceC0848e interfaceC0848e = (InterfaceC0848e) classifier;
            if (interfaceC0848e.y()) {
                return "companion object";
            }
            switch (C0406a.f23391a[interfaceC0848e.i().ordinal()]) {
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
                    throw new C2487o();
            }
        }

        public final n b(B5.k changeOptions) {
            AbstractC2304t.f(changeOptions, "changeOptions");
            z zVar = new z();
            changeOptions.invoke(zVar);
            zVar.q0();
            return new u(zVar);
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public interface b {

        public static final class a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f23392a = new a();

            @Override // t6.n.b
            public void a(t0 parameter, int i8, int i9, StringBuilder builder) {
                AbstractC2304t.f(parameter, "parameter");
                AbstractC2304t.f(builder, "builder");
                if (i8 != i9 - 1) {
                    builder.append(", ");
                }
            }

            @Override // t6.n.b
            public void b(t0 parameter, int i8, int i9, StringBuilder builder) {
                AbstractC2304t.f(parameter, "parameter");
                AbstractC2304t.f(builder, "builder");
            }

            @Override // t6.n.b
            public void c(int i8, StringBuilder builder) {
                AbstractC2304t.f(builder, "builder");
                builder.append("(");
            }

            @Override // t6.n.b
            public void d(int i8, StringBuilder builder) {
                AbstractC2304t.f(builder, "builder");
                builder.append(")");
            }
        }

        void a(t0 t0Var, int i8, int i9, StringBuilder sb);

        void b(t0 t0Var, int i8, int i9, StringBuilder sb);

        void c(int i8, StringBuilder sb);

        void d(int i8, StringBuilder sb);
    }

    static {
        a aVar = new a(null);
        f23379a = aVar;
        f23380b = aVar.b(C2755c.f23368a);
        f23381c = aVar.b(C2757e.f23370a);
        f23382d = aVar.b(C2758f.f23371a);
        f23383e = aVar.b(C2759g.f23372a);
        f23384f = aVar.b(h.f23373a);
        f23385g = aVar.b(i.f23374a);
        f23386h = aVar.b(j.f23375a);
        f23387i = aVar.b(k.f23376a);
        f23388j = aVar.b(l.f23377a);
        f23389k = aVar.b(m.f23378a);
        f23390l = aVar.b(C2756d.f23369a);
    }

    public static final C2470H A(w withOptions) {
        AbstractC2304t.f(withOptions, "$this$withOptions");
        withOptions.d(S.d());
        return C2470H.f21956a;
    }

    public static /* synthetic */ String O(n nVar, S5.c cVar, S5.e eVar, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
        }
        if ((i8 & 2) != 0) {
            eVar = null;
        }
        return nVar.N(cVar, eVar);
    }

    public static final C2470H q(w withOptions) {
        AbstractC2304t.f(withOptions, "$this$withOptions");
        withOptions.e(false);
        withOptions.d(S.d());
        return C2470H.f21956a;
    }

    public static final C2470H r(w withOptions) {
        AbstractC2304t.f(withOptions, "$this$withOptions");
        withOptions.e(false);
        withOptions.d(S.d());
        withOptions.h(true);
        return C2470H.f21956a;
    }

    public static final C2470H s(w withOptions) {
        AbstractC2304t.f(withOptions, "$this$withOptions");
        withOptions.e(false);
        return C2470H.f21956a;
    }

    public static final C2470H t(w withOptions) {
        AbstractC2304t.f(withOptions, "$this$withOptions");
        withOptions.d(S.d());
        withOptions.l(InterfaceC2754b.C0405b.f23366a);
        withOptions.a(D.f23345b);
        return C2470H.f21956a;
    }

    public static final C2470H u(w withOptions) {
        AbstractC2304t.f(withOptions, "$this$withOptions");
        withOptions.i(true);
        withOptions.l(InterfaceC2754b.a.f23365a);
        withOptions.d(v.f23407d);
        return C2470H.f21956a;
    }

    public static final C2470H v(w withOptions) {
        AbstractC2304t.f(withOptions, "$this$withOptions");
        withOptions.d(v.f23406c);
        return C2470H.f21956a;
    }

    public static final C2470H w(w withOptions) {
        AbstractC2304t.f(withOptions, "$this$withOptions");
        withOptions.d(v.f23407d);
        return C2470H.f21956a;
    }

    public static final C2470H x(w withOptions) {
        AbstractC2304t.f(withOptions, "$this$withOptions");
        withOptions.g(F.f23355b);
        withOptions.d(v.f23407d);
        return C2470H.f21956a;
    }

    public static final C2470H y(w withOptions) {
        AbstractC2304t.f(withOptions, "$this$withOptions");
        withOptions.e(false);
        withOptions.d(S.d());
        withOptions.l(InterfaceC2754b.C0405b.f23366a);
        withOptions.p(true);
        withOptions.a(D.f23346c);
        withOptions.k(true);
        withOptions.j(true);
        withOptions.h(true);
        withOptions.c(true);
        return C2470H.f21956a;
    }

    public static final C2470H z(w withOptions) {
        AbstractC2304t.f(withOptions, "$this$withOptions");
        withOptions.l(InterfaceC2754b.C0405b.f23366a);
        withOptions.a(D.f23345b);
        return C2470H.f21956a;
    }

    public abstract String M(InterfaceC0856m interfaceC0856m);

    public abstract String N(S5.c cVar, S5.e eVar);

    public abstract String P(String str, String str2, O5.i iVar);

    public abstract String Q(q6.d dVar);

    public abstract String R(q6.f fVar, boolean z7);

    public abstract String S(I6.S s8);

    public abstract String T(B0 b02);

    public final n U(B5.k changeOptions) {
        AbstractC2304t.f(changeOptions, "changeOptions");
        AbstractC2304t.d(this, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        z zVarS = ((u) this).K0().s();
        changeOptions.invoke(zVarS);
        zVarS.q0();
        return new u(zVarS);
    }
}
