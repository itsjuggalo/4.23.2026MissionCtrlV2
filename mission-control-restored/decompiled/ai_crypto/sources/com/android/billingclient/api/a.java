package com.android.billingclient.api;

import Y0.A0;
import Y0.C0713a;
import Y0.C0723f;
import Y0.C0727h;
import Y0.C0728i;
import Y0.C0735p;
import Y0.C0736q;
import Y0.InterfaceC0715b;
import Y0.InterfaceC0717c;
import Y0.InterfaceC0721e;
import Y0.InterfaceC0725g;
import Y0.InterfaceC0729j;
import Y0.InterfaceC0731l;
import Y0.InterfaceC0732m;
import Y0.InterfaceC0733n;
import Y0.InterfaceC0734o;
import android.app.Activity;
import android.content.Context;
import com.android.billingclient.api.e;
import com.google.android.gms.internal.play_billing.zze;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.android.billingclient.api.a$a, reason: collision with other inner class name */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterfaceC0176a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile e f10558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f10559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile InterfaceC0734o f10560c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f10561d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile boolean f10562e;

        public /* synthetic */ b(Context context, A0 a02) {
            this.f10559b = context;
        }

        public a a() {
            if (this.f10559b == null) {
                throw new IllegalArgumentException("Please provide a valid Context.");
            }
            if (this.f10560c == null) {
                if (!this.f10561d && !this.f10562e) {
                    throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
                }
                Context context = this.f10559b;
                return e() ? new j(null, context, null, null) : new com.android.billingclient.api.b(null, context, null, null);
            }
            if (this.f10558a == null || !this.f10558a.a()) {
                throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
            }
            if (this.f10560c == null) {
                e eVar = this.f10558a;
                Context context2 = this.f10559b;
                return e() ? new j(null, eVar, context2, null, null, null) : new com.android.billingclient.api.b(null, eVar, context2, null, null, null);
            }
            e eVar2 = this.f10558a;
            Context context3 = this.f10559b;
            InterfaceC0734o interfaceC0734o = this.f10560c;
            return e() ? new j(null, eVar2, context3, interfaceC0734o, null, null, null) : new com.android.billingclient.api.b(null, eVar2, context3, interfaceC0734o, null, null, null);
        }

        public b b() {
            e.a aVarC = e.c();
            aVarC.b();
            c(aVarC.a());
            return this;
        }

        public b c(e eVar) {
            this.f10558a = eVar;
            return this;
        }

        public b d(InterfaceC0734o interfaceC0734o) {
            this.f10560c = interfaceC0734o;
            return this;
        }

        public final boolean e() {
            try {
                return this.f10559b.getPackageManager().getApplicationInfo(this.f10559b.getPackageName(), 128).metaData.getBoolean("com.google.android.play.billingclient.enableBillingOverridesTesting", false);
            } catch (Exception e7) {
                zze.zzm("BillingClient", "Unable to retrieve metadata value for enableBillingOverridesTesting.", e7);
                return false;
            }
        }
    }

    public static b h(Context context) {
        return new b(context, null);
    }

    public abstract void a(C0713a c0713a, InterfaceC0715b interfaceC0715b);

    public abstract void b(C0723f c0723f, InterfaceC0725g interfaceC0725g);

    public abstract void c();

    public abstract void d(C0727h c0727h, InterfaceC0721e interfaceC0721e);

    public abstract d e(String str);

    public abstract boolean f();

    public abstract d g(Activity activity, c cVar);

    public abstract void i(g gVar, InterfaceC0731l interfaceC0731l);

    public abstract void j(C0735p c0735p, InterfaceC0732m interfaceC0732m);

    public abstract void k(C0736q c0736q, InterfaceC0733n interfaceC0733n);

    public abstract d l(Activity activity, C0728i c0728i, InterfaceC0729j interfaceC0729j);

    public abstract void m(InterfaceC0717c interfaceC0717c);
}
