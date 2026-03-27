package z1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: z1.F, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1975F extends A1.a {
    public static final Parcelable.Creator<C1975F> CREATOR = new C1976G();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f16065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f16067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f16068d;

    public C1975F(boolean z4, String str, int i4, int i5) {
        this.f16065a = z4;
        this.f16066b = str;
        this.f16067c = AbstractC1982M.a(i4) - 1;
        this.f16068d = AbstractC2001s.a(i5) - 1;
    }

    public final int i() {
        return AbstractC2001s.a(this.f16068d);
    }

    public final int k() {
        return AbstractC1982M.a(this.f16067c);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.g(parcel, 1, this.f16065a);
        A1.c.E(parcel, 2, this.f16066b, false);
        A1.c.t(parcel, 3, this.f16067c);
        A1.c.t(parcel, 4, this.f16068d);
        A1.c.b(parcel, iA);
    }

    public final String zza() {
        return this.f16066b;
    }

    public final boolean zzb() {
        return this.f16065a;
    }
}
