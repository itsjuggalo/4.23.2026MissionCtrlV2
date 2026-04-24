package com.revenuecat.purchases.paywalls.components.properties;

import B5.k;
import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import o5.C2487o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/FontStyleDeserializer;", "Lcom/revenuecat/purchases/utils/serializers/EnumDeserializerWithDefault;", "Lcom/revenuecat/purchases/paywalls/components/properties/FontStyle;", "()V", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FontStyleDeserializer extends EnumDeserializerWithDefault<FontStyle> {
    public static final FontStyleDeserializer INSTANCE = new FontStyleDeserializer();

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.properties.FontStyleDeserializer$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "value", "Lcom/revenuecat/purchases/paywalls/components/properties/FontStyle;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 extends AbstractC2306v implements k {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.properties.FontStyleDeserializer$1$WhenMappings */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FontStyle.values().length];
                try {
                    iArr[FontStyle.NORMAL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FontStyle.ITALIC.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // B5.k
        public final String invoke(FontStyle value) {
            AbstractC2304t.f(value, "value");
            int i8 = WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
            if (i8 == 1) {
                return "normal";
            }
            if (i8 == 2) {
                return "italic";
            }
            throw new C2487o();
        }
    }

    private FontStyleDeserializer() {
        super(FontStyle.NORMAL, AnonymousClass1.INSTANCE);
    }
}
