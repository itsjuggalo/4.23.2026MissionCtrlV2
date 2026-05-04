package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class Status extends n5.a implements k, ReflectedParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PendingIntent f5464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m5.b f5465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Status f5454e = new Status(-1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Status f5455f = new Status(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Status f5456g = new Status(14);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Status f5457h = new Status(8);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Status f5458i = new Status(15);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Status f5459j = new Status(16);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Status f5460k = new Status(17);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Status f5461l = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new u();

    public Status(int i10, String str, PendingIntent pendingIntent, m5.b bVar) {
        this.f5462a = i10;
        this.f5463b = str;
        this.f5464c = pendingIntent;
        this.f5465d = bVar;
    }

    public m5.b R() {
        return this.f5465d;
    }

    public int S() {
        return this.f5462a;
    }

    public String T() {
        return this.f5463b;
    }

    public boolean U() {
        return this.f5464c != null;
    }

    public boolean V() {
        return this.f5462a <= 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f5462a == status.f5462a && com.google.android.gms.common.internal.q.b(this.f5463b, status.f5463b) && com.google.android.gms.common.internal.q.b(this.f5464c, status.f5464c) && com.google.android.gms.common.internal.q.b(this.f5465d, status.f5465d);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(Integer.valueOf(this.f5462a), this.f5463b, this.f5464c, this.f5465d);
    }

    public String toString() {
        q.a aVarD = com.google.android.gms.common.internal.q.d(this);
        aVarD.a("statusCode", zza());
        aVarD.a("resolution", this.f5464c);
        return aVarD.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, S());
        n5.c.E(parcel, 2, T(), false);
        n5.c.C(parcel, 3, this.f5464c, i10, false);
        n5.c.C(parcel, 4, R(), i10, false);
        n5.c.b(parcel, iA);
    }

    public final String zza() {
        String str = this.f5463b;
        return str != null ? str : d.a(this.f5462a);
    }

    public Status(int i10) {
        this(i10, (String) null);
    }

    public Status(m5.b bVar, String str) {
        this(bVar, str, 17);
    }

    public Status(int i10, String str) {
        this(i10, str, (PendingIntent) null);
    }

    public Status(m5.b bVar, String str, int i10) {
        this(i10, str, bVar.T(), bVar);
    }

    public Status(int i10, String str, PendingIntent pendingIntent) {
        this(i10, str, pendingIntent, null);
    }

    @Override // com.google.android.gms.common.api.k
    public Status getStatus() {
        return this;
    }
}
