package com.revenuecat.purchases.hybridcommon.mappers;

import W2.o;
import W2.t;
import X2.AbstractC0770q;
import X2.K;
import X2.L;
import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.EntitlementInfos;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.r;
import o3.AbstractC1681l;

/* JADX INFO: loaded from: classes3.dex */
public final class EntitlementInfosMapperKt {
    public static final Map<String, Object> map(EntitlementInfos entitlementInfos) {
        r.f(entitlementInfos, "<this>");
        Set<Map.Entry<String, EntitlementInfo>> setEntrySet = entitlementInfos.getAll().entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC1681l.b(K.b(AbstractC0770q.q(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            o oVarA = t.a(entry.getKey(), EntitlementInfoMapperKt.map((EntitlementInfo) entry.getValue()));
            linkedHashMap.put(oVarA.c(), oVarA.d());
        }
        o oVarA2 = t.a("all", linkedHashMap);
        Set<Map.Entry<String, EntitlementInfo>> setEntrySet2 = entitlementInfos.getActive().entrySet();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(AbstractC1681l.b(K.b(AbstractC0770q.q(setEntrySet2, 10)), 16));
        Iterator<T> it2 = setEntrySet2.iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            o oVarA3 = t.a(entry2.getKey(), EntitlementInfoMapperKt.map((EntitlementInfo) entry2.getValue()));
            linkedHashMap2.put(oVarA3.c(), oVarA3.d());
        }
        return L.g(oVarA2, t.a("active", linkedHashMap2), t.a("verification", entitlementInfos.getVerification().name()));
    }
}
