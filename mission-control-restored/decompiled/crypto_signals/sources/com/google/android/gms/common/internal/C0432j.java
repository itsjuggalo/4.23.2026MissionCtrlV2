package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.common.zzc;
import u1.C1202d;
import v1.AbstractC1255a;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0432j extends AbstractC1255a {
    public static final Parcelable.Creator<C0432j> CREATOR = new Q(0);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Scope[] f5248s = new Scope[0];

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final C1202d[] f5249t = new C1202d[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5253d;
    public IBinder e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Scope[] f5254f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Bundle f5255k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Account f5256l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public C1202d[] f5257m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public C1202d[] f5258n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f5259o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f5260p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f5261q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f5262r;

    public C0432j(int i, int i6, int i7, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, C1202d[] c1202dArr, C1202d[] c1202dArr2, boolean z6, int i8, boolean z7, String str2) {
        Scope[] scopeArr2 = scopeArr == null ? f5248s : scopeArr;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        C1202d[] c1202dArr3 = f5249t;
        C1202d[] c1202dArr4 = c1202dArr == null ? c1202dArr3 : c1202dArr;
        c1202dArr3 = c1202dArr2 != null ? c1202dArr2 : c1202dArr3;
        this.f5250a = i;
        this.f5251b = i6;
        this.f5252c = i7;
        if ("com.google.android.gms".equals(str)) {
            this.f5253d = "com.google.android.gms";
        } else {
            this.f5253d = str;
        }
        if (i < 2) {
            Account account2 = null;
            if (iBinder != null) {
                int i9 = AbstractBinderC0423a.f5233a;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                IInterface y = iInterfaceQueryLocalInterface instanceof InterfaceC0436n ? (InterfaceC0436n) iInterfaceQueryLocalInterface : new Y(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
                if (y != null) {
                    long jClearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        try {
                            Y y6 = (Y) y;
                            Parcel parcelZzB = y6.zzB(2, y6.zza());
                            Account account3 = (Account) zzc.zza(parcelZzB, Account.CREATOR);
                            parcelZzB.recycle();
                            Binder.restoreCallingIdentity(jClearCallingIdentity);
                            account2 = account3;
                        } catch (RemoteException unused) {
                            Log.w("AccountAccessor", "Remote account accessor probably died");
                            Binder.restoreCallingIdentity(jClearCallingIdentity);
                        }
                    } catch (Throwable th) {
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                        throw th;
                    }
                }
            }
            this.f5256l = account2;
        } else {
            this.e = iBinder;
            this.f5256l = account;
        }
        this.f5254f = scopeArr2;
        this.f5255k = bundle2;
        this.f5257m = c1202dArr4;
        this.f5258n = c1202dArr3;
        this.f5259o = z6;
        this.f5260p = i8;
        this.f5261q = z7;
        this.f5262r = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Q.a(this, parcel, i);
    }
}
