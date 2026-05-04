package com.revenuecat.purchases.hybridcommon.mappers;

import cd.h0;
import cd.q;
import cd.s;
import cd.w;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PresentedOfferingContext;
import dd.o0;
import gd.e;
import hd.c;
import id.f;
import id.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import ng.i;
import ng.k0;
import ng.n0;
import pd.k;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a3\u0010\t\u001a\u00020\u0007*\u00020\u00002 \u0010\b\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\n\u001a!\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u000bH\u0002¢\u0006\u0004\b\u0004\u0010\f\u001a3\u0010\t\u001a\u00020\u0007*\u00020\u000b2 \u0010\b\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\r\u001a\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u000e¢\u0006\u0004\b\u0004\u0010\u000f\u001a\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0010¢\u0006\u0004\b\u0004\u0010\u0011\u001a\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0012¢\u0006\u0004\b\u0004\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/Offerings;", "", "", "", "map", "(Lcom/revenuecat/purchases/Offerings;)Ljava/util/Map;", "Lkotlin/Function1;", "Lcd/h0;", "callback", "mapAsync", "(Lcom/revenuecat/purchases/Offerings;Lpd/k;)V", "Lcom/revenuecat/purchases/Offering;", "(Lcom/revenuecat/purchases/Offering;)Ljava/util/Map;", "(Lcom/revenuecat/purchases/Offering;Lpd/k;)V", "Lcom/revenuecat/purchases/Package;", "(Lcom/revenuecat/purchases/Package;)Ljava/util/Map;", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "(Lcom/revenuecat/purchases/PresentedOfferingContext;)Ljava/util/Map;", "Lcom/revenuecat/purchases/PresentedOfferingContext$TargetingContext;", "(Lcom/revenuecat/purchases/PresentedOfferingContext$TargetingContext;)Ljava/util/Map;", "hybridcommon_bc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OfferingsMapperKt {

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.mappers.OfferingsMapperKt$mapAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lng/n0;", "Lcd/h0;", "<anonymous>", "(Lng/n0;)V"}, k = 3, mv = {1, 8, 0})
    @f(c = "com.revenuecat.purchases.hybridcommon.mappers.OfferingsMapperKt$mapAsync$1", f = "OfferingsMapper.kt", l = {20}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends m implements o {
        final /* synthetic */ k $callback;
        final /* synthetic */ Offerings $this_mapAsync;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(k kVar, Offerings offerings, e eVar) {
            super(2, eVar);
            this.$callback = kVar;
            this.$this_mapAsync = offerings;
        }

        @Override // id.a
        public final e create(Object obj, e eVar) {
            return new AnonymousClass1(this.$callback, this.$this_mapAsync, eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = c.f();
            int i10 = this.label;
            if (i10 == 0) {
                s.b(obj);
                k0 mapperDispatcher = MappersHelpersKt.getMapperDispatcher();
                OfferingsMapperKt$mapAsync$1$map$1 offeringsMapperKt$mapAsync$1$map$1 = new OfferingsMapperKt$mapAsync$1$map$1(this.$this_mapAsync, null);
                this.label = 1;
                obj = i.g(mapperDispatcher, offeringsMapperKt$mapAsync$1$map$1, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                s.b(obj);
            }
            this.$callback.invoke((Map) obj);
            return h0.f3852a;
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, e eVar) {
            return ((AnonymousClass1) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.mappers.OfferingsMapperKt$mapAsync$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lng/n0;", "Lcd/h0;", "<anonymous>", "(Lng/n0;)V"}, k = 3, mv = {1, 8, 0})
    @f(c = "com.revenuecat.purchases.hybridcommon.mappers.OfferingsMapperKt$mapAsync$2", f = "OfferingsMapper.kt", l = {44}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends m implements o {
        final /* synthetic */ k $callback;
        final /* synthetic */ Offering $this_mapAsync;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(k kVar, Offering offering, e eVar) {
            super(2, eVar);
            this.$callback = kVar;
            this.$this_mapAsync = offering;
        }

        @Override // id.a
        public final e create(Object obj, e eVar) {
            return new AnonymousClass2(this.$callback, this.$this_mapAsync, eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = c.f();
            int i10 = this.label;
            if (i10 == 0) {
                s.b(obj);
                k0 mapperDispatcher = MappersHelpersKt.getMapperDispatcher();
                OfferingsMapperKt$mapAsync$2$map$1 offeringsMapperKt$mapAsync$2$map$1 = new OfferingsMapperKt$mapAsync$2$map$1(this.$this_mapAsync, null);
                this.label = 1;
                obj = i.g(mapperDispatcher, offeringsMapperKt$mapAsync$2$map$1, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                s.b(obj);
            }
            this.$callback.invoke((Map) obj);
            return h0.f3852a;
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, e eVar) {
            return ((AnonymousClass2) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<String, Object> map(Offerings offerings) {
        Map<String, Offering> all = offerings.getAll();
        LinkedHashMap linkedHashMap = new LinkedHashMap(dd.n0.d(all.size()));
        Iterator<T> it = all.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), map((Offering) entry.getValue()));
        }
        q qVarA = w.a("all", linkedHashMap);
        Offering current = offerings.getCurrent();
        return o0.l(qVarA, w.a("current", current != null ? map(current) : null));
    }

    public static final void mapAsync(Offerings offerings, k callback) {
        t.f(offerings, "<this>");
        t.f(callback, "callback");
        ng.k.d(MappersHelpersKt.getMainScope(), null, null, new AnonymousClass1(callback, offerings, null), 3, null);
    }

    public static final void mapAsync(Offering offering, k callback) {
        t.f(offering, "<this>");
        t.f(callback, "callback");
        ng.k.d(MappersHelpersKt.getMainScope(), null, null, new AnonymousClass2(callback, offering, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<String, Object> map(Offering offering) {
        q qVarA = w.a("identifier", offering.getIdentifier());
        q qVarA2 = w.a("serverDescription", offering.getServerDescription());
        q qVarA3 = w.a("metadata", offering.getMetadata());
        List<Package> availablePackages = offering.getAvailablePackages();
        ArrayList arrayList = new ArrayList(dd.s.u(availablePackages, 10));
        Iterator<T> it = availablePackages.iterator();
        while (it.hasNext()) {
            arrayList.add(map((Package) it.next()));
        }
        q qVarA4 = w.a("availablePackages", arrayList);
        Package lifetime = offering.getLifetime();
        q qVarA5 = w.a("lifetime", lifetime != null ? map(lifetime) : null);
        Package annual = offering.getAnnual();
        q qVarA6 = w.a("annual", annual != null ? map(annual) : null);
        Package sixMonth = offering.getSixMonth();
        q qVarA7 = w.a("sixMonth", sixMonth != null ? map(sixMonth) : null);
        Package threeMonth = offering.getThreeMonth();
        q qVarA8 = w.a("threeMonth", threeMonth != null ? map(threeMonth) : null);
        Package twoMonth = offering.getTwoMonth();
        q qVarA9 = w.a("twoMonth", twoMonth != null ? map(twoMonth) : null);
        Package monthly = offering.getMonthly();
        q qVarA10 = w.a("monthly", monthly != null ? map(monthly) : null);
        Package weekly = offering.getWeekly();
        return o0.l(qVarA, qVarA2, qVarA3, qVarA4, qVarA5, qVarA6, qVarA7, qVarA8, qVarA9, qVarA10, w.a("weekly", weekly != null ? map(weekly) : null));
    }

    public static final Map<String, Object> map(Package r52) {
        t.f(r52, "<this>");
        return o0.l(w.a("identifier", r52.getIdentifier()), w.a("packageType", r52.getPackageType().name()), w.a("product", StoreProductMapperKt.map(r52.getProduct())), w.a("offeringIdentifier", r52.getPresentedOfferingContext().getOfferingIdentifier()), w.a("presentedOfferingContext", map(r52.getPresentedOfferingContext())));
    }

    public static final Map<String, Object> map(PresentedOfferingContext presentedOfferingContext) {
        t.f(presentedOfferingContext, "<this>");
        q qVarA = w.a("offeringIdentifier", presentedOfferingContext.getOfferingIdentifier());
        q qVarA2 = w.a("placementIdentifier", presentedOfferingContext.getPlacementIdentifier());
        PresentedOfferingContext.TargetingContext targetingContext = presentedOfferingContext.getTargetingContext();
        return o0.l(qVarA, qVarA2, w.a("targetingContext", targetingContext != null ? map(targetingContext) : null));
    }

    public static final Map<String, Object> map(PresentedOfferingContext.TargetingContext targetingContext) {
        t.f(targetingContext, "<this>");
        return o0.l(w.a("revision", Integer.valueOf(targetingContext.getRevision())), w.a("ruleId", targetingContext.getRuleId()));
    }
}
