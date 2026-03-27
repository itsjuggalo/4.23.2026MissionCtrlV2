package com.revenuecat.purchases.common.networking;

import F3.b;
import H3.e;
import I3.d;
import J3.k0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class WebBillingPurchaseOption {
    public static final Companion Companion = new Companion(null);
    private final WebBillingPhase base;
    private final WebBillingPrice basePrice;
    private final WebBillingPhase introPrice;
    private final WebBillingPhase trial;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return WebBillingPurchaseOption$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public WebBillingPurchaseOption() {
        this((WebBillingPrice) null, (WebBillingPhase) null, (WebBillingPhase) null, (WebBillingPhase) null, 15, (AbstractC1585j) null);
    }

    public static /* synthetic */ WebBillingPurchaseOption copy$default(WebBillingPurchaseOption webBillingPurchaseOption, WebBillingPrice webBillingPrice, WebBillingPhase webBillingPhase, WebBillingPhase webBillingPhase2, WebBillingPhase webBillingPhase3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            webBillingPrice = webBillingPurchaseOption.basePrice;
        }
        if ((i4 & 2) != 0) {
            webBillingPhase = webBillingPurchaseOption.base;
        }
        if ((i4 & 4) != 0) {
            webBillingPhase2 = webBillingPurchaseOption.trial;
        }
        if ((i4 & 8) != 0) {
            webBillingPhase3 = webBillingPurchaseOption.introPrice;
        }
        return webBillingPurchaseOption.copy(webBillingPrice, webBillingPhase, webBillingPhase2, webBillingPhase3);
    }

    public static /* synthetic */ void getBasePrice$annotations() {
    }

    public static /* synthetic */ void getIntroPrice$annotations() {
    }

    public static final /* synthetic */ void write$Self(WebBillingPurchaseOption webBillingPurchaseOption, d dVar, e eVar) {
        if (dVar.j(eVar, 0) || webBillingPurchaseOption.basePrice != null) {
            dVar.E(eVar, 0, WebBillingPrice$$serializer.INSTANCE, webBillingPurchaseOption.basePrice);
        }
        if (dVar.j(eVar, 1) || webBillingPurchaseOption.base != null) {
            dVar.E(eVar, 1, WebBillingPhase$$serializer.INSTANCE, webBillingPurchaseOption.base);
        }
        if (dVar.j(eVar, 2) || webBillingPurchaseOption.trial != null) {
            dVar.E(eVar, 2, WebBillingPhase$$serializer.INSTANCE, webBillingPurchaseOption.trial);
        }
        if (!dVar.j(eVar, 3) && webBillingPurchaseOption.introPrice == null) {
            return;
        }
        dVar.E(eVar, 3, WebBillingPhase$$serializer.INSTANCE, webBillingPurchaseOption.introPrice);
    }

    public final WebBillingPrice component1() {
        return this.basePrice;
    }

    public final WebBillingPhase component2() {
        return this.base;
    }

    public final WebBillingPhase component3() {
        return this.trial;
    }

    public final WebBillingPhase component4() {
        return this.introPrice;
    }

    public final WebBillingPurchaseOption copy(WebBillingPrice webBillingPrice, WebBillingPhase webBillingPhase, WebBillingPhase webBillingPhase2, WebBillingPhase webBillingPhase3) {
        return new WebBillingPurchaseOption(webBillingPrice, webBillingPhase, webBillingPhase2, webBillingPhase3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebBillingPurchaseOption)) {
            return false;
        }
        WebBillingPurchaseOption webBillingPurchaseOption = (WebBillingPurchaseOption) obj;
        return r.b(this.basePrice, webBillingPurchaseOption.basePrice) && r.b(this.base, webBillingPurchaseOption.base) && r.b(this.trial, webBillingPurchaseOption.trial) && r.b(this.introPrice, webBillingPurchaseOption.introPrice);
    }

    public final WebBillingPhase getBase() {
        return this.base;
    }

    public final WebBillingPrice getBasePrice() {
        return this.basePrice;
    }

    public final WebBillingPhase getIntroPrice() {
        return this.introPrice;
    }

    public final WebBillingPhase getTrial() {
        return this.trial;
    }

    public int hashCode() {
        WebBillingPrice webBillingPrice = this.basePrice;
        int iHashCode = (webBillingPrice == null ? 0 : webBillingPrice.hashCode()) * 31;
        WebBillingPhase webBillingPhase = this.base;
        int iHashCode2 = (iHashCode + (webBillingPhase == null ? 0 : webBillingPhase.hashCode())) * 31;
        WebBillingPhase webBillingPhase2 = this.trial;
        int iHashCode3 = (iHashCode2 + (webBillingPhase2 == null ? 0 : webBillingPhase2.hashCode())) * 31;
        WebBillingPhase webBillingPhase3 = this.introPrice;
        return iHashCode3 + (webBillingPhase3 != null ? webBillingPhase3.hashCode() : 0);
    }

    public String toString() {
        return "WebBillingPurchaseOption(basePrice=" + this.basePrice + ", base=" + this.base + ", trial=" + this.trial + ", introPrice=" + this.introPrice + ')';
    }

    public /* synthetic */ WebBillingPurchaseOption(int i4, WebBillingPrice webBillingPrice, WebBillingPhase webBillingPhase, WebBillingPhase webBillingPhase2, WebBillingPhase webBillingPhase3, k0 k0Var) {
        if ((i4 & 1) == 0) {
            this.basePrice = null;
        } else {
            this.basePrice = webBillingPrice;
        }
        if ((i4 & 2) == 0) {
            this.base = null;
        } else {
            this.base = webBillingPhase;
        }
        if ((i4 & 4) == 0) {
            this.trial = null;
        } else {
            this.trial = webBillingPhase2;
        }
        if ((i4 & 8) == 0) {
            this.introPrice = null;
        } else {
            this.introPrice = webBillingPhase3;
        }
    }

    public WebBillingPurchaseOption(WebBillingPrice webBillingPrice, WebBillingPhase webBillingPhase, WebBillingPhase webBillingPhase2, WebBillingPhase webBillingPhase3) {
        this.basePrice = webBillingPrice;
        this.base = webBillingPhase;
        this.trial = webBillingPhase2;
        this.introPrice = webBillingPhase3;
    }

    public /* synthetic */ WebBillingPurchaseOption(WebBillingPrice webBillingPrice, WebBillingPhase webBillingPhase, WebBillingPhase webBillingPhase2, WebBillingPhase webBillingPhase3, int i4, AbstractC1585j abstractC1585j) {
        this((i4 & 1) != 0 ? null : webBillingPrice, (i4 & 2) != 0 ? null : webBillingPhase, (i4 & 4) != 0 ? null : webBillingPhase2, (i4 & 8) != 0 ? null : webBillingPhase3);
    }
}
