package com.google.android.gms.common.api;

import P1.C0648b;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.ReflectedParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class Status extends Q1.a implements k, ReflectedParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PendingIntent f10847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0648b f10848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Status f10837e = new Status(-1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Status f10838f = new Status(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Status f10839g = new Status(14);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Status f10840h = new Status(8);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Status f10841i = new Status(15);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Status f10842j = new Status(16);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Status f10844l = new Status(17);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Status f10843k = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new u();

    public Status(int i7, String str, PendingIntent pendingIntent, C0648b c0648b) {
        this.f10845a = i7;
        this.f10846b = str;
        this.f10847c = pendingIntent;
        this.f10848d = c0648b;
    }

    public C0648b A() {
        return this.f10848d;
    }

    public int B() {
        return this.f10845a;
    }

    public String C() {
        return this.f10846b;
    }

    public boolean D() {
        return this.f10847c != null;
    }

    public boolean E() {
        return this.f10845a == 16;
    }

    public boolean F() {
        return this.f10845a <= 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f10845a == status.f10845a && AbstractC1206q.b(this.f10846b, status.f10846b) && AbstractC1206q.b(this.f10847c, status.f10847c) && AbstractC1206q.b(this.f10848d, status.f10848d);
    }

    @Override // com.google.android.gms.common.api.k
    public Status getStatus() {
        return this;
    }

    public int hashCode() {
        return AbstractC1206q.c(Integer.valueOf(this.f10845a), this.f10846b, this.f10847c, this.f10848d);
    }

    public String toString() {
        AbstractC1206q.a aVarD = AbstractC1206q.d(this);
        aVarD.a("statusCode", zza());
        aVarD.a("resolution", this.f10847c);
        return aVarD.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, B());
        Q1.c.E(parcel, 2, C(), false);
        Q1.c.C(parcel, 3, this.f10847c, i7, false);
        Q1.c.C(parcel, 4, A(), i7, false);
        Q1.c.b(parcel, iA);
    }

    public final String zza() {
        String str = this.f10846b;
        return str != null ? str : c.a(this.f10845a);
    }

    public Status(int i7) {
        this(i7, (String) null);
    }

    public Status(C0648b c0648b, String str) {
        this(c0648b, str, 17);
    }

    public Status(int i7, String str) {
        this(i7, str, (PendingIntent) null);
    }

    public Status(C0648b c0648b, String str, int i7) {
        this(i7, str, c0648b.C(), c0648b);
    }

    public Status(int i7, String str, PendingIntent pendingIntent) {
        this(i7, str, pendingIntent, null);
    }
}
