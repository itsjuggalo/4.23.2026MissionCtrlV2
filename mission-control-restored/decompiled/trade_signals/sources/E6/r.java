package E6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r extends U5.H {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final H6.n f1033g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(q6.c fqName, H6.n storageManager, R5.H module) {
        super(module, fqName);
        AbstractC2304t.f(fqName, "fqName");
        AbstractC2304t.f(storageManager, "storageManager");
        AbstractC2304t.f(module, "module");
        this.f1033g = storageManager;
    }

    public abstract InterfaceC0471j H0();

    public boolean L0(q6.f name) {
        AbstractC2304t.f(name, "name");
        B6.k kVarR = r();
        return (kVarR instanceof G6.w) && ((G6.w) kVarR).t().contains(name);
    }

    public abstract void M0(C0475n c0475n);
}
