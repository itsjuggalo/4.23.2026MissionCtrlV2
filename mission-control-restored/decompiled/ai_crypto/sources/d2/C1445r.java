package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: d2.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1445r extends Q1.a {
    public static final Parcelable.Creator<C1445r> CREATOR = new H0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13288a;

    public C1445r(String str) {
        this.f13288a = (String) AbstractC1207s.k(str);
    }

    public String A() {
        return this.f13288a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1445r) {
            return this.f13288a.equals(((C1445r) obj).f13288a);
        }
        return false;
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f13288a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 2, A(), false);
        Q1.c.b(parcel, iA);
    }
}
