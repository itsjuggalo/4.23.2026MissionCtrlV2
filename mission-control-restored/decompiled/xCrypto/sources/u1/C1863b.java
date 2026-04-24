package u1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.C0896b;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import p1.AbstractC1686a;
import v1.q;
import z1.C1988f;

/* JADX INFO: renamed from: u1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1863b extends com.google.android.gms.common.api.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f15095a = new j(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f15096b = 1;

    public C1863b(Activity activity, GoogleSignInOptions googleSignInOptions) {
        super(activity, AbstractC1686a.f13974b, googleSignInOptions, new C0896b());
    }

    public Intent d() {
        Context applicationContext = getApplicationContext();
        int iG = g();
        int i4 = iG - 1;
        if (iG != 0) {
            return i4 != 2 ? i4 != 3 ? q.b(applicationContext, (GoogleSignInOptions) getApiOptions()) : q.c(applicationContext, (GoogleSignInOptions) getApiOptions()) : q.a(applicationContext, (GoogleSignInOptions) getApiOptions());
        }
        throw null;
    }

    public Task e() {
        return r.b(q.f(asGoogleApiClient(), getApplicationContext(), g() == 3));
    }

    public Task f() {
        return r.a(q.e(asGoogleApiClient(), getApplicationContext(), (GoogleSignInOptions) getApiOptions(), g() == 3), f15095a);
    }

    public final synchronized int g() {
        int i4;
        try {
            i4 = f15096b;
            if (i4 == 1) {
                Context applicationContext = getApplicationContext();
                C1988f c1988fN = C1988f.n();
                int iH = c1988fN.h(applicationContext, 12451000);
                if (iH == 0) {
                    i4 = 4;
                    f15096b = 4;
                } else if (c1988fN.b(applicationContext, iH, null) != null || DynamiteModule.a(applicationContext, "com.google.android.gms.auth.api.fallback") == 0) {
                    i4 = 2;
                    f15096b = 2;
                } else {
                    i4 = 3;
                    f15096b = 3;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return i4;
    }

    public Task signOut() {
        return r.b(q.g(asGoogleApiClient(), getApplicationContext(), g() == 3));
    }

    public C1863b(Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, AbstractC1686a.f13974b, googleSignInOptions, new e.a.C0147a().c(new C0896b()).a());
    }
}
