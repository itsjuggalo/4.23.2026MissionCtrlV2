package com.google.android.gms.common.internal;

import Q1.C0790b;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class J implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        int iR = 0;
        boolean zL = false;
        boolean zL2 = false;
        IBinder iBinderQ = null;
        C0790b c0790b = null;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            int iK = T1.b.k(iP);
            if (iK == 1) {
                iR = T1.b.r(parcel, iP);
            } else if (iK == 2) {
                iBinderQ = T1.b.q(parcel, iP);
            } else if (iK == 3) {
                c0790b = (C0790b) T1.b.e(parcel, iP, C0790b.CREATOR);
            } else if (iK == 4) {
                zL = T1.b.l(parcel, iP);
            } else if (iK != 5) {
                T1.b.v(parcel, iP);
            } else {
                zL2 = T1.b.l(parcel, iP);
            }
        }
        T1.b.j(parcel, iW);
        return new I(iR, iBinderQ, c0790b, zL, zL2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new I[i8];
    }
}
