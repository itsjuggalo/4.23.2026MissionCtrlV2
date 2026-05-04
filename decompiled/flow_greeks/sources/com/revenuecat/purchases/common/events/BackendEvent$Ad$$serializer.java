package com.revenuecat.purchases.common.events;

import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.events.BackendEvent;
import dh.e0;
import dh.j0;
import dh.j1;
import dh.q0;
import dh.s1;
import dh.w1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/common/events/BackendEvent.Ad.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BackendEvent$Ad$$serializer implements e0 {
    public static final BackendEvent$Ad$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        BackendEvent$Ad$$serializer backendEvent$Ad$$serializer = new BackendEvent$Ad$$serializer();
        INSTANCE = backendEvent$Ad$$serializer;
        j1 j1Var = new j1("ad", backendEvent$Ad$$serializer, 15);
        j1Var.g(DiagnosticsEntry.ID_KEY, false);
        j1Var.g(DiagnosticsEntry.VERSION_KEY, false);
        j1Var.g("type", false);
        j1Var.g("timestamp_ms", false);
        j1Var.g("network_name", false);
        j1Var.g("mediator_name", false);
        j1Var.g("placement", false);
        j1Var.g("ad_unit_id", false);
        j1Var.g("impression_id", false);
        j1Var.g("app_user_id", false);
        j1Var.g(DiagnosticsEntry.APP_SESSION_ID_KEY, false);
        j1Var.g("revenue_micros", true);
        j1Var.g("currency", true);
        j1Var.g("precision", true);
        j1Var.g("mediator_error_code", true);
        descriptor = j1Var;
    }

    private BackendEvent$Ad$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        w1 w1Var = w1.f8244a;
        j0 j0Var = j0.f8162a;
        q0 q0Var = q0.f8206a;
        return new b[]{w1Var, j0Var, w1Var, q0Var, w1Var, w1Var, ah.a.p(w1Var), w1Var, ah.a.p(w1Var), w1Var, w1Var, ah.a.p(q0Var), ah.a.p(w1Var), ah.a.p(w1Var), ah.a.p(j0Var)};
    }

    @Override // zg.a
    public BackendEvent.Ad deserialize(e decoder) {
        int i10;
        int i11;
        String str;
        String str2;
        Integer num;
        String str3;
        String str4;
        Long l10;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        long j10;
        int i12;
        char c10;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        int i13 = 11;
        int i14 = 10;
        int i15 = 7;
        if (cVarB.z()) {
            String strS = cVarB.s(descriptor2, 0);
            int iC = cVarB.C(descriptor2, 1);
            String strS2 = cVarB.s(descriptor2, 2);
            long jG = cVarB.g(descriptor2, 3);
            String strS3 = cVarB.s(descriptor2, 4);
            String strS4 = cVarB.s(descriptor2, 5);
            w1 w1Var = w1.f8244a;
            String str12 = (String) cVarB.n(descriptor2, 6, w1Var, null);
            String strS5 = cVarB.s(descriptor2, 7);
            String str13 = (String) cVarB.n(descriptor2, 8, w1Var, null);
            String strS6 = cVarB.s(descriptor2, 9);
            String strS7 = cVarB.s(descriptor2, 10);
            Long l11 = (Long) cVarB.n(descriptor2, 11, q0.f8206a, null);
            String str14 = (String) cVarB.n(descriptor2, 12, w1Var, null);
            String str15 = (String) cVarB.n(descriptor2, 13, w1Var, null);
            i10 = 32767;
            num = (Integer) cVarB.n(descriptor2, 14, j0.f8162a, null);
            i11 = iC;
            str6 = strS2;
            l10 = l11;
            str11 = strS7;
            str10 = strS6;
            str9 = strS5;
            str2 = str12;
            str8 = strS4;
            str7 = strS3;
            str = str13;
            str3 = str14;
            str4 = str15;
            str5 = strS;
            j10 = jG;
        } else {
            boolean z10 = true;
            int iC2 = 0;
            String str16 = null;
            Integer num2 = null;
            String str17 = null;
            String str18 = null;
            Long l12 = null;
            String strS8 = null;
            String strS9 = null;
            String strS10 = null;
            String strS11 = null;
            String strS12 = null;
            long jG2 = 0;
            i10 = 0;
            String str19 = null;
            String strS13 = null;
            String strS14 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z10 = false;
                        i15 = i15;
                        i13 = 11;
                        break;
                    case 0:
                        i12 = i15;
                        c10 = 6;
                        strS13 = cVarB.s(descriptor2, 0);
                        i10 |= 1;
                        i15 = i12;
                        i13 = 11;
                        i14 = 10;
                        break;
                    case 1:
                        c10 = 6;
                        i10 |= 2;
                        i15 = i15;
                        iC2 = cVarB.C(descriptor2, 1);
                        i13 = 11;
                        i14 = 10;
                        break;
                    case 2:
                        i12 = i15;
                        c10 = 6;
                        strS14 = cVarB.s(descriptor2, 2);
                        i10 |= 4;
                        i15 = i12;
                        i13 = 11;
                        i14 = 10;
                        break;
                    case 3:
                        i12 = i15;
                        c10 = 6;
                        jG2 = cVarB.g(descriptor2, 3);
                        i10 |= 8;
                        i15 = i12;
                        i13 = 11;
                        i14 = 10;
                        break;
                    case 4:
                        i12 = i15;
                        c10 = 6;
                        strS8 = cVarB.s(descriptor2, 4);
                        i10 |= 16;
                        i15 = i12;
                        i13 = 11;
                        i14 = 10;
                        break;
                    case 5:
                        i12 = i15;
                        c10 = 6;
                        strS9 = cVarB.s(descriptor2, 5);
                        i10 |= 32;
                        i15 = i12;
                        i13 = 11;
                        i14 = 10;
                        break;
                    case 6:
                        i12 = i15;
                        c10 = 6;
                        str19 = (String) cVarB.n(descriptor2, 6, w1.f8244a, str19);
                        i10 |= 64;
                        i15 = i12;
                        i13 = 11;
                        i14 = 10;
                        break;
                    case 7:
                        int i16 = i15;
                        strS10 = cVarB.s(descriptor2, i16);
                        i10 |= 128;
                        i15 = i16;
                        break;
                    case 8:
                        str16 = (String) cVarB.n(descriptor2, 8, w1.f8244a, str16);
                        i10 |= 256;
                        i15 = 7;
                        break;
                    case 9:
                        strS11 = cVarB.s(descriptor2, 9);
                        i10 |= 512;
                        i15 = 7;
                        break;
                    case 10:
                        strS12 = cVarB.s(descriptor2, i14);
                        i10 |= 1024;
                        i15 = 7;
                        break;
                    case 11:
                        l12 = (Long) cVarB.n(descriptor2, i13, q0.f8206a, l12);
                        i10 |= 2048;
                        i15 = 7;
                        break;
                    case 12:
                        str17 = (String) cVarB.n(descriptor2, 12, w1.f8244a, str17);
                        i10 |= 4096;
                        i15 = 7;
                        break;
                    case 13:
                        str18 = (String) cVarB.n(descriptor2, 13, w1.f8244a, str18);
                        i10 |= 8192;
                        i15 = 7;
                        break;
                    case 14:
                        num2 = (Integer) cVarB.n(descriptor2, 14, j0.f8162a, num2);
                        i10 |= 16384;
                        i15 = 7;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            i11 = iC2;
            str = str16;
            str2 = str19;
            num = num2;
            str3 = str17;
            str4 = str18;
            l10 = l12;
            str5 = strS13;
            str6 = strS14;
            str7 = strS8;
            str8 = strS9;
            str9 = strS10;
            str10 = strS11;
            str11 = strS12;
            j10 = jG2;
        }
        int i17 = i10;
        cVarB.c(descriptor2);
        return new BackendEvent.Ad(i17, str5, i11, str6, j10, str7, str8, str2, str9, str, str10, str11, l10, str3, str4, num, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, BackendEvent.Ad value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        BackendEvent.Ad.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
