package com.amazon.device.iap.internal.a;

import android.content.Context;
import android.os.Handler;
import com.amazon.a.a.n.a.h;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataResponse;

/* JADX INFO: loaded from: classes.dex */
public class c extends com.amazon.a.a.j.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f14405c = "c";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RequestId f14406d;

    public c(RequestId requestId) {
        this.f14406d = requestId;
    }

    @Override // com.amazon.a.a.j.a
    public com.amazon.a.a.j.b a() {
        return this.f13838a;
    }

    @Override // com.amazon.a.a.j.a
    public void b() {
    }

    @Override // com.amazon.a.a.j.a
    public void c() {
    }

    public RequestId d() {
        return this.f14406d;
    }

    public void e() {
        h hVar = this.f13839b;
        if (hVar != null) {
            hVar.l();
        } else {
            b();
        }
    }

    @Override // com.amazon.a.a.j.a
    public void a(h hVar) {
        this.f13839b = hVar;
    }

    public void a(Object obj) {
        a(obj, null);
    }

    public void a(final Object obj, final h hVar) {
        com.amazon.a.a.o.f.a(obj, "response");
        Context contextB = com.amazon.device.iap.internal.d.f().b();
        final PurchasingListener purchasingListenerA = com.amazon.device.iap.internal.d.f().a();
        if (contextB != null && purchasingListenerA != null) {
            new Handler(contextB.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.iap.internal.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.a().a(com.amazon.a.a.o.b.ao, Boolean.FALSE);
                    try {
                        Object obj2 = obj;
                        if (obj2 instanceof ProductDataResponse) {
                            purchasingListenerA.onProductDataResponse((ProductDataResponse) obj2);
                        } else if (obj2 instanceof UserDataResponse) {
                            purchasingListenerA.onUserDataResponse((UserDataResponse) obj2);
                        } else if (obj2 instanceof PurchaseUpdatesResponse) {
                            PurchaseUpdatesResponse purchaseUpdatesResponse = (PurchaseUpdatesResponse) obj2;
                            purchasingListenerA.onPurchaseUpdatesResponse(purchaseUpdatesResponse);
                            Object objA = c.this.a().a(com.amazon.a.a.o.b.ap);
                            if (objA != null && (objA instanceof String)) {
                                com.amazon.device.iap.internal.util.a.a(purchaseUpdatesResponse.getUserData().getUserId(), objA.toString());
                            }
                        } else if (obj2 instanceof PurchaseResponse) {
                            purchasingListenerA.onPurchaseResponse((PurchaseResponse) obj2);
                        } else {
                            com.amazon.device.iap.internal.util.b.b(c.f14405c, "Unknown response type:" + obj.getClass().getName());
                        }
                        c.this.a().a(com.amazon.a.a.o.b.ao, Boolean.TRUE);
                    } catch (Throwable th) {
                        com.amazon.device.iap.internal.util.b.b(c.f14405c, "Error in sendResponse: " + th);
                    }
                    h hVar2 = hVar;
                    if (hVar2 != null) {
                        hVar2.a(true);
                        hVar.l();
                    }
                }
            });
            return;
        }
        com.amazon.device.iap.internal.util.b.a(f14405c, "PurchasingListener is not set. Dropping response: " + obj);
    }
}
