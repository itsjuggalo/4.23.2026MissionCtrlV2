package com.revenuecat.purchases.paywalls.components.properties;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.w0;
import W2.w;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import java.net.URL;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class ImageUrls$$serializer implements C {
    public static final ImageUrls$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        ImageUrls$$serializer imageUrls$$serializer = new ImageUrls$$serializer();
        INSTANCE = imageUrls$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.properties.ImageUrls", imageUrls$$serializer, 5);
        c0327b0.l("original", false);
        c0327b0.l("webp", false);
        c0327b0.l("webp_low_res", false);
        c0327b0.l("width", false);
        c0327b0.l("height", false);
        descriptor = c0327b0;
    }

    private ImageUrls$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        URLSerializer uRLSerializer = URLSerializer.INSTANCE;
        w0 w0Var = w0.f990a;
        return new b[]{uRLSerializer, uRLSerializer, uRLSerializer, w0Var, w0Var};
    }

    @Override // F3.a
    public ImageUrls deserialize(e decoder) {
        Object objM;
        int i4;
        Object objM2;
        Object objM3;
        Object objM4;
        Object objM5;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        Object objM6 = null;
        if (cVarD.w()) {
            URLSerializer uRLSerializer = URLSerializer.INSTANCE;
            objM2 = cVarD.m(descriptor2, 0, uRLSerializer, null);
            Object objM7 = cVarD.m(descriptor2, 1, uRLSerializer, null);
            objM3 = cVarD.m(descriptor2, 2, uRLSerializer, null);
            w0 w0Var = w0.f990a;
            objM4 = cVarD.m(descriptor2, 3, w0Var, null);
            objM5 = cVarD.m(descriptor2, 4, w0Var, null);
            objM = objM7;
            i4 = 31;
        } else {
            boolean z4 = true;
            int i5 = 0;
            objM = null;
            Object objM8 = null;
            Object objM9 = null;
            Object objM10 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objM6 = cVarD.m(descriptor2, 0, URLSerializer.INSTANCE, objM6);
                    i5 |= 1;
                } else if (i6 == 1) {
                    objM = cVarD.m(descriptor2, 1, URLSerializer.INSTANCE, objM);
                    i5 |= 2;
                } else if (i6 == 2) {
                    objM8 = cVarD.m(descriptor2, 2, URLSerializer.INSTANCE, objM8);
                    i5 |= 4;
                } else if (i6 == 3) {
                    objM9 = cVarD.m(descriptor2, 3, w0.f990a, objM9);
                    i5 |= 8;
                } else {
                    if (i6 != 4) {
                        throw new j(i6);
                    }
                    objM10 = cVarD.m(descriptor2, 4, w0.f990a, objM10);
                    i5 |= 16;
                }
            }
            i4 = i5;
            objM2 = objM6;
            objM3 = objM8;
            objM4 = objM9;
            objM5 = objM10;
        }
        cVarD.c(descriptor2);
        return new ImageUrls(i4, (URL) objM2, (URL) objM, (URL) objM3, (w) objM4, (w) objM5, null, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, ImageUrls value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        ImageUrls.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
