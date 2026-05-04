package com.revenuecat.purchases.paywalls.components;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.google.firebase.analytics.FirebaseAnalytics;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/TimelineComponent.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/TimelineComponent;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/TimelineComponent;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/TimelineComponent;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TimelineComponent$$serializer implements e0 {
    public static final TimelineComponent$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        TimelineComponent$$serializer timelineComponent$$serializer = new TimelineComponent$$serializer();
        INSTANCE = timelineComponent$$serializer;
        j1 j1Var = new j1("timeline", timelineComponent$$serializer, 10);
        j1Var.g("item_spacing", false);
        j1Var.g("text_spacing", false);
        j1Var.g("column_gutter", false);
        j1Var.g("icon_alignment", false);
        j1Var.g("visible", true);
        j1Var.g("size", true);
        j1Var.g("padding", true);
        j1Var.g("margin", true);
        j1Var.g(FirebaseAnalytics.Param.ITEMS, true);
        j1Var.g("overrides", true);
        descriptor = j1Var;
    }

    private TimelineComponent$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b[] bVarArr = TimelineComponent.$childSerializers;
        b bVarP = a.p(h.f8149a);
        b bVar = bVarArr[8];
        b bVar2 = bVarArr[9];
        j0 j0Var = j0.f8162a;
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{j0Var, j0Var, j0Var, TimelineIconAlignmentDeserializer.INSTANCE, bVarP, Size$$serializer.INSTANCE, padding$$serializer, padding$$serializer, bVar, bVar2};
    }

    @Override // zg.a
    public TimelineComponent deserialize(e decoder) {
        int iC;
        List list;
        List list2;
        Padding padding;
        Padding padding2;
        Size size;
        Boolean bool;
        TimelineComponent.IconAlignment iconAlignment;
        int i10;
        int i11;
        int i12;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        b[] bVarArr = TimelineComponent.$childSerializers;
        int i13 = 9;
        if (cVarB.z()) {
            iC = cVarB.C(descriptor2, 0);
            int iC2 = cVarB.C(descriptor2, 1);
            int iC3 = cVarB.C(descriptor2, 2);
            TimelineComponent.IconAlignment iconAlignment2 = (TimelineComponent.IconAlignment) cVarB.h(descriptor2, 3, TimelineIconAlignmentDeserializer.INSTANCE, null);
            Boolean bool2 = (Boolean) cVarB.n(descriptor2, 4, h.f8149a, null);
            Size size2 = (Size) cVarB.h(descriptor2, 5, Size$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) cVarB.h(descriptor2, 6, padding$$serializer, null);
            Padding padding4 = (Padding) cVarB.h(descriptor2, 7, padding$$serializer, null);
            List list3 = (List) cVarB.h(descriptor2, 8, bVarArr[8], null);
            list = (List) cVarB.h(descriptor2, 9, bVarArr[9], null);
            padding2 = padding4;
            padding = padding3;
            size = size2;
            iconAlignment = iconAlignment2;
            bool = bool2;
            i10 = iC3;
            i11 = 1023;
            list2 = list3;
            i12 = iC2;
        } else {
            boolean z10 = true;
            iC = 0;
            int i14 = 0;
            int iC4 = 0;
            List list4 = null;
            List list5 = null;
            Padding padding5 = null;
            Padding padding6 = null;
            Size size3 = null;
            Boolean bool3 = null;
            int iC5 = 0;
            TimelineComponent.IconAlignment iconAlignment3 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z10 = false;
                        break;
                    case 0:
                        i14 |= 1;
                        iC = cVarB.C(descriptor2, 0);
                        i13 = 9;
                        break;
                    case 1:
                        iC4 = cVarB.C(descriptor2, 1);
                        i14 |= 2;
                        i13 = 9;
                        break;
                    case 2:
                        iC5 = cVarB.C(descriptor2, 2);
                        i14 |= 4;
                        i13 = 9;
                        break;
                    case 3:
                        iconAlignment3 = (TimelineComponent.IconAlignment) cVarB.h(descriptor2, 3, TimelineIconAlignmentDeserializer.INSTANCE, iconAlignment3);
                        i14 |= 8;
                        i13 = 9;
                        break;
                    case 4:
                        bool3 = (Boolean) cVarB.n(descriptor2, 4, h.f8149a, bool3);
                        i14 |= 16;
                        i13 = 9;
                        break;
                    case 5:
                        size3 = (Size) cVarB.h(descriptor2, 5, Size$$serializer.INSTANCE, size3);
                        i14 |= 32;
                        i13 = 9;
                        break;
                    case 6:
                        padding5 = (Padding) cVarB.h(descriptor2, 6, Padding$$serializer.INSTANCE, padding5);
                        i14 |= 64;
                        i13 = 9;
                        break;
                    case 7:
                        padding6 = (Padding) cVarB.h(descriptor2, 7, Padding$$serializer.INSTANCE, padding6);
                        i14 |= 128;
                        i13 = 9;
                        break;
                    case 8:
                        list5 = (List) cVarB.h(descriptor2, 8, bVarArr[8], list5);
                        i14 |= 256;
                        break;
                    case 9:
                        list4 = (List) cVarB.h(descriptor2, i13, bVarArr[i13], list4);
                        i14 |= 512;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            list = list4;
            list2 = list5;
            padding = padding5;
            padding2 = padding6;
            size = size3;
            bool = bool3;
            iconAlignment = iconAlignment3;
            i10 = iC5;
            i11 = i14;
            i12 = iC4;
        }
        int i15 = iC;
        cVarB.c(descriptor2);
        return new TimelineComponent(i11, i15, i12, i10, iconAlignment, bool, size, padding, padding2, list2, list, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, TimelineComponent value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        TimelineComponent.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
