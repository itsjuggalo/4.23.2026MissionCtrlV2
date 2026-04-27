package N2;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: N2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0156e extends AbstractC0163l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f1994c;

    public C0156e(int i, List list) {
        this.f1992a = new ArrayList(list);
        this.f1993b = i;
    }

    @Override // N2.AbstractC0163l
    public final String a() {
        boolean z6;
        String str;
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = this.f1992a;
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z6 = e();
            } else if (((AbstractC0163l) it.next()) instanceof C0156e) {
                break;
            }
        }
        if (z6) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                sb.append(((AbstractC0163l) it2.next()).a());
            }
            return sb.toString();
        }
        int i = this.f1993b;
        if (i == 1) {
            str = "and";
        } else {
            if (i != 2) {
                throw null;
            }
            str = "or";
        }
        sb.append(str.concat("("));
        sb.append(TextUtils.join(",", arrayList));
        sb.append(")");
        return sb.toString();
    }

    @Override // N2.AbstractC0163l
    public final List b() {
        return Collections.unmodifiableList(this.f1992a);
    }

    @Override // N2.AbstractC0163l
    public final List c() {
        ArrayList arrayList = this.f1994c;
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        this.f1994c = new ArrayList();
        Iterator it = this.f1992a.iterator();
        while (it.hasNext()) {
            this.f1994c.addAll(((AbstractC0163l) it.next()).c());
        }
        return Collections.unmodifiableList(this.f1994c);
    }

    @Override // N2.AbstractC0163l
    public final boolean d(Q2.k kVar) {
        boolean zE = e();
        ArrayList arrayList = this.f1992a;
        if (zE) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!((AbstractC0163l) it.next()).d(kVar)) {
                    return false;
                }
            }
            return true;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (((AbstractC0163l) it2.next()).d(kVar)) {
                return true;
            }
        }
        return false;
    }

    public final boolean e() {
        return this.f1993b == 1;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C0156e)) {
            return false;
        }
        C0156e c0156e = (C0156e) obj;
        return this.f1993b == c0156e.f1993b && this.f1992a.equals(c0156e.f1992a);
    }

    public final int hashCode() {
        return this.f1992a.hashCode() + ((S.i.c(this.f1993b) + 1147) * 31);
    }

    public final String toString() {
        return a();
    }
}
