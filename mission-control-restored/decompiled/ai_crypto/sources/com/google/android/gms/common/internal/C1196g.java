package com.google.android.gms.common.internal;

import P1.C0650d;
import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.InterfaceC1200k;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1196g extends Q1.a {
    public static final Parcelable.Creator<C1196g> CREATOR = new p0();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Scope[] f11083o = new Scope[0];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final C0650d[] f11084p = new C0650d[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f11088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IBinder f11089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Scope[] f11090f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bundle f11091g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Account f11092h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public C0650d[] f11093i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public C0650d[] f11094j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f11095k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f11096l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f11097m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f11098n;

    public C1196g(int i7, int i8, int i9, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, C0650d[] c0650dArr, C0650d[] c0650dArr2, boolean z7, int i10, boolean z8, String str2) {
        scopeArr = scopeArr == null ? f11083o : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        c0650dArr = c0650dArr == null ? f11084p : c0650dArr;
        c0650dArr2 = c0650dArr2 == null ? f11084p : c0650dArr2;
        this.f11085a = i7;
        this.f11086b = i8;
        this.f11087c = i9;
        if ("com.google.android.gms".equals(str)) {
            this.f11088d = "com.google.android.gms";
        } else {
            this.f11088d = str;
        }
        if (i7 < 2) {
            this.f11092h = iBinder != null ? AbstractBinderC1189a.c(InterfaceC1200k.a.b(iBinder)) : null;
        } else {
            this.f11089e = iBinder;
            this.f11092h = account;
        }
        this.f11090f = scopeArr;
        this.f11091g = bundle;
        this.f11093i = c0650dArr;
        this.f11094j = c0650dArr2;
        this.f11095k = z7;
        this.f11096l = i10;
        this.f11097m = z8;
        this.f11098n = str2;
    }

    public String A() {
        return this.f11098n;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        p0.a(this, parcel, i7);
    }
}
