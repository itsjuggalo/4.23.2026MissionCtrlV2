package com.revenuecat.purchases.paywalls.components;

import F3.b;
import H3.e;
import I3.d;
import J3.C0335h;
import J3.k0;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class PartialTabsComponent implements PartialComponent {
    public static final Companion Companion = new Companion(null);
    private final Background background;
    private final ColorScheme backgroundColor;
    private final Border border;
    private final Padding margin;
    private final Padding padding;
    private final Shadow shadow;
    private final Shape shape;
    private final Size size;
    private final Boolean visible;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return PartialTabsComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public PartialTabsComponent() {
        this((Boolean) null, (Size) null, (Padding) null, (Padding) null, (ColorScheme) null, (Background) null, (Shape) null, (Border) null, (Shadow) null, 511, (AbstractC1585j) null);
    }

    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    public static final /* synthetic */ void write$Self(PartialTabsComponent partialTabsComponent, d dVar, e eVar) {
        if (dVar.j(eVar, 0) || !r.b(partialTabsComponent.visible, Boolean.TRUE)) {
            dVar.E(eVar, 0, C0335h.f929a, partialTabsComponent.visible);
        }
        if (dVar.j(eVar, 1) || partialTabsComponent.size != null) {
            dVar.E(eVar, 1, Size$$serializer.INSTANCE, partialTabsComponent.size);
        }
        if (dVar.j(eVar, 2) || partialTabsComponent.padding != null) {
            dVar.E(eVar, 2, Padding$$serializer.INSTANCE, partialTabsComponent.padding);
        }
        if (dVar.j(eVar, 3) || partialTabsComponent.margin != null) {
            dVar.E(eVar, 3, Padding$$serializer.INSTANCE, partialTabsComponent.margin);
        }
        if (dVar.j(eVar, 4) || partialTabsComponent.backgroundColor != null) {
            dVar.E(eVar, 4, ColorScheme$$serializer.INSTANCE, partialTabsComponent.backgroundColor);
        }
        if (dVar.j(eVar, 5) || partialTabsComponent.background != null) {
            dVar.E(eVar, 5, BackgroundDeserializer.INSTANCE, partialTabsComponent.background);
        }
        if (dVar.j(eVar, 6) || partialTabsComponent.shape != null) {
            dVar.E(eVar, 6, ShapeDeserializer.INSTANCE, partialTabsComponent.shape);
        }
        if (dVar.j(eVar, 7) || partialTabsComponent.border != null) {
            dVar.E(eVar, 7, Border$$serializer.INSTANCE, partialTabsComponent.border);
        }
        if (!dVar.j(eVar, 8) && partialTabsComponent.shadow == null) {
            return;
        }
        dVar.E(eVar, 8, Shadow$$serializer.INSTANCE, partialTabsComponent.shadow);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PartialTabsComponent)) {
            return false;
        }
        PartialTabsComponent partialTabsComponent = (PartialTabsComponent) obj;
        return r.b(this.visible, partialTabsComponent.visible) && r.b(this.size, partialTabsComponent.size) && r.b(this.padding, partialTabsComponent.padding) && r.b(this.margin, partialTabsComponent.margin) && r.b(this.backgroundColor, partialTabsComponent.backgroundColor) && r.b(this.background, partialTabsComponent.background) && r.b(this.shape, partialTabsComponent.shape) && r.b(this.border, partialTabsComponent.border) && r.b(this.shadow, partialTabsComponent.shadow);
    }

    public final /* synthetic */ Background getBackground() {
        return this.background;
    }

    public final /* synthetic */ ColorScheme getBackgroundColor() {
        return this.backgroundColor;
    }

    public final /* synthetic */ Border getBorder() {
        return this.border;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
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

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        Boolean bool = this.visible;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Size size = this.size;
        int iHashCode2 = (iHashCode + (size == null ? 0 : size.hashCode())) * 31;
        Padding padding = this.padding;
        int iHashCode3 = (iHashCode2 + (padding == null ? 0 : padding.hashCode())) * 31;
        Padding padding2 = this.margin;
        int iHashCode4 = (iHashCode3 + (padding2 == null ? 0 : padding2.hashCode())) * 31;
        ColorScheme colorScheme = this.backgroundColor;
        int iHashCode5 = (iHashCode4 + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        Background background = this.background;
        int iHashCode6 = (iHashCode5 + (background == null ? 0 : background.hashCode())) * 31;
        Shape shape = this.shape;
        int iHashCode7 = (iHashCode6 + (shape == null ? 0 : shape.hashCode())) * 31;
        Border border = this.border;
        int iHashCode8 = (iHashCode7 + (border == null ? 0 : border.hashCode())) * 31;
        Shadow shadow = this.shadow;
        return iHashCode8 + (shadow != null ? shadow.hashCode() : 0);
    }

    public String toString() {
        return "PartialTabsComponent(visible=" + this.visible + ", size=" + this.size + ", padding=" + this.padding + ", margin=" + this.margin + ", backgroundColor=" + this.backgroundColor + ", background=" + this.background + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ')';
    }

    public /* synthetic */ PartialTabsComponent(int i4, Boolean bool, Size size, Padding padding, Padding padding2, ColorScheme colorScheme, Background background, Shape shape, Border border, Shadow shadow, k0 k0Var) {
        this.visible = (i4 & 1) == 0 ? Boolean.TRUE : bool;
        if ((i4 & 2) == 0) {
            this.size = null;
        } else {
            this.size = size;
        }
        if ((i4 & 4) == 0) {
            this.padding = null;
        } else {
            this.padding = padding;
        }
        if ((i4 & 8) == 0) {
            this.margin = null;
        } else {
            this.margin = padding2;
        }
        if ((i4 & 16) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = colorScheme;
        }
        if ((i4 & 32) == 0) {
            this.background = null;
        } else {
            this.background = background;
        }
        if ((i4 & 64) == 0) {
            this.shape = null;
        } else {
            this.shape = shape;
        }
        if ((i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) == 0) {
            this.border = null;
        } else {
            this.border = border;
        }
        if ((i4 & 256) == 0) {
            this.shadow = null;
        } else {
            this.shadow = shadow;
        }
    }

    public PartialTabsComponent(Boolean bool, Size size, Padding padding, Padding padding2, ColorScheme colorScheme, Background background, Shape shape, Border border, Shadow shadow) {
        this.visible = bool;
        this.size = size;
        this.padding = padding;
        this.margin = padding2;
        this.backgroundColor = colorScheme;
        this.background = background;
        this.shape = shape;
        this.border = border;
        this.shadow = shadow;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ PartialTabsComponent(java.lang.Boolean r2, com.revenuecat.purchases.paywalls.components.properties.Size r3, com.revenuecat.purchases.paywalls.components.properties.Padding r4, com.revenuecat.purchases.paywalls.components.properties.Padding r5, com.revenuecat.purchases.paywalls.components.properties.ColorScheme r6, com.revenuecat.purchases.paywalls.components.common.Background r7, com.revenuecat.purchases.paywalls.components.properties.Shape r8, com.revenuecat.purchases.paywalls.components.properties.Border r9, com.revenuecat.purchases.paywalls.components.properties.Shadow r10, int r11, kotlin.jvm.internal.AbstractC1585j r12) {
        /*
            r1 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L6
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
        L6:
            r12 = r11 & 2
            r0 = 0
            if (r12 == 0) goto Lc
            r3 = r0
        Lc:
            r12 = r11 & 4
            if (r12 == 0) goto L11
            r4 = r0
        L11:
            r12 = r11 & 8
            if (r12 == 0) goto L16
            r5 = r0
        L16:
            r12 = r11 & 16
            if (r12 == 0) goto L1b
            r6 = r0
        L1b:
            r12 = r11 & 32
            if (r12 == 0) goto L20
            r7 = r0
        L20:
            r12 = r11 & 64
            if (r12 == 0) goto L25
            r8 = r0
        L25:
            r12 = r11 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L2a
            r9 = r0
        L2a:
            r11 = r11 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L39
            r12 = r0
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L43
        L39:
            r12 = r10
            r11 = r9
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L43:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.paywalls.components.PartialTabsComponent.<init>(java.lang.Boolean, com.revenuecat.purchases.paywalls.components.properties.Size, com.revenuecat.purchases.paywalls.components.properties.Padding, com.revenuecat.purchases.paywalls.components.properties.Padding, com.revenuecat.purchases.paywalls.components.properties.ColorScheme, com.revenuecat.purchases.paywalls.components.common.Background, com.revenuecat.purchases.paywalls.components.properties.Shape, com.revenuecat.purchases.paywalls.components.properties.Border, com.revenuecat.purchases.paywalls.components.properties.Shadow, int, kotlin.jvm.internal.j):void");
    }
}
