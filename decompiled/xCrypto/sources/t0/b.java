package t0;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import u.C1853a;

/* JADX INFO: loaded from: classes.dex */
public class b extends AbstractC1782a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseIntArray f14719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Parcel f14720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f14721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f14722g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f14723h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14724i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14725j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14726k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new C1853a(), new C1853a(), new C1853a());
    }

    @Override // t0.AbstractC1782a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f14720e.writeInt(-1);
        } else {
            this.f14720e.writeInt(bArr.length);
            this.f14720e.writeByteArray(bArr);
        }
    }

    @Override // t0.AbstractC1782a
    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f14720e, 0);
    }

    @Override // t0.AbstractC1782a
    public void E(int i4) {
        this.f14720e.writeInt(i4);
    }

    @Override // t0.AbstractC1782a
    public void G(Parcelable parcelable) {
        this.f14720e.writeParcelable(parcelable, 0);
    }

    @Override // t0.AbstractC1782a
    public void I(String str) {
        this.f14720e.writeString(str);
    }

    @Override // t0.AbstractC1782a
    public void a() {
        int i4 = this.f14724i;
        if (i4 >= 0) {
            int i5 = this.f14719d.get(i4);
            int iDataPosition = this.f14720e.dataPosition();
            this.f14720e.setDataPosition(i5);
            this.f14720e.writeInt(iDataPosition - i5);
            this.f14720e.setDataPosition(iDataPosition);
        }
    }

    @Override // t0.AbstractC1782a
    public AbstractC1782a b() {
        Parcel parcel = this.f14720e;
        int iDataPosition = parcel.dataPosition();
        int i4 = this.f14725j;
        if (i4 == this.f14721f) {
            i4 = this.f14722g;
        }
        return new b(parcel, iDataPosition, i4, this.f14723h + "  ", this.f14716a, this.f14717b, this.f14718c);
    }

    @Override // t0.AbstractC1782a
    public boolean g() {
        return this.f14720e.readInt() != 0;
    }

    @Override // t0.AbstractC1782a
    public byte[] i() {
        int i4 = this.f14720e.readInt();
        if (i4 < 0) {
            return null;
        }
        byte[] bArr = new byte[i4];
        this.f14720e.readByteArray(bArr);
        return bArr;
    }

    @Override // t0.AbstractC1782a
    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f14720e);
    }

    @Override // t0.AbstractC1782a
    public boolean m(int i4) {
        while (this.f14725j < this.f14722g) {
            int i5 = this.f14726k;
            if (i5 == i4) {
                return true;
            }
            if (String.valueOf(i5).compareTo(String.valueOf(i4)) > 0) {
                return false;
            }
            this.f14720e.setDataPosition(this.f14725j);
            int i6 = this.f14720e.readInt();
            this.f14726k = this.f14720e.readInt();
            this.f14725j += i6;
        }
        return this.f14726k == i4;
    }

    @Override // t0.AbstractC1782a
    public int o() {
        return this.f14720e.readInt();
    }

    @Override // t0.AbstractC1782a
    public Parcelable q() {
        return this.f14720e.readParcelable(getClass().getClassLoader());
    }

    @Override // t0.AbstractC1782a
    public String s() {
        return this.f14720e.readString();
    }

    @Override // t0.AbstractC1782a
    public void w(int i4) {
        a();
        this.f14724i = i4;
        this.f14719d.put(i4, this.f14720e.dataPosition());
        E(0);
        E(i4);
    }

    @Override // t0.AbstractC1782a
    public void y(boolean z4) {
        this.f14720e.writeInt(z4 ? 1 : 0);
    }

    public b(Parcel parcel, int i4, int i5, String str, C1853a c1853a, C1853a c1853a2, C1853a c1853a3) {
        super(c1853a, c1853a2, c1853a3);
        this.f14719d = new SparseIntArray();
        this.f14724i = -1;
        this.f14726k = -1;
        this.f14720e = parcel;
        this.f14721f = i4;
        this.f14722g = i5;
        this.f14725j = i4;
        this.f14723h = str;
    }
}
