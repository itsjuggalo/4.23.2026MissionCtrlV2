package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1361l extends AbstractC1346i implements InterfaceC1371n {
    public C1361l(IBinder iBinder) {
        super(iBinder, "com.google.android.apps.play.billingtestcompanion.aidl.IBillingOverrideService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.InterfaceC1371n
    public final void u(String str, String str2, InterfaceC1381p interfaceC1381p) {
        Parcel parcelD = D();
        parcelD.writeString(str);
        parcelD.writeString(str2);
        int i8 = AbstractC1356k.f15448a;
        parcelD.writeStrongBinder(interfaceC1381p);
        G(1, parcelD);
    }
}
