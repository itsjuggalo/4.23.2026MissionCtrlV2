package n7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaas;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends m7.k0 {
    public static final Parcelable.Creator<o> CREATOR = new q();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f16827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f16828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m7.z1 f16830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f16831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f16832f;

    public o(List list, p pVar, String str, m7.z1 z1Var, i iVar, List list2) {
        this.f16827a = (List) com.google.android.gms.common.internal.s.k(list);
        this.f16828b = (p) com.google.android.gms.common.internal.s.k(pVar);
        this.f16829c = com.google.android.gms.common.internal.s.e(str);
        this.f16830d = z1Var;
        this.f16831e = iVar;
        this.f16832f = (List) com.google.android.gms.common.internal.s.k(list2);
    }

    public static o W(zzaas zzaasVar, FirebaseAuth firebaseAuth, m7.a0 a0Var) {
        List<m7.j0> listZzc = zzaasVar.zzc();
        ArrayList arrayList = new ArrayList();
        for (m7.j0 j0Var : listZzc) {
            if (j0Var instanceof m7.r0) {
                arrayList.add((m7.r0) j0Var);
            }
        }
        List<m7.j0> listZzc2 = zzaasVar.zzc();
        ArrayList arrayList2 = new ArrayList();
        for (m7.j0 j0Var2 : listZzc2) {
            if (j0Var2 instanceof m7.x0) {
                arrayList2.add((m7.x0) j0Var2);
            }
        }
        return new o(arrayList, p.T(zzaasVar.zzc(), zzaasVar.zzb()), firebaseAuth.l().q(), zzaasVar.zza(), (i) a0Var, arrayList2);
    }

    @Override // m7.k0
    public final FirebaseAuth R() {
        return FirebaseAuth.getInstance(a7.g.p(this.f16829c));
    }

    @Override // m7.k0
    public final List S() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f16827a.iterator();
        while (it.hasNext()) {
            arrayList.add((m7.r0) it.next());
        }
        Iterator it2 = this.f16832f.iterator();
        while (it2.hasNext()) {
            arrayList.add((m7.x0) it2.next());
        }
        return arrayList;
    }

    @Override // m7.k0
    public final m7.l0 T() {
        return this.f16828b;
    }

    @Override // m7.k0
    public final Task U(m7.i0 i0Var) {
        return R().a0(i0Var, this.f16828b, this.f16831e).continueWithTask(new n(this));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.I(parcel, 1, this.f16827a, false);
        n5.c.C(parcel, 2, T(), i10, false);
        n5.c.E(parcel, 3, this.f16829c, false);
        n5.c.C(parcel, 4, this.f16830d, i10, false);
        n5.c.C(parcel, 5, this.f16831e, i10, false);
        n5.c.I(parcel, 6, this.f16832f, false);
        n5.c.b(parcel, iA);
    }
}
