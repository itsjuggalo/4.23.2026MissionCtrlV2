package com.revenuecat.purchases.common.events;

import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.events.BackendEvent;
import dh.e0;
import dh.h;
import dh.j0;
import dh.j1;
import dh.q0;
import dh.w1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/common/events/BackendEvent.Paywalls.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BackendEvent$Paywalls$$serializer implements e0 {
    public static final BackendEvent$Paywalls$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        BackendEvent$Paywalls$$serializer backendEvent$Paywalls$$serializer = new BackendEvent$Paywalls$$serializer();
        INSTANCE = backendEvent$Paywalls$$serializer;
        j1 j1Var = new j1("paywalls", backendEvent$Paywalls$$serializer, 11);
        j1Var.g(DiagnosticsEntry.ID_KEY, false);
        j1Var.g(DiagnosticsEntry.VERSION_KEY, false);
        j1Var.g("type", false);
        j1Var.g("app_user_id", false);
        j1Var.g("session_id", false);
        j1Var.g("offering_id", false);
        j1Var.g("paywall_revision", false);
        j1Var.g(DiagnosticsEntry.TIMESTAMP_KEY, false);
        j1Var.g("display_mode", false);
        j1Var.g("dark_mode", false);
        j1Var.g("locale", false);
        descriptor = j1Var;
    }

    private BackendEvent$Paywalls$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        w1 w1Var = w1.f8244a;
        j0 j0Var = j0.f8162a;
        return new b[]{w1Var, j0Var, w1Var, w1Var, w1Var, w1Var, j0Var, q0.f8206a, w1Var, h.f8149a, w1Var};
    }

    @Override // zg.a
    public BackendEvent.Paywalls deserialize(e decoder) {
        String strS;
        int i10;
        String strS2;
        boolean z10;
        String str;
        int i11;
        String str2;
        String str3;
        String str4;
        String str5;
        int i12;
        long j10;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        int i13 = 0;
        if (cVarB.z()) {
            strS = cVarB.s(descriptor2, 0);
            int iC = cVarB.C(descriptor2, 1);
            String strS3 = cVarB.s(descriptor2, 2);
            String strS4 = cVarB.s(descriptor2, 3);
            String strS5 = cVarB.s(descriptor2, 4);
            String strS6 = cVarB.s(descriptor2, 5);
            int iC2 = cVarB.C(descriptor2, 6);
            long jG = cVarB.g(descriptor2, 7);
            String strS7 = cVarB.s(descriptor2, 8);
            boolean zB = cVarB.B(descriptor2, 9);
            strS2 = cVarB.s(descriptor2, 10);
            z10 = zB;
            str = strS7;
            i11 = iC2;
            str2 = strS6;
            str3 = strS4;
            i10 = 2047;
            str4 = strS5;
            str5 = strS3;
            i12 = iC;
            j10 = jG;
        } else {
            strS = null;
            String strS8 = null;
            String strS9 = null;
            String strS10 = null;
            String strS11 = null;
            String strS12 = null;
            boolean z11 = true;
            int iC3 = 0;
            int iC4 = 0;
            long jG2 = 0;
            String strS13 = null;
            boolean zB2 = false;
            while (z11) {
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z11 = false;
                        break;
                    case 0:
                        i13 |= 1;
                        strS = cVarB.s(descriptor2, 0);
                        continue;
                    case 1:
                        iC4 = cVarB.C(descriptor2, 1);
                        i13 |= 2;
                        continue;
                    case 2:
                        strS12 = cVarB.s(descriptor2, 2);
                        i13 |= 4;
                        break;
                    case 3:
                        strS10 = cVarB.s(descriptor2, 3);
                        i13 |= 8;
                        break;
                    case 4:
                        strS11 = cVarB.s(descriptor2, 4);
                        i13 |= 16;
                        break;
                    case 5:
                        strS9 = cVarB.s(descriptor2, 5);
                        i13 |= 32;
                        break;
                    case 6:
                        iC3 = cVarB.C(descriptor2, 6);
                        i13 |= 64;
                        break;
                    case 7:
                        jG2 = cVarB.g(descriptor2, 7);
                        i13 |= 128;
                        break;
                    case 8:
                        strS8 = cVarB.s(descriptor2, 8);
                        i13 |= 256;
                        break;
                    case 9:
                        zB2 = cVarB.B(descriptor2, 9);
                        i13 |= 512;
                        break;
                    case 10:
                        strS13 = cVarB.s(descriptor2, 10);
                        i13 |= 1024;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            i10 = i13;
            strS2 = strS13;
            z10 = zB2;
            str = strS8;
            i11 = iC3;
            str2 = strS9;
            str3 = strS10;
            str4 = strS11;
            str5 = strS12;
            i12 = iC4;
            j10 = jG2;
        }
        String str6 = strS;
        cVarB.c(descriptor2);
        return new BackendEvent.Paywalls(i10, str6, i12, str5, str3, str4, str2, i11, j10, str, z10, strS2, null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, BackendEvent.Paywalls value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        BackendEvent.Paywalls.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
