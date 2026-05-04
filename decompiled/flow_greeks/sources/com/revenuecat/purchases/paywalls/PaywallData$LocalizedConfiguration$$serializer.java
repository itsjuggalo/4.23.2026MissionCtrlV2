package com.revenuecat.purchases.paywalls;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.paywalls.PaywallData;
import dh.e0;
import dh.j1;
import dh.s1;
import dh.w1;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/PaywallData.LocalizedConfiguration.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallData$LocalizedConfiguration$$serializer implements e0 {
    public static final PaywallData$LocalizedConfiguration$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        PaywallData$LocalizedConfiguration$$serializer paywallData$LocalizedConfiguration$$serializer = new PaywallData$LocalizedConfiguration$$serializer();
        INSTANCE = paywallData$LocalizedConfiguration$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.PaywallData.LocalizedConfiguration", paywallData$LocalizedConfiguration$$serializer, 12);
        j1Var.g(b.S, false);
        j1Var.g("subtitle", true);
        j1Var.g("call_to_action", false);
        j1Var.g("call_to_action_with_intro_offer", true);
        j1Var.g("call_to_action_with_multiple_intro_offers", true);
        j1Var.g("offer_details", true);
        j1Var.g("offer_details_with_intro_offer", true);
        j1Var.g("offer_details_with_multiple_intro_offers", true);
        j1Var.g("offer_name", true);
        j1Var.g("features", true);
        j1Var.g("tier_name", true);
        j1Var.g("offer_overrides", true);
        descriptor = j1Var;
    }

    private PaywallData$LocalizedConfiguration$$serializer() {
    }

    @Override // dh.e0
    public zg.b[] childSerializers() {
        zg.b[] bVarArr = PaywallData.LocalizedConfiguration.$childSerializers;
        EmptyStringToNullSerializer emptyStringToNullSerializer = EmptyStringToNullSerializer.INSTANCE;
        zg.b bVarP = a.p(emptyStringToNullSerializer);
        zg.b bVarP2 = a.p(emptyStringToNullSerializer);
        zg.b bVarP3 = a.p(emptyStringToNullSerializer);
        zg.b bVarP4 = a.p(emptyStringToNullSerializer);
        zg.b bVarP5 = a.p(emptyStringToNullSerializer);
        zg.b bVarP6 = a.p(emptyStringToNullSerializer);
        zg.b bVarP7 = a.p(emptyStringToNullSerializer);
        zg.b bVar = bVarArr[9];
        zg.b bVarP8 = a.p(emptyStringToNullSerializer);
        zg.b bVar2 = bVarArr[11];
        w1 w1Var = w1.f8244a;
        return new zg.b[]{w1Var, bVarP, w1Var, bVarP2, bVarP3, bVarP4, bVarP5, bVarP6, bVarP7, bVar, bVarP8, bVar2};
    }

    @Override // zg.a
    public PaywallData.LocalizedConfiguration deserialize(e decoder) {
        int i10;
        String str;
        List list;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Map map;
        String str8;
        String str9;
        String str10;
        zg.b[] bVarArr;
        zg.b[] bVarArr2;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        zg.b[] bVarArr3 = PaywallData.LocalizedConfiguration.$childSerializers;
        if (cVarB.z()) {
            String strS = cVarB.s(descriptor2, 0);
            EmptyStringToNullSerializer emptyStringToNullSerializer = EmptyStringToNullSerializer.INSTANCE;
            String str11 = (String) cVarB.n(descriptor2, 1, emptyStringToNullSerializer, null);
            String strS2 = cVarB.s(descriptor2, 2);
            String str12 = (String) cVarB.n(descriptor2, 3, emptyStringToNullSerializer, null);
            String str13 = (String) cVarB.n(descriptor2, 4, emptyStringToNullSerializer, null);
            String str14 = (String) cVarB.n(descriptor2, 5, emptyStringToNullSerializer, null);
            String str15 = (String) cVarB.n(descriptor2, 6, emptyStringToNullSerializer, null);
            String str16 = (String) cVarB.n(descriptor2, 7, emptyStringToNullSerializer, null);
            String str17 = (String) cVarB.n(descriptor2, 8, emptyStringToNullSerializer, null);
            List list2 = (List) cVarB.h(descriptor2, 9, bVarArr3[9], null);
            String str18 = (String) cVarB.n(descriptor2, 10, emptyStringToNullSerializer, null);
            i10 = 4095;
            map = (Map) cVarB.h(descriptor2, 11, bVarArr3[11], null);
            str = strS;
            list = list2;
            str3 = str16;
            str6 = str15;
            str4 = str14;
            str8 = str12;
            str2 = str17;
            str7 = str13;
            str10 = strS2;
            str5 = str18;
            str9 = str11;
        } else {
            int i11 = 11;
            String strS3 = null;
            List list3 = null;
            String str19 = null;
            String str20 = null;
            String str21 = null;
            String str22 = null;
            String str23 = null;
            String str24 = null;
            String strS4 = null;
            int i12 = 9;
            boolean z10 = true;
            Map map2 = null;
            String str25 = null;
            i10 = 0;
            String str26 = null;
            while (z10) {
                int i13 = i11;
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        bVarArr = bVarArr3;
                        z10 = false;
                        bVarArr3 = bVarArr;
                        i11 = 11;
                        i12 = 9;
                        break;
                    case 0:
                        bVarArr = bVarArr3;
                        strS3 = cVarB.s(descriptor2, 0);
                        i10 |= 1;
                        bVarArr3 = bVarArr;
                        i11 = 11;
                        i12 = 9;
                        break;
                    case 1:
                        bVarArr = bVarArr3;
                        str26 = (String) cVarB.n(descriptor2, 1, EmptyStringToNullSerializer.INSTANCE, str26);
                        i10 |= 2;
                        bVarArr3 = bVarArr;
                        i11 = 11;
                        i12 = 9;
                        break;
                    case 2:
                        bVarArr = bVarArr3;
                        strS4 = cVarB.s(descriptor2, 2);
                        i10 |= 4;
                        bVarArr3 = bVarArr;
                        i11 = 11;
                        i12 = 9;
                        break;
                    case 3:
                        bVarArr = bVarArr3;
                        str25 = (String) cVarB.n(descriptor2, 3, EmptyStringToNullSerializer.INSTANCE, str25);
                        i10 |= 8;
                        bVarArr3 = bVarArr;
                        i11 = 11;
                        i12 = 9;
                        break;
                    case 4:
                        bVarArr = bVarArr3;
                        str24 = (String) cVarB.n(descriptor2, 4, EmptyStringToNullSerializer.INSTANCE, str24);
                        i10 |= 16;
                        bVarArr3 = bVarArr;
                        i11 = 11;
                        i12 = 9;
                        break;
                    case 5:
                        bVarArr = bVarArr3;
                        str21 = (String) cVarB.n(descriptor2, 5, EmptyStringToNullSerializer.INSTANCE, str21);
                        i10 |= 32;
                        bVarArr3 = bVarArr;
                        i11 = 11;
                        i12 = 9;
                        break;
                    case 6:
                        bVarArr = bVarArr3;
                        str23 = (String) cVarB.n(descriptor2, 6, EmptyStringToNullSerializer.INSTANCE, str23);
                        i10 |= 64;
                        bVarArr3 = bVarArr;
                        i11 = 11;
                        i12 = 9;
                        break;
                    case 7:
                        bVarArr = bVarArr3;
                        str20 = (String) cVarB.n(descriptor2, 7, EmptyStringToNullSerializer.INSTANCE, str20);
                        i10 |= 128;
                        bVarArr3 = bVarArr;
                        i11 = 11;
                        i12 = 9;
                        break;
                    case 8:
                        bVarArr = bVarArr3;
                        str19 = (String) cVarB.n(descriptor2, 8, EmptyStringToNullSerializer.INSTANCE, str19);
                        i10 |= 256;
                        bVarArr3 = bVarArr;
                        i11 = 11;
                        i12 = 9;
                        break;
                    case 9:
                        bVarArr2 = bVarArr3;
                        list3 = (List) cVarB.h(descriptor2, i12, bVarArr2[i12], list3);
                        i10 |= 512;
                        bVarArr3 = bVarArr2;
                        i11 = 11;
                        break;
                    case 10:
                        bVarArr2 = bVarArr3;
                        str22 = (String) cVarB.n(descriptor2, 10, EmptyStringToNullSerializer.INSTANCE, str22);
                        i10 |= 1024;
                        bVarArr3 = bVarArr2;
                        i11 = 11;
                        break;
                    case 11:
                        map2 = (Map) cVarB.h(descriptor2, i13, bVarArr3[i13], map2);
                        i10 |= 2048;
                        i11 = i13;
                        bVarArr3 = bVarArr3;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            str = strS3;
            list = list3;
            str2 = str19;
            str3 = str20;
            str4 = str21;
            str5 = str22;
            str6 = str23;
            str7 = str24;
            map = map2;
            str8 = str25;
            str9 = str26;
            str10 = strS4;
        }
        int i14 = i10;
        cVarB.c(descriptor2);
        return new PaywallData.LocalizedConfiguration(i14, str, str9, str10, str8, str7, str4, str6, str3, str2, list, str5, map, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, PaywallData.LocalizedConfiguration value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        PaywallData.LocalizedConfiguration.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public zg.b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
