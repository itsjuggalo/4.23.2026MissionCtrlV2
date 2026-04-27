package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public class r extends A1.a {
    public static final Parcelable.Creator<r> CREATOR = new H0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2832a;

    public r(String str) {
        this.f2832a = (String) AbstractC0940s.k(str);
    }

    public boolean equals(Object obj) {
        if (obj instanceof r) {
            return this.f2832a.equals(((r) obj).f2832a);
        }
        return false;
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f2832a);
    }

    public String i() {
        return this.f2832a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.E(parcel, 2, i(), false);
        A1.c.b(parcel, iA);
    }
}
