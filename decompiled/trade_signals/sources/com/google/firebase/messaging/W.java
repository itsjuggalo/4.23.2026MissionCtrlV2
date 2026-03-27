package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class W implements Parcelable.Creator {
    public static void c(V v8, Parcel parcel, int i8) {
        int iA = T1.c.a(parcel);
        T1.c.e(parcel, 2, v8.f15635a, false);
        T1.c.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public V createFromParcel(Parcel parcel) {
        int iW = T1.b.w(parcel);
        Bundle bundleA = null;
        while (parcel.dataPosition() < iW) {
            int iP = T1.b.p(parcel);
            if (T1.b.k(iP) != 2) {
                T1.b.v(parcel, iP);
            } else {
                bundleA = T1.b.a(parcel, iP);
            }
        }
        T1.b.j(parcel, iW);
        return new V(bundleA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public V[] newArray(int i8) {
        return new V[i8];
    }
}
