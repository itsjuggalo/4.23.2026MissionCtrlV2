package D4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0011a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f1484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f1485c;

    /* JADX INFO: renamed from: D4.a$a, reason: collision with other inner class name */
    public class C0011a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i7) {
            return new a[i7];
        }
    }

    public a(String str, float f7, float f8) {
        this.f1483a = str;
        this.f1484b = f7;
        this.f1485c = f8;
    }

    public String a() {
        return this.f1483a;
    }

    public float c() {
        return this.f1484b;
    }

    public float d() {
        return this.f1485c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeString(this.f1483a);
        parcel.writeFloat(this.f1484b);
        parcel.writeFloat(this.f1485c);
    }

    public a(Parcel parcel) {
        this.f1483a = parcel.readString();
        this.f1484b = parcel.readFloat();
        this.f1485c = parcel.readFloat();
    }
}
