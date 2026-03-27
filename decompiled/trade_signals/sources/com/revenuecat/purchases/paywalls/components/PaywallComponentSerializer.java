package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import k7.b;
import k7.j;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.O;
import m7.e;
import m7.k;
import n7.f;
import p7.AbstractC2609b;
import p7.C;
import p7.E;
import p7.h;
import p7.i;

/* JADX INFO: loaded from: classes.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PaywallComponentSerializer;", "Lk7/b;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "<init>", "()V", "Ln7/f;", "encoder", "value", "Lo5/H;", "serialize", "(Ln7/f;Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;)V", "Ln7/e;", "decoder", "deserialize", "(Ln7/e;)Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "Lm7/e;", "descriptor", "Lm7/e;", "getDescriptor", "()Lm7/e;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public final class PaywallComponentSerializer implements b {
    private final e descriptor = k.c("PaywallComponent", new e[0], PaywallComponentSerializer$descriptor$1.INSTANCE);

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // k7.a
    public PaywallComponent deserialize(n7.e decoder) {
        String string;
        AbstractC2609b abstractC2609bB;
        String string2;
        b bVarSerializer;
        E eO;
        AbstractC2304t.f(decoder, "decoder");
        h hVar = decoder instanceof h ? (h) decoder : null;
        if (hVar == null) {
            throw new j("Can only deserialize PaywallComponent from JSON, got: " + O.b(decoder.getClass()));
        }
        C cN = p7.j.n(hVar.l());
        i iVar = (i) cN.get("type");
        String strA = (iVar == null || (eO = p7.j.o(iVar)) == null) ? null : eO.a();
        if (strA != null) {
            switch (strA.hashCode()) {
                case -2076650431:
                    if (strA.equals("timeline")) {
                        abstractC2609bB = hVar.b();
                        string2 = cN.toString();
                        abstractC2609bB.a();
                        bVarSerializer = TimelineComponent.INSTANCE.serializer();
                        return (PaywallComponent) abstractC2609bB.d(bVarSerializer, string2);
                    }
                    break;
                case -1896978765:
                    if (strA.equals("tab_control")) {
                        abstractC2609bB = hVar.b();
                        string2 = cN.toString();
                        abstractC2609bB.a();
                        bVarSerializer = TabControlComponent.INSTANCE.serializer();
                        return (PaywallComponent) abstractC2609bB.d(bVarSerializer, string2);
                    }
                    break;
                case -1822017359:
                    if (strA.equals("sticky_footer")) {
                        abstractC2609bB = hVar.b();
                        string2 = cN.toString();
                        abstractC2609bB.a();
                        bVarSerializer = StickyFooterComponent.INSTANCE.serializer();
                        return (PaywallComponent) abstractC2609bB.d(bVarSerializer, string2);
                    }
                    break;
                case -1391809488:
                    if (strA.equals("purchase_button")) {
                        abstractC2609bB = hVar.b();
                        string2 = cN.toString();
                        abstractC2609bB.a();
                        bVarSerializer = PurchaseButtonComponent.INSTANCE.serializer();
                        return (PaywallComponent) abstractC2609bB.d(bVarSerializer, string2);
                    }
                    break;
                case -1377687758:
                    if (strA.equals("button")) {
                        abstractC2609bB = hVar.b();
                        string2 = cN.toString();
                        abstractC2609bB.a();
                        bVarSerializer = ButtonComponent.INSTANCE.serializer();
                        return (PaywallComponent) abstractC2609bB.d(bVarSerializer, string2);
                    }
                    break;
                case -807062458:
                    if (strA.equals("package")) {
                        abstractC2609bB = hVar.b();
                        string2 = cN.toString();
                        abstractC2609bB.a();
                        bVarSerializer = PackageComponent.INSTANCE.serializer();
                        return (PaywallComponent) abstractC2609bB.d(bVarSerializer, string2);
                    }
                    break;
                case 2908512:
                    if (strA.equals("carousel")) {
                        abstractC2609bB = hVar.b();
                        string2 = cN.toString();
                        abstractC2609bB.a();
                        bVarSerializer = CarouselComponent.INSTANCE.serializer();
                        return (PaywallComponent) abstractC2609bB.d(bVarSerializer, string2);
                    }
                    break;
                case 3226745:
                    if (strA.equals("icon")) {
                        abstractC2609bB = hVar.b();
                        string2 = cN.toString();
                        abstractC2609bB.a();
                        bVarSerializer = IconComponent.INSTANCE.serializer();
                        return (PaywallComponent) abstractC2609bB.d(bVarSerializer, string2);
                    }
                    break;
                case 3552126:
                    if (strA.equals("tabs")) {
                        abstractC2609bB = hVar.b();
                        string2 = cN.toString();
                        abstractC2609bB.a();
                        bVarSerializer = TabsComponent.INSTANCE.serializer();
                        return (PaywallComponent) abstractC2609bB.d(bVarSerializer, string2);
                    }
                    break;
                case 3556653:
                    if (strA.equals("text")) {
                        abstractC2609bB = hVar.b();
                        string2 = cN.toString();
                        abstractC2609bB.a();
                        bVarSerializer = TextComponent.INSTANCE.serializer();
                        return (PaywallComponent) abstractC2609bB.d(bVarSerializer, string2);
                    }
                    break;
                case 100313435:
                    if (strA.equals("image")) {
                        abstractC2609bB = hVar.b();
                        string2 = cN.toString();
                        abstractC2609bB.a();
                        bVarSerializer = ImageComponent.INSTANCE.serializer();
                        return (PaywallComponent) abstractC2609bB.d(bVarSerializer, string2);
                    }
                    break;
                case 109757064:
                    if (strA.equals("stack")) {
                        abstractC2609bB = hVar.b();
                        string2 = cN.toString();
                        abstractC2609bB.a();
                        bVarSerializer = StackComponent.INSTANCE.serializer();
                        return (PaywallComponent) abstractC2609bB.d(bVarSerializer, string2);
                    }
                    break;
                case 318201406:
                    if (strA.equals("tab_control_button")) {
                        abstractC2609bB = hVar.b();
                        string2 = cN.toString();
                        abstractC2609bB.a();
                        bVarSerializer = TabControlButtonComponent.INSTANCE.serializer();
                        return (PaywallComponent) abstractC2609bB.d(bVarSerializer, string2);
                    }
                    break;
                case 827585120:
                    if (strA.equals("tab_control_toggle")) {
                        abstractC2609bB = hVar.b();
                        string2 = cN.toString();
                        abstractC2609bB.a();
                        bVarSerializer = TabControlToggleComponent.INSTANCE.serializer();
                        return (PaywallComponent) abstractC2609bB.d(bVarSerializer, string2);
                    }
                    break;
            }
        }
        i iVar2 = (i) cN.get("fallback");
        if (iVar2 != null) {
            C c8 = iVar2 instanceof C ? (C) iVar2 : null;
            if (c8 != null && (string = c8.toString()) != null) {
                AbstractC2609b abstractC2609bB2 = hVar.b();
                abstractC2609bB2.a();
                PaywallComponent paywallComponent = (PaywallComponent) abstractC2609bB2.d(PaywallComponent.INSTANCE.serializer(), string);
                if (paywallComponent != null) {
                    return paywallComponent;
                }
            }
        }
        throw new j("No fallback provided for unknown type: " + strA);
    }

    @Override // k7.b, k7.k, k7.a
    public e getDescriptor() {
        return this.descriptor;
    }

    @Override // k7.k
    public void serialize(f encoder, PaywallComponent value) {
        AbstractC2304t.f(encoder, "encoder");
        AbstractC2304t.f(value, "value");
    }
}
