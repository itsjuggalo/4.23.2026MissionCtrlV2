package I1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;

/* JADX INFO: renamed from: I1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0580e extends Q1.a {
    public static final Parcelable.Creator<C0580e> CREATOR = new u();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2911a;

    public C0580e(int i7) {
        this.f2911a = i7;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0580e) {
            return AbstractC1206q.b(Integer.valueOf(this.f2911a), Integer.valueOf(((C0580e) obj).f2911a));
        }
        return false;
    }

    public int hashCode() {
        return AbstractC1206q.c(Integer.valueOf(this.f2911a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int i8 = this.f2911a;
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, i8);
        Q1.c.b(parcel, iA);
    }
}
