package O1;

import O1.c;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class d extends A1.a {
    public static final Parcelable.Creator<d> CREATOR = new j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f3122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f3123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3124d;

    public d(int i4, String str, byte[] bArr, String str2) {
        this.f3121a = i4;
        try {
            this.f3122b = c.a(str);
            this.f3123c = bArr;
            this.f3124d = str2;
        } catch (c.a e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!Arrays.equals(this.f3123c, dVar.f3123c) || this.f3122b != dVar.f3122b) {
            return false;
        }
        String str = this.f3124d;
        if (str == null) {
            if (dVar.f3124d != null) {
                return false;
            }
        } else if (!str.equals(dVar.f3124d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int iHashCode = ((Arrays.hashCode(this.f3123c) + 31) * 31) + this.f3122b.hashCode();
        String str = this.f3124d;
        return (iHashCode * 31) + (str == null ? 0 : str.hashCode());
    }

    public String i() {
        return this.f3124d;
    }

    public byte[] k() {
        return this.f3123c;
    }

    public int l() {
        return this.f3121a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, l());
        A1.c.E(parcel, 2, this.f3122b.toString(), false);
        A1.c.k(parcel, 3, k(), false);
        A1.c.E(parcel, 4, i(), false);
        A1.c.b(parcel, iA);
    }
}
