package com.revenuecat.purchases.paywalls.components.properties;

import F3.b;
import W2.t;
import X2.L;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.utils.serializers.SealedDeserializerWithDefault;
import i3.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class ShapeDeserializer extends SealedDeserializerWithDefault<Shape> {
    public static final ShapeDeserializer INSTANCE = new ShapeDeserializer();

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements Function0 {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return Shape.Rectangle.Companion.serializer();
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends s implements Function0 {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return Shape.Pill.INSTANCE.serializer();
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer$3, reason: invalid class name */
    public static final class AnonymousClass3 extends s implements k {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // i3.k
        public final Shape invoke(String it) {
            r.f(it, "it");
            return new Shape.Rectangle((CornerRadiuses) null, 1, (AbstractC1585j) (0 == true ? 1 : 0));
        }
    }

    private ShapeDeserializer() {
        super("Shape", L.g(t.a("rectangle", AnonymousClass1.INSTANCE), t.a("pill", AnonymousClass2.INSTANCE)), AnonymousClass3.INSTANCE, null, 8, null);
    }
}
