package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public final class I0 extends A1.a {
    public static final Parcelable.Creator<I0> CREATOR = new J();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2750a;

    public I0(boolean z4) {
        this.f2750a = ((Boolean) AbstractC0940s.k(Boolean.valueOf(z4))).booleanValue();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof I0) && this.f2750a == ((I0) obj).f2750a;
    }

    public final int hashCode() {
        return AbstractC0939q.c(Boolean.valueOf(this.f2750a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.g(parcel, 1, this.f2750a);
        A1.c.b(parcel, iA);
    }
}
