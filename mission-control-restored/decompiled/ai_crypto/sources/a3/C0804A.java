package a3;

import Z2.AbstractC0759h;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.p002firebaseauthapi.zzait;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import v0.C2762a;

/* JADX INFO: renamed from: a3.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0804A {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static C0804A f6105c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6106a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BroadcastReceiver f6107b;

    public static AbstractC0759h a(Intent intent) {
        AbstractC1207s.k(intent);
        return Z2.y0.G(((zzait) Q1.e.b(intent, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST", zzait.CREATOR)).zzc(true));
    }

    public static C0804A b() {
        if (f6105c == null) {
            f6105c = new C0804A();
        }
        return f6105c;
    }

    public static /* synthetic */ void d(C0804A c0804a, Intent intent, TaskCompletionSource taskCompletionSource, Context context) {
        taskCompletionSource.setResult(intent.getStringExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN"));
        g(context);
    }

    public static void g(Context context) {
        C0804A c0804a = f6105c;
        c0804a.f6106a = false;
        if (c0804a.f6107b != null) {
            C2762a.b(context).e(f6105c.f6107b);
        }
        f6105c.f6107b = null;
    }

    public final void f(Activity activity, BroadcastReceiver broadcastReceiver) {
        this.f6107b = broadcastReceiver;
        C2762a.b(activity).c(broadcastReceiver, new IntentFilter("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT"));
    }

    public final boolean h(Activity activity, TaskCompletionSource taskCompletionSource) {
        if (this.f6106a) {
            return false;
        }
        f(activity, new C0820I(this, activity, taskCompletionSource));
        this.f6106a = true;
        return true;
    }

    public final boolean i(Activity activity, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth) {
        return j(activity, taskCompletionSource, firebaseAuth, null);
    }

    public final boolean j(Activity activity, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, Z2.A a7) {
        if (this.f6106a) {
            return false;
        }
        f(activity, new C0816G(this, activity, taskCompletionSource, firebaseAuth, a7));
        this.f6106a = true;
        return true;
    }
}
