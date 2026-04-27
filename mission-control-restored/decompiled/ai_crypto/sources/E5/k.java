package E5;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1673a;

        static {
            int[] iArr = new int[l.values().length];
            try {
                iArr[l.f1674a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[l.f1675b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[l.f1676c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f1673a = iArr;
        }
    }

    public static j a(l mode, Function0 initializer) {
        kotlin.jvm.internal.r.f(mode, "mode");
        kotlin.jvm.internal.r.f(initializer, "initializer");
        int i7 = a.f1673a[mode.ordinal()];
        if (i7 == 1) {
            return new s(initializer, null, 2, null);
        }
        if (i7 == 2) {
            return new r(initializer);
        }
        if (i7 == 3) {
            return new F(initializer);
        }
        throw new m();
    }

    public static j b(Function0 initializer) {
        kotlin.jvm.internal.r.f(initializer, "initializer");
        return new s(initializer, null, 2, null);
    }
}
