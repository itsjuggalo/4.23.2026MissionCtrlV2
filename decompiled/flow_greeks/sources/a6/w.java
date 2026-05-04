package a6;

import a6.o;
import a6.z;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class w extends n5.a {
    public static final Parcelable.Creator<w> CREATOR = new z0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f276b;

    public w(String str, int i10) {
        com.google.android.gms.common.internal.s.k(str);
        try {
            this.f275a = z.a(str);
            com.google.android.gms.common.internal.s.k(Integer.valueOf(i10));
            try {
                this.f276b = o.a(i10);
            } catch (o.a e10) {
                throw new IllegalArgumentException(e10);
            }
        } catch (z.a e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public int R() {
        return this.f276b.b();
    }

    public String S() {
        return this.f275a.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f275a.equals(wVar.f275a) && this.f276b.equals(wVar.f276b);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f275a, this.f276b);
    }

    public final String toString() {
        o oVar = this.f276b;
        return "PublicKeyCredentialParameters{\n type=" + String.valueOf(this.f275a) + ", \n algorithm=" + String.valueOf(oVar) + "\n }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 2, S(), false);
        n5.c.w(parcel, 3, Integer.valueOf(R()), false);
        n5.c.b(parcel, iA);
    }
}
