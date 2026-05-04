package tf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class q implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fe.o0 f22046a;

    public q(fe.o0 packageFragmentProvider) {
        kotlin.jvm.internal.t.f(packageFragmentProvider, "packageFragmentProvider");
        this.f22046a = packageFragmentProvider;
    }

    @Override // tf.j
    public i a(ef.b classId) {
        i iVarA;
        kotlin.jvm.internal.t.f(classId, "classId");
        for (fe.n0 n0Var : fe.s0.c(this.f22046a, classId.f())) {
            if ((n0Var instanceof r) && (iVarA = ((r) n0Var).F0().a(classId)) != null) {
                return iVarA;
            }
        }
        return null;
    }
}
