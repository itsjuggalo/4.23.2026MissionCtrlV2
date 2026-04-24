package P1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: renamed from: P1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0492c extends A1.a {
    public static final Parcelable.Creator<C0492c> CREATOR = new V();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3413b;

    public C0492c(int i4, int i5) {
        this.f3412a = i4;
        this.f3413b = i5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0492c)) {
            return false;
        }
        C0492c c0492c = (C0492c) obj;
        return this.f3412a == c0492c.f3412a && this.f3413b == c0492c.f3413b;
    }

    public int hashCode() {
        return AbstractC0939q.c(Integer.valueOf(this.f3412a), Integer.valueOf(this.f3413b));
    }

    public int i() {
        return this.f3412a;
    }

    public int k() {
        return this.f3413b;
    }

    public String toString() {
        int i4 = this.f3412a;
        int i5 = this.f3413b;
        StringBuilder sb = new StringBuilder(75);
        sb.append("ActivityTransition [mActivityType=");
        sb.append(i4);
        sb.append(", mTransitionType=");
        sb.append(i5);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        AbstractC0940s.k(parcel);
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, i());
        A1.c.t(parcel, 2, k());
        A1.c.b(parcel, iA);
    }
}
