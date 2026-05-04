package e5;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c extends n5.a {
    public static final Parcelable.Creator<c> CREATOR = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PendingIntent f8393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f8395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f8397f;

    public c(int i10, int i11, PendingIntent pendingIntent, int i12, Bundle bundle, byte[] bArr) {
        this.f8396e = i10;
        this.f8392a = i11;
        this.f8394c = i12;
        this.f8397f = bundle;
        this.f8395d = bArr;
        this.f8393b = pendingIntent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, this.f8392a);
        n5.c.C(parcel, 2, this.f8393b, i10, false);
        n5.c.t(parcel, 3, this.f8394c);
        n5.c.j(parcel, 4, this.f8397f, false);
        n5.c.k(parcel, 5, this.f8395d, false);
        n5.c.t(parcel, 1000, this.f8396e);
        n5.c.b(parcel, iA);
    }
}
