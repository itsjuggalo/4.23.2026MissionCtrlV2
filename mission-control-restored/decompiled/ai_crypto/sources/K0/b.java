package K0;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import u.C2736a;

/* JADX INFO: loaded from: classes.dex */
public class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseIntArray f3341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Parcel f3342e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3343f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f3344g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f3345h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3346i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3347j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3348k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new C2736a(), new C2736a(), new C2736a());
    }

    @Override // K0.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f3342e.writeInt(-1);
        } else {
            this.f3342e.writeInt(bArr.length);
            this.f3342e.writeByteArray(bArr);
        }
    }

    @Override // K0.a
    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f3342e, 0);
    }

    @Override // K0.a
    public void E(int i7) {
        this.f3342e.writeInt(i7);
    }

    @Override // K0.a
    public void G(Parcelable parcelable) {
        this.f3342e.writeParcelable(parcelable, 0);
    }

    @Override // K0.a
    public void I(String str) {
        this.f3342e.writeString(str);
    }

    @Override // K0.a
    public void a() {
        int i7 = this.f3346i;
        if (i7 >= 0) {
            int i8 = this.f3341d.get(i7);
            int iDataPosition = this.f3342e.dataPosition();
            this.f3342e.setDataPosition(i8);
            this.f3342e.writeInt(iDataPosition - i8);
            this.f3342e.setDataPosition(iDataPosition);
        }
    }

    @Override // K0.a
    public a b() {
        Parcel parcel = this.f3342e;
        int iDataPosition = parcel.dataPosition();
        int i7 = this.f3347j;
        if (i7 == this.f3343f) {
            i7 = this.f3344g;
        }
        return new b(parcel, iDataPosition, i7, this.f3345h + "  ", this.f3338a, this.f3339b, this.f3340c);
    }

    @Override // K0.a
    public boolean g() {
        return this.f3342e.readInt() != 0;
    }

    @Override // K0.a
    public byte[] i() {
        int i7 = this.f3342e.readInt();
        if (i7 < 0) {
            return null;
        }
        byte[] bArr = new byte[i7];
        this.f3342e.readByteArray(bArr);
        return bArr;
    }

    @Override // K0.a
    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f3342e);
    }

    @Override // K0.a
    public boolean m(int i7) {
        while (this.f3347j < this.f3344g) {
            int i8 = this.f3348k;
            if (i8 == i7) {
                return true;
            }
            if (String.valueOf(i8).compareTo(String.valueOf(i7)) > 0) {
                return false;
            }
            this.f3342e.setDataPosition(this.f3347j);
            int i9 = this.f3342e.readInt();
            this.f3348k = this.f3342e.readInt();
            this.f3347j += i9;
        }
        return this.f3348k == i7;
    }

    @Override // K0.a
    public int o() {
        return this.f3342e.readInt();
    }

    @Override // K0.a
    public Parcelable q() {
        return this.f3342e.readParcelable(getClass().getClassLoader());
    }

    @Override // K0.a
    public String s() {
        return this.f3342e.readString();
    }

    @Override // K0.a
    public void w(int i7) {
        a();
        this.f3346i = i7;
        this.f3341d.put(i7, this.f3342e.dataPosition());
        E(0);
        E(i7);
    }

    @Override // K0.a
    public void y(boolean z7) {
        this.f3342e.writeInt(z7 ? 1 : 0);
    }

    public b(Parcel parcel, int i7, int i8, String str, C2736a c2736a, C2736a c2736a2, C2736a c2736a3) {
        super(c2736a, c2736a2, c2736a3);
        this.f3341d = new SparseIntArray();
        this.f3346i = -1;
        this.f3348k = -1;
        this.f3342e = parcel;
        this.f3343f = i7;
        this.f3344g = i8;
        this.f3347j = i7;
        this.f3345h = str;
    }
}
