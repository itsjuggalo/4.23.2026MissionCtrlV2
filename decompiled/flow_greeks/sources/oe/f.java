package oe;

import fe.f1;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends t0 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final f f17966o = new f();

    public static final boolean l(f1 f1Var, fe.b it) {
        kotlin.jvm.internal.t.f(it, "it");
        return t0.f18060a.j().containsKey(xe.c0.d(f1Var));
    }

    public final ef.f j(f1 functionDescriptor) {
        kotlin.jvm.internal.t.f(functionDescriptor, "functionDescriptor");
        Map mapJ = t0.f18060a.j();
        String strD = xe.c0.d(functionDescriptor);
        if (strD == null) {
            return null;
        }
        return (ef.f) mapJ.get(strD);
    }

    public final boolean k(f1 functionDescriptor) {
        kotlin.jvm.internal.t.f(functionDescriptor, "functionDescriptor");
        return ce.i.h0(functionDescriptor) && nf.e.i(functionDescriptor, false, new e(functionDescriptor), 1, null) != null;
    }

    public final boolean m(f1 f1Var) {
        kotlin.jvm.internal.t.f(f1Var, "<this>");
        return kotlin.jvm.internal.t.b(f1Var.getName().b(), "removeAt") && kotlin.jvm.internal.t.b(xe.c0.d(f1Var), t0.f18060a.h().d());
    }
}
