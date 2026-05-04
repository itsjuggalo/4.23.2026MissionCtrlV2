package com.revenuecat.purchases.customercenter;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer;
import dh.e0;
import dh.j1;
import dh.s1;
import dh.w1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/customercenter/CustomerCenterConfigData.Screen.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomerCenterConfigData$Screen$$serializer implements e0 {
    public static final CustomerCenterConfigData$Screen$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        CustomerCenterConfigData$Screen$$serializer customerCenterConfigData$Screen$$serializer = new CustomerCenterConfigData$Screen$$serializer();
        INSTANCE = customerCenterConfigData$Screen$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Screen", customerCenterConfigData$Screen$$serializer, 5);
        j1Var.g("type", false);
        j1Var.g(b.S, false);
        j1Var.g("subtitle", true);
        j1Var.g("paths", false);
        j1Var.g("offering", true);
        descriptor = j1Var;
    }

    private CustomerCenterConfigData$Screen$$serializer() {
    }

    @Override // dh.e0
    public zg.b[] childSerializers() {
        return new zg.b[]{CustomerCenterConfigData.Screen.$childSerializers[0], w1.f8244a, a.p(EmptyStringToNullSerializer.INSTANCE), HelpPathsSerializer.INSTANCE, a.p(CustomerCenterConfigData$ScreenOffering$$serializer.INSTANCE)};
    }

    @Override // zg.a
    public CustomerCenterConfigData.Screen deserialize(e decoder) {
        int i10;
        CustomerCenterConfigData.Screen.ScreenType screenType;
        String str;
        String str2;
        List list;
        CustomerCenterConfigData.ScreenOffering screenOffering;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        zg.b[] bVarArr = CustomerCenterConfigData.Screen.$childSerializers;
        int i11 = 0;
        CustomerCenterConfigData.Screen.ScreenType screenType2 = null;
        if (cVarB.z()) {
            CustomerCenterConfigData.Screen.ScreenType screenType3 = (CustomerCenterConfigData.Screen.ScreenType) cVarB.h(descriptor2, 0, bVarArr[0], null);
            String strS = cVarB.s(descriptor2, 1);
            String str3 = (String) cVarB.n(descriptor2, 2, EmptyStringToNullSerializer.INSTANCE, null);
            screenType = screenType3;
            str = strS;
            list = (List) cVarB.h(descriptor2, 3, HelpPathsSerializer.INSTANCE, null);
            screenOffering = (CustomerCenterConfigData.ScreenOffering) cVarB.n(descriptor2, 4, CustomerCenterConfigData$ScreenOffering$$serializer.INSTANCE, null);
            str2 = str3;
            i10 = 31;
        } else {
            int i12 = 1;
            int i13 = 0;
            String strS2 = null;
            String str4 = null;
            List list2 = null;
            CustomerCenterConfigData.ScreenOffering screenOffering2 = null;
            while (i12 != 0) {
                int iW = cVarB.w(descriptor2);
                int i14 = i11;
                if (iW == -1) {
                    i11 = i14;
                    i12 = i11;
                } else if (iW != 0) {
                    if (iW == 1) {
                        strS2 = cVarB.s(descriptor2, 1);
                        i13 |= 2;
                    } else if (iW == 2) {
                        str4 = (String) cVarB.n(descriptor2, 2, EmptyStringToNullSerializer.INSTANCE, str4);
                        i13 |= 4;
                    } else if (iW == 3) {
                        list2 = (List) cVarB.h(descriptor2, 3, HelpPathsSerializer.INSTANCE, list2);
                        i13 |= 8;
                    } else {
                        if (iW != 4) {
                            throw new m(iW);
                        }
                        screenOffering2 = (CustomerCenterConfigData.ScreenOffering) cVarB.n(descriptor2, 4, CustomerCenterConfigData$ScreenOffering$$serializer.INSTANCE, screenOffering2);
                        i13 |= 16;
                    }
                    i11 = i14;
                } else {
                    screenType2 = (CustomerCenterConfigData.Screen.ScreenType) cVarB.h(descriptor2, i14, bVarArr[i14], screenType2);
                    i13 |= 1;
                    i11 = i14;
                }
            }
            i10 = i13;
            screenType = screenType2;
            str = strS2;
            str2 = str4;
            list = list2;
            screenOffering = screenOffering2;
        }
        cVarB.c(descriptor2);
        return new CustomerCenterConfigData.Screen(i10, screenType, str, str2, list, screenOffering, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, CustomerCenterConfigData.Screen value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        CustomerCenterConfigData.Screen.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public zg.b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
