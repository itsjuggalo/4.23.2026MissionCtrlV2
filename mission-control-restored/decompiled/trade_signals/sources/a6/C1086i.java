package a6;

import R5.InterfaceC0845b;
import R5.InterfaceC0868z;
import a6.U;
import j6.AbstractC2229C;
import kotlin.jvm.internal.AbstractC2304t;
import y6.AbstractC2996e;

/* JADX INFO: renamed from: a6.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1086i extends U {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final C1086i f10141o = new C1086i();

    public static final InterfaceC0868z l(InterfaceC0868z functionDescriptor) {
        AbstractC2304t.f(functionDescriptor, "functionDescriptor");
        C1086i c1086i = f10141o;
        q6.f name = functionDescriptor.getName();
        AbstractC2304t.e(name, "getName(...)");
        if (c1086i.n(name)) {
            return (InterfaceC0868z) AbstractC2996e.i(functionDescriptor, false, C1084g.f10139a, 1, null);
        }
        return null;
    }

    public static final boolean m(InterfaceC0845b it) {
        AbstractC2304t.f(it, "it");
        return f10141o.k(it);
    }

    public static final U.b o(InterfaceC0845b interfaceC0845b) {
        InterfaceC0845b interfaceC0845bI;
        String strD;
        AbstractC2304t.f(interfaceC0845b, "<this>");
        U.a aVar = U.f10090a;
        if (!aVar.d().contains(interfaceC0845b.getName()) || (interfaceC0845bI = AbstractC2996e.i(interfaceC0845b, false, C1085h.f10140a, 1, null)) == null || (strD = AbstractC2229C.d(interfaceC0845bI)) == null) {
            return null;
        }
        return aVar.l(strD);
    }

    public static final boolean p(InterfaceC0845b it) {
        AbstractC2304t.f(it, "it");
        return (it instanceof InterfaceC0868z) && f10141o.k(it);
    }

    public final boolean k(InterfaceC0845b interfaceC0845b) {
        return p5.z.Q(U.f10090a.e(), AbstractC2229C.d(interfaceC0845b));
    }

    public final boolean n(q6.f fVar) {
        AbstractC2304t.f(fVar, "<this>");
        return U.f10090a.d().contains(fVar);
    }
}
