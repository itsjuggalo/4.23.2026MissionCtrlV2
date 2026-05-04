package com.google.firebase.auth;

import android.app.Activity;
import com.google.android.gms.common.internal.s;
import com.google.firebase.auth.b;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import m7.l0;
import m7.r0;
import n7.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FirebaseAuth f6051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f6052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b.AbstractC0100b f6053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Executor f6054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f6055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Activity f6056f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b.a f6057g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l0 f6058h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public r0 f6059i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6060j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6061k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6062l;

    /* JADX INFO: renamed from: com.google.firebase.auth.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0099a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FirebaseAuth f6063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f6064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f6065c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public b.AbstractC0100b f6066d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Executor f6067e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Activity f6068f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public b.a f6069g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public l0 f6070h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public r0 f6071i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f6072j;

        public C0099a(FirebaseAuth firebaseAuth) {
            this.f6063a = (FirebaseAuth) s.k(firebaseAuth);
        }

        public final a a() {
            s.l(this.f6063a, "FirebaseAuth instance cannot be null");
            s.l(this.f6065c, "You must specify an auto-retrieval timeout; please call #setTimeout()");
            s.l(this.f6066d, "You must specify callbacks on your PhoneAuthOptions. Please call #setCallbacks()");
            this.f6067e = this.f6063a.A;
            if (this.f6065c.longValue() < 0 || this.f6065c.longValue() > 120) {
                throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
            }
            l0 l0Var = this.f6070h;
            if (l0Var == null) {
                s.f(this.f6064b, "The given phoneNumber is empty. Please set a non-empty phone number with #setPhoneNumber()");
                s.b(!this.f6072j, "You cannot require sms validation without setting a multi-factor session.");
                s.b(this.f6071i == null, "A phoneMultiFactorInfo must be set for second factor sign-in.");
            } else if (l0Var == null || !((p) l0Var).V()) {
                s.b(this.f6071i != null, "A phoneMultiFactorInfo must be set for second factor sign-in.");
                s.b(this.f6064b == null, "A phone number must not be set for MFA sign-in. A PhoneMultiFactorInfo should be set instead.");
            } else {
                s.e(this.f6064b);
                s.b(this.f6071i == null, "Invalid MultiFactorSession - use the getSession method in MultiFactorResolver to get a valid sign-in session.");
            }
            return new a(this.f6063a, this.f6065c, this.f6066d, this.f6067e, this.f6064b, this.f6068f, this.f6069g, this.f6070h, this.f6071i, this.f6072j);
        }

        public final C0099a b(Activity activity) {
            this.f6068f = activity;
            return this;
        }

        public final C0099a c(b.AbstractC0100b abstractC0100b) {
            this.f6066d = abstractC0100b;
            return this;
        }

        public final C0099a d(b.a aVar) {
            this.f6069g = aVar;
            return this;
        }

        public final C0099a e(r0 r0Var) {
            this.f6071i = r0Var;
            return this;
        }

        public final C0099a f(l0 l0Var) {
            this.f6070h = l0Var;
            return this;
        }

        public final C0099a g(String str) {
            this.f6064b = str;
            return this;
        }

        public final C0099a h(Long l10, TimeUnit timeUnit) {
            this.f6065c = Long.valueOf(TimeUnit.SECONDS.convert(l10.longValue(), timeUnit));
            return this;
        }
    }

    public final Activity a() {
        return this.f6056f;
    }

    public final void b(boolean z10) {
        this.f6061k = true;
    }

    public final FirebaseAuth c() {
        return this.f6051a;
    }

    public final void d(boolean z10) {
        this.f6062l = true;
    }

    public final l0 e() {
        return this.f6058h;
    }

    public final b.a f() {
        return this.f6057g;
    }

    public final b.AbstractC0100b g() {
        return this.f6053c;
    }

    public final r0 h() {
        return this.f6059i;
    }

    public final Long i() {
        return this.f6052b;
    }

    public final String j() {
        return this.f6055e;
    }

    public final Executor k() {
        return this.f6054d;
    }

    public final boolean l() {
        return this.f6061k;
    }

    public final boolean m() {
        return this.f6060j;
    }

    public final boolean n() {
        return this.f6062l;
    }

    public final boolean o() {
        return this.f6058h != null;
    }

    public a(FirebaseAuth firebaseAuth, Long l10, b.AbstractC0100b abstractC0100b, Executor executor, String str, Activity activity, b.a aVar, l0 l0Var, r0 r0Var, boolean z10) {
        this.f6051a = firebaseAuth;
        this.f6055e = str;
        this.f6052b = l10;
        this.f6053c = abstractC0100b;
        this.f6056f = activity;
        this.f6054d = executor;
        this.f6057g = aVar;
        this.f6058h = l0Var;
        this.f6059i = r0Var;
        this.f6060j = z10;
    }
}
