package com.revenuecat.purchases.common.events;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.C0335h;
import J3.H;
import J3.O;
import J3.o0;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.events.BackendEvent;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class BackendEvent$Paywalls$$serializer implements C {
    public static final BackendEvent$Paywalls$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        BackendEvent$Paywalls$$serializer backendEvent$Paywalls$$serializer = new BackendEvent$Paywalls$$serializer();
        INSTANCE = backendEvent$Paywalls$$serializer;
        C0327b0 c0327b0 = new C0327b0("paywalls", backendEvent$Paywalls$$serializer, 11);
        c0327b0.l(DiagnosticsEntry.ID_KEY, false);
        c0327b0.l(DiagnosticsEntry.VERSION_KEY, false);
        c0327b0.l("type", false);
        c0327b0.l("app_user_id", false);
        c0327b0.l("session_id", false);
        c0327b0.l("offering_id", false);
        c0327b0.l("paywall_revision", false);
        c0327b0.l("timestamp", false);
        c0327b0.l("display_mode", false);
        c0327b0.l("dark_mode", false);
        c0327b0.l("locale", false);
        descriptor = c0327b0;
    }

    private BackendEvent$Paywalls$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        o0 o0Var = o0.f952a;
        H h4 = H.f874a;
        return new b[]{o0Var, h4, o0Var, o0Var, o0Var, o0Var, h4, O.f882a, o0Var, C0335h.f929a, o0Var};
    }

    @Override // F3.a
    public BackendEvent.Paywalls deserialize(e decoder) {
        String strV;
        int i4;
        String strV2;
        boolean z4;
        String str;
        int i5;
        String str2;
        String str3;
        String str4;
        String str5;
        int i6;
        long j4;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        int i7 = 0;
        if (cVarD.w()) {
            strV = cVarD.v(descriptor2, 0);
            int iH = cVarD.h(descriptor2, 1);
            String strV3 = cVarD.v(descriptor2, 2);
            String strV4 = cVarD.v(descriptor2, 3);
            String strV5 = cVarD.v(descriptor2, 4);
            String strV6 = cVarD.v(descriptor2, 5);
            int iH2 = cVarD.h(descriptor2, 6);
            long j5 = cVarD.j(descriptor2, 7);
            String strV7 = cVarD.v(descriptor2, 8);
            boolean zN = cVarD.n(descriptor2, 9);
            strV2 = cVarD.v(descriptor2, 10);
            z4 = zN;
            str = strV7;
            i5 = iH2;
            str2 = strV6;
            str3 = strV4;
            i4 = 2047;
            str4 = strV5;
            str5 = strV3;
            i6 = iH;
            j4 = j5;
        } else {
            strV = null;
            String strV8 = null;
            String strV9 = null;
            String strV10 = null;
            String strV11 = null;
            String strV12 = null;
            boolean z5 = true;
            int iH3 = 0;
            int iH4 = 0;
            long j6 = 0;
            String strV13 = null;
            boolean zN2 = false;
            while (z5) {
                int i8 = cVarD.i(descriptor2);
                switch (i8) {
                    case -1:
                        z5 = false;
                        break;
                    case 0:
                        i7 |= 1;
                        strV = cVarD.v(descriptor2, 0);
                        continue;
                    case 1:
                        iH4 = cVarD.h(descriptor2, 1);
                        i7 |= 2;
                        continue;
                    case 2:
                        strV12 = cVarD.v(descriptor2, 2);
                        i7 |= 4;
                        break;
                    case 3:
                        strV10 = cVarD.v(descriptor2, 3);
                        i7 |= 8;
                        break;
                    case 4:
                        strV11 = cVarD.v(descriptor2, 4);
                        i7 |= 16;
                        break;
                    case 5:
                        strV9 = cVarD.v(descriptor2, 5);
                        i7 |= 32;
                        break;
                    case 6:
                        iH3 = cVarD.h(descriptor2, 6);
                        i7 |= 64;
                        break;
                    case 7:
                        j6 = cVarD.j(descriptor2, 7);
                        i7 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        break;
                    case 8:
                        strV8 = cVarD.v(descriptor2, 8);
                        i7 |= 256;
                        break;
                    case 9:
                        zN2 = cVarD.n(descriptor2, 9);
                        i7 |= 512;
                        break;
                    case 10:
                        strV13 = cVarD.v(descriptor2, 10);
                        i7 |= UserMetadata.MAX_ATTRIBUTE_SIZE;
                        break;
                    default:
                        throw new j(i8);
                }
            }
            i4 = i7;
            strV2 = strV13;
            z4 = zN2;
            str = strV8;
            i5 = iH3;
            str2 = strV9;
            str3 = strV10;
            str4 = strV11;
            str5 = strV12;
            i6 = iH4;
            j4 = j6;
        }
        String str6 = strV;
        cVarD.c(descriptor2);
        return new BackendEvent.Paywalls(i4, str6, i6, str5, str3, str4, str2, i5, j4, str, z4, strV2, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, BackendEvent.Paywalls value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        BackendEvent.Paywalls.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
