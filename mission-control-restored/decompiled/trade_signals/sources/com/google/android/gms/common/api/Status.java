package com.google.android.gms.common.api;

import Q1.C0790b;
import R1.c;
import R1.k;
import T1.a;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1293m;
import com.google.android.gms.common.internal.ReflectedParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class Status extends a implements ReflectedParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PendingIntent f14917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0790b f14918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Status f14907e = new Status(-1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Status f14908f = new Status(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Status f14909g = new Status(14);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Status f14910h = new Status(8);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Status f14911i = new Status(15);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Status f14912j = new Status(16);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Status f14914l = new Status(17);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Status f14913k = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new k();

    public Status(int i8) {
        this(i8, (String) null);
    }

    public C0790b a() {
        return this.f14918d;
    }

    public int d() {
        return this.f14915a;
    }

    public String e() {
        return this.f14916b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f14915a == status.f14915a && AbstractC1293m.a(this.f14916b, status.f14916b) && AbstractC1293m.a(this.f14917c, status.f14917c) && AbstractC1293m.a(this.f14918d, status.f14918d);
    }

    public boolean f() {
        return this.f14917c != null;
    }

    public final String h() {
        String str = this.f14916b;
        return str != null ? str : c.a(this.f14915a);
    }

    public int hashCode() {
        return AbstractC1293m.b(Integer.valueOf(this.f14915a), this.f14916b, this.f14917c, this.f14918d);
    }

    public String toString() {
        AbstractC1293m.a aVarC = AbstractC1293m.c(this);
        aVarC.a("statusCode", h());
        aVarC.a("resolution", this.f14917c);
        return aVarC.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        int iA = T1.c.a(parcel);
        T1.c.j(parcel, 1, d());
        T1.c.p(parcel, 2, e(), false);
        T1.c.o(parcel, 3, this.f14917c, i8, false);
        T1.c.o(parcel, 4, a(), i8, false);
        T1.c.b(parcel, iA);
    }

    public Status(int i8, String str) {
        this(i8, str, (PendingIntent) null);
    }

    public Status(int i8, String str, PendingIntent pendingIntent) {
        this(i8, str, pendingIntent, null);
    }

    public Status(int i8, String str, PendingIntent pendingIntent, C0790b c0790b) {
        this.f14915a = i8;
        this.f14916b = str;
        this.f14917c = pendingIntent;
        this.f14918d = c0790b;
    }

    public Status(C0790b c0790b, String str) {
        this(c0790b, str, 17);
    }

    public Status(C0790b c0790b, String str, int i8) {
        this(i8, str, c0790b.e(), c0790b);
    }
}
