package com.revenuecat.purchases.subscriberattributes.caching;

import W2.o;
import W2.t;
import X2.AbstractC0770q;
import X2.K;
import X2.L;
import android.content.SharedPreferences;
import com.amazon.a.a.o.c.a.b;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttribute;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesFactoriesKt;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.r;
import o3.AbstractC1681l;
import org.json.JSONObject;
import r3.AbstractC1753A;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscriberAttributesMigrationExtensionsKt {
    public static final synchronized Map<String, Map<String, SubscriberAttribute>> getAllLegacyStoredSubscriberAttributes(SubscriberAttributesCache subscriberAttributesCache) {
        LinkedHashMap linkedHashMap;
        Map<String, SubscriberAttribute> mapE;
        try {
            r.f(subscriberAttributesCache, "<this>");
            String strLegacySubscriberAttributesCacheKey = legacySubscriberAttributesCacheKey(subscriberAttributesCache, "");
            Set<String> setFindKeysThatStartWith = subscriberAttributesCache.getDeviceCache$purchases_defaultsRelease().findKeysThatStartWith(strLegacySubscriberAttributesCacheKey);
            linkedHashMap = new LinkedHashMap(AbstractC1681l.b(K.b(AbstractC0770q.q(setFindKeysThatStartWith, 10)), 16));
            for (String str : setFindKeysThatStartWith) {
                String str2 = (String) AbstractC1753A.t0(str, new String[]{strLegacySubscriberAttributesCacheKey}, false, 0, 6, null).get(1);
                JSONObject jSONObjectOrNull = subscriberAttributesCache.getDeviceCache$purchases_defaultsRelease().getJSONObjectOrNull(str);
                if (jSONObjectOrNull == null || (mapE = SubscriberAttributesFactoriesKt.buildLegacySubscriberAttributes(jSONObjectOrNull)) == null) {
                    mapE = L.e();
                }
                o oVarA = t.a(str2, mapE);
                linkedHashMap.put(oVarA.c(), oVarA.d());
            }
        } catch (Throwable th) {
            throw th;
        }
        return linkedHashMap;
    }

    public static final String legacySubscriberAttributesCacheKey(SubscriberAttributesCache subscriberAttributesCache, String appUserID) {
        r.f(subscriberAttributesCache, "<this>");
        r.f(appUserID, "appUserID");
        return subscriberAttributesCache.getSubscriberAttributesCacheKey$purchases_defaultsRelease() + b.f8816a + appUserID;
    }

    public static final synchronized void migrateSubscriberAttributes(SubscriberAttributesCache subscriberAttributesCache, Map<String, ? extends Map<String, SubscriberAttribute>> legacySubscriberAttributesForAppUserID, SharedPreferences.Editor cacheEditor) {
        try {
            r.f(subscriberAttributesCache, "<this>");
            r.f(legacySubscriberAttributesForAppUserID, "legacySubscriberAttributesForAppUserID");
            r.f(cacheEditor, "cacheEditor");
            Map<String, Map<String, SubscriberAttribute>> allStoredSubscriberAttributes = subscriberAttributesCache.getAllStoredSubscriberAttributes();
            Map mapU = L.u(allStoredSubscriberAttributes);
            for (Map.Entry<String, ? extends Map<String, SubscriberAttribute>> entry : legacySubscriberAttributesForAppUserID.entrySet()) {
                String key = entry.getKey();
                Map<String, SubscriberAttribute> value = entry.getValue();
                Map<String, SubscriberAttribute> mapE = allStoredSubscriberAttributes.get(key);
                if (mapE == null) {
                    mapE = L.e();
                }
                mapU.put(key, L.k(value, mapE));
                cacheEditor.remove(legacySubscriberAttributesCacheKey(subscriberAttributesCache, key));
            }
            cacheEditor.putString(subscriberAttributesCache.getSubscriberAttributesCacheKey$purchases_defaultsRelease(), CachingHelpersKt.toJSONObject(mapU).toString());
        } catch (Throwable th) {
            throw th;
        }
    }

    public static final synchronized void migrateSubscriberAttributesIfNeeded(SubscriberAttributesCache subscriberAttributesCache, SharedPreferences.Editor cacheEditor) {
        r.f(subscriberAttributesCache, "<this>");
        r.f(cacheEditor, "cacheEditor");
        Map<String, Map<String, SubscriberAttribute>> allLegacyStoredSubscriberAttributes = getAllLegacyStoredSubscriberAttributes(subscriberAttributesCache);
        if (allLegacyStoredSubscriberAttributes.isEmpty()) {
            allLegacyStoredSubscriberAttributes = null;
        }
        if (allLegacyStoredSubscriberAttributes != null) {
            migrateSubscriberAttributes(subscriberAttributesCache, allLegacyStoredSubscriberAttributes, cacheEditor);
        }
    }
}
