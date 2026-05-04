package com.revenuecat.purchases.paywalls;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.paywalls.PaywallData;
import dh.e0;
import dh.j1;
import dh.s1;
import dh.w1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/PaywallData.LocalizedConfiguration.OfferOverride.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$OfferOverride;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$OfferOverride;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$OfferOverride;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallData$LocalizedConfiguration$OfferOverride$$serializer implements e0 {
    public static final PaywallData$LocalizedConfiguration$OfferOverride$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        PaywallData$LocalizedConfiguration$OfferOverride$$serializer paywallData$LocalizedConfiguration$OfferOverride$$serializer = new PaywallData$LocalizedConfiguration$OfferOverride$$serializer();
        INSTANCE = paywallData$LocalizedConfiguration$OfferOverride$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.PaywallData.LocalizedConfiguration.OfferOverride", paywallData$LocalizedConfiguration$OfferOverride$$serializer, 5);
        j1Var.g("offer_name", false);
        j1Var.g("offer_details", false);
        j1Var.g("offer_details_with_intro_offer", true);
        j1Var.g("offer_details_with_multiple_intro_offers", true);
        j1Var.g("offer_badge", true);
        descriptor = j1Var;
    }

    private PaywallData$LocalizedConfiguration$OfferOverride$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        EmptyStringToNullSerializer emptyStringToNullSerializer = EmptyStringToNullSerializer.INSTANCE;
        b bVarP = a.p(emptyStringToNullSerializer);
        b bVarP2 = a.p(emptyStringToNullSerializer);
        b bVarP3 = a.p(emptyStringToNullSerializer);
        w1 w1Var = w1.f8244a;
        return new b[]{w1Var, w1Var, bVarP, bVarP2, bVarP3};
    }

    @Override // zg.a
    public PaywallData.LocalizedConfiguration.OfferOverride deserialize(e decoder) {
        int i10;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        String strS = null;
        if (cVarB.z()) {
            String strS2 = cVarB.s(descriptor2, 0);
            String strS3 = cVarB.s(descriptor2, 1);
            EmptyStringToNullSerializer emptyStringToNullSerializer = EmptyStringToNullSerializer.INSTANCE;
            String str6 = (String) cVarB.n(descriptor2, 2, emptyStringToNullSerializer, null);
            str = strS2;
            str4 = (String) cVarB.n(descriptor2, 3, emptyStringToNullSerializer, null);
            str5 = (String) cVarB.n(descriptor2, 4, emptyStringToNullSerializer, null);
            str3 = str6;
            str2 = strS3;
            i10 = 31;
        } else {
            boolean z10 = true;
            int i11 = 0;
            String strS4 = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                if (iW == -1) {
                    z10 = false;
                } else if (iW == 0) {
                    strS = cVarB.s(descriptor2, 0);
                    i11 |= 1;
                } else if (iW == 1) {
                    strS4 = cVarB.s(descriptor2, 1);
                    i11 |= 2;
                } else if (iW == 2) {
                    str7 = (String) cVarB.n(descriptor2, 2, EmptyStringToNullSerializer.INSTANCE, str7);
                    i11 |= 4;
                } else if (iW == 3) {
                    str8 = (String) cVarB.n(descriptor2, 3, EmptyStringToNullSerializer.INSTANCE, str8);
                    i11 |= 8;
                } else {
                    if (iW != 4) {
                        throw new m(iW);
                    }
                    str9 = (String) cVarB.n(descriptor2, 4, EmptyStringToNullSerializer.INSTANCE, str9);
                    i11 |= 16;
                }
            }
            i10 = i11;
            str = strS;
            str2 = strS4;
            str3 = str7;
            str4 = str8;
            str5 = str9;
        }
        cVarB.c(descriptor2);
        return new PaywallData.LocalizedConfiguration.OfferOverride(i10, str, str2, str3, str4, str5, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, PaywallData.LocalizedConfiguration.OfferOverride value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        PaywallData.LocalizedConfiguration.OfferOverride.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
