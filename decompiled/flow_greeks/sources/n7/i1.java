package n7;

import com.google.android.gms.common.api.internal.c;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i1 implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f1 f16799a;

    public i1(f1 f1Var) {
        Objects.requireNonNull(f1Var);
        this.f16799a = f1Var;
    }

    @Override // com.google.android.gms.common.api.internal.c.a
    public final void a(boolean z10) {
        if (z10) {
            this.f16799a.f16760c = true;
            this.f16799a.b();
        } else {
            this.f16799a.f16760c = false;
            if (this.f16799a.f()) {
                this.f16799a.f16759b.c();
            }
        }
    }
}
