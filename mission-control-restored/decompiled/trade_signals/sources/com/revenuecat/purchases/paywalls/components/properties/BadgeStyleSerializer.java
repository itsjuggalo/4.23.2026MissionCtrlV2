package com.revenuecat.purchases.paywalls.components.properties;

import B5.k;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import o5.C2487o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/BadgeStyleSerializer;", "Lcom/revenuecat/purchases/utils/serializers/EnumDeserializerWithDefault;", "Lcom/revenuecat/purchases/paywalls/components/properties/Badge$Style;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BadgeStyleSerializer extends EnumDeserializerWithDefault<Badge.Style> {
    public static final BadgeStyleSerializer INSTANCE = new BadgeStyleSerializer();

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.properties.BadgeStyleSerializer$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "style", "Lcom/revenuecat/purchases/paywalls/components/properties/Badge$Style;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 extends AbstractC2306v implements k {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.properties.BadgeStyleSerializer$1$WhenMappings */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
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

        @Override // B5.k
        public final String invoke(Badge.Style style) {
            AbstractC2304t.f(style, "style");
            int i8 = WhenMappings.$EnumSwitchMapping$0[style.ordinal()];
            if (i8 == 1) {
                return "overlay";
            }
            if (i8 == 2) {
                return "edge_to_edge";
            }
            if (i8 == 3) {
                return "nested";
            }
            throw new C2487o();
        }
    }

    private BadgeStyleSerializer() {
        super(Badge.Style.Overlay, AnonymousClass1.INSTANCE);
    }
}
