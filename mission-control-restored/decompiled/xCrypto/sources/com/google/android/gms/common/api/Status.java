package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.ReflectedParcelable;
import z1.C1984b;

/* JADX INFO: loaded from: classes.dex */
public final class Status extends A1.a implements k, ReflectedParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PendingIntent f9662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C1984b f9663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Status f9652e = new Status(-1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Status f9653f = new Status(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Status f9654g = new Status(14);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Status f9655h = new Status(8);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Status f9656i = new Status(15);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Status f9657j = new Status(16);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Status f9659l = new Status(17);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Status f9658k = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new u();

    public Status(int i4, String str, PendingIntent pendingIntent, C1984b c1984b) {
        this.f9660a = i4;
        this.f9661b = str;
        this.f9662c = pendingIntent;
        this.f9663d = c1984b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f9660a == status.f9660a && AbstractC0939q.b(this.f9661b, status.f9661b) && AbstractC0939q.b(this.f9662c, status.f9662c) && AbstractC0939q.b(this.f9663d, status.f9663d);
    }

    @Override // com.google.android.gms.common.api.k
    public Status getStatus() {
        return this;
    }

    public int hashCode() {
        return AbstractC0939q.c(Integer.valueOf(this.f9660a), this.f9661b, this.f9662c, this.f9663d);
    }

    public C1984b i() {
        return this.f9663d;
    }

    public int k() {
        return this.f9660a;
    }

    public String l() {
        return this.f9661b;
    }

    public boolean m() {
        return this.f9662c != null;
    }

    public boolean n() {
        return this.f9660a == 16;
    }

    public boolean o() {
        return this.f9660a <= 0;
    }

    public String toString() {
        AbstractC0939q.a aVarD = AbstractC0939q.d(this);
        aVarD.a("statusCode", zza());
        aVarD.a("resolution", this.f9662c);
        return aVarD.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, k());
        A1.c.E(parcel, 2, l(), false);
        A1.c.C(parcel, 3, this.f9662c, i4, false);
        A1.c.C(parcel, 4, i(), i4, false);
        A1.c.b(parcel, iA);
    }

    public final String zza() {
        String str = this.f9661b;
        return str != null ? str : c.a(this.f9660a);
    }

    public Status(int i4) {
        this(i4, (String) null);
    }

    public Status(C1984b c1984b, String str) {
        this(c1984b, str, 17);
    }

    public Status(int i4, String str) {
        this(i4, str, (PendingIntent) null);
    }

    public Status(C1984b c1984b, String str, int i4) {
        this(i4, str, c1984b.l(), c1984b);
    }

    public Status(int i4, String str, PendingIntent pendingIntent) {
        this(i4, str, pendingIntent, null);
    }
}
