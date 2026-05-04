package com.revenuecat.purchases.paywalls.components;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.paywalls.components.TabsComponent;
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
import dh.e0;
import dh.h;
import dh.j1;
import dh.s1;
import dh.w1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/TabsComponent.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/TabsComponent;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/TabsComponent;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/TabsComponent;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TabsComponent$$serializer implements e0 {
    public static final TabsComponent$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        TabsComponent$$serializer tabsComponent$$serializer = new TabsComponent$$serializer();
        INSTANCE = tabsComponent$$serializer;
        j1 j1Var = new j1("tabs", tabsComponent$$serializer, 13);
        j1Var.g("visible", true);
        j1Var.g("size", true);
        j1Var.g("padding", true);
        j1Var.g("margin", true);
        j1Var.g("background_color", true);
        j1Var.g("background", true);
        j1Var.g("shape", true);
        j1Var.g("border", true);
        j1Var.g("shadow", true);
        j1Var.g("control", false);
        j1Var.g("tabs", false);
        j1Var.g("default_tab_id", true);
        j1Var.g("overrides", true);
        descriptor = j1Var;
    }

    private TabsComponent$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b[] bVarArr = TabsComponent.$childSerializers;
        b bVarP = a.p(h.f8149a);
        b bVarP2 = a.p(ColorScheme$$serializer.INSTANCE);
        b bVarP3 = a.p(BackgroundDeserializer.INSTANCE);
        b bVarP4 = a.p(ShapeDeserializer.INSTANCE);
        b bVarP5 = a.p(Border$$serializer.INSTANCE);
        b bVarP6 = a.p(Shadow$$serializer.INSTANCE);
        b bVar = bVarArr[9];
        b bVar2 = bVarArr[10];
        b bVarP7 = a.p(w1.f8244a);
        b bVar3 = bVarArr[12];
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{bVarP, Size$$serializer.INSTANCE, padding$$serializer, padding$$serializer, bVarP2, bVarP3, bVarP4, bVarP5, bVarP6, bVar, bVar2, bVarP7, bVar3};
    }

    @Override // zg.a
    public TabsComponent deserialize(e decoder) {
        int i10;
        Size size;
        TabsComponent.TabControl tabControl;
        Shadow shadow;
        Border border;
        Background background;
        List list;
        Shape shape;
        ColorScheme colorScheme;
        Boolean bool;
        String str;
        Padding padding;
        List list2;
        Padding padding2;
        Boolean bool2;
        List list3;
        int i11;
        List list4;
        Padding padding3;
        int i12;
        List list5;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        b[] bVarArr = TabsComponent.$childSerializers;
        Boolean bool3 = null;
        if (cVarB.z()) {
            Boolean bool4 = (Boolean) cVarB.n(descriptor2, 0, h.f8149a, null);
            Size size2 = (Size) cVarB.h(descriptor2, 1, Size$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding4 = (Padding) cVarB.h(descriptor2, 2, padding$$serializer, null);
            Padding padding5 = (Padding) cVarB.h(descriptor2, 3, padding$$serializer, null);
            ColorScheme colorScheme2 = (ColorScheme) cVarB.n(descriptor2, 4, ColorScheme$$serializer.INSTANCE, null);
            Background background2 = (Background) cVarB.n(descriptor2, 5, BackgroundDeserializer.INSTANCE, null);
            Shape shape2 = (Shape) cVarB.n(descriptor2, 6, ShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) cVarB.n(descriptor2, 7, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) cVarB.n(descriptor2, 8, Shadow$$serializer.INSTANCE, null);
            TabsComponent.TabControl tabControl2 = (TabsComponent.TabControl) cVarB.h(descriptor2, 9, bVarArr[9], null);
            List list6 = (List) cVarB.h(descriptor2, 10, bVarArr[10], null);
            i10 = 8191;
            str = (String) cVarB.n(descriptor2, 11, w1.f8244a, null);
            bool = bool4;
            list2 = (List) cVarB.h(descriptor2, 12, bVarArr[12], null);
            border = border2;
            shape = shape2;
            background = background2;
            padding = padding5;
            shadow = shadow2;
            colorScheme = colorScheme2;
            padding2 = padding4;
            list = list6;
            tabControl = tabControl2;
            size = size2;
        } else {
            int i13 = 12;
            int i14 = 0;
            Padding padding6 = null;
            Size size3 = null;
            TabsComponent.TabControl tabControl3 = null;
            Shadow shadow3 = null;
            Border border3 = null;
            Background background3 = null;
            List list7 = null;
            Shape shape3 = null;
            ColorScheme colorScheme3 = null;
            int i15 = 10;
            int i16 = 9;
            boolean z10 = true;
            List list8 = null;
            String str2 = null;
            Padding padding7 = null;
            while (z10) {
                int i17 = i13;
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        padding3 = padding6;
                        i12 = i14;
                        list5 = list8;
                        z10 = false;
                        list8 = list5;
                        padding6 = padding3;
                        i16 = 9;
                        i15 = 10;
                        i14 = i12;
                        i13 = 12;
                        break;
                    case 0:
                        int i18 = i14;
                        list5 = list8;
                        padding3 = padding6;
                        bool3 = (Boolean) cVarB.n(descriptor2, 0, h.f8149a, bool3);
                        i12 = i18 | 1;
                        list8 = list5;
                        padding6 = padding3;
                        i16 = 9;
                        i15 = 10;
                        i14 = i12;
                        i13 = 12;
                        break;
                    case 1:
                        bool2 = bool3;
                        int i19 = i14;
                        list3 = list8;
                        size3 = (Size) cVarB.h(descriptor2, 1, Size$$serializer.INSTANCE, size3);
                        i11 = i19 | 2;
                        list8 = list3;
                        i13 = 12;
                        i16 = 9;
                        i15 = 10;
                        i14 = i11;
                        bool3 = bool2;
                        break;
                    case 2:
                        bool2 = bool3;
                        int i20 = i14;
                        list3 = list8;
                        padding6 = (Padding) cVarB.h(descriptor2, 2, Padding$$serializer.INSTANCE, padding6);
                        i11 = i20 | 4;
                        list8 = list3;
                        i13 = 12;
                        i16 = 9;
                        i15 = 10;
                        i14 = i11;
                        bool3 = bool2;
                        break;
                    case 3:
                        bool2 = bool3;
                        int i21 = i14;
                        list3 = list8;
                        padding7 = (Padding) cVarB.h(descriptor2, 3, Padding$$serializer.INSTANCE, padding7);
                        i11 = i21 | 8;
                        list8 = list3;
                        i13 = 12;
                        i16 = 9;
                        i15 = 10;
                        i14 = i11;
                        bool3 = bool2;
                        break;
                    case 4:
                        bool2 = bool3;
                        int i22 = i14;
                        list3 = list8;
                        colorScheme3 = (ColorScheme) cVarB.n(descriptor2, 4, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i11 = i22 | 16;
                        list8 = list3;
                        i13 = 12;
                        i16 = 9;
                        i15 = 10;
                        i14 = i11;
                        bool3 = bool2;
                        break;
                    case 5:
                        bool2 = bool3;
                        int i23 = i14;
                        list3 = list8;
                        background3 = (Background) cVarB.n(descriptor2, 5, BackgroundDeserializer.INSTANCE, background3);
                        i11 = i23 | 32;
                        list8 = list3;
                        i13 = 12;
                        i16 = 9;
                        i15 = 10;
                        i14 = i11;
                        bool3 = bool2;
                        break;
                    case 6:
                        bool2 = bool3;
                        int i24 = i14;
                        list3 = list8;
                        shape3 = (Shape) cVarB.n(descriptor2, 6, ShapeDeserializer.INSTANCE, shape3);
                        i11 = i24 | 64;
                        list8 = list3;
                        i13 = 12;
                        i16 = 9;
                        i15 = 10;
                        i14 = i11;
                        bool3 = bool2;
                        break;
                    case 7:
                        bool2 = bool3;
                        int i25 = i14;
                        list3 = list8;
                        border3 = (Border) cVarB.n(descriptor2, 7, Border$$serializer.INSTANCE, border3);
                        i11 = i25 | 128;
                        list8 = list3;
                        i13 = 12;
                        i16 = 9;
                        i15 = 10;
                        i14 = i11;
                        bool3 = bool2;
                        break;
                    case 8:
                        bool2 = bool3;
                        int i26 = i14;
                        list3 = list8;
                        shadow3 = (Shadow) cVarB.n(descriptor2, 8, Shadow$$serializer.INSTANCE, shadow3);
                        i11 = i26 | 256;
                        list8 = list3;
                        i13 = 12;
                        i16 = 9;
                        i15 = 10;
                        i14 = i11;
                        bool3 = bool2;
                        break;
                    case 9:
                        bool2 = bool3;
                        int i27 = i14;
                        tabControl3 = (TabsComponent.TabControl) cVarB.h(descriptor2, i16, bVarArr[i16], tabControl3);
                        i11 = i27 | 512;
                        list8 = list8;
                        i13 = 12;
                        i15 = 10;
                        i14 = i11;
                        bool3 = bool2;
                        break;
                    case 10:
                        bool2 = bool3;
                        int i28 = i14;
                        list4 = list8;
                        list7 = (List) cVarB.h(descriptor2, i15, bVarArr[i15], list7);
                        i11 = i28 | 1024;
                        list8 = list4;
                        i13 = 12;
                        i14 = i11;
                        bool3 = bool2;
                        break;
                    case 11:
                        bool2 = bool3;
                        int i29 = i14;
                        list4 = list8;
                        str2 = (String) cVarB.n(descriptor2, 11, w1.f8244a, str2);
                        i11 = i29 | 2048;
                        list8 = list4;
                        i13 = 12;
                        i14 = i11;
                        bool3 = bool2;
                        break;
                    case 12:
                        bool2 = bool3;
                        list8 = (List) cVarB.h(descriptor2, i17, bVarArr[i17], list8);
                        i14 |= 4096;
                        i13 = i17;
                        bool3 = bool2;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            i10 = i14;
            size = size3;
            tabControl = tabControl3;
            shadow = shadow3;
            border = border3;
            background = background3;
            list = list7;
            shape = shape3;
            colorScheme = colorScheme3;
            bool = bool3;
            str = str2;
            padding = padding7;
            list2 = list8;
            padding2 = padding6;
        }
        int i30 = i10;
        cVarB.c(descriptor2);
        return new TabsComponent(i30, bool, size, padding2, padding, colorScheme, background, shape, border, shadow, tabControl, list, str, list2, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, TabsComponent value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        TabsComponent.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
