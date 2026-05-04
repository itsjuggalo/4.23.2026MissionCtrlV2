package com.revenuecat.purchases.paywalls;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.utils.serializers.GoogleListSerializer;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import dh.e0;
import dh.j0;
import dh.j1;
import dh.s1;
import dh.w1;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/PaywallData.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/PaywallData;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/PaywallData;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/PaywallData;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallData$$serializer implements e0 {
    public static final PaywallData$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        PaywallData$$serializer paywallData$$serializer = new PaywallData$$serializer();
        INSTANCE = paywallData$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.PaywallData", paywallData$$serializer, 8);
        j1Var.g("template_name", false);
        j1Var.g("config", false);
        j1Var.g("asset_base_url", false);
        j1Var.g("revision", true);
        j1Var.g("localized_strings", false);
        j1Var.g("localized_strings_by_tier", true);
        j1Var.g("zero_decimal_place_countries", true);
        j1Var.g("default_locale", true);
        descriptor = j1Var;
    }

    private PaywallData$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b[] bVarArr = PaywallData.$childSerializers;
        w1 w1Var = w1.f8244a;
        return new b[]{w1Var, PaywallData$Configuration$$serializer.INSTANCE, URLSerializer.INSTANCE, j0.f8162a, bVarArr[4], bVarArr[5], GoogleListSerializer.INSTANCE, a.p(w1Var)};
    }

    @Override // zg.a
    public PaywallData deserialize(e decoder) {
        int i10;
        String str;
        List list;
        Map map;
        Map map2;
        int i11;
        String str2;
        PaywallData.Configuration configuration;
        URL url;
        int i12;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        b[] bVarArr = PaywallData.$childSerializers;
        int i13 = 7;
        int i14 = 6;
        int i15 = 4;
        if (cVarB.z()) {
            String strS = cVarB.s(descriptor2, 0);
            PaywallData.Configuration configuration2 = (PaywallData.Configuration) cVarB.h(descriptor2, 1, PaywallData$Configuration$$serializer.INSTANCE, null);
            URL url2 = (URL) cVarB.h(descriptor2, 2, URLSerializer.INSTANCE, null);
            int iC = cVarB.C(descriptor2, 3);
            Map map3 = (Map) cVarB.h(descriptor2, 4, bVarArr[4], null);
            Map map4 = (Map) cVarB.h(descriptor2, 5, bVarArr[5], null);
            List list2 = (List) cVarB.h(descriptor2, 6, GoogleListSerializer.INSTANCE, null);
            map = map4;
            str2 = strS;
            str = (String) cVarB.n(descriptor2, 7, w1.f8244a, null);
            list = list2;
            i10 = iC;
            url = url2;
            i11 = 255;
            map2 = map3;
            configuration = configuration2;
        } else {
            boolean z10 = true;
            int iC2 = 0;
            String str3 = null;
            List list3 = null;
            Map map5 = null;
            String strS2 = null;
            PaywallData.Configuration configuration3 = null;
            URL url3 = null;
            int i16 = 0;
            Map map6 = null;
            while (z10) {
                int i17 = i15;
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z10 = false;
                        i13 = 7;
                        i15 = 4;
                        break;
                    case 0:
                        strS2 = cVarB.s(descriptor2, 0);
                        i16 |= 1;
                        i13 = 7;
                        i14 = 6;
                        i15 = 4;
                        break;
                    case 1:
                        configuration3 = (PaywallData.Configuration) cVarB.h(descriptor2, 1, PaywallData$Configuration$$serializer.INSTANCE, configuration3);
                        i16 |= 2;
                        i13 = 7;
                        i14 = 6;
                        i15 = 4;
                        break;
                    case 2:
                        url3 = (URL) cVarB.h(descriptor2, 2, URLSerializer.INSTANCE, url3);
                        i16 |= 4;
                        i13 = 7;
                        i14 = 6;
                        i15 = 4;
                        break;
                    case 3:
                        i12 = i17;
                        iC2 = cVarB.C(descriptor2, 3);
                        i16 |= 8;
                        i15 = i12;
                        i13 = 7;
                        break;
                    case 4:
                        i12 = i17;
                        map6 = (Map) cVarB.h(descriptor2, i12, bVarArr[i17], map6);
                        i16 |= 16;
                        i15 = i12;
                        i13 = 7;
                        break;
                    case 5:
                        map5 = (Map) cVarB.h(descriptor2, 5, bVarArr[5], map5);
                        i16 |= 32;
                        i15 = i17;
                        break;
                    case 6:
                        list3 = (List) cVarB.h(descriptor2, i14, GoogleListSerializer.INSTANCE, list3);
                        i16 |= 64;
                        i15 = i17;
                        break;
                    case 7:
                        str3 = (String) cVarB.n(descriptor2, i13, w1.f8244a, str3);
                        i16 |= 128;
                        i15 = i17;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            i10 = iC2;
            str = str3;
            list = list3;
            map = map5;
            map2 = map6;
            i11 = i16;
            str2 = strS2;
            configuration = configuration3;
            url = url3;
        }
        cVarB.c(descriptor2);
        return new PaywallData(i11, str2, configuration, url, i10, map2, map, list, str, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, PaywallData value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        PaywallData.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
