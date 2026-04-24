package P1;

import Z1.a;
import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class D extends Q1.a {
    public static final Parcelable.Creator<D> CREATOR = new E();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f4264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f4265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f4266e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f4267f;

    public D(String str, boolean z7, boolean z8, IBinder iBinder, boolean z9, boolean z10) {
        this.f4262a = str;
        this.f4263b = z7;
        this.f4264c = z8;
        this.f4265d = (Context) Z1.b.c(a.AbstractBinderC0104a.b(iBinder));
        this.f4266e = z9;
        this.f4267f = z10;
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [Z1.a, android.os.IBinder] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        String str = this.f4262a;
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, str, false);
        Q1.c.g(parcel, 2, this.f4263b);
        Q1.c.g(parcel, 3, this.f4264c);
        Q1.c.s(parcel, 4, Z1.b.f(this.f4265d), false);
        Q1.c.g(parcel, 5, this.f4266e);
        Q1.c.g(parcel, 6, this.f4267f);
        Q1.c.b(parcel, iA);
    }
}
