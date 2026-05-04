package a6;

import a6.b;
import a6.d0;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class k extends n5.a {
    public static final Parcelable.Creator<k> CREATOR = new z1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g0 f186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d0 f187d;

    public k(String str, Boolean bool, String str2, String str3) {
        b bVarA;
        d0 d0VarA = null;
        if (str == null) {
            bVarA = null;
        } else {
            try {
                bVarA = b.a(str);
            } catch (b.a | d0.a | m1 e10) {
                throw new IllegalArgumentException(e10);
            }
        }
        this.f184a = bVarA;
        this.f185b = bool;
        this.f186c = str2 == null ? null : g0.a(str2);
        if (str3 != null) {
            d0VarA = d0.a(str3);
        }
        this.f187d = d0VarA;
    }

    public String R() {
        b bVar = this.f184a;
        if (bVar == null) {
            return null;
        }
        return bVar.toString();
    }

    public Boolean S() {
        return this.f185b;
    }

    public d0 T() {
        d0 d0Var = this.f187d;
        if (d0Var != null) {
            return d0Var;
        }
        Boolean bool = this.f185b;
        if (bool == null || !bool.booleanValue()) {
            return null;
        }
        return d0.RESIDENT_KEY_REQUIRED;
    }

    public String U() {
        d0 d0VarT = T();
        if (d0VarT == null) {
            return null;
        }
        return d0VarT.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return com.google.android.gms.common.internal.q.b(this.f184a, kVar.f184a) && com.google.android.gms.common.internal.q.b(this.f185b, kVar.f185b) && com.google.android.gms.common.internal.q.b(this.f186c, kVar.f186c) && com.google.android.gms.common.internal.q.b(T(), kVar.T());
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f184a, this.f185b, this.f186c, T());
    }

    public final String toString() {
        d0 d0Var = this.f187d;
        g0 g0Var = this.f186c;
        return "AuthenticatorSelectionCriteria{\n attachment=" + String.valueOf(this.f184a) + ", \n requireResidentKey=" + this.f185b + ", \n requireUserVerification=" + String.valueOf(g0Var) + ", \n residentKeyRequirement=" + String.valueOf(d0Var) + "\n }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 2, R(), false);
        n5.c.i(parcel, 3, S(), false);
        g0 g0Var = this.f186c;
        n5.c.E(parcel, 4, g0Var == null ? null : g0Var.toString(), false);
        n5.c.E(parcel, 5, U(), false);
        n5.c.b(parcel, iA);
    }
}
