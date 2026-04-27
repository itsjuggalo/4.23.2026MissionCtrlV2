package n1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Q;
import com.google.android.gms.internal.auth.zzbz;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import t2.u0;
import z1.C1456a;

/* JADX INFO: renamed from: n1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0871f extends zzbz {
    public static final Parcelable.Creator<C0871f> CREATOR = new Q(25);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final HashMap f8544l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f8545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f8547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8548d;
    public byte[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PendingIntent f8549f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C0866a f8550k;

    static {
        HashMap map = new HashMap();
        f8544l = map;
        map.put("accountType", new C1456a(7, false, 7, false, "accountType", 2, null));
        map.put("status", new C1456a(0, false, 0, false, "status", 3, null));
        map.put("transferBytes", new C1456a(8, false, 8, false, "transferBytes", 4, null));
    }

    public C0871f(HashSet hashSet, int i, String str, int i6, byte[] bArr, PendingIntent pendingIntent, C0866a c0866a) {
        this.f8545a = hashSet;
        this.f8546b = i;
        this.f8547c = str;
        this.f8548d = i6;
        this.e = bArr;
        this.f8549f = pendingIntent;
        this.f8550k = c0866a;
    }

    @Override // z1.AbstractC1457b
    public final /* synthetic */ Map getFieldMappings() {
        return f8544l;
    }

    @Override // z1.AbstractC1457b
    public final Object getFieldValue(C1456a c1456a) {
        int i = c1456a.f11737k;
        if (i == 1) {
            return Integer.valueOf(this.f8546b);
        }
        if (i == 2) {
            return this.f8547c;
        }
        if (i == 3) {
            return Integer.valueOf(this.f8548d);
        }
        if (i == 4) {
            return this.e;
        }
        throw new IllegalStateException("Unknown SafeParcelable id=" + c1456a.f11737k);
    }

    @Override // z1.AbstractC1457b
    public final boolean isFieldSet(C1456a c1456a) {
        return this.f8545a.contains(Integer.valueOf(c1456a.f11737k));
    }

    @Override // z1.AbstractC1457b
    public final void setDecodedBytesInternal(C1456a c1456a, String str, byte[] bArr) {
        int i = c1456a.f11737k;
        if (i != 4) {
            throw new IllegalArgumentException(a3.d.i("Field with id=", i, " is not known to be a byte array."));
        }
        this.e = bArr;
        this.f8545a.add(Integer.valueOf(i));
    }

    @Override // z1.AbstractC1457b
    public final void setIntegerInternal(C1456a c1456a, String str, int i) {
        int i6 = c1456a.f11737k;
        if (i6 != 3) {
            throw new IllegalArgumentException(a3.d.i("Field with id=", i6, " is not known to be an int."));
        }
        this.f8548d = i;
        this.f8545a.add(Integer.valueOf(i6));
    }

    @Override // z1.AbstractC1457b
    public final void setStringInternal(C1456a c1456a, String str, String str2) {
        int i = c1456a.f11737k;
        if (i != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(i)));
        }
        this.f8547c = str2;
        this.f8545a.add(Integer.valueOf(i));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        HashSet hashSet = this.f8545a;
        if (hashSet.contains(1)) {
            u0.b0(parcel, 1, 4);
            parcel.writeInt(this.f8546b);
        }
        if (hashSet.contains(2)) {
            u0.T(parcel, 2, this.f8547c, true);
        }
        if (hashSet.contains(3)) {
            int i6 = this.f8548d;
            u0.b0(parcel, 3, 4);
            parcel.writeInt(i6);
        }
        if (hashSet.contains(4)) {
            u0.M(parcel, 4, this.e, true);
        }
        if (hashSet.contains(5)) {
            u0.S(parcel, 5, this.f8549f, i, true);
        }
        if (hashSet.contains(6)) {
            u0.S(parcel, 6, this.f8550k, i, true);
        }
        u0.a0(iX, parcel);
    }
}
