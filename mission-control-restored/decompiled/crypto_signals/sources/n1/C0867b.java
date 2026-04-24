package n1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Q;
import com.google.android.gms.internal.auth.zzbz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import t2.u0;
import z1.AbstractC1457b;
import z1.C1456a;

/* JADX INFO: renamed from: n1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0867b extends zzbz {
    public static final Parcelable.Creator<C0867b> CREATOR = new Q(22);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HashMap f8527f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f8528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f8530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8531d;
    public C0869d e;

    static {
        HashMap map = new HashMap();
        f8527f = map;
        map.put("authenticatorData", new C1456a(11, true, 11, true, "authenticatorData", 2, C0870e.class));
        map.put("progress", new C1456a(11, false, 11, false, "progress", 4, C0869d.class));
    }

    public C0867b(HashSet hashSet, int i, ArrayList arrayList, int i6, C0869d c0869d) {
        this.f8528a = hashSet;
        this.f8529b = i;
        this.f8530c = arrayList;
        this.f8531d = i6;
        this.e = c0869d;
    }

    @Override // z1.AbstractC1457b
    public final void addConcreteTypeArrayInternal(C1456a c1456a, String str, ArrayList arrayList) {
        int i = c1456a.f11737k;
        if (i != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known ConcreteTypeArray type. Found %s", Integer.valueOf(i), arrayList.getClass().getCanonicalName()));
        }
        this.f8530c = arrayList;
        this.f8528a.add(Integer.valueOf(i));
    }

    @Override // z1.AbstractC1457b
    public final void addConcreteTypeInternal(C1456a c1456a, String str, AbstractC1457b abstractC1457b) {
        int i = c1456a.f11737k;
        if (i != 4) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(i), abstractC1457b.getClass().getCanonicalName()));
        }
        this.e = (C0869d) abstractC1457b;
        this.f8528a.add(Integer.valueOf(i));
    }

    @Override // z1.AbstractC1457b
    public final /* synthetic */ Map getFieldMappings() {
        return f8527f;
    }

    @Override // z1.AbstractC1457b
    public final Object getFieldValue(C1456a c1456a) {
        int i = c1456a.f11737k;
        if (i == 1) {
            return Integer.valueOf(this.f8529b);
        }
        if (i == 2) {
            return this.f8530c;
        }
        if (i == 4) {
            return this.e;
        }
        throw new IllegalStateException("Unknown SafeParcelable id=" + c1456a.f11737k);
    }

    @Override // z1.AbstractC1457b
    public final boolean isFieldSet(C1456a c1456a) {
        return this.f8528a.contains(Integer.valueOf(c1456a.f11737k));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        HashSet hashSet = this.f8528a;
        if (hashSet.contains(1)) {
            u0.b0(parcel, 1, 4);
            parcel.writeInt(this.f8529b);
        }
        if (hashSet.contains(2)) {
            u0.W(parcel, 2, this.f8530c, true);
        }
        if (hashSet.contains(3)) {
            u0.b0(parcel, 3, 4);
            parcel.writeInt(this.f8531d);
        }
        if (hashSet.contains(4)) {
            u0.S(parcel, 4, this.e, i, true);
        }
        u0.a0(iX, parcel);
    }
}
