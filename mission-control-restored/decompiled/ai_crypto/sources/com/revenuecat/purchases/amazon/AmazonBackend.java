package com.revenuecat.purchases.amazon;

import E5.E;
import E5.o;
import E5.t;
import F5.AbstractC0556n;
import Q5.k;
import com.revenuecat.purchases.common.BackendHelper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class AmazonBackend {
    private final BackendHelper backendHelper;
    private volatile Map<List<String>, List<o>> postAmazonReceiptCallbacks;

    public AmazonBackend(BackendHelper backendHelper) {
        r.f(backendHelper, "backendHelper");
        this.backendHelper = backendHelper;
        this.postAmazonReceiptCallbacks = new LinkedHashMap();
    }

    public final void getAmazonReceiptData(String receiptId, String storeUserID, k onSuccess, k onError) {
        r.f(receiptId, "receiptId");
        r.f(storeUserID, "storeUserID");
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        List<String> listL = AbstractC0556n.l(receiptId, storeUserID);
        AmazonBackend$getAmazonReceiptData$call$1 amazonBackend$getAmazonReceiptData$call$1 = new AmazonBackend$getAmazonReceiptData$call$1(this, storeUserID, receiptId, listL);
        o oVarA = t.a(onSuccess, onError);
        synchronized (this) {
            try {
                if (this.postAmazonReceiptCallbacks.containsKey(listL)) {
                    List<o> list = this.postAmazonReceiptCallbacks.get(listL);
                    r.c(list);
                    list.add(oVarA);
                } else {
                    this.postAmazonReceiptCallbacks.put(listL, AbstractC0556n.m(oVarA));
                    amazonBackend$getAmazonReceiptData$call$1.invoke();
                    E e7 = E.f1657a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized Map<List<String>, List<o>> getPostAmazonReceiptCallbacks() {
        return this.postAmazonReceiptCallbacks;
    }

    public final synchronized void setPostAmazonReceiptCallbacks(Map<List<String>, List<o>> map) {
        r.f(map, "<set-?>");
        this.postAmazonReceiptCallbacks = map;
    }
}
