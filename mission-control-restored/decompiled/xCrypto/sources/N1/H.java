package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;

/* JADX INFO: loaded from: classes.dex */
public class H extends A1.a {
    public static final Parcelable.Creator<H> CREATOR = new l0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final short f2748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final short f2749c;

    public H(int i4, short s4, short s5) {
        this.f2747a = i4;
        this.f2748b = s4;
        this.f2749c = s5;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof H)) {
            return false;
        }
        H h4 = (H) obj;
        return this.f2747a == h4.f2747a && this.f2748b == h4.f2748b && this.f2749c == h4.f2749c;
    }

    public int hashCode() {
        return AbstractC0939q.c(Integer.valueOf(this.f2747a), Short.valueOf(this.f2748b), Short.valueOf(this.f2749c));
    }

    public short i() {
        return this.f2748b;
    }

    public short k() {
        return this.f2749c;
    }

    public int l() {
        return this.f2747a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, l());
        A1.c.D(parcel, 2, i());
        A1.c.D(parcel, 3, k());
        A1.c.b(parcel, iA);
    }
}
