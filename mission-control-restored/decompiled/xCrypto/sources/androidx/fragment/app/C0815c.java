package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: renamed from: androidx.fragment.app.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0815c implements Parcelable {
    public static final Parcelable.Creator<C0815c> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f7468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f7469b;

    /* JADX INFO: renamed from: androidx.fragment.app.c$a */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0815c createFromParcel(Parcel parcel) {
            return new C0815c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0815c[] newArray(int i4) {
            return new C0815c[i4];
        }
    }

    public C0815c(Parcel parcel) {
        this.f7468a = parcel.createStringArrayList();
        this.f7469b = parcel.createTypedArrayList(C0814b.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeStringList(this.f7468a);
        parcel.writeTypedList(this.f7469b);
    }
}
