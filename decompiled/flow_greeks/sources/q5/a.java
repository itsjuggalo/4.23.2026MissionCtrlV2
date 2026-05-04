package q5;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashMap;
import r5.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends n5.a implements a.b {
    public static final Parcelable.Creator<a> CREATOR = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f18786b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray f18787c = new SparseArray();

    public a(int i10, ArrayList arrayList) {
        this.f18785a = i10;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            d dVar = (d) arrayList.get(i11);
            R(dVar.f18791b, dVar.f18792c);
        }
    }

    public a R(String str, int i10) {
        this.f18786b.put(str, Integer.valueOf(i10));
        this.f18787c.put(i10, str);
        return this;
    }

    @Override // r5.a.b
    public final /* bridge */ /* synthetic */ Object g(Object obj) {
        HashMap map = this.f18786b;
        Integer num = (Integer) map.get((String) obj);
        return num == null ? (Integer) map.get("gms_unknown") : num;
    }

    @Override // r5.a.b
    public final /* bridge */ /* synthetic */ Object r(Object obj) {
        String str = (String) this.f18787c.get(((Integer) obj).intValue());
        return (str == null && this.f18786b.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f18785a;
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, i11);
        ArrayList arrayList = new ArrayList();
        HashMap map = this.f18786b;
        for (String str : map.keySet()) {
            arrayList.add(new d(str, ((Integer) map.get(str)).intValue()));
        }
        n5.c.I(parcel, 2, arrayList, false);
        n5.c.b(parcel, iA);
    }
}
