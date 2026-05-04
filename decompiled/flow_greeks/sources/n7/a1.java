package n7;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzac;
import com.google.android.gms.internal.p002firebaseauthapi.zzahs;
import com.google.android.gms.internal.p002firebaseauthapi.zzt;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a1 implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b1 f16695b;

    public a1(b1 b1Var, String str) {
        this.f16694a = str;
        Objects.requireNonNull(b1Var);
        this.f16695b = b1Var;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Object then(Task task) {
        if (!task.isSuccessful()) {
            return Tasks.forException(new y0((String) com.google.android.gms.common.internal.s.k(((Exception) com.google.android.gms.common.internal.s.k(task.getException())).getMessage())));
        }
        zzahs zzahsVar = (zzahs) task.getResult();
        String strZza = zzahsVar.zza();
        if (zzac.zzc(strZza)) {
            return Tasks.forException(new y0("No Recaptcha Enterprise siteKey configured for tenant/project " + this.f16694a));
        }
        List<String> listZza = zzt.zza('/').zza((CharSequence) strZza);
        String str = listZza.size() != 4 ? null : listZza.get(3);
        if (TextUtils.isEmpty(str)) {
            return Tasks.forException(new Exception("Invalid siteKey format " + strZza));
        }
        if (Log.isLoggable("RecaptchaHandler", 4)) {
            Log.i("RecaptchaHandler", "Successfully obtained site key for tenant " + this.f16694a);
        }
        b1 b1Var = this.f16695b;
        Task taskA = b1Var.f16708f.a((Application) b1Var.f16706d.m(), str);
        b1.c(this.f16695b, zzahsVar, taskA, this.f16694a);
        return taskA;
    }
}
