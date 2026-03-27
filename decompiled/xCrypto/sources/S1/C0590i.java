package S1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: renamed from: S1.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0590i extends A1.a {
    public static final Parcelable.Creator<C0590i> CREATOR = new C0598j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h7 f4669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4670d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f4671e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4672f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final J f4673g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f4674h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public J f4675i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f4676j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final J f4677k;

    public C0590i(C0590i c0590i) {
        AbstractC0940s.k(c0590i);
        this.f4667a = c0590i.f4667a;
        this.f4668b = c0590i.f4668b;
        this.f4669c = c0590i.f4669c;
        this.f4670d = c0590i.f4670d;
        this.f4671e = c0590i.f4671e;
        this.f4672f = c0590i.f4672f;
        this.f4673g = c0590i.f4673g;
        this.f4674h = c0590i.f4674h;
        this.f4675i = c0590i.f4675i;
        this.f4676j = c0590i.f4676j;
        this.f4677k = c0590i.f4677k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.E(parcel, 2, this.f4667a, false);
        A1.c.E(parcel, 3, this.f4668b, false);
        A1.c.C(parcel, 4, this.f4669c, i4, false);
        A1.c.x(parcel, 5, this.f4670d);
        A1.c.g(parcel, 6, this.f4671e);
        A1.c.E(parcel, 7, this.f4672f, false);
        A1.c.C(parcel, 8, this.f4673g, i4, false);
        A1.c.x(parcel, 9, this.f4674h);
        A1.c.C(parcel, 10, this.f4675i, i4, false);
        A1.c.x(parcel, 11, this.f4676j);
        A1.c.C(parcel, 12, this.f4677k, i4, false);
        A1.c.b(parcel, iA);
    }

    public C0590i(String str, String str2, h7 h7Var, long j4, boolean z4, String str3, J j5, long j6, J j7, long j8, J j9) {
        this.f4667a = str;
        this.f4668b = str2;
        this.f4669c = h7Var;
        this.f4670d = j4;
        this.f4671e = z4;
        this.f4672f = str3;
        this.f4673g = j5;
        this.f4674h = j6;
        this.f4675i = j7;
        this.f4676j = j8;
        this.f4677k = j9;
    }
}
