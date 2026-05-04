package com.revenuecat.purchases.paywalls.components;

import bh.e;
import bh.k;
import ch.f;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import eh.c0;
import eh.e0;
import eh.h;
import eh.i;
import kotlin.Metadata;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import zg.b;
import zg.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PaywallComponentSerializer;", "Lzg/b;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "<init>", "()V", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;)V", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "Lbh/e;", "descriptor", "Lbh/e;", "getDescriptor", "()Lbh/e;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallComponentSerializer implements b {
    private final e descriptor = k.c("PaywallComponent", new e[0], PaywallComponentSerializer$descriptor$1.INSTANCE);

    @Override // zg.b, zg.k, zg.a
    public e getDescriptor() {
        return this.descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, PaywallComponent value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // zg.a
    public PaywallComponent deserialize(ch.e decoder) {
        String string;
        e0 e0VarO;
        t.f(decoder, "decoder");
        h hVar = decoder instanceof h ? (h) decoder : null;
        if (hVar == null) {
            throw new j("Can only deserialize PaywallComponent from JSON, got: " + n0.b(decoder.getClass()));
        }
        c0 c0VarN = eh.j.n(hVar.i());
        i iVar = (i) c0VarN.get("type");
        String strA = (iVar == null || (e0VarO = eh.j.o(iVar)) == null) ? null : e0VarO.a();
        if (strA != null) {
            switch (strA.hashCode()) {
                case -2076650431:
                    if (strA.equals("timeline")) {
                        eh.b bVarD = hVar.d();
                        String string2 = c0VarN.toString();
                        bVarD.a();
                        return (PaywallComponent) bVarD.d(TimelineComponent.INSTANCE.serializer(), string2);
                    }
                    break;
                case -1896978765:
                    if (strA.equals("tab_control")) {
                        eh.b bVarD2 = hVar.d();
                        String string3 = c0VarN.toString();
                        bVarD2.a();
                        return (PaywallComponent) bVarD2.d(TabControlComponent.INSTANCE.serializer(), string3);
                    }
                    break;
                case -1822017359:
                    if (strA.equals("sticky_footer")) {
                        eh.b bVarD3 = hVar.d();
                        String string4 = c0VarN.toString();
                        bVarD3.a();
                        return (PaywallComponent) bVarD3.d(StickyFooterComponent.INSTANCE.serializer(), string4);
                    }
                    break;
                case -1391809488:
                    if (strA.equals("purchase_button")) {
                        eh.b bVarD4 = hVar.d();
                        String string5 = c0VarN.toString();
                        bVarD4.a();
                        return (PaywallComponent) bVarD4.d(PurchaseButtonComponent.INSTANCE.serializer(), string5);
                    }
                    break;
                case -1377687758:
                    if (strA.equals("button")) {
                        eh.b bVarD5 = hVar.d();
                        String string6 = c0VarN.toString();
                        bVarD5.a();
                        return (PaywallComponent) bVarD5.d(ButtonComponent.INSTANCE.serializer(), string6);
                    }
                    break;
                case -807062458:
                    if (strA.equals("package")) {
                        eh.b bVarD6 = hVar.d();
                        String string7 = c0VarN.toString();
                        bVarD6.a();
                        return (PaywallComponent) bVarD6.d(PackageComponent.INSTANCE.serializer(), string7);
                    }
                    break;
                case 2908512:
                    if (strA.equals("carousel")) {
                        eh.b bVarD7 = hVar.d();
                        String string8 = c0VarN.toString();
                        bVarD7.a();
                        return (PaywallComponent) bVarD7.d(CarouselComponent.INSTANCE.serializer(), string8);
                    }
                    break;
                case 3226745:
                    if (strA.equals("icon")) {
                        eh.b bVarD8 = hVar.d();
                        String string9 = c0VarN.toString();
                        bVarD8.a();
                        return (PaywallComponent) bVarD8.d(IconComponent.INSTANCE.serializer(), string9);
                    }
                    break;
                case 3552126:
                    if (strA.equals("tabs")) {
                        eh.b bVarD9 = hVar.d();
                        String string10 = c0VarN.toString();
                        bVarD9.a();
                        return (PaywallComponent) bVarD9.d(TabsComponent.INSTANCE.serializer(), string10);
                    }
                    break;
                case 3556653:
                    if (strA.equals("text")) {
                        eh.b bVarD10 = hVar.d();
                        String string11 = c0VarN.toString();
                        bVarD10.a();
                        return (PaywallComponent) bVarD10.d(TextComponent.INSTANCE.serializer(), string11);
                    }
                    break;
                case 100313435:
                    if (strA.equals("image")) {
                        eh.b bVarD11 = hVar.d();
                        String string12 = c0VarN.toString();
                        bVarD11.a();
                        return (PaywallComponent) bVarD11.d(ImageComponent.INSTANCE.serializer(), string12);
                    }
                    break;
                case 109757064:
                    if (strA.equals("stack")) {
                        eh.b bVarD12 = hVar.d();
                        String string13 = c0VarN.toString();
                        bVarD12.a();
                        return (PaywallComponent) bVarD12.d(StackComponent.INSTANCE.serializer(), string13);
                    }
                    break;
                case 112202875:
                    if (strA.equals("video")) {
                        eh.b bVarD13 = hVar.d();
                        String string14 = c0VarN.toString();
                        bVarD13.a();
                        return (PaywallComponent) bVarD13.d(VideoComponent.INSTANCE.serializer(), string14);
                    }
                    break;
                case 318201406:
                    if (strA.equals("tab_control_button")) {
                        eh.b bVarD14 = hVar.d();
                        String string15 = c0VarN.toString();
                        bVarD14.a();
                        return (PaywallComponent) bVarD14.d(TabControlButtonComponent.INSTANCE.serializer(), string15);
                    }
                    break;
                case 827585120:
                    if (strA.equals("tab_control_toggle")) {
                        eh.b bVarD15 = hVar.d();
                        String string16 = c0VarN.toString();
                        bVarD15.a();
                        return (PaywallComponent) bVarD15.d(TabControlToggleComponent.INSTANCE.serializer(), string16);
                    }
                    break;
                case 1352226353:
                    if (strA.equals("countdown")) {
                        eh.b bVarD16 = hVar.d();
                        String string17 = c0VarN.toString();
                        bVarD16.a();
                        return (PaywallComponent) bVarD16.d(CountdownComponent.INSTANCE.serializer(), string17);
                    }
                    break;
            }
        }
        i iVar2 = (i) c0VarN.get("fallback");
        if (iVar2 != null) {
            c0 c0Var = iVar2 instanceof c0 ? (c0) iVar2 : null;
            if (c0Var != null && (string = c0Var.toString()) != null) {
                eh.b bVarD17 = hVar.d();
                bVarD17.a();
                PaywallComponent paywallComponent = (PaywallComponent) bVarD17.d(PaywallComponent.INSTANCE.serializer(), string);
                if (paywallComponent != null) {
                    return paywallComponent;
                }
            }
        }
        throw new j("No fallback provided for unknown type: " + strA);
    }
}
