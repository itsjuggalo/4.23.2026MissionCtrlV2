package a6;

import R5.InterfaceC0845b;
import java.util.Collection;
import kotlin.jvm.internal.AbstractC2304t;
import y6.AbstractC2996e;

/* JADX INFO: renamed from: a6.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1090m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1090m f10149a = new C1090m();

    public static final boolean c(InterfaceC0845b it) {
        AbstractC2304t.f(it, "it");
        return f10149a.d(it);
    }

    public final String b(InterfaceC0845b interfaceC0845b) {
        q6.f fVar;
        AbstractC2304t.f(interfaceC0845b, "<this>");
        O5.i.h0(interfaceC0845b);
        InterfaceC0845b interfaceC0845bI = AbstractC2996e.i(AbstractC2996e.w(interfaceC0845b), false, C1089l.f10148a, 1, null);
        if (interfaceC0845bI == null || (fVar = (q6.f) C1087j.f10142a.a().get(AbstractC2996e.o(interfaceC0845bI))) == null) {
            return null;
        }
        return fVar.b();
    }

    public final boolean d(InterfaceC0845b callableMemberDescriptor) {
        AbstractC2304t.f(callableMemberDescriptor, "callableMemberDescriptor");
        if (C1087j.f10142a.d().contains(callableMemberDescriptor.getName())) {
            return e(callableMemberDescriptor);
        }
        return false;
    }

    public final boolean e(InterfaceC0845b interfaceC0845b) {
        if (p5.z.Q(C1087j.f10142a.c(), AbstractC2996e.k(interfaceC0845b)) && interfaceC0845b.k().isEmpty()) {
            return true;
        }
        if (!O5.i.h0(interfaceC0845b)) {
            return false;
        }
        Collection<InterfaceC0845b> collectionF = interfaceC0845b.f();
        AbstractC2304t.e(collectionF, "getOverriddenDescriptors(...)");
        if (!collectionF.isEmpty()) {
            for (InterfaceC0845b interfaceC0845b2 : collectionF) {
                C1090m c1090m = f10149a;
                AbstractC2304t.c(interfaceC0845b2);
                if (c1090m.d(interfaceC0845b2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
