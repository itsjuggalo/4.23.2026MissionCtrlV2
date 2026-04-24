package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.b;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            Q1.b.w(iD);
            Q1.b.L(parcel, iD);
        }
        Q1.b.v(parcel, iM);
        return new b.a();
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new b.a[i7];
    }
}
