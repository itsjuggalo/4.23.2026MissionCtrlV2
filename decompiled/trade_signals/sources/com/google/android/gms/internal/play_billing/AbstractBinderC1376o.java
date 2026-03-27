package com.google.android.gms.internal.play_billing;

import android.os.Parcel;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC1376o extends AbstractBinderC1351j implements InterfaceC1381p {
    public AbstractBinderC1376o() {
        super("com.google.android.apps.play.billingtestcompanion.aidl.IBillingOverrideServiceCallback");
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractBinderC1351j
    public final boolean D(int i8, Parcel parcel, Parcel parcel2, int i9) {
        if (i8 != 1) {
            return false;
        }
        int i10 = parcel.readInt();
        AbstractC1356k.b(parcel);
        zza(i10);
        return true;
    }
}
