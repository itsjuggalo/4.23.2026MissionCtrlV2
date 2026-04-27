package T1;

import U1.a;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class b extends Q1.a {
    public static final Parcelable.Creator<b> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f4720b;

    public b(int i7, a aVar) {
        this.f4719a = i7;
        this.f4720b = aVar;
    }

    public static b A(a.b bVar) {
        if (bVar instanceof a) {
            return new b((a) bVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public final a.b B() {
        a aVar = this.f4720b;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int i8 = this.f4719a;
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, i8);
        Q1.c.C(parcel, 2, this.f4720b, i7, false);
        Q1.c.b(parcel, iA);
    }

    public b(a aVar) {
        this.f4719a = 1;
        this.f4720b = aVar;
    }
}
