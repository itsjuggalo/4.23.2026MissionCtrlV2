package com.revenuecat.purchases.paywalls.components.common;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.FitModeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls$$serializer;
import dh.e0;
import dh.h;
import dh.j1;
import dh.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/common/Background.Video.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/common/Background$Video;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/common/Background$Video;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/common/Background$Video;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Background$Video$$serializer implements e0 {
    public static final Background$Video$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        Background$Video$$serializer background$Video$$serializer = new Background$Video$$serializer();
        INSTANCE = background$Video$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.common.Background.Video", background$Video$$serializer, 6);
        j1Var.g("value", false);
        j1Var.g("fallback_image", false);
        j1Var.g("loop", false);
        j1Var.g("mute_audio", false);
        j1Var.g("fit_mode", true);
        j1Var.g("color_overlay", true);
        descriptor = j1Var;
    }

    private Background$Video$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b bVarP = a.p(ColorScheme$$serializer.INSTANCE);
        h hVar = h.f8149a;
        return new b[]{ThemeVideoUrls$$serializer.INSTANCE, ThemeImageUrls$$serializer.INSTANCE, hVar, hVar, FitModeDeserializer.INSTANCE, bVarP};
    }

    @Override // zg.a
    public Background.Video deserialize(e decoder) {
        boolean z10;
        boolean z11;
        int i10;
        ThemeVideoUrls themeVideoUrls;
        ThemeImageUrls themeImageUrls;
        FitMode fitMode;
        ColorScheme colorScheme;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        int i11 = 5;
        if (cVarB.z()) {
            ThemeVideoUrls themeVideoUrls2 = (ThemeVideoUrls) cVarB.h(descriptor2, 0, ThemeVideoUrls$$serializer.INSTANCE, null);
            ThemeImageUrls themeImageUrls2 = (ThemeImageUrls) cVarB.h(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, null);
            boolean zB = cVarB.B(descriptor2, 2);
            boolean zB2 = cVarB.B(descriptor2, 3);
            FitMode fitMode2 = (FitMode) cVarB.h(descriptor2, 4, FitModeDeserializer.INSTANCE, null);
            themeVideoUrls = themeVideoUrls2;
            colorScheme = (ColorScheme) cVarB.n(descriptor2, 5, ColorScheme$$serializer.INSTANCE, null);
            z10 = zB2;
            fitMode = fitMode2;
            z11 = zB;
            themeImageUrls = themeImageUrls2;
            i10 = 63;
        } else {
            boolean z12 = true;
            boolean zB3 = false;
            int i12 = 0;
            ThemeVideoUrls themeVideoUrls3 = null;
            ThemeImageUrls themeImageUrls3 = null;
            FitMode fitMode3 = null;
            ColorScheme colorScheme2 = null;
            boolean zB4 = false;
            while (z12) {
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z12 = false;
                        i11 = 5;
                        break;
                    case 0:
                        themeVideoUrls3 = (ThemeVideoUrls) cVarB.h(descriptor2, 0, ThemeVideoUrls$$serializer.INSTANCE, themeVideoUrls3);
                        i12 |= 1;
                        i11 = 5;
                        break;
                    case 1:
                        themeImageUrls3 = (ThemeImageUrls) cVarB.h(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, themeImageUrls3);
                        i12 |= 2;
                        break;
                    case 2:
                        zB4 = cVarB.B(descriptor2, 2);
                        i12 |= 4;
                        break;
                    case 3:
                        zB3 = cVarB.B(descriptor2, 3);
                        i12 |= 8;
                        break;
                    case 4:
                        fitMode3 = (FitMode) cVarB.h(descriptor2, 4, FitModeDeserializer.INSTANCE, fitMode3);
                        i12 |= 16;
                        break;
                    case 5:
                        colorScheme2 = (ColorScheme) cVarB.n(descriptor2, i11, ColorScheme$$serializer.INSTANCE, colorScheme2);
                        i12 |= 32;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            z10 = zB3;
            z11 = zB4;
            i10 = i12;
            themeVideoUrls = themeVideoUrls3;
            themeImageUrls = themeImageUrls3;
            fitMode = fitMode3;
            colorScheme = colorScheme2;
        }
        cVarB.c(descriptor2);
        return new Background.Video(i10, themeVideoUrls, themeImageUrls, z11, z10, fitMode, colorScheme, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, Background.Video value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        Background.Video.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
