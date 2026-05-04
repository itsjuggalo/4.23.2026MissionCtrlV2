package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class t0 implements Parcelable.Creator {
    public static void c(s0 s0Var, Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.j(parcel, 2, s0Var.f6400a, false);
        n5.c.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public s0 createFromParcel(Parcel parcel) {
        int iM = n5.b.M(parcel);
        Bundle bundleF = null;
        while (parcel.dataPosition() < iM) {
            int iD = n5.b.D(parcel);
            if (n5.b.w(iD) != 2) {
                n5.b.L(parcel, iD);
            } else {
                bundleF = n5.b.f(parcel, iD);
            }
        }
        n5.b.v(parcel, iM);
        return new s0(bundleF);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public s0[] newArray(int i10) {
        return new s0[i10];
    }
}
