package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.fido.zzbc;
import com.google.android.gms.internal.fido.zzh;
import d2.EnumC1453z;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: d2.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1449v extends Q1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC1453z f13312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f13314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zzbc f13311d = zzbc.zzk(zzh.zza, zzh.zzb);
    public static final Parcelable.Creator<C1449v> CREATOR = new C1415W();

    public C1449v(String str, byte[] bArr, List list) {
        AbstractC1207s.k(str);
        try {
            this.f13312a = EnumC1453z.a(str);
            this.f13313b = (byte[]) AbstractC1207s.k(bArr);
            this.f13314c = list;
        } catch (EnumC1453z.a e7) {
            throw new IllegalArgumentException(e7);
        }
    }

    public byte[] A() {
        return this.f13313b;
    }

    public List B() {
        return this.f13314c;
    }

    public String C() {
        return this.f13312a.toString();
    }

    public boolean equals(Object obj) {
        List list;
        if (!(obj instanceof C1449v)) {
            return false;
        }
        C1449v c1449v = (C1449v) obj;
        if (!this.f13312a.equals(c1449v.f13312a) || !Arrays.equals(this.f13313b, c1449v.f13313b)) {
            return false;
        }
        List list2 = this.f13314c;
        if (list2 == null && c1449v.f13314c == null) {
            return true;
        }
        return list2 != null && (list = c1449v.f13314c) != null && list2.containsAll(list) && c1449v.f13314c.containsAll(this.f13314c);
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f13312a, Integer.valueOf(Arrays.hashCode(this.f13313b)), this.f13314c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 2, C(), false);
        Q1.c.k(parcel, 3, A(), false);
        Q1.c.I(parcel, 4, B(), false);
        Q1.c.b(parcel, iA);
    }
}
