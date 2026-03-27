package com.google.android.gms.internal.auth;

import G1.b;
import G1.c;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.api.internal.InterfaceC1169f;
import com.google.android.gms.common.api.internal.InterfaceC1178o;
import com.google.android.gms.common.internal.AbstractC1197h;
import com.google.android.gms.common.internal.C1194e;

/* JADX INFO: loaded from: classes.dex */
public final class zzbe extends AbstractC1197h {
    private final Bundle zze;

    public zzbe(Context context, Looper looper, C1194e c1194e, c cVar, InterfaceC1169f interfaceC1169f, InterfaceC1178o interfaceC1178o) {
        super(context, looper, 16, c1194e, interfaceC1169f, interfaceC1178o);
        this.zze = cVar == null ? new Bundle() : cVar.a();
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        return iInterfaceQueryLocalInterface instanceof zzbh ? (zzbh) iInterfaceQueryLocalInterface : new zzbh(iBinder);
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final Bundle getGetServiceRequestExtraArgs() {
        return this.zze;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c, com.google.android.gms.common.api.a.f
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.service.START";
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c, com.google.android.gms.common.api.a.f
    public final boolean requiresSignIn() {
        C1194e clientSettings = getClientSettings();
        return (TextUtils.isEmpty(clientSettings.c()) || clientSettings.f(b.f2412a).isEmpty()) ? false : true;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final boolean usesClientTelemetry() {
        return true;
    }
}
