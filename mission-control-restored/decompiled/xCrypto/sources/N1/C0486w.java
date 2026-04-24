package N1;

import N1.C0479o;
import N1.EnumC0489z;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: renamed from: N1.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0486w extends A1.a {
    public static final Parcelable.Creator<C0486w> CREATOR = new X();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC0489z f2859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0479o f2860b;

    public C0486w(String str, int i4) {
        AbstractC0940s.k(str);
        try {
            this.f2859a = EnumC0489z.a(str);
            AbstractC0940s.k(Integer.valueOf(i4));
            try {
                this.f2860b = C0479o.a(i4);
            } catch (C0479o.a e4) {
                throw new IllegalArgumentException(e4);
            }
        } catch (EnumC0489z.a e5) {
            throw new IllegalArgumentException(e5);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0486w)) {
            return false;
        }
        C0486w c0486w = (C0486w) obj;
        return this.f2859a.equals(c0486w.f2859a) && this.f2860b.equals(c0486w.f2860b);
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f2859a, this.f2860b);
    }

    public int i() {
        return this.f2860b.b();
    }

    public String k() {
        return this.f2859a.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.E(parcel, 2, k(), false);
        A1.c.w(parcel, 3, Integer.valueOf(i()), false);
        A1.c.b(parcel, iA);
    }
}
