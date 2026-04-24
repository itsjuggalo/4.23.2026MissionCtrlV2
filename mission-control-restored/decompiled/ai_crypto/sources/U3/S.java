package U3;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class S implements Parcelable.Creator {
    public static void c(com.google.firebase.messaging.d dVar, Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.j(parcel, 2, dVar.f12219a, false);
        Q1.c.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.google.firebase.messaging.d createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        Bundle bundleF = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            if (Q1.b.w(iD) != 2) {
                Q1.b.L(parcel, iD);
            } else {
                bundleF = Q1.b.f(parcel, iD);
            }
        }
        Q1.b.v(parcel, iM);
        return new com.google.firebase.messaging.d(bundleF);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.google.firebase.messaging.d[] newArray(int i7) {
        return new com.google.firebase.messaging.d[i7];
    }
}
