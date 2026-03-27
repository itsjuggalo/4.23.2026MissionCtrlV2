package k5;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public L1.b a(Context context, GoogleSignInOptions googleSignInOptions) {
        return com.google.android.gms.auth.api.signin.a.a(context, googleSignInOptions);
    }

    public GoogleSignInAccount b(Context context) {
        return com.google.android.gms.auth.api.signin.a.b(context);
    }

    public boolean c(GoogleSignInAccount googleSignInAccount, Scope scope) {
        return com.google.android.gms.auth.api.signin.a.d(googleSignInAccount, scope);
    }

    public void d(Activity activity, int i7, GoogleSignInAccount googleSignInAccount, Scope[] scopeArr) {
        com.google.android.gms.auth.api.signin.a.e(activity, i7, googleSignInAccount, scopeArr);
    }
}
