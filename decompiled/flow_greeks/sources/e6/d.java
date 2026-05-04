package e6;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d extends n5.a {
    public static final Parcelable.Creator<d> CREATOR = new w0();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Comparator f8404e = new v0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f8405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f8407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f8408d;

    public d(List list, String str, List list2, String str2) {
        com.google.android.gms.common.internal.s.l(list, "transitions can't be null");
        com.google.android.gms.common.internal.s.b(list.size() > 0, "transitions can't be empty.");
        com.google.android.gms.common.internal.s.k(list);
        TreeSet treeSet = new TreeSet(f8404e);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            com.google.android.gms.common.internal.s.b(treeSet.add(cVar), String.format("Found duplicated transition: %s.", cVar));
        }
        this.f8405a = Collections.unmodifiableList(list);
        this.f8406b = str;
        this.f8407c = list2 == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list2);
        this.f8408d = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            d dVar = (d) obj;
            if (com.google.android.gms.common.internal.q.b(this.f8405a, dVar.f8405a) && com.google.android.gms.common.internal.q.b(this.f8406b, dVar.f8406b) && com.google.android.gms.common.internal.q.b(this.f8408d, dVar.f8408d) && com.google.android.gms.common.internal.q.b(this.f8407c, dVar.f8407c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.f8405a.hashCode() * 31;
        String str = this.f8406b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        List list = this.f8407c;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.f8408d;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String strValueOf = String.valueOf(this.f8405a);
        String str = this.f8406b;
        String strValueOf2 = String.valueOf(this.f8407c);
        String str2 = this.f8408d;
        int length = strValueOf.length();
        int length2 = String.valueOf(str).length();
        StringBuilder sb2 = new StringBuilder(length + 79 + length2 + strValueOf2.length() + String.valueOf(str2).length());
        sb2.append("ActivityTransitionRequest [mTransitions=");
        sb2.append(strValueOf);
        sb2.append(", mTag='");
        sb2.append(str);
        sb2.append("', mClients=");
        sb2.append(strValueOf2);
        sb2.append(", mAttributionTag=");
        sb2.append(str2);
        sb2.append(']');
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        com.google.android.gms.common.internal.s.k(parcel);
        int iA = n5.c.a(parcel);
        n5.c.I(parcel, 1, this.f8405a, false);
        n5.c.E(parcel, 2, this.f8406b, false);
        n5.c.I(parcel, 3, this.f8407c, false);
        n5.c.E(parcel, 4, this.f8408d, false);
        n5.c.b(parcel, iA);
    }
}
