package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC1311b extends AbstractBinderC1351j implements InterfaceC1316c {
    public AbstractBinderC1311b() {
        super("com.android.vending.billing.IInAppBillingGetBillingConfigCallback");
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractBinderC1351j
    public final boolean D(int i8, Parcel parcel, Parcel parcel2, int i9) {
        if (i8 != 1) {
            return false;
        }
        Bundle bundle = (Bundle) AbstractC1356k.a(parcel, Bundle.CREATOR);
        AbstractC1356k.b(parcel);
        a(bundle);
        parcel2.writeNoException();
        return true;
    }
}
