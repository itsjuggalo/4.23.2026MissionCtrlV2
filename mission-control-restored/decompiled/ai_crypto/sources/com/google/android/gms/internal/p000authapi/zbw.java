package com.google.android.gms.internal.p000authapi;

import I1.C0577b;
import I1.C0580e;
import I1.C0581f;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.internal.InterfaceC1171h;

/* JADX INFO: loaded from: classes.dex */
public final class zbw extends zba implements IInterface {
    public zbw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.ISignInService");
    }

    public final void zbc(zbm zbmVar, C0577b c0577b) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, zbmVar);
        zbc.zbc(parcelZba, c0577b);
        zbb(1, parcelZba);
    }

    public final void zbd(zbp zbpVar, C0580e c0580e, String str) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, zbpVar);
        zbc.zbc(parcelZba, c0580e);
        parcelZba.writeString(str);
        zbb(4, parcelZba);
    }

    public final void zbe(zbr zbrVar, C0581f c0581f) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, zbrVar);
        zbc.zbc(parcelZba, c0581f);
        zbb(3, parcelZba);
    }

    public final void zbf(InterfaceC1171h interfaceC1171h, String str) {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, interfaceC1171h);
        parcelZba.writeString(str);
        zbb(2, parcelZba);
    }
}
