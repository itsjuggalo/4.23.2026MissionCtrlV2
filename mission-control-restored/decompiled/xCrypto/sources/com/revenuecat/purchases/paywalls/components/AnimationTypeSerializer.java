package com.revenuecat.purchases.paywalls.components;

import W2.m;
import com.revenuecat.purchases.paywalls.components.PaywallAnimation;
import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;
import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class AnimationTypeSerializer extends EnumDeserializerWithDefault<PaywallAnimation.AnimationType> {
    public static final AnimationTypeSerializer INSTANCE = new AnimationTypeSerializer();

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.AnimationTypeSerializer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.AnimationTypeSerializer$1$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PaywallAnimation.AnimationType.values().length];
                try {
                    iArr[PaywallAnimation.AnimationType.EASE_IN.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PaywallAnimation.AnimationType.EASE_OUT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PaywallAnimation.AnimationType.EASE_IN_OUT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[PaywallAnimation.AnimationType.LINEAR.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // i3.k
        public final String invoke(PaywallAnimation.AnimationType value) {
            r.f(value, "value");
            int i4 = WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
            if (i4 == 1) {
                return "ease_in";
            }
            if (i4 == 2) {
                return "ease_out";
            }
            if (i4 == 3) {
                return "ease_in_out";
            }
            if (i4 == 4) {
                return "linear";
            }
            throw new m();
        }
    }

    private AnimationTypeSerializer() {
        super(PaywallAnimation.AnimationType.EASE_IN_OUT, AnonymousClass1.INSTANCE);
    }
}
