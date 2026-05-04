package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.auth.api.identity.ClearTokenRequest;
import com.google.android.gms.auth.api.identity.RevokeAccessRequest;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zbj extends zba implements IInterface {
    public zbj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.IAuthorizationService");
    }

    public final void zbc(zbi zbiVar, AuthorizationRequest authorizationRequest, c cVar) {
        Parcel parcelZba = zba();
        zbc.zbc(parcelZba, zbiVar);
        zbc.zbb(parcelZba, authorizationRequest);
        zbc.zbb(parcelZba, cVar);
        zbb(1, parcelZba);
    }

    public final void zbd(h hVar, RevokeAccessRequest revokeAccessRequest, c cVar) {
        Parcel parcelZba = zba();
        zbc.zbc(parcelZba, hVar);
        zbc.zbb(parcelZba, revokeAccessRequest);
        zbc.zbb(parcelZba, cVar);
        zbb(3, parcelZba);
    }

    public final void zbe(h hVar, ClearTokenRequest clearTokenRequest, c cVar) {
        Parcel parcelZba = zba();
        zbc.zbc(parcelZba, hVar);
        zbc.zbb(parcelZba, clearTokenRequest);
        zbc.zbb(parcelZba, cVar);
        zbb(4, parcelZba);
    }
}
