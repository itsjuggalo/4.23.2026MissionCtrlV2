package t1;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class c extends A1.a {
    public static final Parcelable.Creator<c> CREATOR = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PendingIntent f14743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f14745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f14747f;

    public c(int i4, int i5, PendingIntent pendingIntent, int i6, Bundle bundle, byte[] bArr) {
        this.f14746e = i4;
        this.f14742a = i5;
        this.f14744c = i6;
        this.f14747f = bundle;
        this.f14745d = bArr;
        this.f14743b = pendingIntent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, this.f14742a);
        A1.c.C(parcel, 2, this.f14743b, i4, false);
        A1.c.t(parcel, 3, this.f14744c);
        A1.c.j(parcel, 4, this.f14747f, false);
        A1.c.k(parcel, 5, this.f14745d, false);
        A1.c.t(parcel, 1000, this.f14746e);
        A1.c.b(parcel, iA);
    }
}
