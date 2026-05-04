package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import c5.k;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.google.android.gms.common.api.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zbm extends zba implements IInterface {
    public zbm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.ICredentialSavingService");
    }

    public final void zbc(zbs zbsVar, SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest, c cVar) {
        Parcel parcelZba = zba();
        zbc.zbc(parcelZba, zbsVar);
        zbc.zbb(parcelZba, saveAccountLinkingTokenRequest);
        zbc.zbb(parcelZba, cVar);
        zbb(1, parcelZba);
    }

    public final void zbd(zbu zbuVar, k kVar, c cVar) {
        Parcel parcelZba = zba();
        zbc.zbc(parcelZba, zbuVar);
        zbc.zbb(parcelZba, kVar);
        zbc.zbb(parcelZba, cVar);
        zbb(2, parcelZba);
    }
}
