package cd;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3862a;

        static {
            int[] iArr = new int[n.values().length];
            try {
                iArr[n.f3863a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[n.f3864b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[n.f3865c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f3862a = iArr;
        }
    }

    public static k a(n mode, Function0 initializer) {
        kotlin.jvm.internal.t.f(mode, "mode");
        kotlin.jvm.internal.t.f(initializer, "initializer");
        int i10 = a.f3862a[mode.ordinal()];
        if (i10 == 1) {
            return new u(initializer, null, 2, null);
        }
        if (i10 == 2) {
            return new t(initializer);
        }
        if (i10 == 3) {
            return new i0(initializer);
        }
        throw new o();
    }

    public static k b(Function0 initializer) {
        kotlin.jvm.internal.t.f(initializer, "initializer");
        return new u(initializer, null, 2, null);
    }
}
