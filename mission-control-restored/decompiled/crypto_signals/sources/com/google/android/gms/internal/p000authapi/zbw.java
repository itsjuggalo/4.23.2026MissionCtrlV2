package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.internal.InterfaceC0406i;
import o1.f;
import o1.i;
import o1.j;

/* JADX INFO: loaded from: classes.dex */
public final class zbw extends zba implements IInterface {
    public zbw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.ISignInService");
    }

    public final void zbc(zbm zbmVar, f fVar) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, zbmVar);
        zbc.zbc(parcelZba, fVar);
        zbb(1, parcelZba);
    }

    public final void zbd(zbp zbpVar, i iVar, String str) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, zbpVar);
        zbc.zbc(parcelZba, iVar);
        parcelZba.writeString(str);
        zbb(4, parcelZba);
    }

    public final void zbe(zbr zbrVar, j jVar) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, zbrVar);
        zbc.zbc(parcelZba, jVar);
        zbb(3, parcelZba);
    }

    public final void zbf(InterfaceC0406i interfaceC0406i, String str) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, interfaceC0406i);
        parcelZba.writeString(str);
        zbb(2, parcelZba);
    }
}
