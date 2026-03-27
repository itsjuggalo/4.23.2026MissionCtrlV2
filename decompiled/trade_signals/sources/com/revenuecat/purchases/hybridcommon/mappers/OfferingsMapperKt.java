package com.revenuecat.purchases.hybridcommon.mappers;

import B5.k;
import B5.o;
import Y6.AbstractC1005g;
import Y6.AbstractC1009i;
import Y6.I;
import Y6.L;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PresentedOfferingContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2491s;
import o5.C2470H;
import o5.C2489q;
import o5.w;
import p5.M;
import p5.r;
import s5.InterfaceC2707e;
import t5.AbstractC2751c;
import u5.AbstractC2785l;
import u5.InterfaceC2779f;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a3\u0010\t\u001a\u00020\u0007*\u00020\u00002 \u0010\b\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\n\u001a!\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u000bH\u0002¢\u0006\u0004\b\u0004\u0010\f\u001a3\u0010\t\u001a\u00020\u0007*\u00020\u000b2 \u0010\b\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\r\u001a\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u000e¢\u0006\u0004\b\u0004\u0010\u000f\u001a\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0010¢\u0006\u0004\b\u0004\u0010\u0011\u001a\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0012¢\u0006\u0004\b\u0004\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/Offerings;", "", "", "", "map", "(Lcom/revenuecat/purchases/Offerings;)Ljava/util/Map;", "Lkotlin/Function1;", "Lo5/H;", "callback", "mapAsync", "(Lcom/revenuecat/purchases/Offerings;LB5/k;)V", "Lcom/revenuecat/purchases/Offering;", "(Lcom/revenuecat/purchases/Offering;)Ljava/util/Map;", "(Lcom/revenuecat/purchases/Offering;LB5/k;)V", "Lcom/revenuecat/purchases/Package;", "(Lcom/revenuecat/purchases/Package;)Ljava/util/Map;", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "(Lcom/revenuecat/purchases/PresentedOfferingContext;)Ljava/util/Map;", "Lcom/revenuecat/purchases/PresentedOfferingContext$TargetingContext;", "(Lcom/revenuecat/purchases/PresentedOfferingContext$TargetingContext;)Ljava/util/Map;", "hybridcommon_release"}, k = 2, mv = {1, 8, 0})
public final class OfferingsMapperKt {

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.mappers.OfferingsMapperKt$mapAsync$1, reason: invalid class name */
    @InterfaceC2779f(c = "com.revenuecat.purchases.hybridcommon.mappers.OfferingsMapperKt$mapAsync$1", f = "OfferingsMapper.kt", l = {20}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LY6/L;", "Lo5/H;", "<anonymous>", "(LY6/L;)V"}, k = 3, mv = {1, 8, 0})
    public static final class AnonymousClass1 extends AbstractC2785l implements o {
        final /* synthetic */ k $callback;
        final /* synthetic */ Offerings $this_mapAsync;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(k kVar, Offerings offerings, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.$callback = kVar;
            this.$this_mapAsync = offerings;
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            return new AnonymousClass1(this.$callback, this.$this_mapAsync, interfaceC2707e);
        }

        @Override // B5.o
        public final Object invoke(L l8, InterfaceC2707e interfaceC2707e) {
            return ((AnonymousClass1) create(l8, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = AbstractC2751c.f();
            int i8 = this.label;
            if (i8 == 0) {
                AbstractC2491s.b(obj);
                I mapperDispatcher = MappersHelpersKt.getMapperDispatcher();
                OfferingsMapperKt$mapAsync$1$map$1 offeringsMapperKt$mapAsync$1$map$1 = new OfferingsMapperKt$mapAsync$1$map$1(this.$this_mapAsync, null);
                this.label = 1;
                obj = AbstractC1005g.g(mapperDispatcher, offeringsMapperKt$mapAsync$1$map$1, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC2491s.b(obj);
            }
            this.$callback.invoke((Map) obj);
            return C2470H.f21956a;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.mappers.OfferingsMapperKt$mapAsync$2, reason: invalid class name */
    @InterfaceC2779f(c = "com.revenuecat.purchases.hybridcommon.mappers.OfferingsMapperKt$mapAsync$2", f = "OfferingsMapper.kt", l = {44}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LY6/L;", "Lo5/H;", "<anonymous>", "(LY6/L;)V"}, k = 3, mv = {1, 8, 0})
    public static final class AnonymousClass2 extends AbstractC2785l implements o {
        final /* synthetic */ k $callback;
        final /* synthetic */ Offering $this_mapAsync;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(k kVar, Offering offering, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.$callback = kVar;
            this.$this_mapAsync = offering;
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            return new AnonymousClass2(this.$callback, this.$this_mapAsync, interfaceC2707e);
        }

        @Override // B5.o
        public final Object invoke(L l8, InterfaceC2707e interfaceC2707e) {
            return ((AnonymousClass2) create(l8, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = AbstractC2751c.f();
            int i8 = this.label;
            if (i8 == 0) {
                AbstractC2491s.b(obj);
                I mapperDispatcher = MappersHelpersKt.getMapperDispatcher();
                OfferingsMapperKt$mapAsync$2$map$1 offeringsMapperKt$mapAsync$2$map$1 = new OfferingsMapperKt$mapAsync$2$map$1(this.$this_mapAsync, null);
                this.label = 1;
                obj = AbstractC1005g.g(mapperDispatcher, offeringsMapperKt$mapAsync$2$map$1, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC2491s.b(obj);
            }
            this.$callback.invoke((Map) obj);
            return C2470H.f21956a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<String, Object> map(Offering offering) {
        C2489q c2489qA = w.a("identifier", offering.getIdentifier());
        C2489q c2489qA2 = w.a("serverDescription", offering.getServerDescription());
        C2489q c2489qA3 = w.a("metadata", offering.getMetadata());
        List<Package> availablePackages = offering.getAvailablePackages();
        ArrayList arrayList = new ArrayList(r.s(availablePackages, 10));
        Iterator<T> it = availablePackages.iterator();
        while (it.hasNext()) {
            arrayList.add(map((Package) it.next()));
        }
        C2489q c2489qA4 = w.a("availablePackages", arrayList);
        Package lifetime = offering.getLifetime();
        C2489q c2489qA5 = w.a("lifetime", lifetime != null ? map(lifetime) : null);
        Package annual = offering.getAnnual();
        C2489q c2489qA6 = w.a("annual", annual != null ? map(annual) : null);
        Package sixMonth = offering.getSixMonth();
        C2489q c2489qA7 = w.a("sixMonth", sixMonth != null ? map(sixMonth) : null);
        Package threeMonth = offering.getThreeMonth();
        C2489q c2489qA8 = w.a("threeMonth", threeMonth != null ? map(threeMonth) : null);
        Package twoMonth = offering.getTwoMonth();
        C2489q c2489qA9 = w.a("twoMonth", twoMonth != null ? map(twoMonth) : null);
        Package monthly = offering.getMonthly();
        C2489q c2489qA10 = w.a("monthly", monthly != null ? map(monthly) : null);
        Package weekly = offering.getWeekly();
        return M.k(c2489qA, c2489qA2, c2489qA3, c2489qA4, c2489qA5, c2489qA6, c2489qA7, c2489qA8, c2489qA9, c2489qA10, w.a("weekly", weekly != null ? map(weekly) : null));
    }

    public static final void mapAsync(Offering offering, k callback) {
        AbstractC2304t.f(offering, "<this>");
        AbstractC2304t.f(callback, "callback");
        AbstractC1009i.d(MappersHelpersKt.getMainScope(), null, null, new AnonymousClass2(callback, offering, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<String, Object> map(Offerings offerings) {
        Map<String, Offering> all = offerings.getAll();
        LinkedHashMap linkedHashMap = new LinkedHashMap(p5.L.d(all.size()));
        Iterator<T> it = all.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), map((Offering) entry.getValue()));
        }
        C2489q c2489qA = w.a("all", linkedHashMap);
        Offering current = offerings.getCurrent();
        return M.k(c2489qA, w.a("current", current != null ? map(current) : null));
    }

    public static final void mapAsync(Offerings offerings, k callback) {
        AbstractC2304t.f(offerings, "<this>");
        AbstractC2304t.f(callback, "callback");
        AbstractC1009i.d(MappersHelpersKt.getMainScope(), null, null, new AnonymousClass1(callback, offerings, null), 3, null);
    }

    public static final Map<String, Object> map(Package r52) {
        AbstractC2304t.f(r52, "<this>");
        return M.k(w.a("identifier", r52.getIdentifier()), w.a("packageType", r52.getPackageType().name()), w.a("product", StoreProductMapperKt.map(r52.getProduct())), w.a("offeringIdentifier", r52.getPresentedOfferingContext().getOfferingIdentifier()), w.a("presentedOfferingContext", map(r52.getPresentedOfferingContext())));
    }

    public static final Map<String, Object> map(PresentedOfferingContext.TargetingContext targetingContext) {
        AbstractC2304t.f(targetingContext, "<this>");
        return M.k(w.a("revision", Integer.valueOf(targetingContext.getRevision())), w.a("ruleId", targetingContext.getRuleId()));
    }

    public static final Map<String, Object> map(PresentedOfferingContext presentedOfferingContext) {
        AbstractC2304t.f(presentedOfferingContext, "<this>");
        C2489q c2489qA = w.a("offeringIdentifier", presentedOfferingContext.getOfferingIdentifier());
        C2489q c2489qA2 = w.a("placementIdentifier", presentedOfferingContext.getPlacementIdentifier());
        PresentedOfferingContext.TargetingContext targetingContext = presentedOfferingContext.getTargetingContext();
        return M.k(c2489qA, c2489qA2, w.a("targetingContext", targetingContext != null ? map(targetingContext) : null));
    }
}
