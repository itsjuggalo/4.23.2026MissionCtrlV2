package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public final class P extends A1.a {
    public static final Parcelable.Creator<P> CREATOR = new Q();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2753a;

    public P(String str) {
        this.f2753a = (String) AbstractC0940s.k(str);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof P) {
            return this.f2753a.equals(((P) obj).f2753a);
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC0939q.c(this.f2753a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.E(parcel, 1, this.f2753a, false);
        A1.c.b(parcel, iA);
    }
}
