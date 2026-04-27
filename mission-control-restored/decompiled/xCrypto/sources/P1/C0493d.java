package P1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: renamed from: P1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0493d extends A1.a {
    public static final Parcelable.Creator<C0493d> CREATOR = new X();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Comparator f3414e = new W();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f3415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f3417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3418d;

    public C0493d(List list, String str, List list2, String str2) {
        AbstractC0940s.l(list, "transitions can't be null");
        AbstractC0940s.b(list.size() > 0, "transitions can't be empty.");
        AbstractC0940s.k(list);
        TreeSet treeSet = new TreeSet(f3414e);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0492c c0492c = (C0492c) it.next();
            AbstractC0940s.b(treeSet.add(c0492c), String.format("Found duplicated transition: %s.", c0492c));
        }
        this.f3415a = Collections.unmodifiableList(list);
        this.f3416b = str;
        this.f3417c = list2 == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list2);
        this.f3418d = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C0493d c0493d = (C0493d) obj;
            if (AbstractC0939q.b(this.f3415a, c0493d.f3415a) && AbstractC0939q.b(this.f3416b, c0493d.f3416b) && AbstractC0939q.b(this.f3418d, c0493d.f3418d) && AbstractC0939q.b(this.f3417c, c0493d.f3417c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.f3415a.hashCode() * 31;
        String str = this.f3416b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        List list = this.f3417c;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.f3418d;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String strValueOf = String.valueOf(this.f3415a);
        String str = this.f3416b;
        String strValueOf2 = String.valueOf(this.f3417c);
        String str2 = this.f3418d;
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
    public void writeToParcel(Parcel parcel, int i4) {
        AbstractC0940s.k(parcel);
        int iA = A1.c.a(parcel);
        A1.c.I(parcel, 1, this.f3415a, false);
        A1.c.E(parcel, 2, this.f3416b, false);
        A1.c.I(parcel, 3, this.f3417c, false);
        A1.c.E(parcel, 4, this.f3418d, false);
        A1.c.b(parcel, iA);
    }
}
