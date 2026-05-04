package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.q0;
import androidx.lifecycle.i;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f2029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f2030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f2031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f2032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2033e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f2034f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2035g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f2036h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CharSequence f2037i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f2038j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CharSequence f2039k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f2040l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f2041m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f2042n;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i10) {
            return new b[i10];
        }
    }

    public b(androidx.fragment.app.a aVar) {
        int size = aVar.f2270c.size();
        this.f2029a = new int[size * 6];
        if (!aVar.f2276i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f2030b = new ArrayList(size);
        this.f2031c = new int[size];
        this.f2032d = new int[size];
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            q0.a aVar2 = (q0.a) aVar.f2270c.get(i11);
            int i12 = i10 + 1;
            this.f2029a[i10] = aVar2.f2287a;
            ArrayList arrayList = this.f2030b;
            p pVar = aVar2.f2288b;
            arrayList.add(pVar != null ? pVar.mWho : null);
            int[] iArr = this.f2029a;
            iArr[i12] = aVar2.f2289c ? 1 : 0;
            iArr[i10 + 2] = aVar2.f2290d;
            iArr[i10 + 3] = aVar2.f2291e;
            int i13 = i10 + 5;
            iArr[i10 + 4] = aVar2.f2292f;
            i10 += 6;
            iArr[i13] = aVar2.f2293g;
            this.f2031c[i11] = aVar2.f2294h.ordinal();
            this.f2032d[i11] = aVar2.f2295i.ordinal();
        }
        this.f2033e = aVar.f2275h;
        this.f2034f = aVar.f2278k;
        this.f2035g = aVar.f2022v;
        this.f2036h = aVar.f2279l;
        this.f2037i = aVar.f2280m;
        this.f2038j = aVar.f2281n;
        this.f2039k = aVar.f2282o;
        this.f2040l = aVar.f2283p;
        this.f2041m = aVar.f2284q;
        this.f2042n = aVar.f2285r;
    }

    public final void a(androidx.fragment.app.a aVar) {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            boolean z10 = true;
            if (i10 >= this.f2029a.length) {
                aVar.f2275h = this.f2033e;
                aVar.f2278k = this.f2034f;
                aVar.f2276i = true;
                aVar.f2279l = this.f2036h;
                aVar.f2280m = this.f2037i;
                aVar.f2281n = this.f2038j;
                aVar.f2282o = this.f2039k;
                aVar.f2283p = this.f2040l;
                aVar.f2284q = this.f2041m;
                aVar.f2285r = this.f2042n;
                return;
            }
            q0.a aVar2 = new q0.a();
            int i12 = i10 + 1;
            aVar2.f2287a = this.f2029a[i10];
            if (i0.J0(2)) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i11 + " base fragment #" + this.f2029a[i12]);
            }
            aVar2.f2294h = i.b.values()[this.f2031c[i11]];
            aVar2.f2295i = i.b.values()[this.f2032d[i11]];
            int[] iArr = this.f2029a;
            int i13 = i10 + 2;
            if (iArr[i12] == 0) {
                z10 = false;
            }
            aVar2.f2289c = z10;
            int i14 = iArr[i13];
            aVar2.f2290d = i14;
            int i15 = iArr[i10 + 3];
            aVar2.f2291e = i15;
            int i16 = i10 + 5;
            int i17 = iArr[i10 + 4];
            aVar2.f2292f = i17;
            i10 += 6;
            int i18 = iArr[i16];
            aVar2.f2293g = i18;
            aVar.f2271d = i14;
            aVar.f2272e = i15;
            aVar.f2273f = i17;
            aVar.f2274g = i18;
            aVar.e(aVar2);
            i11++;
        }
    }

    public androidx.fragment.app.a b(i0 i0Var) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(i0Var);
        a(aVar);
        aVar.f2022v = this.f2035g;
        for (int i10 = 0; i10 < this.f2030b.size(); i10++) {
            String str = (String) this.f2030b.get(i10);
            if (str != null) {
                ((q0.a) aVar.f2270c.get(i10)).f2288b = i0Var.g0(str);
            }
        }
        aVar.n(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeIntArray(this.f2029a);
        parcel.writeStringList(this.f2030b);
        parcel.writeIntArray(this.f2031c);
        parcel.writeIntArray(this.f2032d);
        parcel.writeInt(this.f2033e);
        parcel.writeString(this.f2034f);
        parcel.writeInt(this.f2035g);
        parcel.writeInt(this.f2036h);
        TextUtils.writeToParcel(this.f2037i, parcel, 0);
        parcel.writeInt(this.f2038j);
        TextUtils.writeToParcel(this.f2039k, parcel, 0);
        parcel.writeStringList(this.f2040l);
        parcel.writeStringList(this.f2041m);
        parcel.writeInt(this.f2042n ? 1 : 0);
    }

    public b(Parcel parcel) {
        this.f2029a = parcel.createIntArray();
        this.f2030b = parcel.createStringArrayList();
        this.f2031c = parcel.createIntArray();
        this.f2032d = parcel.createIntArray();
        this.f2033e = parcel.readInt();
        this.f2034f = parcel.readString();
        this.f2035g = parcel.readInt();
        this.f2036h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f2037i = (CharSequence) creator.createFromParcel(parcel);
        this.f2038j = parcel.readInt();
        this.f2039k = (CharSequence) creator.createFromParcel(parcel);
        this.f2040l = parcel.createStringArrayList();
        this.f2041m = parcel.createStringArrayList();
        this.f2042n = parcel.readInt() != 0;
    }
}
