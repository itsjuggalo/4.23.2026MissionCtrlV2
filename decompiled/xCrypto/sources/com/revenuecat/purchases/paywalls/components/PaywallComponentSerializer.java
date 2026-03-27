package com.revenuecat.purchases.paywalls.components;

import F3.b;
import H3.e;
import H3.h;
import I3.f;
import K3.a;
import K3.g;
import K3.i;
import K3.u;
import K3.w;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class PaywallComponentSerializer implements b {
    private final e descriptor = h.b("PaywallComponent", new e[0], PaywallComponentSerializer$descriptor$1.INSTANCE);

    @Override // F3.b, F3.h, F3.a
    public e getDescriptor() {
        return this.descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PaywallComponent value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // F3.a
    public PaywallComponent deserialize(I3.e decoder) {
        String string;
        w wVarO;
        r.f(decoder, "decoder");
        g gVar = decoder instanceof g ? (g) decoder : null;
        if (gVar == null) {
            throw new F3.g("Can only deserialize PaywallComponent from JSON, got: " + G.b(decoder.getClass()));
        }
        u uVarN = i.n(gVar.k());
        K3.h hVar = (K3.h) uVarN.get("type");
        String strF = (hVar == null || (wVarO = i.o(hVar)) == null) ? null : wVarO.f();
        if (strF != null) {
            switch (strF.hashCode()) {
                case -2076650431:
                    if (strF.equals("timeline")) {
                        a aVarB = gVar.b();
                        String string2 = uVarN.toString();
                        aVarB.a();
                        return (PaywallComponent) aVarB.d(TimelineComponent.Companion.serializer(), string2);
                    }
                    break;
                case -1896978765:
                    if (strF.equals("tab_control")) {
                        a aVarB2 = gVar.b();
                        String string3 = uVarN.toString();
                        aVarB2.a();
                        return (PaywallComponent) aVarB2.d(TabControlComponent.INSTANCE.serializer(), string3);
                    }
                    break;
                case -1822017359:
                    if (strF.equals("sticky_footer")) {
                        a aVarB3 = gVar.b();
                        String string4 = uVarN.toString();
                        aVarB3.a();
                        return (PaywallComponent) aVarB3.d(StickyFooterComponent.Companion.serializer(), string4);
                    }
                    break;
                case -1391809488:
                    if (strF.equals("purchase_button")) {
                        a aVarB4 = gVar.b();
                        String string5 = uVarN.toString();
                        aVarB4.a();
                        return (PaywallComponent) aVarB4.d(PurchaseButtonComponent.Companion.serializer(), string5);
                    }
                    break;
                case -1377687758:
                    if (strF.equals("button")) {
                        a aVarB5 = gVar.b();
                        String string6 = uVarN.toString();
                        aVarB5.a();
                        return (PaywallComponent) aVarB5.d(ButtonComponent.Companion.serializer(), string6);
                    }
                    break;
                case -807062458:
                    if (strF.equals("package")) {
                        a aVarB6 = gVar.b();
                        String string7 = uVarN.toString();
                        aVarB6.a();
                        return (PaywallComponent) aVarB6.d(PackageComponent.Companion.serializer(), string7);
                    }
                    break;
                case 2908512:
                    if (strF.equals("carousel")) {
                        a aVarB7 = gVar.b();
                        String string8 = uVarN.toString();
                        aVarB7.a();
                        return (PaywallComponent) aVarB7.d(CarouselComponent.Companion.serializer(), string8);
                    }
                    break;
                case 3226745:
                    if (strF.equals("icon")) {
                        a aVarB8 = gVar.b();
                        String string9 = uVarN.toString();
                        aVarB8.a();
                        return (PaywallComponent) aVarB8.d(IconComponent.Companion.serializer(), string9);
                    }
                    break;
                case 3552126:
                    if (strF.equals("tabs")) {
                        a aVarB9 = gVar.b();
                        String string10 = uVarN.toString();
                        aVarB9.a();
                        return (PaywallComponent) aVarB9.d(TabsComponent.Companion.serializer(), string10);
                    }
                    break;
                case 3556653:
                    if (strF.equals("text")) {
                        a aVarB10 = gVar.b();
                        String string11 = uVarN.toString();
                        aVarB10.a();
                        return (PaywallComponent) aVarB10.d(TextComponent.Companion.serializer(), string11);
                    }
                    break;
                case 100313435:
                    if (strF.equals("image")) {
                        a aVarB11 = gVar.b();
                        String string12 = uVarN.toString();
                        aVarB11.a();
                        return (PaywallComponent) aVarB11.d(ImageComponent.Companion.serializer(), string12);
                    }
                    break;
                case 109757064:
                    if (strF.equals("stack")) {
                        a aVarB12 = gVar.b();
                        String string13 = uVarN.toString();
                        aVarB12.a();
                        return (PaywallComponent) aVarB12.d(StackComponent.Companion.serializer(), string13);
                    }
                    break;
                case 318201406:
                    if (strF.equals("tab_control_button")) {
                        a aVarB13 = gVar.b();
                        String string14 = uVarN.toString();
                        aVarB13.a();
                        return (PaywallComponent) aVarB13.d(TabControlButtonComponent.Companion.serializer(), string14);
                    }
                    break;
                case 827585120:
                    if (strF.equals("tab_control_toggle")) {
                        a aVarB14 = gVar.b();
                        String string15 = uVarN.toString();
                        aVarB14.a();
                        return (PaywallComponent) aVarB14.d(TabControlToggleComponent.Companion.serializer(), string15);
                    }
                    break;
            }
        }
        K3.h hVar2 = (K3.h) uVarN.get("fallback");
        if (hVar2 != null) {
            u uVar = hVar2 instanceof u ? (u) hVar2 : null;
            if (uVar != null && (string = uVar.toString()) != null) {
                a aVarB15 = gVar.b();
                aVarB15.a();
                PaywallComponent paywallComponent = (PaywallComponent) aVarB15.d(PaywallComponent.Companion.serializer(), string);
                if (paywallComponent != null) {
                    return paywallComponent;
                }
            }
        }
        throw new F3.g("No fallback provided for unknown type: " + strF);
    }
}
