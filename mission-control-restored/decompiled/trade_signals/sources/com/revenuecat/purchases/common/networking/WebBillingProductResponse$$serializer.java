package com.revenuecat.purchases.common.networking;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.util.Map;
import k7.m;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import l7.a;
import n7.c;
import n7.d;
import n7.e;
import n7.f;
import o7.C2514k0;
import o7.E;
import o7.t0;
import o7.x0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/common/networking/WebBillingProductResponse.$serializer", "Lo7/E;", "Lcom/revenuecat/purchases/common/networking/WebBillingProductResponse;", "<init>", "()V", "", "Lk7/b;", "childSerializers", "()[Lk7/b;", "Ln7/e;", "decoder", "deserialize", "(Ln7/e;)Lcom/revenuecat/purchases/common/networking/WebBillingProductResponse;", "Ln7/f;", "encoder", "value", "Lo5/H;", "serialize", "(Ln7/f;Lcom/revenuecat/purchases/common/networking/WebBillingProductResponse;)V", "Lm7/e;", "getDescriptor", "()Lm7/e;", "descriptor", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public final class WebBillingProductResponse$$serializer implements E {
    public static final WebBillingProductResponse$$serializer INSTANCE;
    private static final /* synthetic */ C2514k0 descriptor;

    static {
        WebBillingProductResponse$$serializer webBillingProductResponse$$serializer = new WebBillingProductResponse$$serializer();
        INSTANCE = webBillingProductResponse$$serializer;
        C2514k0 c2514k0 = new C2514k0("com.revenuecat.purchases.common.networking.WebBillingProductResponse", webBillingProductResponse$$serializer, 6);
        c2514k0.p("identifier", false);
        c2514k0.p(DiagnosticsTracker.PRODUCT_TYPE_KEY, false);
        c2514k0.p(b.f14041S, false);
        c2514k0.p(b.f14051c, true);
        c2514k0.p("default_purchase_option_id", true);
        c2514k0.p("purchase_options", false);
        descriptor = c2514k0;
    }

    private WebBillingProductResponse$$serializer() {
    }

    @Override // o7.E
    public k7.b[] childSerializers() {
        k7.b[] bVarArr = WebBillingProductResponse.$childSerializers;
        x0 x0Var = x0.f22227a;
        return new k7.b[]{x0Var, x0Var, x0Var, a.p(x0Var), a.p(x0Var), bVarArr[5]};
    }

    @Override // k7.a
    public WebBillingProductResponse deserialize(e decoder) {
        int i8;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Map map;
        AbstractC2304t.f(decoder, "decoder");
        m7.e descriptor2 = getDescriptor();
        c cVarC = decoder.c(descriptor2);
        k7.b[] bVarArr = WebBillingProductResponse.$childSerializers;
        String strJ = null;
        if (cVarC.w()) {
            String strJ2 = cVarC.j(descriptor2, 0);
            String strJ3 = cVarC.j(descriptor2, 1);
            String strJ4 = cVarC.j(descriptor2, 2);
            x0 x0Var = x0.f22227a;
            String str6 = (String) cVarC.z(descriptor2, 3, x0Var, null);
            String str7 = (String) cVarC.z(descriptor2, 4, x0Var, null);
            map = (Map) cVarC.u(descriptor2, 5, bVarArr[5], null);
            str = strJ2;
            str4 = str6;
            str5 = str7;
            str3 = strJ4;
            i8 = 63;
            str2 = strJ3;
        } else {
            boolean z7 = true;
            int i9 = 0;
            String strJ5 = null;
            String strJ6 = null;
            String str8 = null;
            String str9 = null;
            Map map2 = null;
            while (z7) {
                int iE = cVarC.E(descriptor2);
                switch (iE) {
                    case -1:
                        z7 = false;
                        continue;
                    case 0:
                        strJ = cVarC.j(descriptor2, 0);
                        i9 |= 1;
                        continue;
                    case 1:
                        strJ5 = cVarC.j(descriptor2, 1);
                        i9 |= 2;
                        break;
                    case 2:
                        strJ6 = cVarC.j(descriptor2, 2);
                        i9 |= 4;
                        break;
                    case 3:
                        str8 = (String) cVarC.z(descriptor2, 3, x0.f22227a, str8);
                        i9 |= 8;
                        break;
                    case 4:
                        str9 = (String) cVarC.z(descriptor2, 4, x0.f22227a, str9);
                        i9 |= 16;
                        break;
                    case 5:
                        map2 = (Map) cVarC.u(descriptor2, 5, bVarArr[5], map2);
                        i9 |= 32;
                        break;
                    default:
                        throw new m(iE);
                }
            }
            i8 = i9;
            str = strJ;
            str2 = strJ5;
            str3 = strJ6;
            str4 = str8;
            str5 = str9;
            map = map2;
        }
        cVarC.d(descriptor2);
        return new WebBillingProductResponse(i8, str, str2, str3, str4, str5, map, (t0) null);
    }

    @Override // k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return descriptor;
    }

    @Override // k7.k
    public void serialize(f encoder, WebBillingProductResponse value) {
        AbstractC2304t.f(encoder, "encoder");
        AbstractC2304t.f(value, "value");
        m7.e descriptor2 = getDescriptor();
        d dVarC = encoder.c(descriptor2);
        WebBillingProductResponse.write$Self$purchases_defaultsRelease(value, dVarC, descriptor2);
        dVarC.d(descriptor2);
    }

    @Override // o7.E
    public k7.b[] typeParametersSerializers() {
        return E.a.a(this);
    }
}
