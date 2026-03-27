package f2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: renamed from: f2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1578d extends Q1.a {
    public static final Parcelable.Creator<C1578d> CREATOR = new C1572X();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Comparator f14079e = new C1571W();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f14080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f14082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f14083d;

    public C1578d(List list, String str, List list2, String str2) {
        AbstractC1207s.l(list, "transitions can't be null");
        AbstractC1207s.b(list.size() > 0, "transitions can't be empty.");
        AbstractC1207s.k(list);
        TreeSet treeSet = new TreeSet(f14079e);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1577c c1577c = (C1577c) it.next();
            AbstractC1207s.b(treeSet.add(c1577c), String.format("Found duplicated transition: %s.", c1577c));
        }
        this.f14080a = Collections.unmodifiableList(list);
        this.f14081b = str;
        this.f14082c = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.f14083d = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C1578d c1578d = (C1578d) obj;
            if (AbstractC1206q.b(this.f14080a, c1578d.f14080a) && AbstractC1206q.b(this.f14081b, c1578d.f14081b) && AbstractC1206q.b(this.f14083d, c1578d.f14083d) && AbstractC1206q.b(this.f14082c, c1578d.f14082c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.f14080a.hashCode() * 31;
        String str = this.f14081b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        List list = this.f14082c;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.f14083d;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String strValueOf = String.valueOf(this.f14080a);
        String str = this.f14081b;
        String strValueOf2 = String.valueOf(this.f14082c);
        String str2 = this.f14083d;
        int length = strValueOf.length();
        int length2 = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 79 + length2 + strValueOf2.length() + String.valueOf(str2).length());
        sb.append("ActivityTransitionRequest [mTransitions=");
        sb.append(strValueOf);
        sb.append(", mTag='");
        sb.append(str);
        sb.append("', mClients=");
        sb.append(strValueOf2);
        sb.append(", mAttributionTag=");
        sb.append(str2);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        AbstractC1207s.k(parcel);
        int iA = Q1.c.a(parcel);
        Q1.c.I(parcel, 1, this.f14080a, false);
        Q1.c.E(parcel, 2, this.f14081b, false);
        Q1.c.I(parcel, 3, this.f14082c, false);
        Q1.c.E(parcel, 4, this.f14083d, false);
        Q1.c.b(parcel, iA);
    }
}
