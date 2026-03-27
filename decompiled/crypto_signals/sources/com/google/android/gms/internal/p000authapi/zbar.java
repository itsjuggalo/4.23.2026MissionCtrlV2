package com.google.android.gms.internal.p000authapi;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.internal.InterfaceC0403f;
import com.google.android.gms.common.api.internal.InterfaceC0413p;
import com.google.android.gms.common.internal.AbstractC0433k;
import com.google.android.gms.common.internal.C0430h;
import o1.t;
import u1.C1202d;

/* JADX INFO: loaded from: classes.dex */
public final class zbar extends AbstractC0433k {
    private final Bundle zba;

    public zbar(Context context, Looper looper, t tVar, C0430h c0430h, InterfaceC0403f interfaceC0403f, InterfaceC0413p interfaceC0413p) {
        super(context, looper, 212, c0430h, interfaceC0403f, interfaceC0413p);
        this.zba = new Bundle();
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.identity.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof zbw ? (zbw) iInterfaceQueryLocalInterface : new zbw(iBinder);
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final C1202d[] getApiFeatures() {
        return zbas.zbi;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final Bundle getGetServiceRequestExtraArgs() {
        return this.zba;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final int getMinApkVersion() {
        return 17895000;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.identity.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.identity.service.signin.START";
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
