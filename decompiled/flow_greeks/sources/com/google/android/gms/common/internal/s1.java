package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.common.zza;
import w5.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s1 extends zza implements u1 {
    public s1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.u1
    public final w5.a zzd() {
        Parcel parcelZzB = zzB(1, zza());
        w5.a aVarH = a.AbstractBinderC0411a.H(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarH;
    }

    @Override // com.google.android.gms.common.internal.u1
    public final int zze() {
        Parcel parcelZzB = zzB(2, zza());
        int i10 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i10;
    }
}
