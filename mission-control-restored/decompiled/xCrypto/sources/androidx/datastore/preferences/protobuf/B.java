package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class B implements Z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final I f6910b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f6911a;

    public class a implements I {
        @Override // androidx.datastore.preferences.protobuf.I
        public H a(Class cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // androidx.datastore.preferences.protobuf.I
        public boolean b(Class cls) {
            return false;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6912a;

        static {
            int[] iArr = new int[T.values().length];
            f6912a = iArr;
            try {
                iArr[T.PROTO3.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static class c implements I {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public I[] f6913a;

        public c(I... iArr) {
            this.f6913a = iArr;
        }

        @Override // androidx.datastore.preferences.protobuf.I
        public H a(Class cls) {
            for (I i4 : this.f6913a) {
                if (i4.b(cls)) {
                    return i4.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        @Override // androidx.datastore.preferences.protobuf.I
        public boolean b(Class cls) {
            for (I i4 : this.f6913a) {
                if (i4.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public B() {
        this(c());
    }

    public static boolean b(H h4) {
        return b.f6912a[h4.c().ordinal()] != 1;
    }

    public static I c() {
        return new c(C0805s.c(), d());
    }

    public static I d() {
        if (U.f6956d) {
            return f6910b;
        }
        try {
            return (I) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return f6910b;
        }
    }

    public static Y e(Class cls, H h4) {
        if (f(cls)) {
            return M.N(cls, h4, Q.b(), A.b(), a0.K(), b(h4) ? AbstractC0803p.b() : null, G.b());
        }
        O oA = Q.a();
        AbstractC0801n abstractC0801nA = null;
        InterfaceC0811y interfaceC0811yA = A.a();
        f0 f0VarJ = a0.J();
        if (b(h4)) {
            abstractC0801nA = AbstractC0803p.a();
        }
        return M.N(cls, h4, oA, interfaceC0811yA, f0VarJ, abstractC0801nA, G.a());
    }

    public static boolean f(Class cls) {
        return U.f6956d || AbstractC0806t.class.isAssignableFrom(cls);
    }

    @Override // androidx.datastore.preferences.protobuf.Z
    public Y a(Class cls) {
        a0.G(cls);
        H hA = this.f6911a.a(cls);
        return hA.a() ? f(cls) ? N.l(a0.K(), AbstractC0803p.b(), hA.b()) : N.l(a0.J(), AbstractC0803p.a(), hA.b()) : e(cls, hA);
    }

    public B(I i4) {
        this.f6911a = (I) AbstractC0807u.b(i4, "messageInfoFactory");
    }
}
