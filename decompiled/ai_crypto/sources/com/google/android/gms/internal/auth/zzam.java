package com.google.android.gms.internal.auth;

import E1.k;
import P1.C0650d;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.AbstractC1197h;
import com.google.android.gms.common.internal.C1194e;

/* JADX INFO: loaded from: classes.dex */
public final class zzam extends AbstractC1197h {
    public zzam(Context context, Looper looper, C1194e c1194e, f.b bVar, f.c cVar) {
        super(context, looper, 120, c1194e, bVar, cVar);
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        return F1.f.b(iBinder);
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final C0650d[] getApiFeatures() {
        return new C0650d[]{k.f1602n};
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c, com.google.android.gms.common.api.a.f
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.account.IWorkAccountService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.account.workaccount.START";
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final boolean usesClientTelemetry() {
        return true;
    }
}
