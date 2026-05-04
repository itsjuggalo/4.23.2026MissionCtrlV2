package r5;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import r5.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends n5.a {
    public static final Parcelable.Creator<h> CREATOR = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f19343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19344c;

    public h(int i10, ArrayList arrayList, String str) {
        this.f19342a = i10;
        HashMap map = new HashMap();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            f fVar = (f) arrayList.get(i11);
            String str2 = fVar.f19337b;
            HashMap map2 = new HashMap();
            int size2 = ((ArrayList) s.k(fVar.f19338c)).size();
            for (int i12 = 0; i12 < size2; i12++) {
                g gVar = (g) fVar.f19338c.get(i12);
                map2.put(gVar.f19340b, gVar.f19341c);
            }
            map.put(str2, map2);
        }
        this.f19343b = map;
        this.f19344c = (String) s.k(str);
        R();
    }

    public final void R() {
        HashMap map = this.f19343b;
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Map map2 = (Map) map.get((String) it.next());
            Iterator it2 = map2.keySet().iterator();
            while (it2.hasNext()) {
                ((a.C0336a) map2.get((String) it2.next())).a0(this);
            }
        }
    }

    public final Map S(String str) {
        return (Map) this.f19343b.get(str);
    }

    public final String T() {
        return this.f19344c;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        HashMap map = this.f19343b;
        for (String str : map.keySet()) {
            sb2.append(str);
            sb2.append(":\n");
            Map map2 = (Map) map.get(str);
            for (String str2 : map2.keySet()) {
                sb2.append("  ");
                sb2.append(str2);
                sb2.append(": ");
                sb2.append(map2.get(str2));
            }
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, this.f19342a);
        ArrayList arrayList = new ArrayList();
        HashMap map = this.f19343b;
        for (String str : map.keySet()) {
            arrayList.add(new f(str, (Map) map.get(str)));
        }
        n5.c.I(parcel, 2, arrayList, false);
        n5.c.E(parcel, 3, this.f19344c, false);
        n5.c.b(parcel, iA);
    }
}
