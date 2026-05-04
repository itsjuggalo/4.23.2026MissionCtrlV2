package com.revenuecat.purchases.paywalls.components;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import dh.e0;
import dh.h;
import dh.j0;
import dh.j1;
import dh.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/PartialTimelineComponent.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/PartialTimelineComponent;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/PartialTimelineComponent;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/PartialTimelineComponent;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PartialTimelineComponent$$serializer implements e0 {
    public static final PartialTimelineComponent$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        PartialTimelineComponent$$serializer partialTimelineComponent$$serializer = new PartialTimelineComponent$$serializer();
        INSTANCE = partialTimelineComponent$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.PartialTimelineComponent", partialTimelineComponent$$serializer, 8);
        j1Var.g("visible", true);
        j1Var.g("item_spacing", true);
        j1Var.g("text_spacing", true);
        j1Var.g("column_gutter", true);
        j1Var.g("icon_alignment", true);
        j1Var.g("size", true);
        j1Var.g("padding", true);
        j1Var.g("margin", true);
        descriptor = j1Var;
    }

    private PartialTimelineComponent$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b bVarP = a.p(h.f8149a);
        j0 j0Var = j0.f8162a;
        b bVarP2 = a.p(j0Var);
        b bVarP3 = a.p(j0Var);
        b bVarP4 = a.p(j0Var);
        b bVarP5 = a.p(TimelineIconAlignmentDeserializer.INSTANCE);
        b bVarP6 = a.p(Size$$serializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{bVarP, bVarP2, bVarP3, bVarP4, bVarP5, bVarP6, a.p(padding$$serializer), a.p(padding$$serializer)};
    }

    @Override // zg.a
    public PartialTimelineComponent deserialize(e decoder) {
        int i10;
        Padding padding;
        Padding padding2;
        Size size;
        Boolean bool;
        Integer num;
        Integer num2;
        Integer num3;
        TimelineComponent.IconAlignment iconAlignment;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        int i11 = 7;
        Boolean bool2 = null;
        if (cVarB.z()) {
            Boolean bool3 = (Boolean) cVarB.n(descriptor2, 0, h.f8149a, null);
            j0 j0Var = j0.f8162a;
            Integer num4 = (Integer) cVarB.n(descriptor2, 1, j0Var, null);
            Integer num5 = (Integer) cVarB.n(descriptor2, 2, j0Var, null);
            Integer num6 = (Integer) cVarB.n(descriptor2, 3, j0Var, null);
            TimelineComponent.IconAlignment iconAlignment2 = (TimelineComponent.IconAlignment) cVarB.n(descriptor2, 4, TimelineIconAlignmentDeserializer.INSTANCE, null);
            Size size2 = (Size) cVarB.n(descriptor2, 5, Size$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) cVarB.n(descriptor2, 6, padding$$serializer, null);
            bool = bool3;
            padding = (Padding) cVarB.n(descriptor2, 7, padding$$serializer, null);
            padding2 = padding3;
            size = size2;
            num3 = num6;
            iconAlignment = iconAlignment2;
            num2 = num5;
            num = num4;
            i10 = 255;
        } else {
            boolean z10 = true;
            int i12 = 0;
            Padding padding4 = null;
            Padding padding5 = null;
            Size size3 = null;
            Integer num7 = null;
            Integer num8 = null;
            Integer num9 = null;
            TimelineComponent.IconAlignment iconAlignment3 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z10 = false;
                        i11 = 7;
                        break;
                    case 0:
                        bool2 = (Boolean) cVarB.n(descriptor2, 0, h.f8149a, bool2);
                        i12 |= 1;
                        i11 = 7;
                        break;
                    case 1:
                        num7 = (Integer) cVarB.n(descriptor2, 1, j0.f8162a, num7);
                        i12 |= 2;
                        i11 = 7;
                        break;
                    case 2:
                        num8 = (Integer) cVarB.n(descriptor2, 2, j0.f8162a, num8);
                        i12 |= 4;
                        i11 = 7;
                        break;
                    case 3:
                        num9 = (Integer) cVarB.n(descriptor2, 3, j0.f8162a, num9);
                        i12 |= 8;
                        i11 = 7;
                        break;
                    case 4:
                        iconAlignment3 = (TimelineComponent.IconAlignment) cVarB.n(descriptor2, 4, TimelineIconAlignmentDeserializer.INSTANCE, iconAlignment3);
                        i12 |= 16;
                        break;
                    case 5:
                        size3 = (Size) cVarB.n(descriptor2, 5, Size$$serializer.INSTANCE, size3);
                        i12 |= 32;
                        break;
                    case 6:
                        padding5 = (Padding) cVarB.n(descriptor2, 6, Padding$$serializer.INSTANCE, padding5);
                        i12 |= 64;
                        break;
                    case 7:
                        padding4 = (Padding) cVarB.n(descriptor2, i11, Padding$$serializer.INSTANCE, padding4);
                        i12 |= 128;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            i10 = i12;
            padding = padding4;
            padding2 = padding5;
            size = size3;
            bool = bool2;
            num = num7;
            num2 = num8;
            num3 = num9;
            iconAlignment = iconAlignment3;
        }
        cVarB.c(descriptor2);
        return new PartialTimelineComponent(i10, bool, num, num2, num3, iconAlignment, size, padding2, padding, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, PartialTimelineComponent value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        PartialTimelineComponent.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
