package com.revenuecat.purchases.amazon.handler;

import W2.E;
import X2.L;
import X2.x;
import android.os.Handler;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.RequestId;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.amazon.AmazonStrings;
import com.revenuecat.purchases.amazon.PurchasingServiceProvider;
import com.revenuecat.purchases.amazon.StoreProductConversionsKt;
import com.revenuecat.purchases.amazon.listener.ProductDataResponseListener;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.StoreProduct;
import i3.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class ProductDataHandler implements ProductDataResponseListener {
    public static final Companion Companion = new Companion(null);
    private static final long GET_PRODUCT_DATA_TIMEOUT_MILLIS = 10000;
    private final Handler mainHandler;
    private final Map<String, Product> productDataCache;
    private final Map<RequestId, Request> productDataRequests;
    private final PurchasingServiceProvider purchasingServiceProvider;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        private Companion() {
        }
    }

    public static final class Request {
        private final String marketplace;
        private final k onError;
        private final k onReceive;
        private final List<String> skuList;

        public Request(List<String> skuList, String marketplace, k onReceive, k onError) {
            r.f(skuList, "skuList");
            r.f(marketplace, "marketplace");
            r.f(onReceive, "onReceive");
            r.f(onError, "onError");
            this.skuList = skuList;
            this.marketplace = marketplace;
            this.onReceive = onReceive;
            this.onError = onError;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Request copy$default(Request request, List list, String str, k kVar, k kVar2, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                list = request.skuList;
            }
            if ((i4 & 2) != 0) {
                str = request.marketplace;
            }
            if ((i4 & 4) != 0) {
                kVar = request.onReceive;
            }
            if ((i4 & 8) != 0) {
                kVar2 = request.onError;
            }
            return request.copy(list, str, kVar, kVar2);
        }

        public final List<String> component1() {
            return this.skuList;
        }

        public final String component2() {
            return this.marketplace;
        }

        public final k component3() {
            return this.onReceive;
        }

        public final k component4() {
            return this.onError;
        }

        public final Request copy(List<String> skuList, String marketplace, k onReceive, k onError) {
            r.f(skuList, "skuList");
            r.f(marketplace, "marketplace");
            r.f(onReceive, "onReceive");
            r.f(onError, "onError");
            return new Request(skuList, marketplace, onReceive, onError);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Request)) {
                return false;
            }
            Request request = (Request) obj;
            return r.b(this.skuList, request.skuList) && r.b(this.marketplace, request.marketplace) && r.b(this.onReceive, request.onReceive) && r.b(this.onError, request.onError);
        }

        public final String getMarketplace() {
            return this.marketplace;
        }

        public final k getOnError() {
            return this.onError;
        }

        public final k getOnReceive() {
            return this.onReceive;
        }

        public final List<String> getSkuList() {
            return this.skuList;
        }

        public int hashCode() {
            return (((((this.skuList.hashCode() * 31) + this.marketplace.hashCode()) * 31) + this.onReceive.hashCode()) * 31) + this.onError.hashCode();
        }

        public String toString() {
            return "Request(skuList=" + this.skuList + ", marketplace=" + this.marketplace + ", onReceive=" + this.onReceive + ", onError=" + this.onError + ')';
        }
    }

    public ProductDataHandler(PurchasingServiceProvider purchasingServiceProvider, Handler mainHandler) {
        r.f(purchasingServiceProvider, "purchasingServiceProvider");
        r.f(mainHandler, "mainHandler");
        this.purchasingServiceProvider = purchasingServiceProvider;
        this.mainHandler = mainHandler;
        this.productDataRequests = new LinkedHashMap();
        this.productDataCache = new LinkedHashMap();
    }

    private final void addTimeoutToProductDataRequest(final RequestId requestId) {
        this.mainHandler.postDelayed(new Runnable() { // from class: com.revenuecat.purchases.amazon.handler.a
            @Override // java.lang.Runnable
            public final void run() {
                ProductDataHandler.addTimeoutToProductDataRequest$lambda$12(this.f11284a, requestId);
            }
        }, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addTimeoutToProductDataRequest$lambda$12(ProductDataHandler this$0, RequestId requestId) {
        r.f(this$0, "this$0");
        r.f(requestId, "$requestId");
        Request request = this$0.getRequest(requestId);
        if (request == null) {
            return;
        }
        PurchasesErrorCode purchasesErrorCode = PurchasesErrorCode.UnknownError;
        String str = String.format(AmazonStrings.ERROR_TIMEOUT_GETTING_PRODUCT_DATA, Arrays.copyOf(new Object[]{request.getSkuList().toString()}, 1));
        r.e(str, "format(this, *args)");
        request.getOnError().invoke(new PurchasesError(purchasesErrorCode, str));
    }

    private final synchronized Request getRequest(RequestId requestId) {
        return this.productDataRequests.remove(requestId);
    }

    private final void handleSuccessfulProductDataResponse(Map<String, Product> map, String str, k kVar) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        ProductDataHandler$handleSuccessfulProductDataResponse$$inlined$log$1 productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$1 = new ProductDataHandler$handleSuccessfulProductDataResponse$$inlined$log$1(logIntent, map);
        int[] iArr = LogWrapperKt.WhenMappings.$EnumSwitchMapping$0;
        switch (iArr[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$1.invoke(), null);
                break;
        }
        if (map.isEmpty()) {
            ProductDataHandler$handleSuccessfulProductDataResponse$$inlined$log$2 productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$2 = new ProductDataHandler$handleSuccessfulProductDataResponse$$inlined$log$2(logIntent);
            switch (iArr[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel10 = LogLevel.DEBUG;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler7.d("[Purchases] - " + logLevel10.name(), (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$2.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$2.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel11 = LogLevel.WARN;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                        currentLogHandler8.w("[Purchases] - " + logLevel11.name(), (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$2.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel12 = LogLevel.INFO;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                        currentLogHandler9.i("[Purchases] - " + logLevel12.name(), (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$2.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel13 = LogLevel.DEBUG;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                        currentLogHandler10.d("[Purchases] - " + logLevel13.name(), (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$2.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$2.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel14 = LogLevel.INFO;
                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                        currentLogHandler11.i("[Purchases] - " + logLevel14.name(), (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$2.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel15 = LogLevel.DEBUG;
                    LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                        currentLogHandler12.d("[Purchases] - " + logLevel15.name(), (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$2.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel16 = LogLevel.DEBUG;
                    LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                        currentLogHandler13.d("[Purchases] - " + logLevel16.name(), (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$2.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel17 = LogLevel.WARN;
                    LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                        currentLogHandler14.w("[Purchases] - " + logLevel17.name(), (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$2.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel18 = LogLevel.WARN;
                    LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                        currentLogHandler15.w("[Purchases] - " + logLevel18.name(), (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$2.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) productDataHandler$handleSuccessfulProductDataResponse$$inlined$log$2.invoke(), null);
                    break;
            }
        }
        Collection<Product> collectionValues = map.values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            StoreProduct storeProduct = StoreProductConversionsKt.toStoreProduct((Product) it.next(), str);
            if (storeProduct != null) {
                arrayList.add(storeProduct);
            }
        }
        kVar.invoke(arrayList);
    }

    private final void handleUnsuccessfulProductDataResponse(ProductDataResponse productDataResponse, k kVar) {
        kVar.invoke(new PurchasesError(PurchasesErrorCode.StoreProblemError, productDataResponse.getRequestStatus() == ProductDataResponse.RequestStatus.NOT_SUPPORTED ? "Couldn't fetch product data, since it's not supported." : "Error when fetching product data."));
    }

    @Override // com.revenuecat.purchases.amazon.listener.ProductDataResponseListener
    public void getProductData(Set<String> skus, String marketplace, k onReceive, k onError) {
        Map mapQ;
        LogHandler currentLogHandler;
        String str;
        String str2;
        r.f(skus, "skus");
        r.f(marketplace, "marketplace");
        r.f(onReceive, "onReceive");
        r.f(onError, "onError");
        LogIntent logIntent = LogIntent.DEBUG;
        ProductDataHandler$getProductData$$inlined$log$1 productDataHandler$getProductData$$inlined$log$1 = new ProductDataHandler$getProductData$$inlined$log$1(logIntent, skus);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) productDataHandler$getProductData$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) productDataHandler$getProductData$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) productDataHandler$getProductData$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) productDataHandler$getProductData$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) productDataHandler$getProductData$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) productDataHandler$getProductData$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) productDataHandler$getProductData$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) productDataHandler$getProductData$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) productDataHandler$getProductData$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) productDataHandler$getProductData$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) productDataHandler$getProductData$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) productDataHandler$getProductData$$inlined$log$1.invoke(), null);
                break;
        }
        synchronized (this) {
            mapQ = L.q(this.productDataCache);
        }
        if (!mapQ.keySet().containsAll(skus)) {
            RequestId productData = this.purchasingServiceProvider.getProductData(skus);
            Request request = new Request(x.g0(skus), marketplace, onReceive, onError);
            synchronized (this) {
                this.productDataRequests.put(productData, request);
                addTimeoutToProductDataRequest(productData);
                E e4 = E.f5463a;
            }
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapQ.entrySet()) {
            if (skus.contains((String) entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        handleSuccessfulProductDataResponse(linkedHashMap, marketplace, onReceive);
    }

    public final synchronized Map<String, Product> getProductDataCache$purchases_defaultsRelease() {
        return this.productDataCache;
    }

    @Override // com.amazon.device.iap.PurchasingListener, com.revenuecat.purchases.amazon.listener.PurchaseResponseListener, com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener, com.revenuecat.purchases.amazon.listener.UserDataResponseListener
    public void onProductDataResponse(ProductDataResponse response) throws Exception {
        LogHandler currentLogHandler;
        String str;
        String str2;
        r.f(response, "response");
        try {
            LogIntent logIntent = LogIntent.DEBUG;
            ProductDataHandler$onProductDataResponse$$inlined$log$1 productDataHandler$onProductDataResponse$$inlined$log$1 = new ProductDataHandler$onProductDataResponse$$inlined$log$1(logIntent, response);
            int[] iArr = LogWrapperKt.WhenMappings.$EnumSwitchMapping$0;
            switch (iArr[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) productDataHandler$onProductDataResponse$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) productDataHandler$onProductDataResponse$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) productDataHandler$onProductDataResponse$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) productDataHandler$onProductDataResponse$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) productDataHandler$onProductDataResponse$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) productDataHandler$onProductDataResponse$$inlined$log$1.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) productDataHandler$onProductDataResponse$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) productDataHandler$onProductDataResponse$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) productDataHandler$onProductDataResponse$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) productDataHandler$onProductDataResponse$$inlined$log$1.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) productDataHandler$onProductDataResponse$$inlined$log$1.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) productDataHandler$onProductDataResponse$$inlined$log$1.invoke(), null);
                    break;
            }
            Set<String> unavailableSkus = response.getUnavailableSkus();
            r.e(unavailableSkus, "response.unavailableSkus");
            if (!unavailableSkus.isEmpty()) {
                ProductDataHandler$onProductDataResponse$$inlined$log$2 productDataHandler$onProductDataResponse$$inlined$log$2 = new ProductDataHandler$onProductDataResponse$$inlined$log$2(logIntent, response);
                switch (iArr[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel10 = LogLevel.DEBUG;
                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                            currentLogHandler7.d("[Purchases] - " + logLevel10.name(), (String) productDataHandler$onProductDataResponse$$inlined$log$2.invoke());
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) productDataHandler$onProductDataResponse$$inlined$log$2.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel11 = LogLevel.WARN;
                        LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                            currentLogHandler8.w("[Purchases] - " + logLevel11.name(), (String) productDataHandler$onProductDataResponse$$inlined$log$2.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel12 = LogLevel.INFO;
                        LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                            currentLogHandler9.i("[Purchases] - " + logLevel12.name(), (String) productDataHandler$onProductDataResponse$$inlined$log$2.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel13 = LogLevel.DEBUG;
                        LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                            currentLogHandler10.d("[Purchases] - " + logLevel13.name(), (String) productDataHandler$onProductDataResponse$$inlined$log$2.invoke());
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) productDataHandler$onProductDataResponse$$inlined$log$2.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel14 = LogLevel.INFO;
                        LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                            currentLogHandler11.i("[Purchases] - " + logLevel14.name(), (String) productDataHandler$onProductDataResponse$$inlined$log$2.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel15 = LogLevel.DEBUG;
                        LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                            currentLogHandler12.d("[Purchases] - " + logLevel15.name(), (String) productDataHandler$onProductDataResponse$$inlined$log$2.invoke());
                        }
                        break;
                    case 9:
                        LogLevel logLevel16 = LogLevel.DEBUG;
                        LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                            currentLogHandler13.d("[Purchases] - " + logLevel16.name(), (String) productDataHandler$onProductDataResponse$$inlined$log$2.invoke());
                        }
                        break;
                    case 10:
                        LogLevel logLevel17 = LogLevel.WARN;
                        LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                            currentLogHandler14.w("[Purchases] - " + logLevel17.name(), (String) productDataHandler$onProductDataResponse$$inlined$log$2.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel18 = LogLevel.WARN;
                        LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                            currentLogHandler15.w("[Purchases] - " + logLevel18.name(), (String) productDataHandler$onProductDataResponse$$inlined$log$2.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) productDataHandler$onProductDataResponse$$inlined$log$2.invoke(), null);
                        break;
                }
            }
            RequestId requestId = response.getRequestId();
            r.e(requestId, "requestId");
            Request request = getRequest(requestId);
            if (request == null) {
                return;
            }
            if (response.getRequestStatus() != ProductDataResponse.RequestStatus.SUCCESSFUL) {
                handleUnsuccessfulProductDataResponse(response, request.getOnError());
                return;
            }
            synchronized (this) {
                Map<String, Product> map = this.productDataCache;
                Map<String, Product> productData = response.getProductData();
                r.e(productData, "response.productData");
                map.putAll(productData);
                E e4 = E.f5463a;
            }
            Map<String, Product> productData2 = response.getProductData();
            r.e(productData2, "response.productData");
            handleSuccessfulProductDataResponse(productData2, request.getMarketplace(), request.getOnReceive());
        } catch (Exception e5) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Exception in onProductDataResponse", e5);
            throw e5;
        }
    }
}
