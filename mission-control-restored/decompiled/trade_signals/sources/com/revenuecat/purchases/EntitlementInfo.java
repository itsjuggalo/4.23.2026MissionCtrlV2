package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.models.RawDataContainer;
import com.revenuecat.purchases.utils.JSONObjectParceler;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0091\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cB\u0089\u0001\b\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 H\u0096\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020$HÖ\u0001¢\u0006\u0004\b'\u0010&J \u0010,\u001a\u00020+2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020$HÖ\u0001¢\u0006\u0004\b,\u0010-R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010.\u001a\u0004\b/\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00100\u001a\u0004\b\u0007\u00101R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u00100\u001a\u0004\b2\u00101R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u00103\u001a\u0004\b4\u00105R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u00106\u001a\u0004\b7\u00108R\u0017\u0010\r\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\r\u00106\u001a\u0004\b9\u00108R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u000e\u00106\u001a\u0004\b:\u00108R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010;\u001a\u0004\b<\u0010=R\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010.\u001a\u0004\b>\u0010\u001fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010.\u001a\u0004\b?\u0010\u001fR\u0017\u0010\u0013\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u00100\u001a\u0004\b\u0013\u00101R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u0014\u00106\u001a\u0004\b@\u00108R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u0015\u00106\u001a\u0004\bA\u00108R\u0017\u0010\u0017\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010B\u001a\u0004\bC\u0010DR\u0014\u0010\u0018\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010ER\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010F\u001a\u0004\bG\u0010HR\u001a\u0010M\u001a\u00020\u00038VX\u0096\u0004¢\u0006\f\u0012\u0004\bK\u0010L\u001a\u0004\bI\u0010J¨\u0006N"}, d2 = {"Lcom/revenuecat/purchases/EntitlementInfo;", "Landroid/os/Parcelable;", "Lcom/revenuecat/purchases/models/RawDataContainer;", "Lorg/json/JSONObject;", "", "identifier", "", "isActive", "willRenew", "Lcom/revenuecat/purchases/PeriodType;", "periodType", "Ljava/util/Date;", "latestPurchaseDate", "originalPurchaseDate", "expirationDate", "Lcom/revenuecat/purchases/Store;", ProductResponseJsonKeys.STORE, "productIdentifier", "productPlanIdentifier", "isSandbox", "unsubscribeDetectedAt", "billingIssueDetectedAt", "Lcom/revenuecat/purchases/OwnershipType;", "ownershipType", "jsonObject", "Lcom/revenuecat/purchases/VerificationResult;", "verification", "<init>", "(Ljava/lang/String;ZZLcom/revenuecat/purchases/PeriodType;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/Store;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/OwnershipType;Lorg/json/JSONObject;Lcom/revenuecat/purchases/VerificationResult;)V", "(Ljava/lang/String;ZZLcom/revenuecat/purchases/PeriodType;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/Store;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/OwnershipType;Lorg/json/JSONObject;)V", "toString", "()Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lo5/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getIdentifier", "Z", "()Z", "getWillRenew", "Lcom/revenuecat/purchases/PeriodType;", "getPeriodType", "()Lcom/revenuecat/purchases/PeriodType;", "Ljava/util/Date;", "getLatestPurchaseDate", "()Ljava/util/Date;", "getOriginalPurchaseDate", "getExpirationDate", "Lcom/revenuecat/purchases/Store;", "getStore", "()Lcom/revenuecat/purchases/Store;", "getProductIdentifier", "getProductPlanIdentifier", "getUnsubscribeDetectedAt", "getBillingIssueDetectedAt", "Lcom/revenuecat/purchases/OwnershipType;", "getOwnershipType", "()Lcom/revenuecat/purchases/OwnershipType;", "Lorg/json/JSONObject;", "Lcom/revenuecat/purchases/VerificationResult;", "getVerification", "()Lcom/revenuecat/purchases/VerificationResult;", "getRawData", "()Lorg/json/JSONObject;", "getRawData$annotations", "()V", "rawData", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public final class EntitlementInfo implements Parcelable, RawDataContainer<JSONObject> {
    public static final Parcelable.Creator<EntitlementInfo> CREATOR = new Creator();
    private final Date billingIssueDetectedAt;
    private final Date expirationDate;
    private final String identifier;
    private final boolean isActive;
    private final boolean isSandbox;
    private final JSONObject jsonObject;
    private final Date latestPurchaseDate;
    private final Date originalPurchaseDate;
    private final OwnershipType ownershipType;
    private final PeriodType periodType;
    private final String productIdentifier;
    private final String productPlanIdentifier;
    private final Store store;
    private final Date unsubscribeDetectedAt;
    private final VerificationResult verification;
    private final boolean willRenew;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<EntitlementInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EntitlementInfo createFromParcel(Parcel parcel) {
            AbstractC2304t.f(parcel, "parcel");
            return new EntitlementInfo(parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, PeriodType.valueOf(parcel.readString()), (Date) parcel.readSerializable(), (Date) parcel.readSerializable(), (Date) parcel.readSerializable(), Store.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readInt() != 0, (Date) parcel.readSerializable(), (Date) parcel.readSerializable(), OwnershipType.valueOf(parcel.readString()), JSONObjectParceler.INSTANCE.create(parcel), VerificationResult.valueOf(parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final EntitlementInfo[] newArray(int i8) {
            return new EntitlementInfo[i8];
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EntitlementInfo(String identifier, boolean z7, boolean z8, PeriodType periodType, Date latestPurchaseDate, Date originalPurchaseDate, Date date, Store store, String productIdentifier, String str, boolean z9, Date date2, Date date3, OwnershipType ownershipType, JSONObject jsonObject) {
        this(identifier, z7, z8, periodType, latestPurchaseDate, originalPurchaseDate, date, store, productIdentifier, str, z9, date2, date3, ownershipType, jsonObject, VerificationResult.NOT_REQUESTED);
        AbstractC2304t.f(identifier, "identifier");
        AbstractC2304t.f(periodType, "periodType");
        AbstractC2304t.f(latestPurchaseDate, "latestPurchaseDate");
        AbstractC2304t.f(originalPurchaseDate, "originalPurchaseDate");
        AbstractC2304t.f(store, "store");
        AbstractC2304t.f(productIdentifier, "productIdentifier");
        AbstractC2304t.f(ownershipType, "ownershipType");
        AbstractC2304t.f(jsonObject, "jsonObject");
    }

    public static /* synthetic */ void getRawData$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!AbstractC2304t.b(EntitlementInfo.class, other != null ? other.getClass() : null)) {
            return false;
        }
        AbstractC2304t.d(other, "null cannot be cast to non-null type com.revenuecat.purchases.EntitlementInfo");
        EntitlementInfo entitlementInfo = (EntitlementInfo) other;
        return AbstractC2304t.b(this.identifier, entitlementInfo.identifier) && this.isActive == entitlementInfo.isActive && this.willRenew == entitlementInfo.willRenew && this.periodType == entitlementInfo.periodType && AbstractC2304t.b(this.latestPurchaseDate, entitlementInfo.latestPurchaseDate) && AbstractC2304t.b(this.originalPurchaseDate, entitlementInfo.originalPurchaseDate) && AbstractC2304t.b(this.expirationDate, entitlementInfo.expirationDate) && this.store == entitlementInfo.store && AbstractC2304t.b(this.productIdentifier, entitlementInfo.productIdentifier) && AbstractC2304t.b(this.productPlanIdentifier, entitlementInfo.productPlanIdentifier) && this.isSandbox == entitlementInfo.isSandbox && AbstractC2304t.b(this.unsubscribeDetectedAt, entitlementInfo.unsubscribeDetectedAt) && AbstractC2304t.b(this.billingIssueDetectedAt, entitlementInfo.billingIssueDetectedAt) && this.ownershipType == entitlementInfo.ownershipType && this.verification == entitlementInfo.verification;
    }

    public final Date getBillingIssueDetectedAt() {
        return this.billingIssueDetectedAt;
    }

    public final Date getExpirationDate() {
        return this.expirationDate;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final Date getLatestPurchaseDate() {
        return this.latestPurchaseDate;
    }

    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    public final OwnershipType getOwnershipType() {
        return this.ownershipType;
    }

    public final PeriodType getPeriodType() {
        return this.periodType;
    }

    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    public final String getProductPlanIdentifier() {
        return this.productPlanIdentifier;
    }

    public final Store getStore() {
        return this.store;
    }

    public final Date getUnsubscribeDetectedAt() {
        return this.unsubscribeDetectedAt;
    }

    public final VerificationResult getVerification() {
        return this.verification;
    }

    public final boolean getWillRenew() {
        return this.willRenew;
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.identifier.hashCode() * 31) + Boolean.hashCode(this.isActive)) * 31) + Boolean.hashCode(this.willRenew)) * 31) + this.periodType.hashCode()) * 31) + this.latestPurchaseDate.hashCode()) * 31) + this.originalPurchaseDate.hashCode()) * 31;
        Date date = this.expirationDate;
        int iHashCode2 = (((((iHashCode + (date != null ? date.hashCode() : 0)) * 31) + this.store.hashCode()) * 31) + this.productIdentifier.hashCode()) * 31;
        String str = this.productPlanIdentifier;
        int iHashCode3 = (((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.isSandbox)) * 31;
        Date date2 = this.unsubscribeDetectedAt;
        int iHashCode4 = (iHashCode3 + (date2 != null ? date2.hashCode() : 0)) * 31;
        Date date3 = this.billingIssueDetectedAt;
        return ((iHashCode4 + (date3 != null ? date3.hashCode() : 0)) * 31) + this.ownershipType.hashCode();
    }

    /* JADX INFO: renamed from: isActive, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    /* JADX INFO: renamed from: isSandbox, reason: from getter */
    public final boolean getIsSandbox() {
        return this.isSandbox;
    }

    public String toString() {
        return "EntitlementInfo(identifier='" + this.identifier + "', isActive=" + this.isActive + ", willRenew=" + this.willRenew + ", periodType=" + this.periodType + ", latestPurchaseDate=" + this.latestPurchaseDate + ", originalPurchaseDate=" + this.originalPurchaseDate + ", expirationDate=" + this.expirationDate + ", store=" + this.store + ", productIdentifier='" + this.productIdentifier + "', productPlanIdentifier='" + this.productPlanIdentifier + "', isSandbox=" + this.isSandbox + ", unsubscribeDetectedAt=" + this.unsubscribeDetectedAt + ", billingIssueDetectedAt=" + this.billingIssueDetectedAt + ", ownershipType=" + this.ownershipType + ", verification=" + this.verification + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        AbstractC2304t.f(parcel, "out");
        parcel.writeString(this.identifier);
        parcel.writeInt(this.isActive ? 1 : 0);
        parcel.writeInt(this.willRenew ? 1 : 0);
        parcel.writeString(this.periodType.name());
        parcel.writeSerializable(this.latestPurchaseDate);
        parcel.writeSerializable(this.originalPurchaseDate);
        parcel.writeSerializable(this.expirationDate);
        parcel.writeString(this.store.name());
        parcel.writeString(this.productIdentifier);
        parcel.writeString(this.productPlanIdentifier);
        parcel.writeInt(this.isSandbox ? 1 : 0);
        parcel.writeSerializable(this.unsubscribeDetectedAt);
        parcel.writeSerializable(this.billingIssueDetectedAt);
        parcel.writeString(this.ownershipType.name());
        JSONObjectParceler.INSTANCE.write(this.jsonObject, parcel, flags);
        parcel.writeString(this.verification.name());
    }

    public EntitlementInfo(String identifier, boolean z7, boolean z8, PeriodType periodType, Date latestPurchaseDate, Date originalPurchaseDate, Date date, Store store, String productIdentifier, String str, boolean z9, Date date2, Date date3, OwnershipType ownershipType, JSONObject jsonObject, VerificationResult verification) {
        AbstractC2304t.f(identifier, "identifier");
        AbstractC2304t.f(periodType, "periodType");
        AbstractC2304t.f(latestPurchaseDate, "latestPurchaseDate");
        AbstractC2304t.f(originalPurchaseDate, "originalPurchaseDate");
        AbstractC2304t.f(store, "store");
        AbstractC2304t.f(productIdentifier, "productIdentifier");
        AbstractC2304t.f(ownershipType, "ownershipType");
        AbstractC2304t.f(jsonObject, "jsonObject");
        AbstractC2304t.f(verification, "verification");
        this.identifier = identifier;
        this.isActive = z7;
        this.willRenew = z8;
        this.periodType = periodType;
        this.latestPurchaseDate = latestPurchaseDate;
        this.originalPurchaseDate = originalPurchaseDate;
        this.expirationDate = date;
        this.store = store;
        this.productIdentifier = productIdentifier;
        this.productPlanIdentifier = str;
        this.isSandbox = z9;
        this.unsubscribeDetectedAt = date2;
        this.billingIssueDetectedAt = date3;
        this.ownershipType = ownershipType;
        this.jsonObject = jsonObject;
        this.verification = verification;
    }

    @Override // com.revenuecat.purchases.models.RawDataContainer
    /* JADX INFO: renamed from: getRawData, reason: avoid collision after fix types in other method and from getter */
    public JSONObject getJsonObject() {
        return this.jsonObject;
    }

    public /* synthetic */ EntitlementInfo(String str, boolean z7, boolean z8, PeriodType periodType, Date date, Date date2, Date date3, Store store, String str2, String str3, boolean z9, Date date4, Date date5, OwnershipType ownershipType, JSONObject jSONObject, VerificationResult verificationResult, int i8, AbstractC2296k abstractC2296k) {
        this(str, z7, z8, periodType, date, date2, date3, store, str2, str3, z9, date4, date5, ownershipType, jSONObject, (i8 & 32768) != 0 ? VerificationResult.NOT_REQUESTED : verificationResult);
    }
}
