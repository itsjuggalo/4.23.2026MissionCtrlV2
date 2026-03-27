package com.google.android.gms.internal.auth;

import H1.d;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.AbstractC1197h;
import com.google.android.gms.common.internal.C1194e;

/* JADX INFO: loaded from: classes.dex */
public final class zzap extends AbstractC1197h {
    private final Bundle zze;

    public zzap(Context context, Looper looper, C1194e c1194e, d dVar, f.b bVar, f.c cVar) {
        super(context, looper, 128, c1194e, bVar, cVar);
        this.zze = new Bundle();
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferService");
        return iInterfaceQueryLocalInterface instanceof zzau ? (zzau) iInterfaceQueryLocalInterface : new zzau(iBinder);
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
        return "com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.accounttransfer.service.START";
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final boolean usesClientTelemetry() {
        return true;
    }
}
