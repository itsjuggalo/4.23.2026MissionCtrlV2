package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class q0 extends e2.d implements L {
    public q0() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static L E(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return iInterfaceQueryLocalInterface instanceof L ? (L) iInterfaceQueryLocalInterface : new p0(iBinder);
    }

    @Override // e2.d
    public final boolean D(int i8, Parcel parcel, Parcel parcel2, int i9) {
        if (i8 == 1) {
            Z1.a aVarZzd = zzd();
            parcel2.writeNoException();
            e2.e.d(parcel2, aVarZzd);
        } else {
            if (i8 != 2) {
                return false;
            }
            int iZzc = zzc();
            parcel2.writeNoException();
            parcel2.writeInt(iZzc);
        }
        return true;
    }
}
