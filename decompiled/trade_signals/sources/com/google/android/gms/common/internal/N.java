package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class N implements InterfaceC1291k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f14937a;

    public N(IBinder iBinder) {
        this.f14937a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f14937a;
    }

    @Override // com.google.android.gms.common.internal.InterfaceC1291k
    public final void g(InterfaceC1290j interfaceC1290j, C1286f c1286f) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(interfaceC1290j != null ? interfaceC1290j.asBinder() : null);
            if (c1286f != null) {
                parcelObtain.writeInt(1);
                f0.a(c1286f, parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.f14937a.transact(46, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            parcelObtain2.recycle();
            parcelObtain.recycle();
        } catch (Throwable th) {
            parcelObtain2.recycle();
            parcelObtain.recycle();
            throw th;
        }
    }
}
