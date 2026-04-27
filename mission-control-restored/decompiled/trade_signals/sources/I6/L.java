package I6;

import kotlin.jvm.internal.AbstractC2304t;
import o5.C2487o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class L {
    public static final I a(S s8) {
        AbstractC2304t.f(s8, "<this>");
        M0 m0R0 = s8.R0();
        AbstractC2304t.d(m0R0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return (I) m0R0;
    }

    public static final boolean b(S s8) {
        AbstractC2304t.f(s8, "<this>");
        return s8.R0() instanceof I;
    }

    public static final AbstractC0613d0 c(S s8) {
        AbstractC2304t.f(s8, "<this>");
        M0 m0R0 = s8.R0();
        if (m0R0 instanceof I) {
            return ((I) m0R0).W0();
        }
        if (m0R0 instanceof AbstractC0613d0) {
            return (AbstractC0613d0) m0R0;
        }
        throw new C2487o();
    }

    public static final AbstractC0613d0 d(S s8) {
        AbstractC2304t.f(s8, "<this>");
        M0 m0R0 = s8.R0();
        if (m0R0 instanceof I) {
            return ((I) m0R0).X0();
        }
        if (m0R0 instanceof AbstractC0613d0) {
            return (AbstractC0613d0) m0R0;
        }
        throw new C2487o();
    }
}
