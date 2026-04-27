package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import e2.AbstractC1663a;

/* JADX INFO: loaded from: classes.dex */
public final class o0 extends AbstractC1663a implements InterfaceC1289i {
    public o0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // com.google.android.gms.common.internal.InterfaceC1289i
    public final Account zzb() {
        Parcel parcelD = D(2, E());
        Account account = (Account) e2.e.a(parcelD, Account.CREATOR);
        parcelD.recycle();
        return account;
    }
}
