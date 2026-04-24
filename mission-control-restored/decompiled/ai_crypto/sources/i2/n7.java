package i2;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class n7 extends Q1.a {
    public static final Parcelable.Creator<n7> CREATOR = new o7();

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final long f15942A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final String f15943B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final String f15944C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final long f15945D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final int f15946E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f15950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f15951e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f15952f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f15953g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f15954h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f15955i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f15956j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f15957k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f15958l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f15959m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f15960n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f15961o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Boolean f15962p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f15963q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List f15964r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f15965s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f15966t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f15967u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f15968v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f15969w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f15970x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f15971y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f15972z;

    public n7(String str, String str2, String str3, long j7, String str4, long j8, long j9, String str5, boolean z7, boolean z8, String str6, long j10, int i7, boolean z9, boolean z10, Boolean bool, long j11, List list, String str7, String str8, String str9, boolean z11, long j12, int i8, String str10, int i9, long j13, String str11, String str12, long j14, int i10) {
        AbstractC1207s.e(str);
        this.f15947a = str;
        this.f15948b = true == TextUtils.isEmpty(str2) ? null : str2;
        this.f15949c = str3;
        this.f15956j = j7;
        this.f15950d = str4;
        this.f15951e = j8;
        this.f15952f = j9;
        this.f15953g = str5;
        this.f15954h = z7;
        this.f15955i = z8;
        this.f15957k = str6;
        this.f15958l = j10;
        this.f15959m = i7;
        this.f15960n = z9;
        this.f15961o = z10;
        this.f15962p = bool;
        this.f15963q = j11;
        this.f15964r = list;
        this.f15965s = str7;
        this.f15966t = str8;
        this.f15967u = str9;
        this.f15968v = z11;
        this.f15969w = j12;
        this.f15970x = i8;
        this.f15971y = str10;
        this.f15972z = i9;
        this.f15942A = j13;
        this.f15943B = str11;
        this.f15944C = str12;
        this.f15945D = j14;
        this.f15946E = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        String str = this.f15947a;
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 2, str, false);
        Q1.c.E(parcel, 3, this.f15948b, false);
        Q1.c.E(parcel, 4, this.f15949c, false);
        Q1.c.E(parcel, 5, this.f15950d, false);
        Q1.c.x(parcel, 6, this.f15951e);
        Q1.c.x(parcel, 7, this.f15952f);
        Q1.c.E(parcel, 8, this.f15953g, false);
        Q1.c.g(parcel, 9, this.f15954h);
        Q1.c.g(parcel, 10, this.f15955i);
        Q1.c.x(parcel, 11, this.f15956j);
        Q1.c.E(parcel, 12, this.f15957k, false);
        Q1.c.x(parcel, 14, this.f15958l);
        Q1.c.t(parcel, 15, this.f15959m);
        Q1.c.g(parcel, 16, this.f15960n);
        Q1.c.g(parcel, 18, this.f15961o);
        Q1.c.i(parcel, 21, this.f15962p, false);
        Q1.c.x(parcel, 22, this.f15963q);
        Q1.c.G(parcel, 23, this.f15964r, false);
        Q1.c.E(parcel, 25, this.f15965s, false);
        Q1.c.E(parcel, 26, this.f15966t, false);
        Q1.c.E(parcel, 27, this.f15967u, false);
        Q1.c.g(parcel, 28, this.f15968v);
        Q1.c.x(parcel, 29, this.f15969w);
        Q1.c.t(parcel, 30, this.f15970x);
        Q1.c.E(parcel, 31, this.f15971y, false);
        Q1.c.t(parcel, 32, this.f15972z);
        Q1.c.x(parcel, 34, this.f15942A);
        Q1.c.E(parcel, 35, this.f15943B, false);
        Q1.c.E(parcel, 36, this.f15944C, false);
        Q1.c.x(parcel, 37, this.f15945D);
        Q1.c.t(parcel, 38, this.f15946E);
        Q1.c.b(parcel, iA);
    }

    public n7(String str, String str2, String str3, String str4, long j7, long j8, String str5, boolean z7, boolean z8, long j9, String str6, long j10, int i7, boolean z9, boolean z10, Boolean bool, long j11, List list, String str7, String str8, String str9, boolean z11, long j12, int i8, String str10, int i9, long j13, String str11, String str12, long j14, int i10) {
        this.f15947a = str;
        this.f15948b = str2;
        this.f15949c = str3;
        this.f15956j = j9;
        this.f15950d = str4;
        this.f15951e = j7;
        this.f15952f = j8;
        this.f15953g = str5;
        this.f15954h = z7;
        this.f15955i = z8;
        this.f15957k = str6;
        this.f15958l = j10;
        this.f15959m = i7;
        this.f15960n = z9;
        this.f15961o = z10;
        this.f15962p = bool;
        this.f15963q = j11;
        this.f15964r = list;
        this.f15965s = str7;
        this.f15966t = str8;
        this.f15967u = str9;
        this.f15968v = z11;
        this.f15969w = j12;
        this.f15970x = i8;
        this.f15971y = str10;
        this.f15972z = i9;
        this.f15942A = j13;
        this.f15943B = str11;
        this.f15944C = str12;
        this.f15945D = j14;
        this.f15946E = i10;
    }
}
