package E6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: E6.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0478q implements InterfaceC0471j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final R5.O f1032a;

    public C0478q(R5.O packageFragmentProvider) {
        AbstractC2304t.f(packageFragmentProvider, "packageFragmentProvider");
        this.f1032a = packageFragmentProvider;
    }

    @Override // E6.InterfaceC0471j
    public C0470i a(q6.b classId) {
        C0470i c0470iA;
        AbstractC2304t.f(classId, "classId");
        for (R5.N n8 : R5.T.c(this.f1032a, classId.f())) {
            if ((n8 instanceof r) && (c0470iA = ((r) n8).H0().a(classId)) != null) {
                return c0470iA;
            }
        }
        return null;
    }
}
