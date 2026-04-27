package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public final class E0 extends Q1.a {
    public static final Parcelable.Creator<E0> CREATOR = new F0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f13200a;

    public E0(boolean z7) {
        this.f13200a = ((Boolean) AbstractC1207s.k(Boolean.valueOf(z7))).booleanValue();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof E0) && this.f13200a == ((E0) obj).f13200a;
    }

    public final int hashCode() {
        return AbstractC1206q.c(Boolean.valueOf(this.f13200a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.g(parcel, 1, this.f13200a);
        Q1.c.b(parcel, iA);
    }
}
