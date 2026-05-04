package com.revenuecat.purchases;

import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.paywalls.components.properties.FontStyle;
import com.revenuecat.purchases.paywalls.components.properties.FontStyleDeserializer;
import dh.e0;
import dh.j0;
import dh.j1;
import dh.s1;
import dh.w1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/UiConfig.AppConfig.FontsConfig.FontInfo.Name.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer implements e0 {
    public static final UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer uiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer = new UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer();
        INSTANCE = uiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer;
        j1 j1Var = new j1("name", uiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer, 6);
        j1Var.g("value", false);
        j1Var.g("url", true);
        j1Var.g("hash", true);
        j1Var.g("family", true);
        j1Var.g("weight", true);
        j1Var.g("style", true);
        descriptor = j1Var;
    }

    private UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer() {
    }

    @Override // dh.e0
    public zg.b[] childSerializers() {
        w1 w1Var = w1.f8244a;
        return new zg.b[]{w1Var, ah.a.p(w1Var), ah.a.p(w1Var), ah.a.p(w1Var), ah.a.p(j0.f8162a), ah.a.p(FontStyleDeserializer.INSTANCE)};
    }

    @Override // zg.a
    public UiConfig.AppConfig.FontsConfig.FontInfo.Name deserialize(ch.e decoder) {
        int i10;
        String str;
        String str2;
        String str3;
        String str4;
        Integer num;
        FontStyle fontStyle;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        ch.c cVarB = decoder.b(descriptor2);
        String strS = null;
        if (cVarB.z()) {
            String strS2 = cVarB.s(descriptor2, 0);
            w1 w1Var = w1.f8244a;
            String str5 = (String) cVarB.n(descriptor2, 1, w1Var, null);
            String str6 = (String) cVarB.n(descriptor2, 2, w1Var, null);
            String str7 = (String) cVarB.n(descriptor2, 3, w1Var, null);
            Integer num2 = (Integer) cVarB.n(descriptor2, 4, j0.f8162a, null);
            str = strS2;
            fontStyle = (FontStyle) cVarB.n(descriptor2, 5, FontStyleDeserializer.INSTANCE, null);
            str4 = str7;
            num = num2;
            str3 = str6;
            str2 = str5;
            i10 = 63;
        } else {
            boolean z10 = true;
            int i11 = 0;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            Integer num3 = null;
            FontStyle fontStyle2 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z10 = false;
                        continue;
                    case 0:
                        strS = cVarB.s(descriptor2, 0);
                        i11 |= 1;
                        continue;
                    case 1:
                        str8 = (String) cVarB.n(descriptor2, 1, w1.f8244a, str8);
                        i11 |= 2;
                        break;
                    case 2:
                        str9 = (String) cVarB.n(descriptor2, 2, w1.f8244a, str9);
                        i11 |= 4;
                        break;
                    case 3:
                        str10 = (String) cVarB.n(descriptor2, 3, w1.f8244a, str10);
                        i11 |= 8;
                        break;
                    case 4:
                        num3 = (Integer) cVarB.n(descriptor2, 4, j0.f8162a, num3);
                        i11 |= 16;
                        break;
                    case 5:
                        fontStyle2 = (FontStyle) cVarB.n(descriptor2, 5, FontStyleDeserializer.INSTANCE, fontStyle2);
                        i11 |= 32;
                        break;
                    default:
                        throw new zg.m(iW);
                }
            }
            i10 = i11;
            str = strS;
            str2 = str8;
            str3 = str9;
            str4 = str10;
            num = num3;
            fontStyle = fontStyle2;
        }
        cVarB.c(descriptor2);
        return new UiConfig.AppConfig.FontsConfig.FontInfo.Name(i10, str, str2, str3, str4, num, fontStyle, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(ch.f encoder, UiConfig.AppConfig.FontsConfig.FontInfo.Name value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        ch.d dVarB = encoder.b(descriptor2);
        UiConfig.AppConfig.FontsConfig.FontInfo.Name.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public zg.b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
