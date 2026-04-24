package a3;

import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.p002firebaseauthapi.zzae;
import com.google.android.gms.internal.p002firebaseauthapi.zzahk;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: a3.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0844c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f6187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zzahk f6188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Q2.g f6189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FirebaseAuth f6190e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InterfaceC0836X f6191f;

    public C0844c0(Q2.g gVar, FirebaseAuth firebaseAuth) {
        this(gVar, firebaseAuth, new C0840a0());
    }

    public static /* synthetic */ void c(C0844c0 c0844c0, zzahk zzahkVar, Task task, String str) {
        synchronized (c0844c0.f6186a) {
            c0844c0.f6188c = zzahkVar;
            c0844c0.f6187b.put(str, task);
        }
    }

    public static String g(String str) {
        return zzae.zzc(str) ? "*" : str;
    }

    public final Task a(String str, Boolean bool) {
        Task taskF;
        String strG = g(str);
        return (bool.booleanValue() || (taskF = f(strG)) == null) ? this.f6190e.Z("RECAPTCHA_ENTERPRISE").continueWithTask(new C0842b0(this, strG)) : taskF;
    }

    public final Task b(String str, Boolean bool, RecaptchaAction recaptchaAction) {
        String strG = g(str);
        Task taskF = f(strG);
        if (bool.booleanValue() || taskF == null) {
            taskF = a(strG, bool);
        }
        return taskF.continueWithTask(new C0848e0(this, recaptchaAction));
    }

    public final boolean d(String str) {
        String strZzb;
        AbstractC1207s.k(str);
        zzahk zzahkVar = this.f6188c;
        if (zzahkVar == null || (strZzb = zzahkVar.zzb(str)) == null) {
            return false;
        }
        return strZzb.equals("AUDIT");
    }

    public final boolean e(String str) {
        boolean z7;
        synchronized (this.f6186a) {
            try {
                zzahk zzahkVar = this.f6188c;
                z7 = zzahkVar != null && zzahkVar.zzc(str);
            } finally {
            }
        }
        return z7;
    }

    public final Task f(String str) {
        Task task;
        synchronized (this.f6186a) {
            task = (Task) this.f6187b.get(str);
        }
        return task;
    }

    public C0844c0(Q2.g gVar, FirebaseAuth firebaseAuth, InterfaceC0836X interfaceC0836X) {
        this.f6186a = new Object();
        this.f6187b = new HashMap();
        this.f6189d = gVar;
        this.f6190e = firebaseAuth;
        this.f6191f = interfaceC0836X;
    }
}
