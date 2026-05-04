package q5;

import android.os.Parcel;
import android.os.Parcelable;
import r5.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends n5.a {
    public static final Parcelable.Creator<b> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f18789b;

    public b(int i10, a aVar) {
        this.f18788a = i10;
        this.f18789b = aVar;
    }

    public static b R(a.b bVar) {
        if (bVar instanceof a) {
            return new b((a) bVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public final a.b S() {
        a aVar = this.f18789b;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f18788a;
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, i11);
        n5.c.C(parcel, 2, this.f18789b, i10, false);
        n5.c.b(parcel, iA);
    }

    public b(a aVar) {
        this.f18788a = 1;
        this.f18789b = aVar;
    }
}
