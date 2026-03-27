package com.revenuecat.purchases.common;

import X2.L;
import com.revenuecat.purchases.JsonTools;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PackageType;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class OfferingParser {
    public final Offering createOffering(JSONObject offeringJson, Map<String, ? extends List<? extends StoreProduct>> productsById, UiConfig uiConfig) throws JSONException {
        Map mapE;
        PaywallData paywallData;
        PaywallComponentsData paywallComponentsData;
        r.f(offeringJson, "offeringJson");
        r.f(productsById, "productsById");
        String offeringIdentifier = offeringJson.getString(io.flutter.plugins.firebase.crashlytics.Constants.IDENTIFIER);
        JSONObject jSONObjectOptJSONObject = offeringJson.optJSONObject("metadata");
        if (jSONObjectOptJSONObject == null || (mapE = JSONObjectExtensionsKt.toMap(jSONObjectOptJSONObject, true)) == null) {
            mapE = L.e();
        }
        Map map = mapE;
        JSONArray jSONArray = offeringJson.getJSONArray("packages");
        r.e(offeringIdentifier, "offeringIdentifier");
        PresentedOfferingContext presentedOfferingContext = new PresentedOfferingContext(offeringIdentifier);
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            JSONObject packageJson = jSONArray.getJSONObject(i4);
            r.e(packageJson, "packageJson");
            Package packageCreatePackage = createPackage(packageJson, productsById, presentedOfferingContext);
            if (packageCreatePackage != null) {
                arrayList.add(packageCreatePackage);
            }
        }
        JSONObject jSONObjectOptJSONObject2 = offeringJson.optJSONObject("paywall");
        if (jSONObjectOptJSONObject2 != null) {
            try {
                K3.a json = JsonTools.INSTANCE.getJson();
                String string = jSONObjectOptJSONObject2.toString();
                r.e(string, "it.toString()");
                json.a();
                paywallData = (PaywallData) json.d(PaywallData.Companion.serializer(), string);
            } catch (Exception e4) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error deserializing paywall data", e4);
                paywallData = null;
            }
        } else {
            paywallData = null;
        }
        JSONObject jSONObjectOptJSONObject3 = offeringJson.optJSONObject("paywall_components");
        if (jSONObjectOptJSONObject3 != null) {
            try {
                K3.a json2 = JsonTools.INSTANCE.getJson();
                String string2 = jSONObjectOptJSONObject3.toString();
                r.e(string2, "it.toString()");
                json2.a();
                paywallComponentsData = (PaywallComponentsData) json2.d(PaywallComponentsData.Companion.serializer(), string2);
            } catch (Throwable th) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error deserializing paywall components data", th);
                paywallComponentsData = null;
            }
        } else {
            paywallComponentsData = null;
        }
        Offering.PaywallComponents paywallComponents = (paywallComponentsData == null || uiConfig == null) ? null : new Offering.PaywallComponents(uiConfig, paywallComponentsData);
        if (arrayList.isEmpty()) {
            return null;
        }
        String string3 = offeringJson.getString(com.amazon.a.a.o.b.f8755c);
        r.e(string3, "offeringJson.getString(\"description\")");
        return new Offering(offeringIdentifier, string3, map, arrayList, paywallData, paywallComponents);
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0323  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.revenuecat.purchases.Offerings createOfferings(org.json.JSONObject r18, java.util.Map<java.lang.String, ? extends java.util.List<? extends com.revenuecat.purchases.models.StoreProduct>> r19) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 854
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.OfferingParser.createOfferings(org.json.JSONObject, java.util.Map):com.revenuecat.purchases.Offerings");
    }

    public final Package createPackage(JSONObject packageJson, Map<String, ? extends List<? extends StoreProduct>> productsById, PresentedOfferingContext presentedOfferingContext) throws JSONException {
        r.f(packageJson, "packageJson");
        r.f(productsById, "productsById");
        r.f(presentedOfferingContext, "presentedOfferingContext");
        String packageIdentifier = packageJson.getString(io.flutter.plugins.firebase.crashlytics.Constants.IDENTIFIER);
        StoreProduct storeProductFindMatchingProduct = findMatchingProduct(productsById, packageJson);
        r.e(packageIdentifier, "packageIdentifier");
        PackageType packageType = OfferingParserKt.toPackageType(packageIdentifier);
        if (storeProductFindMatchingProduct != null) {
            return new Package(packageIdentifier, packageType, storeProductFindMatchingProduct.copyWithPresentedOfferingContext(presentedOfferingContext), presentedOfferingContext);
        }
        return null;
    }

    public abstract StoreProduct findMatchingProduct(Map<String, ? extends List<? extends StoreProduct>> map, JSONObject jSONObject);
}
