package com.revenuecat.purchases;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
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
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.InterfaceC2483k;
import o5.w;
import org.json.JSONObject;
import p5.L;
import p5.M;
import p5.r;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002Bw\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001cJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u001f\u0010\u001cJ\u0017\u0010 \u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\u0007¢\u0006\u0004\b \u0010\u001cJ\u0017\u0010\"\u001a\u0004\u0018\u00010\b2\u0006\u0010!\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010\u001cJ\u0017\u0010#\u001a\u0004\u0018\u00010\b2\u0006\u0010!\u001a\u00020\u0007¢\u0006\u0004\b#\u0010\u001cJ\u000f\u0010$\u001a\u00020\u0007H\u0016¢\u0006\u0004\b$\u0010%J\u001a\u0010)\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010&H\u0096\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\fH\u0016¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b-\u0010,J \u00102\u001a\u0002012\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b2\u00103R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00104\u001a\u0004\b5\u00106R%\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00068\u0006¢\u0006\f\n\u0004\b\t\u00107\u001a\u0004\b8\u00109R%\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00068\u0006¢\u0006\f\n\u0004\b\n\u00107\u001a\u0004\b:\u00109R\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000b\u0010;\u001a\u0004\b<\u0010=R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010>\u001a\u0004\b?\u0010,R\u0017\u0010\u000e\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010;\u001a\u0004\b@\u0010=R\u0017\u0010\u000f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000f\u0010A\u001a\u0004\bB\u0010%R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010C\u001a\u0004\bD\u0010ER\u0019\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0012\u0010;\u001a\u0004\bF\u0010=R\u0014\u0010\u0013\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010GR'\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00070\u00178FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\bH\u0010I\u0012\u0004\bL\u0010M\u001a\u0004\bJ\u0010KR'\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00070\u00178FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\bO\u0010I\u0012\u0004\bQ\u0010M\u001a\u0004\bP\u0010KR'\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00070\u00178FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\bS\u0010I\u0012\u0004\bU\u0010M\u001a\u0004\bT\u0010KR#\u0010Z\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\bW\u0010I\u0012\u0004\bY\u0010M\u001a\u0004\bX\u0010=R'\u0010a\u001a\b\u0012\u0004\u0012\u00020\\0[8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b]\u0010I\u0012\u0004\b`\u0010M\u001a\u0004\b^\u0010_R-\u0010f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020b0\u00068FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\bc\u0010I\u0012\u0004\be\u0010M\u001a\u0004\bd\u00109R\"\u0010h\u001a\n g*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004¢\u0006\f\n\u0004\bh\u0010G\u0012\u0004\bi\u0010MR\u001a\u0010m\u001a\u00020\u00038VX\u0096\u0004¢\u0006\f\u0012\u0004\bl\u0010M\u001a\u0004\bj\u0010k¨\u0006n"}, d2 = {"Lcom/revenuecat/purchases/CustomerInfo;", "Landroid/os/Parcelable;", "Lcom/revenuecat/purchases/models/RawDataContainer;", "Lorg/json/JSONObject;", "Lcom/revenuecat/purchases/EntitlementInfos;", CustomerInfoResponseJsonKeys.ENTITLEMENTS, "", "", "Ljava/util/Date;", "allExpirationDatesByProduct", "allPurchaseDatesByProduct", "requestDate", "", "schemaVersion", "firstSeen", "originalAppUserId", "Landroid/net/Uri;", "managementURL", "originalPurchaseDate", "jsonObject", "<init>", "(Lcom/revenuecat/purchases/EntitlementInfos;Ljava/util/Map;Ljava/util/Map;Ljava/util/Date;ILjava/util/Date;Ljava/lang/String;Landroid/net/Uri;Ljava/util/Date;Lorg/json/JSONObject;)V", "expirations", "", "activeIdentifiers", "(Ljava/util/Map;)Ljava/util/Set;", "sku", "getExpirationDateForSku", "(Ljava/lang/String;)Ljava/util/Date;", "productId", "getExpirationDateForProductId", "getPurchaseDateForSku", "getPurchaseDateForProductId", "entitlement", "getExpirationDateForEntitlement", "getPurchaseDateForEntitlement", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lo5/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/revenuecat/purchases/EntitlementInfos;", "getEntitlements", "()Lcom/revenuecat/purchases/EntitlementInfos;", "Ljava/util/Map;", "getAllExpirationDatesByProduct", "()Ljava/util/Map;", "getAllPurchaseDatesByProduct", "Ljava/util/Date;", "getRequestDate", "()Ljava/util/Date;", "I", "getSchemaVersion", "getFirstSeen", "Ljava/lang/String;", "getOriginalAppUserId", "Landroid/net/Uri;", "getManagementURL", "()Landroid/net/Uri;", "getOriginalPurchaseDate", "Lorg/json/JSONObject;", "activeSubscriptions$delegate", "Lo5/k;", "getActiveSubscriptions", "()Ljava/util/Set;", "getActiveSubscriptions$annotations", "()V", "activeSubscriptions", "allPurchasedSkus$delegate", "getAllPurchasedSkus", "getAllPurchasedSkus$annotations", "allPurchasedSkus", "allPurchasedProductIds$delegate", "getAllPurchasedProductIds", "getAllPurchasedProductIds$annotations", "allPurchasedProductIds", "latestExpirationDate$delegate", "getLatestExpirationDate", "getLatestExpirationDate$annotations", "latestExpirationDate", "", "Lcom/revenuecat/purchases/models/Transaction;", "nonSubscriptionTransactions$delegate", "getNonSubscriptionTransactions", "()Ljava/util/List;", "getNonSubscriptionTransactions$annotations", "nonSubscriptionTransactions", "Lcom/revenuecat/purchases/SubscriptionInfo;", "subscriptionsByProductIdentifier$delegate", "getSubscriptionsByProductIdentifier", "getSubscriptionsByProductIdentifier$annotations", "subscriptionsByProductIdentifier", "kotlin.jvm.PlatformType", "subscriberJSONObject", "getSubscriberJSONObject$annotations", "getRawData", "()Lorg/json/JSONObject;", "getRawData$annotations", "rawData", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public final class CustomerInfo implements Parcelable, RawDataContainer<JSONObject> {
    public static final Parcelable.Creator<CustomerInfo> CREATOR = new Creator();

    /* JADX INFO: renamed from: activeSubscriptions$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k activeSubscriptions;
    private final Map<String, Date> allExpirationDatesByProduct;
    private final Map<String, Date> allPurchaseDatesByProduct;

    /* JADX INFO: renamed from: allPurchasedProductIds$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k allPurchasedProductIds;

    /* JADX INFO: renamed from: allPurchasedSkus$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k allPurchasedSkus;
    private final EntitlementInfos entitlements;
    private final Date firstSeen;
    private final JSONObject jsonObject;

    /* JADX INFO: renamed from: latestExpirationDate$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k latestExpirationDate;
    private final Uri managementURL;

    /* JADX INFO: renamed from: nonSubscriptionTransactions$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k nonSubscriptionTransactions;
    private final String originalAppUserId;
    private final Date originalPurchaseDate;
    private final Date requestDate;
    private final int schemaVersion;
    private final JSONObject subscriberJSONObject;

    /* JADX INFO: renamed from: subscriptionsByProductIdentifier$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k subscriptionsByProductIdentifier;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CustomerInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CustomerInfo createFromParcel(Parcel parcel) {
            AbstractC2304t.f(parcel, "parcel");
            EntitlementInfos entitlementInfosCreateFromParcel = EntitlementInfos.CREATOR.createFromParcel(parcel);
            int i8 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i8);
            for (int i9 = 0; i9 != i8; i9++) {
                linkedHashMap.put(parcel.readString(), parcel.readSerializable());
            }
            int i10 = parcel.readInt();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(i10);
            for (int i11 = 0; i11 != i10; i11++) {
                linkedHashMap2.put(parcel.readString(), parcel.readSerializable());
            }
            return new CustomerInfo(entitlementInfosCreateFromParcel, linkedHashMap, linkedHashMap2, (Date) parcel.readSerializable(), parcel.readInt(), (Date) parcel.readSerializable(), parcel.readString(), (Uri) parcel.readParcelable(CustomerInfo.class.getClassLoader()), (Date) parcel.readSerializable(), JSONObjectParceler.INSTANCE.create(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CustomerInfo[] newArray(int i8) {
            return new CustomerInfo[i8];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomerInfo(EntitlementInfos entitlements, Map<String, ? extends Date> allExpirationDatesByProduct, Map<String, ? extends Date> allPurchaseDatesByProduct, Date requestDate, int i8, Date firstSeen, String originalAppUserId, Uri uri, Date date, JSONObject jsonObject) {
        AbstractC2304t.f(entitlements, "entitlements");
        AbstractC2304t.f(allExpirationDatesByProduct, "allExpirationDatesByProduct");
        AbstractC2304t.f(allPurchaseDatesByProduct, "allPurchaseDatesByProduct");
        AbstractC2304t.f(requestDate, "requestDate");
        AbstractC2304t.f(firstSeen, "firstSeen");
        AbstractC2304t.f(originalAppUserId, "originalAppUserId");
        AbstractC2304t.f(jsonObject, "jsonObject");
        this.entitlements = entitlements;
        this.allExpirationDatesByProduct = allExpirationDatesByProduct;
        this.allPurchaseDatesByProduct = allPurchaseDatesByProduct;
        this.requestDate = requestDate;
        this.schemaVersion = i8;
        this.firstSeen = firstSeen;
        this.originalAppUserId = originalAppUserId;
        this.managementURL = uri;
        this.originalPurchaseDate = date;
        this.jsonObject = jsonObject;
        this.activeSubscriptions = AbstractC2484l.a(new CustomerInfo$activeSubscriptions$2(this));
        this.allPurchasedSkus = AbstractC2484l.a(new CustomerInfo$allPurchasedSkus$2(this));
        this.allPurchasedProductIds = AbstractC2484l.a(new CustomerInfo$allPurchasedProductIds$2(this));
        this.latestExpirationDate = AbstractC2484l.a(new CustomerInfo$latestExpirationDate$2(this));
        this.nonSubscriptionTransactions = AbstractC2484l.a(new CustomerInfo$nonSubscriptionTransactions$2(this));
        this.subscriptionsByProductIdentifier = AbstractC2484l.a(new CustomerInfo$subscriptionsByProductIdentifier$2(this));
        this.subscriberJSONObject = jsonObject.getJSONObject(CustomerInfoResponseJsonKeys.SUBSCRIBER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<String> activeIdentifiers(Map<String, ? extends Date> expirations) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends Date> entry : expirations.entrySet()) {
            if (DateHelper.Companion.m177isDateActiveSxA4cEA$default(DateHelper.INSTANCE, entry.getValue(), this.requestDate, 0L, 4, null).isActive()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap.keySet();
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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        return (other instanceof CustomerInfo) && AbstractC2304t.b(new ComparableData(this), new ComparableData((CustomerInfo) other));
    }

    public final Set<String> getActiveSubscriptions() {
        return (Set) this.activeSubscriptions.getValue();
    }

    public final Map<String, Date> getAllExpirationDatesByProduct() {
        return this.allExpirationDatesByProduct;
    }

    public final Map<String, Date> getAllPurchaseDatesByProduct() {
        return this.allPurchaseDatesByProduct;
    }

    public final Set<String> getAllPurchasedProductIds() {
        return (Set) this.allPurchasedProductIds.getValue();
    }

    public final Set<String> getAllPurchasedSkus() {
        return (Set) this.allPurchasedSkus.getValue();
    }

    public final EntitlementInfos getEntitlements() {
        return this.entitlements;
    }

    public final Date getExpirationDateForEntitlement(String entitlement) {
        AbstractC2304t.f(entitlement, "entitlement");
        EntitlementInfo entitlementInfo = this.entitlements.getAll().get(entitlement);
        if (entitlementInfo != null) {
            return entitlementInfo.getExpirationDate();
        }
        return null;
    }

    public final Date getExpirationDateForProductId(String productId) {
        AbstractC2304t.f(productId, "productId");
        return this.allExpirationDatesByProduct.get(productId);
    }

    public final Date getExpirationDateForSku(String sku) {
        AbstractC2304t.f(sku, "sku");
        return this.allExpirationDatesByProduct.get(sku);
    }

    public final Date getFirstSeen() {
        return this.firstSeen;
    }

    public final Date getLatestExpirationDate() {
        return (Date) this.latestExpirationDate.getValue();
    }

    public final Uri getManagementURL() {
        return this.managementURL;
    }

    public final List<Transaction> getNonSubscriptionTransactions() {
        return (List) this.nonSubscriptionTransactions.getValue();
    }

    public final String getOriginalAppUserId() {
        return this.originalAppUserId;
    }

    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    public final Date getPurchaseDateForEntitlement(String entitlement) {
        AbstractC2304t.f(entitlement, "entitlement");
        EntitlementInfo entitlementInfo = this.entitlements.getAll().get(entitlement);
        if (entitlementInfo != null) {
            return entitlementInfo.getLatestPurchaseDate();
        }
        return null;
    }

    public final Date getPurchaseDateForProductId(String productId) {
        AbstractC2304t.f(productId, "productId");
        return this.allPurchaseDatesByProduct.get(productId);
    }

    public final Date getPurchaseDateForSku(String sku) {
        AbstractC2304t.f(sku, "sku");
        return this.allPurchaseDatesByProduct.get(sku);
    }

    public final Date getRequestDate() {
        return this.requestDate;
    }

    public final int getSchemaVersion() {
        return this.schemaVersion;
    }

    public final Map<String, SubscriptionInfo> getSubscriptionsByProductIdentifier() {
        return (Map) this.subscriptionsByProductIdentifier.getValue();
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
        ArrayList arrayList = new ArrayList(r.s(activeSubscriptions, 10));
        for (String str : activeSubscriptions) {
            arrayList.add(w.a(str, L.e(w.a("expiresDate", getExpirationDateForProductId(str)))));
        }
        sb.append(M.u(arrayList));
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
    public void writeToParcel(Parcel parcel, int flags) {
        AbstractC2304t.f(parcel, "out");
        this.entitlements.writeToParcel(parcel, flags);
        Map<String, Date> map = this.allExpirationDatesByProduct;
        parcel.writeInt(map.size());
        for (Map.Entry<String, Date> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeSerializable(entry.getValue());
        }
        Map<String, Date> map2 = this.allPurchaseDatesByProduct;
        parcel.writeInt(map2.size());
        for (Map.Entry<String, Date> entry2 : map2.entrySet()) {
            parcel.writeString(entry2.getKey());
            parcel.writeSerializable(entry2.getValue());
        }
        parcel.writeSerializable(this.requestDate);
        parcel.writeInt(this.schemaVersion);
        parcel.writeSerializable(this.firstSeen);
        parcel.writeString(this.originalAppUserId);
        parcel.writeParcelable(this.managementURL, flags);
        parcel.writeSerializable(this.originalPurchaseDate);
        JSONObjectParceler.INSTANCE.write(this.jsonObject, parcel, flags);
    }

    @Override // com.revenuecat.purchases.models.RawDataContainer
    /* JADX INFO: renamed from: getRawData, reason: avoid collision after fix types in other method and from getter */
    public JSONObject getJsonObject() {
        return this.jsonObject;
    }
}
