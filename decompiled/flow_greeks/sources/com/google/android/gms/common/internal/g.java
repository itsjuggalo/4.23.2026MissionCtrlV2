package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g extends n5.a {
    public static final Parcelable.Creator<g> CREATOR = new k1();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Scope[] f5704o = new Scope[0];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final m5.d[] f5705p = new m5.d[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IBinder f5710e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Scope[] f5711f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bundle f5712g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Account f5713h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public m5.d[] f5714i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m5.d[] f5715j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f5716k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f5717l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5718m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f5719n;

    public g(int i10, int i11, int i12, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, m5.d[] dVarArr, m5.d[] dVarArr2, boolean z10, int i13, boolean z11, String str2) {
        scopeArr = scopeArr == null ? f5704o : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        dVarArr = dVarArr == null ? f5705p : dVarArr;
        dVarArr2 = dVarArr2 == null ? f5705p : dVarArr2;
        this.f5706a = i10;
        this.f5707b = i11;
        this.f5708c = i12;
        if ("com.google.android.gms".equals(str)) {
            this.f5709d = "com.google.android.gms";
        } else {
            this.f5709d = str;
        }
        if (i10 < 2) {
            this.f5713h = iBinder != null ? a.I(k.a.H(iBinder)) : null;
        } else {
            this.f5710e = iBinder;
            this.f5713h = account;
        }
        this.f5711f = scopeArr;
        this.f5712g = bundle;
        this.f5714i = dVarArr;
        this.f5715j = dVarArr2;
        this.f5716k = z10;
        this.f5717l = i13;
        this.f5718m = z11;
        this.f5719n = str2;
    }

    public String R() {
        return this.f5719n;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        k1.a(this, parcel, i10);
    }
}
