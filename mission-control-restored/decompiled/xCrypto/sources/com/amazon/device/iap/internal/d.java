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
    private static String f9234a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f9235b = "sku";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static d f9236c = new d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e f9237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f9238e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PurchasingListener f9239f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f9240g = false;

    private d() {
    }

    public static d f() {
        return f9236c;
    }

    private void g() {
        if (this.f9239f == null) {
            throw new IllegalStateException("You must register a PurchasingListener before invoking this operation");
        }
    }

    public PurchasingListener a() {
        return this.f9239f;
    }

    public Context b() {
        return this.f9238e;
    }

    public void c() {
        this.f9240g = true;
    }

    public boolean d() {
        return this.f9240g;
    }

    public boolean e() {
        g();
        return com.amazon.a.a.a((Application) this.f9238e.getApplicationContext());
    }

    public void a(Context context, PurchasingListener purchasingListener) {
        com.amazon.device.iap.internal.util.b.a(f9234a, "PurchasingListener registered: " + purchasingListener);
        com.amazon.device.iap.internal.util.b.a(f9234a, "PurchasingListener Context: " + context);
        if (purchasingListener == null || context == null) {
            throw new IllegalArgumentException("Neither PurchasingListener or its Context can be null");
        }
        this.f9238e = context.getApplicationContext();
        e eVarA = b.a().a(this.f9238e);
        this.f9237d = eVarA;
        if (eVarA == null) {
            com.amazon.device.iap.internal.util.b.a(f9234a, "requestHandler is null");
        }
        this.f9239f = purchasingListener;
    }

    public RequestId a(UserDataRequest userDataRequest) {
        g();
        RequestId requestId = new RequestId();
        this.f9237d.a(requestId, userDataRequest);
        return requestId;
    }

    public RequestId a(String str) {
        f.a((Object) str, f9235b);
        g();
        RequestId requestId = new RequestId();
        this.f9237d.a(requestId, str);
        return requestId;
    }

    public RequestId a(Set<String> set) {
        f.a((Object) set, com.amazon.a.a.o.b.f8741O);
        f.a((Collection<? extends Object>) set, com.amazon.a.a.o.b.f8741O);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (it.next().trim().length() == 0) {
                throw new IllegalArgumentException("Empty SKU values are not allowed");
            }
        }
        if (set.size() <= 100) {
            g();
            RequestId requestId = new RequestId();
            this.f9237d.a(requestId, new LinkedHashSet(set));
            return requestId;
        }
        throw new IllegalArgumentException(set.size() + " SKUs were provided, but no more than 100 SKUs are allowed");
    }

    public RequestId a(boolean z4) {
        g();
        RequestId requestId = new RequestId();
        this.f9237d.a(requestId, z4);
        return requestId;
    }

    public void a(String str, FulfillmentResult fulfillmentResult) {
        if (!f.a(str)) {
            f.a(fulfillmentResult, "fulfillmentResult");
            g();
            this.f9237d.a(new RequestId(), str, fulfillmentResult);
            return;
        }
        throw new IllegalArgumentException("Empty receiptId is not allowed");
    }

    public void a(Context context, Intent intent) {
        try {
            this.f9237d.a(context, intent);
        } catch (Exception e4) {
            com.amazon.device.iap.internal.util.b.b(f9234a, "Error in onReceive: " + e4);
        }
    }
}
