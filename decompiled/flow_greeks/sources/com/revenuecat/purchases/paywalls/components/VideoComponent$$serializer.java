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
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/VideoComponent.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/VideoComponent;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/VideoComponent;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/VideoComponent;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VideoComponent$$serializer implements e0 {
    public static final VideoComponent$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        VideoComponent$$serializer videoComponent$$serializer = new VideoComponent$$serializer();
        INSTANCE = videoComponent$$serializer;
        j1 j1Var = new j1("video", videoComponent$$serializer, 17);
        j1Var.g(FirebaseAnalytics.Param.SOURCE, false);
        j1Var.g("fallback_source", false);
        j1Var.g("visible", false);
        j1Var.g("show_controls", false);
        j1Var.g("auto_play", false);
        j1Var.g("loop", false);
        j1Var.g("mute_audio", false);
        j1Var.g("size", false);
        j1Var.g("fit_mode", false);
        j1Var.g("mask_shape", false);
        j1Var.g("color_overlay", false);
        j1Var.g("padding", false);
        j1Var.g("margin", false);
        j1Var.g("border", false);
        j1Var.g("shadow", false);
        j1Var.g("overrides", false);
        j1Var.g("override_source_lid", true);
        descriptor = j1Var;
    }

    private VideoComponent$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b[] bVarArr = VideoComponent.$childSerializers;
        b bVarP = a.p(ThemeImageUrls$$serializer.INSTANCE);
        h hVar = h.f8149a;
        b bVarP2 = a.p(hVar);
        b bVarP3 = a.p(MaskShapeDeserializer.INSTANCE);
        b bVarP4 = a.p(ColorScheme$$serializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{ThemeVideoUrls$$serializer.INSTANCE, bVarP, bVarP2, hVar, hVar, hVar, hVar, Size$$serializer.INSTANCE, FitModeDeserializer.INSTANCE, bVarP3, bVarP4, a.p(padding$$serializer), a.p(padding$$serializer), a.p(Border$$serializer.INSTANCE), a.p(Shadow$$serializer.INSTANCE), a.p(bVarArr[15]), a.p(LocalizationKey$$serializer.INSTANCE)};
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // zg.a
    public VideoComponent deserialize(e decoder) {
        Padding padding;
        List list;
        Shadow shadow;
        Border border;
        Padding padding2;
        Boolean bool;
        ThemeImageUrls themeImageUrls;
        FitMode fitMode;
        Size size;
        ColorScheme colorScheme;
        MaskShape maskShape;
        ThemeVideoUrls themeVideoUrls;
        int i10;
        boolean z10;
        String strM228unboximpl;
        boolean z11;
        boolean z12;
        boolean z13;
        char c10;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        b[] bVarArr = VideoComponent.$childSerializers;
        int i11 = 10;
        char c11 = '\t';
        char c12 = '\b';
        if (cVarB.z()) {
            ThemeVideoUrls themeVideoUrls2 = (ThemeVideoUrls) cVarB.h(descriptor2, 0, ThemeVideoUrls$$serializer.INSTANCE, null);
            ThemeImageUrls themeImageUrls2 = (ThemeImageUrls) cVarB.n(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, null);
            Boolean bool2 = (Boolean) cVarB.n(descriptor2, 2, h.f8149a, null);
            boolean zB = cVarB.B(descriptor2, 3);
            boolean zB2 = cVarB.B(descriptor2, 4);
            boolean zB3 = cVarB.B(descriptor2, 5);
            boolean zB4 = cVarB.B(descriptor2, 6);
            Size size2 = (Size) cVarB.h(descriptor2, 7, Size$$serializer.INSTANCE, null);
            FitMode fitMode2 = (FitMode) cVarB.h(descriptor2, 8, FitModeDeserializer.INSTANCE, null);
            MaskShape maskShape2 = (MaskShape) cVarB.n(descriptor2, 9, MaskShapeDeserializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) cVarB.n(descriptor2, 10, ColorScheme$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) cVarB.n(descriptor2, 11, padding$$serializer, null);
            Padding padding4 = (Padding) cVarB.n(descriptor2, 12, padding$$serializer, null);
            Border border2 = (Border) cVarB.n(descriptor2, 13, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) cVarB.n(descriptor2, 14, Shadow$$serializer.INSTANCE, null);
            List list2 = (List) cVarB.n(descriptor2, 15, bVarArr[15], null);
            LocalizationKey localizationKey = (LocalizationKey) cVarB.n(descriptor2, 16, LocalizationKey$$serializer.INSTANCE, null);
            i10 = 131071;
            themeVideoUrls = themeVideoUrls2;
            bool = bool2;
            themeImageUrls = themeImageUrls2;
            z10 = zB;
            strM228unboximpl = localizationKey != null ? localizationKey.m228unboximpl() : null;
            colorScheme = colorScheme2;
            maskShape = maskShape2;
            size = size2;
            z11 = zB4;
            z12 = zB3;
            z13 = zB2;
            fitMode = fitMode2;
            shadow = shadow2;
            border = border2;
            list = list2;
            padding2 = padding4;
            padding = padding3;
        } else {
            boolean z14 = true;
            int i12 = 0;
            boolean zB5 = false;
            boolean zB6 = false;
            boolean zB7 = false;
            boolean zB8 = false;
            Padding padding5 = null;
            List list3 = null;
            Shadow shadow3 = null;
            Border border3 = null;
            FitMode fitMode3 = null;
            Size size3 = null;
            ColorScheme colorScheme3 = null;
            MaskShape maskShape3 = null;
            ThemeVideoUrls themeVideoUrls3 = null;
            Boolean bool3 = null;
            ThemeImageUrls themeImageUrls3 = null;
            String strM228unboximpl2 = null;
            while (z14) {
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z14 = false;
                        i12 = i12;
                        c11 = '\t';
                        c12 = '\b';
                        break;
                    case 0:
                        themeVideoUrls3 = (ThemeVideoUrls) cVarB.h(descriptor2, 0, ThemeVideoUrls$$serializer.INSTANCE, themeVideoUrls3);
                        i12 |= 1;
                        i11 = 10;
                        c11 = '\t';
                        c12 = '\b';
                        break;
                    case 1:
                        themeImageUrls3 = (ThemeImageUrls) cVarB.n(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, themeImageUrls3);
                        i12 |= 2;
                        i11 = 10;
                        c11 = '\t';
                        c12 = '\b';
                        break;
                    case 2:
                        bool3 = (Boolean) cVarB.n(descriptor2, 2, h.f8149a, bool3);
                        i12 |= 4;
                        i11 = 10;
                        c11 = '\t';
                        c12 = '\b';
                        break;
                    case 3:
                        zB5 = cVarB.B(descriptor2, 3);
                        i12 |= 8;
                        i11 = 10;
                        c11 = '\t';
                        c12 = '\b';
                        break;
                    case 4:
                        zB8 = cVarB.B(descriptor2, 4);
                        i12 |= 16;
                        i11 = 10;
                        c11 = '\t';
                        c12 = '\b';
                        break;
                    case 5:
                        zB7 = cVarB.B(descriptor2, 5);
                        i12 |= 32;
                        i11 = 10;
                        c11 = '\t';
                        c12 = '\b';
                        break;
                    case 6:
                        c10 = 7;
                        zB6 = cVarB.B(descriptor2, 6);
                        i12 |= 64;
                        i11 = 10;
                        c11 = '\t';
                        c12 = '\b';
                        break;
                    case 7:
                        c10 = 7;
                        size3 = (Size) cVarB.h(descriptor2, 7, Size$$serializer.INSTANCE, size3);
                        i12 |= 128;
                        i11 = 10;
                        c11 = '\t';
                        c12 = '\b';
                        break;
                    case 8:
                        fitMode3 = (FitMode) cVarB.h(descriptor2, 8, FitModeDeserializer.INSTANCE, fitMode3);
                        i12 |= 256;
                        c12 = '\b';
                        i11 = 10;
                        c11 = '\t';
                        break;
                    case 9:
                        maskShape3 = (MaskShape) cVarB.n(descriptor2, 9, MaskShapeDeserializer.INSTANCE, maskShape3);
                        i12 |= 512;
                        c11 = '\t';
                        i11 = 10;
                        c12 = '\b';
                        break;
                    case 10:
                        colorScheme3 = (ColorScheme) cVarB.n(descriptor2, i11, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i12 |= 1024;
                        c11 = '\t';
                        c12 = '\b';
                        break;
                    case 11:
                        padding5 = (Padding) cVarB.n(descriptor2, 11, Padding$$serializer.INSTANCE, padding5);
                        i12 |= 2048;
                        c11 = '\t';
                        c12 = '\b';
                        break;
                    case 12:
                        obj = (Padding) cVarB.n(descriptor2, 12, Padding$$serializer.INSTANCE, obj);
                        i12 |= 4096;
                        c11 = '\t';
                        c12 = '\b';
                        break;
                    case 13:
                        border3 = (Border) cVarB.n(descriptor2, 13, Border$$serializer.INSTANCE, border3);
                        i12 |= 8192;
                        c11 = '\t';
                        c12 = '\b';
                        break;
                    case 14:
                        shadow3 = (Shadow) cVarB.n(descriptor2, 14, Shadow$$serializer.INSTANCE, shadow3);
                        i12 |= 16384;
                        c11 = '\t';
                        c12 = '\b';
                        break;
                    case 15:
                        list3 = (List) cVarB.n(descriptor2, 15, bVarArr[15], list3);
                        i12 |= 32768;
                        c11 = '\t';
                        c12 = '\b';
                        break;
                    case 16:
                        LocalizationKey localizationKey2 = (LocalizationKey) cVarB.n(descriptor2, 16, LocalizationKey$$serializer.INSTANCE, strM228unboximpl2 != null ? LocalizationKey.m222boximpl(strM228unboximpl2) : null);
                        strM228unboximpl2 = localizationKey2 != null ? localizationKey2.m228unboximpl() : null;
                        i12 |= 65536;
                        c11 = '\t';
                        c12 = '\b';
                        break;
                    default:
                        throw new m(iW);
                }
            }
            padding = padding5;
            list = list3;
            shadow = shadow3;
            border = border3;
            padding2 = obj;
            bool = bool3;
            themeImageUrls = themeImageUrls3;
            fitMode = fitMode3;
            size = size3;
            colorScheme = colorScheme3;
            maskShape = maskShape3;
            themeVideoUrls = themeVideoUrls3;
            i10 = i12;
            z10 = zB5;
            strM228unboximpl = strM228unboximpl2;
            z11 = zB6;
            z12 = zB7;
            z13 = zB8;
        }
        cVarB.c(descriptor2);
        return new VideoComponent(i10, themeVideoUrls, themeImageUrls, bool, z10, z13, z12, z11, size, fitMode, maskShape, colorScheme, padding, padding2, border, shadow, list, strM228unboximpl, null, null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, VideoComponent value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        VideoComponent.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
