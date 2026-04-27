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
    private static String f14366a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f14367b = new d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f14368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f14369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LicensingListener f14370e;

    private d() {
    }

    public static d d() {
        return f14367b;
    }

    private void f() {
        if (this.f14370e == null) {
            throw new IllegalStateException("You must register a PurchasingListener before invoking this operation");
        }
    }

    private void g() {
        if (this.f14369d == null) {
            throw new IllegalStateException("You must register a ApplicationContext before invoking this operation");
        }
    }

    public String a() {
        try {
            g();
            return (com.amazon.a.a.a((Application) this.f14369d.getApplicationContext()) ? AppstoreSDKModes.SANDBOX : AppstoreSDKModes.PRODUCTION).name();
        } catch (IllegalStateException unused) {
            return AppstoreSDKModes.UNKNOWN.name();
        }
    }

    public LicensingListener b() {
        return this.f14370e;
    }

    public Context c() {
        return this.f14369d;
    }

    public RequestId e() {
        f();
        RequestId requestId = new RequestId();
        this.f14368c.a(requestId);
        return requestId;
    }

    public void a(Context context, Intent intent) {
        try {
            this.f14368c.a(context, intent);
        } catch (Exception e8) {
            com.amazon.device.drm.a.e.b.b(f14366a, "Error in onReceive: " + e8);
        }
    }

    public void a(Context context, LicensingListener licensingListener) {
        if (licensingListener == null || context == null) {
            throw new IllegalArgumentException("LicensingManager/Context cannot be null");
        }
        com.amazon.device.drm.a.e.b.a(f14366a, "LicensingListener registered: " + licensingListener);
        com.amazon.device.drm.a.e.b.a(f14366a, "LicensingListener Context: " + context);
        this.f14369d = context.getApplicationContext();
        this.f14370e = licensingListener;
        c cVarA = a.a().a(this.f14369d);
        this.f14368c = cVarA;
        if (cVarA == null) {
            com.amazon.device.drm.a.e.b.a(f14366a, "requestHandler is null");
        }
    }
}
