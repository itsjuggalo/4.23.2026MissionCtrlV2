package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: d2.M, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1406M extends Q1.a {
    public static final Parcelable.Creator<C1406M> CREATOR = new C1407N();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f13208a;

    public C1406M(boolean z7) {
        this.f13208a = ((Boolean) AbstractC1207s.k(Boolean.valueOf(z7))).booleanValue();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C1406M) && this.f13208a == ((C1406M) obj).f13208a;
    }

    public final int hashCode() {
        return AbstractC1206q.c(Boolean.valueOf(this.f13208a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.g(parcel, 1, this.f13208a);
        Q1.c.b(parcel, iA);
    }
}
