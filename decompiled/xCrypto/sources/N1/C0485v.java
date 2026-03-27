package N1;

import N1.EnumC0489z;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.fido.zzbc;
import com.google.android.gms.internal.fido.zzh;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: N1.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0485v extends A1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC0489z f2856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f2857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f2858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zzbc f2855d = zzbc.zzk(zzh.zza, zzh.zzb);
    public static final Parcelable.Creator<C0485v> CREATOR = new W();

    public C0485v(String str, byte[] bArr, List list) {
        AbstractC0940s.k(str);
        try {
            this.f2856a = EnumC0489z.a(str);
            this.f2857b = (byte[]) AbstractC0940s.k(bArr);
            this.f2858c = list;
        } catch (EnumC0489z.a e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public boolean equals(Object obj) {
        List list;
        if (!(obj instanceof C0485v)) {
            return false;
        }
        C0485v c0485v = (C0485v) obj;
        if (!this.f2856a.equals(c0485v.f2856a) || !Arrays.equals(this.f2857b, c0485v.f2857b)) {
            return false;
        }
        List list2 = this.f2858c;
        if (list2 == null && c0485v.f2858c == null) {
            return true;
        }
        return list2 != null && (list = c0485v.f2858c) != null && list2.containsAll(list) && c0485v.f2858c.containsAll(this.f2858c);
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f2856a, Integer.valueOf(Arrays.hashCode(this.f2857b)), this.f2858c);
    }

    public byte[] i() {
        return this.f2857b;
    }

    public List k() {
        return this.f2858c;
    }

    public String l() {
        return this.f2856a.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.E(parcel, 2, l(), false);
        A1.c.k(parcel, 3, i(), false);
        A1.c.I(parcel, 4, k(), false);
        A1.c.b(parcel, iA);
    }
}
