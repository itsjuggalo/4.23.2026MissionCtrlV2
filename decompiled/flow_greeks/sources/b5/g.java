package b5;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.auth.zzbz;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import r5.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends zzbz {
    public static final Parcelable.Creator<g> CREATOR = new h();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final HashMap f2954g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f2955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f2957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f2959e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f2960f;

    static {
        HashMap map = new HashMap();
        f2954g = map;
        map.put("authenticatorInfo", a.C0336a.S("authenticatorInfo", 2, i.class));
        map.put("signature", a.C0336a.V("signature", 3));
        map.put("package", a.C0336a.V("package", 4));
    }

    public g(Set set, int i10, i iVar, String str, String str2, String str3) {
        this.f2955a = set;
        this.f2956b = i10;
        this.f2957c = iVar;
        this.f2958d = str;
        this.f2959e = str2;
        this.f2960f = str3;
    }

    @Override // r5.a
    public final void addConcreteTypeInternal(a.C0336a c0336a, String str, r5.a aVar) {
        int iX = c0336a.X();
        if (iX != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(iX), aVar.getClass().getCanonicalName()));
        }
        this.f2957c = (i) aVar;
        this.f2955a.add(Integer.valueOf(iX));
    }

    @Override // r5.a
    public final /* synthetic */ Map getFieldMappings() {
        return f2954g;
    }

    @Override // r5.a
    public final Object getFieldValue(a.C0336a c0336a) {
        int iX = c0336a.X();
        if (iX == 1) {
            return Integer.valueOf(this.f2956b);
        }
        if (iX == 2) {
            return this.f2957c;
        }
        if (iX == 3) {
            return this.f2958d;
        }
        if (iX == 4) {
            return this.f2959e;
        }
        throw new IllegalStateException("Unknown SafeParcelable id=" + c0336a.X());
    }

    @Override // r5.a
    public final boolean isFieldSet(a.C0336a c0336a) {
        return this.f2955a.contains(Integer.valueOf(c0336a.X()));
    }

    @Override // r5.a
    public final void setStringInternal(a.C0336a c0336a, String str, String str2) {
        int iX = c0336a.X();
        if (iX == 3) {
            this.f2958d = str2;
        } else {
            if (iX != 4) {
                throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(iX)));
            }
            this.f2959e = str2;
        }
        this.f2955a.add(Integer.valueOf(iX));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        Set set = this.f2955a;
        if (set.contains(1)) {
            n5.c.t(parcel, 1, this.f2956b);
        }
        if (set.contains(2)) {
            n5.c.C(parcel, 2, this.f2957c, i10, true);
        }
        if (set.contains(3)) {
            n5.c.E(parcel, 3, this.f2958d, true);
        }
        if (set.contains(4)) {
            n5.c.E(parcel, 4, this.f2959e, true);
        }
        if (set.contains(5)) {
            n5.c.E(parcel, 5, this.f2960f, true);
        }
        n5.c.b(parcel, iA);
    }
}
