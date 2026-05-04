package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import n5.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzab implements Parcelable.Creator<zzaa> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzaa createFromParcel(Parcel parcel) {
        int iM = b.M(parcel);
        Status status = null;
        while (parcel.dataPosition() < iM) {
            int iD = b.D(parcel);
            if (b.w(iD) != 1) {
                b.L(parcel, iD);
            } else {
                status = (Status) b.p(parcel, iD, Status.CREATOR);
            }
        }
        b.v(parcel, iM);
        return new zzaa(status);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzaa[] newArray(int i10) {
        return new zzaa[i10];
    }
}
