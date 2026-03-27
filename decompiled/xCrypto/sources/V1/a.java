package V1;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.AbstractC0925c;
import com.google.android.gms.common.internal.AbstractC0930h;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.common.internal.C0927e;
import com.google.android.gms.common.internal.Q;
import v1.C1885c;
import z1.C1984b;

/* JADX INFO: loaded from: classes.dex */
public class a extends AbstractC0930h implements U1.e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f5304e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f5305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0927e f5306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f5307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f5308d;

    public a(Context context, Looper looper, boolean z4, C0927e c0927e, Bundle bundle, f.b bVar, f.c cVar) {
        super(context, looper, 44, c0927e, bVar, cVar);
        this.f5305a = true;
        this.f5306b = c0927e;
        this.f5307c = bundle;
        this.f5308d = c0927e.j();
    }

    public static Bundle e(C0927e c0927e) {
        c0927e.i();
        Integer numJ = c0927e.j();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", c0927e.b());
        if (numJ != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", numJ.intValue());
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

    @Override // U1.e
    public final void a() {
        connect(new AbstractC0925c.d());
    }

    @Override // U1.e
    public final void b(f fVar) {
        AbstractC0940s.l(fVar, "Expecting a valid ISignInCallbacks");
        try {
            Account accountD = this.f5306b.d();
            ((g) getService()).b(new j(1, new Q(accountD, ((Integer) AbstractC0940s.k(this.f5308d)).intValue(), AbstractC0925c.DEFAULT_ACCOUNT.equals(accountD.name) ? C1885c.b(getContext()).c() : null)), fVar);
        } catch (RemoteException e4) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                fVar.z(new l(1, new C1984b(8, null), null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e4);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof g ? (g) iInterfaceQueryLocalInterface : new g(iBinder);
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final Bundle getGetServiceRequestExtraArgs() {
        if (!getContext().getPackageName().equals(this.f5306b.g())) {
            this.f5307c.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f5306b.g());
        }
        return this.f5307c;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c, com.google.android.gms.common.api.a.f
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c, com.google.android.gms.common.api.a.f
    public final boolean requiresSignIn() {
        return this.f5305a;
    }
}
