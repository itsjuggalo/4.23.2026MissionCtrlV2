package com.revenuecat.purchases.paywalls.components.properties;

import E5.j;
import E5.k;
import E5.l;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import java.lang.annotation.Annotation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.s;
import n6.b;
import r6.AbstractC2637y;

/* JADX INFO: loaded from: classes2.dex */
@InternalRevenueCatAPI
public enum FontSize {
    HEADING_XXL,
    HEADING_XL,
    HEADING_L,
    HEADING_M,
    HEADING_S,
    HEADING_XS,
    BODY_XL,
    BODY_L,
    BODY_M,
    BODY_S;

    public static final Companion Companion = new Companion(null);
    private static final j $cachedSerializer$delegate = k.a(l.f1675b, Companion.AnonymousClass1.INSTANCE);

    public static final class Companion {

        /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.properties.FontSize$Companion$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements Function0 {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return AbstractC2637y.a("com.revenuecat.purchases.paywalls.components.properties.FontSize", FontSize.values(), new String[]{"heading_xxl", "heading_xl", "heading_l", "heading_m", "heading_s", "heading_xs", "body_xl", "body_l", "body_m", "body_s"}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null}, null);
            }
        }

        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        private final /* synthetic */ b get$cachedSerializer() {
            return (b) FontSize.$cachedSerializer$delegate.getValue();
        }

        public final b serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }
}
