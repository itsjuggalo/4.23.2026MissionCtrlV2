package com.revenuecat.purchases.paywalls;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.k0;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.paywalls.PaywallData;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PaywallData$Configuration$Colors$$serializer implements C {
    public static final PaywallData$Configuration$Colors$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PaywallData$Configuration$Colors$$serializer paywallData$Configuration$Colors$$serializer = new PaywallData$Configuration$Colors$$serializer();
        INSTANCE = paywallData$Configuration$Colors$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.PaywallData.Configuration.Colors", paywallData$Configuration$Colors$$serializer, 15);
        c0327b0.l("background", false);
        c0327b0.l("text_1", false);
        c0327b0.l("text_2", true);
        c0327b0.l("text_3", true);
        c0327b0.l("call_to_action_background", false);
        c0327b0.l("call_to_action_foreground", false);
        c0327b0.l("call_to_action_secondary_background", true);
        c0327b0.l("accent_1", true);
        c0327b0.l("accent_2", true);
        c0327b0.l("accent_3", true);
        c0327b0.l("close_button", true);
        c0327b0.l("tier_control_background", true);
        c0327b0.l("tier_control_foreground", true);
        c0327b0.l("tier_control_selected_background", true);
        c0327b0.l("tier_control_selected_foreground", true);
        descriptor = c0327b0;
    }

    private PaywallData$Configuration$Colors$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        PaywallColor.Serializer serializer = PaywallColor.Serializer.INSTANCE;
        return new b[]{serializer, serializer, G3.a.p(serializer), G3.a.p(serializer), serializer, serializer, G3.a.p(serializer), G3.a.p(serializer), G3.a.p(serializer), G3.a.p(serializer), G3.a.p(serializer), G3.a.p(serializer), G3.a.p(serializer), G3.a.p(serializer), G3.a.p(serializer)};
    }

    @Override // F3.a
    public PaywallData.Configuration.Colors deserialize(e decoder) {
        Object obj;
        Object obj2;
        Object obj3;
        int i4;
        Object objY;
        Object objY2;
        Object objY3;
        Object objY4;
        Object objY5;
        Object objY6;
        Object objY7;
        Object objY8;
        Object objM;
        Object objM2;
        Object objY9;
        Object objY10;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            PaywallColor.Serializer serializer = PaywallColor.Serializer.INSTANCE;
            Object objM3 = cVarD.m(descriptor2, 0, serializer, null);
            Object objM4 = cVarD.m(descriptor2, 1, serializer, null);
            objY10 = cVarD.y(descriptor2, 2, serializer, null);
            objY9 = cVarD.y(descriptor2, 3, serializer, null);
            objM2 = cVarD.m(descriptor2, 4, serializer, null);
            objM = cVarD.m(descriptor2, 5, serializer, null);
            objY8 = cVarD.y(descriptor2, 6, serializer, null);
            objY7 = cVarD.y(descriptor2, 7, serializer, null);
            objY6 = cVarD.y(descriptor2, 8, serializer, null);
            objY4 = cVarD.y(descriptor2, 9, serializer, null);
            objY3 = cVarD.y(descriptor2, 10, serializer, null);
            objY2 = cVarD.y(descriptor2, 11, serializer, null);
            obj2 = objM4;
            objY = cVarD.y(descriptor2, 12, serializer, null);
            Object objY11 = cVarD.y(descriptor2, 13, serializer, null);
            objY5 = cVarD.y(descriptor2, 14, serializer, null);
            obj = objY11;
            i4 = 32767;
            obj3 = objM3;
        } else {
            boolean z4 = true;
            Object objY12 = null;
            Object objY13 = null;
            Object objY14 = null;
            Object objY15 = null;
            Object objY16 = null;
            Object objY17 = null;
            Object objY18 = null;
            Object objM5 = null;
            Object objY19 = null;
            Object objM6 = null;
            Object objY20 = null;
            Object objM7 = null;
            Object objY21 = null;
            Object objM8 = null;
            int i5 = 0;
            Object objY22 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                switch (i6) {
                    case -1:
                        obj4 = objY22;
                        obj5 = objM8;
                        obj6 = objY12;
                        z4 = false;
                        objY22 = obj4;
                        objY12 = obj6;
                        objM8 = obj5;
                        break;
                    case 0:
                        Object obj9 = objM8;
                        obj6 = objY12;
                        obj4 = objY22;
                        obj5 = obj9;
                        objM7 = cVarD.m(descriptor2, 0, PaywallColor.Serializer.INSTANCE, objM7);
                        i5 |= 1;
                        objY22 = obj4;
                        objY12 = obj6;
                        objM8 = obj5;
                        break;
                    case 1:
                        Object obj10 = objY22;
                        i5 |= 2;
                        objM8 = cVarD.m(descriptor2, 1, PaywallColor.Serializer.INSTANCE, objM8);
                        objY12 = objY12;
                        objY22 = obj10;
                        break;
                    case 2:
                        objY12 = cVarD.y(descriptor2, 2, PaywallColor.Serializer.INSTANCE, objY12);
                        i5 |= 4;
                        objY22 = objY22;
                        objY21 = objY21;
                        break;
                    case 3:
                        obj7 = objY22;
                        obj8 = objY12;
                        objY20 = cVarD.y(descriptor2, 3, PaywallColor.Serializer.INSTANCE, objY20);
                        i5 |= 8;
                        objY22 = obj7;
                        objY12 = obj8;
                        break;
                    case 4:
                        obj7 = objY22;
                        obj8 = objY12;
                        objM5 = cVarD.m(descriptor2, 4, PaywallColor.Serializer.INSTANCE, objM5);
                        i5 |= 16;
                        objY22 = obj7;
                        objY12 = obj8;
                        break;
                    case 5:
                        obj7 = objY22;
                        obj8 = objY12;
                        objM6 = cVarD.m(descriptor2, 5, PaywallColor.Serializer.INSTANCE, objM6);
                        i5 |= 32;
                        objY22 = obj7;
                        objY12 = obj8;
                        break;
                    case 6:
                        obj7 = objY22;
                        obj8 = objY12;
                        objY18 = cVarD.y(descriptor2, 6, PaywallColor.Serializer.INSTANCE, objY18);
                        i5 |= 64;
                        objY22 = obj7;
                        objY12 = obj8;
                        break;
                    case 7:
                        obj7 = objY22;
                        obj8 = objY12;
                        objY17 = cVarD.y(descriptor2, 7, PaywallColor.Serializer.INSTANCE, objY17);
                        i5 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        objY22 = obj7;
                        objY12 = obj8;
                        break;
                    case 8:
                        obj7 = objY22;
                        obj8 = objY12;
                        objY16 = cVarD.y(descriptor2, 8, PaywallColor.Serializer.INSTANCE, objY16);
                        i5 |= 256;
                        objY22 = obj7;
                        objY12 = obj8;
                        break;
                    case 9:
                        obj7 = objY22;
                        obj8 = objY12;
                        objY19 = cVarD.y(descriptor2, 9, PaywallColor.Serializer.INSTANCE, objY19);
                        i5 |= 512;
                        objY22 = obj7;
                        objY12 = obj8;
                        break;
                    case 10:
                        obj7 = objY22;
                        obj8 = objY12;
                        objY15 = cVarD.y(descriptor2, 10, PaywallColor.Serializer.INSTANCE, objY15);
                        i5 |= UserMetadata.MAX_ATTRIBUTE_SIZE;
                        objY22 = obj7;
                        objY12 = obj8;
                        break;
                    case 11:
                        obj7 = objY22;
                        obj8 = objY12;
                        objY14 = cVarD.y(descriptor2, 11, PaywallColor.Serializer.INSTANCE, objY14);
                        i5 |= 2048;
                        objY22 = obj7;
                        objY12 = obj8;
                        break;
                    case 12:
                        obj7 = objY22;
                        obj8 = objY12;
                        objY13 = cVarD.y(descriptor2, 12, PaywallColor.Serializer.INSTANCE, objY13);
                        i5 |= 4096;
                        objY22 = obj7;
                        objY12 = obj8;
                        break;
                    case 13:
                        obj8 = objY12;
                        obj7 = objY22;
                        objY21 = cVarD.y(descriptor2, 13, PaywallColor.Serializer.INSTANCE, objY21);
                        i5 |= UserMetadata.MAX_INTERNAL_KEY_SIZE;
                        objY22 = obj7;
                        objY12 = obj8;
                        break;
                    case 14:
                        objY22 = cVarD.y(descriptor2, 14, PaywallColor.Serializer.INSTANCE, objY22);
                        i5 |= 16384;
                        objY12 = objY12;
                        break;
                    default:
                        throw new j(i6);
                }
            }
            obj = objY21;
            obj2 = objM8;
            obj3 = objM7;
            i4 = i5;
            objY = objY13;
            objY2 = objY14;
            objY3 = objY15;
            objY4 = objY19;
            objY5 = objY22;
            objY6 = objY16;
            objY7 = objY17;
            objY8 = objY18;
            objM = objM6;
            objM2 = objM5;
            objY9 = objY20;
            objY10 = objY12;
        }
        Object obj11 = obj2;
        cVarD.c(descriptor2);
        return new PaywallData.Configuration.Colors(i4, (PaywallColor) obj3, (PaywallColor) obj11, (PaywallColor) objY10, (PaywallColor) objY9, (PaywallColor) objM2, (PaywallColor) objM, (PaywallColor) objY8, (PaywallColor) objY7, (PaywallColor) objY6, (PaywallColor) objY4, (PaywallColor) objY3, (PaywallColor) objY2, (PaywallColor) objY, (PaywallColor) obj, (PaywallColor) objY5, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PaywallData.Configuration.Colors value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PaywallData.Configuration.Colors.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
