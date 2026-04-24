package com.revenuecat.purchases.paywalls.components;

import W2.m;
import com.revenuecat.purchases.paywalls.components.PaywallTransition;
import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;
import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class TransitionTypeSerializer extends EnumDeserializerWithDefault<PaywallTransition.TransitionType> {
    public static final TransitionTypeSerializer INSTANCE = new TransitionTypeSerializer();

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.TransitionTypeSerializer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.TransitionTypeSerializer$1$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PaywallTransition.TransitionType.values().length];
                try {
                    iArr[PaywallTransition.TransitionType.FADE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PaywallTransition.TransitionType.FADE_AND_SCALE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PaywallTransition.TransitionType.SCALE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[PaywallTransition.TransitionType.SLIDE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // i3.k
        public final String invoke(PaywallTransition.TransitionType value) {
            r.f(value, "value");
            int i4 = WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
            if (i4 == 1) {
                return "fade";
            }
            if (i4 == 2) {
                return "fade_and_scale";
            }
            if (i4 == 3) {
                return "scale";
            }
            if (i4 == 4) {
                return "slide";
            }
            throw new m();
        }
    }

    private TransitionTypeSerializer() {
        super(PaywallTransition.TransitionType.FADE, AnonymousClass1.INSTANCE);
    }
}
