package e;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: e.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1219a implements Parcelable {
    public static final Parcelable.Creator<C1219a> CREATOR = new C0186a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f11439b;

    /* JADX INFO: renamed from: e.a$a, reason: collision with other inner class name */
    public class C0186a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C1219a createFromParcel(Parcel parcel) {
            return new C1219a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C1219a[] newArray(int i4) {
            return new C1219a[i4];
        }
    }

    public C1219a(int i4, Intent intent) {
        this.f11438a = i4;
        this.f11439b = intent;
    }

    public static String c(int i4) {
        return i4 != -1 ? i4 != 0 ? String.valueOf(i4) : "RESULT_CANCELED" : "RESULT_OK";
    }

    public Intent a() {
        return this.f11439b;
    }

    public int b() {
        return this.f11438a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + c(this.f11438a) + ", data=" + this.f11439b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f11438a);
        parcel.writeInt(this.f11439b == null ? 0 : 1);
        Intent intent = this.f11439b;
        if (intent != null) {
            intent.writeToParcel(parcel, i4);
        }
    }

    public C1219a(Parcel parcel) {
        this.f11438a = parcel.readInt();
        this.f11439b = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
