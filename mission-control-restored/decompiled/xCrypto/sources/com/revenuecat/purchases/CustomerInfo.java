package com.revenuecat.purchases;

import W2.j;
import W2.k;
import W2.t;
import X2.AbstractC0770q;
import X2.K;
import X2.L;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.revenuecat.purchases.models.RawDataContainer;
import com.revenuecat.purchases.models.Transaction;
import com.revenuecat.purchases.utils.DateHelper;
import com.revenuecat.purchases.utils.JSONObjectParceler;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class CustomerInfo implements Parcelable, RawDataContainer<JSONObject> {
    public static final Parcelable.Creator<CustomerInfo> CREATOR = new Creator();
    private final j activeSubscriptions$delegate;
    private final Map<String, Date> allExpirationDatesByProduct;
    private final Map<String, Date> allPurchaseDatesByProduct;
    private final j allPurchasedProductIds$delegate;
    private final j allPurchasedSkus$delegate;
    private final EntitlementInfos entitlements;
    private final Date firstSeen;
    private final JSONObject jsonObject;
    private final j latestExpirationDate$delegate;
    private final Uri managementURL;
    private final j nonSubscriptionTransactions$delegate;
    private final String originalAppUserId;
    private final Date originalPurchaseDate;
    private final Date requestDate;
    private final int schemaVersion;
    private final JSONObject subscriberJSONObject;
    private final j subscriptionsByProductIdentifier$delegate;

    public static final class Creator implements Parcelable.Creator<CustomerInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CustomerInfo createFromParcel(Parcel parcel) {
            r.f(parcel, "parcel");
            EntitlementInfos entitlementInfosCreateFromParcel = EntitlementInfos.CREATOR.createFromParcel(parcel);
            int i4 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i4);
            for (int i5 = 0; i5 != i4; i5++) {
                linkedHashMap.put(parcel.readString(), parcel.readSerializable());
            }
            int i6 = parcel.readInt();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(i6);
            for (int i7 = 0; i7 != i6; i7++) {
                linkedHashMap2.put(parcel.readString(), parcel.readSerializable());
            }
            return new CustomerInfo(entitlementInfosCreateFromParcel, linkedHashMap, linkedHashMap2, (Date) parcel.readSerializable(), parcel.readInt(), (Date) parcel.readSerializable(), parcel.readString(), (Uri) parcel.readParcelable(CustomerInfo.class.getClassLoader()), (Date) parcel.readSerializable(), JSONObjectParceler.INSTANCE.create(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CustomerInfo[] newArray(int i4) {
            return new CustomerInfo[i4];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomerInfo(EntitlementInfos entitlements, Map<String, ? extends Date> allExpirationDatesByProduct, Map<String, ? extends Date> allPurchaseDatesByProduct, Date requestDate, int i4, Date firstSeen, String originalAppUserId, Uri uri, Date date, JSONObject jsonObject) {
        r.f(entitlements, "entitlements");
        r.f(allExpirationDatesByProduct, "allExpirationDatesByProduct");
        r.f(allPurchaseDatesByProduct, "allPurchaseDatesByProduct");
        r.f(requestDate, "requestDate");
        r.f(firstSeen, "firstSeen");
        r.f(originalAppUserId, "originalAppUserId");
        r.f(jsonObject, "jsonObject");
        this.entitlements = entitlements;
        this.allExpirationDatesByProduct = allExpirationDatesByProduct;
        this.allPurchaseDatesByProduct = allPurchaseDatesByProduct;
        this.requestDate = requestDate;
        this.schemaVersion = i4;
        this.firstSeen = firstSeen;
        this.originalAppUserId = originalAppUserId;
        this.managementURL = uri;
        this.originalPurchaseDate = date;
        this.jsonObject = jsonObject;
        this.activeSubscriptions$delegate = k.b(new CustomerInfo$activeSubscriptions$2(this));
        this.allPurchasedSkus$delegate = k.b(new CustomerInfo$allPurchasedSkus$2(this));
        this.allPurchasedProductIds$delegate = k.b(new CustomerInfo$allPurchasedProductIds$2(this));
        this.latestExpirationDate$delegate = k.b(new CustomerInfo$latestExpirationDate$2(this));
        this.nonSubscriptionTransactions$delegate = k.b(new CustomerInfo$nonSubscriptionTransactions$2(this));
        this.subscriptionsByProductIdentifier$delegate = k.b(new CustomerInfo$subscriptionsByProductIdentifier$2(this));
        this.subscriberJSONObject = jsonObject.getJSONObject(CustomerInfoResponseJsonKeys.SUBSCRIBER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<String> activeIdentifiers(Map<String, ? extends Date> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends Date> entry : map.entrySet()) {
            if (DateHelper.Companion.m215isDateActiveSxA4cEA$default(DateHelper.Companion, entry.getValue(), this.requestDate, 0L, 4, null).isActive()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap.keySet();
    }

    private final JSONObject component10() {
        return this.jsonObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomerInfo copy$default(CustomerInfo customerInfo, EntitlementInfos entitlementInfos, Map map, Map map2, Date date, int i4, Date date2, String str, Uri uri, Date date3, JSONObject jSONObject, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            entitlementInfos = customerInfo.entitlements;
        }
        if ((i5 & 2) != 0) {
            map = customerInfo.allExpirationDatesByProduct;
        }
        if ((i5 & 4) != 0) {
            map2 = customerInfo.allPurchaseDatesByProduct;
        }
        if ((i5 & 8) != 0) {
            date = customerInfo.requestDate;
        }
        if ((i5 & 16) != 0) {
            i4 = customerInfo.schemaVersion;
        }
        if ((i5 & 32) != 0) {
            date2 = customerInfo.firstSeen;
        }
        if ((i5 & 64) != 0) {
            str = customerInfo.originalAppUserId;
        }
        if ((i5 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0) {
            uri = customerInfo.managementURL;
        }
        if ((i5 & 256) != 0) {
            date3 = customerInfo.originalPurchaseDate;
        }
        if ((i5 & 512) != 0) {
            jSONObject = customerInfo.jsonObject;
        }
        Date date4 = date3;
        JSONObject jSONObject2 = jSONObject;
        String str2 = str;
        Uri uri2 = uri;
        int i6 = i4;
        Date date5 = date2;
        return customerInfo.copy(entitlementInfos, map, map2, date, i6, date5, str2, uri2, date4, jSONObject2);
    }

    public static /* synthetic */ void getActiveSubscriptions$annotations() {
    }

    public static /* synthetic */ void getAllPurchasedProductIds$annotations() {
    }

    public static /* synthetic */ void getAllPurchasedSkus$annotations() {
    }

    public static /* synthetic */ void getLatestExpirationDate$annotations() {
    }

    public static /* synthetic */ void getNonSubscriptionTransactions$annotations() {
    }

    public static /* synthetic */ void getRawData$annotations() {
    }

    private static /* synthetic */ void getSubscriberJSONObject$annotations() {
    }

    public static /* synthetic */ void getSubscriptionsByProductIdentifier$annotations() {
    }

    public final EntitlementInfos component1() {
        return this.entitlements;
    }

    public final Map<String, Date> component2() {
        return this.allExpirationDatesByProduct;
    }

    public final Map<String, Date> component3() {
        return this.allPurchaseDatesByProduct;
    }

    public final Date component4() {
        return this.requestDate;
    }

    public final int component5() {
        return this.schemaVersion;
    }

    public final Date component6() {
        return this.firstSeen;
    }

    public final String component7() {
        return this.originalAppUserId;
    }

    public final Uri component8() {
        return this.managementURL;
    }

    public final Date component9() {
        return this.originalPurchaseDate;
    }

    public final CustomerInfo copy(EntitlementInfos entitlements, Map<String, ? extends Date> allExpirationDatesByProduct, Map<String, ? extends Date> allPurchaseDatesByProduct, Date requestDate, int i4, Date firstSeen, String originalAppUserId, Uri uri, Date date, JSONObject jsonObject) {
        r.f(entitlements, "entitlements");
        r.f(allExpirationDatesByProduct, "allExpirationDatesByProduct");
        r.f(allPurchaseDatesByProduct, "allPurchaseDatesByProduct");
        r.f(requestDate, "requestDate");
        r.f(firstSeen, "firstSeen");
        r.f(originalAppUserId, "originalAppUserId");
        r.f(jsonObject, "jsonObject");
        return new CustomerInfo(entitlements, allExpirationDatesByProduct, allPurchaseDatesByProduct, requestDate, i4, firstSeen, originalAppUserId, uri, date, jsonObject);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof CustomerInfo) && r.b(new ComparableData(this), new ComparableData((CustomerInfo) obj));
    }

    public final Set<String> getActiveSubscriptions() {
        return (Set) this.activeSubscriptions$delegate.getValue();
    }

    public final Map<String, Date> getAllExpirationDatesByProduct() {
        return this.allExpirationDatesByProduct;
    }

    public final Map<String, Date> getAllPurchaseDatesByProduct() {
        return this.allPurchaseDatesByProduct;
    }

    public final Set<String> getAllPurchasedProductIds() {
        return (Set) this.allPurchasedProductIds$delegate.getValue();
    }

    public final Set<String> getAllPurchasedSkus() {
        return (Set) this.allPurchasedSkus$delegate.getValue();
    }

    public final EntitlementInfos getEntitlements() {
        return this.entitlements;
    }

    public final Date getExpirationDateForEntitlement(String entitlement) {
        r.f(entitlement, "entitlement");
        EntitlementInfo entitlementInfo = this.entitlements.getAll().get(entitlement);
        if (entitlementInfo != null) {
            return entitlementInfo.getExpirationDate();
        }
        return null;
    }

    public final Date getExpirationDateForProductId(String productId) {
        r.f(productId, "productId");
        return this.allExpirationDatesByProduct.get(productId);
    }

    public final Date getExpirationDateForSku(String sku) {
        r.f(sku, "sku");
        return this.allExpirationDatesByProduct.get(sku);
    }

    public final Date getFirstSeen() {
        return this.firstSeen;
    }

    public final Date getLatestExpirationDate() {
        return (Date) this.latestExpirationDate$delegate.getValue();
    }

    public final Uri getManagementURL() {
        return this.managementURL;
    }

    public final List<Transaction> getNonSubscriptionTransactions() {
        return (List) this.nonSubscriptionTransactions$delegate.getValue();
    }

    public final String getOriginalAppUserId() {
        return this.originalAppUserId;
    }

    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    public final Date getPurchaseDateForEntitlement(String entitlement) {
        r.f(entitlement, "entitlement");
        EntitlementInfo entitlementInfo = this.entitlements.getAll().get(entitlement);
        if (entitlementInfo != null) {
            return entitlementInfo.getLatestPurchaseDate();
        }
        return null;
    }

    public final Date getPurchaseDateForProductId(String productId) {
        r.f(productId, "productId");
        return this.allPurchaseDatesByProduct.get(productId);
    }

    public final Date getPurchaseDateForSku(String sku) {
        r.f(sku, "sku");
        return this.allPurchaseDatesByProduct.get(sku);
    }

    public final Date getRequestDate() {
        return this.requestDate;
    }

    public final int getSchemaVersion() {
        return this.schemaVersion;
    }

    public final Map<String, SubscriptionInfo> getSubscriptionsByProductIdentifier() {
        return (Map) this.subscriptionsByProductIdentifier$delegate.getValue();
    }

    public int hashCode() {
        return new ComparableData(this).hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<CustomerInfo\n latestExpirationDate: ");
        sb.append(getLatestExpirationDate());
        sb.append("\nactiveSubscriptions:  ");
        Set<String> activeSubscriptions = getActiveSubscriptions();
        ArrayList arrayList = new ArrayList(AbstractC0770q.q(activeSubscriptions, 10));
        for (String str : activeSubscriptions) {
            arrayList.add(t.a(str, K.c(t.a("expiresDate", getExpirationDateForProductId(str)))));
        }
        sb.append(L.o(arrayList));
        sb.append(",\nactiveEntitlements: ");
        Map<String, EntitlementInfo> active = this.entitlements.getActive();
        ArrayList arrayList2 = new ArrayList(active.size());
        Iterator<Map.Entry<String, EntitlementInfo>> it = active.entrySet().iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().toString());
        }
        sb.append(arrayList2);
        sb.append(",\nentitlements: ");
        Map<String, EntitlementInfo> all = this.entitlements.getAll();
        ArrayList arrayList3 = new ArrayList(all.size());
        Iterator<Map.Entry<String, EntitlementInfo>> it2 = all.entrySet().iterator();
        while (it2.hasNext()) {
            arrayList3.add(it2.next().toString());
        }
        sb.append(arrayList3);
        sb.append(",\nnonSubscriptionTransactions: ");
        sb.append(getNonSubscriptionTransactions());
        sb.append(",\nrequestDate: ");
        sb.append(this.requestDate);
        sb.append("\n>");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i4) {
        r.f(out, "out");
        this.entitlements.writeToParcel(out, i4);
        Map<String, Date> map = this.allExpirationDatesByProduct;
        out.writeInt(map.size());
        for (Map.Entry<String, Date> entry : map.entrySet()) {
            out.writeString(entry.getKey());
            out.writeSerializable(entry.getValue());
        }
        Map<String, Date> map2 = this.allPurchaseDatesByProduct;
        out.writeInt(map2.size());
        for (Map.Entry<String, Date> entry2 : map2.entrySet()) {
            out.writeString(entry2.getKey());
            out.writeSerializable(entry2.getValue());
        }
        out.writeSerializable(this.requestDate);
        out.writeInt(this.schemaVersion);
        out.writeSerializable(this.firstSeen);
        out.writeString(this.originalAppUserId);
        out.writeParcelable(this.managementURL, i4);
        out.writeSerializable(this.originalPurchaseDate);
        JSONObjectParceler.INSTANCE.write(this.jsonObject, out, i4);
    }

    @Override // com.revenuecat.purchases.models.RawDataContainer
    public JSONObject getRawData() {
        return this.jsonObject;
    }
}
