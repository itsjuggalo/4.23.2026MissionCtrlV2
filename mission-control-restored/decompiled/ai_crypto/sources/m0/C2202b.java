package m0;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.AbstractC0963i;
import java.util.ArrayList;
import m0.AbstractC2198P;

/* JADX INFO: renamed from: m0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2202b implements Parcelable {
    public static final Parcelable.Creator<C2202b> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f18730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f18731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f18732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f18733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f18734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f18735f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f18736g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f18737h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CharSequence f18738i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f18739j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CharSequence f18740k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f18741l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f18742m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f18743n;

    /* JADX INFO: renamed from: m0.b$a */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C2202b createFromParcel(Parcel parcel) {
            return new C2202b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C2202b[] newArray(int i7) {
            return new C2202b[i7];
        }
    }

    public C2202b(C2201a c2201a) {
        int size = c2201a.f18630c.size();
        this.f18730a = new int[size * 6];
        if (!c2201a.f18636i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f18731b = new ArrayList(size);
        this.f18732c = new int[size];
        this.f18733d = new int[size];
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            AbstractC2198P.a aVar = (AbstractC2198P.a) c2201a.f18630c.get(i8);
            int i9 = i7 + 1;
            this.f18730a[i7] = aVar.f18647a;
            ArrayList arrayList = this.f18731b;
            AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p = aVar.f18648b;
            arrayList.add(abstractComponentCallbacksC2216p != null ? abstractComponentCallbacksC2216p.f18869f : null);
            int[] iArr = this.f18730a;
            iArr[i9] = aVar.f18649c ? 1 : 0;
            iArr[i7 + 2] = aVar.f18650d;
            iArr[i7 + 3] = aVar.f18651e;
            int i10 = i7 + 5;
            iArr[i7 + 4] = aVar.f18652f;
            i7 += 6;
            iArr[i10] = aVar.f18653g;
            this.f18732c[i8] = aVar.f18654h.ordinal();
            this.f18733d[i8] = aVar.f18655i.ordinal();
        }
        this.f18734e = c2201a.f18635h;
        this.f18735f = c2201a.f18638k;
        this.f18736g = c2201a.f18728v;
        this.f18737h = c2201a.f18639l;
        this.f18738i = c2201a.f18640m;
        this.f18739j = c2201a.f18641n;
        this.f18740k = c2201a.f18642o;
        this.f18741l = c2201a.f18643p;
        this.f18742m = c2201a.f18644q;
        this.f18743n = c2201a.f18645r;
    }

    public final void a(C2201a c2201a) {
        int i7 = 0;
        int i8 = 0;
        while (true) {
            boolean z7 = true;
            if (i7 >= this.f18730a.length) {
                c2201a.f18635h = this.f18734e;
                c2201a.f18638k = this.f18735f;
                c2201a.f18636i = true;
                c2201a.f18639l = this.f18737h;
                c2201a.f18640m = this.f18738i;
                c2201a.f18641n = this.f18739j;
                c2201a.f18642o = this.f18740k;
                c2201a.f18643p = this.f18741l;
                c2201a.f18644q = this.f18742m;
                c2201a.f18645r = this.f18743n;
                return;
            }
            AbstractC2198P.a aVar = new AbstractC2198P.a();
            int i9 = i7 + 1;
            aVar.f18647a = this.f18730a[i7];
            if (AbstractC2190H.I0(2)) {
                Log.v("FragmentManager", "Instantiate " + c2201a + " op #" + i8 + " base fragment #" + this.f18730a[i9]);
            }
            aVar.f18654h = AbstractC0963i.b.values()[this.f18732c[i8]];
            aVar.f18655i = AbstractC0963i.b.values()[this.f18733d[i8]];
            int[] iArr = this.f18730a;
            int i10 = i7 + 2;
            if (iArr[i9] == 0) {
                z7 = false;
            }
            aVar.f18649c = z7;
            int i11 = iArr[i10];
            aVar.f18650d = i11;
            int i12 = iArr[i7 + 3];
            aVar.f18651e = i12;
            int i13 = i7 + 5;
            int i14 = iArr[i7 + 4];
            aVar.f18652f = i14;
            i7 += 6;
            int i15 = iArr[i13];
            aVar.f18653g = i15;
            c2201a.f18631d = i11;
            c2201a.f18632e = i12;
            c2201a.f18633f = i14;
            c2201a.f18634g = i15;
            c2201a.e(aVar);
            i8++;
        }
    }

    public C2201a c(AbstractC2190H abstractC2190H) {
        C2201a c2201a = new C2201a(abstractC2190H);
        a(c2201a);
        c2201a.f18728v = this.f18736g;
        for (int i7 = 0; i7 < this.f18731b.size(); i7++) {
            String str = (String) this.f18731b.get(i7);
            if (str != null) {
                ((AbstractC2198P.a) c2201a.f18630c.get(i7)).f18648b = abstractC2190H.f0(str);
            }
        }
        c2201a.p(1);
        return c2201a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeIntArray(this.f18730a);
        parcel.writeStringList(this.f18731b);
        parcel.writeIntArray(this.f18732c);
        parcel.writeIntArray(this.f18733d);
        parcel.writeInt(this.f18734e);
        parcel.writeString(this.f18735f);
        parcel.writeInt(this.f18736g);
        parcel.writeInt(this.f18737h);
        TextUtils.writeToParcel(this.f18738i, parcel, 0);
        parcel.writeInt(this.f18739j);
        TextUtils.writeToParcel(this.f18740k, parcel, 0);
        parcel.writeStringList(this.f18741l);
        parcel.writeStringList(this.f18742m);
        parcel.writeInt(this.f18743n ? 1 : 0);
    }

    public C2202b(Parcel parcel) {
        this.f18730a = parcel.createIntArray();
        this.f18731b = parcel.createStringArrayList();
        this.f18732c = parcel.createIntArray();
        this.f18733d = parcel.createIntArray();
        this.f18734e = parcel.readInt();
        this.f18735f = parcel.readString();
        this.f18736g = parcel.readInt();
        this.f18737h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f18738i = (CharSequence) creator.createFromParcel(parcel);
        this.f18739j = parcel.readInt();
        this.f18740k = (CharSequence) creator.createFromParcel(parcel);
        this.f18741l = parcel.createStringArrayList();
        this.f18742m = parcel.createStringArrayList();
        this.f18743n = parcel.readInt() != 0;
    }
}
