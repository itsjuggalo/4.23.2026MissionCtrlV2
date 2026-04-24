package com.revenuecat.purchases.paywalls;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.C0335h;
import J3.k0;
import J3.o0;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.utils.serializers.OptionalURLSerializer;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PaywallData$Configuration$$serializer implements C {
    public static final PaywallData$Configuration$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PaywallData$Configuration$$serializer paywallData$Configuration$$serializer = new PaywallData$Configuration$$serializer();
        INSTANCE = paywallData$Configuration$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.PaywallData.Configuration", paywallData$Configuration$$serializer, 13);
        c0327b0.l("packages", true);
        c0327b0.l("default_package", true);
        c0327b0.l("images_webp", true);
        c0327b0.l("images", true);
        c0327b0.l("images_by_tier", true);
        c0327b0.l("blurred_background_image", true);
        c0327b0.l("display_restore_purchases", true);
        c0327b0.l("tos_url", true);
        c0327b0.l("privacy_url", true);
        c0327b0.l("colors", false);
        c0327b0.l("colors_by_tier", true);
        c0327b0.l("tiers", true);
        c0327b0.l("default_tier", true);
        descriptor = c0327b0;
    }

    private PaywallData$Configuration$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b[] bVarArr = PaywallData.Configuration.$childSerializers;
        b bVar = bVarArr[0];
        o0 o0Var = o0.f952a;
        b bVarP = G3.a.p(o0Var);
        PaywallData$Configuration$Images$$serializer paywallData$Configuration$Images$$serializer = PaywallData$Configuration$Images$$serializer.INSTANCE;
        b bVarP2 = G3.a.p(paywallData$Configuration$Images$$serializer);
        b bVarP3 = G3.a.p(paywallData$Configuration$Images$$serializer);
        b bVarP4 = G3.a.p(bVarArr[4]);
        OptionalURLSerializer optionalURLSerializer = OptionalURLSerializer.INSTANCE;
        b bVarP5 = G3.a.p(optionalURLSerializer);
        b bVarP6 = G3.a.p(optionalURLSerializer);
        b bVarP7 = G3.a.p(bVarArr[10]);
        b bVarP8 = G3.a.p(bVarArr[11]);
        b bVarP9 = G3.a.p(o0Var);
        C0335h c0335h = C0335h.f929a;
        return new b[]{bVar, bVarP, bVarP2, bVarP3, bVarP4, c0335h, c0335h, bVarP5, bVarP6, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE, bVarP7, bVarP8, bVarP9};
    }

    @Override // F3.a
    public PaywallData.Configuration deserialize(e decoder) {
        Object objY;
        Object objY2;
        Object objM;
        Object objY3;
        Object obj;
        Object objM2;
        boolean z4;
        int i4;
        Object objY4;
        Object objY5;
        Object objY6;
        Object objY7;
        Object objY8;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        b[] bVarArr = PaywallData.Configuration.$childSerializers;
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, bVarArr[0], null);
            o0 o0Var = o0.f952a;
            objY8 = cVarD.y(descriptor2, 1, o0Var, null);
            PaywallData$Configuration$Images$$serializer paywallData$Configuration$Images$$serializer = PaywallData$Configuration$Images$$serializer.INSTANCE;
            objY7 = cVarD.y(descriptor2, 2, paywallData$Configuration$Images$$serializer, null);
            objY6 = cVarD.y(descriptor2, 3, paywallData$Configuration$Images$$serializer, null);
            objY5 = cVarD.y(descriptor2, 4, bVarArr[4], null);
            boolean zN = cVarD.n(descriptor2, 5);
            boolean zN2 = cVarD.n(descriptor2, 6);
            OptionalURLSerializer optionalURLSerializer = OptionalURLSerializer.INSTANCE;
            objY4 = cVarD.y(descriptor2, 7, optionalURLSerializer, null);
            Object objY9 = cVarD.y(descriptor2, 8, optionalURLSerializer, null);
            objM2 = cVarD.m(descriptor2, 9, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE, null);
            Object objY10 = cVarD.y(descriptor2, 10, bVarArr[10], null);
            Object objY11 = cVarD.y(descriptor2, 11, bVarArr[11], null);
            objY3 = cVarD.y(descriptor2, 12, o0Var, null);
            i4 = 8191;
            z5 = zN2;
            z4 = zN;
            objY = objY9;
            objY2 = objY11;
            obj = objY10;
        } else {
            boolean zN3 = false;
            int i5 = 0;
            Object objY12 = null;
            Object objY13 = null;
            Object objM3 = null;
            objY = null;
            Object objY14 = null;
            objY2 = null;
            Object objY15 = null;
            Object objM4 = null;
            int i6 = 4;
            boolean z9 = true;
            boolean zN4 = false;
            Object objY16 = null;
            Object objY17 = null;
            Object objY18 = null;
            while (z9) {
                int i7 = cVarD.i(descriptor2);
                switch (i7) {
                    case -1:
                        z6 = zN3;
                        z9 = false;
                        objY16 = objY16;
                        i6 = 4;
                        objM4 = objM4;
                        zN3 = z6;
                        break;
                    case 0:
                        i5 |= 1;
                        objY16 = objY16;
                        zN3 = zN3;
                        i6 = 4;
                        objM4 = cVarD.m(descriptor2, 0, bVarArr[0], objM4);
                        break;
                    case 1:
                        z7 = zN3;
                        objY16 = cVarD.y(descriptor2, 1, o0.f952a, objY16);
                        i5 |= 2;
                        zN3 = z7;
                        i6 = 4;
                        break;
                    case 2:
                        z7 = zN3;
                        objY18 = cVarD.y(descriptor2, 2, PaywallData$Configuration$Images$$serializer.INSTANCE, objY18);
                        i5 |= 4;
                        zN3 = z7;
                        i6 = 4;
                        break;
                    case 3:
                        z7 = zN3;
                        objY15 = cVarD.y(descriptor2, 3, PaywallData$Configuration$Images$$serializer.INSTANCE, objY15);
                        i5 |= 8;
                        zN3 = z7;
                        i6 = 4;
                        break;
                    case 4:
                        z8 = zN3;
                        objY14 = cVarD.y(descriptor2, i6, bVarArr[i6], objY14);
                        i5 |= 16;
                        zN3 = z8;
                        break;
                    case 5:
                        z8 = zN3;
                        i5 |= 32;
                        zN4 = cVarD.n(descriptor2, 5);
                        zN3 = z8;
                        break;
                    case 6:
                        i5 |= 64;
                        zN3 = cVarD.n(descriptor2, 6);
                        break;
                    case 7:
                        z8 = zN3;
                        objY17 = cVarD.y(descriptor2, 7, OptionalURLSerializer.INSTANCE, objY17);
                        i5 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        zN3 = z8;
                        break;
                    case 8:
                        z8 = zN3;
                        objY = cVarD.y(descriptor2, 8, OptionalURLSerializer.INSTANCE, objY);
                        i5 |= 256;
                        zN3 = z8;
                        break;
                    case 9:
                        z8 = zN3;
                        objM3 = cVarD.m(descriptor2, 9, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE, objM3);
                        i5 |= 512;
                        zN3 = z8;
                        break;
                    case 10:
                        z8 = zN3;
                        objY13 = cVarD.y(descriptor2, 10, bVarArr[10], objY13);
                        i5 |= UserMetadata.MAX_ATTRIBUTE_SIZE;
                        zN3 = z8;
                        break;
                    case 11:
                        z8 = zN3;
                        objY2 = cVarD.y(descriptor2, 11, bVarArr[11], objY2);
                        i5 |= 2048;
                        zN3 = z8;
                        break;
                    case 12:
                        z6 = zN3;
                        objY12 = cVarD.y(descriptor2, 12, o0.f952a, objY12);
                        i5 |= 4096;
                        zN3 = z6;
                        break;
                    default:
                        throw new j(i7);
                }
            }
            boolean z10 = zN3;
            objM = objM4;
            Object obj2 = objY16;
            objY3 = objY12;
            obj = objY13;
            objM2 = objM3;
            z4 = zN4;
            i4 = i5;
            objY4 = objY17;
            objY5 = objY14;
            objY6 = objY15;
            objY7 = objY18;
            objY8 = obj2;
            z5 = z10;
        }
        cVarD.c(descriptor2);
        return new PaywallData.Configuration(i4, (List) objM, (String) objY8, (PaywallData.Configuration.Images) objY7, (PaywallData.Configuration.Images) objY6, (Map) objY5, z4, z5, (URL) objY4, (URL) objY, (PaywallData.Configuration.ColorInformation) objM2, (Map) obj, (List) objY2, (String) objY3, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PaywallData.Configuration value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PaywallData.Configuration.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
