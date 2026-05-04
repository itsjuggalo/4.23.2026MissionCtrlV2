package g5;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class v extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10071a;

    public v(Context context) {
        this.f10071a = context;
    }

    public final void H() {
        if (t5.q.a(this.f10071a, Binder.getCallingUid())) {
            return;
        }
        int callingUid = Binder.getCallingUid();
        StringBuilder sb2 = new StringBuilder(String.valueOf(callingUid).length() + 41);
        sb2.append("Calling UID ");
        sb2.append(callingUid);
        sb2.append(" is not Google Play services.");
        throw new SecurityException(sb2.toString());
    }

    @Override // g5.r
    public final void j() {
        H();
        Context context = this.f10071a;
        c cVarB = c.b(context);
        GoogleSignInAccount googleSignInAccountC = cVarB.c();
        GoogleSignInOptions googleSignInOptionsD = GoogleSignInOptions.f5411l;
        if (googleSignInAccountC != null) {
            googleSignInOptionsD = cVarB.d();
        }
        f5.b bVarA = com.google.android.gms.auth.api.signin.a.a(context, googleSignInOptionsD);
        if (googleSignInAccountC != null) {
            bVarA.g();
        } else {
            bVarA.signOut();
        }
    }

    @Override // g5.r
    public final void k() {
        H();
        p.a(this.f10071a).b();
    }
}
