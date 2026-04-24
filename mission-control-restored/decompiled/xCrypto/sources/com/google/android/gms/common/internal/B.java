package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class B implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        ArrayList arrayListU = null;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            int iW = A1.b.w(iD);
            if (iW == 1) {
                iF = A1.b.F(parcel, iD);
            } else if (iW != 2) {
                A1.b.L(parcel, iD);
            } else {
                arrayListU = A1.b.u(parcel, iD, C0938p.CREATOR);
            }
        }
        A1.b.v(parcel, iM);
        return new C0944w(iF, arrayListU);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0944w[i4];
    }
}
