package h6;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.o0;
import com.google.android.gms.common.internal.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a extends com.google.android.gms.common.internal.h implements g6.e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f11025e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.common.internal.e f11027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f11028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f11029d;

    public a(Context context, Looper looper, boolean z10, com.google.android.gms.common.internal.e eVar, Bundle bundle, g.b bVar, g.c cVar) {
        super(context, looper, 44, eVar, bVar, cVar);
        this.f11026a = true;
        this.f11027b = eVar;
        this.f11028c = bundle;
        this.f11029d = eVar.k();
    }

    public static Bundle e(com.google.android.gms.common.internal.e eVar) {
        eVar.j();
        Integer numK = eVar.k();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", eVar.b());
        if (numK != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", numK.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    @Override // g6.e
    public final void a(f fVar) {
        s.l(fVar, "Expecting a valid ISignInCallbacks");
        try {
            Account accountD = this.f11027b.d();
            ((g) getService()).H(new j(1, new o0(accountD, ((Integer) s.k(this.f11029d)).intValue(), com.google.android.gms.common.internal.c.DEFAULT_ACCOUNT.equals(accountD.name) ? g5.c.b(getContext()).c() : null)), fVar);
        } catch (RemoteException e10) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                fVar.v(new l(1, new m5.b(8, null), null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e10);
            }
        }
    }

    @Override // g6.e
    public final void b() {
        connect(new c.d(this));
    }

    @Override // com.google.android.gms.common.internal.c
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof g ? (g) iInterfaceQueryLocalInterface : new g(iBinder);
    }

    @Override // com.google.android.gms.common.internal.c
    public final Bundle getGetServiceRequestExtraArgs() {
        com.google.android.gms.common.internal.e eVar = this.f11027b;
        if (!getContext().getPackageName().equals(eVar.g())) {
            this.f11028c.putString("com.google.android.gms.signin.internal.realClientPackageName", eVar.g());
        }
        return this.f11028c;
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.c
    public final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.c
    public final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public final boolean requiresSignIn() {
        return this.f11026a;
    }
}
