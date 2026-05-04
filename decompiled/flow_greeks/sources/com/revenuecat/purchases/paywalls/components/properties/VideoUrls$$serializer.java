package com.revenuecat.purchases.paywalls.components.properties;

import ah.a;
import cd.z;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.models.Checksum;
import com.revenuecat.purchases.models.Checksum$$serializer;
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
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/properties/VideoUrls.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/properties/VideoUrls;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/properties/VideoUrls;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/properties/VideoUrls;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VideoUrls$$serializer implements e0 {
    public static final VideoUrls$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        VideoUrls$$serializer videoUrls$$serializer = new VideoUrls$$serializer();
        INSTANCE = videoUrls$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.properties.VideoUrls", videoUrls$$serializer, 6);
        j1Var.g("width", false);
        j1Var.g("height", false);
        j1Var.g("url", false);
        j1Var.g("checksum", true);
        j1Var.g("url_low_res", true);
        j1Var.g("checksum_low_res", true);
        descriptor = j1Var;
    }

    private VideoUrls$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        URLSerializer uRLSerializer = URLSerializer.INSTANCE;
        Checksum$$serializer checksum$$serializer = Checksum$$serializer.INSTANCE;
        b bVarP = a.p(checksum$$serializer);
        b bVarP2 = a.p(uRLSerializer);
        b bVarP3 = a.p(checksum$$serializer);
        g2 g2Var = g2.f8147a;
        return new b[]{g2Var, g2Var, uRLSerializer, bVarP, bVarP2, bVarP3};
    }

    @Override // zg.a
    public VideoUrls deserialize(e decoder) {
        int i10;
        z zVar;
        z zVar2;
        URL url;
        Checksum checksum;
        URL url2;
        Checksum checksum2;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        int i11 = 5;
        z zVar3 = null;
        if (cVarB.z()) {
            g2 g2Var = g2.f8147a;
            z zVar4 = (z) cVarB.h(descriptor2, 0, g2Var, null);
            z zVar5 = (z) cVarB.h(descriptor2, 1, g2Var, null);
            URLSerializer uRLSerializer = URLSerializer.INSTANCE;
            URL url3 = (URL) cVarB.h(descriptor2, 2, uRLSerializer, null);
            Checksum$$serializer checksum$$serializer = Checksum$$serializer.INSTANCE;
            Checksum checksum3 = (Checksum) cVarB.n(descriptor2, 3, checksum$$serializer, null);
            URL url4 = (URL) cVarB.n(descriptor2, 4, uRLSerializer, null);
            zVar2 = zVar5;
            checksum2 = (Checksum) cVarB.n(descriptor2, 5, checksum$$serializer, null);
            checksum = checksum3;
            url2 = url4;
            url = url3;
            i10 = 63;
            zVar = zVar4;
        } else {
            boolean z10 = true;
            int i12 = 0;
            z zVar6 = null;
            URL url5 = null;
            Checksum checksum4 = null;
            URL url6 = null;
            Checksum checksum5 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z10 = false;
                        i11 = 5;
                        break;
                    case 0:
                        zVar3 = (z) cVarB.h(descriptor2, 0, g2.f8147a, zVar3);
                        i12 |= 1;
                        i11 = 5;
                        break;
                    case 1:
                        zVar6 = (z) cVarB.h(descriptor2, 1, g2.f8147a, zVar6);
                        i12 |= 2;
                        break;
                    case 2:
                        url5 = (URL) cVarB.h(descriptor2, 2, URLSerializer.INSTANCE, url5);
                        i12 |= 4;
                        break;
                    case 3:
                        checksum4 = (Checksum) cVarB.n(descriptor2, 3, Checksum$$serializer.INSTANCE, checksum4);
                        i12 |= 8;
                        break;
                    case 4:
                        url6 = (URL) cVarB.n(descriptor2, 4, URLSerializer.INSTANCE, url6);
                        i12 |= 16;
                        break;
                    case 5:
                        checksum5 = (Checksum) cVarB.n(descriptor2, i11, Checksum$$serializer.INSTANCE, checksum5);
                        i12 |= 32;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            i10 = i12;
            zVar = zVar3;
            zVar2 = zVar6;
            url = url5;
            checksum = checksum4;
            url2 = url6;
            checksum2 = checksum5;
        }
        cVarB.c(descriptor2);
        return new VideoUrls(i10, zVar, zVar2, url, checksum, url2, checksum2, null, null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, VideoUrls value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        VideoUrls.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
