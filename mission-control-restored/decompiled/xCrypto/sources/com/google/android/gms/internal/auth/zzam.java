package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.AbstractC0930h;
import com.google.android.gms.common.internal.C0927e;
import n1.AbstractC1625k;
import o1.AbstractBinderC1666f;
import z1.C1986d;

/* JADX INFO: loaded from: classes.dex */
public final class zzam extends AbstractC0930h {
    public zzam(Context context, Looper looper, C0927e c0927e, f.b bVar, f.c cVar) {
        super(context, looper, 120, c0927e, bVar, cVar);
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        return AbstractBinderC1666f.b(iBinder);
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final C1986d[] getApiFeatures() {
        return new C1986d[]{AbstractC1625k.f13615n};
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c, com.google.android.gms.common.api.a.f
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.account.IWorkAccountService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.account.workaccount.START";
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final boolean usesClientTelemetry() {
        return true;
    }
}
