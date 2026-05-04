package com.revenuecat.purchases.paywalls;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.paywalls.PaywallData;
import dh.e0;
import dh.j1;
import dh.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/PaywallData.Configuration.Colors.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallData$Configuration$Colors$$serializer implements e0 {
    public static final PaywallData$Configuration$Colors$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        PaywallData$Configuration$Colors$$serializer paywallData$Configuration$Colors$$serializer = new PaywallData$Configuration$Colors$$serializer();
        INSTANCE = paywallData$Configuration$Colors$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.PaywallData.Configuration.Colors", paywallData$Configuration$Colors$$serializer, 15);
        j1Var.g("background", false);
        j1Var.g("text_1", false);
        j1Var.g("text_2", true);
        j1Var.g("text_3", true);
        j1Var.g("call_to_action_background", false);
        j1Var.g("call_to_action_foreground", false);
        j1Var.g("call_to_action_secondary_background", true);
        j1Var.g("accent_1", true);
        j1Var.g("accent_2", true);
        j1Var.g("accent_3", true);
        j1Var.g("close_button", true);
        j1Var.g("tier_control_background", true);
        j1Var.g("tier_control_foreground", true);
        j1Var.g("tier_control_selected_background", true);
        j1Var.g("tier_control_selected_foreground", true);
        descriptor = j1Var;
    }

    private PaywallData$Configuration$Colors$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        PaywallColor.Serializer serializer = PaywallColor.Serializer.INSTANCE;
        return new b[]{serializer, serializer, a.p(serializer), a.p(serializer), serializer, serializer, a.p(serializer), a.p(serializer), a.p(serializer), a.p(serializer), a.p(serializer), a.p(serializer), a.p(serializer), a.p(serializer), a.p(serializer)};
    }

    @Override // zg.a
    public PaywallData.Configuration.Colors deserialize(e decoder) {
        PaywallColor paywallColor;
        PaywallColor paywallColor2;
        PaywallColor paywallColor3;
        PaywallColor paywallColor4;
        PaywallColor paywallColor5;
        PaywallColor paywallColor6;
        PaywallColor paywallColor7;
        PaywallColor paywallColor8;
        PaywallColor paywallColor9;
        PaywallColor paywallColor10;
        PaywallColor paywallColor11;
        PaywallColor paywallColor12;
        PaywallColor paywallColor13;
        PaywallColor paywallColor14;
        PaywallColor paywallColor15;
        int i10;
        PaywallColor paywallColor16;
        PaywallColor paywallColor17;
        PaywallColor paywallColor18;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        PaywallColor paywallColor19 = null;
        if (cVarB.z()) {
            PaywallColor.Serializer serializer = PaywallColor.Serializer.INSTANCE;
            PaywallColor paywallColor20 = (PaywallColor) cVarB.h(descriptor2, 0, serializer, null);
            PaywallColor paywallColor21 = (PaywallColor) cVarB.h(descriptor2, 1, serializer, null);
            PaywallColor paywallColor22 = (PaywallColor) cVarB.n(descriptor2, 2, serializer, null);
            PaywallColor paywallColor23 = (PaywallColor) cVarB.n(descriptor2, 3, serializer, null);
            PaywallColor paywallColor24 = (PaywallColor) cVarB.h(descriptor2, 4, serializer, null);
            PaywallColor paywallColor25 = (PaywallColor) cVarB.h(descriptor2, 5, serializer, null);
            PaywallColor paywallColor26 = (PaywallColor) cVarB.n(descriptor2, 6, serializer, null);
            PaywallColor paywallColor27 = (PaywallColor) cVarB.n(descriptor2, 7, serializer, null);
            PaywallColor paywallColor28 = (PaywallColor) cVarB.n(descriptor2, 8, serializer, null);
            PaywallColor paywallColor29 = (PaywallColor) cVarB.n(descriptor2, 9, serializer, null);
            PaywallColor paywallColor30 = (PaywallColor) cVarB.n(descriptor2, 10, serializer, null);
            PaywallColor paywallColor31 = (PaywallColor) cVarB.n(descriptor2, 11, serializer, null);
            paywallColor = paywallColor21;
            PaywallColor paywallColor32 = (PaywallColor) cVarB.n(descriptor2, 12, serializer, null);
            PaywallColor paywallColor33 = (PaywallColor) cVarB.n(descriptor2, 13, serializer, null);
            paywallColor15 = (PaywallColor) cVarB.n(descriptor2, 14, serializer, null);
            i10 = 32767;
            paywallColor2 = paywallColor20;
            paywallColor5 = paywallColor31;
            paywallColor6 = paywallColor30;
            paywallColor11 = paywallColor29;
            paywallColor8 = paywallColor27;
            paywallColor9 = paywallColor26;
            paywallColor12 = paywallColor25;
            paywallColor13 = paywallColor23;
            paywallColor7 = paywallColor28;
            paywallColor10 = paywallColor24;
            paywallColor14 = paywallColor22;
            paywallColor3 = paywallColor33;
            paywallColor4 = paywallColor32;
        } else {
            boolean z10 = true;
            int i11 = 0;
            PaywallColor paywallColor34 = null;
            PaywallColor paywallColor35 = null;
            PaywallColor paywallColor36 = null;
            PaywallColor paywallColor37 = null;
            PaywallColor paywallColor38 = null;
            PaywallColor paywallColor39 = null;
            PaywallColor paywallColor40 = null;
            PaywallColor paywallColor41 = null;
            PaywallColor paywallColor42 = null;
            PaywallColor paywallColor43 = null;
            PaywallColor paywallColor44 = null;
            PaywallColor paywallColor45 = null;
            PaywallColor paywallColor46 = null;
            PaywallColor paywallColor47 = null;
            while (z10) {
                PaywallColor paywallColor48 = paywallColor34;
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z10 = false;
                        paywallColor34 = paywallColor48;
                        paywallColor35 = paywallColor35;
                        i11 = i11;
                        break;
                    case 0:
                        paywallColor17 = paywallColor35;
                        paywallColor18 = paywallColor48;
                        paywallColor46 = (PaywallColor) cVarB.h(descriptor2, 0, PaywallColor.Serializer.INSTANCE, paywallColor46);
                        i11 |= 1;
                        paywallColor47 = paywallColor47;
                        paywallColor34 = paywallColor18;
                        paywallColor35 = paywallColor17;
                        break;
                    case 1:
                        paywallColor17 = paywallColor35;
                        paywallColor18 = paywallColor48;
                        paywallColor47 = (PaywallColor) cVarB.h(descriptor2, 1, PaywallColor.Serializer.INSTANCE, paywallColor47);
                        i11 |= 2;
                        paywallColor34 = paywallColor18;
                        paywallColor35 = paywallColor17;
                        break;
                    case 2:
                        paywallColor17 = paywallColor35;
                        paywallColor34 = (PaywallColor) cVarB.n(descriptor2, 2, PaywallColor.Serializer.INSTANCE, paywallColor48);
                        i11 |= 4;
                        paywallColor35 = paywallColor17;
                        break;
                    case 3:
                        paywallColor45 = (PaywallColor) cVarB.n(descriptor2, 3, PaywallColor.Serializer.INSTANCE, paywallColor45);
                        i11 |= 8;
                        paywallColor34 = paywallColor48;
                        break;
                    case 4:
                        paywallColor16 = paywallColor45;
                        paywallColor42 = (PaywallColor) cVarB.h(descriptor2, 4, PaywallColor.Serializer.INSTANCE, paywallColor42);
                        i11 |= 16;
                        paywallColor34 = paywallColor48;
                        paywallColor45 = paywallColor16;
                        break;
                    case 5:
                        paywallColor16 = paywallColor45;
                        paywallColor44 = (PaywallColor) cVarB.h(descriptor2, 5, PaywallColor.Serializer.INSTANCE, paywallColor44);
                        i11 |= 32;
                        paywallColor34 = paywallColor48;
                        paywallColor45 = paywallColor16;
                        break;
                    case 6:
                        paywallColor16 = paywallColor45;
                        paywallColor41 = (PaywallColor) cVarB.n(descriptor2, 6, PaywallColor.Serializer.INSTANCE, paywallColor41);
                        i11 |= 64;
                        paywallColor34 = paywallColor48;
                        paywallColor45 = paywallColor16;
                        break;
                    case 7:
                        paywallColor16 = paywallColor45;
                        paywallColor40 = (PaywallColor) cVarB.n(descriptor2, 7, PaywallColor.Serializer.INSTANCE, paywallColor40);
                        i11 |= 128;
                        paywallColor34 = paywallColor48;
                        paywallColor45 = paywallColor16;
                        break;
                    case 8:
                        paywallColor16 = paywallColor45;
                        paywallColor39 = (PaywallColor) cVarB.n(descriptor2, 8, PaywallColor.Serializer.INSTANCE, paywallColor39);
                        i11 |= 256;
                        paywallColor34 = paywallColor48;
                        paywallColor45 = paywallColor16;
                        break;
                    case 9:
                        paywallColor16 = paywallColor45;
                        paywallColor43 = (PaywallColor) cVarB.n(descriptor2, 9, PaywallColor.Serializer.INSTANCE, paywallColor43);
                        i11 |= 512;
                        paywallColor34 = paywallColor48;
                        paywallColor45 = paywallColor16;
                        break;
                    case 10:
                        paywallColor16 = paywallColor45;
                        paywallColor38 = (PaywallColor) cVarB.n(descriptor2, 10, PaywallColor.Serializer.INSTANCE, paywallColor38);
                        i11 |= 1024;
                        paywallColor34 = paywallColor48;
                        paywallColor45 = paywallColor16;
                        break;
                    case 11:
                        paywallColor16 = paywallColor45;
                        paywallColor37 = (PaywallColor) cVarB.n(descriptor2, 11, PaywallColor.Serializer.INSTANCE, paywallColor37);
                        i11 |= 2048;
                        paywallColor34 = paywallColor48;
                        paywallColor45 = paywallColor16;
                        break;
                    case 12:
                        paywallColor16 = paywallColor45;
                        paywallColor36 = (PaywallColor) cVarB.n(descriptor2, 12, PaywallColor.Serializer.INSTANCE, paywallColor36);
                        i11 |= 4096;
                        paywallColor34 = paywallColor48;
                        paywallColor45 = paywallColor16;
                        break;
                    case 13:
                        paywallColor16 = paywallColor45;
                        paywallColor19 = (PaywallColor) cVarB.n(descriptor2, 13, PaywallColor.Serializer.INSTANCE, paywallColor19);
                        i11 |= 8192;
                        paywallColor34 = paywallColor48;
                        paywallColor45 = paywallColor16;
                        break;
                    case 14:
                        paywallColor16 = paywallColor45;
                        paywallColor35 = (PaywallColor) cVarB.n(descriptor2, 14, PaywallColor.Serializer.INSTANCE, paywallColor35);
                        i11 |= 16384;
                        paywallColor34 = paywallColor48;
                        paywallColor45 = paywallColor16;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            paywallColor = paywallColor47;
            paywallColor2 = paywallColor46;
            paywallColor3 = paywallColor19;
            paywallColor4 = paywallColor36;
            paywallColor5 = paywallColor37;
            paywallColor6 = paywallColor38;
            paywallColor7 = paywallColor39;
            paywallColor8 = paywallColor40;
            paywallColor9 = paywallColor41;
            paywallColor10 = paywallColor42;
            paywallColor11 = paywallColor43;
            paywallColor12 = paywallColor44;
            paywallColor13 = paywallColor45;
            paywallColor14 = paywallColor34;
            paywallColor15 = paywallColor35;
            i10 = i11;
        }
        PaywallColor paywallColor49 = paywallColor;
        cVarB.c(descriptor2);
        return new PaywallData.Configuration.Colors(i10, paywallColor2, paywallColor49, paywallColor14, paywallColor13, paywallColor10, paywallColor12, paywallColor9, paywallColor8, paywallColor7, paywallColor11, paywallColor6, paywallColor5, paywallColor4, paywallColor3, paywallColor15, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, PaywallData.Configuration.Colors value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        PaywallData.Configuration.Colors.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
