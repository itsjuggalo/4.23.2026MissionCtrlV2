package com.google.android.gms.internal.p000authapi;

import G1.g;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.AbstractC1197h;
import com.google.android.gms.common.internal.C1194e;

/* JADX INFO: loaded from: classes.dex */
public final class zbe extends AbstractC1197h {
    private final g zba;

    public zbe(Context context, Looper looper, C1194e c1194e, g gVar, f.b bVar, f.c cVar) {
        super(context, looper, 68, c1194e, bVar, cVar);
        G1.f fVar = new G1.f(gVar == null ? g.f2420d : gVar);
        fVar.a(zbat.zba());
        this.zba = new g(fVar);
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        return iInterfaceQueryLocalInterface instanceof zbf ? (zbf) iInterfaceQueryLocalInterface : new zbf(iBinder);
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final Bundle getGetServiceRequestExtraArgs() {
        return this.zba.a();
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c, com.google.android.gms.common.api.a.f
    public final int getMinApkVersion() {
        return 12800000;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }
}
