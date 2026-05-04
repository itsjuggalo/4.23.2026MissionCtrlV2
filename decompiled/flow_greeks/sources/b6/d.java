package b6;

import android.os.Parcel;
import android.os.Parcelable;
import b6.c;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d extends n5.a {
    public static final Parcelable.Creator<d> CREATOR = new j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f2990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f2991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2992d;

    public d(int i10, String str, byte[] bArr, String str2) {
        this.f2989a = i10;
        try {
            this.f2990b = c.a(str);
            this.f2991c = bArr;
            this.f2992d = str2;
        } catch (c.a e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public String R() {
        return this.f2992d;
    }

    public byte[] S() {
        return this.f2991c;
    }

    public int T() {
        return this.f2989a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!Arrays.equals(this.f2991c, dVar.f2991c) || this.f2990b != dVar.f2990b) {
            return false;
        }
        String str = this.f2992d;
        if (str == null) {
            if (dVar.f2992d != null) {
                return false;
            }
        } else if (!str.equals(dVar.f2992d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int iHashCode = ((Arrays.hashCode(this.f2991c) + 31) * 31) + this.f2990b.hashCode();
        String str = this.f2992d;
        return (iHashCode * 31) + (str == null ? 0 : str.hashCode());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, T());
        n5.c.E(parcel, 2, this.f2990b.toString(), false);
        n5.c.k(parcel, 3, S(), false);
        n5.c.E(parcel, 4, R(), false);
        n5.c.b(parcel, iA);
    }
}
