package n7;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzaen;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f16761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f16762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FirebaseAuth f16763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m7.a0 f16764d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ a0 f16765e;

    public g0(a0 a0Var, Activity activity, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, m7.a0 a0Var2) {
        Objects.requireNonNull(a0Var);
        this.f16765e = a0Var;
        this.f16761a = new WeakReference(activity);
        this.f16762b = taskCompletionSource;
        this.f16763c = firebaseAuth;
        this.f16764d = a0Var2;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (((Activity) this.f16761a.get()) == null) {
            Log.e("FederatedAuthReceiver", "Failed to unregister BroadcastReceiver because the Activity that launched this flow has been garbage collected; please do not finish() your Activity while performing a FederatedAuthProvider operation.");
            this.f16762b.setException(zzaen.zza(new Status(17499, "Activity that started the web operation is no longer alive; see logcat for details")));
            a0.d(context);
            return;
        }
        if (!intent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
            if (j1.d(intent)) {
                this.f16762b.setException(zzaen.zza(j1.a(intent)));
                a0.d(context);
                return;
            } else {
                if (intent.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
                    this.f16762b.setException(zzaen.zza(r.a("WEB_CONTEXT_CANCELED")));
                    a0.d(context);
                    return;
                }
                return;
            }
        }
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
        if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(stringExtra)) {
            a0 a0Var = this.f16765e;
            TaskCompletionSource taskCompletionSource = this.f16762b;
            this.f16763c.B(a0.a(intent)).addOnSuccessListener(new c0(a0Var, taskCompletionSource, context)).addOnFailureListener(new z(a0Var, taskCompletionSource, context));
            return;
        }
        if ("com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(stringExtra)) {
            a0 a0Var2 = this.f16765e;
            TaskCompletionSource taskCompletionSource2 = this.f16762b;
            this.f16764d.Y(a0.a(intent)).addOnSuccessListener(new f0(a0Var2, taskCompletionSource2, context)).addOnFailureListener(new b0(a0Var2, taskCompletionSource2, context));
        } else if ("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(stringExtra)) {
            a0 a0Var3 = this.f16765e;
            TaskCompletionSource taskCompletionSource3 = this.f16762b;
            this.f16764d.Z(a0.a(intent)).addOnSuccessListener(new h0(a0Var3, taskCompletionSource3, context)).addOnFailureListener(new e0(a0Var3, taskCompletionSource3, context));
        } else {
            this.f16762b.setException(zzaen.zza(r.a("WEB_CONTEXT_CANCELED:Unknown operation received (" + stringExtra + ")")));
        }
    }
}
