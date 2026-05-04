package a6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class y extends n5.a {
    public static final Parcelable.Creator<y> CREATOR = new b1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f299c;

    public y(String str, String str2, String str3) {
        this.f297a = (String) com.google.android.gms.common.internal.s.k(str);
        this.f298b = (String) com.google.android.gms.common.internal.s.k(str2);
        this.f299c = str3;
    }

    public String R() {
        return this.f299c;
    }

    public String S() {
        return this.f297a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return com.google.android.gms.common.internal.q.b(this.f297a, yVar.f297a) && com.google.android.gms.common.internal.q.b(this.f298b, yVar.f298b) && com.google.android.gms.common.internal.q.b(this.f299c, yVar.f299c);
    }

    public String getName() {
        return this.f298b;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f297a, this.f298b, this.f299c);
    }

    public final String toString() {
        return "PublicKeyCredentialRpEntity{\n id='" + this.f297a + "', \n name='" + this.f298b + "', \n icon='" + this.f299c + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 2, S(), false);
        n5.c.E(parcel, 3, getName(), false);
        n5.c.E(parcel, 4, R(), false);
        n5.c.b(parcel, iA);
    }
}
