package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class S extends A1.a {
    public static final Parcelable.Creator<S> CREATOR = new T();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[][] f2754a;

    public S(byte[][] bArr) {
        AbstractC0940s.a(bArr != null);
        AbstractC0940s.a(1 == ((bArr.length & 1) ^ 1));
        int i4 = 0;
        while (i4 < bArr.length) {
            AbstractC0940s.a(i4 == 0 || bArr[i4] != null);
            int i5 = i4 + 1;
            AbstractC0940s.a(bArr[i5] != null);
            int length = bArr[i5].length;
            AbstractC0940s.a(length == 32 || length == 64);
            i4 += 2;
        }
        this.f2754a = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof S) {
            return Arrays.deepEquals(this.f2754a, ((S) obj).f2754a);
        }
        return false;
    }

    public final int hashCode() {
        int iC = 0;
        for (byte[] bArr : this.f2754a) {
            iC ^= AbstractC0939q.c(bArr);
        }
        return iC;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.l(parcel, 1, this.f2754a, false);
        A1.c.b(parcel, iA);
    }
}
