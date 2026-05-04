package com.google.firebase.auth;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.p002firebaseauthapi.zzac;
import com.google.android.gms.internal.p002firebaseauthapi.zzacq;
import com.google.android.gms.internal.p002firebaseauthapi.zzaen;
import com.google.android.gms.internal.p002firebaseauthapi.zzaeu;
import com.google.android.gms.internal.p002firebaseauthapi.zzafd;
import com.google.android.gms.internal.p002firebaseauthapi.zzagb;
import com.google.android.gms.internal.p002firebaseauthapi.zzagl;
import com.google.android.gms.internal.p002firebaseauthapi.zzahv;
import com.google.android.gms.internal.p002firebaseauthapi.zzaij;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.b;
import io.flutter.plugins.firebase.auth.Constants;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import m7.a0;
import m7.c1;
import m7.d2;
import m7.e1;
import m7.e2;
import m7.f2;
import m7.h2;
import m7.i0;
import m7.j2;
import m7.o0;
import m7.r0;
import m7.v0;
import m7.w;
import n7.b1;
import n7.d0;
import n7.f1;
import n7.g1;
import n7.i2;
import n7.k1;
import n7.l1;
import n7.m0;
import n7.p;
import n7.p0;
import n7.s1;
import n7.u1;
import n7.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class FirebaseAuth implements n7.b {
    public final Executor A;
    public String B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a7.g f6023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f6024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f6025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f6026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final zzacq f6027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a0 f6028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n7.f f6029g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f6030h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f6031i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f6032j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f6033k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b1 f6034l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RecaptchaAction f6035m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RecaptchaAction f6036n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RecaptchaAction f6037o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RecaptchaAction f6038p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RecaptchaAction f6039q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final RecaptchaAction f6040r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final g1 f6041s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final l1 f6042t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final d0 f6043u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final fa.b f6044v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final fa.b f6045w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public f1 f6046x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Executor f6047y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Executor f6048z;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        void a(FirebaseAuth firebaseAuth);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        void a(FirebaseAuth firebaseAuth);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements u1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FirebaseAuth f6049a;

        public c(FirebaseAuth firebaseAuth) {
            Objects.requireNonNull(firebaseAuth);
            this.f6049a = firebaseAuth;
        }

        @Override // n7.u1
        public final void a(zzahv zzahvVar, a0 a0Var) {
            s.k(zzahvVar);
            s.k(a0Var);
            a0Var.o0(zzahvVar);
            this.f6049a.k0(a0Var, zzahvVar, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements x, u1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FirebaseAuth f6050a;

        public d(FirebaseAuth firebaseAuth) {
            Objects.requireNonNull(firebaseAuth);
            this.f6050a = firebaseAuth;
        }

        @Override // n7.u1
        public final void a(zzahv zzahvVar, a0 a0Var) {
            s.k(zzahvVar);
            s.k(a0Var);
            a0Var.o0(zzahvVar);
            this.f6050a.l0(a0Var, zzahvVar, true, true);
        }

        @Override // n7.x
        public final void zza(Status status) {
            if (status.S() == 17011 || status.S() == 17021 || status.S() == 17005 || status.S() == 17091) {
                this.f6050a.F();
            }
        }
    }

    public FirebaseAuth(a7.g gVar, fa.b bVar, fa.b bVar2, Executor executor, Executor executor2, Executor executor3, ScheduledExecutorService scheduledExecutorService, Executor executor4) {
        this(gVar, new zzacq(gVar, executor2, scheduledExecutorService), new g1(gVar.m(), gVar.s()), l1.f(), d0.b(), bVar, bVar2, executor, executor2, executor3, executor4);
    }

    public static f1 D0(FirebaseAuth firebaseAuth) {
        if (firebaseAuth.f6046x == null) {
            firebaseAuth.f6046x = new f1((a7.g) s.k(firebaseAuth.f6023a));
        }
        return firebaseAuth.f6046x;
    }

    public static void f0(final a7.m mVar, com.google.firebase.auth.a aVar, String str) {
        Log.e("FirebaseAuth", "Invoking verification failure callback for phone number/uid - " + str);
        final b.AbstractC0100b abstractC0100bZza = zzagb.zza(str, aVar.g(), null);
        aVar.k().execute(new Runnable() { // from class: m7.c2
            @Override // java.lang.Runnable
            public final void run() {
                abstractC0100bZza.onVerificationFailed(mVar);
            }
        });
    }

    public static void g0(FirebaseAuth firebaseAuth, a0 a0Var) {
        if (a0Var != null) {
            Log.d("FirebaseAuth", "Notifying auth state listeners about user ( " + a0Var.a() + " ).");
        } else {
            Log.d("FirebaseAuth", "Notifying auth state listeners about a sign-out event.");
        }
        firebaseAuth.A.execute(new m(firebaseAuth));
    }

    @Keep
    public static FirebaseAuth getInstance() {
        return (FirebaseAuth) a7.g.o().k(FirebaseAuth.class);
    }

    public static void h0(FirebaseAuth firebaseAuth, a0 a0Var, zzahv zzahvVar, boolean z10, boolean z11) {
        boolean z12;
        s.k(a0Var);
        s.k(zzahvVar);
        boolean z13 = true;
        boolean z14 = firebaseAuth.f6028f != null && a0Var.a().equals(firebaseAuth.f6028f.a());
        if (z14 || !z11) {
            a0 a0Var2 = firebaseAuth.f6028f;
            if (a0Var2 == null) {
                z12 = true;
            } else {
                boolean z15 = (z14 && a0Var2.r0().zzc().equals(zzahvVar.zzc())) ? false : true;
                z12 = z14 ? false : true;
                z13 = z15;
            }
            s.k(a0Var);
            if (firebaseAuth.f6028f == null || !a0Var.a().equals(firebaseAuth.a())) {
                firebaseAuth.f6028f = a0Var;
            } else {
                firebaseAuth.f6028f.n0(a0Var.V());
                if (!a0Var.X()) {
                    firebaseAuth.f6028f.p0();
                }
                List listB = a0Var.U().b();
                List listT0 = a0Var.t0();
                firebaseAuth.f6028f.s0(listB);
                firebaseAuth.f6028f.q0(listT0);
            }
            if (z10) {
                firebaseAuth.f6041s.j(firebaseAuth.f6028f);
            }
            if (z13) {
                a0 a0Var3 = firebaseAuth.f6028f;
                if (a0Var3 != null) {
                    a0Var3.o0(zzahvVar);
                }
                r0(firebaseAuth, firebaseAuth.f6028f);
            }
            if (z12) {
                g0(firebaseAuth, firebaseAuth.f6028f);
            }
            if (z10) {
                firebaseAuth.f6041s.f(a0Var, zzahvVar);
            }
            a0 a0Var4 = firebaseAuth.f6028f;
            if (a0Var4 != null) {
                D0(firebaseAuth).d(a0Var4.r0());
            }
        }
    }

    public static void i0(com.google.firebase.auth.a aVar) {
        String strE;
        String strP;
        if (!aVar.o()) {
            FirebaseAuth firebaseAuthC = aVar.c();
            String strE2 = s.e(aVar.j());
            if (aVar.f() == null && zzagb.zza(strE2, aVar.g(), aVar.a(), aVar.k())) {
                return;
            }
            firebaseAuthC.f6043u.a(firebaseAuthC, strE2, aVar.a(), firebaseAuthC.F0(), aVar.l(), aVar.n(), firebaseAuthC.f6038p).addOnCompleteListener(new d2(firebaseAuthC, aVar, strE2));
            return;
        }
        FirebaseAuth firebaseAuthC2 = aVar.c();
        p pVar = (p) s.k(aVar.e());
        if (pVar.V()) {
            strP = s.e(aVar.j());
            strE = strP;
        } else {
            r0 r0Var = (r0) s.k(aVar.h());
            strE = s.e(r0Var.a());
            strP = r0Var.p();
        }
        if (aVar.f() == null || !zzagb.zza(strE, aVar.g(), aVar.a(), aVar.k())) {
            firebaseAuthC2.f6043u.a(firebaseAuthC2, strP, aVar.a(), firebaseAuthC2.F0(), aVar.l(), aVar.n(), pVar.V() ? firebaseAuthC2.f6039q : firebaseAuthC2.f6040r).addOnCompleteListener(new f(firebaseAuthC2, aVar, strE));
        }
    }

    public static void r0(FirebaseAuth firebaseAuth, a0 a0Var) {
        if (a0Var != null) {
            Log.d("FirebaseAuth", "Notifying id token listeners about user ( " + a0Var.a() + " ).");
        } else {
            Log.d("FirebaseAuth", "Notifying id token listeners about a sign-out event.");
        }
        firebaseAuth.A.execute(new l(firebaseAuth, new ka.b(a0Var != null ? a0Var.zzd() : null)));
    }

    public Task A() {
        a0 a0Var = this.f6028f;
        if (a0Var == null || !a0Var.X()) {
            return this.f6027e.zza(this.f6023a, new c(this), this.f6033k);
        }
        n7.i iVar = (n7.i) this.f6028f;
        iVar.x0(false);
        return Tasks.forResult(new i2(iVar));
    }

    public Task B(m7.h hVar) {
        s.k(hVar);
        m7.h hVarT = hVar.T();
        if (hVarT instanceof m7.j) {
            m7.j jVar = (m7.j) hVarT;
            return !jVar.X() ? O(jVar.zzc(), (String) s.k(jVar.zzd()), this.f6033k, null, false) : s0(s.e(jVar.zze())) ? Tasks.forException(zzaen.zza(new Status(17072))) : R(jVar, null, false);
        }
        if (hVarT instanceof o0) {
            return this.f6027e.zza(this.f6023a, (o0) hVarT, this.f6033k, (u1) new c(this));
        }
        return this.f6027e.zza(this.f6023a, hVarT, this.f6033k, new c(this));
    }

    public final Executor B0() {
        return this.f6047y;
    }

    public Task C(String str) {
        s.e(str);
        return this.f6027e.zza(this.f6023a, str, this.f6033k, new c(this));
    }

    public final Executor C0() {
        return this.f6048z;
    }

    public Task D(String str, String str2) {
        s.e(str);
        s.e(str2);
        return O(str, str2, this.f6033k, null, false);
    }

    public Task E(String str, String str2) {
        return B(m7.k.b(str, str2));
    }

    public final void E0() {
        s.k(this.f6041s);
        a0 a0Var = this.f6028f;
        if (a0Var != null) {
            this.f6041s.i(a0Var);
            this.f6028f = null;
        }
        this.f6041s.g();
        r0(this, null);
        g0(this, null);
    }

    public void F() {
        E0();
        f1 f1Var = this.f6046x;
        if (f1Var != null) {
            f1Var.b();
        }
    }

    public final boolean F0() {
        return zzaeu.zza(l().m());
    }

    public Task G(Activity activity, m7.n nVar) {
        s.k(nVar);
        s.k(activity);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.f6042t.c(activity, taskCompletionSource, this)) {
            return Tasks.forException(zzaen.zza(new Status(17057)));
        }
        p0.d(activity.getApplicationContext(), this);
        nVar.c(activity);
        return taskCompletionSource.getTask();
    }

    public final synchronized f1 G0() {
        return D0(this);
    }

    public void H() {
        synchronized (this.f6030h) {
            this.f6031i = zzafd.zza();
        }
    }

    public void I(String str, int i10) {
        s.e(str);
        s.b(i10 >= 0 && i10 <= 65535, "Port number must be in the range 0-65535");
        zzagl.zza(this.f6023a, str, i10);
    }

    public Task J(String str) {
        s.e(str);
        return this.f6027e.zzd(this.f6023a, str, this.f6033k);
    }

    public final Task L() {
        return this.f6027e.zza();
    }

    public final Task M(Activity activity, m7.n nVar, a0 a0Var) {
        s.k(activity);
        s.k(nVar);
        s.k(a0Var);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.f6042t.d(activity, taskCompletionSource, this, a0Var)) {
            return Tasks.forException(zzaen.zza(new Status(17057)));
        }
        p0.e(activity.getApplicationContext(), this, a0Var);
        nVar.a(activity);
        return taskCompletionSource.getTask();
    }

    public final Task N(String str) {
        return this.f6027e.zza(this.f6033k, str);
    }

    public final Task O(String str, String str2, String str3, a0 a0Var, boolean z10) {
        return new n(this, str, z10, a0Var, str2, str3).b(this, str3, this.f6036n, "EMAIL_PASSWORD_PROVIDER");
    }

    public final Task P(String str, String str2, m7.e eVar) {
        s.e(str);
        s.e(str2);
        if (eVar == null) {
            eVar = m7.e.c0();
        }
        String str3 = this.f6031i;
        if (str3 != null) {
            eVar.b0(str3);
        }
        return this.f6027e.zza(str, str2, eVar);
    }

    public final Task Q(m7.e eVar, String str) {
        s.e(str);
        if (this.f6031i != null) {
            if (eVar == null) {
                eVar = m7.e.c0();
            }
            eVar.b0(this.f6031i);
        }
        return this.f6027e.zza(this.f6023a, eVar, str);
    }

    public final Task R(m7.j jVar, a0 a0Var, boolean z10) {
        return new com.google.firebase.auth.c(this, z10, a0Var, jVar).b(this, this.f6033k, this.f6035m, "EMAIL_PASSWORD_PROVIDER");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.firebase.auth.FirebaseAuth$d, n7.k1] */
    public final Task S(a0 a0Var) {
        return Y(a0Var, new d(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.firebase.auth.FirebaseAuth$d, n7.k1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task T(a0 a0Var, String str) {
        s.k(a0Var);
        s.e(str);
        return this.f6027e.zza(this.f6023a, a0Var, str, this.f6033k, (k1) new d(this)).continueWithTask(new h2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.firebase.auth.FirebaseAuth$d, n7.k1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task U(a0 a0Var, m7.h hVar) {
        s.k(hVar);
        s.k(a0Var);
        return hVar instanceof m7.j ? new j(this, a0Var, (m7.j) hVar.T()).b(this, a0Var.W(), this.f6037o, "EMAIL_PASSWORD_PROVIDER") : this.f6027e.zza(this.f6023a, a0Var, hVar.T(), (String) null, (k1) new d(this));
    }

    public final Task V(a0 a0Var, i0 i0Var, String str) {
        s.k(a0Var);
        s.k(i0Var);
        return i0Var instanceof m7.p0 ? this.f6027e.zza(this.f6023a, (m7.p0) i0Var, a0Var, str, new c(this)) : i0Var instanceof v0 ? this.f6027e.zza(this.f6023a, (v0) i0Var, a0Var, str, this.f6033k, new c(this)) : Tasks.forException(zzaen.zza(new Status(17499)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$d, n7.k1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task W(a0 a0Var, o0 o0Var) {
        s.k(a0Var);
        s.k(o0Var);
        return this.f6027e.zza(this.f6023a, a0Var, (o0) o0Var.T(), (k1) new d(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$d, n7.k1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task X(a0 a0Var, c1 c1Var) {
        s.k(a0Var);
        s.k(c1Var);
        return this.f6027e.zza(this.f6023a, a0Var, c1Var, (k1) new d(this));
    }

    public final Task Y(a0 a0Var, k1 k1Var) {
        s.k(a0Var);
        return this.f6027e.zza(this.f6023a, a0Var, k1Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [m7.j2, n7.k1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task Z(a0 a0Var, boolean z10) {
        if (a0Var == null) {
            return Tasks.forException(zzaen.zza(new Status(17495)));
        }
        zzahv zzahvVarR0 = a0Var.r0();
        return (!zzahvVarR0.zzg() || z10) ? this.f6027e.zza(this.f6023a, a0Var, zzahvVarR0.zzd(), (k1) new j2(this)) : Tasks.forResult(m0.a(zzahvVarR0.zzc()));
    }

    @Override // n7.b
    public String a() {
        a0 a0Var = this.f6028f;
        if (a0Var == null) {
            return null;
        }
        return a0Var.a();
    }

    public final Task a0(i0 i0Var, p pVar, a0 a0Var) {
        s.k(i0Var);
        s.k(pVar);
        if (i0Var instanceof m7.p0) {
            return this.f6027e.zza(this.f6023a, a0Var, (m7.p0) i0Var, s.e(pVar.zzc()), new c(this));
        }
        if (i0Var instanceof v0) {
            return this.f6027e.zza(this.f6023a, a0Var, (v0) i0Var, s.e(pVar.zzc()), this.f6033k, new c(this));
        }
        throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
    }

    @Override // n7.b
    public void b(n7.a aVar) {
        s.k(aVar);
        this.f6026d.add(aVar);
        G0().c(this.f6026d.size());
    }

    public final Task b0(p pVar) {
        s.k(pVar);
        return this.f6027e.zza(pVar, this.f6033k).continueWithTask(new m7.i2(this));
    }

    @Override // n7.b
    public Task c(boolean z10) {
        return Z(this.f6028f, z10);
    }

    @Override // n7.b
    public void d(n7.a aVar) {
        s.k(aVar);
        this.f6026d.remove(aVar);
        G0().c(this.f6026d.size());
    }

    public final b.AbstractC0100b d0(com.google.firebase.auth.a aVar, b.AbstractC0100b abstractC0100b, s1 s1Var) {
        return aVar.l() ? abstractC0100b : new g(this, aVar, s1Var, abstractC0100b);
    }

    public void e(a aVar) {
        this.f6025c.add(aVar);
        this.A.execute(new k(this, aVar));
    }

    public final b.AbstractC0100b e0(String str, b.AbstractC0100b abstractC0100b) {
        return (this.f6029g.g() && str != null && str.equals(this.f6029g.d())) ? new h(this, abstractC0100b) : abstractC0100b;
    }

    public void f(b bVar) {
        this.f6024b.add(bVar);
        this.A.execute(new e(this, bVar));
    }

    public Task g(String str) {
        s.e(str);
        return this.f6027e.zza(this.f6023a, str, this.f6033k);
    }

    public Task h(String str) {
        s.e(str);
        return this.f6027e.zzb(this.f6023a, str, this.f6033k);
    }

    public Task i(String str, String str2) {
        s.e(str);
        s.e(str2);
        return this.f6027e.zza(this.f6023a, str, str2, this.f6033k);
    }

    public Task j(String str, String str2) {
        s.e(str);
        s.e(str2);
        return new i(this, str, str2).b(this, this.f6033k, this.f6037o, "EMAIL_PASSWORD_PROVIDER");
    }

    public final void j0(com.google.firebase.auth.a aVar, s1 s1Var) {
        com.google.firebase.auth.a aVar2;
        long jLongValue = aVar.i().longValue();
        if (jLongValue < 0 || jLongValue > 120) {
            throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        }
        String strE = s.e(aVar.j());
        String strC = s1Var.c();
        String strB = s1Var.b();
        String strD = s1Var.d();
        if (zzac.zzc(strC) && q0() != null && q0().d("PHONE_PROVIDER")) {
            strC = "NO_RECAPTCHA";
        }
        String str = strC;
        zzaij zzaijVar = new zzaij(strE, jLongValue, aVar.f() != null, this.f6031i, this.f6033k, strD, strB, str, F0());
        b.AbstractC0100b abstractC0100bE0 = e0(strE, aVar.g());
        if (TextUtils.isEmpty(s1Var.d())) {
            aVar2 = aVar;
            abstractC0100bE0 = d0(aVar2, abstractC0100bE0, s1.a().d(strD).c(str).a(strB).b());
        } else {
            aVar2 = aVar;
        }
        this.f6027e.zza(this.f6023a, zzaijVar, abstractC0100bE0, aVar2.a(), aVar2.k());
    }

    public Task k(String str) {
        s.e(str);
        return this.f6027e.zzc(this.f6023a, str, this.f6033k);
    }

    public final void k0(a0 a0Var, zzahv zzahvVar, boolean z10) {
        l0(a0Var, zzahvVar, true, false);
    }

    public a7.g l() {
        return this.f6023a;
    }

    public final void l0(a0 a0Var, zzahv zzahvVar, boolean z10, boolean z11) {
        h0(this, a0Var, zzahvVar, true, z11);
    }

    public a0 m() {
        return this.f6028f;
    }

    public final synchronized void m0(b1 b1Var) {
        this.f6034l = b1Var;
    }

    public String n() {
        return this.B;
    }

    public final Task n0(Activity activity, m7.n nVar, a0 a0Var) {
        s.k(activity);
        s.k(nVar);
        s.k(a0Var);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.f6042t.d(activity, taskCompletionSource, this, a0Var)) {
            return Tasks.forException(zzaen.zza(new Status(17057)));
        }
        p0.e(activity.getApplicationContext(), this, a0Var);
        nVar.b(activity);
        return taskCompletionSource.getTask();
    }

    public w o() {
        return this.f6029g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$d, n7.k1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task o0(a0 a0Var, String str) {
        s.e(str);
        s.k(a0Var);
        return this.f6027e.zzb(this.f6023a, a0Var, str, new d(this));
    }

    public String p() {
        String str;
        synchronized (this.f6030h) {
            str = this.f6031i;
        }
        return str;
    }

    public String q() {
        String str;
        synchronized (this.f6032j) {
            str = this.f6033k;
        }
        return str;
    }

    public final synchronized b1 q0() {
        return this.f6034l;
    }

    public Task r() {
        if (this.f6034l == null) {
            this.f6034l = new b1(this.f6023a, this);
        }
        return this.f6034l.a(this.f6033k, Boolean.FALSE).continueWithTask(new e1(this));
    }

    public void s(a aVar) {
        this.f6025c.remove(aVar);
    }

    public final boolean s0(String str) {
        m7.f fVarC = m7.f.c(str);
        return (fVarC == null || TextUtils.equals(this.f6033k, fVarC.d())) ? false : true;
    }

    public void t(b bVar) {
        this.f6024b.remove(bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$d, n7.k1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task t0(a0 a0Var, String str) {
        s.k(a0Var);
        s.e(str);
        return this.f6027e.zzc(this.f6023a, a0Var, str, new d(this));
    }

    public Task u(String str) {
        s.e(str);
        return v(str, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.firebase.auth.FirebaseAuth$d, n7.k1] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.firebase.auth.FirebaseAuth$d, n7.k1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task u0(a0 a0Var, m7.h hVar) {
        s.k(a0Var);
        s.k(hVar);
        m7.h hVarT = hVar.T();
        if (!(hVarT instanceof m7.j)) {
            return hVarT instanceof o0 ? this.f6027e.zzb(this.f6023a, a0Var, (o0) hVarT, this.f6033k, (k1) new d(this)) : this.f6027e.zzc(this.f6023a, a0Var, hVarT, a0Var.W(), new d(this));
        }
        m7.j jVar = (m7.j) hVarT;
        return Constants.SIGN_IN_METHOD_PASSWORD.equals(jVar.S()) ? O(jVar.zzc(), s.e(jVar.zzd()), a0Var.W(), a0Var, true) : s0(s.e(jVar.zze())) ? Tasks.forException(zzaen.zza(new Status(17072))) : R(jVar, a0Var, true);
    }

    public Task v(String str, m7.e eVar) {
        s.e(str);
        if (eVar == null) {
            eVar = m7.e.c0();
        }
        String str2 = this.f6031i;
        if (str2 != null) {
            eVar.b0(str2);
        }
        eVar.a0(1);
        return new f2(this, str, eVar).b(this, this.f6033k, this.f6035m, "EMAIL_PASSWORD_PROVIDER");
    }

    public final fa.b v0() {
        return this.f6044v;
    }

    public Task w(String str, m7.e eVar) {
        s.e(str);
        s.k(eVar);
        if (!eVar.R()) {
            throw new IllegalArgumentException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
        }
        String str2 = this.f6031i;
        if (str2 != null) {
            eVar.b0(str2);
        }
        return new e2(this, str, eVar).b(this, this.f6033k, this.f6035m, "EMAIL_PASSWORD_PROVIDER");
    }

    public void x(String str) {
        String str2;
        s.e(str);
        if (str.startsWith("chrome-extension://")) {
            this.B = str;
            return;
        }
        if (str.contains("://")) {
            str2 = str;
        } else {
            str2 = "http://" + str;
        }
        try {
            this.B = (String) s.k(new URI(str2).getHost());
        } catch (URISyntaxException e10) {
            if (Log.isLoggable("FirebaseAuth", 4)) {
                Log.i("FirebaseAuth", "Error parsing URL: '" + str + "', " + e10.getMessage());
            }
            this.B = str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$d, n7.k1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Task x0(a0 a0Var, String str) {
        s.k(a0Var);
        s.e(str);
        return this.f6027e.zzd(this.f6023a, a0Var, str, new d(this));
    }

    public void y(String str) {
        s.e(str);
        synchronized (this.f6030h) {
            this.f6031i = str;
        }
    }

    public final fa.b y0() {
        return this.f6045w;
    }

    public void z(String str) {
        s.e(str);
        synchronized (this.f6032j) {
            this.f6033k = str;
        }
    }

    @Keep
    public static FirebaseAuth getInstance(a7.g gVar) {
        return (FirebaseAuth) gVar.k(FirebaseAuth.class);
    }

    public FirebaseAuth(a7.g gVar, zzacq zzacqVar, g1 g1Var, l1 l1Var, d0 d0Var, fa.b bVar, fa.b bVar2, Executor executor, Executor executor2, Executor executor3, Executor executor4) {
        zzahv zzahvVarA;
        this.f6024b = new CopyOnWriteArrayList();
        this.f6025c = new CopyOnWriteArrayList();
        this.f6026d = new CopyOnWriteArrayList();
        this.f6030h = new Object();
        this.f6032j = new Object();
        this.f6035m = RecaptchaAction.custom("getOobCode");
        this.f6036n = RecaptchaAction.custom("signInWithPassword");
        this.f6037o = RecaptchaAction.custom("signUpPassword");
        this.f6038p = RecaptchaAction.custom("sendVerificationCode");
        this.f6039q = RecaptchaAction.custom("mfaSmsEnrollment");
        this.f6040r = RecaptchaAction.custom("mfaSmsSignIn");
        this.f6023a = (a7.g) s.k(gVar);
        this.f6027e = (zzacq) s.k(zzacqVar);
        g1 g1Var2 = (g1) s.k(g1Var);
        this.f6041s = g1Var2;
        this.f6029g = new n7.f();
        l1 l1Var2 = (l1) s.k(l1Var);
        this.f6042t = l1Var2;
        this.f6043u = (d0) s.k(d0Var);
        this.f6044v = bVar;
        this.f6045w = bVar2;
        this.f6047y = executor2;
        this.f6048z = executor3;
        this.A = executor4;
        a0 a0VarC = g1Var2.c();
        this.f6028f = a0VarC;
        if (a0VarC != null && (zzahvVarA = g1Var2.a(a0VarC)) != null) {
            h0(this, this.f6028f, zzahvVarA, false, false);
        }
        l1Var2.b(this);
    }
}
