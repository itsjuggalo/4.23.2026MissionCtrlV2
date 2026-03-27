package j2;

import android.os.Parcel;
import android.os.Parcelable;
import i2.C0649C;
import java.util.ArrayList;
import java.util.Iterator;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: renamed from: j2.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0733i extends AbstractC1255a {
    public static final Parcelable.Creator<C0733i> CREATOR = new C0727c(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f7702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0734j f7703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i2.I f7705d;
    public final C0730f e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f7706f;

    public C0733i(ArrayList arrayList, C0734j c0734j, String str, i2.I i, C0730f c0730f, ArrayList arrayList2) {
        com.google.android.gms.common.internal.I.g(arrayList);
        this.f7702a = arrayList;
        com.google.android.gms.common.internal.I.g(c0734j);
        this.f7703b = c0734j;
        com.google.android.gms.common.internal.I.d(str);
        this.f7704c = str;
        this.f7705d = i;
        this.e = c0730f;
        com.google.android.gms.common.internal.I.g(arrayList2);
        this.f7706f = arrayList2;
    }

    public final ArrayList m() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f7702a.iterator();
        while (it.hasNext()) {
            arrayList.add((i2.z) it.next());
        }
        Iterator it2 = this.f7706f.iterator();
        while (it2.hasNext()) {
            arrayList.add((C0649C) it2.next());
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.W(parcel, 1, this.f7702a, false);
        u0.S(parcel, 2, this.f7703b, i, false);
        u0.T(parcel, 3, this.f7704c, false);
        u0.S(parcel, 4, this.f7705d, i, false);
        u0.S(parcel, 5, this.e, i, false);
        u0.W(parcel, 6, this.f7706f, false);
        u0.a0(iX, parcel);
    }
}
