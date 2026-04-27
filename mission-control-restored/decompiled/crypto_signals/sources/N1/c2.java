package N1;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
public final class c2 extends AbstractC1255a {
    public static final Parcelable.Creator<c2> CREATOR = new X1(1);

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final long f1540A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final int f1541B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final String f1542C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final int f1543D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final long f1544E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final String f1545F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final String f1546G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public final long f1547H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final int f1548I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1552d;
    public final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f1553f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f1554k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f1555l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f1556m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f1557n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f1558o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f1559p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f1560q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f1561r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f1562s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Boolean f1563t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f1564u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List f1565v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f1566w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f1567x;
    public final String y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f1568z;

    public c2(String str, String str2, String str3, long j4, String str4, long j6, long j7, String str5, boolean z6, boolean z7, String str6, long j8, int i, boolean z8, boolean z9, Boolean bool, long j9, List list, String str7, String str8, String str9, boolean z10, long j10, int i6, String str10, int i7, long j11, String str11, String str12, long j12, int i8) {
        com.google.android.gms.common.internal.I.d(str);
        this.f1549a = str;
        this.f1550b = true == TextUtils.isEmpty(str2) ? null : str2;
        this.f1551c = str3;
        this.f1557n = j4;
        this.f1552d = str4;
        this.e = j6;
        this.f1553f = j7;
        this.f1554k = str5;
        this.f1555l = z6;
        this.f1556m = z7;
        this.f1558o = str6;
        this.f1559p = j8;
        this.f1560q = i;
        this.f1561r = z8;
        this.f1562s = z9;
        this.f1563t = bool;
        this.f1564u = j9;
        this.f1565v = list;
        this.f1566w = str7;
        this.f1567x = str8;
        this.y = str9;
        this.f1568z = z10;
        this.f1540A = j10;
        this.f1541B = i6;
        this.f1542C = str10;
        this.f1543D = i7;
        this.f1544E = j11;
        this.f1545F = str11;
        this.f1546G = str12;
        this.f1547H = j12;
        this.f1548I = i8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = t2.u0.X(20293, parcel);
        t2.u0.T(parcel, 2, this.f1549a, false);
        t2.u0.T(parcel, 3, this.f1550b, false);
        t2.u0.T(parcel, 4, this.f1551c, false);
        t2.u0.T(parcel, 5, this.f1552d, false);
        t2.u0.b0(parcel, 6, 8);
        parcel.writeLong(this.e);
        t2.u0.b0(parcel, 7, 8);
        parcel.writeLong(this.f1553f);
        t2.u0.T(parcel, 8, this.f1554k, false);
        t2.u0.b0(parcel, 9, 4);
        parcel.writeInt(this.f1555l ? 1 : 0);
        t2.u0.b0(parcel, 10, 4);
        parcel.writeInt(this.f1556m ? 1 : 0);
        t2.u0.b0(parcel, 11, 8);
        parcel.writeLong(this.f1557n);
        t2.u0.T(parcel, 12, this.f1558o, false);
        t2.u0.b0(parcel, 14, 8);
        parcel.writeLong(this.f1559p);
        t2.u0.b0(parcel, 15, 4);
        parcel.writeInt(this.f1560q);
        t2.u0.b0(parcel, 16, 4);
        parcel.writeInt(this.f1561r ? 1 : 0);
        t2.u0.b0(parcel, 18, 4);
        parcel.writeInt(this.f1562s ? 1 : 0);
        t2.u0.K(parcel, 21, this.f1563t);
        t2.u0.b0(parcel, 22, 8);
        parcel.writeLong(this.f1564u);
        t2.u0.U(parcel, 23, this.f1565v);
        t2.u0.T(parcel, 25, this.f1566w, false);
        t2.u0.T(parcel, 26, this.f1567x, false);
        t2.u0.T(parcel, 27, this.y, false);
        t2.u0.b0(parcel, 28, 4);
        parcel.writeInt(this.f1568z ? 1 : 0);
        t2.u0.b0(parcel, 29, 8);
        parcel.writeLong(this.f1540A);
        t2.u0.b0(parcel, 30, 4);
        parcel.writeInt(this.f1541B);
        t2.u0.T(parcel, 31, this.f1542C, false);
        t2.u0.b0(parcel, 32, 4);
        parcel.writeInt(this.f1543D);
        t2.u0.b0(parcel, 34, 8);
        parcel.writeLong(this.f1544E);
        t2.u0.T(parcel, 35, this.f1545F, false);
        t2.u0.T(parcel, 36, this.f1546G, false);
        t2.u0.b0(parcel, 37, 8);
        parcel.writeLong(this.f1547H);
        t2.u0.b0(parcel, 38, 4);
        parcel.writeInt(this.f1548I);
        t2.u0.a0(iX, parcel);
    }

    public c2(String str, String str2, String str3, String str4, long j4, long j6, String str5, boolean z6, boolean z7, long j7, String str6, long j8, int i, boolean z8, boolean z9, Boolean bool, long j9, ArrayList arrayList, String str7, String str8, String str9, boolean z10, long j10, int i6, String str10, int i7, long j11, String str11, String str12, long j12, int i8) {
        this.f1549a = str;
        this.f1550b = str2;
        this.f1551c = str3;
        this.f1557n = j7;
        this.f1552d = str4;
        this.e = j4;
        this.f1553f = j6;
        this.f1554k = str5;
        this.f1555l = z6;
        this.f1556m = z7;
        this.f1558o = str6;
        this.f1559p = j8;
        this.f1560q = i;
        this.f1561r = z8;
        this.f1562s = z9;
        this.f1563t = bool;
        this.f1564u = j9;
        this.f1565v = arrayList;
        this.f1566w = str7;
        this.f1567x = str8;
        this.y = str9;
        this.f1568z = z10;
        this.f1540A = j10;
        this.f1541B = i6;
        this.f1542C = str10;
        this.f1543D = i7;
        this.f1544E = j11;
        this.f1545F = str11;
        this.f1546G = str12;
        this.f1547H = j12;
        this.f1548I = i8;
    }
}
