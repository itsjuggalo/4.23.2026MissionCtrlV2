package m7;

import com.google.android.gms.internal.p002firebaseauthapi.zzair;
import com.google.android.gms.internal.p002firebaseauthapi.zzaix;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i2 implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f16027a;

    public i2(FirebaseAuth firebaseAuth) {
        Objects.requireNonNull(firebaseAuth);
        this.f16027a = firebaseAuth;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Object then(Task task) {
        if (!task.isSuccessful()) {
            return Tasks.forException((Exception) com.google.android.gms.common.internal.s.k(task.getException()));
        }
        zzair zzairVar = (zzair) task.getResult();
        if (zzairVar instanceof zzaix) {
            zzaix zzaixVar = (zzaix) zzairVar;
            return Tasks.forResult(new n7.h1(com.google.android.gms.common.internal.s.e(zzaixVar.zzf()), com.google.android.gms.common.internal.s.e(zzaixVar.zze()), zzaixVar.zzc(), zzaixVar.zzb(), zzaixVar.zzd(), com.google.android.gms.common.internal.s.e(zzaixVar.zza()), this.f16027a));
        }
        throw new IllegalArgumentException("Response should be an instance of StartTotpMfaEnrollmentResponse but was " + zzairVar.getClass().getName() + ".");
    }
}
