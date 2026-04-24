package com.revenuecat.purchases.common.networking;

import F3.b;
import H3.e;
import I3.d;
import J3.k0;
import J3.o0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class WebBillingPhase {
    public static final Companion Companion = new Companion(null);
    private final int cycleCount;
    private final String periodDuration;
    private final WebBillingPrice price;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return WebBillingPhase$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public WebBillingPhase() {
        this((WebBillingPrice) null, (String) null, 0, 7, (AbstractC1585j) null);
    }

    public static /* synthetic */ WebBillingPhase copy$default(WebBillingPhase webBillingPhase, WebBillingPrice webBillingPrice, String str, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            webBillingPrice = webBillingPhase.price;
        }
        if ((i5 & 2) != 0) {
            str = webBillingPhase.periodDuration;
        }
        if ((i5 & 4) != 0) {
            i4 = webBillingPhase.cycleCount;
        }
        return webBillingPhase.copy(webBillingPrice, str, i4);
    }

    public static /* synthetic */ void getCycleCount$annotations() {
    }

    public static /* synthetic */ void getPeriodDuration$annotations() {
    }

    public static final /* synthetic */ void write$Self(WebBillingPhase webBillingPhase, d dVar, e eVar) {
        if (dVar.j(eVar, 0) || webBillingPhase.price != null) {
            dVar.E(eVar, 0, WebBillingPrice$$serializer.INSTANCE, webBillingPhase.price);
        }
        if (dVar.j(eVar, 1) || webBillingPhase.periodDuration != null) {
            dVar.E(eVar, 1, o0.f952a, webBillingPhase.periodDuration);
        }
        if (!dVar.j(eVar, 2) && webBillingPhase.cycleCount == 1) {
            return;
        }
        dVar.k(eVar, 2, webBillingPhase.cycleCount);
    }

    public final WebBillingPrice component1() {
        return this.price;
    }

    public final String component2() {
        return this.periodDuration;
    }

    public final int component3() {
        return this.cycleCount;
    }

    public final WebBillingPhase copy(WebBillingPrice webBillingPrice, String str, int i4) {
        return new WebBillingPhase(webBillingPrice, str, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebBillingPhase)) {
            return false;
        }
        WebBillingPhase webBillingPhase = (WebBillingPhase) obj;
        return r.b(this.price, webBillingPhase.price) && r.b(this.periodDuration, webBillingPhase.periodDuration) && this.cycleCount == webBillingPhase.cycleCount;
    }

    public final int getCycleCount() {
        return this.cycleCount;
    }

    public final String getPeriodDuration() {
        return this.periodDuration;
    }

    public final WebBillingPrice getPrice() {
        return this.price;
    }

    public int hashCode() {
        WebBillingPrice webBillingPrice = this.price;
        int iHashCode = (webBillingPrice == null ? 0 : webBillingPrice.hashCode()) * 31;
        String str = this.periodDuration;
        return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + Integer.hashCode(this.cycleCount);
    }

    public String toString() {
        return "WebBillingPhase(price=" + this.price + ", periodDuration=" + this.periodDuration + ", cycleCount=" + this.cycleCount + ')';
    }

    public /* synthetic */ WebBillingPhase(int i4, WebBillingPrice webBillingPrice, String str, int i5, k0 k0Var) {
        if ((i4 & 1) == 0) {
            this.price = null;
        } else {
            this.price = webBillingPrice;
        }
        if ((i4 & 2) == 0) {
            this.periodDuration = null;
        } else {
            this.periodDuration = str;
        }
        if ((i4 & 4) == 0) {
            this.cycleCount = 1;
        } else {
            this.cycleCount = i5;
        }
    }

    public WebBillingPhase(WebBillingPrice webBillingPrice, String str, int i4) {
        this.price = webBillingPrice;
        this.periodDuration = str;
        this.cycleCount = i4;
    }

    public /* synthetic */ WebBillingPhase(WebBillingPrice webBillingPrice, String str, int i4, int i5, AbstractC1585j abstractC1585j) {
        this((i5 & 1) != 0 ? null : webBillingPrice, (i5 & 2) != 0 ? null : str, (i5 & 4) != 0 ? 1 : i4);
    }
}
