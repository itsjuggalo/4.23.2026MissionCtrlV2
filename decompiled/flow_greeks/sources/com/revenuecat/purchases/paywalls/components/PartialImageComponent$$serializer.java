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
import dh.e0;
import dh.h;
import dh.j1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/PartialImageComponent.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/PartialImageComponent;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/PartialImageComponent;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/PartialImageComponent;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PartialImageComponent$$serializer implements e0 {
    public static final PartialImageComponent$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        PartialImageComponent$$serializer partialImageComponent$$serializer = new PartialImageComponent$$serializer();
        INSTANCE = partialImageComponent$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.PartialImageComponent", partialImageComponent$$serializer, 11);
        j1Var.g("visible", true);
        j1Var.g(FirebaseAnalytics.Param.SOURCE, true);
        j1Var.g("size", true);
        j1Var.g("override_source_lid", true);
        j1Var.g("fit_mode", true);
        j1Var.g("mask_shape", true);
        j1Var.g("color_overlay", true);
        j1Var.g("padding", true);
        j1Var.g("margin", true);
        j1Var.g("border", true);
        j1Var.g("shadow", true);
        descriptor = j1Var;
    }

    private PartialImageComponent$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b bVarP = a.p(h.f8149a);
        b bVarP2 = a.p(ThemeImageUrls$$serializer.INSTANCE);
        b bVarP3 = a.p(Size$$serializer.INSTANCE);
        b bVarP4 = a.p(LocalizationKey$$serializer.INSTANCE);
        b bVarP5 = a.p(FitModeDeserializer.INSTANCE);
        b bVarP6 = a.p(MaskShapeDeserializer.INSTANCE);
        b bVarP7 = a.p(ColorScheme$$serializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{bVarP, bVarP2, bVarP3, bVarP4, bVarP5, bVarP6, bVarP7, a.p(padding$$serializer), a.p(padding$$serializer), a.p(Border$$serializer.INSTANCE), a.p(Shadow$$serializer.INSTANCE)};
    }

    @Override // zg.a
    public PartialImageComponent deserialize(e decoder) {
        Boolean bool;
        FitMode fitMode;
        ThemeImageUrls themeImageUrls;
        Size size;
        Padding padding;
        int i10;
        MaskShape maskShape;
        ColorScheme colorScheme;
        Padding padding2;
        Border border;
        Shadow shadow;
        String str;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        int i11 = 10;
        int i12 = 9;
        int i13 = 7;
        int i14 = 6;
        Border border2 = null;
        if (cVarB.z()) {
            bool = (Boolean) cVarB.n(descriptor2, 0, h.f8149a, null);
            ThemeImageUrls themeImageUrls2 = (ThemeImageUrls) cVarB.n(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, null);
            Size size2 = (Size) cVarB.n(descriptor2, 2, Size$$serializer.INSTANCE, null);
            LocalizationKey localizationKey = (LocalizationKey) cVarB.n(descriptor2, 3, LocalizationKey$$serializer.INSTANCE, null);
            String strM228unboximpl = localizationKey != null ? localizationKey.m228unboximpl() : null;
            FitMode fitMode2 = (FitMode) cVarB.n(descriptor2, 4, FitModeDeserializer.INSTANCE, null);
            MaskShape maskShape2 = (MaskShape) cVarB.n(descriptor2, 5, MaskShapeDeserializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) cVarB.n(descriptor2, 6, ColorScheme$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) cVarB.n(descriptor2, 7, padding$$serializer, null);
            Padding padding4 = (Padding) cVarB.n(descriptor2, 8, padding$$serializer, null);
            Border border3 = (Border) cVarB.n(descriptor2, 9, Border$$serializer.INSTANCE, null);
            shadow = (Shadow) cVarB.n(descriptor2, 10, Shadow$$serializer.INSTANCE, null);
            border = border3;
            padding2 = padding3;
            colorScheme = colorScheme2;
            maskShape = maskShape2;
            str = strM228unboximpl;
            padding = padding4;
            fitMode = fitMode2;
            size = size2;
            themeImageUrls = themeImageUrls2;
            i10 = 2047;
        } else {
            boolean z10 = true;
            int i15 = 0;
            bool = null;
            Padding padding5 = null;
            MaskShape maskShape3 = null;
            ColorScheme colorScheme3 = null;
            Padding padding6 = null;
            Shadow shadow2 = null;
            String strM228unboximpl2 = null;
            FitMode fitMode3 = null;
            Size size3 = null;
            ThemeImageUrls themeImageUrls3 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z10 = false;
                        i11 = 10;
                        i13 = 7;
                        i14 = 6;
                        break;
                    case 0:
                        bool = (Boolean) cVarB.n(descriptor2, 0, h.f8149a, bool);
                        i15 |= 1;
                        i11 = 10;
                        i12 = 9;
                        i13 = 7;
                        i14 = 6;
                        break;
                    case 1:
                        themeImageUrls3 = (ThemeImageUrls) cVarB.n(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, themeImageUrls3);
                        i15 |= 2;
                        i11 = 10;
                        i12 = 9;
                        i13 = 7;
                        i14 = 6;
                        break;
                    case 2:
                        size3 = (Size) cVarB.n(descriptor2, 2, Size$$serializer.INSTANCE, size3);
                        i15 |= 4;
                        i11 = 10;
                        i12 = 9;
                        i13 = 7;
                        break;
                    case 3:
                        FitMode fitMode4 = fitMode3;
                        LocalizationKey localizationKey2 = (LocalizationKey) cVarB.n(descriptor2, 3, LocalizationKey$$serializer.INSTANCE, strM228unboximpl2 != null ? LocalizationKey.m222boximpl(strM228unboximpl2) : null);
                        strM228unboximpl2 = localizationKey2 != null ? localizationKey2.m228unboximpl() : null;
                        i15 |= 8;
                        fitMode3 = fitMode4;
                        i11 = 10;
                        i12 = 9;
                        i13 = 7;
                        break;
                    case 4:
                        i15 |= 16;
                        fitMode3 = (FitMode) cVarB.n(descriptor2, 4, FitModeDeserializer.INSTANCE, fitMode3);
                        i11 = 10;
                        i12 = 9;
                        break;
                    case 5:
                        maskShape3 = (MaskShape) cVarB.n(descriptor2, 5, MaskShapeDeserializer.INSTANCE, maskShape3);
                        i15 |= 32;
                        i11 = 10;
                        break;
                    case 6:
                        colorScheme3 = (ColorScheme) cVarB.n(descriptor2, i14, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i15 |= 64;
                        break;
                    case 7:
                        padding6 = (Padding) cVarB.n(descriptor2, i13, Padding$$serializer.INSTANCE, padding6);
                        i15 |= 128;
                        break;
                    case 8:
                        padding5 = (Padding) cVarB.n(descriptor2, 8, Padding$$serializer.INSTANCE, padding5);
                        i15 |= 256;
                        break;
                    case 9:
                        border2 = (Border) cVarB.n(descriptor2, i12, Border$$serializer.INSTANCE, border2);
                        i15 |= 512;
                        break;
                    case 10:
                        shadow2 = (Shadow) cVarB.n(descriptor2, i11, Shadow$$serializer.INSTANCE, shadow2);
                        i15 |= 1024;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            fitMode = fitMode3;
            themeImageUrls = themeImageUrls3;
            size = size3;
            padding = padding5;
            i10 = i15;
            maskShape = maskShape3;
            colorScheme = colorScheme3;
            padding2 = padding6;
            border = border2;
            shadow = shadow2;
            str = strM228unboximpl2;
        }
        Boolean bool2 = bool;
        cVarB.c(descriptor2);
        return new PartialImageComponent(i10, bool2, themeImageUrls, size, str, fitMode, maskShape, colorScheme, padding2, padding, border, shadow, null, null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, PartialImageComponent value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        PartialImageComponent.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
