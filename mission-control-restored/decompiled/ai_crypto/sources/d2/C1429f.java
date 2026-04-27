package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;

/* JADX INFO: renamed from: d2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1429f extends Q1.a {
    public static final Parcelable.Creator<C1429f> CREATOR = new o0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f13234a;

    public C1429f(boolean z7) {
        this.f13234a = z7;
    }

    public boolean A() {
        return this.f13234a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1429f) && this.f13234a == ((C1429f) obj).f13234a;
    }

    public int hashCode() {
        return AbstractC1206q.c(Boolean.valueOf(this.f13234a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.g(parcel, 1, A());
        Q1.c.b(parcel, iA);
    }
}
