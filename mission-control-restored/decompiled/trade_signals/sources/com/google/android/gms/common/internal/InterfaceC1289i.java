package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC1289i extends IInterface {

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.i$a */
    public static abstract class a extends e2.d implements InterfaceC1289i {
        public static InterfaceC1289i E(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return iInterfaceQueryLocalInterface instanceof InterfaceC1289i ? (InterfaceC1289i) iInterfaceQueryLocalInterface : new o0(iBinder);
        }
    }

    Account zzb();
}
