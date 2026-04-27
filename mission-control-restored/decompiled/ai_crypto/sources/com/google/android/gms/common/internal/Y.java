package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class Y implements InterfaceC1203n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f11053a;

    public Y(IBinder iBinder) {
        this.f11053a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f11053a;
    }

    @Override // com.google.android.gms.common.internal.InterfaceC1203n
    public final void m(InterfaceC1202m interfaceC1202m, C1196g c1196g) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(interfaceC1202m != null ? interfaceC1202m.asBinder() : null);
            if (c1196g != null) {
                parcelObtain.writeInt(1);
                p0.a(c1196g, parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.f11053a.transact(46, parcelObtain, parcelObtain2, 0);
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
