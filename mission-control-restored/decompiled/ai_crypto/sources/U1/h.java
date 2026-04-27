package U1;

import U1.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class h extends Q1.a {
    public static final Parcelable.Creator<h> CREATOR = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f4785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4786c;

    public h(int i7, ArrayList arrayList, String str) {
        this.f4784a = i7;
        HashMap map = new HashMap();
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            f fVar = (f) arrayList.get(i8);
            String str2 = fVar.f4779b;
            HashMap map2 = new HashMap();
            int size2 = ((ArrayList) AbstractC1207s.k(fVar.f4780c)).size();
            for (int i9 = 0; i9 < size2; i9++) {
                g gVar = (g) fVar.f4780c.get(i9);
                map2.put(gVar.f4782b, gVar.f4783c);
            }
            map.put(str2, map2);
        }
        this.f4785b = map;
        this.f4786c = (String) AbstractC1207s.k(str);
        C();
    }

    public final String A() {
        return this.f4786c;
    }

    public final Map B(String str) {
        return (Map) this.f4785b.get(str);
    }

    public final void C() {
        Iterator it = this.f4785b.keySet().iterator();
        while (it.hasNext()) {
            Map map = (Map) this.f4785b.get((String) it.next());
            Iterator it2 = map.keySet().iterator();
            while (it2.hasNext()) {
                ((a.C0083a) map.get((String) it2.next())).N(this);
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.f4785b.keySet()) {
            sb.append(str);
            sb.append(":\n");
            Map map = (Map) this.f4785b.get(str);
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
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, this.f4784a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f4785b.keySet()) {
            arrayList.add(new f(str, (Map) this.f4785b.get(str)));
        }
        Q1.c.I(parcel, 2, arrayList, false);
        Q1.c.E(parcel, 3, this.f4786c, false);
        Q1.c.b(parcel, iA);
    }
}
