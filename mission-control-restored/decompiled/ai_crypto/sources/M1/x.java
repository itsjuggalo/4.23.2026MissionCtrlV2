package M1;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* JADX INFO: loaded from: classes.dex */
public final class x extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3828a;

    public x(Context context) {
        this.f3828a = context;
    }

    public final void a0() {
        if (W1.r.a(this.f3828a, Binder.getCallingUid())) {
            return;
        }
        throw new SecurityException("Calling UID " + Binder.getCallingUid() + " is not Google Play services.");
    }

    @Override // M1.t
    public final void j() {
        a0();
        r.c(this.f3828a).d();
    }

    @Override // M1.t
    public final void n() {
        a0();
        c cVarB = c.b(this.f3828a);
        GoogleSignInAccount googleSignInAccountC = cVarB.c();
        GoogleSignInOptions googleSignInOptionsD = GoogleSignInOptions.f10794l;
        if (googleSignInAccountC != null) {
            googleSignInOptionsD = cVarB.d();
        }
        L1.b bVarA = com.google.android.gms.auth.api.signin.a.a(this.f3828a, googleSignInOptionsD);
        if (googleSignInAccountC != null) {
            bVarA.e();
        } else {
            bVarA.signOut();
        }
    }
}
