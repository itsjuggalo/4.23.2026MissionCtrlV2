package m7;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzahv;
import com.google.firebase.auth.FirebaseAuth;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j2 implements n7.x, n7.u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f16034a;

    public j2(FirebaseAuth firebaseAuth) {
        Objects.requireNonNull(firebaseAuth);
        this.f16034a = firebaseAuth;
    }

    @Override // n7.u1
    public final void a(zzahv zzahvVar, a0 a0Var) {
        this.f16034a.l0(a0Var, zzahvVar, true, true);
    }

    @Override // n7.x
    public final void zza(Status status) {
        int iS = status.S();
        if (iS == 17011 || iS == 17021 || iS == 17005) {
            this.f16034a.F();
        }
    }
}
