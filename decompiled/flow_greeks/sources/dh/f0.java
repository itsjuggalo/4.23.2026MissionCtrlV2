package dh;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends j1 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f8141m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(String name, e0 generatedSerializer) {
        super(name, generatedSerializer, 1);
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(generatedSerializer, "generatedSerializer");
        this.f8141m = true;
    }

    @Override // dh.j1
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        bh.e eVar = (bh.e) obj;
        if (!kotlin.jvm.internal.t.b(i(), eVar.i())) {
            return false;
        }
        f0 f0Var = (f0) obj;
        if (!f0Var.isInline() || !Arrays.equals(u(), f0Var.u()) || l() != eVar.l()) {
            return false;
        }
        int iL = l();
        for (int i10 = 0; i10 < iL; i10++) {
            if (!kotlin.jvm.internal.t.b(o(i10).i(), eVar.o(i10).i()) || !kotlin.jvm.internal.t.b(o(i10).h(), eVar.o(i10).h())) {
                return false;
            }
        }
        return true;
    }

    @Override // dh.j1
    public int hashCode() {
        return super.hashCode() * 31;
    }

    @Override // dh.j1, bh.e
    public boolean isInline() {
        return this.f8141m;
    }
}
