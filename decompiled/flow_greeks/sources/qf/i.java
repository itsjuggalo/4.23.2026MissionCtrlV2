package qf;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wf.i f19082b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public i(Function0 getScope) {
        this(null, getScope, 1, 0 == true ? 1 : 0);
        kotlin.jvm.internal.t.f(getScope, "getScope");
    }

    public static final k k(Function0 function0) {
        k kVar = (k) function0.invoke();
        return kVar instanceof a ? ((a) kVar).h() : kVar;
    }

    @Override // qf.a
    public k i() {
        return (k) this.f19082b.invoke();
    }

    public /* synthetic */ i(wf.n nVar, Function0 function0, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? wf.f.f24060e : nVar, function0);
    }

    public i(wf.n storageManager, Function0 getScope) {
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(getScope, "getScope");
        this.f19082b = storageManager.e(new h(getScope));
    }
}
