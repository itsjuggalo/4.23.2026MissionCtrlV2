package f2;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: f2.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1588n extends Q1.a {
    public static final Parcelable.Creator<C1588n> CREATOR = new C1562M();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f14103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f14104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f14105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f14106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f14107e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f14108f;

    public C1588n(boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12) {
        this.f14103a = z7;
        this.f14104b = z8;
        this.f14105c = z9;
        this.f14106d = z10;
        this.f14107e = z11;
        this.f14108f = z12;
    }

    public boolean A() {
        return this.f14108f;
    }

    public boolean B() {
        return this.f14105c;
    }

    public boolean C() {
        return this.f14106d;
    }

    public boolean D() {
        return this.f14103a;
    }

    public boolean E() {
        return this.f14107e;
    }

    public boolean F() {
        return this.f14104b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.g(parcel, 1, D());
        Q1.c.g(parcel, 2, F());
        Q1.c.g(parcel, 3, B());
        Q1.c.g(parcel, 4, C());
        Q1.c.g(parcel, 5, E());
        Q1.c.g(parcel, 6, A());
        Q1.c.b(parcel, iA);
    }
}
