package m5;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import w5.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 extends n5.a {
    public static final Parcelable.Creator<f0> CREATOR = new g0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f15918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f15919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f15920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f15921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f15922f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f15923g;

    public f0(String str, boolean z10, boolean z11, IBinder iBinder, boolean z12, boolean z13, boolean z14) {
        this.f15917a = str;
        this.f15918b = z10;
        this.f15919c = z11;
        this.f15920d = (Context) w5.b.I(a.AbstractBinderC0411a.H(iBinder));
        this.f15921e = z12;
        this.f15922f = z13;
        this.f15923g = z14;
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [android.os.IBinder, w5.a] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        String str = this.f15917a;
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, str, false);
        n5.c.g(parcel, 2, this.f15918b);
        n5.c.g(parcel, 3, this.f15919c);
        n5.c.s(parcel, 4, w5.b.J(this.f15920d), false);
        n5.c.g(parcel, 5, this.f15921e);
        n5.c.g(parcel, 6, this.f15922f);
        n5.c.g(parcel, 8, this.f15923g);
        n5.c.b(parcel, iA);
    }
}
