package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Q;
import androidx.lifecycle.AbstractC1157i;
import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.fragment.app.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1125b implements Parcelable {
    public static final Parcelable.Creator<C1125b> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f11750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f11751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f11752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f11753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f11754e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f11755f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f11756g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f11757h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CharSequence f11758i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f11759j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CharSequence f11760k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f11761l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f11762m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f11763n;

    /* JADX INFO: renamed from: androidx.fragment.app.b$a */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C1125b createFromParcel(Parcel parcel) {
            return new C1125b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C1125b[] newArray(int i8) {
            return new C1125b[i8];
        }
    }

    public C1125b(Parcel parcel) {
        this.f11750a = parcel.createIntArray();
        this.f11751b = parcel.createStringArrayList();
        this.f11752c = parcel.createIntArray();
        this.f11753d = parcel.createIntArray();
        this.f11754e = parcel.readInt();
        this.f11755f = parcel.readString();
        this.f11756g = parcel.readInt();
        this.f11757h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f11758i = (CharSequence) creator.createFromParcel(parcel);
        this.f11759j = parcel.readInt();
        this.f11760k = (CharSequence) creator.createFromParcel(parcel);
        this.f11761l = parcel.createStringArrayList();
        this.f11762m = parcel.createStringArrayList();
        this.f11763n = parcel.readInt() != 0;
    }

    public final void a(C1124a c1124a) {
        int i8 = 0;
        int i9 = 0;
        while (true) {
            boolean z7 = true;
            if (i8 >= this.f11750a.length) {
                c1124a.f11655h = this.f11754e;
                c1124a.f11658k = this.f11755f;
                c1124a.f11656i = true;
                c1124a.f11659l = this.f11757h;
                c1124a.f11660m = this.f11758i;
                c1124a.f11661n = this.f11759j;
                c1124a.f11662o = this.f11760k;
                c1124a.f11663p = this.f11761l;
                c1124a.f11664q = this.f11762m;
                c1124a.f11665r = this.f11763n;
                return;
            }
            Q.a aVar = new Q.a();
            int i10 = i8 + 1;
            aVar.f11667a = this.f11750a[i8];
            if (I.J0(2)) {
                Log.v("FragmentManager", "Instantiate " + c1124a + " op #" + i9 + " base fragment #" + this.f11750a[i10]);
            }
            aVar.f11674h = AbstractC1157i.b.values()[this.f11752c[i9]];
            aVar.f11675i = AbstractC1157i.b.values()[this.f11753d[i9]];
            int[] iArr = this.f11750a;
            int i11 = i8 + 2;
            if (iArr[i10] == 0) {
                z7 = false;
            }
            aVar.f11669c = z7;
            int i12 = iArr[i11];
            aVar.f11670d = i12;
            int i13 = iArr[i8 + 3];
            aVar.f11671e = i13;
            int i14 = i8 + 5;
            int i15 = iArr[i8 + 4];
            aVar.f11672f = i15;
            i8 += 6;
            int i16 = iArr[i14];
            aVar.f11673g = i16;
            c1124a.f11651d = i12;
            c1124a.f11652e = i13;
            c1124a.f11653f = i15;
            c1124a.f11654g = i16;
            c1124a.e(aVar);
            i9++;
        }
    }

    public C1124a b(I i8) {
        C1124a c1124a = new C1124a(i8);
        a(c1124a);
        c1124a.f11748v = this.f11756g;
        for (int i9 = 0; i9 < this.f11751b.size(); i9++) {
            String str = (String) this.f11751b.get(i9);
            if (str != null) {
                ((Q.a) c1124a.f11650c.get(i9)).f11668b = i8.g0(str);
            }
        }
        c1124a.n(1);
        return c1124a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeIntArray(this.f11750a);
        parcel.writeStringList(this.f11751b);
        parcel.writeIntArray(this.f11752c);
        parcel.writeIntArray(this.f11753d);
        parcel.writeInt(this.f11754e);
        parcel.writeString(this.f11755f);
        parcel.writeInt(this.f11756g);
        parcel.writeInt(this.f11757h);
        TextUtils.writeToParcel(this.f11758i, parcel, 0);
        parcel.writeInt(this.f11759j);
        TextUtils.writeToParcel(this.f11760k, parcel, 0);
        parcel.writeStringList(this.f11761l);
        parcel.writeStringList(this.f11762m);
        parcel.writeInt(this.f11763n ? 1 : 0);
    }

    public C1125b(C1124a c1124a) {
        int size = c1124a.f11650c.size();
        this.f11750a = new int[size * 6];
        if (!c1124a.f11656i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f11751b = new ArrayList(size);
        this.f11752c = new int[size];
        this.f11753d = new int[size];
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            Q.a aVar = (Q.a) c1124a.f11650c.get(i9);
            int i10 = i8 + 1;
            this.f11750a[i8] = aVar.f11667a;
            ArrayList arrayList = this.f11751b;
            AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p = aVar.f11668b;
            arrayList.add(abstractComponentCallbacksC1139p != null ? abstractComponentCallbacksC1139p.mWho : null);
            int[] iArr = this.f11750a;
            iArr[i10] = aVar.f11669c ? 1 : 0;
            iArr[i8 + 2] = aVar.f11670d;
            iArr[i8 + 3] = aVar.f11671e;
            int i11 = i8 + 5;
            iArr[i8 + 4] = aVar.f11672f;
            i8 += 6;
            iArr[i11] = aVar.f11673g;
            this.f11752c[i9] = aVar.f11674h.ordinal();
            this.f11753d[i9] = aVar.f11675i.ordinal();
        }
        this.f11754e = c1124a.f11655h;
        this.f11755f = c1124a.f11658k;
        this.f11756g = c1124a.f11748v;
        this.f11757h = c1124a.f11659l;
        this.f11758i = c1124a.f11660m;
        this.f11759j = c1124a.f11661n;
        this.f11760k = c1124a.f11662o;
        this.f11761l = c1124a.f11663p;
        this.f11762m = c1124a.f11664q;
        this.f11763n = c1124a.f11665r;
    }
}
