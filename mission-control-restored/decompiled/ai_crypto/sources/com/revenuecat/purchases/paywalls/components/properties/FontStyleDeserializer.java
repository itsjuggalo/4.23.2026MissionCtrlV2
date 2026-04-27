package com.revenuecat.purchases.paywalls.components.properties;

import E5.m;
import Q5.k;
import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public final class FontStyleDeserializer extends EnumDeserializerWithDefault<FontStyle> {
    public static final FontStyleDeserializer INSTANCE = new FontStyleDeserializer();

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.properties.FontStyleDeserializer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.properties.FontStyleDeserializer$1$WhenMappings */
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

        @Override // Q5.k
        public final String invoke(FontStyle value) {
            r.f(value, "value");
            int i7 = WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
            if (i7 == 1) {
                return "normal";
            }
            if (i7 == 2) {
                return "italic";
            }
            throw new m();
        }
    }

    private FontStyleDeserializer() {
        super(FontStyle.NORMAL, AnonymousClass1.INSTANCE);
    }
}
