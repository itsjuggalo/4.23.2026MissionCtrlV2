package N1;

import android.os.Parcel;
import android.os.Parcelable;
import v1.AbstractC1255a;

/* JADX INFO: renamed from: N1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0087e extends AbstractC1255a {
    public static final Parcelable.Creator<C0087e> CREATOR = new J1.Y(22);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public W1 f1580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1581d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1582f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C0134u f1583k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f1584l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public C0134u f1585m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f1586n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final C0134u f1587o;

    public C0087e(C0087e c0087e) {
        com.google.android.gms.common.internal.I.g(c0087e);
        this.f1578a = c0087e.f1578a;
        this.f1579b = c0087e.f1579b;
        this.f1580c = c0087e.f1580c;
        this.f1581d = c0087e.f1581d;
        this.e = c0087e.e;
        this.f1582f = c0087e.f1582f;
        this.f1583k = c0087e.f1583k;
        this.f1584l = c0087e.f1584l;
        this.f1585m = c0087e.f1585m;
        this.f1586n = c0087e.f1586n;
        this.f1587o = c0087e.f1587o;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = t2.u0.X(20293, parcel);
        t2.u0.T(parcel, 2, this.f1578a, false);
        t2.u0.T(parcel, 3, this.f1579b, false);
        t2.u0.S(parcel, 4, this.f1580c, i, false);
        long j4 = this.f1581d;
        t2.u0.b0(parcel, 5, 8);
        parcel.writeLong(j4);
        boolean z6 = this.e;
        t2.u0.b0(parcel, 6, 4);
        parcel.writeInt(z6 ? 1 : 0);
        t2.u0.T(parcel, 7, this.f1582f, false);
        t2.u0.S(parcel, 8, this.f1583k, i, false);
        long j6 = this.f1584l;
        t2.u0.b0(parcel, 9, 8);
        parcel.writeLong(j6);
        t2.u0.S(parcel, 10, this.f1585m, i, false);
        t2.u0.b0(parcel, 11, 8);
        parcel.writeLong(this.f1586n);
        t2.u0.S(parcel, 12, this.f1587o, i, false);
        t2.u0.a0(iX, parcel);
    }

    public C0087e(String str, String str2, W1 w12, long j4, boolean z6, String str3, C0134u c0134u, long j6, C0134u c0134u2, long j7, C0134u c0134u3) {
        this.f1578a = str;
        this.f1579b = str2;
        this.f1580c = w12;
        this.f1581d = j4;
        this.e = z6;
        this.f1582f = str3;
        this.f1583k = c0134u;
        this.f1584l = j6;
        this.f1585m = c0134u2;
        this.f1586n = j7;
        this.f1587o = c0134u3;
    }
}
