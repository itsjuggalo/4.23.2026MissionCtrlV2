package com.revenuecat.purchases.paywalls.components.common;

import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.utils.serializers.GoogleListSerializer;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import dh.e0;
import dh.j0;
import dh.j1;
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
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/common/PaywallComponentsData.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsData;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsData;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsData;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallComponentsData$$serializer implements e0 {
    public static final PaywallComponentsData$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        PaywallComponentsData$$serializer paywallComponentsData$$serializer = new PaywallComponentsData$$serializer();
        INSTANCE = paywallComponentsData$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData", paywallComponentsData$$serializer, 7);
        j1Var.g("template_name", false);
        j1Var.g("asset_base_url", false);
        j1Var.g("components_config", false);
        j1Var.g("components_localizations", false);
        j1Var.g("default_locale", false);
        j1Var.g("revision", true);
        j1Var.g("zero_decimal_place_countries", true);
        descriptor = j1Var;
    }

    private PaywallComponentsData$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        return new b[]{w1.f8244a, URLSerializer.INSTANCE, ComponentsConfig$$serializer.INSTANCE, PaywallComponentsData.$childSerializers[3], LocaleId$$serializer.INSTANCE, j0.f8162a, GoogleListSerializer.INSTANCE};
    }

    @Override // zg.a
    public PaywallComponentsData deserialize(e decoder) {
        Map map;
        URL url;
        ComponentsConfig componentsConfig;
        String str;
        List list;
        int i10;
        String str2;
        int i11;
        boolean z10;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        b[] bVarArr = PaywallComponentsData.$childSerializers;
        int i12 = 6;
        ComponentsConfig componentsConfig2 = null;
        if (cVarB.z()) {
            String strS = cVarB.s(descriptor2, 0);
            URL url2 = (URL) cVarB.h(descriptor2, 1, URLSerializer.INSTANCE, null);
            ComponentsConfig componentsConfig3 = (ComponentsConfig) cVarB.h(descriptor2, 2, ComponentsConfig$$serializer.INSTANCE, null);
            Map map2 = (Map) cVarB.h(descriptor2, 3, bVarArr[3], null);
            LocaleId localeId = (LocaleId) cVarB.h(descriptor2, 4, LocaleId$$serializer.INSTANCE, null);
            String strM192unboximpl = localeId != null ? localeId.m192unboximpl() : null;
            int iC = cVarB.C(descriptor2, 5);
            map = map2;
            str = strS;
            list = (List) cVarB.h(descriptor2, 6, GoogleListSerializer.INSTANCE, null);
            i10 = iC;
            str2 = strM192unboximpl;
            componentsConfig = componentsConfig3;
            i11 = 127;
            url = url2;
        } else {
            boolean z11 = true;
            int iC2 = 0;
            int i13 = 0;
            Map map3 = null;
            URL url3 = null;
            String strS2 = null;
            List list2 = null;
            String strM192unboximpl2 = null;
            while (z11) {
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z11 = false;
                        break;
                    case 0:
                        z10 = true;
                        strS2 = cVarB.s(descriptor2, 0);
                        i13 |= 1;
                        i12 = 6;
                        break;
                    case 1:
                        z10 = true;
                        url3 = (URL) cVarB.h(descriptor2, 1, URLSerializer.INSTANCE, url3);
                        i13 |= 2;
                        i12 = 6;
                        break;
                    case 2:
                        componentsConfig2 = (ComponentsConfig) cVarB.h(descriptor2, 2, ComponentsConfig$$serializer.INSTANCE, componentsConfig2);
                        i13 |= 4;
                        break;
                    case 3:
                        map3 = (Map) cVarB.h(descriptor2, 3, bVarArr[3], map3);
                        i13 |= 8;
                        break;
                    case 4:
                        LocaleId localeId2 = (LocaleId) cVarB.h(descriptor2, 4, LocaleId$$serializer.INSTANCE, strM192unboximpl2 != null ? LocaleId.m186boximpl(strM192unboximpl2) : null);
                        strM192unboximpl2 = localeId2 != null ? localeId2.m192unboximpl() : null;
                        i13 |= 16;
                        break;
                    case 5:
                        iC2 = cVarB.C(descriptor2, 5);
                        i13 |= 32;
                        break;
                    case 6:
                        list2 = (List) cVarB.h(descriptor2, i12, GoogleListSerializer.INSTANCE, list2);
                        i13 |= 64;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            map = map3;
            url = url3;
            componentsConfig = componentsConfig2;
            str = strS2;
            list = list2;
            i10 = iC2;
            str2 = strM192unboximpl2;
            i11 = i13;
        }
        cVarB.c(descriptor2);
        return new PaywallComponentsData(i11, str, url, componentsConfig, map, str2, i10, list, null, null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, PaywallComponentsData value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        PaywallComponentsData.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
