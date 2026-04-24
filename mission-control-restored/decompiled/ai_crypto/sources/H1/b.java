package H1;

import U1.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.auth.zzbz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class b extends zzbz {
    public static final Parcelable.Creator<b> CREATOR = new c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HashMap f2557f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f2558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f2560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f2562e;

    static {
        HashMap map = new HashMap();
        f2557f = map;
        map.put("authenticatorData", a.C0083a.C("authenticatorData", 2, g.class));
        map.put("progress", a.C0083a.B("progress", 4, e.class));
    }

    public b(Set set, int i7, ArrayList arrayList, int i8, e eVar) {
        this.f2558a = set;
        this.f2559b = i7;
        this.f2560c = arrayList;
        this.f2561d = i8;
        this.f2562e = eVar;
    }

    @Override // U1.a
    public final void addConcreteTypeArrayInternal(a.C0083a c0083a, String str, ArrayList arrayList) {
        int iG = c0083a.G();
        if (iG != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known ConcreteTypeArray type. Found %s", Integer.valueOf(iG), arrayList.getClass().getCanonicalName()));
        }
        this.f2560c = arrayList;
        this.f2558a.add(Integer.valueOf(iG));
    }

    @Override // U1.a
    public final void addConcreteTypeInternal(a.C0083a c0083a, String str, U1.a aVar) {
        int iG = c0083a.G();
        if (iG != 4) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(iG), aVar.getClass().getCanonicalName()));
        }
        this.f2562e = (e) aVar;
        this.f2558a.add(Integer.valueOf(iG));
    }

    @Override // U1.a
    public final /* synthetic */ Map getFieldMappings() {
        return f2557f;
    }

    @Override // U1.a
    public final Object getFieldValue(a.C0083a c0083a) {
        int iG = c0083a.G();
        if (iG == 1) {
            return Integer.valueOf(this.f2559b);
        }
        if (iG == 2) {
            return this.f2560c;
        }
        if (iG == 4) {
            return this.f2562e;
        }
        throw new IllegalStateException("Unknown SafeParcelable id=" + c0083a.G());
    }

    @Override // U1.a
    public final boolean isFieldSet(a.C0083a c0083a) {
        return this.f2558a.contains(Integer.valueOf(c0083a.G()));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Set set = this.f2558a;
        if (set.contains(1)) {
            Q1.c.t(parcel, 1, this.f2559b);
        }
        if (set.contains(2)) {
            Q1.c.I(parcel, 2, this.f2560c, true);
        }
        if (set.contains(3)) {
            Q1.c.t(parcel, 3, this.f2561d);
        }
        if (set.contains(4)) {
            Q1.c.C(parcel, 4, this.f2562e, i7, true);
        }
        Q1.c.b(parcel, iA);
    }
}
