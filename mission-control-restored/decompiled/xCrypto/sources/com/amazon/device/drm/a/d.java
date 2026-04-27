package com.amazon.device.drm.a;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.amazon.device.drm.LicensingListener;
import com.amazon.device.drm.model.AppstoreSDKModes;
import com.amazon.device.drm.model.RequestId;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f9070a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f9071b = new d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f9072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f9073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LicensingListener f9074e;

    private d() {
    }

    public static d d() {
        return f9071b;
    }

    private void f() {
        if (this.f9074e == null) {
            throw new IllegalStateException("You must register a PurchasingListener before invoking this operation");
        }
    }

    private void g() {
        if (this.f9073d == null) {
            throw new IllegalStateException("You must register a ApplicationContext before invoking this operation");
        }
    }

    public void a(Context context, LicensingListener licensingListener) {
        if (licensingListener == null || context == null) {
            throw new IllegalArgumentException("LicensingManager/Context cannot be null");
        }
        com.amazon.device.drm.a.e.b.a(f9070a, "LicensingListener registered: " + licensingListener);
        com.amazon.device.drm.a.e.b.a(f9070a, "LicensingListener Context: " + context);
        this.f9073d = context.getApplicationContext();
        this.f9074e = licensingListener;
        c cVarA = a.a().a(this.f9073d);
        this.f9072c = cVarA;
        if (cVarA == null) {
            com.amazon.device.drm.a.e.b.a(f9070a, "requestHandler is null");
        }
    }

    public LicensingListener b() {
        return this.f9074e;
    }

    public Context c() {
        return this.f9073d;
    }

    public RequestId e() {
        f();
        RequestId requestId = new RequestId();
        this.f9072c.a(requestId);
        return requestId;
    }

    public String a() {
        try {
            g();
            if (com.amazon.a.a.a((Application) this.f9073d.getApplicationContext())) {
                return AppstoreSDKModes.SANDBOX.name();
            }
            return AppstoreSDKModes.PRODUCTION.name();
        } catch (IllegalStateException unused) {
            return AppstoreSDKModes.UNKNOWN.name();
        }
    }

    public void a(Context context, Intent intent) {
        try {
            this.f9072c.a(context, intent);
        } catch (Exception e4) {
            com.amazon.device.drm.a.e.b.b(f9070a, "Error in onReceive: " + e4);
        }
    }
}
