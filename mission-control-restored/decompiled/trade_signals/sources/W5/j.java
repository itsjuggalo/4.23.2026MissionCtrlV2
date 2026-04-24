package W5;

import E6.InterfaceC0483w;
import R5.InterfaceC0845b;
import R5.InterfaceC0848e;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements InterfaceC0483w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f9299b = new j();

    @Override // E6.InterfaceC0483w
    public void a(InterfaceC0848e descriptor, List unresolvedSuperClasses) {
        AbstractC2304t.f(descriptor, "descriptor");
        AbstractC2304t.f(unresolvedSuperClasses, "unresolvedSuperClasses");
        throw new IllegalStateException("Incomplete hierarchy for class " + descriptor.getName() + ", unresolved classes " + unresolvedSuperClasses);
    }

    @Override // E6.InterfaceC0483w
    public void b(InterfaceC0845b descriptor) {
        AbstractC2304t.f(descriptor, "descriptor");
        throw new IllegalStateException("Cannot infer visibility for " + descriptor);
    }
}
