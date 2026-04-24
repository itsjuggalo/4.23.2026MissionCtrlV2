package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zac;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0905i extends IInterface {

    /* JADX INFO: renamed from: com.google.android.gms.common.api.internal.i$a */
    public static abstract class a extends zab implements InterfaceC0905i {
        public a() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        public static InterfaceC0905i asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
            return iInterfaceQueryLocalInterface instanceof InterfaceC0905i ? (InterfaceC0905i) iInterfaceQueryLocalInterface : new Y(iBinder);
        }

        @Override // com.google.android.gms.internal.base.zab
        public final boolean zaa(int i4, Parcel parcel, Parcel parcel2, int i5) {
            if (i4 != 1) {
                return false;
            }
            Status status = (Status) zac.zaa(parcel, Status.CREATOR);
            zac.zab(parcel);
            onResult(status);
            return true;
        }
    }

    void onResult(Status status);
}
