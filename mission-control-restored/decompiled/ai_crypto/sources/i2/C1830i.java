package i2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: i2.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1830i extends Q1.a {
    public static final Parcelable.Creator<C1830i> CREATOR = new C1838j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f15827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h7 f15828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f15829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f15830e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f15831f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C1750J f15832g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f15833h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public C1750J f15834i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f15835j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C1750J f15836k;

    public C1830i(C1830i c1830i) {
        AbstractC1207s.k(c1830i);
        this.f15826a = c1830i.f15826a;
        this.f15827b = c1830i.f15827b;
        this.f15828c = c1830i.f15828c;
        this.f15829d = c1830i.f15829d;
        this.f15830e = c1830i.f15830e;
        this.f15831f = c1830i.f15831f;
        this.f15832g = c1830i.f15832g;
        this.f15833h = c1830i.f15833h;
        this.f15834i = c1830i.f15834i;
        this.f15835j = c1830i.f15835j;
        this.f15836k = c1830i.f15836k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 2, this.f15826a, false);
        Q1.c.E(parcel, 3, this.f15827b, false);
        Q1.c.C(parcel, 4, this.f15828c, i7, false);
        Q1.c.x(parcel, 5, this.f15829d);
        Q1.c.g(parcel, 6, this.f15830e);
        Q1.c.E(parcel, 7, this.f15831f, false);
        Q1.c.C(parcel, 8, this.f15832g, i7, false);
        Q1.c.x(parcel, 9, this.f15833h);
        Q1.c.C(parcel, 10, this.f15834i, i7, false);
        Q1.c.x(parcel, 11, this.f15835j);
        Q1.c.C(parcel, 12, this.f15836k, i7, false);
        Q1.c.b(parcel, iA);
    }

    public C1830i(String str, String str2, h7 h7Var, long j7, boolean z7, String str3, C1750J c1750j, long j8, C1750J c1750j2, long j9, C1750J c1750j3) {
        this.f15826a = str;
        this.f15827b = str2;
        this.f15828c = h7Var;
        this.f15829d = j7;
        this.f15830e = z7;
        this.f15831f = str3;
        this.f15832g = c1750j;
        this.f15833h = j8;
        this.f15834i = c1750j2;
        this.f15835j = j9;
        this.f15836k = c1750j3;
    }
}
