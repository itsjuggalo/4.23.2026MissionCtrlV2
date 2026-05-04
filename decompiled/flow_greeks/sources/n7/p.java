package n7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends m7.l0 {
    public static final Parcelable.Creator<p> CREATOR = new s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f16836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f16837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f16838e;

    public p() {
    }

    public static p S(String str, i iVar) {
        com.google.android.gms.common.internal.s.e(str);
        p pVar = new p();
        pVar.f16834a = str;
        pVar.f16838e = iVar;
        return pVar;
    }

    public static p T(List list, String str) {
        com.google.android.gms.common.internal.s.k(list);
        com.google.android.gms.common.internal.s.e(str);
        p pVar = new p();
        pVar.f16836c = new ArrayList();
        pVar.f16837d = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m7.j0 j0Var = (m7.j0) it.next();
            if (j0Var instanceof m7.r0) {
                pVar.f16836c.add((m7.r0) j0Var);
            } else {
                if (!(j0Var instanceof m7.x0)) {
                    throw new IllegalArgumentException("MultiFactorInfo must be either PhoneMultiFactorInfo or TotpMultiFactorInfo. The factorId of this MultiFactorInfo: " + j0Var.S());
                }
                pVar.f16837d.add((m7.x0) j0Var);
            }
        }
        pVar.f16835b = str;
        return pVar;
    }

    public final i R() {
        return this.f16838e;
    }

    public final String U() {
        return this.f16834a;
    }

    public final boolean V() {
        return this.f16834a != null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 1, this.f16834a, false);
        n5.c.E(parcel, 2, this.f16835b, false);
        n5.c.I(parcel, 3, this.f16836c, false);
        n5.c.I(parcel, 4, this.f16837d, false);
        n5.c.C(parcel, 5, this.f16838e, i10, false);
        n5.c.b(parcel, iA);
    }

    public final String zzc() {
        return this.f16835b;
    }

    public p(String str, String str2, List list, List list2, i iVar) {
        this.f16834a = str;
        this.f16835b = str2;
        this.f16836c = list;
        this.f16837d = list2;
        this.f16838e = iVar;
    }
}
