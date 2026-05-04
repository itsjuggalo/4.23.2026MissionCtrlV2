package c5;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends n5.a {
    public static final Parcelable.Creator<e> CREATOR = new u();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3653b;

    public e(String str, boolean z10) {
        this.f3652a = str;
        this.f3653b = z10;
    }

    public boolean R() {
        return this.f3653b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f3652a.equals(eVar.f3652a) && this.f3653b == eVar.f3653b) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return this.f3652a;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f3652a, Boolean.valueOf(this.f3653b));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, getName(), false);
        n5.c.g(parcel, 2, R());
        n5.c.b(parcel, iA);
    }
}
