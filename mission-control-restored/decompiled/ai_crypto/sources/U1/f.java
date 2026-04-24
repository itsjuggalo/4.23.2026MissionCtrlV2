package U1;

import U1.a;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class f extends Q1.a {
    public static final Parcelable.Creator<f> CREATOR = new j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f4780c;

    public f(int i7, String str, ArrayList arrayList) {
        this.f4778a = i7;
        this.f4779b = str;
        this.f4780c = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int i8 = this.f4778a;
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, i8);
        Q1.c.E(parcel, 2, this.f4779b, false);
        Q1.c.I(parcel, 3, this.f4780c, false);
        Q1.c.b(parcel, iA);
    }

    public f(String str, Map map) {
        ArrayList arrayList;
        this.f4778a = 1;
        this.f4779b = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (String str2 : map.keySet()) {
                arrayList.add(new g(str2, (a.C0083a) map.get(str2)));
            }
        }
        this.f4780c = arrayList;
    }
}
