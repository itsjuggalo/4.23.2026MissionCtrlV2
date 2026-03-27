package com.revenuecat.purchases.paywalls.events;

import F3.b;
import H3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.k0;
import K3.a;
import com.revenuecat.purchases.utils.JsonElementExtensionsKt;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PaywallPostReceiptData {
    public static final Companion Companion = new Companion(null);
    private static final a.C0033a json = a.f1326d;
    private final boolean darkMode;
    private final String displayMode;
    private final String localeIdentifier;
    private final String offeringId;
    private final int revision;
    private final String sessionID;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final a.C0033a getJson() {
            return PaywallPostReceiptData.json;
        }

        public final b serializer() {
            return PaywallPostReceiptData$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ PaywallPostReceiptData(int i4, String str, int i5, String str2, boolean z4, String str3, String str4, k0 k0Var) {
        if (63 != (i4 & 63)) {
            AbstractC0325a0.a(i4, 63, PaywallPostReceiptData$$serializer.INSTANCE.getDescriptor());
        }
        this.sessionID = str;
        this.revision = i5;
        this.displayMode = str2;
        this.darkMode = z4;
        this.localeIdentifier = str3;
        this.offeringId = str4;
    }

    public static /* synthetic */ PaywallPostReceiptData copy$default(PaywallPostReceiptData paywallPostReceiptData, String str, int i4, String str2, boolean z4, String str3, String str4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = paywallPostReceiptData.sessionID;
        }
        if ((i5 & 2) != 0) {
            i4 = paywallPostReceiptData.revision;
        }
        if ((i5 & 4) != 0) {
            str2 = paywallPostReceiptData.displayMode;
        }
        if ((i5 & 8) != 0) {
            z4 = paywallPostReceiptData.darkMode;
        }
        if ((i5 & 16) != 0) {
            str3 = paywallPostReceiptData.localeIdentifier;
        }
        if ((i5 & 32) != 0) {
            str4 = paywallPostReceiptData.offeringId;
        }
        String str5 = str3;
        String str6 = str4;
        return paywallPostReceiptData.copy(str, i4, str2, z4, str5, str6);
    }

    public static /* synthetic */ void getDarkMode$annotations() {
    }

    public static /* synthetic */ void getDisplayMode$annotations() {
    }

    public static /* synthetic */ void getLocaleIdentifier$annotations() {
    }

    public static /* synthetic */ void getOfferingId$annotations() {
    }

    public static /* synthetic */ void getRevision$annotations() {
    }

    public static /* synthetic */ void getSessionID$annotations() {
    }

    public static final /* synthetic */ void write$Self(PaywallPostReceiptData paywallPostReceiptData, d dVar, e eVar) {
        dVar.o(eVar, 0, paywallPostReceiptData.sessionID);
        dVar.k(eVar, 1, paywallPostReceiptData.revision);
        dVar.o(eVar, 2, paywallPostReceiptData.displayMode);
        dVar.y(eVar, 3, paywallPostReceiptData.darkMode);
        dVar.o(eVar, 4, paywallPostReceiptData.localeIdentifier);
        dVar.o(eVar, 5, paywallPostReceiptData.offeringId);
    }

    public final String component1() {
        return this.sessionID;
    }

    public final int component2() {
        return this.revision;
    }

    public final String component3() {
        return this.displayMode;
    }

    public final boolean component4() {
        return this.darkMode;
    }

    public final String component5() {
        return this.localeIdentifier;
    }

    public final String component6() {
        return this.offeringId;
    }

    public final PaywallPostReceiptData copy(String sessionID, int i4, String displayMode, boolean z4, String localeIdentifier, String offeringId) {
        r.f(sessionID, "sessionID");
        r.f(displayMode, "displayMode");
        r.f(localeIdentifier, "localeIdentifier");
        r.f(offeringId, "offeringId");
        return new PaywallPostReceiptData(sessionID, i4, displayMode, z4, localeIdentifier, offeringId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallPostReceiptData)) {
            return false;
        }
        PaywallPostReceiptData paywallPostReceiptData = (PaywallPostReceiptData) obj;
        return r.b(this.sessionID, paywallPostReceiptData.sessionID) && this.revision == paywallPostReceiptData.revision && r.b(this.displayMode, paywallPostReceiptData.displayMode) && this.darkMode == paywallPostReceiptData.darkMode && r.b(this.localeIdentifier, paywallPostReceiptData.localeIdentifier) && r.b(this.offeringId, paywallPostReceiptData.offeringId);
    }

    public final boolean getDarkMode() {
        return this.darkMode;
    }

    public final String getDisplayMode() {
        return this.displayMode;
    }

    public final String getLocaleIdentifier() {
        return this.localeIdentifier;
    }

    public final String getOfferingId() {
        return this.offeringId;
    }

    public final int getRevision() {
        return this.revision;
    }

    public final String getSessionID() {
        return this.sessionID;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    public int hashCode() {
        int iHashCode = ((((this.sessionID.hashCode() * 31) + Integer.hashCode(this.revision)) * 31) + this.displayMode.hashCode()) * 31;
        boolean z4 = this.darkMode;
        ?? r12 = z4;
        if (z4) {
            r12 = 1;
        }
        return ((((iHashCode + r12) * 31) + this.localeIdentifier.hashCode()) * 31) + this.offeringId.hashCode();
    }

    public final Map<String, Object> toMap() {
        a.C0033a c0033a = json;
        c0033a.a();
        Map<String, Object> mapAsMap = JsonElementExtensionsKt.asMap(c0033a.e(Companion.serializer(), this));
        if (mapAsMap == null) {
            return null;
        }
        return MapExtensionsKt.filterNotNullValues(mapAsMap);
    }

    public String toString() {
        return "PaywallPostReceiptData(sessionID=" + this.sessionID + ", revision=" + this.revision + ", displayMode=" + this.displayMode + ", darkMode=" + this.darkMode + ", localeIdentifier=" + this.localeIdentifier + ", offeringId=" + this.offeringId + ')';
    }

    public PaywallPostReceiptData(String sessionID, int i4, String displayMode, boolean z4, String localeIdentifier, String offeringId) {
        r.f(sessionID, "sessionID");
        r.f(displayMode, "displayMode");
        r.f(localeIdentifier, "localeIdentifier");
        r.f(offeringId, "offeringId");
        this.sessionID = sessionID;
        this.revision = i4;
        this.displayMode = displayMode;
        this.darkMode = z4;
        this.localeIdentifier = localeIdentifier;
        this.offeringId = offeringId;
    }
}
