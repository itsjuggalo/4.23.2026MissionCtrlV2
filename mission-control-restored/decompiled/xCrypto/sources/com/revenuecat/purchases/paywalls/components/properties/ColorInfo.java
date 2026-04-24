package com.revenuecat.purchases.paywalls.components.properties;

import F3.b;
import F3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.C0332e;
import J3.k0;
import com.revenuecat.purchases.ColorAlias;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.r;
import p3.InterfaceC1716c;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public interface ColorInfo {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Alias implements ColorInfo {
        public static final Companion Companion = new Companion(null);
        private final String value;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return ColorInfo$Alias$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ Alias(int i4, String str, k0 k0Var, AbstractC1585j abstractC1585j) {
            this(i4, str, k0Var);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Alias) && ColorAlias.m45equalsimpl0(this.value, ((Alias) obj).value);
        }

        /* JADX INFO: renamed from: getValue-671NwFM, reason: not valid java name */
        public final /* synthetic */ String m204getValue671NwFM() {
            return this.value;
        }

        public int hashCode() {
            return ColorAlias.m46hashCodeimpl(this.value);
        }

        public String toString() {
            return "Alias(value=" + ((Object) ColorAlias.m47toStringimpl(this.value)) + ')';
        }

        public /* synthetic */ Alias(String str, AbstractC1585j abstractC1585j) {
            this(str);
        }

        private Alias(int i4, String str, k0 k0Var) {
            if (1 != (i4 & 1)) {
                AbstractC0325a0.a(i4, 1, ColorInfo$Alias$$serializer.INSTANCE.getDescriptor());
            }
            this.value = str;
        }

        private Alias(String value) {
            r.f(value, "value");
            this.value = value;
        }
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final b serializer() {
            return new e("com.revenuecat.purchases.paywalls.components.properties.ColorInfo", G.b(ColorInfo.class), new InterfaceC1716c[]{G.b(Alias.class), G.b(Gradient.Linear.class), G.b(Gradient.Radial.class), G.b(Hex.class)}, new b[]{ColorInfo$Alias$$serializer.INSTANCE, ColorInfo$Gradient$Linear$$serializer.INSTANCE, ColorInfo$Gradient$Radial$$serializer.INSTANCE, ColorInfo$Hex$$serializer.INSTANCE}, new Annotation[0]);
        }
    }

    public interface Gradient extends ColorInfo {

        public static final class Radial implements Gradient {
            private final List<Point> points;
            public static final Companion Companion = new Companion(null);
            private static final b[] $childSerializers = {new C0332e(ColorInfo$Gradient$Point$$serializer.INSTANCE)};

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                    this();
                }

                public final b serializer() {
                    return ColorInfo$Gradient$Radial$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public /* synthetic */ Radial(int i4, List list, k0 k0Var) {
                if (1 != (i4 & 1)) {
                    AbstractC0325a0.a(i4, 1, ColorInfo$Gradient$Radial$$serializer.INSTANCE.getDescriptor());
                }
                this.points = list;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Radial) && r.b(this.points, ((Radial) obj).points);
            }

            public final /* synthetic */ List getPoints() {
                return this.points;
            }

            public int hashCode() {
                return this.points.hashCode();
            }

            public String toString() {
                return "Radial(points=" + this.points + ')';
            }

            public Radial(List<Point> points) {
                r.f(points, "points");
                this.points = points;
            }
        }

        public static final class Linear implements Gradient {
            private final float degrees;
            private final List<Point> points;
            public static final Companion Companion = new Companion(null);
            private static final b[] $childSerializers = {null, new C0332e(ColorInfo$Gradient$Point$$serializer.INSTANCE)};

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                    this();
                }

                public final b serializer() {
                    return ColorInfo$Gradient$Linear$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public Linear(float f4, List<Point> points) {
                r.f(points, "points");
                this.degrees = f4;
                this.points = points;
            }

            public static final /* synthetic */ void write$Self(Linear linear, d dVar, H3.e eVar) {
                b[] bVarArr = $childSerializers;
                dVar.t(eVar, 0, linear.degrees);
                dVar.u(eVar, 1, bVarArr[1], linear.points);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Linear)) {
                    return false;
                }
                Linear linear = (Linear) obj;
                return Float.compare(this.degrees, linear.degrees) == 0 && r.b(this.points, linear.points);
            }

            public final /* synthetic */ float getDegrees() {
                return this.degrees;
            }

            public final /* synthetic */ List getPoints() {
                return this.points;
            }

            public int hashCode() {
                return (Float.hashCode(this.degrees) * 31) + this.points.hashCode();
            }

            public String toString() {
                return "Linear(degrees=" + this.degrees + ", points=" + this.points + ')';
            }

            public /* synthetic */ Linear(int i4, float f4, List list, k0 k0Var) {
                if (3 != (i4 & 3)) {
                    AbstractC0325a0.a(i4, 3, ColorInfo$Gradient$Linear$$serializer.INSTANCE.getDescriptor());
                }
                this.degrees = f4;
                this.points = list;
            }
        }

        public static final class Point {
            public static final Companion Companion = new Companion(null);
            private final int color;
            private final float percent;

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                    this();
                }

                public final b serializer() {
                    return ColorInfo$Gradient$Point$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public Point(int i4, float f4) {
                this.color = i4;
                this.percent = f4;
            }

            public static /* synthetic */ void getColor$annotations() {
            }

            public static final /* synthetic */ void write$Self(Point point, d dVar, H3.e eVar) {
                dVar.u(eVar, 0, RgbaStringArgbColorIntDeserializer.INSTANCE, Integer.valueOf(point.color));
                dVar.t(eVar, 1, point.percent);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Point)) {
                    return false;
                }
                Point point = (Point) obj;
                return this.color == point.color && Float.compare(this.percent, point.percent) == 0;
            }

            public final /* synthetic */ int getColor() {
                return this.color;
            }

            public final /* synthetic */ float getPercent() {
                return this.percent;
            }

            public int hashCode() {
                return (Integer.hashCode(this.color) * 31) + Float.hashCode(this.percent);
            }

            public String toString() {
                return "Point(color=" + this.color + ", percent=" + this.percent + ')';
            }

            public /* synthetic */ Point(int i4, int i5, float f4, k0 k0Var) {
                if (3 != (i4 & 3)) {
                    AbstractC0325a0.a(i4, 3, ColorInfo$Gradient$Point$$serializer.INSTANCE.getDescriptor());
                }
                this.color = i5;
                this.percent = f4;
            }
        }
    }

    public static final class Hex implements ColorInfo {
        public static final Companion Companion = new Companion(null);
        private final int value;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return ColorInfo$Hex$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public Hex(int i4) {
            this.value = i4;
        }

        public static /* synthetic */ void getValue$annotations() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Hex) && this.value == ((Hex) obj).value;
        }

        public final /* synthetic */ int getValue() {
            return this.value;
        }

        public int hashCode() {
            return Integer.hashCode(this.value);
        }

        public String toString() {
            return "Hex(value=" + this.value + ')';
        }

        public /* synthetic */ Hex(int i4, int i5, k0 k0Var) {
            if (1 != (i4 & 1)) {
                AbstractC0325a0.a(i4, 1, ColorInfo$Hex$$serializer.INSTANCE.getDescriptor());
            }
            this.value = i5;
        }
    }
}
