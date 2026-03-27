package S1;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class n7 extends A1.a {
    public static final Parcelable.Creator<n7> CREATOR = new o7();

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final long f4783A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final String f4784B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final String f4785C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final long f4786D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final int f4787E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f4792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f4793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f4794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f4795h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f4796i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f4797j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f4798k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f4799l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f4800m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f4801n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f4802o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Boolean f4803p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f4804q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List f4805r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f4806s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f4807t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f4808u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f4809v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f4810w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f4811x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f4812y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f4813z;

    public n7(String str, String str2, String str3, long j4, String str4, long j5, long j6, String str5, boolean z4, boolean z5, String str6, long j7, int i4, boolean z6, boolean z7, Boolean bool, long j8, List list, String str7, String str8, String str9, boolean z8, long j9, int i5, String str10, int i6, long j10, String str11, String str12, long j11, int i7) {
        AbstractC0940s.e(str);
        this.f4788a = str;
        this.f4789b = true == TextUtils.isEmpty(str2) ? null : str2;
        this.f4790c = str3;
        this.f4797j = j4;
        this.f4791d = str4;
        this.f4792e = j5;
        this.f4793f = j6;
        this.f4794g = str5;
        this.f4795h = z4;
        this.f4796i = z5;
        this.f4798k = str6;
        this.f4799l = j7;
        this.f4800m = i4;
        this.f4801n = z6;
        this.f4802o = z7;
        this.f4803p = bool;
        this.f4804q = j8;
        this.f4805r = list;
        this.f4806s = str7;
        this.f4807t = str8;
        this.f4808u = str9;
        this.f4809v = z8;
        this.f4810w = j9;
        this.f4811x = i5;
        this.f4812y = str10;
        this.f4813z = i6;
        this.f4783A = j10;
        this.f4784B = str11;
        this.f4785C = str12;
        this.f4786D = j11;
        this.f4787E = i7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        String str = this.f4788a;
        int iA = A1.c.a(parcel);
        A1.c.E(parcel, 2, str, false);
        A1.c.E(parcel, 3, this.f4789b, false);
        A1.c.E(parcel, 4, this.f4790c, false);
        A1.c.E(parcel, 5, this.f4791d, false);
        A1.c.x(parcel, 6, this.f4792e);
        A1.c.x(parcel, 7, this.f4793f);
        A1.c.E(parcel, 8, this.f4794g, false);
        A1.c.g(parcel, 9, this.f4795h);
        A1.c.g(parcel, 10, this.f4796i);
        A1.c.x(parcel, 11, this.f4797j);
        A1.c.E(parcel, 12, this.f4798k, false);
        A1.c.x(parcel, 14, this.f4799l);
        A1.c.t(parcel, 15, this.f4800m);
        A1.c.g(parcel, 16, this.f4801n);
        A1.c.g(parcel, 18, this.f4802o);
        A1.c.i(parcel, 21, this.f4803p, false);
        A1.c.x(parcel, 22, this.f4804q);
        A1.c.G(parcel, 23, this.f4805r, false);
        A1.c.E(parcel, 25, this.f4806s, false);
        A1.c.E(parcel, 26, this.f4807t, false);
        A1.c.E(parcel, 27, this.f4808u, false);
        A1.c.g(parcel, 28, this.f4809v);
        A1.c.x(parcel, 29, this.f4810w);
        A1.c.t(parcel, 30, this.f4811x);
        A1.c.E(parcel, 31, this.f4812y, false);
        A1.c.t(parcel, 32, this.f4813z);
        A1.c.x(parcel, 34, this.f4783A);
        A1.c.E(parcel, 35, this.f4784B, false);
        A1.c.E(parcel, 36, this.f4785C, false);
        A1.c.x(parcel, 37, this.f4786D);
        A1.c.t(parcel, 38, this.f4787E);
        A1.c.b(parcel, iA);
    }

    public n7(String str, String str2, String str3, String str4, long j4, long j5, String str5, boolean z4, boolean z5, long j6, String str6, long j7, int i4, boolean z6, boolean z7, Boolean bool, long j8, List list, String str7, String str8, String str9, boolean z8, long j9, int i5, String str10, int i6, long j10, String str11, String str12, long j11, int i7) {
        this.f4788a = str;
        this.f4789b = str2;
        this.f4790c = str3;
        this.f4797j = j6;
        this.f4791d = str4;
        this.f4792e = j4;
        this.f4793f = j5;
        this.f4794g = str5;
        this.f4795h = z4;
        this.f4796i = z5;
        this.f4798k = str6;
        this.f4799l = j7;
        this.f4800m = i4;
        this.f4801n = z6;
        this.f4802o = z7;
        this.f4803p = bool;
        this.f4804q = j8;
        this.f4805r = list;
        this.f4806s = str7;
        this.f4807t = str8;
        this.f4808u = str9;
        this.f4809v = z8;
        this.f4810w = j9;
        this.f4811x = i5;
        this.f4812y = str10;
        this.f4813z = i6;
        this.f4783A = j10;
        this.f4784B = str11;
        this.f4785C = str12;
        this.f4786D = j11;
        this.f4787E = i7;
    }
}
