package P1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: P1.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0503n extends A1.a {
    public static final Parcelable.Creator<C0503n> CREATOR = new M();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f3442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f3443f;

    public C0503n(boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        this.f3438a = z4;
        this.f3439b = z5;
        this.f3440c = z6;
        this.f3441d = z7;
        this.f3442e = z8;
        this.f3443f = z9;
    }

    public boolean i() {
        return this.f3443f;
    }

    public boolean k() {
        return this.f3440c;
    }

    public boolean l() {
        return this.f3441d;
    }

    public boolean m() {
        return this.f3438a;
    }

    public boolean n() {
        return this.f3442e;
    }

    public boolean o() {
        return this.f3439b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.g(parcel, 1, m());
        A1.c.g(parcel, 2, o());
        A1.c.g(parcel, 3, k());
        A1.c.g(parcel, 4, l());
        A1.c.g(parcel, 5, n());
        A1.c.g(parcel, 6, i());
        A1.c.b(parcel, iA);
    }
}
