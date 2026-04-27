package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class N implements p0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final V f10961b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V f10962a;

    public class a implements V {
        @Override // com.google.protobuf.V
        public U a(Class cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // com.google.protobuf.V
        public boolean b(Class cls) {
            return false;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10963a;

        static {
            int[] iArr = new int[i0.values().length];
            f10963a = iArr;
            try {
                iArr[i0.PROTO3.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static class c implements V {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public V[] f10964a;

        public c(V... vArr) {
            this.f10964a = vArr;
        }

        @Override // com.google.protobuf.V
        public U a(Class cls) {
            for (V v4 : this.f10964a) {
                if (v4.b(cls)) {
                    return v4.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        @Override // com.google.protobuf.V
        public boolean b(Class cls) {
            for (V v4 : this.f10964a) {
                if (v4.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public N() {
        this(c());
    }

    public static boolean b(U u4) {
        return b.f10963a[u4.c().ordinal()] != 1;
    }

    public static V c() {
        return new c(C1076x.c(), d());
    }

    public static V d() {
        try {
            return (V) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return f10961b;
        }
    }

    public static o0 e(Class cls, U u4) {
        return AbstractC1077y.class.isAssignableFrom(cls) ? b(u4) ? Z.S(cls, u4, AbstractC1057d0.b(), L.b(), q0.L(), AbstractC1072t.b(), T.b()) : Z.S(cls, u4, AbstractC1057d0.b(), L.b(), q0.L(), null, T.b()) : b(u4) ? Z.S(cls, u4, AbstractC1057d0.a(), L.a(), q0.K(), AbstractC1072t.a(), T.a()) : Z.S(cls, u4, AbstractC1057d0.a(), L.a(), q0.K(), null, T.a());
    }

    @Override // com.google.protobuf.p0
    public o0 a(Class cls) {
        q0.H(cls);
        U uA = this.f10962a.a(cls);
        return uA.a() ? AbstractC1077y.class.isAssignableFrom(cls) ? C1051a0.m(q0.L(), AbstractC1072t.b(), uA.b()) : C1051a0.m(q0.K(), AbstractC1072t.a(), uA.b()) : e(cls, uA);
    }

    public N(V v4) {
        this.f10962a = (V) C.b(v4, "messageInfoFactory");
    }
}
