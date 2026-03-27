package com.google.android.gms.internal.p000authapi;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.AbstractC0930h;
import com.google.android.gms.common.internal.C0927e;
import p1.C1691f;
import p1.C1692g;

/* JADX INFO: loaded from: classes.dex */
public final class zbe extends AbstractC0930h {
    private final C1692g zba;

    public zbe(Context context, Looper looper, C0927e c0927e, C1692g c1692g, f.b bVar, f.c cVar) {
        super(context, looper, 68, c0927e, bVar, cVar);
        C1691f c1691f = new C1691f(c1692g == null ? C1692g.f13991d : c1692g);
        c1691f.a(zbat.zba());
        this.zba = new C1692g(c1691f);
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        return iInterfaceQueryLocalInterface instanceof zbf ? (zbf) iInterfaceQueryLocalInterface : new zbf(iBinder);
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final Bundle getGetServiceRequestExtraArgs() {
        return this.zba.a();
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c, com.google.android.gms.common.api.a.f
    public final int getMinApkVersion() {
        return 12800000;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }
}
