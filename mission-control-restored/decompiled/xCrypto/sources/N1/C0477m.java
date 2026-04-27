package N1;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: renamed from: N1.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0477m extends AbstractC0478n {
    public static final Parcelable.Creator<C0477m> CREATOR = new y0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0487x f2803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f2804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f2805c;

    public C0477m(C0487x c0487x, Uri uri, byte[] bArr) {
        this.f2803a = (C0487x) AbstractC0940s.k(c0487x);
        m(uri);
        this.f2804b = uri;
        n(bArr);
        this.f2805c = bArr;
    }

    private static Uri m(Uri uri) {
        AbstractC0940s.k(uri);
        AbstractC0940s.b(uri.getScheme() != null, "origin scheme must be non-empty");
        AbstractC0940s.b(uri.getAuthority() != null, "origin authority must be non-empty");
        return uri;
    }

    private static byte[] n(byte[] bArr) {
        boolean z4 = true;
        if (bArr != null && bArr.length != 32) {
            z4 = false;
        }
        AbstractC0940s.b(z4, "clientDataHash must be 32 bytes long");
        return bArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0477m)) {
            return false;
        }
        C0477m c0477m = (C0477m) obj;
        return AbstractC0939q.b(this.f2803a, c0477m.f2803a) && AbstractC0939q.b(this.f2804b, c0477m.f2804b);
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f2803a, this.f2804b);
    }

    public byte[] i() {
        return this.f2805c;
    }

    public Uri k() {
        return this.f2804b;
    }

    public C0487x l() {
        return this.f2803a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.C(parcel, 2, l(), i4, false);
        A1.c.C(parcel, 3, k(), i4, false);
        A1.c.k(parcel, 4, i(), false);
        A1.c.b(parcel, iA);
    }
}
