package b5;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.auth.zzbz;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import r5.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends zzbz {
    public static final Parcelable.Creator<i> CREATOR = new j();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final HashMap f2961h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f2962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f2966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PendingIntent f2967f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f2968g;

    static {
        HashMap map = new HashMap();
        f2961h = map;
        map.put("accountType", a.C0336a.V("accountType", 2));
        map.put("status", a.C0336a.U("status", 3));
        map.put("transferBytes", a.C0336a.R("transferBytes", 4));
    }

    public i(Set set, int i10, String str, int i11, byte[] bArr, PendingIntent pendingIntent, a aVar) {
        this.f2962a = set;
        this.f2963b = i10;
        this.f2964c = str;
        this.f2965d = i11;
        this.f2966e = bArr;
        this.f2967f = pendingIntent;
        this.f2968g = aVar;
    }

    @Override // r5.a
    public final /* synthetic */ Map getFieldMappings() {
        return f2961h;
    }

    @Override // r5.a
    public final Object getFieldValue(a.C0336a c0336a) {
        int iX = c0336a.X();
        if (iX == 1) {
            return Integer.valueOf(this.f2963b);
        }
        if (iX == 2) {
            return this.f2964c;
        }
        if (iX == 3) {
            return Integer.valueOf(this.f2965d);
        }
        if (iX == 4) {
            return this.f2966e;
        }
        throw new IllegalStateException("Unknown SafeParcelable id=" + c0336a.X());
    }

    @Override // r5.a
    public final boolean isFieldSet(a.C0336a c0336a) {
        return this.f2962a.contains(Integer.valueOf(c0336a.X()));
    }

    @Override // r5.a
    public final void setDecodedBytesInternal(a.C0336a c0336a, String str, byte[] bArr) {
        int iX = c0336a.X();
        if (iX == 4) {
            this.f2966e = bArr;
            this.f2962a.add(Integer.valueOf(iX));
        } else {
            throw new IllegalArgumentException("Field with id=" + iX + " is not known to be a byte array.");
        }
    }

    @Override // r5.a
    public final void setIntegerInternal(a.C0336a c0336a, String str, int i10) {
        int iX = c0336a.X();
        if (iX == 3) {
            this.f2965d = i10;
            this.f2962a.add(Integer.valueOf(iX));
        } else {
            throw new IllegalArgumentException("Field with id=" + iX + " is not known to be an int.");
        }
    }

    @Override // r5.a
    public final void setStringInternal(a.C0336a c0336a, String str, String str2) {
        int iX = c0336a.X();
        if (iX != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(iX)));
        }
        this.f2964c = str2;
        this.f2962a.add(Integer.valueOf(iX));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        Set set = this.f2962a;
        if (set.contains(1)) {
            n5.c.t(parcel, 1, this.f2963b);
        }
        if (set.contains(2)) {
            n5.c.E(parcel, 2, this.f2964c, true);
        }
        if (set.contains(3)) {
            n5.c.t(parcel, 3, this.f2965d);
        }
        if (set.contains(4)) {
            n5.c.k(parcel, 4, this.f2966e, true);
        }
        if (set.contains(5)) {
            n5.c.C(parcel, 5, this.f2967f, i10, true);
        }
        if (set.contains(6)) {
            n5.c.C(parcel, 6, this.f2968g, i10, true);
        }
        n5.c.b(parcel, iA);
    }
}
