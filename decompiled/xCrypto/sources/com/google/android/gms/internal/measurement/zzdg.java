package com.google.android.gms.internal.measurement;

import A1.b;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzdg implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        String strQ = null;
        int iF = 0;
        Intent intent = null;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            int iW = b.w(iD);
            if (iW == 1) {
                iF = b.F(parcel, iD);
            } else if (iW == 2) {
                strQ = b.q(parcel, iD);
            } else if (iW != 3) {
                b.L(parcel, iD);
            } else {
                intent = (Intent) b.p(parcel, iD, Intent.CREATOR);
            }
        }
        b.v(parcel, iM);
        return new zzdf(iF, strQ, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new zzdf[i4];
    }
}
