package com.google.android.gms.internal.location;

import A1.b;
import P1.Y;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0926d;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzk implements Parcelable.Creator<zzj> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzj createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        Y y4 = zzj.zzb;
        List<C0926d> listU = zzj.zza;
        String strQ = null;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            int iW = b.w(iD);
            if (iW == 1) {
                y4 = (Y) b.p(parcel, iD, Y.CREATOR);
            } else if (iW == 2) {
                listU = b.u(parcel, iD, C0926d.CREATOR);
            } else if (iW != 3) {
                b.L(parcel, iD);
            } else {
                strQ = b.q(parcel, iD);
            }
        }
        b.v(parcel, iM);
        return new zzj(y4, listU, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzj[] newArray(int i4) {
        return new zzj[i4];
    }
}
