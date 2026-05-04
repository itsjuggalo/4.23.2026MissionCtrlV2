package n7;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzahv;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends m7.a0 {
    public static final Parcelable.Creator<i> CREATOR = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zzahv f16783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f16784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f16786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f16787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f16788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f16789g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f16790h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k f16791i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f16792j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public m7.z1 f16793k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public n0 f16794l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f16795m;

    public i(a7.g gVar, List list) {
        com.google.android.gms.common.internal.s.k(gVar);
        this.f16785c = gVar.q();
        this.f16786d = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.f16789g = "2";
        n0(list);
    }

    public final List A0() {
        return this.f16787e;
    }

    public final boolean B0() {
        return this.f16792j;
    }

    @Override // m7.a0, m7.b1
    public final String K() {
        return this.f16784b.K();
    }

    @Override // m7.a0
    public final m7.b0 T() {
        return this.f16791i;
    }

    @Override // m7.a0
    public final /* synthetic */ m7.h0 U() {
        return new m(this);
    }

    @Override // m7.a0
    public final List V() {
        return this.f16787e;
    }

    @Override // m7.a0
    public final String W() {
        Map map;
        zzahv zzahvVar = this.f16783a;
        if (zzahvVar == null || zzahvVar.zzc() == null || (map = (Map) m0.a(this.f16783a.zzc()).b().get("firebase")) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    @Override // m7.a0
    public final boolean X() {
        m7.c0 c0VarA;
        Boolean bool = this.f16790h;
        if (bool == null || bool.booleanValue()) {
            zzahv zzahvVar = this.f16783a;
            String strE = "";
            if (zzahvVar != null && (c0VarA = m0.a(zzahvVar.zzc())) != null) {
                strE = c0VarA.e();
            }
            boolean z10 = true;
            if (V().size() > 1 || (strE != null && strE.equals("custom"))) {
                z10 = false;
            }
            this.f16790h = Boolean.valueOf(z10);
        }
        return this.f16790h.booleanValue();
    }

    @Override // m7.a0, m7.b1
    public final String a() {
        return this.f16784b.a();
    }

    @Override // m7.b1
    public final String c() {
        return this.f16784b.c();
    }

    @Override // m7.a0, m7.b1
    public final Uri d() {
        return this.f16784b.d();
    }

    @Override // m7.b1
    public final boolean f() {
        return this.f16784b.f();
    }

    @Override // m7.a0
    public final a7.g m0() {
        return a7.g.p(this.f16785c);
    }

    @Override // m7.a0
    public final synchronized m7.a0 n0(List list) {
        try {
            com.google.android.gms.common.internal.s.k(list);
            this.f16787e = new ArrayList(list.size());
            this.f16788f = new ArrayList(list.size());
            for (int i10 = 0; i10 < list.size(); i10++) {
                m7.b1 b1Var = (m7.b1) list.get(i10);
                if (b1Var.c().equals("firebase")) {
                    this.f16784b = (e) b1Var;
                } else {
                    this.f16788f.add(b1Var.c());
                }
                this.f16787e.add((e) b1Var);
            }
            if (this.f16784b == null) {
                this.f16784b = (e) this.f16787e.get(0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    @Override // m7.a0
    public final void o0(zzahv zzahvVar) {
        this.f16783a = (zzahv) com.google.android.gms.common.internal.s.k(zzahvVar);
    }

    @Override // m7.a0, m7.b1
    public final String p() {
        return this.f16784b.p();
    }

    @Override // m7.a0
    public final /* synthetic */ m7.a0 p0() {
        this.f16790h = Boolean.FALSE;
        return this;
    }

    @Override // m7.a0
    public final void q0(List list) {
        if (list == null) {
            list = new ArrayList();
        }
        this.f16795m = list;
    }

    @Override // m7.a0
    public final zzahv r0() {
        return this.f16783a;
    }

    @Override // m7.a0
    public final void s0(List list) {
        this.f16794l = n0.R(list);
    }

    @Override // m7.a0
    public final List t0() {
        return this.f16795m;
    }

    public final i u0(String str) {
        this.f16789g = str;
        return this;
    }

    @Override // m7.a0, m7.b1
    public final String v() {
        return this.f16784b.v();
    }

    public final void v0(m7.z1 z1Var) {
        this.f16793k = z1Var;
    }

    public final void w0(k kVar) {
        this.f16791i = kVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.C(parcel, 1, r0(), i10, false);
        n5.c.C(parcel, 2, this.f16784b, i10, false);
        n5.c.E(parcel, 3, this.f16785c, false);
        n5.c.E(parcel, 4, this.f16786d, false);
        n5.c.I(parcel, 5, this.f16787e, false);
        n5.c.G(parcel, 6, zzg(), false);
        n5.c.E(parcel, 7, this.f16789g, false);
        n5.c.i(parcel, 8, Boolean.valueOf(X()), false);
        n5.c.C(parcel, 9, T(), i10, false);
        n5.c.g(parcel, 10, this.f16792j);
        n5.c.C(parcel, 11, this.f16793k, i10, false);
        n5.c.C(parcel, 12, this.f16794l, i10, false);
        n5.c.I(parcel, 13, t0(), false);
        n5.c.b(parcel, iA);
    }

    public final void x0(boolean z10) {
        this.f16792j = z10;
    }

    public final m7.z1 y0() {
        return this.f16793k;
    }

    public final List z0() {
        n0 n0Var = this.f16794l;
        return n0Var != null ? n0Var.zza() : new ArrayList();
    }

    @Override // m7.a0
    public final String zzd() {
        return r0().zzc();
    }

    @Override // m7.a0
    public final String zze() {
        return this.f16783a.zzf();
    }

    @Override // m7.a0
    public final List zzg() {
        return this.f16788f;
    }

    public i(zzahv zzahvVar, e eVar, String str, String str2, List list, List list2, String str3, Boolean bool, k kVar, boolean z10, m7.z1 z1Var, n0 n0Var, List list3) {
        this.f16783a = zzahvVar;
        this.f16784b = eVar;
        this.f16785c = str;
        this.f16786d = str2;
        this.f16787e = list;
        this.f16788f = list2;
        this.f16789g = str3;
        this.f16790h = bool;
        this.f16791i = kVar;
        this.f16792j = z10;
        this.f16793k = z1Var;
        this.f16794l = n0Var;
        this.f16795m = list3;
    }
}
