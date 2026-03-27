package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.Arrays;

/* JADX INFO: renamed from: d2.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1394A extends Q1.a {
    public static final Parcelable.Creator<C1394A> CREATOR = new C1422b0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f13167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13170d;

    public C1394A(byte[] bArr, String str, String str2, String str3) {
        this.f13167a = (byte[]) AbstractC1207s.k(bArr);
        this.f13168b = (String) AbstractC1207s.k(str);
        this.f13169c = str2;
        this.f13170d = (String) AbstractC1207s.k(str3);
    }

    public String A() {
        return this.f13169c;
    }

    public byte[] B() {
        return this.f13167a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1394A)) {
            return false;
        }
        C1394A c1394a = (C1394A) obj;
        return Arrays.equals(this.f13167a, c1394a.f13167a) && AbstractC1206q.b(this.f13168b, c1394a.f13168b) && AbstractC1206q.b(this.f13169c, c1394a.f13169c) && AbstractC1206q.b(this.f13170d, c1394a.f13170d);
    }

    public String getName() {
        return this.f13168b;
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f13167a, this.f13168b, this.f13169c, this.f13170d);
    }

    public String p() {
        return this.f13170d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.k(parcel, 2, B(), false);
        Q1.c.E(parcel, 3, getName(), false);
        Q1.c.E(parcel, 4, A(), false);
        Q1.c.E(parcel, 5, p(), false);
        Q1.c.b(parcel, iA);
    }
}
