package com.revenuecat.purchases.models;

import K3.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.JsonTools;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.common.responses.SubscriptionInfoResponse;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import org.json.JSONException;
import org.json.JSONObject;
import r3.AbstractC1753A;

/* JADX INFO: loaded from: classes3.dex */
public final class Transaction implements Parcelable {
    public static final Parcelable.Creator<Transaction> CREATOR = new Creator();
    private final String displayName;
    private final boolean isSandbox;
    private final Date originalPurchaseDate;
    private final Price price;
    private final String productId;
    private final String productIdentifier;
    private final Date purchaseDate;
    private final String revenuecatId;
    private final Store store;
    private final String storeTransactionId;
    private final String transactionIdentifier;

    public static final class Creator implements Parcelable.Creator<Transaction> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Transaction createFromParcel(Parcel parcel) {
            r.f(parcel, "parcel");
            return new Transaction(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (Date) parcel.readSerializable(), parcel.readString(), Store.valueOf(parcel.readString()), parcel.readString(), parcel.readInt() != 0, (Date) parcel.readSerializable(), parcel.readInt() == 0 ? null : Price.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Transaction[] newArray(int i4) {
            return new Transaction[i4];
        }
    }

    public Transaction(String transactionIdentifier, String revenuecatId, String productIdentifier, String productId, Date purchaseDate, String str, Store store, String str2, boolean z4, Date date, Price price) {
        r.f(transactionIdentifier, "transactionIdentifier");
        r.f(revenuecatId, "revenuecatId");
        r.f(productIdentifier, "productIdentifier");
        r.f(productId, "productId");
        r.f(purchaseDate, "purchaseDate");
        r.f(store, "store");
        this.transactionIdentifier = transactionIdentifier;
        this.revenuecatId = revenuecatId;
        this.productIdentifier = productIdentifier;
        this.productId = productId;
        this.purchaseDate = purchaseDate;
        this.storeTransactionId = str;
        this.store = store;
        this.displayName = str2;
        this.isSandbox = z4;
        this.originalPurchaseDate = date;
        this.price = price;
    }

