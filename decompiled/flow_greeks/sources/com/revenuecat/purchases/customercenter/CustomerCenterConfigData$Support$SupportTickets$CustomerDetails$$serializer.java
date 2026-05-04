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
import io.flutter.plugins.firebase.auth.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/customercenter/CustomerCenterConfigData.Support.SupportTickets.CustomerDetails.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer implements e0 {
    public static final CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer customerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer = new CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer();
        INSTANCE = customerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Support.SupportTickets.CustomerDetails", customerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer, 14);
        j1Var.g("active_entitlements", true);
        j1Var.g("app_user_id", true);
        j1Var.g("att_consent", true);
        j1Var.g("country", true);
        j1Var.g("device_version", true);
        j1Var.g(Constants.EMAIL, true);
        j1Var.g("facebook_anon_id", true);
        j1Var.g("idfa", true);
        j1Var.g("idfv", true);
        j1Var.g("ip", true);
        j1Var.g("last_opened", true);
        j1Var.g("last_seen_app_version", true);
        j1Var.g("total_spent", true);
        j1Var.g("user_since", true);
        descriptor = j1Var;
    }

    private CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        h hVar = h.f8149a;
        return new b[]{hVar, hVar, hVar, hVar, hVar, hVar, hVar, hVar, hVar, hVar, hVar, hVar, hVar, hVar};
    }

    @Override // zg.a
    public CustomerCenterConfigData.Support.SupportTickets.CustomerDetails deserialize(e decoder) {
        int i10;
        boolean z10;
        boolean z11;
        boolean zB;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21;
        boolean zB2;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        int i11 = 0;
        if (cVarB.z()) {
            boolean zB3 = cVarB.B(descriptor2, 0);
            boolean zB4 = cVarB.B(descriptor2, 1);
            boolean zB5 = cVarB.B(descriptor2, 2);
            boolean zB6 = cVarB.B(descriptor2, 3);
            boolean zB7 = cVarB.B(descriptor2, 4);
            boolean zB8 = cVarB.B(descriptor2, 5);
            boolean zB9 = cVarB.B(descriptor2, 6);
            boolean zB10 = cVarB.B(descriptor2, 7);
            boolean zB11 = cVarB.B(descriptor2, 8);
            boolean zB12 = cVarB.B(descriptor2, 9);
            boolean zB13 = cVarB.B(descriptor2, 10);
            boolean zB14 = cVarB.B(descriptor2, 11);
            z10 = zB3;
            z11 = zB4;
            zB = cVarB.B(descriptor2, 12);
            z12 = zB14;
            z13 = zB13;
            z14 = zB12;
            z15 = zB10;
            z16 = zB9;
            z17 = zB8;
            z18 = zB6;
            z19 = zB11;
            z20 = zB7;
            z21 = zB5;
            zB2 = cVarB.B(descriptor2, 13);
            i10 = 16383;
        } else {
            int i12 = 13;
            boolean zB15 = false;
            boolean zB16 = false;
            boolean zB17 = false;
            boolean zB18 = false;
            boolean zB19 = false;
            boolean zB20 = false;
            boolean zB21 = false;
            boolean zB22 = false;
            boolean zB23 = false;
            boolean zB24 = false;
            boolean zB25 = false;
            boolean zB26 = false;
            boolean zB27 = false;
            boolean zB28 = false;
            boolean z22 = true;
            while (z22) {
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z22 = false;
                        i12 = 13;
                        break;
                    case 0:
                        zB15 = cVarB.B(descriptor2, 0);
                        i11 |= 1;
                        i12 = 13;
                        break;
                    case 1:
                        zB16 = cVarB.B(descriptor2, 1);
                        i11 |= 2;
                        break;
                    case 2:
                        zB27 = cVarB.B(descriptor2, 2);
                        i11 |= 4;
                        break;
                    case 3:
                        zB24 = cVarB.B(descriptor2, 3);
                        i11 |= 8;
                        break;
                    case 4:
                        zB26 = cVarB.B(descriptor2, 4);
                        i11 |= 16;
                        break;
                    case 5:
                        zB23 = cVarB.B(descriptor2, 5);
                        i11 |= 32;
                        break;
                    case 6:
                        zB22 = cVarB.B(descriptor2, 6);
                        i11 |= 64;
                        break;
                    case 7:
                        zB21 = cVarB.B(descriptor2, 7);
                        i11 |= 128;
                        break;
                    case 8:
                        zB25 = cVarB.B(descriptor2, 8);
                        i11 |= 256;
                        break;
                    case 9:
                        zB20 = cVarB.B(descriptor2, 9);
                        i11 |= 512;
                        break;
                    case 10:
                        zB19 = cVarB.B(descriptor2, 10);
                        i11 |= 1024;
                        break;
                    case 11:
                        zB18 = cVarB.B(descriptor2, 11);
                        i11 |= 2048;
                        break;
                    case 12:
                        zB17 = cVarB.B(descriptor2, 12);
                        i11 |= 4096;
                        break;
                    case 13:
                        zB28 = cVarB.B(descriptor2, i12);
                        i11 |= 8192;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            i10 = i11;
            z10 = zB15;
            z11 = zB16;
            zB = zB17;
            z12 = zB18;
            z13 = zB19;
            z14 = zB20;
            z15 = zB21;
            z16 = zB22;
            z17 = zB23;
            z18 = zB24;
            z19 = zB25;
            z20 = zB26;
            z21 = zB27;
            zB2 = zB28;
        }
        cVarB.c(descriptor2);
        return new CustomerCenterConfigData.Support.SupportTickets.CustomerDetails(i10, z10, z11, z21, z18, z20, z17, z16, z15, z19, z14, z13, z12, zB, zB2, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, CustomerCenterConfigData.Support.SupportTickets.CustomerDetails value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        CustomerCenterConfigData.Support.SupportTickets.CustomerDetails.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
