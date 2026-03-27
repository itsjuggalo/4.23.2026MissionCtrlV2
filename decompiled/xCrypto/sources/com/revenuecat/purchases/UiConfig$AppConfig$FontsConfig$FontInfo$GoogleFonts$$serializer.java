package com.revenuecat.purchases;

import F3.j;
import J3.C;
import J3.C0327b0;
import J3.o0;
import com.revenuecat.purchases.UiConfig;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class UiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts$$serializer implements C {
    public static final UiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        UiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts$$serializer uiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts$$serializer = new UiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts$$serializer();
        INSTANCE = uiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts$$serializer;
        C0327b0 c0327b0 = new C0327b0("google_fonts", uiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts$$serializer, 1);
        c0327b0.l("value", false);
        descriptor = c0327b0;
    }

    private UiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts$$serializer() {
    }

    @Override // J3.C
    public F3.b[] childSerializers() {
        return new F3.b[]{o0.f952a};
    }

    @Override // F3.a
    public UiConfig.AppConfig.FontsConfig.FontInfo.GoogleFonts deserialize(I3.e decoder) {
        String strV;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        I3.c cVarD = decoder.d(descriptor2);
        int i4 = 1;
        if (cVarD.w()) {
            strV = cVarD.v(descriptor2, 0);
        } else {
            boolean z4 = true;
            int i5 = 0;
            strV = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else {
                    if (i6 != 0) {
                        throw new j(i6);
                    }
                    strV = cVarD.v(descriptor2, 0);
                    i5 = 1;
                }
            }
            i4 = i5;
        }
        cVarD.c(descriptor2);
        return new UiConfig.AppConfig.FontsConfig.FontInfo.GoogleFonts(i4, strV, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(I3.f encoder, UiConfig.AppConfig.FontsConfig.FontInfo.GoogleFonts value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        I3.d dVarD = encoder.d(descriptor2);
        dVarD.o(descriptor2, 0, value.value);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public F3.b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
