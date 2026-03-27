package com.google.android.gms.internal.p002firebaseauthapi;

import A1.b;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzaiq implements Parcelable.Creator<zzair> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzair createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            b.w(iD);
            b.L(parcel, iD);
        }
        b.v(parcel, iM);
        return new zzair();
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzair[] newArray(int i4) {
        return new zzair[i4];
    }
}
