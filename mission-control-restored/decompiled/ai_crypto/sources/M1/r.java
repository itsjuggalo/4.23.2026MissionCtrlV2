package M1;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static r f3824d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f3825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GoogleSignInAccount f3826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GoogleSignInOptions f3827c;

    public r(Context context) {
        c cVarB = c.b(context);
        this.f3825a = cVarB;
        this.f3826b = cVarB.c();
        this.f3827c = cVarB.d();
    }

    public static synchronized r c(Context context) {
        return f(context.getApplicationContext());
    }

    public static synchronized r f(Context context) {
        r rVar = f3824d;
        if (rVar != null) {
            return rVar;
        }
        r rVar2 = new r(context);
        f3824d = rVar2;
        return rVar2;
    }

    public final synchronized GoogleSignInAccount a() {
        return this.f3826b;
    }

    public final synchronized GoogleSignInOptions b() {
        return this.f3827c;
    }

    public final synchronized void d() {
        this.f3825a.a();
        this.f3826b = null;
        this.f3827c = null;
    }

    public final synchronized void e(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.f3825a.f(googleSignInAccount, googleSignInOptions);
        this.f3826b = googleSignInAccount;
        this.f3827c = googleSignInOptions;
    }
}
