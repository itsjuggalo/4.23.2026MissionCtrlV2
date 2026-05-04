package com.google.protobuf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m0 implements n1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t0 f7103b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t0 f7104a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements t0 {
        @Override // com.google.protobuf.t0
        public s0 a(Class cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // com.google.protobuf.t0
        public boolean b(Class cls) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7105a;

        static {
            int[] iArr = new int[g1.values().length];
            f7105a = iArr;
            try {
                iArr[g1.PROTO3.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c implements t0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public t0[] f7106a;

        public c(t0... t0VarArr) {
            this.f7106a = t0VarArr;
        }

        @Override // com.google.protobuf.t0
        public s0 a(Class cls) {
            for (t0 t0Var : this.f7106a) {
                if (t0Var.b(cls)) {
                    return t0Var.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        @Override // com.google.protobuf.t0
        public boolean b(Class cls) {
            for (t0 t0Var : this.f7106a) {
                if (t0Var.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public m0() {
        this(c());
    }

    public static boolean b(s0 s0Var) {
        return b.f7105a[s0Var.c().ordinal()] != 1;
    }

    public static t0 c() {
        return new c(x.c(), d());
    }

    public static t0 d() {
        try {
            return (t0) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return f7103b;
        }
    }

    public static m1 e(Class cls, s0 s0Var) {
        return y.class.isAssignableFrom(cls) ? b(s0Var) ? x0.T(cls, s0Var, b1.b(), k0.b(), o1.K(), t.b(), r0.b()) : x0.T(cls, s0Var, b1.b(), k0.b(), o1.K(), null, r0.b()) : b(s0Var) ? x0.T(cls, s0Var, b1.a(), k0.a(), o1.J(), t.a(), r0.a()) : x0.T(cls, s0Var, b1.a(), k0.a(), o1.J(), null, r0.a());
    }

    @Override // com.google.protobuf.n1
    public m1 a(Class cls) {
        o1.G(cls);
        s0 s0VarA = this.f7104a.a(cls);
        return s0VarA.a() ? y.class.isAssignableFrom(cls) ? y0.m(o1.K(), t.b(), s0VarA.b()) : y0.m(o1.J(), t.a(), s0VarA.b()) : e(cls, s0VarA);
    }

    public m0(t0 t0Var) {
        this.f7104a = (t0) c0.b(t0Var, "messageInfoFactory");
    }
}
