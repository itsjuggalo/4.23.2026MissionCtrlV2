package Z2;

import android.app.Activity;
import android.net.Uri;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.p002firebaseauthapi.zzahn;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class A extends Q1.a implements InterfaceC0750c0 {
    public Task A() {
        return FirebaseAuth.getInstance(V()).O(this);
    }

    public Task B(boolean z7) {
        return FirebaseAuth.getInstance(V()).V(this, z7);
    }

    public abstract B C();

    public abstract H D();

    public abstract List E();

    public abstract String F();

    public abstract boolean G();

    public Task H(AbstractC0759h abstractC0759h) {
        AbstractC1207s.k(abstractC0759h);
        return FirebaseAuth.getInstance(V()).P(this, abstractC0759h);
    }

    public Task I(AbstractC0759h abstractC0759h) {
        AbstractC1207s.k(abstractC0759h);
        return FirebaseAuth.getInstance(V()).w0(this, abstractC0759h);
    }

    public Task J() {
        return FirebaseAuth.getInstance(V()).p0(this);
    }

    public Task K() {
        return FirebaseAuth.getInstance(V()).V(this, false).continueWithTask(new C0762i0(this));
    }

    public Task L(C0753e c0753e) {
        return FirebaseAuth.getInstance(V()).V(this, false).continueWithTask(new C0766k0(this, c0753e));
    }

    public Task M(Activity activity, AbstractC0769n abstractC0769n) {
        AbstractC1207s.k(activity);
        AbstractC1207s.k(abstractC0769n);
        return FirebaseAuth.getInstance(V()).Y(activity, abstractC0769n, this);
    }

    public Task N(Activity activity, AbstractC0769n abstractC0769n) {
        AbstractC1207s.k(activity);
        AbstractC1207s.k(abstractC0769n);
        return FirebaseAuth.getInstance(V()).r0(activity, abstractC0769n, this);
    }

    public Task O(String str) {
        AbstractC1207s.e(str);
        return FirebaseAuth.getInstance(V()).q0(this, str);
    }

    public Task P(String str) {
        AbstractC1207s.e(str);
        return FirebaseAuth.getInstance(V()).x0(this, str);
    }

    public Task Q(String str) {
        AbstractC1207s.e(str);
        return FirebaseAuth.getInstance(V()).A0(this, str);
    }

    public Task R(O o7) {
        return FirebaseAuth.getInstance(V()).R(this, o7);
    }

    public Task S(C0752d0 c0752d0) {
        AbstractC1207s.k(c0752d0);
        return FirebaseAuth.getInstance(V()).S(this, c0752d0);
    }

    public Task T(String str) {
        return U(str, null);
    }

    public Task U(String str, C0753e c0753e) {
        return FirebaseAuth.getInstance(V()).V(this, false).continueWithTask(new C0764j0(this, str, c0753e));
    }

    public abstract Q2.g V();

    public abstract A W(List list);

    public abstract void X(zzahn zzahnVar);

    public abstract A Y();

    public abstract void Z(List list);

    @Override // Z2.InterfaceC0750c0
    public abstract String a();

    public abstract zzahn a0();

    public abstract void b0(List list);

    @Override // Z2.InterfaceC0750c0
    public abstract Uri c();

    public abstract List c0();

    @Override // Z2.InterfaceC0750c0
    public abstract String k();

    @Override // Z2.InterfaceC0750c0
    public abstract String p();

    @Override // Z2.InterfaceC0750c0
    public abstract String x();

    public abstract String zzd();

    public abstract String zze();

    public abstract List zzg();
}
