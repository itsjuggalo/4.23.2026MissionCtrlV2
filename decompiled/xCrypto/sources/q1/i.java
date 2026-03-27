package q1;

import E1.a;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.auth.zzbz;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class i extends zzbz {
    public static final Parcelable.Creator<i> CREATOR = new j();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final HashMap f14192h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f14193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f14195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f14197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PendingIntent f14198f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public C1719a f14199g;

    static {
        HashMap map = new HashMap();
        f14192h = map;
        map.put("accountType", a.C0016a.n("accountType", 2));
        map.put("status", a.C0016a.m("status", 3));
        map.put("transferBytes", a.C0016a.i("transferBytes", 4));
    }

    public i(Set set, int i4, String str, int i5, byte[] bArr, PendingIntent pendingIntent, C1719a c1719a) {
        this.f14193a = set;
        this.f14194b = i4;
        this.f14195c = str;
        this.f14196d = i5;
        this.f14197e = bArr;
        this.f14198f = pendingIntent;
        this.f14199g = c1719a;
    }

    @Override // E1.a
    public final /* synthetic */ Map getFieldMappings() {
        return f14192h;
    }

    @Override // E1.a
    public final Object getFieldValue(a.C0016a c0016a) {
        int iP = c0016a.p();
        if (iP == 1) {
            return Integer.valueOf(this.f14194b);
        }
        if (iP == 2) {
            return this.f14195c;
        }
        if (iP == 3) {
            return Integer.valueOf(this.f14196d);
        }
        if (iP == 4) {
            return this.f14197e;
        }
        throw new IllegalStateException("Unknown SafeParcelable id=" + c0016a.p());
    }

    @Override // E1.a
    public final boolean isFieldSet(a.C0016a c0016a) {
        return this.f14193a.contains(Integer.valueOf(c0016a.p()));
    }

    @Override // E1.a
    public final void setDecodedBytesInternal(a.C0016a c0016a, String str, byte[] bArr) {
        int iP = c0016a.p();
        if (iP == 4) {
            this.f14197e = bArr;
            this.f14193a.add(Integer.valueOf(iP));
        } else {
            throw new IllegalArgumentException("Field with id=" + iP + " is not known to be a byte array.");
        }
    }

    @Override // E1.a
    public final void setIntegerInternal(a.C0016a c0016a, String str, int i4) {
        int iP = c0016a.p();
        if (iP == 3) {
            this.f14196d = i4;
            this.f14193a.add(Integer.valueOf(iP));
        } else {
            throw new IllegalArgumentException("Field with id=" + iP + " is not known to be an int.");
        }
    }

    @Override // E1.a
    public final void setStringInternal(a.C0016a c0016a, String str, String str2) {
        int iP = c0016a.p();
        if (iP != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(iP)));
        }
        this.f14195c = str2;
        this.f14193a.add(Integer.valueOf(iP));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        Set set = this.f14193a;
        if (set.contains(1)) {
            A1.c.t(parcel, 1, this.f14194b);
        }
        if (set.contains(2)) {
            A1.c.E(parcel, 2, this.f14195c, true);
        }
        if (set.contains(3)) {
            A1.c.t(parcel, 3, this.f14196d);
        }
        if (set.contains(4)) {
            A1.c.k(parcel, 4, this.f14197e, true);
        }
        if (set.contains(5)) {
            A1.c.C(parcel, 5, this.f14198f, i4, true);
        }
        if (set.contains(6)) {
            A1.c.C(parcel, 6, this.f14199g, i4, true);
        }
        A1.c.b(parcel, iA);
    }
}
