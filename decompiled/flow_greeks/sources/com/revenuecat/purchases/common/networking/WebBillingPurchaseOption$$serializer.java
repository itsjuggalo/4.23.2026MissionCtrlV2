package com.revenuecat.purchases.common.networking;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import dh.e0;
import dh.j1;
import dh.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/common/networking/WebBillingPurchaseOption.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/common/networking/WebBillingPurchaseOption;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/common/networking/WebBillingPurchaseOption;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/common/networking/WebBillingPurchaseOption;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebBillingPurchaseOption$$serializer implements e0 {
    public static final WebBillingPurchaseOption$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        WebBillingPurchaseOption$$serializer webBillingPurchaseOption$$serializer = new WebBillingPurchaseOption$$serializer();
        INSTANCE = webBillingPurchaseOption$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.common.networking.WebBillingPurchaseOption", webBillingPurchaseOption$$serializer, 4);
        j1Var.g("base_price", true);
        j1Var.g("base", true);
        j1Var.g("trial", true);
        j1Var.g("intro_price", true);
        descriptor = j1Var;
    }

    private WebBillingPurchaseOption$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b bVarP = a.p(WebBillingPrice$$serializer.INSTANCE);
        WebBillingPhase$$serializer webBillingPhase$$serializer = WebBillingPhase$$serializer.INSTANCE;
        return new b[]{bVarP, a.p(webBillingPhase$$serializer), a.p(webBillingPhase$$serializer), a.p(webBillingPhase$$serializer)};
    }

    @Override // zg.a
    public WebBillingPurchaseOption deserialize(e decoder) {
        int i10;
        WebBillingPrice webBillingPrice;
        WebBillingPhase webBillingPhase;
        WebBillingPhase webBillingPhase2;
        WebBillingPhase webBillingPhase3;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        WebBillingPrice webBillingPrice2 = null;
        if (cVarB.z()) {
            WebBillingPrice webBillingPrice3 = (WebBillingPrice) cVarB.n(descriptor2, 0, WebBillingPrice$$serializer.INSTANCE, null);
            WebBillingPhase$$serializer webBillingPhase$$serializer = WebBillingPhase$$serializer.INSTANCE;
            WebBillingPhase webBillingPhase4 = (WebBillingPhase) cVarB.n(descriptor2, 1, webBillingPhase$$serializer, null);
            WebBillingPhase webBillingPhase5 = (WebBillingPhase) cVarB.n(descriptor2, 2, webBillingPhase$$serializer, null);
            webBillingPrice = webBillingPrice3;
            webBillingPhase3 = (WebBillingPhase) cVarB.n(descriptor2, 3, webBillingPhase$$serializer, null);
            webBillingPhase2 = webBillingPhase5;
            webBillingPhase = webBillingPhase4;
            i10 = 15;
        } else {
            boolean z10 = true;
            int i11 = 0;
            WebBillingPhase webBillingPhase6 = null;
            WebBillingPhase webBillingPhase7 = null;
            WebBillingPhase webBillingPhase8 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                if (iW == -1) {
                    z10 = false;
                } else if (iW == 0) {
                    webBillingPrice2 = (WebBillingPrice) cVarB.n(descriptor2, 0, WebBillingPrice$$serializer.INSTANCE, webBillingPrice2);
                    i11 |= 1;
                } else if (iW == 1) {
                    webBillingPhase6 = (WebBillingPhase) cVarB.n(descriptor2, 1, WebBillingPhase$$serializer.INSTANCE, webBillingPhase6);
                    i11 |= 2;
                } else if (iW == 2) {
                    webBillingPhase7 = (WebBillingPhase) cVarB.n(descriptor2, 2, WebBillingPhase$$serializer.INSTANCE, webBillingPhase7);
                    i11 |= 4;
                } else {
                    if (iW != 3) {
                        throw new m(iW);
                    }
                    webBillingPhase8 = (WebBillingPhase) cVarB.n(descriptor2, 3, WebBillingPhase$$serializer.INSTANCE, webBillingPhase8);
                    i11 |= 8;
                }
            }
            i10 = i11;
            webBillingPrice = webBillingPrice2;
            webBillingPhase = webBillingPhase6;
            webBillingPhase2 = webBillingPhase7;
            webBillingPhase3 = webBillingPhase8;
        }
        cVarB.c(descriptor2);
        return new WebBillingPurchaseOption(i10, webBillingPrice, webBillingPhase, webBillingPhase2, webBillingPhase3, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, WebBillingPurchaseOption value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        WebBillingPurchaseOption.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
