package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import d2.C1442o;
import d2.EnumC1453z;

/* JADX INFO: renamed from: d2.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1450w extends Q1.a {
    public static final Parcelable.Creator<C1450w> CREATOR = new C1416X();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC1453z f13315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1442o f13316b;

    public C1450w(String str, int i7) {
        AbstractC1207s.k(str);
        try {
            this.f13315a = EnumC1453z.a(str);
            AbstractC1207s.k(Integer.valueOf(i7));
            try {
                this.f13316b = C1442o.a(i7);
            } catch (C1442o.a e7) {
                throw new IllegalArgumentException(e7);
            }
        } catch (EnumC1453z.a e8) {
            throw new IllegalArgumentException(e8);
        }
    }

    public int A() {
        return this.f13316b.c();
    }

    public String B() {
        return this.f13315a.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1450w)) {
            return false;
        }
        C1450w c1450w = (C1450w) obj;
        return this.f13315a.equals(c1450w.f13315a) && this.f13316b.equals(c1450w.f13316b);
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f13315a, this.f13316b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 2, B(), false);
        Q1.c.w(parcel, 3, Integer.valueOf(A()), false);
        Q1.c.b(parcel, iA);
    }
}
