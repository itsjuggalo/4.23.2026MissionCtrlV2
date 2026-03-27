package com.revenuecat.purchases.paywalls.components;

import F3.b;
import F3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.C0332e;
import J3.C0335h;
import J3.k0;
import X2.AbstractC0769p;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
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
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.r;
import p3.InterfaceC1716c;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class TabsComponent implements PaywallComponent {
    private final Background background;
    private final ColorScheme backgroundColor;
    private final Border border;
    private final TabControl control;
    private final Padding margin;
    private final List<ComponentOverride<PartialTabsComponent>> overrides;
    private final Padding padding;
    private final Shadow shadow;
    private final Shape shape;
    private final Size size;
    private final List<Tab> tabs;
    private final Boolean visible;
    public static final Companion Companion = new Companion(null);
    private static final b[] $childSerializers = {null, null, null, null, null, null, null, null, null, new e("com.revenuecat.purchases.paywalls.components.TabsComponent.TabControl", G.b(TabControl.class), new InterfaceC1716c[]{G.b(TabControl.Buttons.class), G.b(TabControl.Toggle.class)}, new b[]{TabsComponent$TabControl$Buttons$$serializer.INSTANCE, TabsComponent$TabControl$Toggle$$serializer.INSTANCE}, new Annotation[0]), new C0332e(TabsComponent$Tab$$serializer.INSTANCE), new C0332e(ComponentOverride.Companion.serializer(PartialTabsComponent$$serializer.INSTANCE))};

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return TabsComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @InternalRevenueCatAPI
    public static final class Tab {
        public static final Companion Companion = new Companion(null);
        private final StackComponent stack;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return TabsComponent$Tab$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ Tab(int i4, StackComponent stackComponent, k0 k0Var) {
            if (1 != (i4 & 1)) {
                AbstractC0325a0.a(i4, 1, TabsComponent$Tab$$serializer.INSTANCE.getDescriptor());
            }
            this.stack = stackComponent;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Tab) && r.b(this.stack, ((Tab) obj).stack);
        }

        public final /* synthetic */ StackComponent getStack() {
            return this.stack;
        }

        public int hashCode() {
            return this.stack.hashCode();
        }

        public String toString() {
            return "Tab(stack=" + this.stack + ')';
        }

        public Tab(StackComponent stack) {
            r.f(stack, "stack");
            this.stack = stack;
        }
    }

    @InternalRevenueCatAPI
    public interface TabControl {
        public static final Companion Companion = Companion.$$INSTANCE;

        @InternalRevenueCatAPI
        public static final class Buttons implements TabControl {
            public static final Companion Companion = new Companion(null);
            private final StackComponent stack;

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                    this();
                }

                public final b serializer() {
                    return TabsComponent$TabControl$Buttons$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public /* synthetic */ Buttons(int i4, StackComponent stackComponent, k0 k0Var) {
                if (1 != (i4 & 1)) {
                    AbstractC0325a0.a(i4, 1, TabsComponent$TabControl$Buttons$$serializer.INSTANCE.getDescriptor());
                }
                this.stack = stackComponent;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Buttons) && r.b(this.stack, ((Buttons) obj).stack);
            }

            public final /* synthetic */ StackComponent getStack() {
                return this.stack;
            }

            public int hashCode() {
                return this.stack.hashCode();
            }

            public String toString() {
                return "Buttons(stack=" + this.stack + ')';
            }

            public Buttons(StackComponent stack) {
                r.f(stack, "stack");
                this.stack = stack;
            }
        }

        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final b serializer() {
                return new e("com.revenuecat.purchases.paywalls.components.TabsComponent.TabControl", G.b(TabControl.class), new InterfaceC1716c[]{G.b(Buttons.class), G.b(Toggle.class)}, new b[]{TabsComponent$TabControl$Buttons$$serializer.INSTANCE, TabsComponent$TabControl$Toggle$$serializer.INSTANCE}, new Annotation[0]);
            }
        }

        @InternalRevenueCatAPI
        public static final class Toggle implements TabControl {
            public static final Companion Companion = new Companion(null);
            private final StackComponent stack;

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                    this();
                }

                public final b serializer() {
                    return TabsComponent$TabControl$Toggle$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public /* synthetic */ Toggle(int i4, StackComponent stackComponent, k0 k0Var) {
                if (1 != (i4 & 1)) {
                    AbstractC0325a0.a(i4, 1, TabsComponent$TabControl$Toggle$$serializer.INSTANCE.getDescriptor());
                }
                this.stack = stackComponent;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Toggle) && r.b(this.stack, ((Toggle) obj).stack);
            }

            public final /* synthetic */ StackComponent getStack() {
                return this.stack;
            }

            public int hashCode() {
                return this.stack.hashCode();
            }

            public String toString() {
                return "Toggle(stack=" + this.stack + ')';
            }

            public Toggle(StackComponent stack) {
                r.f(stack, "stack");
                this.stack = stack;
            }
        }
    }

    public /* synthetic */ TabsComponent(int i4, Boolean bool, Size size, Padding padding, Padding padding2, ColorScheme colorScheme, Background background, Shape shape, Border border, Shadow shadow, TabControl tabControl, List list, List list2, k0 k0Var) {
        if (1536 != (i4 & 1536)) {
            AbstractC0325a0.a(i4, 1536, TabsComponent$$serializer.INSTANCE.getDescriptor());
        }
        if ((i4 & 1) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i4 & 2) == 0) {
            this.size = new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE);
        } else {
            this.size = size;
        }
        if ((i4 & 4) == 0) {
            this.padding = Padding.Companion.getZero();
        } else {
            this.padding = padding;
        }
        if ((i4 & 8) == 0) {
            this.margin = Padding.Companion.getZero();
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
        this.control = tabControl;
        this.tabs = list;
        if ((i4 & 2048) == 0) {
            this.overrides = AbstractC0769p.g();
        } else {
            this.overrides = list2;
        }
    }

    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    public static final /* synthetic */ void write$Self(TabsComponent tabsComponent, d dVar, H3.e eVar) {
        b[] bVarArr = $childSerializers;
        if (dVar.j(eVar, 0) || tabsComponent.visible != null) {
            dVar.E(eVar, 0, C0335h.f929a, tabsComponent.visible);
        }
        if (dVar.j(eVar, 1) || !r.b(tabsComponent.size, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE))) {
            dVar.u(eVar, 1, Size$$serializer.INSTANCE, tabsComponent.size);
        }
        if (dVar.j(eVar, 2) || !r.b(tabsComponent.padding, Padding.Companion.getZero())) {
            dVar.u(eVar, 2, Padding$$serializer.INSTANCE, tabsComponent.padding);
        }
        if (dVar.j(eVar, 3) || !r.b(tabsComponent.margin, Padding.Companion.getZero())) {
            dVar.u(eVar, 3, Padding$$serializer.INSTANCE, tabsComponent.margin);
        }
        if (dVar.j(eVar, 4) || tabsComponent.backgroundColor != null) {
            dVar.E(eVar, 4, ColorScheme$$serializer.INSTANCE, tabsComponent.backgroundColor);
        }
        if (dVar.j(eVar, 5) || tabsComponent.background != null) {
            dVar.E(eVar, 5, BackgroundDeserializer.INSTANCE, tabsComponent.background);
        }
        if (dVar.j(eVar, 6) || tabsComponent.shape != null) {
            dVar.E(eVar, 6, ShapeDeserializer.INSTANCE, tabsComponent.shape);
        }
        if (dVar.j(eVar, 7) || tabsComponent.border != null) {
            dVar.E(eVar, 7, Border$$serializer.INSTANCE, tabsComponent.border);
        }
        if (dVar.j(eVar, 8) || tabsComponent.shadow != null) {
            dVar.E(eVar, 8, Shadow$$serializer.INSTANCE, tabsComponent.shadow);
        }
        dVar.u(eVar, 9, bVarArr[9], tabsComponent.control);
        dVar.u(eVar, 10, bVarArr[10], tabsComponent.tabs);
        if (!dVar.j(eVar, 11) && r.b(tabsComponent.overrides, AbstractC0769p.g())) {
            return;
        }
        dVar.u(eVar, 11, bVarArr[11], tabsComponent.overrides);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabsComponent)) {
            return false;
        }
        TabsComponent tabsComponent = (TabsComponent) obj;
        return r.b(this.visible, tabsComponent.visible) && r.b(this.size, tabsComponent.size) && r.b(this.padding, tabsComponent.padding) && r.b(this.margin, tabsComponent.margin) && r.b(this.backgroundColor, tabsComponent.backgroundColor) && r.b(this.background, tabsComponent.background) && r.b(this.shape, tabsComponent.shape) && r.b(this.border, tabsComponent.border) && r.b(this.shadow, tabsComponent.shadow) && r.b(this.control, tabsComponent.control) && r.b(this.tabs, tabsComponent.tabs) && r.b(this.overrides, tabsComponent.overrides);
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

    public final /* synthetic */ TabControl getControl() {
        return this.control;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
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

    public final /* synthetic */ List getTabs() {
        return this.tabs;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        Boolean bool = this.visible;
        int iHashCode = (((((((bool == null ? 0 : bool.hashCode()) * 31) + this.size.hashCode()) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31;
        ColorScheme colorScheme = this.backgroundColor;
        int iHashCode2 = (iHashCode + (colorScheme == null ? 0 : colorScheme.hashCode())) * 31;
        Background background = this.background;
        int iHashCode3 = (iHashCode2 + (background == null ? 0 : background.hashCode())) * 31;
        Shape shape = this.shape;
        int iHashCode4 = (iHashCode3 + (shape == null ? 0 : shape.hashCode())) * 31;
        Border border = this.border;
        int iHashCode5 = (iHashCode4 + (border == null ? 0 : border.hashCode())) * 31;
        Shadow shadow = this.shadow;
        return ((((((iHashCode5 + (shadow != null ? shadow.hashCode() : 0)) * 31) + this.control.hashCode()) * 31) + this.tabs.hashCode()) * 31) + this.overrides.hashCode();
    }

    public String toString() {
        return "TabsComponent(visible=" + this.visible + ", size=" + this.size + ", padding=" + this.padding + ", margin=" + this.margin + ", backgroundColor=" + this.backgroundColor + ", background=" + this.background + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", control=" + this.control + ", tabs=" + this.tabs + ", overrides=" + this.overrides + ')';
    }

    public TabsComponent(Boolean bool, Size size, Padding padding, Padding margin, ColorScheme colorScheme, Background background, Shape shape, Border border, Shadow shadow, TabControl control, List<Tab> tabs, List<ComponentOverride<PartialTabsComponent>> overrides) {
        r.f(size, "size");
        r.f(padding, "padding");
        r.f(margin, "margin");
        r.f(control, "control");
        r.f(tabs, "tabs");
        r.f(overrides, "overrides");
        this.visible = bool;
        this.size = size;
        this.padding = padding;
        this.margin = margin;
        this.backgroundColor = colorScheme;
        this.background = background;
        this.shape = shape;
        this.border = border;
        this.shadow = shadow;
        this.control = control;
        this.tabs = tabs;
        this.overrides = overrides;
    }

    public /* synthetic */ TabsComponent(Boolean bool, Size size, Padding padding, Padding padding2, ColorScheme colorScheme, Background background, Shape shape, Border border, Shadow shadow, TabControl tabControl, List list, List list2, int i4, AbstractC1585j abstractC1585j) {
        this((i4 & 1) != 0 ? null : bool, (i4 & 2) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE) : size, (i4 & 4) != 0 ? Padding.Companion.getZero() : padding, (i4 & 8) != 0 ? Padding.Companion.getZero() : padding2, (i4 & 16) != 0 ? null : colorScheme, (i4 & 32) != 0 ? null : background, (i4 & 64) != 0 ? null : shape, (i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0 ? null : border, (i4 & 256) != 0 ? null : shadow, tabControl, list, (i4 & 2048) != 0 ? AbstractC0769p.g() : list2);
    }
}
