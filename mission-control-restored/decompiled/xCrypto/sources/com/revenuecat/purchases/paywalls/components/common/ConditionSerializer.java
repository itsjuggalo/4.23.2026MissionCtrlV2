package com.revenuecat.purchases.paywalls.components.common;

import F3.b;
import W2.t;
import X2.L;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.utils.serializers.SealedDeserializerWithDefault;
import i3.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class ConditionSerializer extends SealedDeserializerWithDefault<ComponentOverride.Condition> {
    public static final ConditionSerializer INSTANCE = new ConditionSerializer();

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.common.ConditionSerializer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements Function0 {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return ComponentOverride.Condition.Compact.INSTANCE.serializer();
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.common.ConditionSerializer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends s implements Function0 {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return ComponentOverride.Condition.Medium.INSTANCE.serializer();
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.common.ConditionSerializer$3, reason: invalid class name */
    public static final class AnonymousClass3 extends s implements Function0 {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return ComponentOverride.Condition.Expanded.INSTANCE.serializer();
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.common.ConditionSerializer$4, reason: invalid class name */
    public static final class AnonymousClass4 extends s implements Function0 {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return ComponentOverride.Condition.IntroOffer.INSTANCE.serializer();
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.common.ConditionSerializer$5, reason: invalid class name */
    public static final class AnonymousClass5 extends s implements Function0 {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        public AnonymousClass5() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return ComponentOverride.Condition.MultipleIntroOffers.INSTANCE.serializer();
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.common.ConditionSerializer$6, reason: invalid class name */
    public static final class AnonymousClass6 extends s implements Function0 {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        public AnonymousClass6() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return ComponentOverride.Condition.Selected.INSTANCE.serializer();
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.common.ConditionSerializer$7, reason: invalid class name */
    public static final class AnonymousClass7 extends s implements k {
        public static final AnonymousClass7 INSTANCE = new AnonymousClass7();

        public AnonymousClass7() {
            super(1);
        }

        @Override // i3.k
        public final ComponentOverride.Condition invoke(String it) {
            r.f(it, "it");
            return ComponentOverride.Condition.Unsupported.INSTANCE;
        }
    }

    private ConditionSerializer() {
        super("Condition", L.g(t.a("compact", AnonymousClass1.INSTANCE), t.a("medium", AnonymousClass2.INSTANCE), t.a("expanded", AnonymousClass3.INSTANCE), t.a("intro_offer", AnonymousClass4.INSTANCE), t.a("multiple_intro_offers", AnonymousClass5.INSTANCE), t.a("selected", AnonymousClass6.INSTANCE)), AnonymousClass7.INSTANCE, null, 8, null);
    }
}
