package a3;

import Z2.InterfaceC0750c0;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.p002firebaseauthapi.zzahn;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: a3.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0855i extends Z2.A {
    public static final Parcelable.Creator<C0855i> CREATOR = new C0853h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zzahn f6224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0847e f6225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f6228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f6229f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f6230g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f6231h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public C0859k f6232i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6233j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Z2.y0 f6234k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public C0827N f6235l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f6236m;

    public C0855i(Q2.g gVar, List list) {
        AbstractC1207s.k(gVar);
        this.f6226c = gVar.q();
        this.f6227d = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.f6230g = "2";
        W(list);
    }

    @Override // Z2.A
    public Z2.B C() {
        return this.f6232i;
    }

    @Override // Z2.A
    public /* synthetic */ Z2.H D() {
        return new C0863m(this);
    }

    @Override // Z2.A
    public List E() {
        return this.f6228e;
    }

    @Override // Z2.A
    public String F() {
        Map map;
        zzahn zzahnVar = this.f6224a;
        if (zzahnVar == null || zzahnVar.zzc() == null || (map = (Map) AbstractC0826M.a(this.f6224a.zzc()).b().get("firebase")) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    @Override // Z2.A
    public boolean G() {
        Z2.C cA;
        Boolean bool = this.f6231h;
        if (bool == null || bool.booleanValue()) {
            zzahn zzahnVar = this.f6224a;
            String strE = "";
            if (zzahnVar != null && (cA = AbstractC0826M.a(zzahnVar.zzc())) != null) {
                strE = cA.e();
            }
            boolean z7 = true;
            if (E().size() > 1 || (strE != null && strE.equals("custom"))) {
                z7 = false;
            }
            this.f6231h = Boolean.valueOf(z7);
        }
        return this.f6231h.booleanValue();
    }

    @Override // Z2.A
    public final Q2.g V() {
        return Q2.g.p(this.f6226c);
    }

    @Override // Z2.A
    public final synchronized Z2.A W(List list) {
        try {
            AbstractC1207s.k(list);
            this.f6228e = new ArrayList(list.size());
            this.f6229f = new ArrayList(list.size());
            for (int i7 = 0; i7 < list.size(); i7++) {
                InterfaceC0750c0 interfaceC0750c0 = (InterfaceC0750c0) list.get(i7);
                if (interfaceC0750c0.b().equals("firebase")) {
                    this.f6225b = (C0847e) interfaceC0750c0;
                } else {
                    this.f6229f.add(interfaceC0750c0.b());
                }
                this.f6228e.add((C0847e) interfaceC0750c0);
            }
            if (this.f6225b == null) {
                this.f6225b = (C0847e) this.f6228e.get(0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    @Override // Z2.A
    public final void X(zzahn zzahnVar) {
        this.f6224a = (zzahn) AbstractC1207s.k(zzahnVar);
    }

    @Override // Z2.A
    public final /* synthetic */ Z2.A Y() {
        this.f6231h = Boolean.FALSE;
        return this;
    }

    @Override // Z2.A
    public final void Z(List list) {
        if (list == null) {
            list = new ArrayList();
        }
        this.f6236m = list;
    }

    @Override // Z2.A, Z2.InterfaceC0750c0
    public String a() {
        return this.f6225b.a();
    }

    @Override // Z2.A
    public final zzahn a0() {
        return this.f6224a;
    }

    @Override // Z2.InterfaceC0750c0
    public String b() {
        return this.f6225b.b();
    }

    @Override // Z2.A
    public final void b0(List list) {
        this.f6235l = C0827N.A(list);
    }

    @Override // Z2.A, Z2.InterfaceC0750c0
    public Uri c() {
        return this.f6225b.c();
    }

    @Override // Z2.A
    public final List c0() {
        return this.f6236m;
    }

    public final C0855i d0(String str) {
        this.f6230g = str;
        return this;
    }

    public final void e0(Z2.y0 y0Var) {
        this.f6234k = y0Var;
    }

    public final void f0(C0859k c0859k) {
        this.f6232i = c0859k;
    }

    @Override // Z2.InterfaceC0750c0
    public boolean g() {
        return this.f6225b.g();
    }

    public final void g0(boolean z7) {
        this.f6233j = z7;
    }

    public final Z2.y0 h0() {
        return this.f6234k;
    }

    public final List i0() {
        C0827N c0827n = this.f6235l;
        return c0827n != null ? c0827n.zza() : new ArrayList();
    }

    public final List j0() {
        return this.f6228e;
    }

    @Override // Z2.A, Z2.InterfaceC0750c0
    public String k() {
        return this.f6225b.k();
    }

    public final boolean k0() {
        return this.f6233j;
    }

    @Override // Z2.A, Z2.InterfaceC0750c0
    public String p() {
        return this.f6225b.p();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.C(parcel, 1, a0(), i7, false);
        Q1.c.C(parcel, 2, this.f6225b, i7, false);
        Q1.c.E(parcel, 3, this.f6226c, false);
        Q1.c.E(parcel, 4, this.f6227d, false);
        Q1.c.I(parcel, 5, this.f6228e, false);
        Q1.c.G(parcel, 6, zzg(), false);
        Q1.c.E(parcel, 7, this.f6230g, false);
        Q1.c.i(parcel, 8, Boolean.valueOf(G()), false);
        Q1.c.C(parcel, 9, C(), i7, false);
        Q1.c.g(parcel, 10, this.f6233j);
        Q1.c.C(parcel, 11, this.f6234k, i7, false);
        Q1.c.C(parcel, 12, this.f6235l, i7, false);
        Q1.c.I(parcel, 13, c0(), false);
        Q1.c.b(parcel, iA);
    }

    @Override // Z2.A, Z2.InterfaceC0750c0
    public String x() {
        return this.f6225b.x();
    }

    @Override // Z2.A
    public final String zzd() {
        return a0().zzc();
    }

    @Override // Z2.A
    public final String zze() {
        return this.f6224a.zzf();
    }

    @Override // Z2.A
    public final List zzg() {
        return this.f6229f;
    }

    public C0855i(zzahn zzahnVar, C0847e c0847e, String str, String str2, List list, List list2, String str3, Boolean bool, C0859k c0859k, boolean z7, Z2.y0 y0Var, C0827N c0827n, List list3) {
        this.f6224a = zzahnVar;
        this.f6225b = c0847e;
        this.f6226c = str;
        this.f6227d = str2;
        this.f6228e = list;
        this.f6229f = list2;
        this.f6230g = str3;
        this.f6231h = bool;
        this.f6232i = c0859k;
        this.f6233j = z7;
        this.f6234k = y0Var;
        this.f6235l = c0827n;
        this.f6236m = list3;
    }
}
