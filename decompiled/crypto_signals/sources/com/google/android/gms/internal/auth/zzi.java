package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.internal.InterfaceC0403f;
import com.google.android.gms.common.api.internal.InterfaceC0413p;
import com.google.android.gms.common.internal.AbstractC0433k;
import com.google.android.gms.common.internal.C0430h;
import k1.AbstractC0753f;
import u1.C1202d;

/* JADX INFO: loaded from: classes.dex */
final class zzi extends AbstractC0433k {
    public zzi(Context context, Looper looper, C0430h c0430h, InterfaceC0403f interfaceC0403f, InterfaceC0413p interfaceC0413p) {
        super(context, looper, 224, c0430h, interfaceC0403f, interfaceC0413p);
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.account.data.IGoogleAuthService");
        return iInterfaceQueryLocalInterface instanceof zzp ? (zzp) iInterfaceQueryLocalInterface : new zzp(iBinder);
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f, com.google.android.gms.common.api.g
    public final void disconnect(String str) {
        Log.w("GoogleAuthSvcClientImpl", "GoogleAuthServiceClientImpl disconnected with reason: ".concat(String.valueOf(str)));
        super.disconnect(str);
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final C1202d[] getApiFeatures() {
        return new C1202d[]{AbstractC0753f.f7830c, AbstractC0753f.f7829b, AbstractC0753f.f7828a};
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final int getMinApkVersion() {
        return 17895000;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.account.data.IGoogleAuthService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.account.authapi.START";
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final boolean getUseDynamicLookup() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final boolean usesClientTelemetry() {
        return true;
    }
}
