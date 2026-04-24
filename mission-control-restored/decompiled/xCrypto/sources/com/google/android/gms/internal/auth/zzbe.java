package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.api.internal.InterfaceC0903g;
import com.google.android.gms.common.api.internal.InterfaceC0912p;
import com.google.android.gms.common.internal.AbstractC0930h;
import com.google.android.gms.common.internal.C0927e;
import p1.AbstractC1687b;
import p1.C1688c;

/* JADX INFO: loaded from: classes.dex */
public final class zzbe extends AbstractC0930h {
    private final Bundle zze;

    public zzbe(Context context, Looper looper, C0927e c0927e, C1688c c1688c, InterfaceC0903g interfaceC0903g, InterfaceC0912p interfaceC0912p) {
        super(context, looper, 16, c0927e, interfaceC0903g, interfaceC0912p);
        this.zze = c1688c == null ? new Bundle() : c1688c.a();
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        return iInterfaceQueryLocalInterface instanceof zzbh ? (zzbh) iInterfaceQueryLocalInterface : new zzbh(iBinder);
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final Bundle getGetServiceRequestExtraArgs() {
        return this.zze;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c, com.google.android.gms.common.api.a.f
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.service.START";
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c, com.google.android.gms.common.api.a.f
    public final boolean requiresSignIn() {
        C0927e clientSettings = getClientSettings();
        return (TextUtils.isEmpty(clientSettings.c()) || clientSettings.f(AbstractC1687b.f13983a).isEmpty()) ? false : true;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final boolean usesClientTelemetry() {
        return true;
    }
}
