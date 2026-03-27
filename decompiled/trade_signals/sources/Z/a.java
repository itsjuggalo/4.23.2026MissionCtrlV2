package Z;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Parcelable f9705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9704b = new C0157a();
    public static final Parcelable.Creator<a> CREATOR = new b();

    /* JADX INFO: renamed from: Z.a$a, reason: collision with other inner class name */
    public class C0157a extends a {
        public C0157a() {
            super((C0157a) null);
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
                return a.f9704b;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i8) {
            return new a[i8];
        }
    }

    public a() {
        this.f9705a = null;
    }

    public final Parcelable a() {
        return this.f9705a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeParcelable(this.f9705a, i8);
    }

    public /* synthetic */ a(C0157a c0157a) {
        this();
    }

    public a(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f9705a = parcelable == null ? f9704b : parcelable;
    }

    public a(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.f9705a = parcelable == f9704b ? null : parcelable;
    }
}
