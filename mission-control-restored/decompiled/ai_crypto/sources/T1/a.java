package T1;

import U1.a;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a extends Q1.a implements a.b {
    public static final Parcelable.Creator<a> CREATOR = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f4717b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray f4718c = new SparseArray();

    public a(int i7, ArrayList arrayList) {
        this.f4716a = i7;
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            d dVar = (d) arrayList.get(i8);
            A(dVar.f4722b, dVar.f4723c);
        }
    }

    public a A(String str, int i7) {
        this.f4717b.put(str, Integer.valueOf(i7));
        this.f4718c.put(i7, str);
        return this;
    }

    @Override // U1.a.b
    public final /* bridge */ /* synthetic */ Object j(Object obj) {
        String str = (String) this.f4718c.get(((Integer) obj).intValue());
        return (str == null && this.f4717b.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    @Override // U1.a.b
    public final /* bridge */ /* synthetic */ Object m(Object obj) {
        Integer num = (Integer) this.f4717b.get((String) obj);
        return num == null ? (Integer) this.f4717b.get("gms_unknown") : num;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int i8 = this.f4716a;
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, i8);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f4717b.keySet()) {
            arrayList.add(new d(str, ((Integer) this.f4717b.get(str)).intValue()));
        }
        Q1.c.I(parcel, 2, arrayList, false);
        Q1.c.b(parcel, iA);
    }
}
