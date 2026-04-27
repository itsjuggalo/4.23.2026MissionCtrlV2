package D1;

import E1.a;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class b extends A1.a {
    public static final Parcelable.Creator<b> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f318b;

    public b(int i4, a aVar) {
        this.f317a = i4;
        this.f318b = aVar;
    }

    public static b i(a.b bVar) {
        if (bVar instanceof a) {
            return new b((a) bVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public final a.b k() {
        a aVar = this.f318b;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int i5 = this.f317a;
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, i5);
        A1.c.C(parcel, 2, this.f318b, i4, false);
        A1.c.b(parcel, iA);
    }

    public b(a aVar) {
        this.f317a = 1;
        this.f318b = aVar;
    }
}
