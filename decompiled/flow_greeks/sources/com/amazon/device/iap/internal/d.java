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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f5010a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f5011b = "sku";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static d f5012c = new d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e f5013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f5014e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PurchasingListener f5015f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f5016g = false;

    private d() {
    }

    public static d f() {
        return f5012c;
    }

    private void g() {
        if (this.f5015f == null) {
            throw new IllegalStateException("You must register a PurchasingListener before invoking this operation");
        }
    }

    public PurchasingListener a() {
        return this.f5015f;
    }

    public Context b() {
        return this.f5014e;
    }

    public void c() {
        this.f5016g = true;
    }

    public boolean d() {
        return this.f5016g;
    }

    public boolean e() {
        g();
        return com.amazon.a.a.a((Application) this.f5014e.getApplicationContext());
    }

    public void a(Context context, PurchasingListener purchasingListener) {
        com.amazon.device.iap.internal.util.b.a(f5010a, "PurchasingListener registered: " + purchasingListener);
        com.amazon.device.iap.internal.util.b.a(f5010a, "PurchasingListener Context: " + context);
        if (purchasingListener == null || context == null) {
            throw new IllegalArgumentException("Neither PurchasingListener or its Context can be null");
        }
        this.f5014e = context.getApplicationContext();
        e eVarA = b.a().a(this.f5014e);
        this.f5013d = eVarA;
        if (eVarA == null) {
            com.amazon.device.iap.internal.util.b.a(f5010a, "requestHandler is null");
        }
        this.f5015f = purchasingListener;
    }

    public RequestId a(UserDataRequest userDataRequest) {
        g();
        RequestId requestId = new RequestId();
        this.f5013d.a(requestId, userDataRequest);
        return requestId;
    }

    public RequestId a(String str) {
        f.a((Object) str, f5011b);
        g();
        RequestId requestId = new RequestId();
        this.f5013d.a(requestId, str);
        return requestId;
    }

    public RequestId a(Set<String> set) {
        f.a((Object) set, com.amazon.a.a.o.b.O);
        f.a((Collection<? extends Object>) set, com.amazon.a.a.o.b.O);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (it.next().trim().length() == 0) {
                throw new IllegalArgumentException("Empty SKU values are not allowed");
            }
        }
        if (set.size() <= 100) {
            g();
            RequestId requestId = new RequestId();
            this.f5013d.a(requestId, new LinkedHashSet(set));
            return requestId;
        }
        throw new IllegalArgumentException(set.size() + " SKUs were provided, but no more than 100 SKUs are allowed");
    }

    public RequestId a(boolean z10) {
        g();
        RequestId requestId = new RequestId();
        this.f5013d.a(requestId, z10);
        return requestId;
    }

    public void a(String str, FulfillmentResult fulfillmentResult) {
        if (!f.a(str)) {
            f.a(fulfillmentResult, "fulfillmentResult");
            g();
            this.f5013d.a(new RequestId(), str, fulfillmentResult);
            return;
        }
        throw new IllegalArgumentException("Empty receiptId is not allowed");
    }

    public void a(Context context, Intent intent) {
        try {
            this.f5013d.a(context, intent);
        } catch (Exception e10) {
            com.amazon.device.iap.internal.util.b.b(f5010a, "Error in onReceive: " + e10);
        }
    }
}
