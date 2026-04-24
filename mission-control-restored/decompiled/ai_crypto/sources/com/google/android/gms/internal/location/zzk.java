package com.google.android.gms.internal.location;

import Q1.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C1193d;
import f2.C1573Y;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzk implements Parcelable.Creator<zzj> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzj createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        C1573Y c1573y = zzj.zzb;
        List<C1193d> listU = zzj.zza;
        String strQ = null;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            int iW = b.w(iD);
            if (iW == 1) {
                c1573y = (C1573Y) b.p(parcel, iD, C1573Y.CREATOR);
            } else if (iW == 2) {
                listU = b.u(parcel, iD, C1193d.CREATOR);
            } else if (iW != 3) {
                b.L(parcel, iD);
            } else {
                strQ = b.q(parcel, iD);
            }
        }
        b.v(parcel, iM);
        return new zzj(c1573y, listU, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzj[] newArray(int i7) {
        return new zzj[i7];
    }
}
