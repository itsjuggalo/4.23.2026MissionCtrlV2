package com.revenuecat.purchases.paywalls.components.properties;

import E5.j;
import E5.k;
import E5.l;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent$$serializer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import n6.b;
import p6.e;
import q6.d;
import r6.AbstractC2611a0;
import r6.k0;

/* JADX INFO: loaded from: classes2.dex */
@InternalRevenueCatAPI
public final class Badge {
    public static final Companion Companion = new Companion(null);
    private final TwoDimensionalAlignment alignment;
    private final StackComponent stack;
    private final Style style;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        public final b serializer() {
            return Badge$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @InternalRevenueCatAPI
    public enum Style {
        Overlay,
        EdgeToEdge,
        Nested;

        public static final Companion Companion = new Companion(null);
        private static final j $cachedSerializer$delegate = k.a(l.f1675b, Companion.AnonymousClass1.INSTANCE);

        public static final class Companion {

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.properties.Badge$Style$Companion$1, reason: invalid class name */
            public static final class AnonymousClass1 extends s implements Function0 {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final b invoke() {
                    return BadgeStyleSerializer.INSTANCE;
                }
            }

            public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
                this();
            }

            private final /* synthetic */ b get$cachedSerializer() {
                return (b) Style.$cachedSerializer$delegate.getValue();
            }

            public final b serializer() {
                return get$cachedSerializer();
            }

            private Companion() {
            }
        }
    }

    public /* synthetic */ Badge(int i7, StackComponent stackComponent, Style style, TwoDimensionalAlignment twoDimensionalAlignment, k0 k0Var) {
        if (7 != (i7 & 7)) {
            AbstractC2611a0.a(i7, 7, Badge$$serializer.INSTANCE.getDescriptor());
        }
        this.stack = stackComponent;
        this.style = style;
        this.alignment = twoDimensionalAlignment;
    }

    public static final /* synthetic */ void write$Self(Badge badge, d dVar, e eVar) {
        dVar.x(eVar, 0, StackComponent$$serializer.INSTANCE, badge.stack);
        dVar.x(eVar, 1, BadgeStyleSerializer.INSTANCE, badge.style);
        dVar.x(eVar, 2, TwoDimensionalAlignmentDeserializer.INSTANCE, badge.alignment);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Badge)) {
            return false;
        }
        Badge badge = (Badge) obj;
        return r.b(this.stack, badge.stack) && this.style == badge.style && this.alignment == badge.alignment;
    }

    public final /* synthetic */ TwoDimensionalAlignment getAlignment() {
        return this.alignment;
    }

    public final /* synthetic */ StackComponent getStack() {
        return this.stack;
    }

    public final /* synthetic */ Style getStyle() {
        return this.style;
    }

    public int hashCode() {
        return (((this.stack.hashCode() * 31) + this.style.hashCode()) * 31) + this.alignment.hashCode();
    }

    public String toString() {
        return "Badge(stack=" + this.stack + ", style=" + this.style + ", alignment=" + this.alignment + ')';
    }

    public Badge(StackComponent stack, Style style, TwoDimensionalAlignment alignment) {
        r.f(stack, "stack");
        r.f(style, "style");
        r.f(alignment, "alignment");
        this.stack = stack;
        this.style = style;
        this.alignment = alignment;
    }
}
