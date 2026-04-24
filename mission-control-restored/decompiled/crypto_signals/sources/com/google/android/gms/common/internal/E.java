package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class E implements InterfaceC0438p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f5195a;

    public E(IBinder iBinder) {
        this.f5195a = iBinder;
    }

    public final void a(L l6, C0432j c0432j) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(l6.asBinder());
            parcelObtain.writeInt(1);
            Q.a(c0432j, parcelObtain, 0);
            this.f5195a.transact(46, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f5195a;
    }
}
