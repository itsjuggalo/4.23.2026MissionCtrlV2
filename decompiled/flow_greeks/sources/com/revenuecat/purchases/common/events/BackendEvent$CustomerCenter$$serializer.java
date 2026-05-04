package com.revenuecat.purchases.common.events;

import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.events.BackendEvent;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.events.CustomerCenterDisplayMode;
import com.revenuecat.purchases.customercenter.events.CustomerCenterEventType;
import dh.e0;
import dh.h;
import dh.j0;
import dh.j1;
import dh.q0;
import dh.w1;
import io.flutter.plugins.firebase.database.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/common/events/BackendEvent.CustomerCenter.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BackendEvent$CustomerCenter$$serializer implements e0 {
    public static final BackendEvent$CustomerCenter$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        BackendEvent$CustomerCenter$$serializer backendEvent$CustomerCenter$$serializer = new BackendEvent$CustomerCenter$$serializer();
        INSTANCE = backendEvent$CustomerCenter$$serializer;
        j1 j1Var = new j1("customer_center", backendEvent$CustomerCenter$$serializer, 12);
        j1Var.g(DiagnosticsEntry.ID_KEY, false);
        j1Var.g("revision_id", false);
        j1Var.g("type", false);
        j1Var.g("app_user_id", false);
        j1Var.g(DiagnosticsEntry.APP_SESSION_ID_KEY, false);
        j1Var.g(DiagnosticsEntry.TIMESTAMP_KEY, false);
        j1Var.g("dark_mode", false);
        j1Var.g("locale", false);
        j1Var.g("display_mode", false);
        j1Var.g(Constants.PATH, false);
        j1Var.g("url", false);
        j1Var.g("survey_option_id", false);
        descriptor = j1Var;
    }

    private BackendEvent$CustomerCenter$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b[] bVarArr = BackendEvent.CustomerCenter.$childSerializers;
        w1 w1Var = w1.f8244a;
        return new b[]{w1Var, j0.f8162a, bVarArr[2], w1Var, w1Var, q0.f8206a, h.f8149a, w1Var, bVarArr[8], ah.a.p(bVarArr[9]), ah.a.p(w1Var), ah.a.p(w1Var)};
    }

    @Override // zg.a
    public BackendEvent.CustomerCenter deserialize(e decoder) {
        CustomerCenterEventType customerCenterEventType;
        String str;
        String str2;
        int i10;
        String str3;
        CustomerCenterConfigData.HelpPath.PathType pathType;
        CustomerCenterDisplayMode customerCenterDisplayMode;
        String str4;
        String str5;
        String str6;
        boolean z10;
        int i11;
        long j10;
        int i12;
        int i13;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        b[] bVarArr = BackendEvent.CustomerCenter.$childSerializers;
        int i14 = 10;
        int i15 = 7;
        int i16 = 6;
        String strS = null;
        if (cVarB.z()) {
            String strS2 = cVarB.s(descriptor2, 0);
            int iC = cVarB.C(descriptor2, 1);
            CustomerCenterEventType customerCenterEventType2 = (CustomerCenterEventType) cVarB.h(descriptor2, 2, bVarArr[2], null);
            String strS3 = cVarB.s(descriptor2, 3);
            String strS4 = cVarB.s(descriptor2, 4);
            long jG = cVarB.g(descriptor2, 5);
            boolean zB = cVarB.B(descriptor2, 6);
            String strS5 = cVarB.s(descriptor2, 7);
            CustomerCenterDisplayMode customerCenterDisplayMode2 = (CustomerCenterDisplayMode) cVarB.h(descriptor2, 8, bVarArr[8], null);
            CustomerCenterConfigData.HelpPath.PathType pathType2 = (CustomerCenterConfigData.HelpPath.PathType) cVarB.n(descriptor2, 9, bVarArr[9], null);
            w1 w1Var = w1.f8244a;
            String str7 = (String) cVarB.n(descriptor2, 10, w1Var, null);
            pathType = pathType2;
            str = strS2;
            str2 = (String) cVarB.n(descriptor2, 11, w1Var, null);
            str3 = str7;
            str6 = strS5;
            z10 = zB;
            customerCenterDisplayMode = customerCenterDisplayMode2;
            str4 = strS3;
            str5 = strS4;
            i10 = 4095;
            customerCenterEventType = customerCenterEventType2;
            i11 = iC;
            j10 = jG;
        } else {
            CustomerCenterEventType customerCenterEventType3 = null;
            String str8 = null;
            String strS6 = null;
            boolean z11 = true;
            int i17 = 0;
            boolean zB2 = false;
            int iC2 = 0;
            long jG2 = 0;
            String str9 = null;
            CustomerCenterConfigData.HelpPath.PathType pathType3 = null;
            CustomerCenterDisplayMode customerCenterDisplayMode3 = null;
            String strS7 = null;
            String strS8 = null;
            while (z11) {
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z11 = false;
                        break;
                    case 0:
                        i17 |= 1;
                        i16 = i16;
                        strS = cVarB.s(descriptor2, 0);
                        i14 = 10;
                        i15 = 7;
                        break;
                    case 1:
                        i12 = i16;
                        iC2 = cVarB.C(descriptor2, 1);
                        i17 |= 2;
                        i16 = i12;
                        i14 = 10;
                        i15 = 7;
                        break;
                    case 2:
                        i12 = i16;
                        customerCenterEventType3 = (CustomerCenterEventType) cVarB.h(descriptor2, 2, bVarArr[2], customerCenterEventType3);
                        i17 |= 4;
                        i16 = i12;
                        i14 = 10;
                        i15 = 7;
                        break;
                    case 3:
                        i13 = i16;
                        strS7 = cVarB.s(descriptor2, 3);
                        i17 |= 8;
                        i16 = i13;
                        i14 = 10;
                        break;
                    case 4:
                        i13 = i16;
                        strS8 = cVarB.s(descriptor2, 4);
                        i17 |= 16;
                        i16 = i13;
                        i14 = 10;
                        break;
                    case 5:
                        jG2 = cVarB.g(descriptor2, 5);
                        i17 |= 32;
                        i16 = i16;
                        i14 = 10;
                        break;
                    case 6:
                        int i18 = i16;
                        zB2 = cVarB.B(descriptor2, i18);
                        i17 |= 64;
                        i16 = i18;
                        break;
                    case 7:
                        strS6 = cVarB.s(descriptor2, i15);
                        i17 |= 128;
                        i16 = 6;
                        break;
                    case 8:
                        customerCenterDisplayMode3 = (CustomerCenterDisplayMode) cVarB.h(descriptor2, 8, bVarArr[8], customerCenterDisplayMode3);
                        i17 |= 256;
                        i16 = 6;
                        break;
                    case 9:
                        pathType3 = (CustomerCenterConfigData.HelpPath.PathType) cVarB.n(descriptor2, 9, bVarArr[9], pathType3);
                        i17 |= 512;
                        i16 = 6;
                        break;
                    case 10:
                        str9 = (String) cVarB.n(descriptor2, i14, w1.f8244a, str9);
                        i17 |= 1024;
                        i16 = 6;
                        break;
                    case 11:
                        str8 = (String) cVarB.n(descriptor2, 11, w1.f8244a, str8);
                        i17 |= 2048;
                        i16 = 6;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            customerCenterEventType = customerCenterEventType3;
            str = strS;
            str2 = str8;
            i10 = i17;
            str3 = str9;
            pathType = pathType3;
            customerCenterDisplayMode = customerCenterDisplayMode3;
            str4 = strS7;
            str5 = strS8;
            str6 = strS6;
            z10 = zB2;
            i11 = iC2;
            j10 = jG2;
        }
        cVarB.c(descriptor2);
        return new BackendEvent.CustomerCenter(i10, str, i11, customerCenterEventType, str4, str5, j10, z10, str6, customerCenterDisplayMode, pathType, str3, str2, null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, BackendEvent.CustomerCenter value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        BackendEvent.CustomerCenter.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
