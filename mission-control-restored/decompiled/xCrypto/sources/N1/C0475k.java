package N1;

import N1.D;
import N1.EnumC0458b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;

/* JADX INFO: renamed from: N1.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0475k extends A1.a {
    public static final Parcelable.Creator<C0475k> CREATOR = new w0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC0458b f2796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f2797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EnumC0473i0 f2798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final D f2799d;

    public C0475k(String str, Boolean bool, String str2, String str3) {
        EnumC0458b enumC0458bA;
        D dA = null;
        if (str == null) {
            enumC0458bA = null;
        } else {
            try {
                enumC0458bA = EnumC0458b.a(str);
            } catch (D.a | EnumC0458b.a | C0471h0 e4) {
                throw new IllegalArgumentException(e4);
            }
        }
        this.f2796a = enumC0458bA;
        this.f2797b = bool;
        this.f2798c = str2 == null ? null : EnumC0473i0.a(str2);
        if (str3 != null) {
            dA = D.a(str3);
        }
        this.f2799d = dA;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0475k)) {
            return false;
        }
        C0475k c0475k = (C0475k) obj;
        return AbstractC0939q.b(this.f2796a, c0475k.f2796a) && AbstractC0939q.b(this.f2797b, c0475k.f2797b) && AbstractC0939q.b(this.f2798c, c0475k.f2798c) && AbstractC0939q.b(l(), c0475k.l());
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f2796a, this.f2797b, this.f2798c, l());
    }

    public String i() {
        EnumC0458b enumC0458b = this.f2796a;
        if (enumC0458b == null) {
            return null;
        }
        return enumC0458b.toString();
    }

    public Boolean k() {
        return this.f2797b;
    }

    public D l() {
        D d4 = this.f2799d;
        if (d4 != null) {
            return d4;
        }
        Boolean bool = this.f2797b;
        if (bool == null || !bool.booleanValue()) {
            return null;
        }
        return D.RESIDENT_KEY_REQUIRED;
    }

    public String m() {
        if (l() == null) {
            return null;
        }
        return l().toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.E(parcel, 2, i(), false);
        A1.c.i(parcel, 3, k(), false);
        EnumC0473i0 enumC0473i0 = this.f2798c;
        A1.c.E(parcel, 4, enumC0473i0 == null ? null : enumC0473i0.toString(), false);
        A1.c.E(parcel, 5, m(), false);
        A1.c.b(parcel, iA);
    }
}
