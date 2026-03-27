package u6;

import R5.InterfaceC0845b;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: u6.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2798m extends AbstractC2799n {
    @Override // u6.AbstractC2799n
    public void b(InterfaceC0845b first, InterfaceC0845b second) {
        AbstractC2304t.f(first, "first");
        AbstractC2304t.f(second, "second");
        e(first, second);
    }

    @Override // u6.AbstractC2799n
    public void c(InterfaceC0845b fromSuper, InterfaceC0845b fromCurrent) {
        AbstractC2304t.f(fromSuper, "fromSuper");
        AbstractC2304t.f(fromCurrent, "fromCurrent");
        e(fromSuper, fromCurrent);
    }

    public abstract void e(InterfaceC0845b interfaceC0845b, InterfaceC0845b interfaceC0845b2);
}
