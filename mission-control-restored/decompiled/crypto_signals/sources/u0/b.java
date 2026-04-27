package u0;

import android.os.Parcel;
import android.util.SparseIntArray;
import q.C0910b;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public final class b extends AbstractC1198a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseIntArray f10265d;
    public final Parcel e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f10266f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f10267g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f10268h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f10269j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10270k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new C0910b(), new C0910b(), new C0910b());
    }

    @Override // u0.AbstractC1198a
    public final b a() {
        Parcel parcel = this.e;
        int iDataPosition = parcel.dataPosition();
        int i = this.f10269j;
        if (i == this.f10266f) {
            i = this.f10267g;
        }
        return new b(parcel, iDataPosition, i, AbstractC1024h.d(new StringBuilder(), this.f10268h, "  "), this.f10262a, this.f10263b, this.f10264c);
    }

    @Override // u0.AbstractC1198a
    public final boolean e(int i) {
        while (this.f10269j < this.f10267g) {
            int i6 = this.f10270k;
            if (i6 == i) {
                return true;
            }
            if (String.valueOf(i6).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            int i7 = this.f10269j;
            Parcel parcel = this.e;
            parcel.setDataPosition(i7);
            int i8 = parcel.readInt();
            this.f10270k = parcel.readInt();
            this.f10269j += i8;
        }
        return this.f10270k == i;
    }

    @Override // u0.AbstractC1198a
    public final void i(int i) {
        int i6 = this.i;
        SparseIntArray sparseIntArray = this.f10265d;
        Parcel parcel = this.e;
        if (i6 >= 0) {
            int i7 = sparseIntArray.get(i6);
            int iDataPosition = parcel.dataPosition();
            parcel.setDataPosition(i7);
            parcel.writeInt(iDataPosition - i7);
            parcel.setDataPosition(iDataPosition);
        }
        this.i = i;
        sparseIntArray.put(i, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i);
    }

    public b(Parcel parcel, int i, int i6, String str, C0910b c0910b, C0910b c0910b2, C0910b c0910b3) {
        super(c0910b, c0910b2, c0910b3);
        this.f10265d = new SparseIntArray();
        this.i = -1;
        this.f10270k = -1;
        this.e = parcel;
        this.f10266f = i;
        this.f10267g = i6;
        this.f10269j = i;
        this.f10268h = str;
    }
}
