package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC1326e extends AbstractBinderC1351j implements InterfaceC1331f {
    public static InterfaceC1331f E(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC1331f ? (InterfaceC1331f) iInterfaceQueryLocalInterface : new C1321d(iBinder);
    }
}
