package I6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class t0 {
    public static final InterfaceC0642w a(S s8) {
        AbstractC2304t.f(s8, "<this>");
        S5.a aVarR0 = s8.R0();
        InterfaceC0642w interfaceC0642w = aVarR0 instanceof InterfaceC0642w ? (InterfaceC0642w) aVarR0 : null;
        if (interfaceC0642w == null || !interfaceC0642w.C0()) {
            return null;
        }
        return interfaceC0642w;
    }

    public static final boolean b(S s8) {
        AbstractC2304t.f(s8, "<this>");
        S5.a aVarR0 = s8.R0();
        InterfaceC0642w interfaceC0642w = aVarR0 instanceof InterfaceC0642w ? (InterfaceC0642w) aVarR0 : null;
        if (interfaceC0642w != null) {
            return interfaceC0642w.C0();
        }
        return false;
    }
}
