package com.revenuecat.purchases.paywalls.components.properties;

import W2.m;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;
import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class BadgeStyleSerializer extends EnumDeserializerWithDefault<Badge.Style> {
    public static final BadgeStyleSerializer INSTANCE = new BadgeStyleSerializer();

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.properties.BadgeStyleSerializer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.properties.BadgeStyleSerializer$1$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Badge.Style.values().length];
                try {
                    iArr[Badge.Style.Overlay.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Badge.Style.EdgeToEdge.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Badge.Style.Nested.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // i3.k
        public final String invoke(Badge.Style style) {
            r.f(style, "style");
            int i4 = WhenMappings.$EnumSwitchMapping$0[style.ordinal()];
            if (i4 == 1) {
                return "overlay";
            }
            if (i4 == 2) {
                return "edge_to_edge";
            }
            if (i4 == 3) {
                return "nested";
            }
            throw new m();
        }
    }

    private BadgeStyleSerializer() {
        super(Badge.Style.Overlay, AnonymousClass1.INSTANCE);
    }
}
