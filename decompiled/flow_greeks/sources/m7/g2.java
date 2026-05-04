package m7;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g2 implements n7.y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f16018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f16019b;

    public g2(FirebaseAuth firebaseAuth, a0 a0Var) {
        this.f16018a = a0Var;
        Objects.requireNonNull(firebaseAuth);
        this.f16019b = firebaseAuth;
    }

    @Override // n7.y
    public final void zza() {
        if (this.f16019b.f6028f == null || !this.f16019b.f6028f.a().equalsIgnoreCase(this.f16018a.a())) {
            return;
        }
        this.f16019b.E0();
    }

    @Override // n7.x
    public final void zza(Status status) {
        if (status.S() == 17011 || status.S() == 17021 || status.S() == 17005) {
            this.f16019b.F();
        }
    }
}
