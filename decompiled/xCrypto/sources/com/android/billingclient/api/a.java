package com.android.billingclient.api;

import H0.A0;
import H0.C0292a;
import H0.C0302f;
import H0.C0306h;
import H0.C0307i;
import H0.C0314p;
import H0.C0315q;
import H0.InterfaceC0294b;
import H0.InterfaceC0296c;
import H0.InterfaceC0300e;
import H0.InterfaceC0304g;
import H0.InterfaceC0308j;
import H0.InterfaceC0310l;
import H0.InterfaceC0311m;
import H0.InterfaceC0312n;
import H0.InterfaceC0313o;
import android.app.Activity;
import android.content.Context;
import com.android.billingclient.api.e;
import com.google.android.gms.internal.play_billing.zze;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.android.billingclient.api.a$a, reason: collision with other inner class name */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterfaceC0143a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile e f9373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f9374b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile InterfaceC0313o f9375c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f9376d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile boolean f9377e;

        public /* synthetic */ b(Context context, A0 a02) {
            this.f9374b = context;
        }

        public a a() {
            if (this.f9374b == null) {
                throw new IllegalArgumentException("Please provide a valid Context.");
            }
            if (this.f9375c == null) {
                if (!this.f9376d && !this.f9377e) {
                    throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
                }
                Context context = this.f9374b;
                return e() ? new j(null, context, null, null) : new com.android.billingclient.api.b(null, context, null, null);
            }
            if (this.f9373a == null || !this.f9373a.a()) {
                throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
            }
            if (this.f9375c == null) {
                e eVar = this.f9373a;
                Context context2 = this.f9374b;
                return e() ? new j(null, eVar, context2, null, null, null) : new com.android.billingclient.api.b(null, eVar, context2, null, null, null);
            }
            e eVar2 = this.f9373a;
            Context context3 = this.f9374b;
            InterfaceC0313o interfaceC0313o = this.f9375c;
            return e() ? new j(null, eVar2, context3, interfaceC0313o, null, null, null) : new com.android.billingclient.api.b(null, eVar2, context3, interfaceC0313o, null, null, null);
        }

        public b b() {
            e.a aVarC = e.c();
            aVarC.b();
            c(aVarC.a());
            return this;
        }

        public b c(e eVar) {
            this.f9373a = eVar;
            return this;
        }

        public b d(InterfaceC0313o interfaceC0313o) {
            this.f9375c = interfaceC0313o;
            return this;
        }

        public final boolean e() {
            try {
                return this.f9374b.getPackageManager().getApplicationInfo(this.f9374b.getPackageName(), UserMetadata.MAX_ROLLOUT_ASSIGNMENTS).metaData.getBoolean("com.google.android.play.billingclient.enableBillingOverridesTesting", false);
            } catch (Exception e4) {
                zze.zzm("BillingClient", "Unable to retrieve metadata value for enableBillingOverridesTesting.", e4);
                return false;
            }
        }
    }

    public static b h(Context context) {
        return new b(context, null);
    }

    public abstract void a(C0292a c0292a, InterfaceC0294b interfaceC0294b);

    public abstract void b(C0302f c0302f, InterfaceC0304g interfaceC0304g);

    public abstract void c();

    public abstract void d(C0306h c0306h, InterfaceC0300e interfaceC0300e);

    public abstract d e(String str);

    public abstract boolean f();

    public abstract d g(Activity activity, c cVar);

    public abstract void i(g gVar, InterfaceC0310l interfaceC0310l);

    public abstract void j(C0314p c0314p, InterfaceC0311m interfaceC0311m);

    public abstract void k(C0315q c0315q, InterfaceC0312n interfaceC0312n);

    public abstract d l(Activity activity, C0307i c0307i, InterfaceC0308j interfaceC0308j);

    public abstract void m(InterfaceC0296c interfaceC0296c);
}
