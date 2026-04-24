package o5;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: o5.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2484l {

    /* JADX INFO: renamed from: o5.l$a */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21973a;

        static {
            int[] iArr = new int[EnumC2486n.values().length];
            try {
                iArr[EnumC2486n.f21974a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC2486n.f21975b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC2486n.f21976c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f21973a = iArr;
        }
    }

    public static InterfaceC2483k a(Function0 initializer) {
        AbstractC2304t.f(initializer, "initializer");
        return new u(initializer, null, 2, null);
    }

    public static InterfaceC2483k b(EnumC2486n mode, Function0 initializer) {
        AbstractC2304t.f(mode, "mode");
        AbstractC2304t.f(initializer, "initializer");
        int i8 = a.f21973a[mode.ordinal()];
        if (i8 == 1) {
            return new u(initializer, null, 2, null);
        }
        if (i8 == 2) {
            return new t(initializer);
        }
        if (i8 == 3) {
            return new C2471I(initializer);
        }
        throw new C2487o();
    }
}
