package v1;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static r f15308d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1885c f15309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GoogleSignInAccount f15310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GoogleSignInOptions f15311c;

    public r(Context context) {
        C1885c c1885cB = C1885c.b(context);
        this.f15309a = c1885cB;
        this.f15310b = c1885cB.c();
        this.f15311c = c1885cB.d();
    }

    public static synchronized r c(Context context) {
        return f(context.getApplicationContext());
    }

    public static synchronized r f(Context context) {
        r rVar = f15308d;
        if (rVar != null) {
            return rVar;
        }
        r rVar2 = new r(context);
        f15308d = rVar2;
        return rVar2;
    }

    public final synchronized GoogleSignInAccount a() {
        return this.f15310b;
    }

    public final synchronized GoogleSignInOptions b() {
        return this.f15311c;
    }

    public final synchronized void d() {
        this.f15309a.a();
        this.f15310b = null;
        this.f15311c = null;
    }

    public final synchronized void e(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.f15309a.f(googleSignInAccount, googleSignInOptions);
        this.f15310b = googleSignInAccount;
        this.f15311c = googleSignInOptions;
    }
}
