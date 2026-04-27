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
    private static String f10255a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f10256b = new d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f10257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f10258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LicensingListener f10259e;

    private d() {
    }

    public static d d() {
        return f10256b;
    }

    private void f() {
        if (this.f10259e == null) {
            throw new IllegalStateException("You must register a PurchasingListener before invoking this operation");
        }
    }

    private void g() {
        if (this.f10258d == null) {
            throw new IllegalStateException("You must register a ApplicationContext before invoking this operation");
        }
    }

    public void a(Context context, LicensingListener licensingListener) {
        if (licensingListener == null || context == null) {
            throw new IllegalArgumentException("LicensingManager/Context cannot be null");
        }
        com.amazon.device.drm.a.e.b.a(f10255a, "LicensingListener registered: " + licensingListener);
        com.amazon.device.drm.a.e.b.a(f10255a, "LicensingListener Context: " + context);
        this.f10258d = context.getApplicationContext();
        this.f10259e = licensingListener;
        c cVarA = a.a().a(this.f10258d);
        this.f10257c = cVarA;
        if (cVarA == null) {
            com.amazon.device.drm.a.e.b.a(f10255a, "requestHandler is null");
        }
    }

    public LicensingListener b() {
        return this.f10259e;
    }

    public Context c() {
        return this.f10258d;
    }

    public RequestId e() {
        f();
        RequestId requestId = new RequestId();
        this.f10257c.a(requestId);
        return requestId;
    }

    public String a() {
        try {
            g();
            if (com.amazon.a.a.a((Application) this.f10258d.getApplicationContext())) {
                return AppstoreSDKModes.SANDBOX.name();
            }
            return AppstoreSDKModes.PRODUCTION.name();
        } catch (IllegalStateException unused) {
            return AppstoreSDKModes.UNKNOWN.name();
        }
    }

    public void a(Context context, Intent intent) {
        try {
            this.f10257c.a(context, intent);
        } catch (Exception e7) {
            com.amazon.device.drm.a.e.b.b(f10255a, "Error in onReceive: " + e7);
        }
    }
}
