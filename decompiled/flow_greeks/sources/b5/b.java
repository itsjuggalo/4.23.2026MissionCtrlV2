package b5;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.auth.zzbz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import r5.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends zzbz {
    public static final Parcelable.Creator<b> CREATOR = new c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HashMap f2941f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f2942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f2944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f2946e;

    static {
        HashMap map = new HashMap();
        f2941f = map;
        map.put("authenticatorData", a.C0336a.T("authenticatorData", 2, g.class));
        map.put("progress", a.C0336a.S("progress", 4, e.class));
    }

    public b(Set set, int i10, ArrayList arrayList, int i11, e eVar) {
        this.f2942a = set;
        this.f2943b = i10;
        this.f2944c = arrayList;
        this.f2945d = i11;
        this.f2946e = eVar;
    }

    @Override // r5.a
    public final void addConcreteTypeArrayInternal(a.C0336a c0336a, String str, ArrayList arrayList) {
        int iX = c0336a.X();
        if (iX != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known ConcreteTypeArray type. Found %s", Integer.valueOf(iX), arrayList.getClass().getCanonicalName()));
        }
        this.f2944c = arrayList;
        this.f2942a.add(Integer.valueOf(iX));
    }

    @Override // r5.a
    public final void addConcreteTypeInternal(a.C0336a c0336a, String str, r5.a aVar) {
        int iX = c0336a.X();
        if (iX != 4) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(iX), aVar.getClass().getCanonicalName()));
        }
        this.f2946e = (e) aVar;
        this.f2942a.add(Integer.valueOf(iX));
    }

    @Override // r5.a
    public final /* synthetic */ Map getFieldMappings() {
        return f2941f;
    }

    @Override // r5.a
    public final Object getFieldValue(a.C0336a c0336a) {
        int iX = c0336a.X();
        if (iX == 1) {
            return Integer.valueOf(this.f2943b);
        }
        if (iX == 2) {
            return this.f2944c;
        }
        if (iX == 4) {
            return this.f2946e;
        }
        throw new IllegalStateException("Unknown SafeParcelable id=" + c0336a.X());
    }

    @Override // r5.a
    public final boolean isFieldSet(a.C0336a c0336a) {
        return this.f2942a.contains(Integer.valueOf(c0336a.X()));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        Set set = this.f2942a;
        if (set.contains(1)) {
            n5.c.t(parcel, 1, this.f2943b);
        }
        if (set.contains(2)) {
            n5.c.I(parcel, 2, this.f2944c, true);
        }
        if (set.contains(3)) {
            n5.c.t(parcel, 3, this.f2945d);
        }
        if (set.contains(4)) {
            n5.c.C(parcel, 4, this.f2946e, i10, true);
        }
        n5.c.b(parcel, iA);
    }
}
