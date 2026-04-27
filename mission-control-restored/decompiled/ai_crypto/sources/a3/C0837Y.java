package a3;

import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.p002firebaseauthapi.zzaei;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;

/* JADX INFO: renamed from: a3.Y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0837Y implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f6171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0844c0 f6172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecaptchaAction f6173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Continuation f6174d;

    public C0837Y(String str, C0844c0 c0844c0, RecaptchaAction recaptchaAction, Continuation continuation) {
        this.f6171a = str;
        this.f6172b = c0844c0;
        this.f6173c = recaptchaAction;
        this.f6174d = continuation;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Object then(Task task) {
        if (task.isSuccessful() || !zzaei.zzc((Exception) AbstractC1207s.k(task.getException()))) {
            return task;
        }
        if (Log.isLoggable("RecaptchaCallWrapper", 4)) {
            Log.i("RecaptchaCallWrapper", "Invalid token - Refreshing Recaptcha Enterprise config and fetching new token for tenant " + this.f6171a);
        }
        return this.f6172b.b(this.f6171a, Boolean.TRUE, this.f6173c).continueWithTask(this.f6174d);
    }
}
