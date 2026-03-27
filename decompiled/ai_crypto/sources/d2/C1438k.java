package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import d2.EnumC1397D;
import d2.EnumC1421b;

/* JADX INFO: renamed from: d2.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1438k extends Q1.a {
    public static final Parcelable.Creator<C1438k> CREATOR = new w0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC1421b f13252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f13253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EnumC1436i0 f13254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EnumC1397D f13255d;

    public C1438k(String str, Boolean bool, String str2, String str3) {
        EnumC1421b enumC1421bA;
        EnumC1397D enumC1397DA = null;
        if (str == null) {
            enumC1421bA = null;
        } else {
            try {
                enumC1421bA = EnumC1421b.a(str);
            } catch (EnumC1397D.a | EnumC1421b.a | C1434h0 e7) {
                throw new IllegalArgumentException(e7);
            }
        }
        this.f13252a = enumC1421bA;
        this.f13253b = bool;
        this.f13254c = str2 == null ? null : EnumC1436i0.a(str2);
        if (str3 != null) {
            enumC1397DA = EnumC1397D.a(str3);
        }
        this.f13255d = enumC1397DA;
    }

    public String A() {
        EnumC1421b enumC1421b = this.f13252a;
        if (enumC1421b == null) {
            return null;
        }
        return enumC1421b.toString();
    }

    public Boolean B() {
        return this.f13253b;
    }

    public EnumC1397D C() {
        EnumC1397D enumC1397D = this.f13255d;
        if (enumC1397D != null) {
            return enumC1397D;
        }
        Boolean bool = this.f13253b;
        if (bool == null || !bool.booleanValue()) {
            return null;
        }
        return EnumC1397D.RESIDENT_KEY_REQUIRED;
    }

    public String D() {
        if (C() == null) {
            return null;
        }
        return C().toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1438k)) {
            return false;
        }
        C1438k c1438k = (C1438k) obj;
        return AbstractC1206q.b(this.f13252a, c1438k.f13252a) && AbstractC1206q.b(this.f13253b, c1438k.f13253b) && AbstractC1206q.b(this.f13254c, c1438k.f13254c) && AbstractC1206q.b(C(), c1438k.C());
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f13252a, this.f13253b, this.f13254c, C());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 2, A(), false);
        Q1.c.i(parcel, 3, B(), false);
        EnumC1436i0 enumC1436i0 = this.f13254c;
        Q1.c.E(parcel, 4, enumC1436i0 == null ? null : enumC1436i0.toString(), false);
        Q1.c.E(parcel, 5, D(), false);
        Q1.c.b(parcel, iA);
    }
}