    public static /* synthetic */ Transaction copy$default(Transaction transaction, String str, String str2, String str3, String str4, Date date, String str5, Store store, String str6, boolean z4, Date date2, Price price, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = transaction.transactionIdentifier;
        }
        if ((i4 & 2) != 0) {
            str2 = transaction.revenuecatId;
        }
        if ((i4 & 4) != 0) {
            str3 = transaction.productIdentifier;
        }
        if ((i4 & 8) != 0) {
            str4 = transaction.productId;
        }
        if ((i4 & 16) != 0) {
            date = transaction.purchaseDate;
        }
        if ((i4 & 32) != 0) {
            str5 = transaction.storeTransactionId;
        }
        if ((i4 & 64) != 0) {
            store = transaction.store;
        }
        if ((i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0) {
            str6 = transaction.displayName;
        }
        if ((i4 & 256) != 0) {
            z4 = transaction.isSandbox;
        }
        if ((i4 & 512) != 0) {
            date2 = transaction.originalPurchaseDate;
        }
        if ((i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
            price = transaction.price;
        }
        Date date3 = date2;
        Price price2 = price;
        String str7 = str6;
        boolean z5 = z4;
        String str8 = str5;
        Store store2 = store;
        Date date4 = date;
        String str9 = str3;
        return transaction.copy(str, str2, str9, str4, date4, str8, store2, str7, z5, date3, price2);
    }

    public static /* synthetic */ void getProductId$annotations() {
    }

    public static /* synthetic */ void getRevenuecatId$annotations() {
    }

    public final String component1() {
        return this.transactionIdentifier;
    }

    public final Date component10() {
        return this.originalPurchaseDate;
    }

    public final Price component11() {
        return this.price;
    }

    public final String component2() {
        return this.revenuecatId;
    }

    public final String component3() {
        return this.productIdentifier;
    }

    public final String component4() {
        return this.productId;
    }

    public final Date component5() {
        return this.purchaseDate;
    }

    public final String component6() {
        return this.storeTransactionId;
    }

    public final Store component7() {
        return this.store;
    }

    public final String component8() {
        return this.displayName;
    }

    public final boolean component9() {
        return this.isSandbox;
    }

    public final Transaction copy(String transactionIdentifier, String revenuecatId, String productIdentifier, String productId, Date purchaseDate, String str, Store store, String str2, boolean z4, Date date, Price price) {
        r.f(transactionIdentifier, "transactionIdentifier");
        r.f(revenuecatId, "revenuecatId");
        r.f(productIdentifier, "productIdentifier");
        r.f(productId, "productId");
        r.f(purchaseDate, "purchaseDate");
        r.f(store, "store");
        return new Transaction(transactionIdentifier, revenuecatId, productIdentifier, productId, purchaseDate, str, store, str2, z4, date, price);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Transaction)) {
            return false;
        }
        Transaction transaction = (Transaction) obj;
        return r.b(this.transactionIdentifier, transaction.transactionIdentifier) && r.b(this.revenuecatId, transaction.revenuecatId) && r.b(this.productIdentifier, transaction.productIdentifier) && r.b(this.productId, transaction.productId) && r.b(this.purchaseDate, transaction.purchaseDate) && r.b(this.storeTransactionId, transaction.storeTransactionId) && this.store == transaction.store && r.b(this.displayName, transaction.displayName) && this.isSandbox == transaction.isSandbox && r.b(this.originalPurchaseDate, transaction.originalPurchaseDate) && r.b(this.price, transaction.price);
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    public final Price getPrice() {
        return this.price;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    public final Date getPurchaseDate() {
        return this.purchaseDate;
    }

    public final String getRevenuecatId() {
        return this.revenuecatId;
    }

    public final Store getStore() {
        return this.store;
    }

    public final String getStoreTransactionId() {
        return this.storeTransactionId;
    }

    public final String getTransactionIdentifier() {
        return this.transactionIdentifier;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v26 */
    public int hashCode() {
        int iHashCode = ((((((((this.transactionIdentifier.hashCode() * 31) + this.revenuecatId.hashCode()) * 31) + this.productIdentifier.hashCode()) * 31) + this.productId.hashCode()) * 31) + this.purchaseDate.hashCode()) * 31;
        String str = this.storeTransactionId;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.store.hashCode()) * 31;
        String str2 = this.displayName;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z4 = this.isSandbox;
        ?? r12 = z4;
        if (z4) {
            r12 = 1;
        }
        int i4 = (iHashCode3 + r12) * 31;
        Date date = this.originalPurchaseDate;
        int iHashCode4 = (i4 + (date == null ? 0 : date.hashCode())) * 31;
        Price price = this.price;
        return iHashCode4 + (price != null ? price.hashCode() : 0);
    }

    public final boolean isSandbox() {
        return this.isSandbox;
    }

    public String toString() {
        return "Transaction(transactionIdentifier=" + this.transactionIdentifier + ", revenuecatId=" + this.revenuecatId + ", productIdentifier=" + this.productIdentifier + ", productId=" + this.productId + ", purchaseDate=" + this.purchaseDate + ", storeTransactionId=" + this.storeTransactionId + ", store=" + this.store + ", displayName=" + this.displayName + ", isSandbox=" + this.isSandbox + ", originalPurchaseDate=" + this.originalPurchaseDate + ", price=" + this.price + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i4) {
        r.f(out, "out");
        out.writeString(this.transactionIdentifier);
        out.writeString(this.revenuecatId);
        out.writeString(this.productIdentifier);
        out.writeString(this.productId);
        out.writeSerializable(this.purchaseDate);
        out.writeString(this.storeTransactionId);
        out.writeString(this.store.name());
        out.writeString(this.displayName);
        out.writeInt(this.isSandbox ? 1 : 0);
        out.writeSerializable(this.originalPurchaseDate);
        Price price = this.price;
        if (price == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            price.writeToParcel(out, i4);
        }
    }

    public /* synthetic */ Transaction(String str, String str2, String str3, String str4, Date date, String str5, Store store, String str6, boolean z4, Date date2, Price price, int i4, AbstractC1585j abstractC1585j) {
        this(str, str2, str3, str4, date, str5, store, str6, (i4 & 256) != 0 ? false : z4, date2, price);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Transaction(String transactionIdentifier, String revenuecatId, String productIdentifier, String productId, Date purchaseDate, String str, Store store) {
        this(transactionIdentifier, revenuecatId, productIdentifier, productId, purchaseDate, str, store, null, false, null, null);
        r.f(transactionIdentifier, "transactionIdentifier");
        r.f(revenuecatId, "revenuecatId");
        r.f(productIdentifier, "productIdentifier");
        r.f(productId, "productId");
        r.f(purchaseDate, "purchaseDate");
        r.f(store, "store");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Transaction(String str, JSONObject jSONObject, Locale locale, int i4, AbstractC1585j abstractC1585j) {
        if ((i4 & 4) != 0) {
            locale = Locale.getDefault();
            r.e(locale, "getDefault()");
        }
        this(str, jSONObject, locale);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Transaction(String productId, JSONObject jsonObject, Locale locale) throws JSONException {
        String string;
        r.f(productId, "productId");
        r.f(jsonObject, "jsonObject");
        r.f(locale, "locale");
        String string2 = jsonObject.getString(DiagnosticsEntry.ID_KEY);
        r.e(string2, "jsonObject.getString(\"id\")");
        String string3 = jsonObject.getString(DiagnosticsEntry.ID_KEY);
        r.e(string3, "jsonObject.getString(\"id\")");
        Date date = JSONObjectExtensionsKt.getDate(jsonObject, "purchase_date");
        String it = jsonObject.optString("store_transaction_id");
        r.e(it, "it");
        Price price = null;
        it = AbstractC1753A.U(it) ? null : it;
        String it2 = jsonObject.getString(ProductResponseJsonKeys.STORE);
        Store.Companion companion = Store.Companion;
        r.e(it2, "it");
        Store storeFromString = companion.fromString(it2);
        String it3 = jsonObject.optString("display_name");
        r.e(it3, "it");
        String str = !AbstractC1753A.U(it3) ? it3 : null;
        boolean zOptBoolean = jsonObject.optBoolean(ProductResponseJsonKeys.IS_SANDBOX, false);
        Date dateOptDate = JSONObjectExtensionsKt.optDate(jsonObject, "original_purchase_date");
        JSONObject jSONObjectOptJSONObject = jsonObject.optJSONObject("price");
        if (jSONObjectOptJSONObject != null && (string = jSONObjectOptJSONObject.toString()) != null) {
            a json = JsonTools.INSTANCE.getJson();
            json.a();
            price = ((SubscriptionInfoResponse.PriceResponse) json.d(SubscriptionInfoResponse.PriceResponse.Companion.serializer(), string)).toPrice(locale);
        }
        this(string2, string3, productId, productId, date, it, storeFromString, str, zOptBoolean, dateOptDate, price);
    }
}
