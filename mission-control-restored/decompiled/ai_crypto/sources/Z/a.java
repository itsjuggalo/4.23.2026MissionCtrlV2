package Z;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Parcelable f5681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5680b = new C0102a();
    public static final Parcelable.Creator<a> CREATOR = new b();

    /* JADX INFO: renamed from: Z.a$a, reason: collision with other inner class name */
    public class C0102a extends a {
        public C0102a() {
            super((C0102a) null);
        }
    }

    public class b implements Parcelable.ClassLoaderCreator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return a.f5680b;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i7) {
            return new a[i7];
        }
    }

    public /* synthetic */ a(C0102a c0102a) {
        this();
    }

    public final Parcelable a() {
        return this.f5681a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeParcelable(this.f5681a, i7);
    }

    public a() {
        this.f5681a = null;
    }

    public a(Parcelable parcelable) {
        if (parcelable != null) {
            this.f5681a = parcelable == f5680b ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public a(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f5681a = parcelable == null ? f5680b : parcelable;
    }
}
