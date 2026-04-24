package a6;

import R5.InterfaceC0845b;
import R5.g0;
import j6.AbstractC2229C;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import y6.AbstractC2996e;

/* JADX INFO: renamed from: a6.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1083f extends U {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final C1083f f10138o = new C1083f();

    public static final boolean l(g0 g0Var, InterfaceC0845b it) {
        AbstractC2304t.f(it, "it");
        return U.f10090a.j().containsKey(AbstractC2229C.d(g0Var));
    }

    public final q6.f j(g0 functionDescriptor) {
        AbstractC2304t.f(functionDescriptor, "functionDescriptor");
        Map mapJ = U.f10090a.j();
        String strD = AbstractC2229C.d(functionDescriptor);
        if (strD == null) {
            return null;
        }
        return (q6.f) mapJ.get(strD);
    }

    public final boolean k(g0 functionDescriptor) {
        AbstractC2304t.f(functionDescriptor, "functionDescriptor");
        return O5.i.h0(functionDescriptor) && AbstractC2996e.i(functionDescriptor, false, new C1082e(functionDescriptor), 1, null) != null;
    }

    public final boolean m(g0 g0Var) {
        AbstractC2304t.f(g0Var, "<this>");
        return AbstractC2304t.b(g0Var.getName().b(), "removeAt") && AbstractC2304t.b(AbstractC2229C.d(g0Var), U.f10090a.h().d());
    }
}
