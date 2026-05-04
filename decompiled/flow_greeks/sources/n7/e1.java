package n7;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e1 implements OnFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f16743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f16745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f16746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f16747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ l1 f16748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f16749g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ d0 f16750h;

    public e1(d0 d0Var, FirebaseAuth firebaseAuth, String str, Activity activity, boolean z10, boolean z11, l1 l1Var, TaskCompletionSource taskCompletionSource) {
        this.f16743a = firebaseAuth;
        this.f16744b = str;
        this.f16745c = activity;
        this.f16746d = z10;
        this.f16747e = z11;
        this.f16748f = l1Var;
        this.f16749g = taskCompletionSource;
        Objects.requireNonNull(d0Var);
        this.f16750h = d0Var;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        Log.e(d0.f16724b, "Failed to get reCAPTCHA enterprise token: " + exc.getMessage() + "\n\n Using fallback methods.");
        if (this.f16743a.q0().d("PHONE_PROVIDER")) {
            this.f16750h.c(this.f16743a, this.f16744b, this.f16745c, this.f16746d, this.f16747e, this.f16748f, this.f16749g);
        } else {
            this.f16749g.setResult(new v1().b());
        }
    }
}
