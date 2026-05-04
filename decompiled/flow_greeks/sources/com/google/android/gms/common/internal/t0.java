package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class t0 implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f5795a;

    public t0(IBinder iBinder) {
        this.f5795a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f5795a;
    }

    @Override // com.google.android.gms.common.internal.n
    public final void e(m mVar, g gVar) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(mVar != null ? mVar.asBinder() : null);
            if (gVar != null) {
                parcelObtain.writeInt(1);
                k1.a(gVar, parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.f5795a.transact(46, parcelObtain, parcelObtain2, 0);
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
