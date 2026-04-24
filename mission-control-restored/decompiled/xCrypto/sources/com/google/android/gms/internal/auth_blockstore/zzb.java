package com.google.android.gms.internal.auth_blockstore;

import android.os.BadParcelableException;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public class zzb extends Binder implements IInterface {
    private static zzd globalInterceptor;

    public zzb(String str) {
        attachInterface(this, str);
    }

    private boolean routeToSuperOrEnforceInterface(int i4, Parcel parcel, Parcel parcel2, int i5) {
        if (i4 > 16777215) {
            return super.onTransact(i4, parcel, parcel2, i5);
        }
        parcel.enforceInterface(getInterfaceDescriptor());
        return false;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public boolean dispatchTransaction(int i4, Parcel parcel, Parcel parcel2, int i5) {
        throw null;
    }

    public void enforceNoDataAvail(Parcel parcel) {
        zzd zzdVar = globalInterceptor;
        if (zzdVar != null) {
            zzdVar.zza();
            return;
        }
        int i4 = zzc.zza;
        int iDataAvail = parcel.dataAvail();
        if (iDataAvail <= 0) {
            return;
        }
        throw new BadParcelableException("Parcel data not fully consumed, unread size: " + iDataAvail);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
        if (routeToSuperOrEnforceInterface(i4, parcel, parcel2, i5)) {
            return true;
        }
        zzd zzdVar = globalInterceptor;
        return zzdVar == null ? dispatchTransaction(i4, parcel, parcel2, i5) : zzdVar.zzb();
    }
}
