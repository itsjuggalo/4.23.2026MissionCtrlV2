package com.google.android.gms.internal.p000authapi;

import I1.F;
import P1.C0650d;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.internal.InterfaceC1169f;
import com.google.android.gms.common.api.internal.InterfaceC1178o;
import com.google.android.gms.common.internal.AbstractC1197h;
import com.google.android.gms.common.internal.C1194e;

/* JADX INFO: loaded from: classes.dex */
public final class zbar extends AbstractC1197h {
    private final Bundle zba;

    public zbar(Context context, Looper looper, F f7, C1194e c1194e, InterfaceC1169f interfaceC1169f, InterfaceC1178o interfaceC1178o) {
        super(context, looper, 212, c1194e, interfaceC1169f, interfaceC1178o);
        this.zba = new Bundle();
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.identity.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof zbw ? (zbw) iInterfaceQueryLocalInterface : new zbw(iBinder);
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final C0650d[] getApiFeatures() {
        return zbas.zbi;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final Bundle getGetServiceRequestExtraArgs() {
        return this.zba;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c, com.google.android.gms.common.api.a.f
    public final int getMinApkVersion() {
        return 17895000;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.identity.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.identity.service.signin.START";
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final boolean getUseDynamicLookup() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final boolean usesClientTelemetry() {
        return true;
    }
}
