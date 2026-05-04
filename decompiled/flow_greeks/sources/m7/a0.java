package m7;

import android.app.Activity;
import android.net.Uri;
import com.google.android.gms.internal.p002firebaseauthapi.zzahv;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a0 extends n5.a implements b1 {
    @Override // m7.b1
    public abstract String K();

    public Task R() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(m0());
        com.google.android.gms.common.internal.s.k(this);
        return firebaseAuth.f6027e.zza(this, new g2(firebaseAuth, this));
    }

    public Task S(boolean z10) {
        return FirebaseAuth.getInstance(m0()).Z(this, z10);
    }

    public abstract b0 T();

    public abstract h0 U();

    public abstract List V();

    public abstract String W();

    public abstract boolean X();

    public Task Y(h hVar) {
        com.google.android.gms.common.internal.s.k(hVar);
        return FirebaseAuth.getInstance(m0()).U(this, hVar);
    }

    public Task Z(h hVar) {
        com.google.android.gms.common.internal.s.k(hVar);
        return FirebaseAuth.getInstance(m0()).u0(this, hVar);
    }

    @Override // m7.b1
    public abstract String a();

    public Task a0() {
        return FirebaseAuth.getInstance(m0()).S(this);
    }

    public Task b0() {
        return FirebaseAuth.getInstance(m0()).Z(this, false).continueWithTask(new j1(this));
    }

    public Task c0(e eVar) {
        return FirebaseAuth.getInstance(m0()).Z(this, false).continueWithTask(new i1(this, eVar));
    }

    @Override // m7.b1
    public abstract Uri d();

    public Task d0(Activity activity, n nVar) {
        com.google.android.gms.common.internal.s.k(activity);
        com.google.android.gms.common.internal.s.k(nVar);
        return FirebaseAuth.getInstance(m0()).M(activity, nVar, this);
    }

    public Task e0(Activity activity, n nVar) {
        com.google.android.gms.common.internal.s.k(activity);
        com.google.android.gms.common.internal.s.k(nVar);
        return FirebaseAuth.getInstance(m0()).n0(activity, nVar, this);
    }

    public Task f0(String str) {
        com.google.android.gms.common.internal.s.e(str);
        return FirebaseAuth.getInstance(m0()).o0(this, str);
    }

    public Task g0(String str) {
        com.google.android.gms.common.internal.s.e(str);
        return FirebaseAuth.getInstance(m0()).t0(this, str);
    }

    public Task h0(String str) {
        com.google.android.gms.common.internal.s.e(str);
        return FirebaseAuth.getInstance(m0()).x0(this, str);
    }

    public Task i0(o0 o0Var) {
        return FirebaseAuth.getInstance(m0()).W(this, o0Var);
    }

    public Task j0(c1 c1Var) {
        com.google.android.gms.common.internal.s.k(c1Var);
        return FirebaseAuth.getInstance(m0()).X(this, c1Var);
    }

    public Task k0(String str) {
        return l0(str, null);
    }

    public Task l0(String str, e eVar) {
        return FirebaseAuth.getInstance(m0()).Z(this, false).continueWithTask(new k1(this, str, eVar));
    }

    public abstract a7.g m0();

    public abstract a0 n0(List list);

    public abstract void o0(zzahv zzahvVar);

    @Override // m7.b1
    public abstract String p();

    public abstract a0 p0();

    public abstract void q0(List list);

    public abstract zzahv r0();

    public abstract void s0(List list);

    public abstract List t0();

    @Override // m7.b1
    public abstract String v();

    public abstract String zzd();

    public abstract String zze();

    public abstract List zzg();
}
