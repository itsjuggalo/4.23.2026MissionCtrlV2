package E0;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import w.C2882a;

/* JADX INFO: loaded from: classes.dex */
public class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseIntArray f880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Parcel f881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f883g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f884h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f885i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f886j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f887k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new C2882a(), new C2882a(), new C2882a());
    }

    @Override // E0.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f881e.writeInt(-1);
        } else {
            this.f881e.writeInt(bArr.length);
            this.f881e.writeByteArray(bArr);
        }
    }

    @Override // E0.a
    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f881e, 0);
    }

    @Override // E0.a
    public void E(int i8) {
        this.f881e.writeInt(i8);
    }

    @Override // E0.a
    public void G(Parcelable parcelable) {
        this.f881e.writeParcelable(parcelable, 0);
    }

    @Override // E0.a
    public void I(String str) {
        this.f881e.writeString(str);
    }

    @Override // E0.a
    public void a() {
        int i8 = this.f885i;
        if (i8 >= 0) {
            int i9 = this.f880d.get(i8);
            int iDataPosition = this.f881e.dataPosition();
            this.f881e.setDataPosition(i9);
            this.f881e.writeInt(iDataPosition - i9);
            this.f881e.setDataPosition(iDataPosition);
        }
    }

    @Override // E0.a
    public a b() {
        Parcel parcel = this.f881e;
        int iDataPosition = parcel.dataPosition();
        int i8 = this.f886j;
        if (i8 == this.f882f) {
            i8 = this.f883g;
        }
        return new b(parcel, iDataPosition, i8, this.f884h + "  ", this.f877a, this.f878b, this.f879c);
    }

    @Override // E0.a
    public boolean g() {
        return this.f881e.readInt() != 0;
    }

    @Override // E0.a
    public byte[] i() {
        int i8 = this.f881e.readInt();
        if (i8 < 0) {
            return null;
        }
        byte[] bArr = new byte[i8];
        this.f881e.readByteArray(bArr);
        return bArr;
    }

    @Override // E0.a
    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f881e);
    }

    @Override // E0.a
    public boolean m(int i8) {
        while (this.f886j < this.f883g) {
            int i9 = this.f887k;
            if (i9 == i8) {
                return true;
            }
            if (String.valueOf(i9).compareTo(String.valueOf(i8)) > 0) {
                return false;
            }
            this.f881e.setDataPosition(this.f886j);
            int i10 = this.f881e.readInt();
            this.f887k = this.f881e.readInt();
            this.f886j += i10;
        }
        return this.f887k == i8;
    }

    @Override // E0.a
    public int o() {
        return this.f881e.readInt();
    }

    @Override // E0.a
    public Parcelable q() {
        return this.f881e.readParcelable(getClass().getClassLoader());
    }

    @Override // E0.a
    public String s() {
        return this.f881e.readString();
    }

    @Override // E0.a
    public void w(int i8) {
        a();
        this.f885i = i8;
        this.f880d.put(i8, this.f881e.dataPosition());
        E(0);
        E(i8);
    }

    @Override // E0.a
    public void y(boolean z7) {
        this.f881e.writeInt(z7 ? 1 : 0);
    }

    public b(Parcel parcel, int i8, int i9, String str, C2882a c2882a, C2882a c2882a2, C2882a c2882a3) {
        super(c2882a, c2882a2, c2882a3);
        this.f880d = new SparseIntArray();
        this.f885i = -1;
        this.f887k = -1;
        this.f881e = parcel;
        this.f882f = i8;
        this.f883g = i9;
        this.f886j = i8;
        this.f884h = str;
    }
}
