package com.revenuecat.purchases.paywalls.components.properties;

import cd.z;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import dh.e0;
import dh.g2;
import dh.j1;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/properties/ImageUrls.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/properties/ImageUrls;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/properties/ImageUrls;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/properties/ImageUrls;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ImageUrls$$serializer implements e0 {
    public static final ImageUrls$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        ImageUrls$$serializer imageUrls$$serializer = new ImageUrls$$serializer();
        INSTANCE = imageUrls$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.properties.ImageUrls", imageUrls$$serializer, 5);
        j1Var.g("original", false);
        j1Var.g("webp", false);
        j1Var.g("webp_low_res", false);
        j1Var.g("width", false);
        j1Var.g("height", false);
        descriptor = j1Var;
    }

    private ImageUrls$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        URLSerializer uRLSerializer = URLSerializer.INSTANCE;
        g2 g2Var = g2.f8147a;
        return new b[]{uRLSerializer, uRLSerializer, uRLSerializer, g2Var, g2Var};
    }

    @Override // zg.a
    public ImageUrls deserialize(e decoder) {
        int i10;
        URL url;
        URL url2;
        URL url3;
        z zVar;
        z zVar2;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        URL url4 = null;
        if (cVarB.z()) {
            URLSerializer uRLSerializer = URLSerializer.INSTANCE;
            URL url5 = (URL) cVarB.h(descriptor2, 0, uRLSerializer, null);
            URL url6 = (URL) cVarB.h(descriptor2, 1, uRLSerializer, null);
            URL url7 = (URL) cVarB.h(descriptor2, 2, uRLSerializer, null);
            g2 g2Var = g2.f8147a;
            url3 = url7;
            zVar = (z) cVarB.h(descriptor2, 3, g2Var, null);
            zVar2 = (z) cVarB.h(descriptor2, 4, g2Var, null);
            i10 = 31;
            url2 = url6;
            url = url5;
        } else {
            boolean z10 = true;
            int i11 = 0;
            URL url8 = null;
            URL url9 = null;
            z zVar3 = null;
            z zVar4 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                if (iW == -1) {
                    z10 = false;
                } else if (iW == 0) {
                    url4 = (URL) cVarB.h(descriptor2, 0, URLSerializer.INSTANCE, url4);
                    i11 |= 1;
                } else if (iW == 1) {
                    url8 = (URL) cVarB.h(descriptor2, 1, URLSerializer.INSTANCE, url8);
                    i11 |= 2;
                } else if (iW == 2) {
                    url9 = (URL) cVarB.h(descriptor2, 2, URLSerializer.INSTANCE, url9);
                    i11 |= 4;
                } else if (iW == 3) {
                    zVar3 = (z) cVarB.h(descriptor2, 3, g2.f8147a, zVar3);
                    i11 |= 8;
                } else {
                    if (iW != 4) {
                        throw new m(iW);
                    }
                    zVar4 = (z) cVarB.h(descriptor2, 4, g2.f8147a, zVar4);
                    i11 |= 16;
                }
            }
            i10 = i11;
            url = url4;
            url2 = url8;
            url3 = url9;
            zVar = zVar3;
            zVar2 = zVar4;
        }
        cVarB.c(descriptor2);
        return new ImageUrls(i10, url, url2, url3, zVar, zVar2, null, null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, ImageUrls value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        ImageUrls.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
