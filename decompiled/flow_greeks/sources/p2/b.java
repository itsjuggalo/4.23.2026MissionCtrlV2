package p2;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseIntArray f18194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Parcel f18195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f18196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f18197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f18198h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f18199i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f18200j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f18201k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new w.a(), new w.a(), new w.a());
    }

    @Override // p2.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f18195e.writeInt(-1);
        } else {
            this.f18195e.writeInt(bArr.length);
            this.f18195e.writeByteArray(bArr);
        }
    }

    @Override // p2.a
    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f18195e, 0);
    }

    @Override // p2.a
    public void E(int i10) {
        this.f18195e.writeInt(i10);
    }

    @Override // p2.a
    public void G(Parcelable parcelable) {
        this.f18195e.writeParcelable(parcelable, 0);
    }

    @Override // p2.a
    public void I(String str) {
        this.f18195e.writeString(str);
    }

    @Override // p2.a
    public void a() {
        int i10 = this.f18199i;
        if (i10 >= 0) {
            int i11 = this.f18194d.get(i10);
            int iDataPosition = this.f18195e.dataPosition();
            this.f18195e.setDataPosition(i11);
            this.f18195e.writeInt(iDataPosition - i11);
            this.f18195e.setDataPosition(iDataPosition);
        }
    }

    @Override // p2.a
    public a b() {
        Parcel parcel = this.f18195e;
        int iDataPosition = parcel.dataPosition();
        int i10 = this.f18200j;
        if (i10 == this.f18196f) {
            i10 = this.f18197g;
        }
        return new b(parcel, iDataPosition, i10, this.f18198h + "  ", this.f18191a, this.f18192b, this.f18193c);
    }

    @Override // p2.a
    public boolean g() {
        return this.f18195e.readInt() != 0;
    }

    @Override // p2.a
    public byte[] i() {
        int i10 = this.f18195e.readInt();
        if (i10 < 0) {
            return null;
        }
        byte[] bArr = new byte[i10];
        this.f18195e.readByteArray(bArr);
        return bArr;
    }

    @Override // p2.a
    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f18195e);
    }

    @Override // p2.a
    public boolean m(int i10) {
        while (this.f18200j < this.f18197g) {
            int i11 = this.f18201k;
            if (i11 == i10) {
                return true;
            }
            if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                return false;
            }
            this.f18195e.setDataPosition(this.f18200j);
            int i12 = this.f18195e.readInt();
            this.f18201k = this.f18195e.readInt();
            this.f18200j += i12;
        }
        return this.f18201k == i10;
    }

    @Override // p2.a
    public int o() {
        return this.f18195e.readInt();
    }

    @Override // p2.a
    public Parcelable q() {
        return this.f18195e.readParcelable(getClass().getClassLoader());
    }

    @Override // p2.a
    public String s() {
        return this.f18195e.readString();
    }

    @Override // p2.a
    public void w(int i10) {
        a();
        this.f18199i = i10;
        this.f18194d.put(i10, this.f18195e.dataPosition());
        E(0);
        E(i10);
    }

    @Override // p2.a
    public void y(boolean z10) {
        this.f18195e.writeInt(z10 ? 1 : 0);
    }

    public b(Parcel parcel, int i10, int i11, String str, w.a aVar, w.a aVar2, w.a aVar3) {
        super(aVar, aVar2, aVar3);
        this.f18194d = new SparseIntArray();
        this.f18199i = -1;
        this.f18201k = -1;
        this.f18195e = parcel;
        this.f18196f = i10;
        this.f18197g = i11;
        this.f18200j = i10;
        this.f18198h = str;
    }
}
