package com.revenuecat.purchases.common.networking;

import F3.b;
import H3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.k0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class WebBillingPrice {
    public static final Companion Companion = new Companion(null);
    private final long amountMicros;
    private final String currency;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return WebBillingPrice$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ WebBillingPrice(int i4, long j4, String str, k0 k0Var) {
        if (3 != (i4 & 3)) {
            AbstractC0325a0.a(i4, 3, WebBillingPrice$$serializer.INSTANCE.getDescriptor());
        }
        this.amountMicros = j4;
        this.currency = str;
    }

    public static /* synthetic */ WebBillingPrice copy$default(WebBillingPrice webBillingPrice, long j4, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j4 = webBillingPrice.amountMicros;
        }
        if ((i4 & 2) != 0) {
            str = webBillingPrice.currency;
        }
        return webBillingPrice.copy(j4, str);
    }

    public static /* synthetic */ void getAmountMicros$annotations() {
    }

    public static final /* synthetic */ void write$Self(WebBillingPrice webBillingPrice, d dVar, e eVar) {
        dVar.l(eVar, 0, webBillingPrice.amountMicros);
        dVar.o(eVar, 1, webBillingPrice.currency);
    }

    public final long component1() {
        return this.amountMicros;
    }

    public final String component2() {
        return this.currency;
    }

    public final WebBillingPrice copy(long j4, String currency) {
        r.f(currency, "currency");
        return new WebBillingPrice(j4, currency);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebBillingPrice)) {
            return false;
        }
        WebBillingPrice webBillingPrice = (WebBillingPrice) obj;
        return this.amountMicros == webBillingPrice.amountMicros && r.b(this.currency, webBillingPrice.currency);
    }

    public final long getAmountMicros() {
        return this.amountMicros;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public int hashCode() {
        return (Long.hashCode(this.amountMicros) * 31) + this.currency.hashCode();
    }

    public String toString() {
        return "WebBillingPrice(amountMicros=" + this.amountMicros + ", currency=" + this.currency + ')';
    }

    public WebBillingPrice(long j4, String currency) {
        r.f(currency, "currency");
        this.amountMicros = j4;
        this.currency = currency;
    }
}
