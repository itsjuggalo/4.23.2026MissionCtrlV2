package com.revenuecat.purchases.common.offlineentitlements;

import com.revenuecat.purchases.common.HTTPResponseOriginalSource;
import com.revenuecat.purchases.common.HTTPResponseOriginalSourceKt;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import dd.n0;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB-\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u000e\u0010\u0012\u001a\u00020\u0007HÀ\u0003¢\u0006\u0002\b\u0013J\t\u0010\u0014\u001a\u00020\tHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping;", "", "mappings", "", "", "Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping$Mapping;", "originalSource", "Lcom/revenuecat/purchases/common/HTTPResponseOriginalSource;", "loadedFromCache", "", "(Ljava/util/Map;Lcom/revenuecat/purchases/common/HTTPResponseOriginalSource;Z)V", "getLoadedFromCache", "()Z", "getMappings", "()Ljava/util/Map;", "getOriginalSource$purchases_defaultsBc8Release", "()Lcom/revenuecat/purchases/common/HTTPResponseOriginalSource;", "component1", "component2", "component2$purchases_defaultsBc8Release", "component3", "copy", "equals", "other", "hashCode", "", "toJson", "Lorg/json/JSONObject;", "toString", "Companion", "Mapping", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ProductEntitlementMapping {
    private static final String BASE_PLAN_ID_KEY = "base_plan_id";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String ENTITLEMENTS_KEY = "entitlements";
    private static final String ORIGINAL_SOURCE_KEY = "rc_original_source";
    private static final String PRODUCT_ENTITLEMENT_MAPPING_KEY = "product_entitlement_mapping";
    private static final String PRODUCT_ID_KEY = "product_identifier";
    private final boolean loadedFromCache;
    private final Map<String, Mapping> mappings;
    private final HTTPResponseOriginalSource originalSource;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping$Companion;", "", "()V", "BASE_PLAN_ID_KEY", "", "ENTITLEMENTS_KEY", "ORIGINAL_SOURCE_KEY", "PRODUCT_ENTITLEMENT_MAPPING_KEY", "PRODUCT_ID_KEY", "fromJson", "Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping;", "json", "Lorg/json/JSONObject;", "loadedFromCache", "", "fromNetwork", "httpResult", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(k kVar) {
            this();
        }

        public static /* synthetic */ ProductEntitlementMapping fromJson$default(Companion companion, JSONObject jSONObject, boolean z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            return companion.fromJson(jSONObject, z10);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x009e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping fromJson(org.json.JSONObject r13, boolean r14) throws org.json.JSONException {
            /*
                r12 = this;
                java.lang.String r0 = "json"
                kotlin.jvm.internal.t.f(r13, r0)
                java.lang.String r0 = "product_entitlement_mapping"
                org.json.JSONObject r0 = r13.getJSONObject(r0)
                java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
                r1.<init>()
                java.util.Iterator r2 = r0.keys()
                java.lang.String r3 = "productsObject.keys()"
                kotlin.jvm.internal.t.e(r2, r3)
            L19:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto L6e
                java.lang.Object r3 = r2.next()
                java.lang.String r3 = (java.lang.String) r3
                org.json.JSONObject r4 = r0.getJSONObject(r3)
                java.lang.String r5 = "product_identifier"
                java.lang.String r5 = r4.getString(r5)
                java.lang.String r6 = "productObject"
                kotlin.jvm.internal.t.e(r4, r6)
                java.lang.String r6 = "base_plan_id"
                java.lang.String r6 = com.revenuecat.purchases.utils.JSONObjectExtensionsKt.optNullableString(r4, r6)
                java.lang.String r7 = "entitlements"
                org.json.JSONArray r4 = r4.getJSONArray(r7)
                java.util.ArrayList r7 = new java.util.ArrayList
                r7.<init>()
                int r8 = r4.length()
                r9 = 0
            L4a:
                if (r9 >= r8) goto L5b
                java.lang.String r10 = r4.getString(r9)
                java.lang.String r11 = "entitlementsArray.getString(entitlementIndex)"
                kotlin.jvm.internal.t.e(r10, r11)
                r7.add(r10)
                int r9 = r9 + 1
                goto L4a
            L5b:
                java.lang.String r4 = "mappingIdentifier"
                kotlin.jvm.internal.t.e(r3, r4)
                com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping$Mapping r4 = new com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping$Mapping
                java.lang.String r8 = "productIdentifier"
                kotlin.jvm.internal.t.e(r5, r8)
                r4.<init>(r5, r6, r7)
                r1.put(r3, r4)
                goto L19
            L6e:
                java.lang.String r0 = "rc_original_source"
                java.lang.String r13 = com.revenuecat.purchases.utils.JSONObjectExtensionsKt.optNullableString(r13, r0)
                if (r13 == 0) goto L9e
                com.revenuecat.purchases.common.HTTPResponseOriginalSource r13 = com.revenuecat.purchases.common.HTTPResponseOriginalSource.valueOf(r13)     // Catch: java.lang.IllegalArgumentException -> L7b
                goto L9c
            L7b:
                r0 = move-exception
                com.revenuecat.purchases.LogHandler r2 = com.revenuecat.purchases.common.LogWrapperKt.getCurrentLogHandler()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Invalid original source when reading it from JSON: "
                r3.append(r4)
                r3.append(r13)
                java.lang.String r13 = ". Defaulting to MAIN."
                r3.append(r13)
                java.lang.String r13 = r3.toString()
                java.lang.String r3 = "[Purchases] - ERROR"
                r2.e(r3, r13, r0)
                r13 = 0
            L9c:
                if (r13 != 0) goto La0
            L9e:
                com.revenuecat.purchases.common.HTTPResponseOriginalSource r13 = com.revenuecat.purchases.common.HTTPResponseOriginalSource.MAIN
            La0:
                com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping r0 = new com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping
                r0.<init>(r1, r13, r14)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping.Companion.fromJson(org.json.JSONObject, boolean):com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping");
        }

        public final ProductEntitlementMapping fromNetwork(JSONObject json, HTTPResult httpResult) throws JSONException {
            t.f(json, "json");
            t.f(httpResult, "httpResult");
            JSONObject jsonWithSource = JSONObjectExtensionsKt.copy(json, false).put("rc_original_source", HTTPResponseOriginalSourceKt.getOriginalDataSource(httpResult).name());
            t.e(jsonWithSource, "jsonWithSource");
            return fromJson(jsonWithSource, false);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J/\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping$Mapping;", "", "productIdentifier", "", "basePlanId", "entitlements", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getBasePlanId", "()Ljava/lang/String;", "getEntitlements", "()Ljava/util/List;", "getProductIdentifier", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Mapping {
        private final String basePlanId;
        private final List<String> entitlements;
        private final String productIdentifier;

        public Mapping(String productIdentifier, String str, List<String> entitlements) {
            t.f(productIdentifier, "productIdentifier");
            t.f(entitlements, "entitlements");
            this.productIdentifier = productIdentifier;
            this.basePlanId = str;
            this.entitlements = entitlements;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Mapping copy$default(Mapping mapping, String str, String str2, List list, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = mapping.productIdentifier;
            }
            if ((i10 & 2) != 0) {
                str2 = mapping.basePlanId;
            }
            if ((i10 & 4) != 0) {
                list = mapping.entitlements;
            }
            return mapping.copy(str, str2, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getProductIdentifier() {
            return this.productIdentifier;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getBasePlanId() {
            return this.basePlanId;
        }

        public final List<String> component3() {
            return this.entitlements;
        }

        public final Mapping copy(String productIdentifier, String basePlanId, List<String> entitlements) {
            t.f(productIdentifier, "productIdentifier");
            t.f(entitlements, "entitlements");
            return new Mapping(productIdentifier, basePlanId, entitlements);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Mapping)) {
                return false;
            }
            Mapping mapping = (Mapping) other;
            return t.b(this.productIdentifier, mapping.productIdentifier) && t.b(this.basePlanId, mapping.basePlanId) && t.b(this.entitlements, mapping.entitlements);
        }

        public final String getBasePlanId() {
            return this.basePlanId;
        }

        public final List<String> getEntitlements() {
            return this.entitlements;
        }

        public final String getProductIdentifier() {
            return this.productIdentifier;
        }

        public int hashCode() {
            int iHashCode = this.productIdentifier.hashCode() * 31;
            String str = this.basePlanId;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.entitlements.hashCode();
        }

        public String toString() {
            return "Mapping(productIdentifier=" + this.productIdentifier + ", basePlanId=" + this.basePlanId + ", entitlements=" + this.entitlements + ')';
        }
    }

    public ProductEntitlementMapping(Map<String, Mapping> mappings, HTTPResponseOriginalSource originalSource, boolean z10) {
        t.f(mappings, "mappings");
        t.f(originalSource, "originalSource");
        this.mappings = mappings;
        this.originalSource = originalSource;
        this.loadedFromCache = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProductEntitlementMapping copy$default(ProductEntitlementMapping productEntitlementMapping, Map map, HTTPResponseOriginalSource hTTPResponseOriginalSource, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            map = productEntitlementMapping.mappings;
        }
        if ((i10 & 2) != 0) {
            hTTPResponseOriginalSource = productEntitlementMapping.originalSource;
        }
        if ((i10 & 4) != 0) {
            z10 = productEntitlementMapping.loadedFromCache;
        }
        return productEntitlementMapping.copy(map, hTTPResponseOriginalSource, z10);
    }

    public final Map<String, Mapping> component1() {
        return this.mappings;
    }

    /* JADX INFO: renamed from: component2$purchases_defaultsBc8Release, reason: from getter */
    public final HTTPResponseOriginalSource getOriginalSource() {
        return this.originalSource;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getLoadedFromCache() {
        return this.loadedFromCache;
    }

    public final ProductEntitlementMapping copy(Map<String, Mapping> mappings, HTTPResponseOriginalSource originalSource, boolean loadedFromCache) {
        t.f(mappings, "mappings");
        t.f(originalSource, "originalSource");
        return new ProductEntitlementMapping(mappings, originalSource, loadedFromCache);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProductEntitlementMapping)) {
            return false;
        }
        ProductEntitlementMapping productEntitlementMapping = (ProductEntitlementMapping) other;
        return t.b(this.mappings, productEntitlementMapping.mappings) && this.originalSource == productEntitlementMapping.originalSource && this.loadedFromCache == productEntitlementMapping.loadedFromCache;
    }

    public final boolean getLoadedFromCache() {
        return this.loadedFromCache;
    }

    public final Map<String, Mapping> getMappings() {
        return this.mappings;
    }

    public final HTTPResponseOriginalSource getOriginalSource$purchases_defaultsBc8Release() {
        return this.originalSource;
    }

    public int hashCode() {
        return (((this.mappings.hashCode() * 31) + this.originalSource.hashCode()) * 31) + Boolean.hashCode(this.loadedFromCache);
    }

    public final JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Map<String, Mapping> map = this.mappings;
        LinkedHashMap linkedHashMap = new LinkedHashMap(n0.d(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Mapping mapping = (Mapping) entry.getValue();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("product_identifier", mapping.getProductIdentifier());
            String basePlanId = mapping.getBasePlanId();
            if (basePlanId != null) {
                jSONObject2.put(BASE_PLAN_ID_KEY, basePlanId);
            }
            jSONObject2.put("entitlements", new JSONArray((Collection) mapping.getEntitlements()));
            linkedHashMap.put(key, jSONObject2);
        }
        jSONObject.put(PRODUCT_ENTITLEMENT_MAPPING_KEY, new JSONObject(linkedHashMap));
        jSONObject.put("rc_original_source", this.originalSource.name());
        return jSONObject;
    }

    public String toString() {
        return "ProductEntitlementMapping(mappings=" + this.mappings + ", originalSource=" + this.originalSource + ", loadedFromCache=" + this.loadedFromCache + ')';
    }

    public /* synthetic */ ProductEntitlementMapping(Map map, HTTPResponseOriginalSource hTTPResponseOriginalSource, boolean z10, int i10, k kVar) {
        this(map, (i10 & 2) != 0 ? HTTPResponseOriginalSource.MAIN : hTTPResponseOriginalSource, (i10 & 4) != 0 ? false : z10);
    }
}
