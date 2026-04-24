package H1;

import U1.a;
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
    public static final HashMap f2577h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f2578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f2582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PendingIntent f2583f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f2584g;

    static {
        HashMap map = new HashMap();
        f2577h = map;
        map.put("accountType", a.C0083a.E("accountType", 2));
        map.put("status", a.C0083a.D("status", 3));
        map.put("transferBytes", a.C0083a.A("transferBytes", 4));
    }

    public i(Set set, int i7, String str, int i8, byte[] bArr, PendingIntent pendingIntent, a aVar) {
        this.f2578a = set;
        this.f2579b = i7;
        this.f2580c = str;
        this.f2581d = i8;
        this.f2582e = bArr;
        this.f2583f = pendingIntent;
        this.f2584g = aVar;
    }

    @Override // U1.a
    public final /* synthetic */ Map getFieldMappings() {
        return f2577h;
    }

    @Override // U1.a
    public final Object getFieldValue(a.C0083a c0083a) {
        int iG = c0083a.G();
        if (iG == 1) {
            return Integer.valueOf(this.f2579b);
        }
        if (iG == 2) {
            return this.f2580c;
        }
        if (iG == 3) {
            return Integer.valueOf(this.f2581d);
        }
        if (iG == 4) {
            return this.f2582e;
        }
        throw new IllegalStateException("Unknown SafeParcelable id=" + c0083a.G());
    }

    @Override // U1.a
    public final boolean isFieldSet(a.C0083a c0083a) {
        return this.f2578a.contains(Integer.valueOf(c0083a.G()));
    }

    @Override // U1.a
    public final void setDecodedBytesInternal(a.C0083a c0083a, String str, byte[] bArr) {
        int iG = c0083a.G();
        if (iG == 4) {
            this.f2582e = bArr;
            this.f2578a.add(Integer.valueOf(iG));
        } else {
            throw new IllegalArgumentException("Field with id=" + iG + " is not known to be a byte array.");
        }
    }

    @Override // U1.a
    public final void setIntegerInternal(a.C0083a c0083a, String str, int i7) {
        int iG = c0083a.G();
        if (iG == 3) {
            this.f2581d = i7;
            this.f2578a.add(Integer.valueOf(iG));
        } else {
            throw new IllegalArgumentException("Field with id=" + iG + " is not known to be an int.");
        }
    }

    @Override // U1.a
    public final void setStringInternal(a.C0083a c0083a, String str, String str2) {
        int iG = c0083a.G();
        if (iG != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(iG)));
        }
        this.f2580c = str2;
        this.f2578a.add(Integer.valueOf(iG));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Set set = this.f2578a;
        if (set.contains(1)) {
            Q1.c.t(parcel, 1, this.f2579b);
        }
        if (set.contains(2)) {
            Q1.c.E(parcel, 2, this.f2580c, true);
        }
        if (set.contains(3)) {
            Q1.c.t(parcel, 3, this.f2581d);
        }
        if (set.contains(4)) {
            Q1.c.k(parcel, 4, this.f2582e, true);
        }
        if (set.contains(5)) {
            Q1.c.C(parcel, 5, this.f2583f, i7, true);
        }
        if (set.contains(6)) {
            Q1.c.C(parcel, 6, this.f2584g, i7, true);
        }
        Q1.c.b(parcel, iA);
    }
}
