package n7;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzaen;
import com.google.android.gms.internal.p002firebaseauthapi.zzafz;
import com.google.android.gms.internal.p002firebaseauthapi.zzagl;
import com.google.android.gms.internal.p002firebaseauthapi.zzahr;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16724b = "d0";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d0 f16725c = new d0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16726a;

    public static d0 b() {
        return f16725c;
    }

    public static /* synthetic */ void e(d0 d0Var, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, RecaptchaAction recaptchaAction, String str, Activity activity, boolean z10, boolean z11, l1 l1Var, Task task) {
        if (!task.isSuccessful()) {
            Log.e(f16724b, "Failed to initialize reCAPTCHA config: " + task.getException().getMessage());
        }
        if (firebaseAuth.q0() == null || !firebaseAuth.q0().e("PHONE_PROVIDER")) {
            d0Var.c(firebaseAuth, str, activity, z10, z11, l1Var, taskCompletionSource);
        } else {
            firebaseAuth.q0().b(firebaseAuth.q(), Boolean.FALSE, recaptchaAction).addOnSuccessListener(new o1(d0Var, taskCompletionSource)).addOnFailureListener(new e1(d0Var, firebaseAuth, str, activity, z10, z11, l1Var, taskCompletionSource));
        }
    }

    public static /* synthetic */ void f(d0 d0Var, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, l1 l1Var, Activity activity, Task task) {
        if (task.isSuccessful() && task.getResult() != null && !TextUtils.isEmpty(((IntegrityTokenResponse) task.getResult()).token())) {
            taskCompletionSource.setResult(new v1().a(((IntegrityTokenResponse) task.getResult()).token()).b());
            return;
        }
        String message = task.getException() == null ? "" : task.getException().getMessage();
        Log.e(f16724b, "Play Integrity Token fetch failed, falling back to Recaptcha" + message);
        d0Var.d(firebaseAuth, l1Var, activity, taskCompletionSource);
    }

    public static boolean i(Exception exc) {
        if (exc instanceof m7.t) {
            return true;
        }
        return (exc instanceof m7.q) && ((m7.q) exc).a().endsWith("UNAUTHORIZED_DOMAIN");
    }

    public final Task a(final FirebaseAuth firebaseAuth, final String str, final Activity activity, final boolean z10, boolean z11, boolean z12, final RecaptchaAction recaptchaAction) {
        f fVar = (f) firebaseAuth.o();
        final l1 l1VarF = l1.f();
        if (zzagl.zza(firebaseAuth.l()) || fVar.h()) {
            return Tasks.forResult(new v1().b());
        }
        String str2 = f16724b;
        Log.i(str2, "ForceRecaptchaV2Flow from phoneAuthOptions = " + z11 + ", ForceRecaptchav2Flow from firebaseSettings = " + fVar.f());
        boolean z13 = z11 || fVar.f();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Task taskE = l1VarF.e();
        if (taskE != null) {
            if (taskE.isSuccessful()) {
                return Tasks.forResult(new v1().d((String) taskE.getResult()).b());
            }
            Log.e(str2, "Error in previous reCAPTCHAV2 flow: " + taskE.getException().getMessage());
            Log.e(str2, "Continuing with application verification as normal");
        }
        if (z13 || z12) {
            c(firebaseAuth, str, activity, z10, z13, l1VarF, taskCompletionSource);
        } else {
            Task taskR = firebaseAuth.r();
            final boolean z14 = false;
            OnCompleteListener onCompleteListener = new OnCompleteListener() { // from class: n7.c
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    d0.e(this.f16709a, taskCompletionSource, firebaseAuth, recaptchaAction, str, activity, z10, z14, l1VarF, task);
                }
            };
            taskCompletionSource = taskCompletionSource;
            taskR.addOnCompleteListener(onCompleteListener);
        }
        return taskCompletionSource.getTask();
    }

    public final void c(final FirebaseAuth firebaseAuth, String str, final Activity activity, boolean z10, boolean z11, final l1 l1Var, final TaskCompletionSource taskCompletionSource) {
        if (!z10 || z11) {
            d(firebaseAuth, l1Var, activity, taskCompletionSource);
        } else {
            (!TextUtils.isEmpty(this.f16726a) ? Tasks.forResult(new zzahr(this.f16726a)) : firebaseAuth.L()).continueWithTask(firebaseAuth.C0(), new n1(this, str, IntegrityManagerFactory.create(firebaseAuth.l().m()))).addOnCompleteListener(new OnCompleteListener() { // from class: n7.m1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    d0.f(this.f16816a, taskCompletionSource, firebaseAuth, l1Var, activity, task);
                }
            });
        }
    }

    public final void d(FirebaseAuth firebaseAuth, l1 l1Var, Activity activity, TaskCompletionSource taskCompletionSource) {
        Task task;
        if (activity == null) {
            taskCompletionSource.setException(new m7.t());
            return;
        }
        p0.d(firebaseAuth.l().m(), firebaseAuth);
        com.google.android.gms.common.internal.s.k(activity);
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        if (a0.b().h(activity, taskCompletionSource2)) {
            new zzafz(firebaseAuth, activity).zza();
            task = taskCompletionSource2.getTask();
        } else {
            task = Tasks.forException(zzaen.zza(new Status(17057, "reCAPTCHA flow already in progress")));
        }
        task.addOnSuccessListener(new p1(this, taskCompletionSource)).addOnFailureListener(new q1(this, taskCompletionSource));
    }
}
