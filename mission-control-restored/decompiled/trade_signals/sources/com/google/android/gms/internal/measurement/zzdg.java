package com.google.android.gms.internal.measurement;

import T1.b;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzdg implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = b.w(parcel);
        String strF = null;
        int iR = 0;
        Intent intent = null;
        while (parcel.dataPosition() < iW) {
            int iP = b.p(parcel);
            int iK = b.k(iP);
            if (iK == 1) {
                iR = b.r(parcel, iP);
            } else if (iK == 2) {
                strF = b.f(parcel, iP);
            } else if (iK != 3) {
                b.v(parcel, iP);
            } else {
                intent = (Intent) b.e(parcel, iP, Intent.CREATOR);
            }
        }
        b.j(parcel, iW);
        return new zzdf(iR, strF, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new zzdf[i8];
    }
}
