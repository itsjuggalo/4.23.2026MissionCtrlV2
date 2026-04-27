package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1321d extends AbstractC1346i implements InterfaceC1331f {
    public C1321d(IBinder iBinder) {
        super(iBinder, "com.android.vending.billing.IInAppBillingService");
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1331f
    public final int B(int i8, String str, String str2) {
        Parcel parcelD = D();
        parcelD.writeInt(i8);
        parcelD.writeString(str);
        parcelD.writeString(str2);
        Parcel parcelE = E(1, parcelD);
        int i9 = parcelE.readInt();
        parcelE.recycle();
        return i9;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1331f
    public final int b(int i8, String str, String str2) {
        Parcel parcelD = D();
        parcelD.writeInt(3);
        parcelD.writeString(str);
        parcelD.writeString(str2);
        Parcel parcelE = E(5, parcelD);
        int i9 = parcelE.readInt();
        parcelE.recycle();
        return i9;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1331f
    public final Bundle c(int i8, String str, String str2, Bundle bundle) {
        Parcel parcelD = D();
        parcelD.writeInt(9);
        parcelD.writeString(str);
        parcelD.writeString(str2);
        AbstractC1356k.c(parcelD, bundle);
        Parcel parcelE = E(12, parcelD);
        Bundle bundle2 = (Bundle) AbstractC1356k.a(parcelE, Bundle.CREATOR);
        parcelE.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1331f
    public final Bundle j(int i8, String str, String str2, String str3, String str4) {
        Parcel parcelD = D();
        parcelD.writeInt(3);
        parcelD.writeString(str);
        parcelD.writeString(str2);
        parcelD.writeString(str3);
        parcelD.writeString(null);
        Parcel parcelE = E(3, parcelD);
        Bundle bundle = (Bundle) AbstractC1356k.a(parcelE, Bundle.CREATOR);
        parcelE.recycle();
        return bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.InterfaceC1331f
    public final void k(int i8, String str, Bundle bundle, InterfaceC1341h interfaceC1341h) {
        Parcel parcelD = D();
        parcelD.writeInt(12);
        parcelD.writeString(str);
        AbstractC1356k.c(parcelD, bundle);
        parcelD.writeStrongBinder(interfaceC1341h);
        F(1201, parcelD);
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1331f
    public final Bundle l(int i8, String str, String str2, String str3) {
        Parcel parcelD = D();
        parcelD.writeInt(3);
        parcelD.writeString(str);
        parcelD.writeString(str2);
        parcelD.writeString(str3);
        Parcel parcelE = E(4, parcelD);
        Bundle bundle = (Bundle) AbstractC1356k.a(parcelE, Bundle.CREATOR);
        parcelE.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1331f
    public final Bundle p(int i8, String str, String str2, String str3, String str4, Bundle bundle) {
        Parcel parcelD = D();
        parcelD.writeInt(i8);
        parcelD.writeString(str);
        parcelD.writeString(str2);
        parcelD.writeString(str3);
        parcelD.writeString(null);
        AbstractC1356k.c(parcelD, bundle);
        Parcel parcelE = E(8, parcelD);
        Bundle bundle2 = (Bundle) AbstractC1356k.a(parcelE, Bundle.CREATOR);
        parcelE.recycle();
        return bundle2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.InterfaceC1331f
    public final void q(int i8, String str, Bundle bundle, InterfaceC1316c interfaceC1316c) {
        Parcel parcelD = D();
        parcelD.writeInt(18);
        parcelD.writeString(str);
        AbstractC1356k.c(parcelD, bundle);
        parcelD.writeStrongBinder(interfaceC1316c);
        F(1301, parcelD);
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1331f
    public final Bundle s(int i8, String str, String str2, String str3, Bundle bundle) {
        Parcel parcelD = D();
        parcelD.writeInt(i8);
        parcelD.writeString(str);
        parcelD.writeString(str2);
        parcelD.writeString(str3);
        AbstractC1356k.c(parcelD, bundle);
        Parcel parcelE = E(11, parcelD);
        Bundle bundle2 = (Bundle) AbstractC1356k.a(parcelE, Bundle.CREATOR);
        parcelE.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1331f
    public final int t(int i8, String str, String str2, Bundle bundle) {
        Parcel parcelD = D();
        parcelD.writeInt(i8);
        parcelD.writeString(str);
        parcelD.writeString(str2);
        AbstractC1356k.c(parcelD, bundle);
        Parcel parcelE = E(10, parcelD);
        int i9 = parcelE.readInt();
        parcelE.recycle();
        return i9;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1331f
    public final Bundle v(int i8, String str, String str2, Bundle bundle, Bundle bundle2) {
        Parcel parcelD = D();
        parcelD.writeInt(i8);
        parcelD.writeString(str);
        parcelD.writeString(str2);
        AbstractC1356k.c(parcelD, bundle);
        AbstractC1356k.c(parcelD, bundle2);
        Parcel parcelE = E(901, parcelD);
        Bundle bundle3 = (Bundle) AbstractC1356k.a(parcelE, Bundle.CREATOR);
        parcelE.recycle();
        return bundle3;
    }

    @Override // com.google.android.gms.internal.play_billing.InterfaceC1331f
    public final Bundle z(int i8, String str, String str2, Bundle bundle) {
        Parcel parcelD = D();
        parcelD.writeInt(9);
        parcelD.writeString(str);
        parcelD.writeString(str2);
        AbstractC1356k.c(parcelD, bundle);
        Parcel parcelE = E(902, parcelD);
        Bundle bundle2 = (Bundle) AbstractC1356k.a(parcelE, Bundle.CREATOR);
        parcelE.recycle();
        return bundle2;
    }
}
