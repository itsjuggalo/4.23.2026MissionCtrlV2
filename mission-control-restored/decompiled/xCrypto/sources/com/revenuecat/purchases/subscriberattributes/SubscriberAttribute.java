package com.revenuecat.purchases.subscriberattributes;

import W2.t;
import X2.L;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.subscriberattributes.SpecialSubscriberAttributesKt;
import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.util.Date;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscriberAttribute {
    private final DateProvider dateProvider;
    private final boolean isSynced;
    private final SubscriberAttributeKey key;
    private final Date setTime;
    private final String value;

    public SubscriberAttribute(SubscriberAttributeKey key, String str, DateProvider dateProvider, Date setTime, boolean z4) {
        r.f(key, "key");
        r.f(dateProvider, "dateProvider");
        r.f(setTime, "setTime");
        this.key = key;
        this.value = str;
        this.dateProvider = dateProvider;
        this.setTime = setTime;
        this.isSynced = z4;
    }

    public static /* synthetic */ SubscriberAttribute copy$default(SubscriberAttribute subscriberAttribute, SubscriberAttributeKey subscriberAttributeKey, String str, DateProvider dateProvider, Date date, boolean z4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            subscriberAttributeKey = subscriberAttribute.key;
        }
        if ((i4 & 2) != 0) {
            str = subscriberAttribute.value;
        }
        if ((i4 & 4) != 0) {
            dateProvider = subscriberAttribute.dateProvider;
        }
        if ((i4 & 8) != 0) {
            date = subscriberAttribute.setTime;
        }
        if ((i4 & 16) != 0) {
            z4 = subscriberAttribute.isSynced;
        }
        boolean z5 = z4;
        DateProvider dateProvider2 = dateProvider;
        return subscriberAttribute.copy(subscriberAttributeKey, str, dateProvider2, date, z5);
    }

    public final SubscriberAttributeKey component1() {
        return this.key;
    }

    public final String component2() {
        return this.value;
    }

    public final DateProvider component3() {
        return this.dateProvider;
    }

    public final Date component4() {
        return this.setTime;
    }

    public final boolean component5() {
        return this.isSynced;
    }

    public final SubscriberAttribute copy(SubscriberAttributeKey key, String str, DateProvider dateProvider, Date setTime, boolean z4) {
        r.f(key, "key");
        r.f(dateProvider, "dateProvider");
        r.f(setTime, "setTime");
        return new SubscriberAttribute(key, str, dateProvider, setTime, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!r.b(SubscriberAttribute.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        r.d(obj, "null cannot be cast to non-null type com.revenuecat.purchases.subscriberattributes.SubscriberAttribute");
        SubscriberAttribute subscriberAttribute = (SubscriberAttribute) obj;
        return r.b(this.key, subscriberAttribute.key) && r.b(this.value, subscriberAttribute.value) && r.b(this.setTime, subscriberAttribute.setTime) && this.isSynced == subscriberAttribute.isSynced;
    }

    public final DateProvider getDateProvider() {
        return this.dateProvider;
    }

    public final SubscriberAttributeKey getKey() {
        return this.key;
    }

    public final Date getSetTime() {
        return this.setTime;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        int iHashCode = this.key.hashCode() * 31;
        String str = this.value;
        return ((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.setTime.hashCode()) * 31) + Boolean.hashCode(this.isSynced);
    }

    public final boolean isSynced() {
        return this.isSynced;
    }

    public final Map<String, Object> toBackendMap() {
        return L.g(t.a("value", this.value), t.a(SubscriberAttributeKt.BACKEND_NAME_TIMESTAMP, Long.valueOf(this.setTime.getTime())));
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", this.key.getBackendKey());
        String str = this.value;
        if (str == null || jSONObject.put("value", str) == null) {
            jSONObject.put("value", JSONObject.NULL);
        }
        jSONObject.put(SubscriberAttributeKt.JSON_NAME_SET_TIME, this.setTime.getTime());
        jSONObject.put(SubscriberAttributeKt.JSON_NAME_IS_SYNCED, this.isSynced);
        return jSONObject;
    }

    public String toString() {
        return "SubscriberAttribute(key=" + this.key + ", value=" + this.value + ", setTime=" + this.setTime + ", isSynced=" + this.isSynced + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SubscriberAttribute(SubscriberAttributeKey subscriberAttributeKey, String str, DateProvider dateProvider, Date date, boolean z4, int i4, AbstractC1585j abstractC1585j) {
        DateProvider defaultDateProvider = (i4 & 4) != 0 ? new DefaultDateProvider() : dateProvider;
        this(subscriberAttributeKey, str, defaultDateProvider, (i4 & 8) != 0 ? defaultDateProvider.getNow() : date, (i4 & 16) != 0 ? false : z4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SubscriberAttribute(String str, String str2, DateProvider dateProvider, Date date, boolean z4, int i4, AbstractC1585j abstractC1585j) {
        DateProvider defaultDateProvider = (i4 & 4) != 0 ? new DefaultDateProvider() : dateProvider;
        this(str, str2, defaultDateProvider, (i4 & 8) != 0 ? defaultDateProvider.getNow() : date, (i4 & 16) != 0 ? false : z4);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SubscriberAttribute(String key, String str, DateProvider dateProvider, Date setTime, boolean z4) {
        this(SpecialSubscriberAttributesKt.getSubscriberAttributeKey(key), str, (DateProvider) null, setTime, z4, 4, (AbstractC1585j) null);
        r.f(key, "key");
        r.f(dateProvider, "dateProvider");
        r.f(setTime, "setTime");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SubscriberAttribute(JSONObject jsonObject) throws JSONException {
        r.f(jsonObject, "jsonObject");
        String string = jsonObject.getString("key");
        r.e(string, "jsonObject.getString(JSON_NAME_KEY)");
        this(SpecialSubscriberAttributesKt.getSubscriberAttributeKey(string), JSONObjectExtensionsKt.getNullableString(jsonObject, "value"), (DateProvider) null, new Date(jsonObject.getLong(SubscriberAttributeKt.JSON_NAME_SET_TIME)), jsonObject.getBoolean(SubscriberAttributeKt.JSON_NAME_IS_SYNCED), 4, (AbstractC1585j) null);
    }
}
