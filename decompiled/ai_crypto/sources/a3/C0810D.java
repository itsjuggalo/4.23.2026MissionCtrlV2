package a3;

import Z2.C0772q;
import Z2.C0774t;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.p002firebaseauthapi.zzaei;
import com.google.android.gms.internal.p002firebaseauthapi.zzafr;
import com.google.android.gms.internal.p002firebaseauthapi.zzagd;
import com.google.android.gms.internal.p002firebaseauthapi.zzahj;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: renamed from: a3.D, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0810D {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f6120b = "D";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0810D f6121c = new C0810D();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6122a;

    public static C0810D a() {
        return f6121c;
    }

    public static /* synthetic */ void c(C0810D c0810d, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, C0864m0 c0864m0, Activity activity, Task task) {
        if (task.isSuccessful() && task.getResult() != null && !TextUtils.isEmpty(((IntegrityTokenResponse) task.getResult()).token())) {
            taskCompletionSource.setResult(new C0884w0().a(((IntegrityTokenResponse) task.getResult()).token()).b());
            return;
        }
        String message = task.getException() == null ? "" : task.getException().getMessage();
        Log.e(f6120b, "Play Integrity Token fetch failed, falling back to Recaptcha" + message);
        c0810d.g(firebaseAuth, c0864m0, activity, taskCompletionSource);
    }

    public static /* synthetic */ void d(C0810D c0810d, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, RecaptchaAction recaptchaAction, String str, Activity activity, boolean z7, boolean z8, C0864m0 c0864m0, Task task) {
        if (!task.isSuccessful()) {
            Log.e(f6120b, "Failed to initialize reCAPTCHA config: " + task.getException().getMessage());
        }
        if (firebaseAuth.o0() == null || !firebaseAuth.o0().e("PHONE_PROVIDER")) {
            c0810d.h(firebaseAuth, str, activity, z7, z8, c0864m0, taskCompletionSource);
        } else {
            firebaseAuth.o0().b(firebaseAuth.q(), Boolean.FALSE, recaptchaAction).addOnSuccessListener(new C0870p0(c0810d, taskCompletionSource)).addOnFailureListener(new C0850f0(c0810d, firebaseAuth, str, activity, z7, z8, c0864m0, taskCompletionSource));
        }
    }

    public static boolean i(Exception exc) {
        if (exc instanceof C0774t) {
            return true;
        }
        return (exc instanceof C0772q) && ((C0772q) exc).a().endsWith("UNAUTHORIZED_DOMAIN");
    }

    public final Task b(final FirebaseAuth firebaseAuth, final String str, final Activity activity, final boolean z7, boolean z8, boolean z9, final RecaptchaAction recaptchaAction) {
        C0849f c0849f = (C0849f) firebaseAuth.o();
        final C0864m0 c0864m0F = C0864m0.f();
        if (zzagd.zza(firebaseAuth.l()) || c0849f.h()) {
            return Tasks.forResult(new C0884w0().b());
        }
        String str2 = f6120b;
        Log.i(str2, "ForceRecaptchaV2Flow from phoneAuthOptions = " + z8 + ", ForceRecaptchav2Flow from firebaseSettings = " + c0849f.f());
        boolean z10 = z8 || c0849f.f();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Task taskE = c0864m0F.e();
        if (taskE != null) {
            if (taskE.isSuccessful()) {
                return Tasks.forResult(new C0884w0().d((String) taskE.getResult()).b());
            }
            Log.e(str2, "Error in previous reCAPTCHAV2 flow: " + taskE.getException().getMessage());
            Log.e(str2, "Continuing with application verification as normal");
        }
        if (z10 || z9) {
            h(firebaseAuth, str, activity, z7, z10, c0864m0F, taskCompletionSource);
        } else {
            final boolean z11 = false;
            firebaseAuth.r().addOnCompleteListener(new OnCompleteListener() { // from class: a3.c
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    C0810D.d(this.f6177a, taskCompletionSource, firebaseAuth, recaptchaAction, str, activity, z7, z11, c0864m0F, task);
                }
            });
        }
        return taskCompletionSource.getTask();
    }

    public final void g(FirebaseAuth firebaseAuth, C0864m0 c0864m0, Activity activity, TaskCompletionSource taskCompletionSource) {
        Task task;
        if (activity == null) {
            taskCompletionSource.setException(new C0774t());
            return;
        }
        C0829P.d(firebaseAuth.l().m(), firebaseAuth);
        AbstractC1207s.k(activity);
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        if (C0804A.b().h(activity, taskCompletionSource2)) {
            new zzafr(firebaseAuth, activity).zza();
            task = taskCompletionSource2.getTask();
        } else {
            task = Tasks.forException(zzaei.zza(new Status(17057, "reCAPTCHA flow already in progress")));
        }
        task.addOnSuccessListener(new C0872q0(this, taskCompletionSource)).addOnFailureListener(new C0874r0(this, taskCompletionSource));
    }

    public final void h(final FirebaseAuth firebaseAuth, String str, final Activity activity, boolean z7, boolean z8, final C0864m0 c0864m0, final TaskCompletionSource taskCompletionSource) {
        if (!z7 || z8) {
            g(firebaseAuth, c0864m0, activity, taskCompletionSource);
        } else {
            (!TextUtils.isEmpty(this.f6122a) ? Tasks.forResult(new zzahj(this.f6122a)) : firebaseAuth.L()).continueWithTask(firebaseAuth.E0(), new C0868o0(this, str, IntegrityManagerFactory.create(firebaseAuth.l().m()))).addOnCompleteListener(new OnCompleteListener() { // from class: a3.n0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    C0810D.c(this.f6254a, taskCompletionSource, firebaseAuth, c0864m0, activity, task);
                }
            });
        }
    }
}
