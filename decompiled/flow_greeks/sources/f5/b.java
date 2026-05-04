package f5;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import g5.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b extends com.google.android.gms.common.api.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f9354a = new g(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f9355b = 1;

    public b(Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, a5.a.f70b, googleSignInOptions, new f.a.C0096a().c(new com.google.android.gms.common.api.internal.a()).a());
    }

    public Task g() {
        return r.b(o.c(asGoogleApiClient(), getApplicationContext(), h() == 3));
    }

    public final synchronized int h() {
        int i10;
        try {
            i10 = f9355b;
            if (i10 == 1) {
                Context applicationContext = getApplicationContext();
                m5.e eVarN = m5.e.n();
                int iH = eVarN.h(applicationContext, 12451000);
                if (iH == 0) {
                    i10 = 4;
                    f9355b = 4;
                } else if (eVarN.b(applicationContext, iH, null) != null || DynamiteModule.a(applicationContext, "com.google.android.gms.auth.api.fallback") == 0) {
                    i10 = 2;
                    f9355b = 2;
                } else {
                    i10 = 3;
                    f9355b = 3;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return i10;
    }

    public Task signOut() {
        return r.b(o.b(asGoogleApiClient(), getApplicationContext(), h() == 3));
    }
}
