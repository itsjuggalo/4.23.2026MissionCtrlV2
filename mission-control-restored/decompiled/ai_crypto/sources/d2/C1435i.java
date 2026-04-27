package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.internal.fido.zzam;
import com.google.android.gms.internal.fido.zzan;
import d2.EnumC1444q;

/* JADX INFO: renamed from: d2.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1435i extends AbstractC1437j {
    public static final Parcelable.Creator<C1435i> CREATOR = new v0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC1444q f13244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13246c;

    public C1435i(int i7, String str, int i8) {
        try {
            this.f13244a = EnumC1444q.c(i7);
            this.f13245b = str;
            this.f13246c = i8;
        } catch (EnumC1444q.a e7) {
            throw new IllegalArgumentException(e7);
        }
    }

    public int A() {
        return this.f13244a.a();
    }

    public String B() {
        return this.f13245b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1435i)) {
            return false;
        }
        C1435i c1435i = (C1435i) obj;
        return AbstractC1206q.b(this.f13244a, c1435i.f13244a) && AbstractC1206q.b(this.f13245b, c1435i.f13245b) && AbstractC1206q.b(Integer.valueOf(this.f13246c), Integer.valueOf(c1435i.f13246c));
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f13244a, this.f13245b, Integer.valueOf(this.f13246c));
    }

    public String toString() {
        zzam zzamVarZza = zzan.zza(this);
        zzamVarZza.zza("errorCode", this.f13244a.a());
        String str = this.f13245b;
        if (str != null) {
            zzamVarZza.zzb(com.amazon.a.a.o.b.f9943f, str);
        }
        return zzamVarZza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 2, A());
        Q1.c.E(parcel, 3, B(), false);
        Q1.c.t(parcel, 4, this.f13246c);
        Q1.c.b(parcel, iA);
    }
}
