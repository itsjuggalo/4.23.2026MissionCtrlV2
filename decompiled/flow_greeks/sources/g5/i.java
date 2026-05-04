package g5;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.g;
import com.google.android.gms.internal.p000authapi.zbaw;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends com.google.android.gms.common.internal.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GoogleSignInOptions f10063a;

    public i(Context context, Looper looper, com.google.android.gms.common.internal.e eVar, GoogleSignInOptions googleSignInOptions, g.b bVar, g.c cVar) {
        super(context, looper, 91, eVar, bVar, cVar);
        GoogleSignInOptions.a aVar = googleSignInOptions != null ? new GoogleSignInOptions.a(googleSignInOptions) : new GoogleSignInOptions.a();
        aVar.e(zbaw.zba());
        if (!eVar.e().isEmpty()) {
            Iterator it = eVar.e().iterator();
            while (it.hasNext()) {
                aVar.d((Scope) it.next(), new Scope[0]);
            }
        }
        this.f10063a = aVar.a();
    }

    @Override // com.google.android.gms.common.internal.c
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof u ? (u) iInterfaceQueryLocalInterface : new u(iBinder);
    }

    public final GoogleSignInOptions e() {
        return this.f10063a;
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.c
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.c
    public final Intent getSignInIntent() {
        return o.a(getContext(), this.f10063a);
    }

    @Override // com.google.android.gms.common.internal.c
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.c
    public final boolean providesSignIn() {
        return true;
    }
}
