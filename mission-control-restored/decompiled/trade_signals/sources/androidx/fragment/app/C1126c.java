package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: renamed from: androidx.fragment.app.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1126c implements Parcelable {
    public static final Parcelable.Creator<C1126c> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f11765b;

    /* JADX INFO: renamed from: androidx.fragment.app.c$a */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C1126c createFromParcel(Parcel parcel) {
            return new C1126c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C1126c[] newArray(int i8) {
            return new C1126c[i8];
        }
    }

    public C1126c(Parcel parcel) {
        this.f11764a = parcel.createStringArrayList();
        this.f11765b = parcel.createTypedArrayList(C1125b.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeStringList(this.f11764a);
        parcel.writeTypedList(this.f11765b);
    }
}
