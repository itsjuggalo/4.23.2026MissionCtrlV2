package io.flutter.plugins.googlesignin;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import u1.C1863b;

/* JADX INFO: loaded from: classes3.dex */
public class GoogleSignInWrapper {
    public C1863b getClient(Context context, GoogleSignInOptions googleSignInOptions) {
        return com.google.android.gms.auth.api.signin.a.a(context, googleSignInOptions);
    }

    public GoogleSignInAccount getLastSignedInAccount(Context context) {
        return com.google.android.gms.auth.api.signin.a.b(context);
    }

    public boolean hasPermissions(GoogleSignInAccount googleSignInAccount, Scope scope) {
        return com.google.android.gms.auth.api.signin.a.d(googleSignInAccount, scope);
    }

    public void requestPermissions(Activity activity, int i4, GoogleSignInAccount googleSignInAccount, Scope[] scopeArr) {
        com.google.android.gms.auth.api.signin.a.e(activity, i4, googleSignInAccount, scopeArr);
    }
}
