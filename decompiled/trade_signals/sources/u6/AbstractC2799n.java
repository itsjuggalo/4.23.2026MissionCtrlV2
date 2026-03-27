package u6;

import R5.InterfaceC0845b;
import java.util.Collection;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: u6.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2799n {
    public abstract void a(InterfaceC0845b interfaceC0845b);

    public abstract void b(InterfaceC0845b interfaceC0845b, InterfaceC0845b interfaceC0845b2);

    public abstract void c(InterfaceC0845b interfaceC0845b, InterfaceC0845b interfaceC0845b2);

    public void d(InterfaceC0845b member, Collection overridden) {
        AbstractC2304t.f(member, "member");
        AbstractC2304t.f(overridden, "overridden");
        member.z0(overridden);
    }
}
