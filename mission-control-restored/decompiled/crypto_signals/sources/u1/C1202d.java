package u1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: renamed from: u1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1202d extends AbstractC1255a {
    public static final Parcelable.Creator<C1202d> CREATOR = new o1.r(22);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f10282c;

    public C1202d(long j4, String str, int i) {
        this.f10280a = str;
        this.f10281b = i;
        this.f10282c = j4;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1202d) {
            C1202d c1202d = (C1202d) obj;
            String str = this.f10280a;
            if (((str != null && str.equals(c1202d.f10280a)) || (str == null && c1202d.f10280a == null)) && m() == c1202d.m()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10280a, Long.valueOf(m())});
    }

    public final long m() {
        long j4 = this.f10282c;
        return j4 == -1 ? this.f10281b : j4;
    }

    public final String toString() {
        Y3.d dVar = new Y3.d(this);
        dVar.h(this.f10280a, "name");
        dVar.h(Long.valueOf(m()), "version");
        return dVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.T(parcel, 1, this.f10280a, false);
        u0.b0(parcel, 2, 4);
        parcel.writeInt(this.f10281b);
        long jM = m();
        u0.b0(parcel, 3, 8);
        parcel.writeLong(jM);
        u0.a0(iX, parcel);
    }

    public C1202d(String str, long j4) {
        this.f10280a = str;
        this.f10282c = j4;
        this.f10281b = -1;
    }
}
