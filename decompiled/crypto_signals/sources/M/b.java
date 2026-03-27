package M;

import android.os.Parcel;
import android.os.Parcelable;
import m.A0;
import m.P0;
import p0.B;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.ClassLoaderCreator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1050a;

    public /* synthetic */ b(int i) {
        this.f1050a = i;
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.f1050a) {
            case 0:
                if (parcel.readParcelable(classLoader) == null) {
                    return c.f1051b;
                }
                throw new IllegalStateException("superState must be null");
            case 1:
                return new A0(parcel, classLoader);
            case 2:
                return new P0(parcel, classLoader);
            default:
                return new B(parcel, classLoader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f1050a) {
            case 0:
                return new c[i];
            case 1:
                return new A0[i];
            case 2:
                return new P0[i];
            default:
                return new B[i];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f1050a) {
            case 0:
                if (parcel.readParcelable(null) == null) {
                    return c.f1051b;
                }
                throw new IllegalStateException("superState must be null");
            case 1:
                return new A0(parcel, null);
            case 2:
                return new P0(parcel, null);
            default:
                return new B(parcel, null);
        }
    }
}
