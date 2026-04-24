package v1;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import u1.C1863b;

/* JADX INFO: loaded from: classes.dex */
public final class x extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15312a;

    public x(Context context) {
        this.f15312a = context;
    }

    public final void a0() {
        if (G1.r.a(this.f15312a, Binder.getCallingUid())) {
            return;
        }
        throw new SecurityException("Calling UID " + Binder.getCallingUid() + " is not Google Play services.");
    }

    @Override // v1.t
    public final void j() {
        a0();
        r.c(this.f15312a).d();
    }

    @Override // v1.t
    public final void n() {
        a0();
        C1885c c1885cB = C1885c.b(this.f15312a);
        GoogleSignInAccount googleSignInAccountC = c1885cB.c();
        GoogleSignInOptions googleSignInOptionsD = GoogleSignInOptions.f9609l;
        if (googleSignInAccountC != null) {
            googleSignInOptionsD = c1885cB.d();
        }
        C1863b c1863bA = com.google.android.gms.auth.api.signin.a.a(this.f15312a, googleSignInOptionsD);
        if (googleSignInAccountC != null) {
            c1863bA.e();
        } else {
            c1863bA.signOut();
        }
    }
}
