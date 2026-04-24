package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Q;
import androidx.lifecycle.AbstractC0846i;
import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.fragment.app.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0814b implements Parcelable {
    public static final Parcelable.Creator<C0814b> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f7454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f7455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f7456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f7457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f7458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f7459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f7460g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f7461h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CharSequence f7462i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f7463j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CharSequence f7464k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f7465l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f7466m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f7467n;

    /* JADX INFO: renamed from: androidx.fragment.app.b$a */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0814b createFromParcel(Parcel parcel) {
            return new C0814b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0814b[] newArray(int i4) {
            return new C0814b[i4];
        }
    }

    public C0814b(C0813a c0813a) {
        int size = c0813a.f7354c.size();
        this.f7454a = new int[size * 6];
        if (!c0813a.f7360i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f7455b = new ArrayList(size);
        this.f7456c = new int[size];
        this.f7457d = new int[size];
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Q.a aVar = (Q.a) c0813a.f7354c.get(i5);
            int i6 = i4 + 1;
            this.f7454a[i4] = aVar.f7371a;
            ArrayList arrayList = this.f7455b;
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = aVar.f7372b;
            arrayList.add(abstractComponentCallbacksC0828p != null ? abstractComponentCallbacksC0828p.mWho : null);
            int[] iArr = this.f7454a;
            iArr[i6] = aVar.f7373c ? 1 : 0;
            iArr[i4 + 2] = aVar.f7374d;
            iArr[i4 + 3] = aVar.f7375e;
            int i7 = i4 + 5;
            iArr[i4 + 4] = aVar.f7376f;
            i4 += 6;
            iArr[i7] = aVar.f7377g;
            this.f7456c[i5] = aVar.f7378h.ordinal();
            this.f7457d[i5] = aVar.f7379i.ordinal();
        }
        this.f7458e = c0813a.f7359h;
        this.f7459f = c0813a.f7362k;
        this.f7460g = c0813a.f7452v;
        this.f7461h = c0813a.f7363l;
        this.f7462i = c0813a.f7364m;
        this.f7463j = c0813a.f7365n;
        this.f7464k = c0813a.f7366o;
        this.f7465l = c0813a.f7367p;
        this.f7466m = c0813a.f7368q;
        this.f7467n = c0813a.f7369r;
    }

    public final void a(C0813a c0813a) {
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z4 = true;
            if (i4 >= this.f7454a.length) {
                c0813a.f7359h = this.f7458e;
                c0813a.f7362k = this.f7459f;
                c0813a.f7360i = true;
                c0813a.f7363l = this.f7461h;
                c0813a.f7364m = this.f7462i;
                c0813a.f7365n = this.f7463j;
                c0813a.f7366o = this.f7464k;
                c0813a.f7367p = this.f7465l;
                c0813a.f7368q = this.f7466m;
                c0813a.f7369r = this.f7467n;
                return;
            }
            Q.a aVar = new Q.a();
            int i6 = i4 + 1;
            aVar.f7371a = this.f7454a[i4];
            if (I.J0(2)) {
                Log.v("FragmentManager", "Instantiate " + c0813a + " op #" + i5 + " base fragment #" + this.f7454a[i6]);
            }
            aVar.f7378h = AbstractC0846i.b.values()[this.f7456c[i5]];
            aVar.f7379i = AbstractC0846i.b.values()[this.f7457d[i5]];
            int[] iArr = this.f7454a;
            int i7 = i4 + 2;
            if (iArr[i6] == 0) {
                z4 = false;
            }
            aVar.f7373c = z4;
            int i8 = iArr[i7];
            aVar.f7374d = i8;
            int i9 = iArr[i4 + 3];
            aVar.f7375e = i9;
            int i10 = i4 + 5;
            int i11 = iArr[i4 + 4];
            aVar.f7376f = i11;
            i4 += 6;
            int i12 = iArr[i10];
            aVar.f7377g = i12;
            c0813a.f7355d = i8;
            c0813a.f7356e = i9;
            c0813a.f7357f = i11;
            c0813a.f7358g = i12;
            c0813a.e(aVar);
            i5++;
        }
    }

    public C0813a b(I i4) {
        C0813a c0813a = new C0813a(i4);
        a(c0813a);
        c0813a.f7452v = this.f7460g;
        for (int i5 = 0; i5 < this.f7455b.size(); i5++) {
            String str = (String) this.f7455b.get(i5);
            if (str != null) {
                ((Q.a) c0813a.f7354c.get(i5)).f7372b = i4.g0(str);
            }
        }
        c0813a.n(1);
        return c0813a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeIntArray(this.f7454a);
        parcel.writeStringList(this.f7455b);
        parcel.writeIntArray(this.f7456c);
        parcel.writeIntArray(this.f7457d);
        parcel.writeInt(this.f7458e);
        parcel.writeString(this.f7459f);
        parcel.writeInt(this.f7460g);
        parcel.writeInt(this.f7461h);
        TextUtils.writeToParcel(this.f7462i, parcel, 0);
        parcel.writeInt(this.f7463j);
        TextUtils.writeToParcel(this.f7464k, parcel, 0);
        parcel.writeStringList(this.f7465l);
        parcel.writeStringList(this.f7466m);
        parcel.writeInt(this.f7467n ? 1 : 0);
    }

    public C0814b(Parcel parcel) {
        this.f7454a = parcel.createIntArray();
        this.f7455b = parcel.createStringArrayList();
        this.f7456c = parcel.createIntArray();
        this.f7457d = parcel.createIntArray();
        this.f7458e = parcel.readInt();
        this.f7459f = parcel.readString();
        this.f7460g = parcel.readInt();
        this.f7461h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f7462i = (CharSequence) creator.createFromParcel(parcel);
        this.f7463j = parcel.readInt();
        this.f7464k = (CharSequence) creator.createFromParcel(parcel);
        this.f7465l = parcel.createStringArrayList();
        this.f7466m = parcel.createStringArrayList();
        this.f7467n = parcel.readInt() != 0;
    }
}
