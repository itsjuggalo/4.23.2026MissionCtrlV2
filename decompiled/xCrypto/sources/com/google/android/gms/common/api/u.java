package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import z1.C1984b;

/* JADX INFO: loaded from: classes.dex */
public final class u implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        String strQ = null;
        C1984b c1984b = null;
        int iF = 0;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                iF = A1.b.F(parcel, iD);
            } else if (iW == 2) {
                strQ = A1.b.q(parcel, iD);
            } else if (iW == 3) {
                pendingIntent = (PendingIntent) A1.b.p(parcel, iD, PendingIntent.CREATOR);
            } else if (iW != 4) {
                A1.b.L(parcel, iD);
            } else {
                c1984b = (C1984b) A1.b.p(parcel, iD, C1984b.CREATOR);
            }
        }
        A1.b.v(parcel, iM);
        return new Status(iF, strQ, pendingIntent, c1984b);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new Status[i4];
    }
}
