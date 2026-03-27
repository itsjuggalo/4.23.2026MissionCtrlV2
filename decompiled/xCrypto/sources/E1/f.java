package E1;

import E1.a;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class f extends A1.a {
    public static final Parcelable.Creator<f> CREATOR = new j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f401c;

    public f(int i4, String str, ArrayList arrayList) {
        this.f399a = i4;
        this.f400b = str;
        this.f401c = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int i5 = this.f399a;
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, i5);
        A1.c.E(parcel, 2, this.f400b, false);
        A1.c.I(parcel, 3, this.f401c, false);
        A1.c.b(parcel, iA);
    }

    public f(String str, Map map) {
        ArrayList arrayList;
        this.f399a = 1;
        this.f400b = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (String str2 : map.keySet()) {
                arrayList.add(new g(str2, (a.C0016a) map.get(str2)));
            }
        }
        this.f401c = arrayList;
    }
}
