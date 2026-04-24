package com.revenuecat.purchases.paywalls.components;

import E5.m;
import Q5.k;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public final class TimelineIconAlignmentDeserializer extends EnumDeserializerWithDefault<TimelineComponent.IconAlignment> {
    public static final TimelineIconAlignmentDeserializer INSTANCE = new TimelineIconAlignmentDeserializer();

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.TimelineIconAlignmentDeserializer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.TimelineIconAlignmentDeserializer$1$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[TimelineComponent.IconAlignment.values().length];
                try {
                    iArr[TimelineComponent.IconAlignment.Title.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[TimelineComponent.IconAlignment.TitleAndDescription.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // Q5.k
        public final String invoke(TimelineComponent.IconAlignment value) {
            r.f(value, "value");
            int i7 = WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
            if (i7 == 1) {
                return b.f9930S;
            }
            if (i7 == 2) {
                return "title_and_description";
            }
            throw new m();
        }
    }

    private TimelineIconAlignmentDeserializer() {
        super(TimelineComponent.IconAlignment.Title, AnonymousClass1.INSTANCE);
    }
}
