package com.revenuecat.purchases.customercenter;

import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import dh.e0;
import dh.h;
import dh.j1;
import dh.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/customercenter/CustomerCenterConfigData.Support.SupportTickets.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomerCenterConfigData$Support$SupportTickets$$serializer implements e0 {
    public static final CustomerCenterConfigData$Support$SupportTickets$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        CustomerCenterConfigData$Support$SupportTickets$$serializer customerCenterConfigData$Support$SupportTickets$$serializer = new CustomerCenterConfigData$Support$SupportTickets$$serializer();
        INSTANCE = customerCenterConfigData$Support$SupportTickets$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Support.SupportTickets", customerCenterConfigData$Support$SupportTickets$$serializer, 3);
        j1Var.g("allow_creation", true);
        j1Var.g("customer_details", true);
        j1Var.g("customer_type", true);
        descriptor = j1Var;
    }

    private CustomerCenterConfigData$Support$SupportTickets$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        return new b[]{h.f8149a, CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer.INSTANCE, CustomerCenterConfigData.Support.SupportTickets.$childSerializers[2]};
    }

    @Override // zg.a
    public CustomerCenterConfigData.Support.SupportTickets deserialize(e decoder) {
        boolean zB;
        int i10;
        CustomerCenterConfigData.Support.SupportTickets.CustomerDetails customerDetails;
        CustomerCenterConfigData.Support.SupportTickets.CustomerType customerType;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        b[] bVarArr = CustomerCenterConfigData.Support.SupportTickets.$childSerializers;
        if (cVarB.z()) {
            zB = cVarB.B(descriptor2, 0);
            CustomerCenterConfigData.Support.SupportTickets.CustomerDetails customerDetails2 = (CustomerCenterConfigData.Support.SupportTickets.CustomerDetails) cVarB.h(descriptor2, 1, CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer.INSTANCE, null);
            customerType = (CustomerCenterConfigData.Support.SupportTickets.CustomerType) cVarB.h(descriptor2, 2, bVarArr[2], null);
            i10 = 7;
            customerDetails = customerDetails2;
        } else {
            boolean z10 = true;
            zB = false;
            CustomerCenterConfigData.Support.SupportTickets.CustomerDetails customerDetails3 = null;
            CustomerCenterConfigData.Support.SupportTickets.CustomerType customerType2 = null;
            int i11 = 0;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                if (iW == -1) {
                    z10 = false;
                } else if (iW == 0) {
                    zB = cVarB.B(descriptor2, 0);
                    i11 |= 1;
                } else if (iW == 1) {
                    customerDetails3 = (CustomerCenterConfigData.Support.SupportTickets.CustomerDetails) cVarB.h(descriptor2, 1, CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer.INSTANCE, customerDetails3);
                    i11 |= 2;
                } else {
                    if (iW != 2) {
                        throw new m(iW);
                    }
                    customerType2 = (CustomerCenterConfigData.Support.SupportTickets.CustomerType) cVarB.h(descriptor2, 2, bVarArr[2], customerType2);
                    i11 |= 4;
                }
            }
            i10 = i11;
            customerDetails = customerDetails3;
            customerType = customerType2;
        }
        boolean z11 = zB;
        cVarB.c(descriptor2);
        return new CustomerCenterConfigData.Support.SupportTickets(i10, z11, customerDetails, customerType, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, CustomerCenterConfigData.Support.SupportTickets value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        CustomerCenterConfigData.Support.SupportTickets.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
