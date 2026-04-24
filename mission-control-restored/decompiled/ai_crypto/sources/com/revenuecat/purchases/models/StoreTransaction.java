package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.utils.JSONObjectParceler;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class StoreTransaction implements Parcelable {
    public static final Parcelable.Creator<StoreTransaction> CREATOR = new Creator();
    private final Boolean isAutoRenewing;
    private final String marketplace;
    private final String orderId;
    private final JSONObject originalJson;
    private final PresentedOfferingContext presentedOfferingContext;
    private final List<String> productIds;
    private final PurchaseState purchaseState;
    private final long purchaseTime;
    private final String purchaseToken;
    private final PurchaseType purchaseType;
    private final ReplacementMode replacementMode;
    private final String signature;
    private final String storeUserID;
    private final String subscriptionOptionId;
    private final ProductType type;

    public static final class Creator implements Parcelable.Creator<StoreTransaction> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StoreTransaction createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            r.f(parcel, "parcel");
            String string = parcel.readString();
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            ProductType productTypeValueOf = ProductType.valueOf(parcel.readString());
            long j7 = parcel.readLong();
            String string2 = parcel.readString();
            PurchaseState purchaseStateValueOf = PurchaseState.valueOf(parcel.readString());
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new StoreTransaction(string, arrayListCreateStringArrayList, productTypeValueOf, j7, string2, purchaseStateValueOf, boolValueOf, parcel.readString(), JSONObjectParceler.INSTANCE.create(parcel), parcel.readInt() != 0 ? PresentedOfferingContext.CREATOR.createFromParcel(parcel) : null, parcel.readString(), PurchaseType.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), (ReplacementMode) parcel.readParcelable(StoreTransaction.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StoreTransaction[] newArray(int i7) {
            return new StoreTransaction[i7];
        }
    }

    public StoreTransaction(String str, List<String> productIds, ProductType type, long j7, String purchaseToken, PurchaseState purchaseState, Boolean bool, String str2, JSONObject originalJson, PresentedOfferingContext presentedOfferingContext, String str3, PurchaseType purchaseType, String str4, String str5, ReplacementMode replacementMode) {
        r.f(productIds, "productIds");
        r.f(type, "type");
        r.f(purchaseToken, "purchaseToken");
        r.f(purchaseState, "purchaseState");
        r.f(originalJson, "originalJson");
        r.f(purchaseType, "purchaseType");
        this.orderId = str;
        this.productIds = productIds;
        this.type = type;
        this.purchaseTime = j7;
        this.purchaseToken = purchaseToken;
        this.purchaseState = purchaseState;
        this.isAutoRenewing = bool;
        this.signature = str2;
        this.originalJson = originalJson;
        this.presentedOfferingContext = presentedOfferingContext;
        this.storeUserID = str3;
        this.purchaseType = purchaseType;
        this.marketplace = str4;
        this.subscriptionOptionId = str5;
        this.replacementMode = replacementMode;
    }

    public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
    }

    public static /* synthetic */ void getSkus$annotations() {
    }

    public final String component1() {
        return this.orderId;
    }

    public final PresentedOfferingContext component10() {
        return this.presentedOfferingContext;
    }

    public final String component11() {
        return this.storeUserID;
    }

    public final PurchaseType component12() {
        return this.purchaseType;
    }

    public final String component13() {
        return this.marketplace;
    }

    public final String component14() {
        return this.subscriptionOptionId;
    }

    public final ReplacementMode component15() {
        return this.replacementMode;
    }

    public final List<String> component2() {
        return this.productIds;
    }

    public final ProductType component3() {
        return this.type;
    }

    public final long component4() {
        return this.purchaseTime;
    }

    public final String component5() {
        return this.purchaseToken;
    }

    public final PurchaseState component6() {
        return this.purchaseState;
    }

    public final Boolean component7() {
        return this.isAutoRenewing;
    }

    public final String component8() {
        return this.signature;
    }

    public final JSONObject component9() {
        return this.originalJson;
    }

    public final StoreTransaction copy(String str, List<String> productIds, ProductType type, long j7, String purchaseToken, PurchaseState purchaseState, Boolean bool, String str2, JSONObject originalJson, PresentedOfferingContext presentedOfferingContext, String str3, PurchaseType purchaseType, String str4, String str5, ReplacementMode replacementMode) {
        r.f(productIds, "productIds");
        r.f(type, "type");
        r.f(purchaseToken, "purchaseToken");
        r.f(purchaseState, "purchaseState");
        r.f(originalJson, "originalJson");
        r.f(purchaseType, "purchaseType");
        return new StoreTransaction(str, productIds, type, j7, purchaseToken, purchaseState, bool, str2, originalJson, presentedOfferingContext, str3, purchaseType, str4, str5, replacementMode);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof StoreTransaction) && r.b(new ComparableData(this), new ComparableData((StoreTransaction) obj));
    }

    public final String getMarketplace() {
        return this.marketplace;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final JSONObject getOriginalJson() {
        return this.originalJson;
    }

    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public final String getPresentedOfferingIdentifier() {
        PresentedOfferingContext presentedOfferingContext = this.presentedOfferingContext;
        if (presentedOfferingContext != null) {
            return presentedOfferingContext.getOfferingIdentifier();
        }
        return null;
    }

    public final List<String> getProductIds() {
        return this.productIds;
    }

    public final PurchaseState getPurchaseState() {
        return this.purchaseState;
    }

    public final long getPurchaseTime() {
        return this.purchaseTime;
    }

    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    public final PurchaseType getPurchaseType() {
        return this.purchaseType;
    }

    public final ReplacementMode getReplacementMode() {
        return this.replacementMode;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final List<String> getSkus() {
        return this.productIds;
    }

    public final String getStoreUserID() {
        return this.storeUserID;
    }

    public final String getSubscriptionOptionId() {
        return this.subscriptionOptionId;
    }

    public final ProductType getType() {
        return this.type;
    }

    public int hashCode() {
        return new ComparableData(this).hashCode();
    }

    public final Boolean isAutoRenewing() {
        return this.isAutoRenewing;
    }

    public String toString() {
        return "StoreTransaction(orderId=" + this.orderId + ", productIds=" + this.productIds + ", type=" + this.type + ", purchaseTime=" + this.purchaseTime + ", purchaseToken=" + this.purchaseToken + ", purchaseState=" + this.purchaseState + ", isAutoRenewing=" + this.isAutoRenewing + ", signature=" + this.signature + ", originalJson=" + this.originalJson + ", presentedOfferingContext=" + this.presentedOfferingContext + ", storeUserID=" + this.storeUserID + ", purchaseType=" + this.purchaseType + ", marketplace=" + this.marketplace + ", subscriptionOptionId=" + this.subscriptionOptionId + ", replacementMode=" + this.replacementMode + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i7) {
        r.f(out, "out");
        out.writeString(this.orderId);
        out.writeStringList(this.productIds);
        out.writeString(this.type.name());
        out.writeLong(this.purchaseTime);
        out.writeString(this.purchaseToken);
        out.writeString(this.purchaseState.name());
        Boolean bool = this.isAutoRenewing;
        if (bool == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool.booleanValue() ? 1 : 0);
        }
        out.writeString(this.signature);
        JSONObjectParceler.INSTANCE.write(this.originalJson, out, i7);
        PresentedOfferingContext presentedOfferingContext = this.presentedOfferingContext;
        if (presentedOfferingContext == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            presentedOfferingContext.writeToParcel(out, i7);
        }
        out.writeString(this.storeUserID);
        out.writeString(this.purchaseType.name());
        out.writeString(this.marketplace);
        out.writeString(this.subscriptionOptionId);
        out.writeParcelable(this.replacementMode, i7);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StoreTransaction(String str, List<String> productIds, ProductType type, long j7, String purchaseToken, PurchaseState purchaseState, Boolean bool, String str2, JSONObject originalJson, String str3, String str4, PurchaseType purchaseType, String str5, String str6, ReplacementMode replacementMode) {
        this(str, productIds, type, j7, purchaseToken, purchaseState, bool, str2, originalJson, str3 != null ? new PresentedOfferingContext(str3) : null, str4, purchaseType, str5, str6, replacementMode);
        r.f(productIds, "productIds");
        r.f(type, "type");
        r.f(purchaseToken, "purchaseToken");
        r.f(purchaseState, "purchaseState");
        r.f(originalJson, "originalJson");
        r.f(purchaseType, "purchaseType");
    }
}
