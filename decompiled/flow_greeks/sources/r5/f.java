package r5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Map;
import r5.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends n5.a {
    public static final Parcelable.Creator<f> CREATOR = new j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f19338c;

    public f(int i10, String str, ArrayList arrayList) {
        this.f19336a = i10;
        this.f19337b = str;
        this.f19338c = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f19336a;
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, i11);
        n5.c.E(parcel, 2, this.f19337b, false);
        n5.c.I(parcel, 3, this.f19338c, false);
        n5.c.b(parcel, iA);
    }

    public f(String str, Map map) {
        ArrayList arrayList;
        this.f19336a = 1;
        this.f19337b = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (String str2 : map.keySet()) {
                arrayList.add(new g(str2, (a.C0336a) map.get(str2)));
            }
        }
        this.f19338c = arrayList;
    }
}
