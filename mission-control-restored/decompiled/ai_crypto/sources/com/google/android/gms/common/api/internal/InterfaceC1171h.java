package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zac;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC1171h extends IInterface {

    /* JADX INFO: renamed from: com.google.android.gms.common.api.internal.h$a */
    public static abstract class a extends zab implements InterfaceC1171h {
        public a() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        public static InterfaceC1171h asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
            return iInterfaceQueryLocalInterface instanceof InterfaceC1171h ? (InterfaceC1171h) iInterfaceQueryLocalInterface : new V(iBinder);
        }

        @Override // com.google.android.gms.internal.base.zab
        public final boolean zaa(int i7, Parcel parcel, Parcel parcel2, int i8) {
            if (i7 != 1) {
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
