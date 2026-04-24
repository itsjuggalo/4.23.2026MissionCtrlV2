package com.revenuecat.purchases;

import F5.AbstractC0557o;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PresentedOfferingContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class OfferingsKt {
    public static final Offering withPresentedContext(Offering offering, String str, Offerings.Targeting targeting) {
        r.f(offering, "<this>");
        List<Package> availablePackages = offering.getAvailablePackages();
        ArrayList arrayList = new ArrayList(AbstractC0557o.q(availablePackages, 10));
        for (Package r12 : availablePackages) {
            PresentedOfferingContext presentedOfferingContext = r12.getPresentedOfferingContext();
            PresentedOfferingContext presentedOfferingContextCopy$default = PresentedOfferingContext.copy$default(presentedOfferingContext, null, str == null ? presentedOfferingContext.getPlacementIdentifier() : str, targeting != null ? new PresentedOfferingContext.TargetingContext(targeting.getRevision(), targeting.getRuleId()) : presentedOfferingContext.getTargetingContext(), 1, null);
            arrayList.add(new Package(r12.getIdentifier(), r12.getPackageType(), r12.getProduct().copyWithPresentedOfferingContext(presentedOfferingContextCopy$default), presentedOfferingContextCopy$default));
        }
        return new Offering(offering.getIdentifier(), offering.getServerDescription(), offering.getMetadata(), arrayList, offering.getPaywall(), offering.getPaywallComponents());
    }
}
