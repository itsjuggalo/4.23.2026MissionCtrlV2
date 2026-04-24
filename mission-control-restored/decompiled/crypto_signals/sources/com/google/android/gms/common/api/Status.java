package com.google.android.gms.common.api;

import N1.X1;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.I;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;
import t2.u0;
import u1.C1200b;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
public final class Status extends AbstractC1255a implements s, ReflectedParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PendingIntent f5064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C1200b f5065d;
    public static final Status e = new Status(0, null, null, null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Status f5058f = new Status(14, null, null, null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Status f5059k = new Status(8, null, null, null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Status f5060l = new Status(15, null, null, null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Status f5061m = new Status(16, null, null, null);
    public static final Parcelable.Creator<Status> CREATOR = new X1(22);

    public Status(int i, String str, PendingIntent pendingIntent, C1200b c1200b) {
        this.f5062a = i;
        this.f5063b = str;
        this.f5064c = pendingIntent;
        this.f5065d = c1200b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f5062a == status.f5062a && I.j(this.f5063b, status.f5063b) && I.j(this.f5064c, status.f5064c) && I.j(this.f5065d, status.f5065d);
    }

    @Override // com.google.android.gms.common.api.s
    public final Status getStatus() {
        return this;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f5062a), this.f5063b, this.f5064c, this.f5065d});
    }

    public final boolean m() {
        return this.f5062a <= 0;
    }

    public final String toString() {
        Y3.d dVar = new Y3.d(this);
        String strO = this.f5063b;
        if (strO == null) {
            strO = android.support.v4.media.session.a.o(this.f5062a);
        }
        dVar.h(strO, "statusCode");
        dVar.h(this.f5064c, "resolution");
        return dVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.b0(parcel, 1, 4);
        parcel.writeInt(this.f5062a);
        u0.T(parcel, 2, this.f5063b, false);
        u0.S(parcel, 3, this.f5064c, i, false);
        u0.S(parcel, 4, this.f5065d, i, false);
        u0.a0(iX, parcel);
    }
}
