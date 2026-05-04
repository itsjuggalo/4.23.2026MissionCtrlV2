package com.revenuecat.purchases.paywalls.components;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import dh.e0;
import dh.h;
import dh.j1;
import dh.s1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/TimelineComponent.Item.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Item;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Item;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Item;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TimelineComponent$Item$$serializer implements e0 {
    public static final TimelineComponent$Item$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        TimelineComponent$Item$$serializer timelineComponent$Item$$serializer = new TimelineComponent$Item$$serializer();
        INSTANCE = timelineComponent$Item$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.TimelineComponent.Item", timelineComponent$Item$$serializer, 6);
        j1Var.g(b.S, false);
        j1Var.g("visible", true);
        j1Var.g(b.f4549c, true);
        j1Var.g("icon", false);
        j1Var.g("connector", true);
        j1Var.g("overrides", true);
        descriptor = j1Var;
    }

    private TimelineComponent$Item$$serializer() {
    }

    @Override // dh.e0
    public zg.b[] childSerializers() {
        zg.b[] bVarArr = TimelineComponent.Item.$childSerializers;
        TextComponent$$serializer textComponent$$serializer = TextComponent$$serializer.INSTANCE;
        return new zg.b[]{textComponent$$serializer, a.p(h.f8149a), a.p(textComponent$$serializer), IconComponent$$serializer.INSTANCE, a.p(TimelineComponent$Connector$$serializer.INSTANCE), bVarArr[5]};
    }

    @Override // zg.a
    public TimelineComponent.Item deserialize(e decoder) {
        int i10;
        TextComponent textComponent;
        Boolean bool;
        TextComponent textComponent2;
        IconComponent iconComponent;
        TimelineComponent.Connector connector;
        List list;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        zg.b[] bVarArr = TimelineComponent.Item.$childSerializers;
        int i11 = 3;
        TextComponent textComponent3 = null;
        if (cVarB.z()) {
            TextComponent$$serializer textComponent$$serializer = TextComponent$$serializer.INSTANCE;
            TextComponent textComponent4 = (TextComponent) cVarB.h(descriptor2, 0, textComponent$$serializer, null);
            Boolean bool2 = (Boolean) cVarB.n(descriptor2, 1, h.f8149a, null);
            TextComponent textComponent5 = (TextComponent) cVarB.n(descriptor2, 2, textComponent$$serializer, null);
            IconComponent iconComponent2 = (IconComponent) cVarB.h(descriptor2, 3, IconComponent$$serializer.INSTANCE, null);
            TimelineComponent.Connector connector2 = (TimelineComponent.Connector) cVarB.n(descriptor2, 4, TimelineComponent$Connector$$serializer.INSTANCE, null);
            list = (List) cVarB.h(descriptor2, 5, bVarArr[5], null);
            textComponent2 = textComponent5;
            iconComponent = iconComponent2;
            connector = connector2;
            i10 = 63;
            bool = bool2;
            textComponent = textComponent4;
        } else {
            boolean z10 = true;
            int i12 = 0;
            Boolean bool3 = null;
            TextComponent textComponent6 = null;
            IconComponent iconComponent3 = null;
            TimelineComponent.Connector connector3 = null;
            List list2 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z10 = false;
                        i11 = 3;
                        break;
                    case 0:
                        textComponent3 = (TextComponent) cVarB.h(descriptor2, 0, TextComponent$$serializer.INSTANCE, textComponent3);
                        i12 |= 1;
                        i11 = 3;
                        break;
                    case 1:
                        bool3 = (Boolean) cVarB.n(descriptor2, 1, h.f8149a, bool3);
                        i12 |= 2;
                        break;
                    case 2:
                        textComponent6 = (TextComponent) cVarB.n(descriptor2, 2, TextComponent$$serializer.INSTANCE, textComponent6);
                        i12 |= 4;
                        break;
                    case 3:
                        iconComponent3 = (IconComponent) cVarB.h(descriptor2, i11, IconComponent$$serializer.INSTANCE, iconComponent3);
                        i12 |= 8;
                        break;
                    case 4:
                        connector3 = (TimelineComponent.Connector) cVarB.n(descriptor2, 4, TimelineComponent$Connector$$serializer.INSTANCE, connector3);
                        i12 |= 16;
                        break;
                    case 5:
                        list2 = (List) cVarB.h(descriptor2, 5, bVarArr[5], list2);
                        i12 |= 32;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            i10 = i12;
            textComponent = textComponent3;
            bool = bool3;
            textComponent2 = textComponent6;
            iconComponent = iconComponent3;
            connector = connector3;
            list = list2;
        }
        cVarB.c(descriptor2);
        return new TimelineComponent.Item(i10, textComponent, bool, textComponent2, iconComponent, connector, list, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, TimelineComponent.Item value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        TimelineComponent.Item.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public zg.b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
