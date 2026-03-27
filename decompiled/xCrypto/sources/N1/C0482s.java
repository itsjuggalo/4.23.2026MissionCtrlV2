package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;

/* JADX INFO: renamed from: N1.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0482s extends A1.a {
    public static final Parcelable.Creator<C0482s> CREATOR = new O();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2835a;

    public C0482s(boolean z4) {
        this.f2835a = z4;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0482s) && this.f2835a == ((C0482s) obj).i();
    }

    public int hashCode() {
        return AbstractC0939q.c(Boolean.valueOf(this.f2835a));
    }

    public boolean i() {
        return this.f2835a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.g(parcel, 1, i());
        A1.c.b(parcel, iA);
    }
}
