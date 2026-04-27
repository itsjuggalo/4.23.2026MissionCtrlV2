package m0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: renamed from: m0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2203c implements Parcelable {
    public static final Parcelable.Creator<C2203c> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f18744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f18745b;

    /* JADX INFO: renamed from: m0.c$a */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C2203c createFromParcel(Parcel parcel) {
            return new C2203c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C2203c[] newArray(int i7) {
            return new C2203c[i7];
        }
    }

    public C2203c(Parcel parcel) {
        this.f18744a = parcel.createStringArrayList();
        this.f18745b = parcel.createTypedArrayList(C2202b.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeStringList(this.f18744a);
        parcel.writeTypedList(this.f18745b);
    }
}
