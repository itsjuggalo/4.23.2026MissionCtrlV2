package com.revenuecat.purchases.paywalls.components;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.FitModeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.MaskShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls$$serializer;
import dh.e0;
import dh.h;
import dh.j1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/PartialVideoComponent.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/PartialVideoComponent;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/PartialVideoComponent;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/PartialVideoComponent;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PartialVideoComponent$$serializer implements e0 {
    public static final PartialVideoComponent$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        PartialVideoComponent$$serializer partialVideoComponent$$serializer = new PartialVideoComponent$$serializer();
        INSTANCE = partialVideoComponent$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.PartialVideoComponent", partialVideoComponent$$serializer, 16);
        j1Var.g(FirebaseAnalytics.Param.SOURCE, true);
        j1Var.g("fallback_source", true);
        j1Var.g("visible", true);
        j1Var.g("show_controls", true);
        j1Var.g("auto_play", true);
        j1Var.g("loop", true);
        j1Var.g("mute_audio", true);
        j1Var.g("size", true);
        j1Var.g("fit_mode", true);
        j1Var.g("mask_shape", true);
        j1Var.g("color_overlay", true);
        j1Var.g("padding", true);
        j1Var.g("margin", true);
        j1Var.g("border", true);
        j1Var.g("shadow", true);
        j1Var.g("override_source_lid", true);
        descriptor = j1Var;
    }

    private PartialVideoComponent$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b bVarP = a.p(ThemeVideoUrls$$serializer.INSTANCE);
        b bVarP2 = a.p(ThemeImageUrls$$serializer.INSTANCE);
        h hVar = h.f8149a;
        b bVarP3 = a.p(hVar);
        b bVarP4 = a.p(hVar);
        b bVarP5 = a.p(hVar);
        b bVarP6 = a.p(hVar);
        b bVarP7 = a.p(hVar);
        b bVarP8 = a.p(Size$$serializer.INSTANCE);
        b bVarP9 = a.p(FitModeDeserializer.INSTANCE);
        b bVarP10 = a.p(MaskShapeDeserializer.INSTANCE);
        b bVarP11 = a.p(ColorScheme$$serializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{bVarP, bVarP2, bVarP3, bVarP4, bVarP5, bVarP6, bVarP7, bVarP8, bVarP9, bVarP10, bVarP11, a.p(padding$$serializer), a.p(padding$$serializer), a.p(Border$$serializer.INSTANCE), a.p(Shadow$$serializer.INSTANCE), a.p(LocalizationKey$$serializer.INSTANCE)};
    }

    @Override // zg.a
    public PartialVideoComponent deserialize(e decoder) {
        ThemeVideoUrls themeVideoUrls;
        ThemeImageUrls themeImageUrls;
        Padding padding;
        int i10;
        Size size;
        Boolean bool;
        FitMode fitMode;
        MaskShape maskShape;
        ColorScheme colorScheme;
        Boolean bool2;
        Boolean bool3;
        Padding padding2;
        Boolean bool4;
        Boolean bool5;
        Border border;
        String strM228unboximpl;
        Shadow shadow;
        Shadow shadow2;
        Border border2;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        int i11 = 11;
        char c10 = '\n';
        char c11 = '\t';
        if (cVarB.z()) {
            ThemeVideoUrls themeVideoUrls2 = (ThemeVideoUrls) cVarB.n(descriptor2, 0, ThemeVideoUrls$$serializer.INSTANCE, null);
            ThemeImageUrls themeImageUrls2 = (ThemeImageUrls) cVarB.n(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, null);
            h hVar = h.f8149a;
            Boolean bool6 = (Boolean) cVarB.n(descriptor2, 2, hVar, null);
            Boolean bool7 = (Boolean) cVarB.n(descriptor2, 3, hVar, null);
            Boolean bool8 = (Boolean) cVarB.n(descriptor2, 4, hVar, null);
            Boolean bool9 = (Boolean) cVarB.n(descriptor2, 5, hVar, null);
            Boolean bool10 = (Boolean) cVarB.n(descriptor2, 6, hVar, null);
            Size size2 = (Size) cVarB.n(descriptor2, 7, Size$$serializer.INSTANCE, null);
            FitMode fitMode2 = (FitMode) cVarB.n(descriptor2, 8, FitModeDeserializer.INSTANCE, null);
            MaskShape maskShape2 = (MaskShape) cVarB.n(descriptor2, 9, MaskShapeDeserializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) cVarB.n(descriptor2, 10, ColorScheme$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) cVarB.n(descriptor2, 11, padding$$serializer, null);
            Padding padding4 = (Padding) cVarB.n(descriptor2, 12, padding$$serializer, null);
            Border border3 = (Border) cVarB.n(descriptor2, 13, Border$$serializer.INSTANCE, null);
            Shadow shadow3 = (Shadow) cVarB.n(descriptor2, 14, Shadow$$serializer.INSTANCE, null);
            LocalizationKey localizationKey = (LocalizationKey) cVarB.n(descriptor2, 15, LocalizationKey$$serializer.INSTANCE, null);
            i10 = 65535;
            bool4 = bool6;
            themeImageUrls = themeImageUrls2;
            bool2 = bool10;
            strM228unboximpl = localizationKey != null ? localizationKey.m228unboximpl() : null;
            padding2 = padding3;
            colorScheme = colorScheme2;
            maskShape = maskShape2;
            size = size2;
            fitMode = fitMode2;
            bool = bool9;
            bool5 = bool7;
            bool3 = bool8;
            shadow = shadow3;
            border = border3;
            padding = padding4;
            themeVideoUrls = themeVideoUrls2;
        } else {
            boolean z10 = true;
            ThemeVideoUrls themeVideoUrls3 = null;
            Shadow shadow4 = null;
            Border border4 = null;
            FitMode fitMode3 = null;
            MaskShape maskShape3 = null;
            ColorScheme colorScheme3 = null;
            Boolean bool11 = null;
            Padding padding5 = null;
            Boolean bool12 = null;
            ThemeImageUrls themeImageUrls3 = null;
            String strM228unboximpl2 = null;
            Size size3 = null;
            Boolean bool13 = null;
            Boolean bool14 = null;
            Boolean bool15 = null;
            int i12 = 0;
            Padding padding6 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z10 = false;
                        border4 = border4;
                        shadow4 = shadow4;
                        i11 = 11;
                        c10 = '\n';
                        break;
                    case 0:
                        shadow2 = shadow4;
                        border2 = border4;
                        themeVideoUrls3 = (ThemeVideoUrls) cVarB.n(descriptor2, 0, ThemeVideoUrls$$serializer.INSTANCE, themeVideoUrls3);
                        i12 |= 1;
                        border4 = border2;
                        shadow4 = shadow2;
                        i11 = 11;
                        c10 = '\n';
                        c11 = '\t';
                        break;
                    case 1:
                        shadow2 = shadow4;
                        border2 = border4;
                        themeImageUrls3 = (ThemeImageUrls) cVarB.n(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, themeImageUrls3);
                        i12 |= 2;
                        bool12 = bool12;
                        border4 = border2;
                        shadow4 = shadow2;
                        i11 = 11;
                        c10 = '\n';
                        c11 = '\t';
                        break;
                    case 2:
                        shadow2 = shadow4;
                        border2 = border4;
                        bool12 = (Boolean) cVarB.n(descriptor2, 2, h.f8149a, bool12);
                        i12 |= 4;
                        bool14 = bool14;
                        border4 = border2;
                        shadow4 = shadow2;
                        i11 = 11;
                        c10 = '\n';
                        c11 = '\t';
                        break;
                    case 3:
                        shadow2 = shadow4;
                        border2 = border4;
                        bool14 = (Boolean) cVarB.n(descriptor2, 3, h.f8149a, bool14);
                        i12 |= 8;
                        border4 = border2;
                        shadow4 = shadow2;
                        i11 = 11;
                        c10 = '\n';
                        c11 = '\t';
                        break;
                    case 4:
                        shadow2 = shadow4;
                        bool15 = (Boolean) cVarB.n(descriptor2, 4, h.f8149a, bool15);
                        i12 |= 16;
                        shadow4 = shadow2;
                        i11 = 11;
                        c10 = '\n';
                        c11 = '\t';
                        break;
                    case 5:
                        bool13 = (Boolean) cVarB.n(descriptor2, 5, h.f8149a, bool13);
                        i12 |= 32;
                        i11 = 11;
                        c10 = '\n';
                        c11 = '\t';
                        break;
                    case 6:
                        bool11 = (Boolean) cVarB.n(descriptor2, 6, h.f8149a, bool11);
                        i12 |= 64;
                        i11 = 11;
                        c10 = '\n';
                        c11 = '\t';
                        break;
                    case 7:
                        i12 |= 128;
                        size3 = (Size) cVarB.n(descriptor2, 7, Size$$serializer.INSTANCE, size3);
                        i11 = 11;
                        c10 = '\n';
                        c11 = '\t';
                        break;
                    case 8:
                        fitMode3 = (FitMode) cVarB.n(descriptor2, 8, FitModeDeserializer.INSTANCE, fitMode3);
                        i12 |= 256;
                        i11 = 11;
                        c10 = '\n';
                        c11 = '\t';
                        break;
                    case 9:
                        maskShape3 = (MaskShape) cVarB.n(descriptor2, 9, MaskShapeDeserializer.INSTANCE, maskShape3);
                        i12 |= 512;
                        c11 = '\t';
                        i11 = 11;
                        c10 = '\n';
                        break;
                    case 10:
                        colorScheme3 = (ColorScheme) cVarB.n(descriptor2, 10, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i12 |= 1024;
                        c10 = '\n';
                        i11 = 11;
                        c11 = '\t';
                        break;
                    case 11:
                        padding5 = (Padding) cVarB.n(descriptor2, i11, Padding$$serializer.INSTANCE, padding5);
                        i12 |= 2048;
                        c10 = '\n';
                        c11 = '\t';
                        break;
                    case 12:
                        padding6 = (Padding) cVarB.n(descriptor2, 12, Padding$$serializer.INSTANCE, padding6);
                        i12 |= 4096;
                        c10 = '\n';
                        c11 = '\t';
                        break;
                    case 13:
                        border4 = (Border) cVarB.n(descriptor2, 13, Border$$serializer.INSTANCE, border4);
                        i12 |= 8192;
                        c10 = '\n';
                        c11 = '\t';
                        break;
                    case 14:
                        shadow4 = (Shadow) cVarB.n(descriptor2, 14, Shadow$$serializer.INSTANCE, shadow4);
                        i12 |= 16384;
                        c10 = '\n';
                        c11 = '\t';
                        break;
                    case 15:
                        LocalizationKey localizationKey2 = (LocalizationKey) cVarB.n(descriptor2, 15, LocalizationKey$$serializer.INSTANCE, strM228unboximpl2 != null ? LocalizationKey.m222boximpl(strM228unboximpl2) : null);
                        strM228unboximpl2 = localizationKey2 != null ? localizationKey2.m228unboximpl() : null;
                        i12 |= 32768;
                        c10 = '\n';
                        c11 = '\t';
                        break;
                    default:
                        throw new m(iW);
                }
            }
            themeVideoUrls = themeVideoUrls3;
            themeImageUrls = themeImageUrls3;
            padding = padding6;
            i10 = i12;
            size = size3;
            bool = bool13;
            fitMode = fitMode3;
            maskShape = maskShape3;
            colorScheme = colorScheme3;
            bool2 = bool11;
            bool3 = bool15;
            padding2 = padding5;
            bool4 = bool12;
            bool5 = bool14;
            border = border4;
            strM228unboximpl = strM228unboximpl2;
            shadow = shadow4;
        }
        cVarB.c(descriptor2);
        return new PartialVideoComponent(i10, themeVideoUrls, themeImageUrls, bool4, bool5, bool3, bool, bool2, size, fitMode, maskShape, colorScheme, padding2, padding, border, shadow, strM228unboximpl, null, null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, PartialVideoComponent value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        PartialVideoComponent.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
