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
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.events.CustomerCenterDisplayMode;
import com.revenuecat.purchases.customercenter.events.CustomerCenterEventType;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class BackendEvent$CustomerCenter$$serializer implements C {
    public static final BackendEvent$CustomerCenter$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        BackendEvent$CustomerCenter$$serializer backendEvent$CustomerCenter$$serializer = new BackendEvent$CustomerCenter$$serializer();
        INSTANCE = backendEvent$CustomerCenter$$serializer;
        C0327b0 c0327b0 = new C0327b0("customer_center", backendEvent$CustomerCenter$$serializer, 12);
        c0327b0.l(DiagnosticsEntry.ID_KEY, false);
        c0327b0.l("revision_id", false);
        c0327b0.l("type", false);
        c0327b0.l("app_user_id", false);
        c0327b0.l(DiagnosticsEntry.APP_SESSION_ID_KEY, false);
        c0327b0.l("timestamp", false);
        c0327b0.l("dark_mode", false);
        c0327b0.l("locale", false);
        c0327b0.l("display_mode", false);
        c0327b0.l("path", false);
        c0327b0.l("url", false);
        c0327b0.l("survey_option_id", false);
        descriptor = c0327b0;
    }

    private BackendEvent$CustomerCenter$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b[] bVarArr = BackendEvent.CustomerCenter.$childSerializers;
        o0 o0Var = o0.f952a;
        return new b[]{o0Var, H.f874a, bVarArr[2], o0Var, o0Var, O.f882a, C0335h.f929a, o0Var, bVarArr[8], G3.a.p(bVarArr[9]), G3.a.p(o0Var), G3.a.p(o0Var)};
    }

    @Override // F3.a
    public BackendEvent.CustomerCenter deserialize(e decoder) {
        Object objM;
        Object objY;
        String str;
        Object objY2;
        int i4;
        Object objY3;
        Object objM2;
        String strV;
        String strV2;
        String strV3;
        boolean z4;
        int iH;
        long j4;
        int i5;
        int i6;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        b[] bVarArr = BackendEvent.CustomerCenter.$childSerializers;
        int i7 = 10;
        int i8 = 7;
        int i9 = 6;
        String strV4 = null;
        if (cVarD.w()) {
            String strV5 = cVarD.v(descriptor2, 0);
            iH = cVarD.h(descriptor2, 1);
            Object objM3 = cVarD.m(descriptor2, 2, bVarArr[2], null);
            strV = cVarD.v(descriptor2, 3);
            strV2 = cVarD.v(descriptor2, 4);
            j4 = cVarD.j(descriptor2, 5);
            boolean zN = cVarD.n(descriptor2, 6);
            strV3 = cVarD.v(descriptor2, 7);
            objM2 = cVarD.m(descriptor2, 8, bVarArr[8], null);
            objY3 = cVarD.y(descriptor2, 9, bVarArr[9], null);
            o0 o0Var = o0.f952a;
            Object objY4 = cVarD.y(descriptor2, 10, o0Var, null);
            objY2 = cVarD.y(descriptor2, 11, o0Var, null);
            i4 = 4095;
            str = strV5;
            objM = objM3;
            objY = objY4;
            z4 = zN;
        } else {
            objM = null;
            Object objY5 = null;
            String strV6 = null;
            boolean z5 = true;
            int i10 = 0;
            boolean zN2 = false;
            int iH2 = 0;
            long j5 = 0;
            objY = null;
            Object objY6 = null;
            Object objM4 = null;
            String strV7 = null;
            String strV8 = null;
            while (z5) {
                int i11 = cVarD.i(descriptor2);
                switch (i11) {
                    case -1:
                        z5 = false;
                        break;
                    case 0:
                        i10 |= 1;
                        i9 = i9;
                        strV4 = cVarD.v(descriptor2, 0);
                        i7 = 10;
                        i8 = 7;
                        break;
                    case 1:
                        i5 = i9;
                        iH2 = cVarD.h(descriptor2, 1);
                        i10 |= 2;
                        i9 = i5;
                        i7 = 10;
                        i8 = 7;
                        break;
                    case 2:
                        i5 = i9;
                        objM = cVarD.m(descriptor2, 2, bVarArr[2], objM);
                        i10 |= 4;
                        i9 = i5;
                        i7 = 10;
                        i8 = 7;
                        break;
                    case 3:
                        i6 = i9;
                        strV7 = cVarD.v(descriptor2, 3);
                        i10 |= 8;
                        i9 = i6;
                        i7 = 10;
                        break;
                    case 4:
                        i6 = i9;
                        strV8 = cVarD.v(descriptor2, 4);
                        i10 |= 16;
                        i9 = i6;
                        i7 = 10;
                        break;
                    case 5:
                        j5 = cVarD.j(descriptor2, 5);
                        i10 |= 32;
                        i9 = i9;
                        i7 = 10;
                        break;
                    case 6:
                        int i12 = i9;
                        zN2 = cVarD.n(descriptor2, i12);
                        i10 |= 64;
                        i9 = i12;
                        break;
                    case 7:
                        strV6 = cVarD.v(descriptor2, i8);
                        i10 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        i9 = 6;
                        break;
                    case 8:
                        objM4 = cVarD.m(descriptor2, 8, bVarArr[8], objM4);
                        i10 |= 256;
                        i9 = 6;
                        break;
                    case 9:
                        objY6 = cVarD.y(descriptor2, 9, bVarArr[9], objY6);
                        i10 |= 512;
                        i9 = 6;
                        break;
                    case 10:
                        objY = cVarD.y(descriptor2, i7, o0.f952a, objY);
                        i10 |= UserMetadata.MAX_ATTRIBUTE_SIZE;
                        i9 = 6;
                        break;
                    case 11:
                        objY5 = cVarD.y(descriptor2, 11, o0.f952a, objY5);
                        i10 |= 2048;
                        i9 = 6;
                        break;
                    default:
                        throw new j(i11);
                }
            }
            str = strV4;
            objY2 = objY5;
            i4 = i10;
            objY3 = objY6;
            objM2 = objM4;
            strV = strV7;
            strV2 = strV8;
            strV3 = strV6;
            z4 = zN2;
            iH = iH2;
            j4 = j5;
        }
        cVarD.c(descriptor2);
        String str2 = (String) objY;
        return new BackendEvent.CustomerCenter(i4, str, iH, (CustomerCenterEventType) objM, strV, strV2, j4, z4, strV3, (CustomerCenterDisplayMode) objM2, (CustomerCenterConfigData.HelpPath.PathType) objY3, str2, (String) objY2, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, BackendEvent.CustomerCenter value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        BackendEvent.CustomerCenter.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
