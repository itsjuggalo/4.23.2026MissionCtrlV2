package N1;

import N1.EnumC0481q;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.internal.fido.zzam;
import com.google.android.gms.internal.fido.zzan;

/* JADX INFO: renamed from: N1.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0472i extends AbstractC0474j {
    public static final Parcelable.Creator<C0472i> CREATOR = new v0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC0481q f2788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2790c;

    public C0472i(int i4, String str, int i5) {
        try {
            this.f2788a = EnumC0481q.c(i4);
            this.f2789b = str;
            this.f2790c = i5;
        } catch (EnumC0481q.a e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0472i)) {
            return false;
        }
        C0472i c0472i = (C0472i) obj;
        return AbstractC0939q.b(this.f2788a, c0472i.f2788a) && AbstractC0939q.b(this.f2789b, c0472i.f2789b) && AbstractC0939q.b(Integer.valueOf(this.f2790c), Integer.valueOf(c0472i.f2790c));
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f2788a, this.f2789b, Integer.valueOf(this.f2790c));
    }

    public int i() {
        return this.f2788a.a();
    }

    public String k() {
        return this.f2789b;
    }

    public String toString() {
        zzam zzamVarZza = zzan.zza(this);
        zzamVarZza.zza("errorCode", this.f2788a.a());
        String str = this.f2789b;
        if (str != null) {
            zzamVarZza.zzb(com.amazon.a.a.o.b.f8758f, str);
        }
        return zzamVarZza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 2, i());
        A1.c.E(parcel, 3, k(), false);
        A1.c.t(parcel, 4, this.f2790c);
        A1.c.b(parcel, iA);
    }
}
