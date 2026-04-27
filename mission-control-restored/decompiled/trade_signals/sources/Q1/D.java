package Q1;

import Z1.a;
import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class D extends T1.a {
    public static final Parcelable.Creator<D> CREATOR = new E();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f6659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f6660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f6661f;

    public D(String str, boolean z7, boolean z8, IBinder iBinder, boolean z9, boolean z10) {
        this.f6656a = str;
        this.f6657b = z7;
        this.f6658c = z8;
        this.f6659d = (Context) Z1.b.F(a.AbstractBinderC0162a.E(iBinder));
        this.f6660e = z9;
        this.f6661f = z10;
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [Z1.a, android.os.IBinder] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        String str = this.f6656a;
        int iA = T1.c.a(parcel);
        T1.c.p(parcel, 1, str, false);
        T1.c.c(parcel, 2, this.f6657b);
        T1.c.c(parcel, 3, this.f6658c);
        T1.c.i(parcel, 4, Z1.b.G(this.f6659d), false);
        T1.c.c(parcel, 5, this.f6660e);
        T1.c.c(parcel, 6, this.f6661f);
        T1.c.b(parcel, iA);
    }
}
