package com.revenuecat.purchases;

import java.util.Map;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class Offerings {
    private final Map<String, Offering> all;
    private final Offering current;
    private final Placements placements;
    private final Targeting targeting;

    public static final class Placements {
        private final String fallbackOfferingId;
        private final Map<String, String> offeringIdsByPlacement;

        public Placements(String str, Map<String, String> offeringIdsByPlacement) {
            r.f(offeringIdsByPlacement, "offeringIdsByPlacement");
            this.fallbackOfferingId = str;
            this.offeringIdsByPlacement = offeringIdsByPlacement;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Placements copy$default(Placements placements, String str, Map map, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = placements.fallbackOfferingId;
            }
            if ((i4 & 2) != 0) {
                map = placements.offeringIdsByPlacement;
            }
            return placements.copy(str, map);
        }

        public final String component1() {
            return this.fallbackOfferingId;
        }

        public final Map<String, String> component2() {
            return this.offeringIdsByPlacement;
        }

        public final Placements copy(String str, Map<String, String> offeringIdsByPlacement) {
            r.f(offeringIdsByPlacement, "offeringIdsByPlacement");
            return new Placements(str, offeringIdsByPlacement);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Placements)) {
                return false;
            }
            Placements placements = (Placements) obj;
            return r.b(this.fallbackOfferingId, placements.fallbackOfferingId) && r.b(this.offeringIdsByPlacement, placements.offeringIdsByPlacement);
        }

        public final String getFallbackOfferingId() {
            return this.fallbackOfferingId;
        }

        public final Map<String, String> getOfferingIdsByPlacement() {
            return this.offeringIdsByPlacement;
        }

        public int hashCode() {
            String str = this.fallbackOfferingId;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.offeringIdsByPlacement.hashCode();
        }

        public String toString() {
            return "Placements(fallbackOfferingId=" + this.fallbackOfferingId + ", offeringIdsByPlacement=" + this.offeringIdsByPlacement + ')';
        }
    }

    public static final class Targeting {
        private final int revision;
        private final String ruleId;

        public Targeting(int i4, String ruleId) {
            r.f(ruleId, "ruleId");
            this.revision = i4;
            this.ruleId = ruleId;
        }

        public static /* synthetic */ Targeting copy$default(Targeting targeting, int i4, String str, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i4 = targeting.revision;
            }
            if ((i5 & 2) != 0) {
                str = targeting.ruleId;
            }
            return targeting.copy(i4, str);
        }

        public final int component1() {
            return this.revision;
        }

        public final String component2() {
            return this.ruleId;
        }

        public final Targeting copy(int i4, String ruleId) {
            r.f(ruleId, "ruleId");
            return new Targeting(i4, ruleId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Targeting)) {
                return false;
            }
            Targeting targeting = (Targeting) obj;
            return this.revision == targeting.revision && r.b(this.ruleId, targeting.ruleId);
        }

        public final int getRevision() {
            return this.revision;
        }

        public final String getRuleId() {
            return this.ruleId;
        }

        public int hashCode() {
            return (Integer.hashCode(this.revision) * 31) + this.ruleId.hashCode();
        }

        public String toString() {
            return "Targeting(revision=" + this.revision + ", ruleId=" + this.ruleId + ')';
        }
    }

    public Offerings(Offering offering, Map<String, Offering> all, Placements placements, Targeting targeting) {
        r.f(all, "all");
        this.current = offering;
        this.all = all;
        this.placements = placements;
        this.targeting = targeting;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Offerings copy$default(Offerings offerings, Offering offering, Map map, Placements placements, Targeting targeting, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            offering = offerings.current;
        }
        if ((i4 & 2) != 0) {
            map = offerings.all;
        }
        if ((i4 & 4) != 0) {
            placements = offerings.placements;
        }
        if ((i4 & 8) != 0) {
            targeting = offerings.targeting;
        }
        return offerings.copy(offering, map, placements, targeting);
    }

    public final Offering component1() {
        return this.current;
    }

    public final Map<String, Offering> component2() {
        return this.all;
    }

    public final Placements component3$purchases_defaultsRelease() {
        return this.placements;
    }

    public final Targeting component4$purchases_defaultsRelease() {
        return this.targeting;
    }

    public final Offerings copy(Offering offering, Map<String, Offering> all, Placements placements, Targeting targeting) {
        r.f(all, "all");
        return new Offerings(offering, all, placements, targeting);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Offerings)) {
            return false;
        }
        Offerings offerings = (Offerings) obj;
        return r.b(this.current, offerings.current) && r.b(this.all, offerings.all) && r.b(this.placements, offerings.placements) && r.b(this.targeting, offerings.targeting);
    }

    public final Offering get(String identifier) {
        r.f(identifier, "identifier");
        return getOffering(identifier);
    }

    public final Map<String, Offering> getAll() {
        return this.all;
    }

    public final Offering getCurrent() {
        return this.current;
    }

    public final Offering getCurrentOfferingForPlacement(String placementId) {
        r.f(placementId, "placementId");
        Placements placements = this.placements;
        if (placements == null) {
            return null;
        }
        String str = placements.getOfferingIdsByPlacement().get(placementId);
        Offering offering = str != null ? getOffering(str) : null;
        String fallbackOfferingId = placements.getFallbackOfferingId();
        Offering offering2 = fallbackOfferingId != null ? getOffering(fallbackOfferingId) : null;
        boolean zContainsKey = placements.getOfferingIdsByPlacement().containsKey(placementId);
        if (offering == null) {
            offering = zContainsKey ? null : offering2;
        }
        if (offering != null) {
            return OfferingsKt.withPresentedContext(offering, placementId, this.targeting);
        }
        return null;
    }

    public final Offering getOffering(String identifier) {
        r.f(identifier, "identifier");
        return this.all.get(identifier);
    }

    public final Placements getPlacements$purchases_defaultsRelease() {
        return this.placements;
    }

    public final Targeting getTargeting$purchases_defaultsRelease() {
        return this.targeting;
    }

    public int hashCode() {
        Offering offering = this.current;
        int iHashCode = (((offering == null ? 0 : offering.hashCode()) * 31) + this.all.hashCode()) * 31;
        Placements placements = this.placements;
        int iHashCode2 = (iHashCode + (placements == null ? 0 : placements.hashCode())) * 31;
        Targeting targeting = this.targeting;
        return iHashCode2 + (targeting != null ? targeting.hashCode() : 0);
    }

    public String toString() {
        return "Offerings(current=" + this.current + ", all=" + this.all + ", placements=" + this.placements + ", targeting=" + this.targeting + ')';
    }

    public /* synthetic */ Offerings(Offering offering, Map map, Placements placements, Targeting targeting, int i4, AbstractC1585j abstractC1585j) {
        this(offering, map, (i4 & 4) != 0 ? null : placements, (i4 & 8) != 0 ? null : targeting);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Offerings(Offering offering, Map<String, Offering> all) {
        this(offering, all, null, null);
        r.f(all, "all");
    }
}
