package n7;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i2 implements m7.i {
    public static final Parcelable.Creator<i2> CREATOR = new h2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f16800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g2 f16801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m7.z1 f16802c;

    public i2(i iVar) {
        i iVar2 = (i) com.google.android.gms.common.internal.s.k(iVar);
        this.f16800a = iVar2;
        List listA0 = iVar2.A0();
        this.f16801b = null;
        for (int i10 = 0; i10 < listA0.size(); i10++) {
            if (!TextUtils.isEmpty(((e) listA0.get(i10)).zza())) {
                this.f16801b = new g2(((e) listA0.get(i10)).c(), ((e) listA0.get(i10)).zza(), iVar.B0());
            }
        }
        if (this.f16801b == null) {
            this.f16801b = new g2(iVar.B0());
        }
        this.f16802c = iVar.y0();
    }

    @Override // m7.i
    public final m7.h A() {
        return this.f16802c;
    }

    @Override // m7.i
    public final m7.a0 G() {
        return this.f16800a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.C(parcel, 1, G(), i10, false);
        n5.c.C(parcel, 2, y(), i10, false);
        n5.c.C(parcel, 3, this.f16802c, i10, false);
        n5.c.b(parcel, iA);
    }

    @Override // m7.i
    public final m7.g y() {
        return this.f16801b;
    }

    public i2(i iVar, g2 g2Var, m7.z1 z1Var) {
        this.f16800a = iVar;
        this.f16801b = g2Var;
        this.f16802c = z1Var;
    }
}
