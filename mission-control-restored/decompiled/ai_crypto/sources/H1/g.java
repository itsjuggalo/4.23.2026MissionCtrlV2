package H1;

import U1.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.auth.zzbz;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class g extends zzbz {
    public static final Parcelable.Creator<g> CREATOR = new h();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final HashMap f2570g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f2571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f2573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f2575e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f2576f;

    static {
        HashMap map = new HashMap();
        f2570g = map;
        map.put("authenticatorInfo", a.C0083a.B("authenticatorInfo", 2, i.class));
        map.put("signature", a.C0083a.E("signature", 3));
        map.put("package", a.C0083a.E("package", 4));
    }

    public g(Set set, int i7, i iVar, String str, String str2, String str3) {
        this.f2571a = set;
        this.f2572b = i7;
        this.f2573c = iVar;
        this.f2574d = str;
        this.f2575e = str2;
        this.f2576f = str3;
    }

    @Override // U1.a
    public final void addConcreteTypeInternal(a.C0083a c0083a, String str, U1.a aVar) {
        int iG = c0083a.G();
        if (iG != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(iG), aVar.getClass().getCanonicalName()));
        }
        this.f2573c = (i) aVar;
        this.f2571a.add(Integer.valueOf(iG));
    }

    @Override // U1.a
    public final /* synthetic */ Map getFieldMappings() {
        return f2570g;
    }

    @Override // U1.a
    public final Object getFieldValue(a.C0083a c0083a) {
        int iG = c0083a.G();
        if (iG == 1) {
            return Integer.valueOf(this.f2572b);
        }
        if (iG == 2) {
            return this.f2573c;
        }
        if (iG == 3) {
            return this.f2574d;
        }
        if (iG == 4) {
            return this.f2575e;
        }
        throw new IllegalStateException("Unknown SafeParcelable id=" + c0083a.G());
    }

    @Override // U1.a
    public final boolean isFieldSet(a.C0083a c0083a) {
        return this.f2571a.contains(Integer.valueOf(c0083a.G()));
    }

    @Override // U1.a
    public final void setStringInternal(a.C0083a c0083a, String str, String str2) {
        int iG = c0083a.G();
        if (iG == 3) {
            this.f2574d = str2;
        } else {
            if (iG != 4) {
                throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(iG)));
            }
            this.f2575e = str2;
        }
        this.f2571a.add(Integer.valueOf(iG));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Set set = this.f2571a;
        if (set.contains(1)) {
            Q1.c.t(parcel, 1, this.f2572b);
        }
        if (set.contains(2)) {
            Q1.c.C(parcel, 2, this.f2573c, i7, true);
        }
        if (set.contains(3)) {
            Q1.c.E(parcel, 3, this.f2574d, true);
        }
        if (set.contains(4)) {
            Q1.c.E(parcel, 4, this.f2575e, true);
        }
        if (set.contains(5)) {
            Q1.c.E(parcel, 5, this.f2576f, true);
        }
        Q1.c.b(parcel, iA);
    }
}
