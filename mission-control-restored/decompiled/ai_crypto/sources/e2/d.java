package e2;

import android.os.Parcel;
import android.os.Parcelable;
import e2.c;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class d extends Q1.a {
    public static final Parcelable.Creator<d> CREATOR = new j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f13583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f13584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13585d;

    public d(int i7, String str, byte[] bArr, String str2) {
        this.f13582a = i7;
        try {
            this.f13583b = c.a(str);
            this.f13584c = bArr;
            this.f13585d = str2;
        } catch (c.a e7) {
            throw new IllegalArgumentException(e7);
        }
    }

    public String A() {
        return this.f13585d;
    }

    public byte[] B() {
        return this.f13584c;
    }

    public int C() {
        return this.f13582a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!Arrays.equals(this.f13584c, dVar.f13584c) || this.f13583b != dVar.f13583b) {
            return false;
        }
        String str = this.f13585d;
        if (str == null) {
            if (dVar.f13585d != null) {
                return false;
            }
        } else if (!str.equals(dVar.f13585d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int iHashCode = ((Arrays.hashCode(this.f13584c) + 31) * 31) + this.f13583b.hashCode();
        String str = this.f13585d;
        return (iHashCode * 31) + (str == null ? 0 : str.hashCode());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, C());
        Q1.c.E(parcel, 2, this.f13583b.toString(), false);
        Q1.c.k(parcel, 3, B(), false);
        Q1.c.E(parcel, 4, A(), false);
        Q1.c.b(parcel, iA);
    }
}
