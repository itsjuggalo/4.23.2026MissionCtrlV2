package com.revenuecat.purchases.paywalls.components.common;

import F3.b;
import W2.t;
import X2.L;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.utils.serializers.SealedDeserializerWithDefault;
import i3.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class BackgroundDeserializer extends SealedDeserializerWithDefault<Background> {
    public static final BackgroundDeserializer INSTANCE = new BackgroundDeserializer();

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements Function0 {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return Background.Color.Companion.serializer();
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends s implements Function0 {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return Background.Image.Companion.serializer();
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer$3, reason: invalid class name */
    public static final class AnonymousClass3 extends s implements k {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // i3.k
        public final Background invoke(String type) {
            r.f(type, "type");
            return new Background.Unknown(type);
        }
    }

    private BackgroundDeserializer() {
        super("Background", L.g(t.a("color", AnonymousClass1.INSTANCE), t.a("image", AnonymousClass2.INSTANCE)), AnonymousClass3.INSTANCE, null, 8, null);
    }
}
