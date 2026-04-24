package L1;

import M1.q;
import P1.C0652f;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.C1164a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.google.android.gms.common.api.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f3647a = new j(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f3648b = 1;

    public b(Activity activity, GoogleSignInOptions googleSignInOptions) {
        super(activity, G1.a.f2403b, googleSignInOptions, new C1164a());
    }

    public Intent d() {
        Context applicationContext = getApplicationContext();
        int iG = g();
        int i7 = iG - 1;
        if (iG != 0) {
            return i7 != 2 ? i7 != 3 ? q.b(applicationContext, (GoogleSignInOptions) getApiOptions()) : q.c(applicationContext, (GoogleSignInOptions) getApiOptions()) : q.a(applicationContext, (GoogleSignInOptions) getApiOptions());
        }
        throw null;
    }

    public Task e() {
        return r.b(q.f(asGoogleApiClient(), getApplicationContext(), g() == 3));
    }

    public Task f() {
        return r.a(q.e(asGoogleApiClient(), getApplicationContext(), (GoogleSignInOptions) getApiOptions(), g() == 3), f3647a);
    }

    public final synchronized int g() {
        int i7;
        try {
            i7 = f3648b;
            if (i7 == 1) {
                Context applicationContext = getApplicationContext();
                C0652f c0652fN = C0652f.n();
                int iH = c0652fN.h(applicationContext, 12451000);
                if (iH == 0) {
                    i7 = 4;
                    f3648b = 4;
                } else if (c0652fN.b(applicationContext, iH, null) != null || DynamiteModule.a(applicationContext, "com.google.android.gms.auth.api.fallback") == 0) {
                    i7 = 2;
                    f3648b = 2;
                } else {
                    i7 = 3;
                    f3648b = 3;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return i7;
    }

    public Task signOut() {
        return r.b(q.g(asGoogleApiClient(), getApplicationContext(), g() == 3));
    }

    public b(Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, G1.a.f2403b, googleSignInOptions, new e.a.C0180a().c(new C1164a()).a());
    }
}
