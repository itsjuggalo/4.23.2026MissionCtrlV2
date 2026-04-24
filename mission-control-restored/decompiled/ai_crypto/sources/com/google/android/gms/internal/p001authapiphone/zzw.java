package com.google.android.gms.internal.p001authapiphone;

import P1.C0650d;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.internal.InterfaceC1169f;
import com.google.android.gms.common.api.internal.InterfaceC1178o;
import com.google.android.gms.common.internal.AbstractC1197h;
import com.google.android.gms.common.internal.C1194e;

/* JADX INFO: loaded from: classes.dex */
public final class zzw extends AbstractC1197h {
    public zzw(Context context, Looper looper, C1194e c1194e, InterfaceC1169f interfaceC1169f, InterfaceC1178o interfaceC1178o) {
        super(context, looper, 126, c1194e, interfaceC1169f, interfaceC1178o);
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
        return iInterfaceQueryLocalInterface instanceof zzh ? (zzh) iInterfaceQueryLocalInterface : new zzh(iBinder);
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final C0650d[] getApiFeatures() {
        return zzac.zze;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c, com.google.android.gms.common.api.a.f
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.phone.service.SmsRetrieverApiService.START";
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final boolean usesClientTelemetry() {
        return true;
    }
}
