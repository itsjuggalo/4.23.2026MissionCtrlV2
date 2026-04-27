package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: d2.P, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1409P extends Q1.a {
    public static final Parcelable.Creator<C1409P> CREATOR = new C1410Q();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13209a;

    public C1409P(String str) {
        this.f13209a = (String) AbstractC1207s.k(str);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1409P) {
            return this.f13209a.equals(((C1409P) obj).f13209a);
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC1206q.c(this.f13209a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, this.f13209a, false);
        Q1.c.b(parcel, iA);
    }
}
