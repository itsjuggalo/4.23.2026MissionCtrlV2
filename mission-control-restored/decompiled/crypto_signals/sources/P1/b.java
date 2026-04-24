package P1;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.InterfaceC0403f;
import com.google.android.gms.common.api.internal.InterfaceC0413p;
import com.google.android.gms.common.api.m;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.internal.C0430h;
import com.google.android.gms.common.internal.C0444w;
import com.google.android.gms.internal.auth.zzam;
import com.google.android.gms.internal.auth.zzbe;
import com.google.android.gms.internal.p000authapi.zbe;
import com.google.android.gms.internal.p001authapiphone.zzw;
import java.util.Collections;
import java.util.List;
import m1.d;
import s1.C0988e;
import w1.C1277c;

/* JADX INFO: loaded from: classes.dex */
public final class b extends com.google.android.gms.common.api.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2346a;

    public /* synthetic */ b(int i) {
        this.f2346a = i;
    }

    @Override // com.google.android.gms.common.api.a
    public g buildClient(Context context, Looper looper, C0430h c0430h, Object obj, m mVar, n nVar) {
        switch (this.f2346a) {
            case 0:
                c0430h.getClass();
                Integer num = c0430h.f5242g;
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", null);
                if (num != null) {
                    bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
                }
                bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
                bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
                bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
                bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
                bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
                bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
                return new Q1.a(context, looper, c0430h, bundle, mVar, nVar);
            case 1:
                obj.getClass();
                throw new ClassCastException();
            case 2:
                return new zzam(context, looper, c0430h, mVar, nVar);
            case 3:
                return new zbe(context, looper, c0430h, (d) obj, mVar, nVar);
            case 4:
                return new C0988e(context, looper, c0430h, (GoogleSignInOptions) obj, mVar, nVar);
            default:
                return super.buildClient(context, looper, c0430h, obj, mVar, nVar);
        }
    }

    @Override // com.google.android.gms.common.api.f
    public /* bridge */ /* synthetic */ List getImpliedScopes(Object obj) {
        switch (this.f2346a) {
            case 4:
                GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
                return googleSignInOptions == null ? Collections.EMPTY_LIST : googleSignInOptions.m();
            default:
                return super.getImpliedScopes(obj);
        }
    }

    @Override // com.google.android.gms.common.api.a
    public /* synthetic */ g buildClient(Context context, Looper looper, C0430h c0430h, Object obj, InterfaceC0403f interfaceC0403f, InterfaceC0413p interfaceC0413p) {
        switch (this.f2346a) {
            case 5:
                return new zzbe(context, looper, c0430h, (m1.c) obj, interfaceC0403f, interfaceC0413p);
            case 6:
                return new zzw(context, looper, c0430h, interfaceC0403f, interfaceC0413p);
            case 7:
                return new C1277c(context, looper, c0430h, (C0444w) obj, interfaceC0403f, interfaceC0413p);
            default:
                return super.buildClient(context, looper, c0430h, obj, interfaceC0403f, interfaceC0413p);
        }
    }
}
