package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class B implements Z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final I f16275b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f16276a;

    public class a implements I {
        @Override // com.google.protobuf.I
        public H a(Class cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // com.google.protobuf.I
        public boolean b(Class cls) {
            return false;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16277a;

        static {
            int[] iArr = new int[T.values().length];
            f16277a = iArr;
            try {
                iArr[T.PROTO3.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static class c implements I {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public I[] f16278a;

        public c(I... iArr) {
            this.f16278a = iArr;
        }

        @Override // com.google.protobuf.I
        public H a(Class cls) {
            for (I i8 : this.f16278a) {
                if (i8.b(cls)) {
                    return i8.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        @Override // com.google.protobuf.I
        public boolean b(Class cls) {
            for (I i8 : this.f16278a) {
                if (i8.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public B() {
        this(c());
    }

    public static boolean b(H h8) {
        return b.f16277a[h8.c().ordinal()] != 1;
    }

    public static I c() {
        return new c(C1479s.c(), d());
    }

    public static I d() {
        try {
            return (I) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return f16275b;
        }
    }

    public static Y e(Class cls, H h8) {
        return AbstractC1480t.class.isAssignableFrom(cls) ? b(h8) ? M.O(cls, h8, Q.b(), A.b(), a0.K(), AbstractC1477p.b(), G.b()) : M.O(cls, h8, Q.b(), A.b(), a0.K(), null, G.b()) : b(h8) ? M.O(cls, h8, Q.a(), A.a(), a0.J(), AbstractC1477p.a(), G.a()) : M.O(cls, h8, Q.a(), A.a(), a0.J(), null, G.a());
    }

    @Override // com.google.protobuf.Z
    public Y a(Class cls) {
        f0 f0VarJ;
        AbstractC1475n abstractC1475nA;
        a0.G(cls);
        H hA = this.f16276a.a(cls);
        if (!hA.a()) {
            return e(cls, hA);
        }
        if (AbstractC1480t.class.isAssignableFrom(cls)) {
            f0VarJ = a0.K();
            abstractC1475nA = AbstractC1477p.b();
        } else {
            f0VarJ = a0.J();
            abstractC1475nA = AbstractC1477p.a();
        }
        return N.l(f0VarJ, abstractC1475nA, hA.b());
    }

    public B(I i8) {
        this.f16276a = (I) AbstractC1481u.b(i8, "messageInfoFactory");
    }
}
