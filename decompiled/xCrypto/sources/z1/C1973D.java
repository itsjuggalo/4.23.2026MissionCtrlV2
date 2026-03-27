package z1;

import J1.a;
import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: z1.D, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1973D extends A1.a {
    public static final Parcelable.Creator<C1973D> CREATOR = new C1974E();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f16060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f16061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f16062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f16063e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f16064f;

    public C1973D(String str, boolean z4, boolean z5, IBinder iBinder, boolean z6, boolean z7) {
        this.f16059a = str;
        this.f16060b = z4;
        this.f16061c = z5;
        this.f16062d = (Context) J1.b.c(a.AbstractBinderC0026a.b(iBinder));
        this.f16063e = z6;
        this.f16064f = z7;
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [J1.a, android.os.IBinder] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        String str = this.f16059a;
        int iA = A1.c.a(parcel);
        A1.c.E(parcel, 1, str, false);
        A1.c.g(parcel, 2, this.f16060b);
        A1.c.g(parcel, 3, this.f16061c);
        A1.c.s(parcel, 4, J1.b.f(this.f16062d), false);
        A1.c.g(parcel, 5, this.f16063e);
        A1.c.g(parcel, 6, this.f16064f);
        A1.c.b(parcel, iA);
    }
}
