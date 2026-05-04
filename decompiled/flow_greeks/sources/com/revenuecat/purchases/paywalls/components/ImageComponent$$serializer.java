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
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/ImageComponent.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/ImageComponent;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/ImageComponent;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/ImageComponent;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ImageComponent$$serializer implements e0 {
    public static final ImageComponent$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        ImageComponent$$serializer imageComponent$$serializer = new ImageComponent$$serializer();
        INSTANCE = imageComponent$$serializer;
        j1 j1Var = new j1("image", imageComponent$$serializer, 12);
        j1Var.g(FirebaseAnalytics.Param.SOURCE, false);
        j1Var.g("visible", true);
        j1Var.g("size", true);
        j1Var.g("override_source_lid", true);
        j1Var.g("mask_shape", true);
        j1Var.g("color_overlay", true);
        j1Var.g("fit_mode", true);
        j1Var.g("padding", true);
        j1Var.g("margin", true);
        j1Var.g("border", true);
        j1Var.g("shadow", true);
        j1Var.g("overrides", true);
        descriptor = j1Var;
    }

    private ImageComponent$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b[] bVarArr = ImageComponent.$childSerializers;
        b bVarP = a.p(h.f8149a);
        b bVarP2 = a.p(LocalizationKey$$serializer.INSTANCE);
        b bVarP3 = a.p(MaskShapeDeserializer.INSTANCE);
        b bVarP4 = a.p(ColorScheme$$serializer.INSTANCE);
        b bVarP5 = a.p(Border$$serializer.INSTANCE);
        b bVarP6 = a.p(Shadow$$serializer.INSTANCE);
        b bVar = bVarArr[11];
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{ThemeImageUrls$$serializer.INSTANCE, bVarP, Size$$serializer.INSTANCE, bVarP2, bVarP3, bVarP4, FitModeDeserializer.INSTANCE, padding$$serializer, padding$$serializer, bVarP5, bVarP6, bVar};
    }

    @Override // zg.a
    public ImageComponent deserialize(e decoder) {
        MaskShape maskShape;
        Boolean bool;
        Size size;
        int i10;
        Padding padding;
        FitMode fitMode;
        ThemeImageUrls themeImageUrls;
        ColorScheme colorScheme;
        Padding padding2;
        List list;
        Border border;
        Shadow shadow;
        String str;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        b[] bVarArr = ImageComponent.$childSerializers;
        int i11 = 10;
        int i12 = 9;
        int i13 = 8;
        List list2 = null;
        if (cVarB.z()) {
            ThemeImageUrls themeImageUrls2 = (ThemeImageUrls) cVarB.h(descriptor2, 0, ThemeImageUrls$$serializer.INSTANCE, null);
            Boolean bool2 = (Boolean) cVarB.n(descriptor2, 1, h.f8149a, null);
            Size size2 = (Size) cVarB.h(descriptor2, 2, Size$$serializer.INSTANCE, null);
            LocalizationKey localizationKey = (LocalizationKey) cVarB.n(descriptor2, 3, LocalizationKey$$serializer.INSTANCE, null);
            String strM228unboximpl = localizationKey != null ? localizationKey.m228unboximpl() : null;
            MaskShape maskShape2 = (MaskShape) cVarB.n(descriptor2, 4, MaskShapeDeserializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) cVarB.n(descriptor2, 5, ColorScheme$$serializer.INSTANCE, null);
            FitMode fitMode2 = (FitMode) cVarB.h(descriptor2, 6, FitModeDeserializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) cVarB.h(descriptor2, 7, padding$$serializer, null);
            Padding padding4 = (Padding) cVarB.h(descriptor2, 8, padding$$serializer, null);
            Border border2 = (Border) cVarB.n(descriptor2, 9, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) cVarB.n(descriptor2, 10, Shadow$$serializer.INSTANCE, null);
            list = (List) cVarB.h(descriptor2, 11, bVarArr[11], null);
            themeImageUrls = themeImageUrls2;
            shadow = shadow2;
            border = border2;
            padding2 = padding3;
            fitMode = fitMode2;
            colorScheme = colorScheme2;
            str = strM228unboximpl;
            padding = padding4;
            maskShape = maskShape2;
            size = size2;
            i10 = 4095;
            bool = bool2;
        } else {
            int i14 = 11;
            Padding padding5 = null;
            FitMode fitMode3 = null;
            ColorScheme colorScheme3 = null;
            Padding padding6 = null;
            ThemeImageUrls themeImageUrls3 = null;
            String strM228unboximpl2 = null;
            MaskShape maskShape3 = null;
            Size size3 = null;
            Boolean bool3 = null;
            boolean z10 = true;
            int i15 = 0;
            Border border3 = null;
            Shadow shadow3 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z10 = false;
                        bVarArr = bVarArr;
                        i14 = 11;
                        i12 = 9;
                        themeImageUrls3 = themeImageUrls3;
                        i13 = 8;
                        break;
                    case 0:
                        i15 |= 1;
                        bVarArr = bVarArr;
                        i14 = 11;
                        i12 = 9;
                        i13 = 8;
                        themeImageUrls3 = (ThemeImageUrls) cVarB.h(descriptor2, 0, ThemeImageUrls$$serializer.INSTANCE, themeImageUrls3);
                        i11 = 10;
                        break;
                    case 1:
                        bool3 = (Boolean) cVarB.n(descriptor2, 1, h.f8149a, bool3);
                        i15 |= 2;
                        i14 = 11;
                        i11 = 10;
                        i12 = 9;
                        i13 = 8;
                        break;
                    case 2:
                        size3 = (Size) cVarB.h(descriptor2, 2, Size$$serializer.INSTANCE, size3);
                        i15 |= 4;
                        i14 = 11;
                        i11 = 10;
                        i12 = 9;
                        break;
                    case 3:
                        MaskShape maskShape4 = maskShape3;
                        LocalizationKey localizationKey2 = (LocalizationKey) cVarB.n(descriptor2, 3, LocalizationKey$$serializer.INSTANCE, strM228unboximpl2 != null ? LocalizationKey.m222boximpl(strM228unboximpl2) : null);
                        strM228unboximpl2 = localizationKey2 != null ? localizationKey2.m228unboximpl() : null;
                        i15 |= 8;
                        maskShape3 = maskShape4;
                        i14 = 11;
                        i11 = 10;
                        i12 = 9;
                        break;
                    case 4:
                        maskShape3 = (MaskShape) cVarB.n(descriptor2, 4, MaskShapeDeserializer.INSTANCE, maskShape3);
                        i15 |= 16;
                        i14 = 11;
                        i11 = 10;
                        break;
                    case 5:
                        colorScheme3 = (ColorScheme) cVarB.n(descriptor2, 5, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i15 |= 32;
                        i14 = 11;
                        break;
                    case 6:
                        fitMode3 = (FitMode) cVarB.h(descriptor2, 6, FitModeDeserializer.INSTANCE, fitMode3);
                        i15 |= 64;
                        i14 = 11;
                        break;
                    case 7:
                        padding6 = (Padding) cVarB.h(descriptor2, 7, Padding$$serializer.INSTANCE, padding6);
                        i15 |= 128;
                        i14 = 11;
                        break;
                    case 8:
                        padding5 = (Padding) cVarB.h(descriptor2, i13, Padding$$serializer.INSTANCE, padding5);
                        i15 |= 256;
                        break;
                    case 9:
                        border3 = (Border) cVarB.n(descriptor2, i12, Border$$serializer.INSTANCE, border3);
                        i15 |= 512;
                        break;
                    case 10:
                        shadow3 = (Shadow) cVarB.n(descriptor2, i11, Shadow$$serializer.INSTANCE, shadow3);
                        i15 |= 1024;
                        break;
                    case 11:
                        list2 = (List) cVarB.h(descriptor2, i14, bVarArr[i14], list2);
                        i15 |= 2048;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            maskShape = maskShape3;
            bool = bool3;
            size = size3;
            i10 = i15;
            padding = padding5;
            fitMode = fitMode3;
            themeImageUrls = themeImageUrls3;
            colorScheme = colorScheme3;
            padding2 = padding6;
            list = list2;
            border = border3;
            shadow = shadow3;
            str = strM228unboximpl2;
        }
        cVarB.c(descriptor2);
        return new ImageComponent(i10, themeImageUrls, bool, size, str, maskShape, colorScheme, fitMode, padding2, padding, border, shadow, list, null, null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, ImageComponent value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        ImageComponent.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
