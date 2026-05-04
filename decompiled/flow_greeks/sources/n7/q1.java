package n7;

import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class q1 implements OnFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f16846a;

    public q1(d0 d0Var, TaskCompletionSource taskCompletionSource) {
        this.f16846a = taskCompletionSource;
        Objects.requireNonNull(d0Var);
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        Log.e(d0.f16724b, String.format("Failed to get reCAPTCHA token with error [%s]- calling backend without app verification", exc.getMessage()));
        if ((exc instanceof m7.q) && ((m7.q) exc).a().endsWith("UNAUTHORIZED_DOMAIN")) {
            this.f16846a.setException(exc);
        } else {
            this.f16846a.setResult(new v1().b());
        }
    }
}
