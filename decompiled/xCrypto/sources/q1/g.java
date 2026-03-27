package q1;

import E1.a;
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
    public static final HashMap f14185g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f14186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f14188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f14189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f14190e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f14191f;

    static {
        HashMap map = new HashMap();
        f14185g = map;
        map.put("authenticatorInfo", a.C0016a.k("authenticatorInfo", 2, i.class));
        map.put("signature", a.C0016a.n("signature", 3));
        map.put("package", a.C0016a.n("package", 4));
    }

    public g(Set set, int i4, i iVar, String str, String str2, String str3) {
        this.f14186a = set;
        this.f14187b = i4;
        this.f14188c = iVar;
        this.f14189d = str;
        this.f14190e = str2;
        this.f14191f = str3;
    }

    @Override // E1.a
    public final void addConcreteTypeInternal(a.C0016a c0016a, String str, E1.a aVar) {
        int iP = c0016a.p();
        if (iP != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(iP), aVar.getClass().getCanonicalName()));
        }
        this.f14188c = (i) aVar;
        this.f14186a.add(Integer.valueOf(iP));
    }

    @Override // E1.a
    public final /* synthetic */ Map getFieldMappings() {
        return f14185g;
    }

    @Override // E1.a
    public final Object getFieldValue(a.C0016a c0016a) {
        int iP = c0016a.p();
        if (iP == 1) {
            return Integer.valueOf(this.f14187b);
        }
        if (iP == 2) {
            return this.f14188c;
        }
        if (iP == 3) {
            return this.f14189d;
        }
        if (iP == 4) {
            return this.f14190e;
        }
        throw new IllegalStateException("Unknown SafeParcelable id=" + c0016a.p());
    }

    @Override // E1.a
    public final boolean isFieldSet(a.C0016a c0016a) {
        return this.f14186a.contains(Integer.valueOf(c0016a.p()));
    }

    @Override // E1.a
    public final void setStringInternal(a.C0016a c0016a, String str, String str2) {
        int iP = c0016a.p();
        if (iP == 3) {
            this.f14189d = str2;
        } else {
            if (iP != 4) {
                throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(iP)));
            }
            this.f14190e = str2;
        }
        this.f14186a.add(Integer.valueOf(iP));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        Set set = this.f14186a;
        if (set.contains(1)) {
            A1.c.t(parcel, 1, this.f14187b);
        }
        if (set.contains(2)) {
            A1.c.C(parcel, 2, this.f14188c, i4, true);
        }
        if (set.contains(3)) {
            A1.c.E(parcel, 3, this.f14189d, true);
        }
        if (set.contains(4)) {
            A1.c.E(parcel, 4, this.f14190e, true);
        }
        if (set.contains(5)) {
            A1.c.E(parcel, 5, this.f14191f, true);
        }
        A1.c.b(parcel, iA);
    }
}
