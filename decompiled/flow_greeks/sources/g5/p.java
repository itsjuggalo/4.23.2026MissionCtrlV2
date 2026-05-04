package g5;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static p f10067d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f10068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GoogleSignInAccount f10069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GoogleSignInOptions f10070c;

    public p(Context context) {
        c cVarB = c.b(context);
        this.f10068a = cVarB;
        this.f10069b = cVarB.c();
        this.f10070c = cVarB.d();
    }

    public static synchronized p a(Context context) {
        return d(context.getApplicationContext());
    }

    public static synchronized p d(Context context) {
        p pVar = f10067d;
        if (pVar != null) {
            return pVar;
        }
        p pVar2 = new p(context);
        f10067d = pVar2;
        return pVar2;
    }

    public final synchronized void b() {
        this.f10068a.a();
        this.f10069b = null;
        this.f10070c = null;
    }

    public final synchronized void c(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.f10068a.f(googleSignInAccount, googleSignInOptions);
        this.f10069b = googleSignInAccount;
        this.f10070c = googleSignInOptions;
    }
}
