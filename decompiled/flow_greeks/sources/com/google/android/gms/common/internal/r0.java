package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class r0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        int iF = 0;
        boolean zX = false;
        boolean zX2 = false;
        IBinder iBinderE = null;
        m5.b bVar = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            int iW = n5.b.w(iD);
            if (iW == 1) {
                iF = n5.b.F(parcel, iD);
            } else if (iW == 2) {
                iBinderE = n5.b.E(parcel, iD);
            } else if (iW == 3) {
                bVar = (m5.b) n5.b.p(parcel, iD, m5.b.CREATOR);
            } else if (iW == 4) {
                zX = n5.b.x(parcel, iD);
            } else if (iW != 5) {
                n5.b.L(parcel, iD);
            } else {
                zX2 = n5.b.x(parcel, iD);
            }
        }
        n5.b.v(parcel, iM);
        return new q0(iF, iBinderE, bVar, zX, zX2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new q0[i10];
    }
}
