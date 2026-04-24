package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.internal.InterfaceC0905i;
import r1.C1745b;
import r1.C1748e;
import r1.C1749f;

/* JADX INFO: loaded from: classes.dex */
public final class zbw extends zba implements IInterface {
    public zbw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.ISignInService");
    }

    public final void zbc(zbm zbmVar, C1745b c1745b) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, zbmVar);
        zbc.zbc(parcelZba, c1745b);
        zbb(1, parcelZba);
    }

    public final void zbd(zbp zbpVar, C1748e c1748e, String str) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, zbpVar);
        zbc.zbc(parcelZba, c1748e);
        parcelZba.writeString(str);
        zbb(4, parcelZba);
    }

    public final void zbe(zbr zbrVar, C1749f c1749f) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, zbrVar);
        zbc.zbc(parcelZba, c1749f);
        zbb(3, parcelZba);
    }

    public final void zbf(InterfaceC0905i interfaceC0905i, String str) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, interfaceC0905i);
        parcelZba.writeString(str);
        zbb(2, parcelZba);
    }
}
