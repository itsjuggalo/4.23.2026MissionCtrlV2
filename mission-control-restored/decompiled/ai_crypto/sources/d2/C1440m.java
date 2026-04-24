package d2;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: d2.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1440m extends AbstractC1441n {
    public static final Parcelable.Creator<C1440m> CREATOR = new y0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1451x f13259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f13260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f13261c;

    public C1440m(C1451x c1451x, Uri uri, byte[] bArr) {
        this.f13259a = (C1451x) AbstractC1207s.k(c1451x);
        D(uri);
        this.f13260b = uri;
        E(bArr);
        this.f13261c = bArr;
    }

    private static Uri D(Uri uri) {
        AbstractC1207s.k(uri);
        AbstractC1207s.b(uri.getScheme() != null, "origin scheme must be non-empty");
        AbstractC1207s.b(uri.getAuthority() != null, "origin authority must be non-empty");
        return uri;
    }

    private static byte[] E(byte[] bArr) {
        boolean z7 = true;
        if (bArr != null && bArr.length != 32) {
            z7 = false;
        }
        AbstractC1207s.b(z7, "clientDataHash must be 32 bytes long");
        return bArr;
    }

    public byte[] A() {
        return this.f13261c;
    }

    public Uri B() {
        return this.f13260b;
    }

    public C1451x C() {
        return this.f13259a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1440m)) {
            return false;
        }
        C1440m c1440m = (C1440m) obj;
        return AbstractC1206q.b(this.f13259a, c1440m.f13259a) && AbstractC1206q.b(this.f13260b, c1440m.f13260b);
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f13259a, this.f13260b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.C(parcel, 2, C(), i7, false);
        Q1.c.C(parcel, 3, B(), i7, false);
        Q1.c.k(parcel, 4, A(), false);
        Q1.c.b(parcel, iA);
    }
}
