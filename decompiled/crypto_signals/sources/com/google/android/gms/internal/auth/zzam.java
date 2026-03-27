package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.m;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.internal.AbstractC0433k;
import com.google.android.gms.common.internal.C0430h;
import k1.AbstractC0753f;
import l1.d;
import l1.e;
import l1.f;
import u1.C1202d;

/* JADX INFO: loaded from: classes.dex */
public final class zzam extends AbstractC0433k {
    public zzam(Context context, Looper looper, C0430h c0430h, m mVar, n nVar) {
        super(context, looper, 120, c0430h, mVar, nVar);
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final IInterface createServiceInterface(IBinder iBinder) {
        int i = e.f8067a;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.account.IWorkAccountService");
        return iInterfaceQueryLocalInterface instanceof f ? (f) iInterfaceQueryLocalInterface : new d(iBinder, "com.google.android.gms.auth.account.IWorkAccountService");
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final C1202d[] getApiFeatures() {
        return new C1202d[]{AbstractC0753f.f7831d};
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.account.IWorkAccountService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.account.workaccount.START";
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final boolean usesClientTelemetry() {
        return true;
    }
}
