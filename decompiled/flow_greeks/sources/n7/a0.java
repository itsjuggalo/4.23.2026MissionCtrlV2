package n7;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a0 f16691c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f16692a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BroadcastReceiver f16693b;

    public static m7.h a(Intent intent) {
        com.google.android.gms.common.internal.s.k(intent);
        return m7.z1.Y(((zzajb) n5.e.b(intent, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST", zzajb.CREATOR)).zzc(true));
    }

    public static a0 b() {
        if (f16691c == null) {
            f16691c = new a0();
        }
        return f16691c;
    }

    public static void d(Context context) {
        a0 a0Var = f16691c;
        a0Var.f16692a = false;
        if (a0Var.f16693b != null) {
            b2.a.b(context).e(f16691c.f16693b);
        }
        f16691c.f16693b = null;
    }

    public static /* synthetic */ void e(a0 a0Var, Intent intent, TaskCompletionSource taskCompletionSource, Context context) {
        taskCompletionSource.setResult(intent.getStringExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN"));
        d(context);
    }

    public final void c(Activity activity, BroadcastReceiver broadcastReceiver) {
        this.f16693b = broadcastReceiver;
        b2.a.b(activity).c(broadcastReceiver, new IntentFilter("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT"));
    }

    public final boolean h(Activity activity, TaskCompletionSource taskCompletionSource) {
        if (this.f16692a) {
            return false;
        }
        c(activity, new i0(this, activity, taskCompletionSource));
        this.f16692a = true;
        return true;
    }

    public final boolean i(Activity activity, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth) {
        return j(activity, taskCompletionSource, firebaseAuth, null);
    }

    public final boolean j(Activity activity, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, m7.a0 a0Var) {
        if (this.f16692a) {
            return false;
        }
        c(activity, new g0(this, activity, taskCompletionSource, firebaseAuth, a0Var));
        this.f16692a = true;
        return true;
    }
}
