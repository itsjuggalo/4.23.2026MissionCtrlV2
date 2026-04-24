package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class Y implements InterfaceC0936n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f9870a;

    public Y(IBinder iBinder) {
        this.f9870a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f9870a;
    }

    @Override // com.google.android.gms.common.internal.InterfaceC0936n
    public final void m(InterfaceC0935m interfaceC0935m, C0929g c0929g) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(interfaceC0935m != null ? interfaceC0935m.asBinder() : null);
            if (c0929g != null) {
                parcelObtain.writeInt(1);
                p0.a(c0929g, parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.f9870a.transact(46, parcelObtain, parcelObtain2, 0);
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
