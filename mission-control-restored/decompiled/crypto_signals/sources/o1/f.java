package o1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.I;
import com.google.android.gms.common.internal.Q;
import java.util.Arrays;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
public final class f extends AbstractC1255a {
    public static final Parcelable.Creator<f> CREATOR = new Q(29);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f8644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f8645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f8647d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f8648f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f8649k;

    public f(e eVar, b bVar, String str, boolean z6, int i, d dVar, c cVar) {
        I.g(eVar);
        this.f8644a = eVar;
        I.g(bVar);
        this.f8645b = bVar;
        this.f8646c = str;
        this.f8647d = z6;
        this.e = i;
        this.f8648f = dVar == null ? new d(false, null, null) : dVar;
        this.f8649k = cVar == null ? new c(null, false) : cVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return I.j(this.f8644a, fVar.f8644a) && I.j(this.f8645b, fVar.f8645b) && I.j(this.f8648f, fVar.f8648f) && I.j(this.f8649k, fVar.f8649k) && I.j(this.f8646c, fVar.f8646c) && this.f8647d == fVar.f8647d && this.e == fVar.e;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8644a, this.f8645b, this.f8648f, this.f8649k, this.f8646c, Boolean.valueOf(this.f8647d)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.S(parcel, 1, this.f8644a, i, false);
        u0.S(parcel, 2, this.f8645b, i, false);
        u0.T(parcel, 3, this.f8646c, false);
        u0.b0(parcel, 4, 4);
        parcel.writeInt(this.f8647d ? 1 : 0);
        u0.b0(parcel, 5, 4);
        parcel.writeInt(this.e);
        u0.S(parcel, 6, this.f8648f, i, false);
        u0.S(parcel, 7, this.f8649k, i, false);
        u0.a0(iX, parcel);
    }
}
