package n7;

import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzaen;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s0 {
    public static /* synthetic */ Task a(RecaptchaAction recaptchaAction, FirebaseAuth firebaseAuth, String str, Continuation continuation, Task task) {
        if (task.isSuccessful()) {
            return Tasks.forResult(task.getResult());
        }
        Exception exc = (Exception) com.google.android.gms.common.internal.s.k(task.getException());
        if (zzaen.zzd(exc)) {
            if (Log.isLoggable("RecaptchaCallWrapper", 4)) {
                Log.i("RecaptchaCallWrapper", "Falling back to recaptcha enterprise flow for action " + String.valueOf(recaptchaAction));
            }
            if (firebaseAuth.q0() == null) {
                firebaseAuth.m0(new b1(firebaseAuth.l(), firebaseAuth));
            }
            return d(firebaseAuth.q0(), recaptchaAction, str, continuation);
        }
        Log.e("RecaptchaCallWrapper", "Initial task failed for action " + String.valueOf(recaptchaAction) + "with exception - " + exc.getMessage());
        return Tasks.forException(exc);
    }

    public static Task d(b1 b1Var, RecaptchaAction recaptchaAction, String str, Continuation continuation) {
        Task taskB = b1Var.b(str, Boolean.FALSE, recaptchaAction);
        return taskB.continueWithTask(continuation).continueWithTask(new x0(str, b1Var, recaptchaAction, continuation));
    }

    public final Task b(final FirebaseAuth firebaseAuth, final String str, final RecaptchaAction recaptchaAction, String str2) {
        final Continuation continuation = new Continuation() { // from class: n7.u0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                s0 s0Var = this.f16859a;
                if (task.isSuccessful()) {
                    return s0Var.c((String) task.getResult());
                }
                Log.e("RecaptchaCallWrapper", "Failed to get Recaptcha token, error - " + ((Exception) com.google.android.gms.common.internal.s.k(task.getException())).getMessage() + "\n\n Failing open with a fake token.");
                return s0Var.c("NO_RECAPTCHA");
            }
        };
        b1 b1VarQ0 = firebaseAuth.q0();
        return (b1VarQ0 == null || !b1VarQ0.e(str2)) ? c(null).continueWithTask(new Continuation() { // from class: n7.v0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return s0.a(recaptchaAction, firebaseAuth, str, continuation, task);
            }
        }) : d(b1VarQ0, recaptchaAction, str, continuation);
    }

    public abstract Task c(String str);
}
