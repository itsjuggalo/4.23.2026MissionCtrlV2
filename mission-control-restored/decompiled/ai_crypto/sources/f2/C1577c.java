package f2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: f2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1577c extends Q1.a {
    public static final Parcelable.Creator<C1577c> CREATOR = new C1570V();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14078b;

    public C1577c(int i7, int i8) {
        this.f14077a = i7;
        this.f14078b = i8;
    }

    public int A() {
        return this.f14077a;
    }

    public int B() {
        return this.f14078b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1577c)) {
            return false;
        }
        C1577c c1577c = (C1577c) obj;
        return this.f14077a == c1577c.f14077a && this.f14078b == c1577c.f14078b;
    }

    public int hashCode() {
        return AbstractC1206q.c(Integer.valueOf(this.f14077a), Integer.valueOf(this.f14078b));
    }

    public String toString() {
        int i7 = this.f14077a;
        int i8 = this.f14078b;
        StringBuilder sb = new StringBuilder(75);
        sb.append("ActivityTransition [mActivityType=");
        sb.append(i7);
        sb.append(", mTransitionType=");
        sb.append(i8);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        AbstractC1207s.k(parcel);
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, A());
        Q1.c.t(parcel, 2, B());
        Q1.c.b(parcel, iA);
    }
}
