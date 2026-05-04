package tf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r extends ie.h0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final wf.n f22049g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(ef.c fqName, wf.n storageManager, fe.h0 module) {
        super(module, fqName);
        kotlin.jvm.internal.t.f(fqName, "fqName");
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(module, "module");
        this.f22049g = storageManager;
    }

    public abstract j F0();

    public boolean K0(ef.f name) {
        kotlin.jvm.internal.t.f(name, "name");
        qf.k kVarQ = q();
        return (kVarQ instanceof vf.w) && ((vf.w) kVarQ).t().contains(name);
    }

    public abstract void L0(n nVar);
}
