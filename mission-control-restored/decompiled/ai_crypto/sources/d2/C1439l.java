package d2;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: d2.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1439l extends AbstractC1441n {
    public static final Parcelable.Creator<C1439l> CREATOR = new x0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1448u f13256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f13257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f13258c;

    public C1439l(C1448u c1448u, Uri uri, byte[] bArr) {
        this.f13256a = (C1448u) AbstractC1207s.k(c1448u);
        D(uri);
        this.f13257b = uri;
        E(bArr);
        this.f13258c = bArr;
    }

    public static Uri D(Uri uri) {
        AbstractC1207s.k(uri);
        AbstractC1207s.b(uri.getScheme() != null, "origin scheme must be non-empty");
        AbstractC1207s.b(uri.getAuthority() != null, "origin authority must be non-empty");
        return uri;
    }

    public static byte[] E(byte[] bArr) {
        boolean z7 = true;
        if (bArr != null && bArr.length != 32) {
            z7 = false;
        }
        AbstractC1207s.b(z7, "clientDataHash must be 32 bytes long");
        return bArr;
    }

    public byte[] A() {
        return this.f13258c;
    }

    public Uri B() {
        return this.f13257b;
    }

    public C1448u C() {
        return this.f13256a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1439l)) {
            return false;
        }
        C1439l c1439l = (C1439l) obj;
        return AbstractC1206q.b(this.f13256a, c1439l.f13256a) && AbstractC1206q.b(this.f13257b, c1439l.f13257b);
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f13256a, this.f13257b);
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
