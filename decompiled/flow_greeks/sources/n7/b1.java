package n7;

import com.google.android.gms.internal.p002firebaseauthapi.zzac;
import com.google.android.gms.internal.p002firebaseauthapi.zzahs;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f16703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f16704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zzahs f16705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a7.g f16706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FirebaseAuth f16707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public w0 f16708f;

    public b1(a7.g gVar, FirebaseAuth firebaseAuth) {
        this(gVar, firebaseAuth, new z0());
    }

    public static /* synthetic */ void c(b1 b1Var, zzahs zzahsVar, Task task, String str) {
        synchronized (b1Var.f16703a) {
            b1Var.f16705c = zzahsVar;
            b1Var.f16704b.put(str, task);
        }
    }

    public static String g(String str) {
        return zzac.zzc(str) ? "*" : str;
    }

    public final Task a(String str, Boolean bool) {
        Task taskF;
        String strG = g(str);
        return (bool.booleanValue() || (taskF = f(strG)) == null) ? this.f16707e.N("RECAPTCHA_ENTERPRISE").continueWithTask(new a1(this, strG)) : taskF;
    }

    public final Task b(String str, Boolean bool, RecaptchaAction recaptchaAction) {
        String strG = g(str);
        Task taskF = f(strG);
        if (bool.booleanValue() || taskF == null) {
            taskF = a(strG, bool);
        }
        return taskF.continueWithTask(new d1(this, recaptchaAction));
    }

    public final boolean d(String str) {
        String strZzb;
        com.google.android.gms.common.internal.s.k(str);
        zzahs zzahsVar = this.f16705c;
        if (zzahsVar == null || (strZzb = zzahsVar.zzb(str)) == null) {
            return false;
        }
        return strZzb.equals("AUDIT");
    }

    public final boolean e(String str) {
        boolean z10;
        synchronized (this.f16703a) {
            try {
                zzahs zzahsVar = this.f16705c;
                z10 = zzahsVar != null && zzahsVar.zzc(str);
            } finally {
            }
        }
        return z10;
    }

    public final Task f(String str) {
        Task task;
        synchronized (this.f16703a) {
            task = (Task) this.f16704b.get(str);
        }
        return task;
    }

    public b1(a7.g gVar, FirebaseAuth firebaseAuth, w0 w0Var) {
        this.f16703a = new Object();
        this.f16704b = new HashMap();
        this.f16706d = gVar;
        this.f16707e = firebaseAuth;
        this.f16708f = w0Var;
    }
}
