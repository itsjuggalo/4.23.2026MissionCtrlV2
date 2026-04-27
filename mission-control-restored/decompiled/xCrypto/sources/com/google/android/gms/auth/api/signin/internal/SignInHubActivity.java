package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.AbstractActivityC0832u;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.api.Status;
import v1.C1882A;
import v1.r;

/* JADX INFO: loaded from: classes.dex */
public class SignInHubActivity extends AbstractActivityC0832u {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f9642g = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9643a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SignInConfiguration f9644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9645c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Intent f9647f;

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    public final void n() {
        getSupportLoaderManager().c(0, null, new C1882A(this, null));
        f9642g = false;
    }

    public final void o(int i4) {
        Status status = new Status(i4);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        f9642g = false;
    }

    @Override // androidx.fragment.app.AbstractActivityC0832u, androidx.activity.h, android.app.Activity
    public final void onActivityResult(int i4, int i5, Intent intent) {
        if (this.f9643a) {
            return;
        }
        setResult(0);
        if (i4 != 40962) {
            return;
        }
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null && signInAccount.i() != null) {
                GoogleSignInAccount googleSignInAccountI = signInAccount.i();
                r rVarC = r.c(this);
                GoogleSignInOptions googleSignInOptionsI = this.f9644b.i();
                googleSignInAccountI.getClass();
                rVarC.e(googleSignInOptionsI, googleSignInAccountI);
                intent.removeExtra("signInAccount");
                intent.putExtra("googleSignInAccount", googleSignInAccountI);
                this.f9645c = true;
                this.f9646e = i5;
                this.f9647f = intent;
                n();
                return;
            }
            if (intent.hasExtra("errorCode")) {
                int intExtra = intent.getIntExtra("errorCode", 8);
                if (intExtra == 13) {
                    intExtra = 12501;
                }
                o(intExtra);
                return;
            }
        }
        o(8);
    }

    @Override // androidx.fragment.app.AbstractActivityC0832u, androidx.activity.h, w.g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        action.getClass();
        if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            o(12500);
            return;
        }
        if (!action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            Log.e("AuthSignInClient", "Unknown action: ".concat(String.valueOf(intent.getAction())));
            finish();
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra("config");
        bundleExtra.getClass();
        SignInConfiguration signInConfiguration = (SignInConfiguration) bundleExtra.getParcelable("config");
        if (signInConfiguration == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            return;
        }
        this.f9644b = signInConfiguration;
        if (bundle == null) {
            if (f9642g) {
                setResult(0);
                o(12502);
                return;
            } else {
                f9642g = true;
                p(action);
                return;
            }
        }
        boolean z4 = bundle.getBoolean("signingInGoogleApiClients");
        this.f9645c = z4;
        if (z4) {
            this.f9646e = bundle.getInt("signInResultCode");
            Intent intent2 = (Intent) bundle.getParcelable("signInResultData");
            intent2.getClass();
            this.f9647f = intent2;
            n();
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0832u, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        f9642g = false;
    }

    @Override // androidx.activity.h, w.g, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.f9645c);
        if (this.f9645c) {
            bundle.putInt("signInResultCode", this.f9646e);
            bundle.putParcelable("signInResultData", this.f9647f);
        }
    }

    public final void p(String str) {
        Intent intent = new Intent(str);
        if (str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
            intent.setPackage("com.google.android.gms");
        } else {
            intent.setPackage(getPackageName());
        }
        intent.putExtra("config", this.f9644b);
        try {
            startActivityForResult(intent, 40962);
        } catch (ActivityNotFoundException unused) {
            this.f9643a = true;
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            o(17);
        }
    }
}
