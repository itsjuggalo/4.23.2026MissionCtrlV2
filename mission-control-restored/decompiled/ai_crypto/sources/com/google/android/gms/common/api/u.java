package com.google.android.gms.common.api;

import P1.C0648b;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class u implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        String strQ = null;
        C0648b c0648b = null;
        int iF = 0;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            int iW = Q1.b.w(iD);
            if (iW == 1) {
                iF = Q1.b.F(parcel, iD);
            } else if (iW == 2) {
                strQ = Q1.b.q(parcel, iD);
            } else if (iW == 3) {
                pendingIntent = (PendingIntent) Q1.b.p(parcel, iD, PendingIntent.CREATOR);
            } else if (iW != 4) {
                Q1.b.L(parcel, iD);
            } else {
                c0648b = (C0648b) Q1.b.p(parcel, iD, C0648b.CREATOR);
            }
        }
        Q1.b.v(parcel, iM);
        return new Status(iF, strQ, pendingIntent, c0648b);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new Status[i7];
    }
}
