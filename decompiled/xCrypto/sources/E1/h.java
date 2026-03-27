package E1;

import E1.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class h extends A1.a {
    public static final Parcelable.Creator<h> CREATOR = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f407c;

    public h(int i4, ArrayList arrayList, String str) {
        this.f405a = i4;
        HashMap map = new HashMap();
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            f fVar = (f) arrayList.get(i5);
            String str2 = fVar.f400b;
            HashMap map2 = new HashMap();
            int size2 = ((ArrayList) AbstractC0940s.k(fVar.f401c)).size();
            for (int i6 = 0; i6 < size2; i6++) {
                g gVar = (g) fVar.f401c.get(i6);
                map2.put(gVar.f403b, gVar.f404c);
            }
            map.put(str2, map2);
        }
        this.f406b = map;
        this.f407c = (String) AbstractC0940s.k(str);
        l();
    }

    public final String i() {
        return this.f407c;
    }

    public final Map k(String str) {
        return (Map) this.f406b.get(str);
    }

    public final void l() {
        Iterator it = this.f406b.keySet().iterator();
        while (it.hasNext()) {
            Map map = (Map) this.f406b.get((String) it.next());
            Iterator it2 = map.keySet().iterator();
            while (it2.hasNext()) {
                ((a.C0016a) map.get((String) it2.next())).w(this);
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.f406b.keySet()) {
            sb.append(str);
            sb.append(":\n");
            Map map = (Map) this.f406b.get(str);
            for (String str2 : map.keySet()) {
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(map.get(str2));
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, this.f405a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f406b.keySet()) {
            arrayList.add(new f(str, (Map) this.f406b.get(str)));
        }
        A1.c.I(parcel, 2, arrayList, false);
        A1.c.E(parcel, 3, this.f407c, false);
        A1.c.b(parcel, iA);
    }
}
