package I6;

import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;

/* JADX INFO: loaded from: classes2.dex */
public abstract class S implements S5.a, M6.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4385a;

    public S() {
    }

    public final int L0() {
        return W.a(this) ? super.hashCode() : (((O0().hashCode() * 31) + M0().hashCode()) * 31) + (P0() ? 1 : 0);
    }

    public abstract List M0();

    public abstract r0 N0();

    public abstract v0 O0();

    public abstract boolean P0();

    public abstract S Q0(J6.g gVar);

    public abstract M0 R0();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof S)) {
            return false;
        }
        S s8 = (S) obj;
        return P0() == s8.P0() && J6.t.f4671a.a(R0(), s8.R0());
    }

    @Override // S5.a
    public S5.h getAnnotations() {
        return AbstractC0639t.a(N0());
    }

    public final int hashCode() {
        int i8 = this.f4385a;
        if (i8 != 0) {
            return i8;
        }
        int iL0 = L0();
        this.f4385a = iL0;
        return iL0;
    }

    public abstract B6.k r();

    public /* synthetic */ S(AbstractC2296k abstractC2296k) {
        this();
    }
}
