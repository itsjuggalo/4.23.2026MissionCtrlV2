package com.revenuecat.purchases.paywalls.components;

import I5.d;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Badge$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.Dimension$Horizontal$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Dimension$Vertical$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Dimension$ZLayer$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import java.lang.annotation.Annotation;
import java.util.List;
import k7.b;
import k7.h;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.O;
import m7.e;
import o7.AbstractC2504f0;
import o7.C2501e;
import o7.C2507h;
import o7.D;
import o7.t0;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b2\b\u0007\u0018\u0000 [2\u00020\u0001:\u0003\\[]B¿\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u0002¢\u0006\u0004\b \u0010!BÅ\u0001\b\u0011\u0012\u0006\u0010#\u001a\u00020\"\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0014\u0010\u001f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d\u0018\u00010\u0002\u0012\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b \u0010&J(\u0010/\u001a\u00020,2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*HÁ\u0001¢\u0006\u0004\b-\u0010.R\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00100\u001a\u0004\b1\u00102R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00103\u001a\u0004\b4\u00105R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00106\u001a\u0004\b7\u00108R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u00109\u001a\u0004\b:\u0010;R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010<\u001a\u0004\b=\u0010>R\"\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\r\u0010?\u0012\u0004\bB\u0010C\u001a\u0004\b@\u0010AR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010D\u001a\u0004\bE\u0010FR\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010G\u001a\u0004\bH\u0010IR\u0017\u0010\u0012\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u0010G\u001a\u0004\bJ\u0010IR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010K\u001a\u0004\bL\u0010MR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010N\u001a\u0004\bO\u0010PR\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010Q\u001a\u0004\bR\u0010SR\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010T\u001a\u0004\bU\u0010VR\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010W\u001a\u0004\bX\u0010YR#\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u00100\u001a\u0004\bZ\u00102¨\u0006^"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "", "components", "", "visible", "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "dimension", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "size", "", "spacing", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "backgroundColor", "Lcom/revenuecat/purchases/paywalls/components/common/Background;", "background", "Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "padding", "margin", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "shape", "Lcom/revenuecat/purchases/paywalls/components/properties/Border;", "border", "Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;", "shadow", "Lcom/revenuecat/purchases/paywalls/components/properties/Badge;", "badge", "Lcom/revenuecat/purchases/paywalls/components/StackComponent$Overflow;", "overflow", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride;", "Lcom/revenuecat/purchases/paywalls/components/PartialStackComponent;", "overrides", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Ljava/lang/Float;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/common/Background;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/paywalls/components/properties/Border;Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;Lcom/revenuecat/purchases/paywalls/components/properties/Badge;Lcom/revenuecat/purchases/paywalls/components/StackComponent$Overflow;Ljava/util/List;)V", "", "seen1", "Lo7/t0;", "serializationConstructorMarker", "(ILjava/util/List;Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Ljava/lang/Float;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/common/Background;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/paywalls/components/properties/Border;Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;Lcom/revenuecat/purchases/paywalls/components/properties/Badge;Lcom/revenuecat/purchases/paywalls/components/StackComponent$Overflow;Ljava/util/List;Lo7/t0;)V", "self", "Ln7/d;", "output", "Lm7/e;", "serialDesc", "Lo5/H;", "write$Self$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/paywalls/components/StackComponent;Ln7/d;Lm7/e;)V", "write$Self", "Ljava/util/List;", "getComponents", "()Ljava/util/List;", "Ljava/lang/Boolean;", "getVisible", "()Ljava/lang/Boolean;", "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "getDimension", "()Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "Ljava/lang/Float;", "getSpacing", "()Ljava/lang/Float;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "getBackgroundColor", "()Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "getBackgroundColor$annotations", "()V", "Lcom/revenuecat/purchases/paywalls/components/common/Background;", "getBackground", "()Lcom/revenuecat/purchases/paywalls/components/common/Background;", "Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "getPadding", "()Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "getMargin", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "getShape", "()Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "Lcom/revenuecat/purchases/paywalls/components/properties/Border;", "getBorder", "()Lcom/revenuecat/purchases/paywalls/components/properties/Border;", "Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;", "getShadow", "()Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;", "Lcom/revenuecat/purchases/paywalls/components/properties/Badge;", "getBadge", "()Lcom/revenuecat/purchases/paywalls/components/properties/Badge;", "Lcom/revenuecat/purchases/paywalls/components/StackComponent$Overflow;", "getOverflow", "()Lcom/revenuecat/purchases/paywalls/components/StackComponent$Overflow;", "getOverrides", "Companion", "$serializer", "Overflow", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public final class StackComponent implements PaywallComponent {
    private final Background background;
    private final ColorScheme backgroundColor;
    private final Badge badge;
    private final Border border;
    private final List<PaywallComponent> components;
    private final Dimension dimension;
    private final Padding margin;
    private final Overflow overflow;
    private final List<ComponentOverride<PartialStackComponent>> overrides;
    private final Padding padding;
    private final Shadow shadow;
    private final Shape shape;
    private final Size size;
    private final Float spacing;
    private final Boolean visible;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final b[] $childSerializers = {new C2501e(new PaywallComponentSerializer()), null, new h("com.revenuecat.purchases.paywalls.components.properties.Dimension", O.b(Dimension.class), new d[]{O.b(Dimension.Horizontal.class), O.b(Dimension.Vertical.class), O.b(Dimension.ZLayer.class)}, new b[]{Dimension$Horizontal$$serializer.INSTANCE, Dimension$Vertical$$serializer.INSTANCE, Dimension$ZLayer$$serializer.INSTANCE}, new Annotation[0]), null, null, null, null, null, null, null, null, null, null, null, new C2501e(ComponentOverride.INSTANCE.serializer(PartialStackComponent$$serializer.INSTANCE))};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/StackComponent$Companion;", "", "<init>", "()V", "Lk7/b;", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "serializer", "()Lk7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return StackComponent$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/StackComponent$Overflow;", "", "(Ljava/lang/String;I)V", "NONE", "SCROLL", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Overflow {
        NONE,
        SCROLL;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/StackComponent$Overflow$Companion;", "", "<init>", "()V", "Lk7/b;", "Lcom/revenuecat/purchases/paywalls/components/StackComponent$Overflow;", "serializer", "()Lk7/b;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {
            private Companion() {
            }

            public final b serializer() {
                return StackOverflowDeserializer.INSTANCE;
            }

            public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
                this();
            }
        }
    }

    public /* synthetic */ StackComponent(int i8, List list, Boolean bool, Dimension dimension, Size size, Float f8, ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, Badge badge, Overflow overflow, List list2, t0 t0Var) {
        if (1 != (i8 & 1)) {
            AbstractC2504f0.a(i8, 1, StackComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.components = list;
        if ((i8 & 2) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        this.dimension = (i8 & 4) == 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : dimension;
        this.size = (i8 & 8) == 0 ? new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE) : size;
        if ((i8 & 16) == 0) {
            this.spacing = null;
        } else {
            this.spacing = f8;
        }
        if ((i8 & 32) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = colorScheme;
        }
        if ((i8 & 64) == 0) {
            this.background = null;
        } else {
            this.background = background;
        }
        this.padding = (i8 & 128) == 0 ? Padding.INSTANCE.getZero() : padding;
        this.margin = (i8 & 256) == 0 ? Padding.INSTANCE.getZero() : padding2;
        if ((i8 & 512) == 0) {
            this.shape = null;
        } else {
            this.shape = shape;
        }
        if ((i8 & 1024) == 0) {
            this.border = null;
        } else {
            this.border = border;
        }
        if ((i8 & 2048) == 0) {
            this.shadow = null;
        } else {
            this.shadow = shadow;
        }
        if ((i8 & 4096) == 0) {
            this.badge = null;
        } else {
            this.badge = badge;
        }
        if ((i8 & 8192) == 0) {
            this.overflow = null;
        } else {
            this.overflow = overflow;
        }
        this.overrides = (i8 & 16384) == 0 ? AbstractC2595q.i() : list2;
    }

    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsRelease(StackComponent self, n7.d output, e serialDesc) {
        b[] bVarArr = $childSerializers;
        output.B(serialDesc, 0, bVarArr[0], self.components);
        if (output.q(serialDesc, 1) || self.visible != null) {
            output.u(serialDesc, 1, C2507h.f22167a, self.visible);
        }
        if (output.q(serialDesc, 2) || !AbstractC2304t.b(self.dimension, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START))) {
            output.B(serialDesc, 2, bVarArr[2], self.dimension);
        }
        if (output.q(serialDesc, 3) || !AbstractC2304t.b(self.size, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE))) {
            output.B(serialDesc, 3, Size$$serializer.INSTANCE, self.size);
        }
        if (output.q(serialDesc, 4) || self.spacing != null) {
            output.u(serialDesc, 4, D.f22101a, self.spacing);
        }
        if (output.q(serialDesc, 5) || self.backgroundColor != null) {
            output.u(serialDesc, 5, ColorScheme$$serializer.INSTANCE, self.backgroundColor);
        }
        if (output.q(serialDesc, 6) || self.background != null) {
            output.u(serialDesc, 6, BackgroundDeserializer.INSTANCE, self.background);
        }
        if (output.q(serialDesc, 7) || !AbstractC2304t.b(self.padding, Padding.INSTANCE.getZero())) {
            output.B(serialDesc, 7, Padding$$serializer.INSTANCE, self.padding);
        }
        if (output.q(serialDesc, 8) || !AbstractC2304t.b(self.margin, Padding.INSTANCE.getZero())) {
            output.B(serialDesc, 8, Padding$$serializer.INSTANCE, self.margin);
        }
        if (output.q(serialDesc, 9) || self.shape != null) {
            output.u(serialDesc, 9, ShapeDeserializer.INSTANCE, self.shape);
        }
        if (output.q(serialDesc, 10) || self.border != null) {
            output.u(serialDesc, 10, Border$$serializer.INSTANCE, self.border);
        }
        if (output.q(serialDesc, 11) || self.shadow != null) {
            output.u(serialDesc, 11, Shadow$$serializer.INSTANCE, self.shadow);
        }
        if (output.q(serialDesc, 12) || self.badge != null) {
            output.u(serialDesc, 12, Badge$$serializer.INSTANCE, self.badge);
        }
        if (output.q(serialDesc, 13) || self.overflow != null) {
            output.u(serialDesc, 13, StackOverflowDeserializer.INSTANCE, self.overflow);
        }
        if (!output.q(serialDesc, 14) && AbstractC2304t.b(self.overrides, AbstractC2595q.i())) {
            return;
        }
        output.B(serialDesc, 14, bVarArr[14], self.overrides);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StackComponent)) {
            return false;
        }
        StackComponent stackComponent = (StackComponent) obj;
        return AbstractC2304t.b(this.components, stackComponent.components) && AbstractC2304t.b(this.visible, stackComponent.visible) && AbstractC2304t.b(this.dimension, stackComponent.dimension) && AbstractC2304t.b(this.size, stackComponent.size) && AbstractC2304t.b(this.spacing, stackComponent.spacing) && AbstractC2304t.b(this.backgroundColor, stackComponent.backgroundColor) && AbstractC2304t.b(this.background, stackComponent.background) && AbstractC2304t.b(this.padding, stackComponent.padding) && AbstractC2304t.b(this.margin, stackComponent.margin) && AbstractC2304t.b(this.shape, stackComponent.shape) && AbstractC2304t.b(this.border, stackComponent.border) && AbstractC2304t.b(this.shadow, stackComponent.shadow) && AbstractC2304t.b(this.badge, stackComponent.badge) && this.overflow == stackComponent.overflow && AbstractC2304t.b(this.overrides, stackComponent.overrides);
    }

    public final /* synthetic */ Background getBackground() {
        return this.background;
    }

    public final /* synthetic */ ColorScheme getBackgroundColor() {
        return this.backgroundColor;
    }

    public final /* synthetic */ Badge getBadge() {
        return this.badge;
    }

    public final /* synthetic */ Border getBorder() {
        return this.border;
    }

    public final /* synthetic */ List getComponents() {
        return this.components;
    }

    public final /* synthetic */ Dimension getDimension() {
        return this.dimension;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ Overflow getOverflow() {
        return this.overflow;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    public final /* synthetic */ Padding getPadding() {
        return this.padding;
    }

    public final /* synthetic */ Shadow getShadow() {
        return this.shadow;
    }

    public final /* synthetic */ Shape getShape() {
        return this.shape;
    }

    public final /* synthetic */ Size getSize() {
        return this.size;
    }

    public final /* synthetic */ Float getSpacing() {
        return this.spacing;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iHashCode = this.components.hashCode() * 31;
        Boolean bool = this.visible;
        int iHashCode2 = (((((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + this.dimension.hashCode()) * 31) + this.size.hashCode()) * 31;
        Float f8 = this.spacing;
        int iHashCode3 = (iHashCode2 + (f8 == null ? 0 : f8.hashCode())) * 31;
        ColorScheme colorScheme = this.backgroundColor;
        int iHashCode4 = (iHashCode3 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        Background background = this.background;
        int iHashCode5 = (((((iHashCode4 + (background == null ? 0 : background.hashCode())) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31;
        Shape shape = this.shape;
        int iHashCode6 = (iHashCode5 + (shape == null ? 0 : shape.hashCode())) * 31;
        Border border = this.border;
        int iHashCode7 = (iHashCode6 + (border == null ? 0 : border.hashCode())) * 31;
        Shadow shadow = this.shadow;
        int iHashCode8 = (iHashCode7 + (shadow == null ? 0 : shadow.hashCode())) * 31;
        Badge badge = this.badge;
        int iHashCode9 = (iHashCode8 + (badge == null ? 0 : badge.hashCode())) * 31;
        Overflow overflow = this.overflow;
        return ((iHashCode9 + (overflow != null ? overflow.hashCode() : 0)) * 31) + this.overrides.hashCode();
    }

    public String toString() {
        return "StackComponent(components=" + this.components + ", visible=" + this.visible + ", dimension=" + this.dimension + ", size=" + this.size + ", spacing=" + this.spacing + ", backgroundColor=" + this.backgroundColor + ", background=" + this.background + ", padding=" + this.padding + ", margin=" + this.margin + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", badge=" + this.badge + ", overflow=" + this.overflow + ", overrides=" + this.overrides + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StackComponent(List<? extends PaywallComponent> components, Boolean bool, Dimension dimension, Size size, Float f8, ColorScheme colorScheme, Background background, Padding padding, Padding margin, Shape shape, Border border, Shadow shadow, Badge badge, Overflow overflow, List<ComponentOverride<PartialStackComponent>> overrides) {
        AbstractC2304t.f(components, "components");
        AbstractC2304t.f(dimension, "dimension");
        AbstractC2304t.f(size, "size");
        AbstractC2304t.f(padding, "padding");
        AbstractC2304t.f(margin, "margin");
        AbstractC2304t.f(overrides, "overrides");
        this.components = components;
        this.visible = bool;
        this.dimension = dimension;
        this.size = size;
        this.spacing = f8;
        this.backgroundColor = colorScheme;
        this.background = background;
        this.padding = padding;
        this.margin = margin;
        this.shape = shape;
        this.border = border;
        this.shadow = shadow;
        this.badge = badge;
        this.overflow = overflow;
        this.overrides = overrides;
    }

    public /* synthetic */ StackComponent(List list, Boolean bool, Dimension dimension, Size size, Float f8, ColorScheme colorScheme, Background background, Padding padding, Padding padding2, Shape shape, Border border, Shadow shadow, Badge badge, Overflow overflow, List list2, int i8, AbstractC2296k abstractC2296k) {
        this(list, (i8 & 2) != 0 ? null : bool, (i8 & 4) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : dimension, (i8 & 8) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE) : size, (i8 & 16) != 0 ? null : f8, (i8 & 32) != 0 ? null : colorScheme, (i8 & 64) != 0 ? null : background, (i8 & 128) != 0 ? Padding.INSTANCE.getZero() : padding, (i8 & 256) != 0 ? Padding.INSTANCE.getZero() : padding2, (i8 & 512) != 0 ? null : shape, (i8 & 1024) != 0 ? null : border, (i8 & 2048) != 0 ? null : shadow, (i8 & 4096) != 0 ? null : badge, (i8 & 8192) == 0 ? overflow : null, (i8 & 16384) != 0 ? AbstractC2595q.i() : list2);
    }
}
