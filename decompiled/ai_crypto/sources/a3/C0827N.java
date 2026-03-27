package a3;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: a3.N, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0827N extends Q1.a {
    public static final Parcelable.Creator<C0827N> CREATOR = new C0830Q();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f6155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f6156b;

    public C0827N(List list, List list2) {
        this.f6155a = list == null ? new ArrayList() : list;
        this.f6156b = list2 == null ? new ArrayList() : list2;
    }

    public static C0827N A(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Z2.J j7 = (Z2.J) it.next();
            if (j7 instanceof Z2.S) {
                arrayList.add((Z2.S) j7);
            } else if (j7 instanceof Z2.Y) {
                arrayList2.add((Z2.Y) j7);
            }
        }
        return new C0827N(arrayList, arrayList2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.I(parcel, 1, this.f6155a, false);
        Q1.c.I(parcel, 2, this.f6156b, false);
        Q1.c.b(parcel, iA);
    }

    public final List zza() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f6155a.iterator();
        while (it.hasNext()) {
            arrayList.add((Z2.S) it.next());
        }
        Iterator it2 = this.f6156b.iterator();
        while (it2.hasNext()) {
            arrayList.add((Z2.Y) it2.next());
        }
        return arrayList;
    }
}
