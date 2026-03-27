package q1;

import E1.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.auth.zzbz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: q1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1720b extends zzbz {
    public static final Parcelable.Creator<C1720b> CREATOR = new C1721c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HashMap f14172f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f14173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f14175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f14177e;

    static {
        HashMap map = new HashMap();
        f14172f = map;
        map.put("authenticatorData", a.C0016a.l("authenticatorData", 2, g.class));
        map.put("progress", a.C0016a.k("progress", 4, e.class));
    }

    public C1720b(Set set, int i4, ArrayList arrayList, int i5, e eVar) {
        this.f14173a = set;
        this.f14174b = i4;
        this.f14175c = arrayList;
        this.f14176d = i5;
        this.f14177e = eVar;
    }

    @Override // E1.a
    public final void addConcreteTypeArrayInternal(a.C0016a c0016a, String str, ArrayList arrayList) {
        int iP = c0016a.p();
        if (iP != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known ConcreteTypeArray type. Found %s", Integer.valueOf(iP), arrayList.getClass().getCanonicalName()));
        }
        this.f14175c = arrayList;
        this.f14173a.add(Integer.valueOf(iP));
    }

    @Override // E1.a
    public final void addConcreteTypeInternal(a.C0016a c0016a, String str, E1.a aVar) {
        int iP = c0016a.p();
        if (iP != 4) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(iP), aVar.getClass().getCanonicalName()));
        }
        this.f14177e = (e) aVar;
        this.f14173a.add(Integer.valueOf(iP));
    }

    @Override // E1.a
    public final /* synthetic */ Map getFieldMappings() {
        return f14172f;
    }

    @Override // E1.a
    public final Object getFieldValue(a.C0016a c0016a) {
        int iP = c0016a.p();
        if (iP == 1) {
            return Integer.valueOf(this.f14174b);
        }
        if (iP == 2) {
            return this.f14175c;
        }
        if (iP == 4) {
            return this.f14177e;
        }
        throw new IllegalStateException("Unknown SafeParcelable id=" + c0016a.p());
    }

    @Override // E1.a
    public final boolean isFieldSet(a.C0016a c0016a) {
        return this.f14173a.contains(Integer.valueOf(c0016a.p()));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        Set set = this.f14173a;
        if (set.contains(1)) {
            A1.c.t(parcel, 1, this.f14174b);
        }
        if (set.contains(2)) {
            A1.c.I(parcel, 2, this.f14175c, true);
        }
        if (set.contains(3)) {
            A1.c.t(parcel, 3, this.f14176d);
        }
        if (set.contains(4)) {
            A1.c.C(parcel, 4, this.f14177e, i4, true);
        }
        A1.c.b(parcel, iA);
    }
}
