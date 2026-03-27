package com.amazon.device.iap.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.amazon.a.a.o.f;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataRequest;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f14530a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f14531b = "sku";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static d f14532c = new d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e f14533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f14534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PurchasingListener f14535f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f14536g = false;

    private d() {
    }

    public static d f() {
        return f14532c;
    }

    private void g() {
        if (this.f14535f == null) {
            throw new IllegalStateException("You must register a PurchasingListener before invoking this operation");
        }
    }

    public PurchasingListener a() {
        return this.f14535f;
    }

    public Context b() {
        return this.f14534e;
    }

    public void c() {
        this.f14536g = true;
    }

    public boolean d() {
        return this.f14536g;
    }

    public boolean e() {
        g();
        return com.amazon.a.a.a((Application) this.f14534e.getApplicationContext());
    }

    public RequestId a(UserDataRequest userDataRequest) {
        g();
        RequestId requestId = new RequestId();
        this.f14533d.a(requestId, userDataRequest);
        return requestId;
    }

    public RequestId a(String str) {
        f.a((Object) str, f14531b);
        g();
        RequestId requestId = new RequestId();
        this.f14533d.a(requestId, str);
        return requestId;
    }

    public RequestId a(Set<String> set) {
        f.a((Object) set, com.amazon.a.a.o.b.f14037O);
        f.a((Collection<? extends Object>) set, com.amazon.a.a.o.b.f14037O);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (it.next().trim().length() == 0) {
                throw new IllegalArgumentException("Empty SKU values are not allowed");
            }
        }
        if (set.size() <= 100) {
            g();
            RequestId requestId = new RequestId();
            this.f14533d.a(requestId, new LinkedHashSet(set));
            return requestId;
        }
        throw new IllegalArgumentException(set.size() + " SKUs were provided, but no more than 100 SKUs are allowed");
    }

    public RequestId a(boolean z7) {
        g();
        RequestId requestId = new RequestId();
        this.f14533d.a(requestId, z7);
        return requestId;
    }

    public void a(Context context, Intent intent) {
        try {
            this.f14533d.a(context, intent);
        } catch (Exception e8) {
            com.amazon.device.iap.internal.util.b.b(f14530a, "Error in onReceive: " + e8);
        }
    }

    public void a(Context context, PurchasingListener purchasingListener) {
        com.amazon.device.iap.internal.util.b.a(f14530a, "PurchasingListener registered: " + purchasingListener);
        com.amazon.device.iap.internal.util.b.a(f14530a, "PurchasingListener Context: " + context);
        if (purchasingListener == null || context == null) {
            throw new IllegalArgumentException("Neither PurchasingListener or its Context can be null");
        }
        this.f14534e = context.getApplicationContext();
        e eVarA = b.a().a(this.f14534e);
        this.f14533d = eVarA;
        if (eVarA == null) {
            com.amazon.device.iap.internal.util.b.a(f14530a, "requestHandler is null");
        }
        this.f14535f = purchasingListener;
    }

    public void a(String str, FulfillmentResult fulfillmentResult) {
        if (f.a(str)) {
            throw new IllegalArgumentException("Empty receiptId is not allowed");
        }
        f.a(fulfillmentResult, "fulfillmentResult");
        g();
        this.f14533d.a(new RequestId(), str, fulfillmentResult);
    }
}
