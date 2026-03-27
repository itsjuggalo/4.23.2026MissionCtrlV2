package K1;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class c extends Q1.a {
    public static final Parcelable.Creator<c> CREATOR = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PendingIntent f3365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f3367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3368e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f3369f;

    public c(int i7, int i8, PendingIntent pendingIntent, int i9, Bundle bundle, byte[] bArr) {
        this.f3368e = i7;
        this.f3364a = i8;
        this.f3366c = i9;
        this.f3369f = bundle;
        this.f3367d = bArr;
        this.f3365b = pendingIntent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, this.f3364a);
        Q1.c.C(parcel, 2, this.f3365b, i7, false);
        Q1.c.t(parcel, 3, this.f3366c);
        Q1.c.j(parcel, 4, this.f3369f, false);
        Q1.c.k(parcel, 5, this.f3367d, false);
        Q1.c.t(parcel, 1000, this.f3368e);
        Q1.c.b(parcel, iA);
    }
}
