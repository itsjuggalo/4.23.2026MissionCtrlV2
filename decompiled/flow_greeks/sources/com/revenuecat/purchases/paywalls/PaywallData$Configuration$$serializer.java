package com.revenuecat.purchases.paywalls;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.utils.serializers.OptionalURLSerializer;
import dh.e0;
import dh.h;
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
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/PaywallData.Configuration.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallData$Configuration$$serializer implements e0 {
    public static final PaywallData$Configuration$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        PaywallData$Configuration$$serializer paywallData$Configuration$$serializer = new PaywallData$Configuration$$serializer();
        INSTANCE = paywallData$Configuration$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.PaywallData.Configuration", paywallData$Configuration$$serializer, 13);
        j1Var.g("packages", true);
        j1Var.g("default_package", true);
        j1Var.g("images_webp", true);
        j1Var.g("images", true);
        j1Var.g("images_by_tier", true);
        j1Var.g("blurred_background_image", true);
        j1Var.g("display_restore_purchases", true);
        j1Var.g("tos_url", true);
        j1Var.g("privacy_url", true);
        j1Var.g("colors", false);
        j1Var.g("colors_by_tier", true);
        j1Var.g("tiers", true);
        j1Var.g("default_tier", true);
        descriptor = j1Var;
    }

    private PaywallData$Configuration$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b[] bVarArr = PaywallData.Configuration.$childSerializers;
        b bVar = bVarArr[0];
        w1 w1Var = w1.f8244a;
        b bVarP = a.p(w1Var);
        PaywallData$Configuration$Images$$serializer paywallData$Configuration$Images$$serializer = PaywallData$Configuration$Images$$serializer.INSTANCE;
        b bVarP2 = a.p(paywallData$Configuration$Images$$serializer);
        b bVarP3 = a.p(paywallData$Configuration$Images$$serializer);
        b bVarP4 = a.p(bVarArr[4]);
        OptionalURLSerializer optionalURLSerializer = OptionalURLSerializer.INSTANCE;
        b bVarP5 = a.p(optionalURLSerializer);
        b bVarP6 = a.p(optionalURLSerializer);
        b bVarP7 = a.p(bVarArr[10]);
        b bVarP8 = a.p(bVarArr[11]);
        b bVarP9 = a.p(w1Var);
        h hVar = h.f8149a;
        return new b[]{bVar, bVarP, bVarP2, bVarP3, bVarP4, hVar, hVar, bVarP5, bVarP6, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE, bVarP7, bVarP8, bVarP9};
    }

    @Override // zg.a
    public PaywallData.Configuration deserialize(e decoder) {
        int i10;
        String str;
        String str2;
        Map map;
        PaywallData.Configuration.ColorInformation colorInformation;
        URL url;
        Map map2;
        List list;
        PaywallData.Configuration.Images images;
        List list2;
        URL url2;
        PaywallData.Configuration.Images images2;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        b[] bVarArr = PaywallData.Configuration.$childSerializers;
        if (cVarB.z()) {
            List list3 = (List) cVarB.h(descriptor2, 0, bVarArr[0], null);
            w1 w1Var = w1.f8244a;
            String str3 = (String) cVarB.n(descriptor2, 1, w1Var, null);
            PaywallData$Configuration$Images$$serializer paywallData$Configuration$Images$$serializer = PaywallData$Configuration$Images$$serializer.INSTANCE;
            PaywallData.Configuration.Images images3 = (PaywallData.Configuration.Images) cVarB.n(descriptor2, 2, paywallData$Configuration$Images$$serializer, null);
            PaywallData.Configuration.Images images4 = (PaywallData.Configuration.Images) cVarB.n(descriptor2, 3, paywallData$Configuration$Images$$serializer, null);
            Map map3 = (Map) cVarB.n(descriptor2, 4, bVarArr[4], null);
            boolean zB = cVarB.B(descriptor2, 5);
            boolean zB2 = cVarB.B(descriptor2, 6);
            OptionalURLSerializer optionalURLSerializer = OptionalURLSerializer.INSTANCE;
            URL url3 = (URL) cVarB.n(descriptor2, 7, optionalURLSerializer, null);
            URL url4 = (URL) cVarB.n(descriptor2, 8, optionalURLSerializer, null);
            PaywallData.Configuration.ColorInformation colorInformation2 = (PaywallData.Configuration.ColorInformation) cVarB.h(descriptor2, 9, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE, null);
            Map map4 = (Map) cVarB.n(descriptor2, 10, bVarArr[10], null);
            i10 = 8191;
            list = (List) cVarB.n(descriptor2, 11, bVarArr[11], null);
            list2 = list3;
            str2 = (String) cVarB.n(descriptor2, 12, w1Var, null);
            colorInformation = colorInformation2;
            url2 = url3;
            z10 = zB2;
            z11 = zB;
            images = images4;
            url = url4;
            images2 = images3;
            map2 = map3;
            str = str3;
            map = map4;
        } else {
            boolean zB3 = false;
            boolean zB4 = false;
            String str4 = null;
            Map map5 = null;
            PaywallData.Configuration.ColorInformation colorInformation3 = null;
            URL url5 = null;
            Map map6 = null;
            List list4 = null;
            PaywallData.Configuration.Images images5 = null;
            List list5 = null;
            int i11 = 4;
            boolean z14 = true;
            i10 = 0;
            String str5 = null;
            URL url6 = null;
            PaywallData.Configuration.Images images6 = null;
            while (true) {
                boolean z15 = zB3;
                if (z14) {
                    int iW = cVarB.w(descriptor2);
                    switch (iW) {
                        case -1:
                            z13 = zB4;
                            z14 = false;
                            zB3 = z15;
                            zB4 = z13;
                            i11 = 4;
                            break;
                        case 0:
                            z13 = zB4;
                            list5 = (List) cVarB.h(descriptor2, 0, bVarArr[0], list5);
                            i10 |= 1;
                            zB3 = z15;
                            zB4 = z13;
                            i11 = 4;
                            break;
                        case 1:
                            z13 = zB4;
                            str5 = (String) cVarB.n(descriptor2, 1, w1.f8244a, str5);
                            i10 |= 2;
                            zB3 = z15;
                            zB4 = z13;
                            i11 = 4;
                            break;
                        case 2:
                            z13 = zB4;
                            images6 = (PaywallData.Configuration.Images) cVarB.n(descriptor2, 2, PaywallData$Configuration$Images$$serializer.INSTANCE, images6);
                            i10 |= 4;
                            zB3 = z15;
                            zB4 = z13;
                            i11 = 4;
                            break;
                        case 3:
                            z13 = zB4;
                            images5 = (PaywallData.Configuration.Images) cVarB.n(descriptor2, 3, PaywallData$Configuration$Images$$serializer.INSTANCE, images5);
                            i10 |= 8;
                            zB3 = z15;
                            zB4 = z13;
                            i11 = 4;
                            break;
                        case 4:
                            z12 = zB4;
                            map6 = (Map) cVarB.n(descriptor2, i11, bVarArr[i11], map6);
                            i10 |= 16;
                            zB3 = z15;
                            zB4 = z12;
                            break;
                        case 5:
                            i10 |= 32;
                            zB4 = cVarB.B(descriptor2, 5);
                            zB3 = z15;
                            break;
                        case 6:
                            z12 = zB4;
                            i10 |= 64;
                            zB3 = cVarB.B(descriptor2, 6);
                            zB4 = z12;
                            break;
                        case 7:
                            z12 = zB4;
                            url6 = (URL) cVarB.n(descriptor2, 7, OptionalURLSerializer.INSTANCE, url6);
                            i10 |= 128;
                            zB3 = z15;
                            zB4 = z12;
                            break;
                        case 8:
                            z12 = zB4;
                            url5 = (URL) cVarB.n(descriptor2, 8, OptionalURLSerializer.INSTANCE, url5);
                            i10 |= 256;
                            zB3 = z15;
                            zB4 = z12;
                            break;
                        case 9:
                            z12 = zB4;
                            colorInformation3 = (PaywallData.Configuration.ColorInformation) cVarB.h(descriptor2, 9, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE, colorInformation3);
                            i10 |= 512;
                            zB3 = z15;
                            zB4 = z12;
                            break;
                        case 10:
                            z12 = zB4;
                            map5 = (Map) cVarB.n(descriptor2, 10, bVarArr[10], map5);
                            i10 |= 1024;
                            zB3 = z15;
                            zB4 = z12;
                            break;
                        case 11:
                            z12 = zB4;
                            list4 = (List) cVarB.n(descriptor2, 11, bVarArr[11], list4);
                            i10 |= 2048;
                            zB3 = z15;
                            zB4 = z12;
                            break;
                        case 12:
                            z12 = zB4;
                            str4 = (String) cVarB.n(descriptor2, 12, w1.f8244a, str4);
                            i10 |= 4096;
                            zB3 = z15;
                            zB4 = z12;
                            break;
                        default:
                            throw new m(iW);
                    }
                } else {
                    str = str5;
                    str2 = str4;
                    map = map5;
                    colorInformation = colorInformation3;
                    url = url5;
                    map2 = map6;
                    list = list4;
                    images = images5;
                    list2 = list5;
                    url2 = url6;
                    images2 = images6;
                    z10 = z15;
                    z11 = zB4;
                }
            }
        }
        int i12 = i10;
        cVarB.c(descriptor2);
        return new PaywallData.Configuration(i12, list2, str, images2, images, map2, z11, z10, url2, url, colorInformation, map, list, str2, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, PaywallData.Configuration value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        PaywallData.Configuration.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
