package com.revenuecat.purchases.paywalls.components.properties;

import W2.m;
import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;
import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class FontWeightDeserializer extends EnumDeserializerWithDefault<FontWeight> {
    public static final FontWeightDeserializer INSTANCE = new FontWeightDeserializer();

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.properties.FontWeightDeserializer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.properties.FontWeightDeserializer$1$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FontWeight.values().length];
                try {
                    iArr[FontWeight.EXTRA_LIGHT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FontWeight.THIN.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[FontWeight.LIGHT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[FontWeight.REGULAR.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[FontWeight.MEDIUM.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[FontWeight.SEMI_BOLD.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[FontWeight.BOLD.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[FontWeight.EXTRA_BOLD.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[FontWeight.BLACK.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // i3.k
        public final String invoke(FontWeight value) {
            r.f(value, "value");
            switch (WhenMappings.$EnumSwitchMapping$0[value.ordinal()]) {
                case 1:
                    return "extra_light";
                case 2:
                    return "thin";
                case 3:
                    return "light";
                case 4:
                    return "regular";
                case 5:
                    return "medium";
                case 6:
                    return "semibold";
                case 7:
                    return "bold";
                case 8:
                    return "extra_bold";
                case 9:
                    return "black";
                default:
                    throw new m();
            }
        }
    }

    private FontWeightDeserializer() {
        super(FontWeight.REGULAR, AnonymousClass1.INSTANCE);
    }
}
