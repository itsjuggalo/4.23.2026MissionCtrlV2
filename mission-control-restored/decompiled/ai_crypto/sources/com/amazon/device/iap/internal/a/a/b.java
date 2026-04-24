package com.amazon.device.iap.internal.a.a;

import com.amazon.d.a.j;
import com.amazon.device.iap.internal.model.ProductBuilder;
import com.amazon.device.iap.internal.model.ProductDataResponseBuilder;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.ProductType;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10286d = "b";

    public b(com.amazon.device.iap.internal.a.c cVar, Set<String> set) {
        super(cVar, "1.0", set);
    }

    private Product a(String str, Map map) {
        String str2 = (String) map.get(str);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            ProductType productTypeValueOf = ProductType.valueOf(jSONObject.getString(com.amazon.a.a.o.b.f9948k).toUpperCase());
            String string = jSONObject.getString(com.amazon.a.a.o.b.f9940c);
            String strOptString = jSONObject.optString(com.amazon.a.a.o.b.f9961x);
            return new ProductBuilder().setSku(str).setProductType(productTypeValueOf).setDescription(string).setPrice(strOptString).setSmallIconUrl(jSONObject.getString(com.amazon.a.a.o.b.f9947j)).setTitle(jSONObject.getString(com.amazon.a.a.o.b.f9930S)).setCoinsRewardAmount(jSONObject.optInt(com.amazon.a.a.o.b.f9931T, 0)).build();
        } catch (JSONException unused) {
            throw new IllegalArgumentException("error in parsing json string" + str2);
        }
    }

    @Override // com.amazon.a.a.n.a.h
    public boolean b(j jVar) {
        Map mapB = jVar.b();
        com.amazon.device.iap.internal.util.b.a(f10286d, "data: " + mapB);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        HashMap map = new HashMap();
        for (String str : ((a) this).f10285c) {
            if (mapB.containsKey(str)) {
                try {
                    map.put(str, a(str, mapB));
                } catch (IllegalArgumentException e7) {
                    linkedHashSet.add(str);
                    com.amazon.device.iap.internal.util.b.b(f10286d, "Error parsing JSON for SKU " + str + ": " + e7.getMessage());
                }
            } else {
                linkedHashSet.add(str);
            }
        }
        com.amazon.device.iap.internal.a.c cVar = (com.amazon.device.iap.internal.a.c) j();
        cVar.a().a(new ProductDataResponseBuilder().setRequestId(cVar.d()).setRequestStatus(ProductDataResponse.RequestStatus.SUCCESSFUL).setUnavailableSkus(linkedHashSet).setProductData(map).build());
        return true;
    }
}
