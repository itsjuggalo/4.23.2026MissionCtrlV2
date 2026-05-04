package xf;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class x0 extends n2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wf.n f25093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0 f25094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final wf.i f25095d;

    public x0(wf.n storageManager, Function0 computation) {
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(computation, "computation");
        this.f25093b = storageManager;
        this.f25094c = computation;
        this.f25095d = storageManager.e(computation);
    }

    public static final r0 V0(yf.g gVar, x0 x0Var) {
        return gVar.a((bg.i) x0Var.f25094c.invoke());
    }

    @Override // xf.n2
    public r0 R0() {
        return (r0) this.f25095d.invoke();
    }

    @Override // xf.n2
    public boolean S0() {
        return this.f25095d.e();
    }

    @Override // xf.r0
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public x0 X0(yf.g kotlinTypeRefiner) {
        kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new x0(this.f25093b, new w0(kotlinTypeRefiner, this));
    }
}
