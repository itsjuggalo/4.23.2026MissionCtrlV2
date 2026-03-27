package Q;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Parcelable f3539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3538b = new C0057a();
    public static final Parcelable.Creator<a> CREATOR = new b();

    /* JADX INFO: renamed from: Q.a$a, reason: collision with other inner class name */
    public class C0057a extends a {
        public C0057a() {
            super((C0057a) null);
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
                return a.f3538b;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i4) {
            return new a[i4];
        }
    }

    public /* synthetic */ a(C0057a c0057a) {
        this();
    }

    public final Parcelable a() {
        return this.f3539a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.f3539a, i4);
    }

    public a() {
        this.f3539a = null;
    }

    public a(Parcelable parcelable) {
        if (parcelable != null) {
            this.f3539a = parcelable == f3538b ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public a(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f3539a = parcelable == null ? f3538b : parcelable;
    }
}
