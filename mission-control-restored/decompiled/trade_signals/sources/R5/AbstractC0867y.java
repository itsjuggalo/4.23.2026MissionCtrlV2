package R5;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: R5.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0867y {
    public static final InterfaceC0848e b(H h8, q6.b classId) {
        AbstractC2304t.f(h8, "<this>");
        AbstractC2304t.f(classId, "classId");
        InterfaceC0851h interfaceC0851hC = c(h8, classId);
        if (interfaceC0851hC instanceof InterfaceC0848e) {
            return (InterfaceC0848e) interfaceC0851hC;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final R5.InterfaceC0851h c(R5.H r6, q6.b r7) {
        /*
            Method dump skipped, instruction units count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: R5.AbstractC0867y.c(R5.H, q6.b):R5.h");
    }

    public static final InterfaceC0848e d(H h8, q6.b classId, M notFoundClasses) {
        AbstractC2304t.f(h8, "<this>");
        AbstractC2304t.f(classId, "classId");
        AbstractC2304t.f(notFoundClasses, "notFoundClasses");
        InterfaceC0848e interfaceC0848eB = b(h8, classId);
        return interfaceC0848eB != null ? interfaceC0848eB : notFoundClasses.d(classId, U6.r.J(U6.r.B(U6.o.l(classId, new kotlin.jvm.internal.G() { // from class: R5.y.a
            @Override // kotlin.jvm.internal.G, I5.o
            public Object get(Object obj) {
                return ((q6.b) obj).e();
            }
        }), C0866x.f7287a)));
    }

    public static final int e(q6.b it) {
        AbstractC2304t.f(it, "it");
        return 0;
    }

    public static final l0 f(H h8, q6.b classId) {
        AbstractC2304t.f(h8, "<this>");
        AbstractC2304t.f(classId, "classId");
        InterfaceC0851h interfaceC0851hC = c(h8, classId);
        if (interfaceC0851hC instanceof l0) {
            return (l0) interfaceC0851hC;
        }
        return null;
    }
}
