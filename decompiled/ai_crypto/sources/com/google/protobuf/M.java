package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class M implements o0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final U f12586b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final U f12587a;

    public class a implements U {
        @Override // com.google.protobuf.U
        public T a(Class cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // com.google.protobuf.U
        public boolean b(Class cls) {
            return false;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12588a;

        static {
            int[] iArr = new int[h0.values().length];
            f12588a = iArr;
            try {
                iArr[h0.PROTO3.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static class c implements U {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public U[] f12589a;

        public c(U... uArr) {
            this.f12589a = uArr;
        }

        @Override // com.google.protobuf.U
        public T a(Class cls) {
            for (U u7 : this.f12589a) {
                if (u7.b(cls)) {
                    return u7.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        @Override // com.google.protobuf.U
        public boolean b(Class cls) {
            for (U u7 : this.f12589a) {
                if (u7.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public M() {
        this(c());
    }

    public static boolean b(T t7) {
        return b.f12588a[t7.c().ordinal()] != 1;
    }

    public static U c() {
        return new c(C1254x.c(), d());
    }

    public static U d() {
        try {
            return (U) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return f12586b;
        }
    }

    public static n0 e(Class cls, T t7) {
        return AbstractC1255y.class.isAssignableFrom(cls) ? b(t7) ? Y.S(cls, t7, AbstractC1234c0.b(), K.b(), p0.K(), AbstractC1250t.b(), S.b()) : Y.S(cls, t7, AbstractC1234c0.b(), K.b(), p0.K(), null, S.b()) : b(t7) ? Y.S(cls, t7, AbstractC1234c0.a(), K.a(), p0.J(), AbstractC1250t.a(), S.a()) : Y.S(cls, t7, AbstractC1234c0.a(), K.a(), p0.J(), null, S.a());
    }

    @Override // com.google.protobuf.o0
    public n0 a(Class cls) {
        p0.G(cls);
        T tA = this.f12587a.a(cls);
        return tA.a() ? AbstractC1255y.class.isAssignableFrom(cls) ? Z.m(p0.K(), AbstractC1250t.b(), tA.b()) : Z.m(p0.J(), AbstractC1250t.a(), tA.b()) : e(cls, tA);
    }

    public M(U u7) {
        this.f12587a = (U) C.b(u7, "messageInfoFactory");
    }
}
