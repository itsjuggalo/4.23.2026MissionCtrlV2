package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.api.internal.InterfaceC0403f;
import com.google.android.gms.common.api.internal.InterfaceC0413p;
import com.google.android.gms.common.internal.AbstractC0433k;
import com.google.android.gms.common.internal.C0430h;
import m1.b;
import m1.c;

/* JADX INFO: loaded from: classes.dex */
public final class zzbe extends AbstractC0433k {
    private final Bundle zze;

    public zzbe(Context context, Looper looper, C0430h c0430h, c cVar, InterfaceC0403f interfaceC0403f, InterfaceC0413p interfaceC0413p) {
        super(context, looper, 16, c0430h, interfaceC0403f, interfaceC0413p);
        this.zze = cVar == null ? new Bundle() : new Bundle(cVar.f8456a);
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        return iInterfaceQueryLocalInterface instanceof zzbh ? (zzbh) iInterfaceQueryLocalInterface : new zzbh(iBinder);
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final Bundle getGetServiceRequestExtraArgs() {
        return this.zze;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.service.START";
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f, com.google.android.gms.common.api.g
    public final boolean requiresSignIn() {
        C0430h clientSettings = getClientSettings();
        clientSettings.getClass();
        if (TextUtils.isEmpty(null)) {
            return false;
        }
        if (clientSettings.f5239c.get(b.f8454a) == null) {
            return !clientSettings.f5237a.isEmpty();
        }
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final boolean usesClientTelemetry() {
        return true;
    }
}
