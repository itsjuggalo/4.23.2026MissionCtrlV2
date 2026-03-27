package a6;

import R5.InterfaceC0844a;
import R5.InterfaceC0848e;
import R5.Z;
import e6.AbstractC1702d;
import kotlin.jvm.internal.AbstractC2304t;
import u6.InterfaceC2795j;

/* JADX INFO: renamed from: a6.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1095s implements InterfaceC2795j {
    @Override // u6.InterfaceC2795j
    public InterfaceC2795j.b a(InterfaceC0844a superDescriptor, InterfaceC0844a subDescriptor, InterfaceC0848e interfaceC0848e) {
        AbstractC2304t.f(superDescriptor, "superDescriptor");
        AbstractC2304t.f(subDescriptor, "subDescriptor");
        if (!(subDescriptor instanceof Z) || !(superDescriptor instanceof Z)) {
            return InterfaceC2795j.b.UNKNOWN;
        }
        Z z7 = (Z) subDescriptor;
        Z z8 = (Z) superDescriptor;
        return !AbstractC2304t.b(z7.getName(), z8.getName()) ? InterfaceC2795j.b.UNKNOWN : (AbstractC1702d.a(z7) && AbstractC1702d.a(z8)) ? InterfaceC2795j.b.OVERRIDABLE : (AbstractC1702d.a(z7) || AbstractC1702d.a(z8)) ? InterfaceC2795j.b.INCOMPATIBLE : InterfaceC2795j.b.UNKNOWN;
    }

    @Override // u6.InterfaceC2795j
    public InterfaceC2795j.a b() {
        return InterfaceC2795j.a.BOTH;
    }
}
