package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements Parcelable.Creator {
    public static final c a(Parcel parcel) {
        int iM = n5.b.M(parcel);
        boolean zX = false;
        e eVar = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 1) {
                eVar = (e) n5.b.p(parcel, iD, e.CREATOR);
            } else if (iW != 2) {
                n5.b.L(parcel, iD);
            } else {
                zX = n5.b.x(parcel, iD);
            }
        }
        n5.b.v(parcel, iM);
        return new c(eVar, zX);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new c[i10];
    }
}
