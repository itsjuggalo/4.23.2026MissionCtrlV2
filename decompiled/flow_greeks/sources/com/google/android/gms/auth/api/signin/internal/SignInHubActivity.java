package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.u;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import g5.p;
import g5.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@KeepName
public class SignInHubActivity extends u {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f5444f = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5445a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SignInConfiguration f5446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Intent f5449e;

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    public final /* synthetic */ int l() {
        return this.f5448d;
    }

    public final /* synthetic */ Intent m() {
        return this.f5449e;
    }

    public final void n(String str) {
        Intent intent = new Intent(str);
        if (str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
            intent.setPackage("com.google.android.gms");
        } else {
            intent.setPackage(getPackageName());
        }
        intent.putExtra("config", this.f5446b);
        try {
            startActivityForResult(intent, 40962);
        } catch (ActivityNotFoundException unused) {
            this.f5445a = true;
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            p(17);
        }
    }

    public final void o() {
        getSupportLoaderManager().c(0, null, new x(this, null));
        f5444f = false;
    }

    @Override // androidx.fragment.app.u, androidx.activity.h, android.app.Activity
    public final void onActivityResult(int i10, int i11, Intent intent) {
        if (this.f5445a) {
            return;
        }
        setResult(0);
        if (i10 != 40962) {
            return;
        }
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null && signInAccount.R() != null) {
                GoogleSignInAccount googleSignInAccountR = signInAccount.R();
                if (googleSignInAccountR == null) {
                    Log.e("AuthSignInClient", "Google account is null");
                    p(12500);
                    return;
                }
                p.a(this).c(this.f5446b.R(), googleSignInAccountR);
                intent.removeExtra("signInAccount");
                intent.putExtra("googleSignInAccount", googleSignInAccountR);
                this.f5447c = true;
                this.f5448d = i11;
                this.f5449e = intent;
                o();
                return;
            }
            if (intent.hasExtra("errorCode")) {
                int intExtra = intent.getIntExtra("errorCode", 8);
                if (intExtra == 13) {
                    intExtra = 12501;
                }
                p(intExtra);
                return;
            }
        }
        p(8);
    }

    @Override // androidx.fragment.app.u, androidx.activity.h, h0.f, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        if (action == null) {
            Log.e("AuthSignInClient", "Null action");
            p(12500);
            return;
        }
        if (action.equals("com.google.android.gms.auth.NO_IMPL")) {
            Log.e("AuthSignInClient", "Action not implemented");
            p(12500);
            return;
        }
        if (!action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            Log.e("AuthSignInClient", "Unknown action: ".concat(String.valueOf(intent.getAction())));
            finish();
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra("config");
        if (bundleExtra == null) {
            Log.e("AuthSignInClient", "Activity started with no configuration.");
            setResult(0);
            finish();
            return;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) bundleExtra.getParcelable("config");
        if (signInConfiguration == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            return;
        }
        this.f5446b = signInConfiguration;
        if (bundle == null) {
            if (f5444f) {
                setResult(0);
                p(12502);
                return;
            } else {
                f5444f = true;
                n(action);
                return;
            }
        }
        boolean z10 = bundle.getBoolean("signingInGoogleApiClients");
        this.f5447c = z10;
        if (z10) {
            this.f5448d = bundle.getInt("signInResultCode");
            Intent intent2 = (Intent) bundle.getParcelable("signInResultData");
            if (intent2 != null) {
                this.f5449e = intent2;
                o();
            } else {
                Log.e("AuthSignInClient", "Sign in result data cannot be null");
                setResult(0);
                finish();
            }
        }
    }

    @Override // androidx.fragment.app.u, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        f5444f = false;
    }

    @Override // androidx.activity.h, h0.f, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.f5447c);
        if (this.f5447c) {
            bundle.putInt("signInResultCode", this.f5448d);
            bundle.putParcelable("signInResultData", this.f5449e);
        }
    }

    public final void p(int i10) {
        Status status = new Status(i10);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        f5444f = false;
    }
}
