package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.Arrays;

/* JADX INFO: renamed from: d2.S, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1411S extends Q1.a {
    public static final Parcelable.Creator<C1411S> CREATOR = new C1412T();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[][] f13210a;

    public C1411S(byte[][] bArr) {
        AbstractC1207s.a(bArr != null);
        AbstractC1207s.a(1 == ((bArr.length & 1) ^ 1));
        int i7 = 0;
        while (i7 < bArr.length) {
            AbstractC1207s.a(i7 == 0 || bArr[i7] != null);
            int i8 = i7 + 1;
            AbstractC1207s.a(bArr[i8] != null);
            int length = bArr[i8].length;
            AbstractC1207s.a(length == 32 || length == 64);
            i7 += 2;
        }
        this.f13210a = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1411S) {
            return Arrays.deepEquals(this.f13210a, ((C1411S) obj).f13210a);
        }
        return false;
    }

    public final int hashCode() {
        int iC = 0;
        for (byte[] bArr : this.f13210a) {
            iC ^= AbstractC1206q.c(bArr);
        }
        return iC;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.l(parcel, 1, this.f13210a, false);
        Q1.c.b(parcel, iA);
    }
}
