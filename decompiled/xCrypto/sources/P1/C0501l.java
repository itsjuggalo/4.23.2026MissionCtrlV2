package P1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: P1.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0501l extends A1.a {
    public static final Parcelable.Creator<C0501l> CREATOR = new K();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f3432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public I f3435d;

    public C0501l(List list, boolean z4, boolean z5, I i4) {
        this.f3432a = list;
        this.f3433b = z4;
        this.f3434c = z5;
        this.f3435d = i4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.I(parcel, 1, Collections.unmodifiableList(this.f3432a), false);
        A1.c.g(parcel, 2, this.f3433b);
        A1.c.g(parcel, 3, this.f3434c);
        A1.c.C(parcel, 5, this.f3435d, i4, false);
        A1.c.b(parcel, iA);
    }
}
