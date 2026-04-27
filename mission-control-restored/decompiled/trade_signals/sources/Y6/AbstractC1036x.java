package Y6;

import o5.C2490r;

/* JADX INFO: renamed from: Y6.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1036x {
    public static final InterfaceC1034v a(InterfaceC1033u0 interfaceC1033u0) {
        return new C1035w(interfaceC1033u0);
    }

    public static /* synthetic */ InterfaceC1034v b(InterfaceC1033u0 interfaceC1033u0, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            interfaceC1033u0 = null;
        }
        return a(interfaceC1033u0);
    }

    public static final boolean c(InterfaceC1034v interfaceC1034v, Object obj) {
        Throwable thE = C2490r.e(obj);
        return thE == null ? interfaceC1034v.X(obj) : interfaceC1034v.T(thE);
    }
}
