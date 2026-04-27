package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class RemoteMessageCreator implements Parcelable.Creator<RemoteMessage> {
    public static final int CONTENT_DESCRIPTION = 0;

    public static void writeToParcel(RemoteMessage remoteMessage, Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.j(parcel, 2, remoteMessage.bundle, false);
        A1.c.b(parcel, iA);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public RemoteMessage createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        Bundle bundleF = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            if (A1.b.w(iD) != 2) {
                A1.b.L(parcel, iD);
            } else {
                bundleF = A1.b.f(parcel, iD);
            }
        }
        A1.b.v(parcel, iM);
        return new RemoteMessage(bundleF);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public RemoteMessage[] newArray(int i4) {
        return new RemoteMessage[i4];
    }
}
