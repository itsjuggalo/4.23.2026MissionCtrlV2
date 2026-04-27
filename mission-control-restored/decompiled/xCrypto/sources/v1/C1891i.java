package v1;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.AbstractC0930h;
import com.google.android.gms.common.internal.C0927e;
import com.google.android.gms.internal.p000authapi.zbat;
import java.util.Iterator;

/* JADX INFO: renamed from: v1.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1891i extends AbstractC0930h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GoogleSignInOptions f15301a;

    public C1891i(Context context, Looper looper, C0927e c0927e, GoogleSignInOptions googleSignInOptions, f.b bVar, f.c cVar) {
        super(context, looper, 91, c0927e, bVar, cVar);
        GoogleSignInOptions.a aVar = googleSignInOptions != null ? new GoogleSignInOptions.a(googleSignInOptions) : new GoogleSignInOptions.a();
        aVar.j(zbat.zba());
        if (!c0927e.e().isEmpty()) {
            Iterator it = c0927e.e().iterator();
            while (it.hasNext()) {
                aVar.f((Scope) it.next(), new Scope[0]);
            }
        }
        this.f15301a = aVar.a();
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof w ? (w) iInterfaceQueryLocalInterface : new w(iBinder);
    }

    public final GoogleSignInOptions e() {
        return this.f15301a;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c, com.google.android.gms.common.api.a.f
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final Intent getSignInIntent() {
        return q.c(getContext(), this.f15301a);
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final boolean providesSignIn() {
        return true;
    }
}
