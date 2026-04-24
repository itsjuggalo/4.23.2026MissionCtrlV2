package D1;

import E1.a;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a extends A1.a implements a.b {
    public static final Parcelable.Creator<a> CREATOR = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f315b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray f316c = new SparseArray();

    public a(int i4, ArrayList arrayList) {
        this.f314a = i4;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            d dVar = (d) arrayList.get(i5);
            i(dVar.f320b, dVar.f321c);
        }
    }

    @Override // E1.a.b
    public final /* bridge */ /* synthetic */ Object c(Object obj) {
        String str = (String) this.f316c.get(((Integer) obj).intValue());
        return (str == null && this.f315b.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    @Override // E1.a.b
    public final /* bridge */ /* synthetic */ Object f(Object obj) {
        Integer num = (Integer) this.f315b.get((String) obj);
        return num == null ? (Integer) this.f315b.get("gms_unknown") : num;
    }

    public a i(String str, int i4) {
        this.f315b.put(str, Integer.valueOf(i4));
        this.f316c.put(i4, str);
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int i5 = this.f314a;
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, i5);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f315b.keySet()) {
            arrayList.add(new d(str, ((Integer) this.f315b.get(str)).intValue()));
        }
        A1.c.I(parcel, 2, arrayList, false);
        A1.c.b(parcel, iA);
    }
}
