package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class M extends e2.d implements InterfaceC1290j {
    public M() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // e2.d
    public final boolean D(int i8, Parcel parcel, Parcel parcel2, int i9) {
        if (i8 == 1) {
            int i10 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) e2.e.a(parcel, Bundle.CREATOR);
            e2.e.b(parcel);
            m(i10, strongBinder, bundle);
        } else if (i8 == 2) {
            int i11 = parcel.readInt();
            Bundle bundle2 = (Bundle) e2.e.a(parcel, Bundle.CREATOR);
            e2.e.b(parcel);
            i(i11, bundle2);
        } else {
            if (i8 != 3) {
                return false;
            }
            int i12 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            c0 c0Var = (c0) e2.e.a(parcel, c0.CREATOR);
            e2.e.b(parcel);
            x(i12, strongBinder2, c0Var);
        }
        parcel2.writeNoException();
        return true;
    }
}
