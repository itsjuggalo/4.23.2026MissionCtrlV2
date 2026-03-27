package V1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class h extends A1.a implements com.google.android.gms.common.api.k {
    public static final Parcelable.Creator<h> CREATOR = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f5312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5313b;

    public h(List list, String str) {
        this.f5312a = list;
        this.f5313b = str;
    }

    @Override // com.google.android.gms.common.api.k
    public final Status getStatus() {
        return this.f5313b != null ? Status.f9653f : Status.f9657j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        List list = this.f5312a;
        int iA = A1.c.a(parcel);
        A1.c.G(parcel, 1, list, false);
        A1.c.E(parcel, 2, this.f5313b, false);
        A1.c.b(parcel, iA);
    }
}
