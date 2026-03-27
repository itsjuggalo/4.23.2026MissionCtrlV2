package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.InterfaceC0933k;
import z1.C1986d;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0929g extends A1.a {
    public static final Parcelable.Creator<C0929g> CREATOR = new p0();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Scope[] f9900o = new Scope[0];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final C1986d[] f9901p = new C1986d[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f9905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IBinder f9906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Scope[] f9907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bundle f9908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Account f9909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public C1986d[] f9910i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public C1986d[] f9911j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f9912k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f9913l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f9914m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f9915n;

    public C0929g(int i4, int i5, int i6, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, C1986d[] c1986dArr, C1986d[] c1986dArr2, boolean z4, int i7, boolean z5, String str2) {
        scopeArr = scopeArr == null ? f9900o : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        c1986dArr = c1986dArr == null ? f9901p : c1986dArr;
        c1986dArr2 = c1986dArr2 == null ? f9901p : c1986dArr2;
        this.f9902a = i4;
        this.f9903b = i5;
        this.f9904c = i6;
        if ("com.google.android.gms".equals(str)) {
            this.f9905d = "com.google.android.gms";
        } else {
            this.f9905d = str;
        }
        if (i4 < 2) {
            this.f9909h = iBinder != null ? AbstractBinderC0922a.c(InterfaceC0933k.a.b(iBinder)) : null;
        } else {
            this.f9906e = iBinder;
            this.f9909h = account;
        }
        this.f9907f = scopeArr;
        this.f9908g = bundle;
        this.f9910i = c1986dArr;
        this.f9911j = c1986dArr2;
        this.f9912k = z4;
        this.f9913l = i7;
        this.f9914m = z5;
        this.f9915n = str2;
    }

    public String i() {
        return this.f9915n;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        p0.a(this, parcel, i4);
    }
}
