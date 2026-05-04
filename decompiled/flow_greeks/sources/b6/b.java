package b6;

import android.os.Parcel;
import android.os.Parcelable;
import b6.c;
import com.google.android.gms.common.internal.q;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b extends n5.a {
    public static final Parcelable.Creator<b> CREATOR = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f2981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f2982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f2983d;

    public b(int i10, byte[] bArr, String str, List list) {
        this.f2980a = i10;
        this.f2981b = bArr;
        try {
            this.f2982c = c.a(str);
            this.f2983d = list;
        } catch (c.a e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public byte[] R() {
        return this.f2981b;
    }

    public c S() {
        return this.f2982c;
    }

    public List T() {
        return this.f2983d;
    }

    public int U() {
        return this.f2980a;
    }

    public boolean equals(Object obj) {
        List list;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!Arrays.equals(this.f2981b, bVar.f2981b) || !this.f2982c.equals(bVar.f2982c)) {
            return false;
        }
        List list2 = this.f2983d;
        if (list2 == null && bVar.f2983d == null) {
            return true;
        }
        return list2 != null && (list = bVar.f2983d) != null && list2.containsAll(list) && bVar.f2983d.containsAll(this.f2983d);
    }

    public int hashCode() {
        return q.c(Integer.valueOf(Arrays.hashCode(this.f2981b)), this.f2982c, this.f2983d);
    }

    public String toString() {
        List list = this.f2983d;
        return String.format("{keyHandle: %s, version: %s, transports: %s}", t5.c.c(this.f2981b), this.f2982c, list == null ? "null" : list.toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, U());
        n5.c.k(parcel, 2, R(), false);
        n5.c.E(parcel, 3, this.f2982c.toString(), false);
        n5.c.I(parcel, 4, T(), false);
        n5.c.b(parcel, iA);
    }
}
