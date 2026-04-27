package e;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: e.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1656a implements Parcelable {
    public static final Parcelable.Creator<C1656a> CREATOR = new C0288a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f17090b;

    /* JADX INFO: renamed from: e.a$a, reason: collision with other inner class name */
    public class C0288a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C1656a createFromParcel(Parcel parcel) {
            return new C1656a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C1656a[] newArray(int i8) {
            return new C1656a[i8];
        }
    }

    public C1656a(int i8, Intent intent) {
        this.f17089a = i8;
        this.f17090b = intent;
    }

    public static String c(int i8) {
        return i8 != -1 ? i8 != 0 ? String.valueOf(i8) : "RESULT_CANCELED" : "RESULT_OK";
    }

    public Intent a() {
        return this.f17090b;
    }

    public int b() {
        return this.f17089a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + c(this.f17089a) + ", data=" + this.f17090b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.f17089a);
        parcel.writeInt(this.f17090b == null ? 0 : 1);
        Intent intent = this.f17090b;
        if (intent != null) {
            intent.writeToParcel(parcel, i8);
        }
    }

    public C1656a(Parcel parcel) {
        this.f17089a = parcel.readInt();
        this.f17090b = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
