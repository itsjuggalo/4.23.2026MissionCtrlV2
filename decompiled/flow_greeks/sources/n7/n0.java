package n7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 extends n5.a {
    public static final Parcelable.Creator<n0> CREATOR = new q0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f16822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f16823b;

    public n0(List list, List list2) {
        this.f16822a = list == null ? new ArrayList() : list;
        this.f16823b = list2 == null ? new ArrayList() : list2;
    }

    public static n0 R(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m7.j0 j0Var = (m7.j0) it.next();
            if (j0Var instanceof m7.r0) {
                arrayList.add((m7.r0) j0Var);
            } else if (j0Var instanceof m7.x0) {
                arrayList2.add((m7.x0) j0Var);
            }
        }
        return new n0(arrayList, arrayList2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.I(parcel, 1, this.f16822a, false);
        n5.c.I(parcel, 2, this.f16823b, false);
        n5.c.b(parcel, iA);
    }

    public final List zza() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f16822a.iterator();
        while (it.hasNext()) {
            arrayList.add((m7.r0) it.next());
        }
        Iterator it2 = this.f16823b.iterator();
        while (it2.hasNext()) {
            arrayList.add((m7.x0) it2.next());
        }
        return arrayList;
    }
}
