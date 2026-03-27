package com.google.android.gms.common.internal;

import Q1.C0792d;
import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.InterfaceC1289i;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1286f extends T1.a {
    public static final Parcelable.Creator<C1286f> CREATOR = new f0();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Scope[] f14980o = new Scope[0];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final C0792d[] f14981p = new C0792d[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f14985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IBinder f14986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Scope[] f14987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bundle f14988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Account f14989h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public C0792d[] f14990i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public C0792d[] f14991j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f14992k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f14993l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f14994m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f14995n;

    public C1286f(int i8, int i9, int i10, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, C0792d[] c0792dArr, C0792d[] c0792dArr2, boolean z7, int i11, boolean z8, String str2) {
        scopeArr = scopeArr == null ? f14980o : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        c0792dArr = c0792dArr == null ? f14981p : c0792dArr;
        c0792dArr2 = c0792dArr2 == null ? f14981p : c0792dArr2;
        this.f14982a = i8;
        this.f14983b = i9;
        this.f14984c = i10;
        if ("com.google.android.gms".equals(str)) {
            this.f14985d = "com.google.android.gms";
        } else {
            this.f14985d = str;
        }
        if (i8 < 2) {
            this.f14989h = iBinder != null ? AbstractBinderC1281a.F(InterfaceC1289i.a.E(iBinder)) : null;
        } else {
            this.f14986e = iBinder;
            this.f14989h = account;
        }
        this.f14987f = scopeArr;
        this.f14988g = bundle;
        this.f14990i = c0792dArr;
        this.f14991j = c0792dArr2;
        this.f14992k = z7;
        this.f14993l = i11;
        this.f14994m = z8;
        this.f14995n = str2;
    }

    public String a() {
        return this.f14995n;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        f0.a(this, parcel, i8);
    }
}
