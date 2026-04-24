package com.revenuecat.purchases.hybridcommon.mappers;

import H5.i;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.EntitlementInfos;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2489q;
import o5.w;
import p5.L;
import p5.M;
import p5.r;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"map", "", "", "", "Lcom/revenuecat/purchases/EntitlementInfos;", "hybridcommon_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EntitlementInfosMapperKt {
    public static final Map<String, Object> map(EntitlementInfos entitlementInfos) {
        AbstractC2304t.f(entitlementInfos, "<this>");
        Set<Map.Entry<String, EntitlementInfo>> setEntrySet = entitlementInfos.getAll().entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(i.b(L.d(r.s(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            C2489q c2489qA = w.a(entry.getKey(), EntitlementInfoMapperKt.map((EntitlementInfo) entry.getValue()));
            linkedHashMap.put(c2489qA.c(), c2489qA.d());
        }
        C2489q c2489qA2 = w.a("all", linkedHashMap);
        Set<Map.Entry<String, EntitlementInfo>> setEntrySet2 = entitlementInfos.getActive().entrySet();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(i.b(L.d(r.s(setEntrySet2, 10)), 16));
        Iterator<T> it2 = setEntrySet2.iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            C2489q c2489qA3 = w.a(entry2.getKey(), EntitlementInfoMapperKt.map((EntitlementInfo) entry2.getValue()));
            linkedHashMap2.put(c2489qA3.c(), c2489qA3.d());
        }
        return M.k(c2489qA2, w.a(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, linkedHashMap2), w.a("verification", entitlementInfos.getVerification().name()));
    }
}
