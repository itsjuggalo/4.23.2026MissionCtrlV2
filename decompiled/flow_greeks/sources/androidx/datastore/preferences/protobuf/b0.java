package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 implements y0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i0 f1662b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f1663a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements i0 {
        @Override // androidx.datastore.preferences.protobuf.i0
        public h0 a(Class cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // androidx.datastore.preferences.protobuf.i0
        public boolean b(Class cls) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1664a;

        static {
            int[] iArr = new int[s0.values().length];
            f1664a = iArr;
            try {
                iArr[s0.PROTO3.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c implements i0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public i0[] f1665a;

        public c(i0... i0VarArr) {
            this.f1665a = i0VarArr;
        }

        @Override // androidx.datastore.preferences.protobuf.i0
        public h0 a(Class cls) {
            for (i0 i0Var : this.f1665a) {
                if (i0Var.b(cls)) {
                    return i0Var.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        @Override // androidx.datastore.preferences.protobuf.i0
        public boolean b(Class cls) {
            for (i0 i0Var : this.f1665a) {
                if (i0Var.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public b0() {
        this(c());
    }

    public static boolean b(h0 h0Var) {
        return b.f1664a[h0Var.c().ordinal()] != 1;
    }

    public static i0 c() {
        return new c(s.c(), d());
    }

    public static i0 d() {
        if (t0.f1908d) {
            return f1662b;
        }
        try {
            return (i0) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return f1662b;
        }
    }

    public static x0 e(Class cls, h0 h0Var) {
        if (f(cls)) {
            return m0.N(cls, h0Var, q0.b(), a0.b(), z0.K(), b(h0Var) ? p.b() : null, g0.b());
        }
        o0 o0VarA = q0.a();
        n nVarA = null;
        y yVarA = a0.a();
        e1 e1VarJ = z0.J();
        if (b(h0Var)) {
            nVarA = p.a();
        }
        return m0.N(cls, h0Var, o0VarA, yVarA, e1VarJ, nVarA, g0.a());
    }

    public static boolean f(Class cls) {
        return t0.f1908d || t.class.isAssignableFrom(cls);
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public x0 a(Class cls) {
        z0.G(cls);
        h0 h0VarA = this.f1663a.a(cls);
        return h0VarA.a() ? f(cls) ? n0.l(z0.K(), p.b(), h0VarA.b()) : n0.l(z0.J(), p.a(), h0VarA.b()) : e(cls, h0VarA);
    }

    public b0(i0 i0Var) {
        this.f1663a = (i0) u.b(i0Var, "messageInfoFactory");
    }
}
