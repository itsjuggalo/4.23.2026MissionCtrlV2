package com.amazon.device.drm.a;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.amazon.device.drm.LicensingListener;
import com.amazon.device.drm.model.AppstoreSDKModes;
import com.amazon.device.drm.model.RequestId;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f4864a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f4865b = new d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f4866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f4867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LicensingListener f4868e;

    private d() {
    }

    public static d d() {
        return f4865b;
    }

    private void f() {
        if (this.f4868e == null) {
            throw new IllegalStateException("You must register a PurchasingListener before invoking this operation");
        }
    }

    private void g() {
        if (this.f4867d == null) {
            throw new IllegalStateException("You must register a ApplicationContext before invoking this operation");
        }
    }

    public void a(Context context, LicensingListener licensingListener) {
        if (licensingListener == null || context == null) {
            throw new IllegalArgumentException("LicensingManager/Context cannot be null");
        }
        com.amazon.device.drm.a.e.b.a(f4864a, "LicensingListener registered: " + licensingListener);
        com.amazon.device.drm.a.e.b.a(f4864a, "LicensingListener Context: " + context);
        this.f4867d = context.getApplicationContext();
        this.f4868e = licensingListener;
        c cVarA = a.a().a(this.f4867d);
        this.f4866c = cVarA;
        if (cVarA == null) {
            com.amazon.device.drm.a.e.b.a(f4864a, "requestHandler is null");
        }
    }

    public LicensingListener b() {
        return this.f4868e;
    }

    public Context c() {
        return this.f4867d;
    }

    public RequestId e() {
        f();
        RequestId requestId = new RequestId();
        this.f4866c.a(requestId);
        return requestId;
    }

    public String a() {
        try {
            g();
            if (com.amazon.a.a.a((Application) this.f4867d.getApplicationContext())) {
                return AppstoreSDKModes.SANDBOX.name();
            }
            return AppstoreSDKModes.PRODUCTION.name();
        } catch (IllegalStateException unused) {
            return AppstoreSDKModes.UNKNOWN.name();
        }
    }

    public void a(Context context, Intent intent) {
        try {
            this.f4866c.a(context, intent);
        } catch (Exception e10) {
            com.amazon.device.drm.a.e.b.b(f4864a, "Error in onReceive: " + e10);
        }
    }
}
