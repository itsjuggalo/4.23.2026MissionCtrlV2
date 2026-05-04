package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import c5.c;
import c5.g;
import com.google.android.gms.common.api.internal.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zbv extends zba implements IInterface {
    public zbv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.ISignInService");
    }

    public final void zbc(zbl zblVar, c cVar, com.google.android.gms.common.api.c cVar2) {
        Parcel parcelZba = zba();
        zbc.zbc(parcelZba, zblVar);
        zbc.zbb(parcelZba, cVar);
        zbc.zbb(parcelZba, cVar2);
        zbb(1, parcelZba);
    }

    public final void zbd(h hVar, String str, com.google.android.gms.common.api.c cVar) {
        Parcel parcelZba = zba();
        zbc.zbc(parcelZba, hVar);
        parcelZba.writeString(str);
        zbc.zbb(parcelZba, cVar);
        zbb(2, parcelZba);
    }

    public final void zbe(zbq zbqVar, c5.h hVar, com.google.android.gms.common.api.c cVar) {
        Parcel parcelZba = zba();
        zbc.zbc(parcelZba, zbqVar);
        zbc.zbb(parcelZba, hVar);
        zbc.zbb(parcelZba, cVar);
        zbb(3, parcelZba);
    }

    public final void zbf(zbo zboVar, g gVar, String str, com.google.android.gms.common.api.c cVar) {
        Parcel parcelZba = zba();
        zbc.zbc(parcelZba, zboVar);
        zbc.zbb(parcelZba, gVar);
        parcelZba.writeString(str);
        zbc.zbb(parcelZba, cVar);
        zbb(4, parcelZba);
    }
}
