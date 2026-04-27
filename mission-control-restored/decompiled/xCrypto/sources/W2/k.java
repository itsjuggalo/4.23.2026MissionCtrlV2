package W2;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5479a;

        static {
            int[] iArr = new int[l.values().length];
            try {
                iArr[l.f5480a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[l.f5481b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[l.f5482c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f5479a = iArr;
        }
    }

    public static j a(l mode, Function0 initializer) {
        kotlin.jvm.internal.r.f(mode, "mode");
        kotlin.jvm.internal.r.f(initializer, "initializer");
        int i4 = a.f5479a[mode.ordinal()];
        if (i4 == 1) {
            return new s(initializer, null, 2, null);
        }
        if (i4 == 2) {
            return new r(initializer);
        }
        if (i4 == 3) {
            return new F(initializer);
        }
        throw new m();
    }

    public static j b(Function0 initializer) {
        kotlin.jvm.internal.r.f(initializer, "initializer");
        return new s(initializer, null, 2, null);
    }
}
