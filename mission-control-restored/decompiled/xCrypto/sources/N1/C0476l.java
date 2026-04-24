package N1;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: renamed from: N1.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0476l extends AbstractC0478n {
    public static final Parcelable.Creator<C0476l> CREATOR = new x0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0484u f2800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f2801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f2802c;

    public C0476l(C0484u c0484u, Uri uri, byte[] bArr) {
        this.f2800a = (C0484u) AbstractC0940s.k(c0484u);
        m(uri);
        this.f2801b = uri;
        n(bArr);
        this.f2802c = bArr;
    }

    public static Uri m(Uri uri) {
        AbstractC0940s.k(uri);
        AbstractC0940s.b(uri.getScheme() != null, "origin scheme must be non-empty");
        AbstractC0940s.b(uri.getAuthority() != null, "origin authority must be non-empty");
        return uri;
    }

    public static byte[] n(byte[] bArr) {
        boolean z4 = true;
        if (bArr != null && bArr.length != 32) {
            z4 = false;
        }
        AbstractC0940s.b(z4, "clientDataHash must be 32 bytes long");
        return bArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0476l)) {
            return false;
        }
        C0476l c0476l = (C0476l) obj;
        return AbstractC0939q.b(this.f2800a, c0476l.f2800a) && AbstractC0939q.b(this.f2801b, c0476l.f2801b);
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f2800a, this.f2801b);
    }

    public byte[] i() {
        return this.f2802c;
    }

    public Uri k() {
        return this.f2801b;
    }

    public C0484u l() {
        return this.f2800a;
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
