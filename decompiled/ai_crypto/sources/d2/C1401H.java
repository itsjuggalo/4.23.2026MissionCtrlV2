package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;

/* JADX INFO: renamed from: d2.H, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1401H extends Q1.a {
    public static final Parcelable.Creator<C1401H> CREATOR = new l0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final short f13204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final short f13205c;

    public C1401H(int i7, short s7, short s8) {
        this.f13203a = i7;
        this.f13204b = s7;
        this.f13205c = s8;
    }

    public short A() {
        return this.f13204b;
    }

    public short B() {
        return this.f13205c;
    }

    public int C() {
        return this.f13203a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1401H)) {
            return false;
        }
        C1401H c1401h = (C1401H) obj;
        return this.f13203a == c1401h.f13203a && this.f13204b == c1401h.f13204b && this.f13205c == c1401h.f13205c;
    }

    public int hashCode() {
        return AbstractC1206q.c(Integer.valueOf(this.f13203a), Short.valueOf(this.f13204b), Short.valueOf(this.f13205c));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, C());
        Q1.c.D(parcel, 2, A());
        Q1.c.D(parcel, 3, B());
        Q1.c.b(parcel, iA);
    }
}
