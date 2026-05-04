package com.revenuecat.purchases.customercenter;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer;
import dh.e0;
import dh.h;
import dh.j1;
import dh.s1;
import io.flutter.plugins.firebase.auth.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/customercenter/CustomerCenterConfigData.Support.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomerCenterConfigData$Support$$serializer implements e0 {
    public static final CustomerCenterConfigData$Support$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        CustomerCenterConfigData$Support$$serializer customerCenterConfigData$Support$$serializer = new CustomerCenterConfigData$Support$$serializer();
        INSTANCE = customerCenterConfigData$Support$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Support", customerCenterConfigData$Support$$serializer, 4);
        j1Var.g(Constants.EMAIL, true);
        j1Var.g("should_warn_customer_to_update", true);
        j1Var.g("display_virtual_currencies", true);
        j1Var.g("support_tickets", true);
        descriptor = j1Var;
    }

    private CustomerCenterConfigData$Support$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b bVarP = a.p(EmptyStringToNullSerializer.INSTANCE);
        h hVar = h.f8149a;
        return new b[]{bVarP, a.p(hVar), a.p(hVar), CustomerCenterConfigData$Support$SupportTickets$$serializer.INSTANCE};
    }

    @Override // zg.a
    public CustomerCenterConfigData.Support deserialize(e decoder) {
        int i10;
        String str;
        Boolean bool;
        Boolean bool2;
        CustomerCenterConfigData.Support.SupportTickets supportTickets;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        String str2 = null;
        if (cVarB.z()) {
            String str3 = (String) cVarB.n(descriptor2, 0, EmptyStringToNullSerializer.INSTANCE, null);
            h hVar = h.f8149a;
            Boolean bool3 = (Boolean) cVarB.n(descriptor2, 1, hVar, null);
            Boolean bool4 = (Boolean) cVarB.n(descriptor2, 2, hVar, null);
            str = str3;
            supportTickets = (CustomerCenterConfigData.Support.SupportTickets) cVarB.h(descriptor2, 3, CustomerCenterConfigData$Support$SupportTickets$$serializer.INSTANCE, null);
            bool2 = bool4;
            bool = bool3;
            i10 = 15;
        } else {
            boolean z10 = true;
            int i11 = 0;
            Boolean bool5 = null;
            Boolean bool6 = null;
            CustomerCenterConfigData.Support.SupportTickets supportTickets2 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                if (iW == -1) {
                    z10 = false;
                } else if (iW == 0) {
                    str2 = (String) cVarB.n(descriptor2, 0, EmptyStringToNullSerializer.INSTANCE, str2);
                    i11 |= 1;
                } else if (iW == 1) {
                    bool5 = (Boolean) cVarB.n(descriptor2, 1, h.f8149a, bool5);
                    i11 |= 2;
                } else if (iW == 2) {
                    bool6 = (Boolean) cVarB.n(descriptor2, 2, h.f8149a, bool6);
                    i11 |= 4;
                } else {
                    if (iW != 3) {
                        throw new m(iW);
                    }
                    supportTickets2 = (CustomerCenterConfigData.Support.SupportTickets) cVarB.h(descriptor2, 3, CustomerCenterConfigData$Support$SupportTickets$$serializer.INSTANCE, supportTickets2);
                    i11 |= 8;
                }
            }
            i10 = i11;
            str = str2;
            bool = bool5;
            bool2 = bool6;
            supportTickets = supportTickets2;
        }
        cVarB.c(descriptor2);
        return new CustomerCenterConfigData.Support(i10, str, bool, bool2, supportTickets, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, CustomerCenterConfigData.Support value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        CustomerCenterConfigData.Support.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
