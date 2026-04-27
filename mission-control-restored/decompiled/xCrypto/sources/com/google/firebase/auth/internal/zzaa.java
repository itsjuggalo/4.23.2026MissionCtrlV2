package com.google.firebase.auth.internal;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzaa implements Parcelable.Creator<zzab> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzab createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        String strQ5 = null;
        String strQ6 = null;
        String strQ7 = null;
        boolean zX = false;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            switch (b.w(iD)) {
                case 1:
                    strQ = b.q(parcel, iD);
                    break;
                case 2:
                    strQ2 = b.q(parcel, iD);
                    break;
                case 3:
                    strQ5 = b.q(parcel, iD);
                    break;
                case 4:
                    strQ4 = b.q(parcel, iD);
                    break;
                case 5:
                    strQ3 = b.q(parcel, iD);
                    break;
                case 6:
                    strQ6 = b.q(parcel, iD);
                    break;
                case 7:
                    zX = b.x(parcel, iD);
                    break;
                case 8:
                    strQ7 = b.q(parcel, iD);
                    break;
                default:
                    b.L(parcel, iD);
                    break;
            }
        }
        b.v(parcel, iM);
        return new zzab(strQ, strQ2, strQ3, strQ4, strQ5, strQ6, zX, strQ7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzab[] newArray(int i4) {
        return new zzab[i4];
    }
}
