package r1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;

/* JADX INFO: renamed from: r1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1748e extends A1.a {
    public static final Parcelable.Creator<C1748e> CREATOR = new u();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14527a;

    public C1748e(int i4) {
        this.f14527a = i4;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1748e) {
            return AbstractC0939q.b(Integer.valueOf(this.f14527a), Integer.valueOf(((C1748e) obj).f14527a));
        }
        return false;
    }

    public int hashCode() {
        return AbstractC0939q.c(Integer.valueOf(this.f14527a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int i5 = this.f14527a;
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, i5);
        A1.c.b(parcel, iA);
    }
}
