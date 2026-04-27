package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;

/* JADX INFO: renamed from: d2.F, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1399F extends Q1.a {
    public static final Parcelable.Creator<C1399F> CREATOR = new C1430f0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f13201a;

    public C1399F(boolean z7) {
        this.f13201a = z7;
    }

    public boolean A() {
        return this.f13201a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1399F) && this.f13201a == ((C1399F) obj).f13201a;
    }

    public int hashCode() {
        return AbstractC1206q.c(Boolean.valueOf(this.f13201a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.g(parcel, 1, A());
        Q1.c.b(parcel, iA);
    }
}
