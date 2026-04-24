package com.revenuecat.purchases.hybridcommon.mappers;

import W2.E;
import W2.q;
import W2.t;
import X2.AbstractC0770q;
import X2.K;
import Z2.e;
import a3.AbstractC0787c;
import b3.InterfaceC0868f;
import b3.l;
import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PresentedOfferingContext;
import i3.k;
import i3.o;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import t3.AbstractC1818i;
import t3.AbstractC1822k;
import t3.I;
import t3.L;

/* JADX INFO: loaded from: classes3.dex */
public final class OfferingsMapperKt {

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.mappers.OfferingsMapperKt$mapAsync$1, reason: invalid class name */
    @InterfaceC0868f(c = "com.revenuecat.purchases.hybridcommon.mappers.OfferingsMapperKt$mapAsync$1", f = "OfferingsMapper.kt", l = {FirestoreIndexValueWriter.INDEX_TYPE_TIMESTAMP}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends l implements o {
        final /* synthetic */ k $callback;
        final /* synthetic */ Offerings $this_mapAsync;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(k kVar, Offerings offerings, e eVar) {
            super(2, eVar);
            this.$callback = kVar;
            this.$this_mapAsync = offerings;
        }

        @Override // b3.AbstractC0863a
        public final e create(Object obj, e eVar) {
            return new AnonymousClass1(this.$callback, this.$this_mapAsync, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            if (i4 == 0) {
                q.b(obj);
                I mapperDispatcher = MappersHelpersKt.getMapperDispatcher();
                OfferingsMapperKt$mapAsync$1$map$1 offeringsMapperKt$mapAsync$1$map$1 = new OfferingsMapperKt$mapAsync$1$map$1(this.$this_mapAsync, null);
                this.label = 1;
                obj = AbstractC1818i.g(mapperDispatcher, offeringsMapperKt$mapAsync$1$map$1, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.b(obj);
            }
            this.$callback.invoke((Map) obj);
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(L l4, e eVar) {
            return ((AnonymousClass1) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.mappers.OfferingsMapperKt$mapAsync$2, reason: invalid class name */
    @InterfaceC0868f(c = "com.revenuecat.purchases.hybridcommon.mappers.OfferingsMapperKt$mapAsync$2", f = "OfferingsMapper.kt", l = {44}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends l implements o {
        final /* synthetic */ k $callback;
        final /* synthetic */ Offering $this_mapAsync;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(k kVar, Offering offering, e eVar) {
            super(2, eVar);
            this.$callback = kVar;
            this.$this_mapAsync = offering;
        }

        @Override // b3.AbstractC0863a
        public final e create(Object obj, e eVar) {
            return new AnonymousClass2(this.$callback, this.$this_mapAsync, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            if (i4 == 0) {
                q.b(obj);
                I mapperDispatcher = MappersHelpersKt.getMapperDispatcher();
                OfferingsMapperKt$mapAsync$2$map$1 offeringsMapperKt$mapAsync$2$map$1 = new OfferingsMapperKt$mapAsync$2$map$1(this.$this_mapAsync, null);
                this.label = 1;
                obj = AbstractC1818i.g(mapperDispatcher, offeringsMapperKt$mapAsync$2$map$1, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.b(obj);
            }
            this.$callback.invoke((Map) obj);
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(L l4, e eVar) {
            return ((AnonymousClass2) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<String, Object> map(Offerings offerings) {
        Map<String, Offering> all = offerings.getAll();
        LinkedHashMap linkedHashMap = new LinkedHashMap(K.b(all.size()));
        Iterator<T> it = all.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), map((Offering) entry.getValue()));
        }
        W2.o oVarA = t.a("all", linkedHashMap);
        Offering current = offerings.getCurrent();
        return X2.L.g(oVarA, t.a("current", current != null ? map(current) : null));
    }

    public static final void mapAsync(Offerings offerings, k callback) {
        r.f(offerings, "<this>");
        r.f(callback, "callback");
        AbstractC1822k.d(MappersHelpersKt.getMainScope(), null, null, new AnonymousClass1(callback, offerings, null), 3, null);
    }

    public static final void mapAsync(Offering offering, k callback) {
        r.f(offering, "<this>");
        r.f(callback, "callback");
        AbstractC1822k.d(MappersHelpersKt.getMainScope(), null, null, new AnonymousClass2(callback, offering, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<String, Object> map(Offering offering) {
        W2.o oVarA = t.a(Constants.IDENTIFIER, offering.getIdentifier());
        W2.o oVarA2 = t.a("serverDescription", offering.getServerDescription());
        W2.o oVarA3 = t.a("metadata", offering.getMetadata());
        List<Package> availablePackages = offering.getAvailablePackages();
        ArrayList arrayList = new ArrayList(AbstractC0770q.q(availablePackages, 10));
        Iterator<T> it = availablePackages.iterator();
        while (it.hasNext()) {
            arrayList.add(map((Package) it.next()));
        }
        W2.o oVarA4 = t.a("availablePackages", arrayList);
        Package lifetime = offering.getLifetime();
        W2.o oVarA5 = t.a("lifetime", lifetime != null ? map(lifetime) : null);
        Package annual = offering.getAnnual();
        W2.o oVarA6 = t.a("annual", annual != null ? map(annual) : null);
        Package sixMonth = offering.getSixMonth();
        W2.o oVarA7 = t.a("sixMonth", sixMonth != null ? map(sixMonth) : null);
        Package threeMonth = offering.getThreeMonth();
        W2.o oVarA8 = t.a("threeMonth", threeMonth != null ? map(threeMonth) : null);
        Package twoMonth = offering.getTwoMonth();
        W2.o oVarA9 = t.a("twoMonth", twoMonth != null ? map(twoMonth) : null);
        Package monthly = offering.getMonthly();
        W2.o oVarA10 = t.a("monthly", monthly != null ? map(monthly) : null);
        Package weekly = offering.getWeekly();
        return X2.L.g(oVarA, oVarA2, oVarA3, oVarA4, oVarA5, oVarA6, oVarA7, oVarA8, oVarA9, oVarA10, t.a("weekly", weekly != null ? map(weekly) : null));
    }

    public static final Map<String, Object> map(Package r5) {
        r.f(r5, "<this>");
        return X2.L.g(t.a(Constants.IDENTIFIER, r5.getIdentifier()), t.a("packageType", r5.getPackageType().name()), t.a("product", StoreProductMapperKt.map(r5.getProduct())), t.a("offeringIdentifier", r5.getPresentedOfferingContext().getOfferingIdentifier()), t.a("presentedOfferingContext", map(r5.getPresentedOfferingContext())));
    }

    public static final Map<String, Object> map(PresentedOfferingContext presentedOfferingContext) {
        r.f(presentedOfferingContext, "<this>");
        W2.o oVarA = t.a("offeringIdentifier", presentedOfferingContext.getOfferingIdentifier());
        W2.o oVarA2 = t.a("placementIdentifier", presentedOfferingContext.getPlacementIdentifier());
        PresentedOfferingContext.TargetingContext targetingContext = presentedOfferingContext.getTargetingContext();
        return X2.L.g(oVarA, oVarA2, t.a("targetingContext", targetingContext != null ? map(targetingContext) : null));
    }

    public static final Map<String, Object> map(PresentedOfferingContext.TargetingContext targetingContext) {
        r.f(targetingContext, "<this>");
        return X2.L.g(t.a("revision", Integer.valueOf(targetingContext.getRevision())), t.a("ruleId", targetingContext.getRuleId()));
    }
}
