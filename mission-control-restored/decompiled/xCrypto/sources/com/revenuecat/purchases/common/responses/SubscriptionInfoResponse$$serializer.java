package com.revenuecat.purchases.common.responses;

import F3.b;
import F3.j;
import G3.a;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.C0335h;
import J3.k0;
import J3.o0;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import com.revenuecat.purchases.OwnershipType;
import com.revenuecat.purchases.PeriodType;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.common.responses.SubscriptionInfoResponse;
import com.revenuecat.purchases.utils.serializers.ISO8601DateSerializer;
import java.util.Date;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class SubscriptionInfoResponse$$serializer implements C {
    public static final SubscriptionInfoResponse$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        SubscriptionInfoResponse$$serializer subscriptionInfoResponse$$serializer = new SubscriptionInfoResponse$$serializer();
        INSTANCE = subscriptionInfoResponse$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.common.responses.SubscriptionInfoResponse", subscriptionInfoResponse$$serializer, 17);
        c0327b0.l("purchase_date", false);
        c0327b0.l("original_purchase_date", true);
        c0327b0.l("expires_date", true);
        c0327b0.l(ProductResponseJsonKeys.STORE, false);
        c0327b0.l(ProductResponseJsonKeys.IS_SANDBOX, false);
        c0327b0.l(ProductResponseJsonKeys.UNSUBSCRIBE_DETECTED_AT, true);
        c0327b0.l(ProductResponseJsonKeys.BILLING_ISSUES_DETECTED_AT, true);
        c0327b0.l("grace_period_expires_date", true);
        c0327b0.l(ProductResponseJsonKeys.OWNERSHIP_TYPE, true);
        c0327b0.l(ProductResponseJsonKeys.PERIOD_TYPE, false);
        c0327b0.l("refunded_at", true);
        c0327b0.l("store_transaction_id", true);
        c0327b0.l("auto_resume_date", true);
        c0327b0.l("display_name", true);
        c0327b0.l("price", true);
        c0327b0.l("product_plan_identifier", true);
        c0327b0.l("management_url", true);
        descriptor = c0327b0;
    }

    private SubscriptionInfoResponse$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b[] bVarArr = SubscriptionInfoResponse.$childSerializers;
        ISO8601DateSerializer iSO8601DateSerializer = ISO8601DateSerializer.INSTANCE;
        b bVarP = a.p(iSO8601DateSerializer);
        b bVarP2 = a.p(iSO8601DateSerializer);
        b bVar = bVarArr[3];
        b bVarP3 = a.p(iSO8601DateSerializer);
        b bVarP4 = a.p(iSO8601DateSerializer);
        b bVarP5 = a.p(iSO8601DateSerializer);
        b bVar2 = bVarArr[8];
        b bVar3 = bVarArr[9];
        b bVarP6 = a.p(iSO8601DateSerializer);
        o0 o0Var = o0.f952a;
        return new b[]{iSO8601DateSerializer, bVarP, bVarP2, bVar, C0335h.f929a, bVarP3, bVarP4, bVarP5, bVar2, bVar3, bVarP6, a.p(o0Var), a.p(iSO8601DateSerializer), a.p(o0Var), a.p(SubscriptionInfoResponse$PriceResponse$$serializer.INSTANCE), a.p(o0Var), a.p(o0Var)};
    }

    @Override // F3.a
    public SubscriptionInfoResponse deserialize(e decoder) {
        int i4;
        Object objY;
        Object objY2;
        Object obj;
        Object obj2;
        Object obj3;
        Object objY3;
        Object objY4;
        boolean z4;
        Object objY5;
        Object objY6;
        Object objM;
        Object objY7;
        Object objM2;
        Object objY8;
        Object objY9;
        Object obj4;
        Object objY10;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        b[] bVarArr = SubscriptionInfoResponse.$childSerializers;
        if (cVarD.w()) {
            ISO8601DateSerializer iSO8601DateSerializer = ISO8601DateSerializer.INSTANCE;
            Object objM3 = cVarD.m(descriptor2, 0, iSO8601DateSerializer, null);
            objY9 = cVarD.y(descriptor2, 1, iSO8601DateSerializer, null);
            objY8 = cVarD.y(descriptor2, 2, iSO8601DateSerializer, null);
            objM2 = cVarD.m(descriptor2, 3, bVarArr[3], null);
            boolean zN = cVarD.n(descriptor2, 4);
            objY5 = cVarD.y(descriptor2, 5, iSO8601DateSerializer, null);
            objY7 = cVarD.y(descriptor2, 6, iSO8601DateSerializer, null);
            objY3 = cVarD.y(descriptor2, 7, iSO8601DateSerializer, null);
            objM = cVarD.m(descriptor2, 8, bVarArr[8], null);
            Object objM4 = cVarD.m(descriptor2, 9, bVarArr[9], null);
            objY6 = cVarD.y(descriptor2, 10, iSO8601DateSerializer, null);
            o0 o0Var = o0.f952a;
            objY4 = cVarD.y(descriptor2, 11, o0Var, null);
            objY10 = cVarD.y(descriptor2, 12, iSO8601DateSerializer, null);
            objY2 = cVarD.y(descriptor2, 13, o0Var, null);
            Object objY11 = cVarD.y(descriptor2, 14, SubscriptionInfoResponse$PriceResponse$$serializer.INSTANCE, null);
            Object objY12 = cVarD.y(descriptor2, 15, o0Var, null);
            i4 = 131071;
            objY = cVarD.y(descriptor2, 16, o0Var, null);
            obj2 = objM3;
            obj = objY12;
            z4 = zN;
            obj4 = objY11;
            obj3 = objM4;
        } else {
            boolean zN2 = false;
            int i5 = 3;
            int i6 = 8;
            boolean z5 = true;
            Object objY13 = null;
            Object objY14 = null;
            Object objY15 = null;
            Object objY16 = null;
            Object objM5 = null;
            Object objM6 = null;
            Object objM7 = null;
            Object objY17 = null;
            Object objY18 = null;
            Object objM8 = null;
            Object objY19 = null;
            Object objY20 = null;
            Object objY21 = null;
            Object objY22 = null;
            int i7 = 9;
            i4 = 0;
            Object objY23 = null;
            Object objY24 = null;
            while (z5) {
                int i8 = cVarD.i(descriptor2);
                switch (i8) {
                    case -1:
                        z5 = false;
                        i5 = 3;
                        i6 = 8;
                        i7 = 9;
                        objM5 = objM5;
                        objY13 = objY13;
                        break;
                    case 0:
                        i4 |= 1;
                        objM5 = cVarD.m(descriptor2, 0, ISO8601DateSerializer.INSTANCE, objM5);
                        objY13 = objY13;
                        objY19 = objY19;
                        i5 = 3;
                        i6 = 8;
                        i7 = 9;
                        break;
                    case 1:
                        obj5 = objY13;
                        obj6 = objM5;
                        objY23 = cVarD.y(descriptor2, 1, ISO8601DateSerializer.INSTANCE, objY23);
                        i4 |= 2;
                        objY13 = obj5;
                        objM5 = obj6;
                        i5 = 3;
                        i6 = 8;
                        i7 = 9;
                        break;
                    case 2:
                        obj5 = objY13;
                        obj6 = objM5;
                        objY16 = cVarD.y(descriptor2, 2, ISO8601DateSerializer.INSTANCE, objY16);
                        i4 |= 4;
                        objY13 = obj5;
                        objM5 = obj6;
                        i5 = 3;
                        i6 = 8;
                        i7 = 9;
                        break;
                    case 3:
                        obj7 = objY13;
                        obj8 = objM5;
                        objM8 = cVarD.m(descriptor2, i5, bVarArr[i5], objM8);
                        i4 |= 8;
                        objY13 = obj7;
                        objM5 = obj8;
                        i6 = 8;
                        i7 = 9;
                        break;
                    case 4:
                        obj7 = objY13;
                        obj8 = objM5;
                        zN2 = cVarD.n(descriptor2, 4);
                        i4 |= 16;
                        objY13 = obj7;
                        objM5 = obj8;
                        i6 = 8;
                        i7 = 9;
                        break;
                    case 5:
                        obj7 = objY13;
                        obj8 = objM5;
                        objY14 = cVarD.y(descriptor2, 5, ISO8601DateSerializer.INSTANCE, objY14);
                        i4 |= 32;
                        objY13 = obj7;
                        objM5 = obj8;
                        i6 = 8;
                        i7 = 9;
                        break;
                    case 6:
                        obj7 = objY13;
                        obj8 = objM5;
                        objY18 = cVarD.y(descriptor2, 6, ISO8601DateSerializer.INSTANCE, objY18);
                        i4 |= 64;
                        objY13 = obj7;
                        objM5 = obj8;
                        i6 = 8;
                        i7 = 9;
                        break;
                    case 7:
                        obj7 = objY13;
                        obj8 = objM5;
                        objY17 = cVarD.y(descriptor2, 7, ISO8601DateSerializer.INSTANCE, objY17);
                        i4 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        objY13 = obj7;
                        objM5 = obj8;
                        i6 = 8;
                        i7 = 9;
                        break;
                    case 8:
                        objM7 = cVarD.m(descriptor2, i6, bVarArr[i6], objM7);
                        i4 |= 256;
                        objY13 = objY13;
                        objM5 = objM5;
                        i7 = 9;
                        break;
                    case 9:
                        obj9 = objY13;
                        obj10 = objM5;
                        objM6 = cVarD.m(descriptor2, i7, bVarArr[i7], objM6);
                        i4 |= 512;
                        objY13 = obj9;
                        objM5 = obj10;
                        break;
                    case 10:
                        obj9 = objY13;
                        obj10 = objM5;
                        objY15 = cVarD.y(descriptor2, 10, ISO8601DateSerializer.INSTANCE, objY15);
                        i4 |= UserMetadata.MAX_ATTRIBUTE_SIZE;
                        objY13 = obj9;
                        objM5 = obj10;
                        break;
                    case 11:
                        obj9 = objY13;
                        obj10 = objM5;
                        objY24 = cVarD.y(descriptor2, 11, o0.f952a, objY24);
                        i4 |= 2048;
                        objY13 = obj9;
                        objM5 = obj10;
                        break;
                    case 12:
                        obj10 = objM5;
                        objY19 = cVarD.y(descriptor2, 12, ISO8601DateSerializer.INSTANCE, objY19);
                        i4 |= 4096;
                        objY13 = objY13;
                        objY20 = objY20;
                        objM5 = obj10;
                        break;
                    case 13:
                        obj10 = objM5;
                        objY20 = cVarD.y(descriptor2, 13, o0.f952a, objY20);
                        i4 |= UserMetadata.MAX_INTERNAL_KEY_SIZE;
                        objY13 = objY13;
                        objY21 = objY21;
                        objM5 = obj10;
                        break;
                    case 14:
                        obj10 = objM5;
                        objY21 = cVarD.y(descriptor2, 14, SubscriptionInfoResponse$PriceResponse$$serializer.INSTANCE, objY21);
                        i4 |= 16384;
                        objY13 = objY13;
                        objY22 = objY22;
                        objM5 = obj10;
                        break;
                    case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                        obj10 = objM5;
                        obj9 = objY13;
                        objY22 = cVarD.y(descriptor2, 15, o0.f952a, objY22);
                        i4 |= 32768;
                        objY13 = obj9;
                        objM5 = obj10;
                        break;
                    case 16:
                        objY13 = cVarD.y(descriptor2, 16, o0.f952a, objY13);
                        i4 |= 65536;
                        objM5 = objM5;
                        break;
                    default:
                        throw new j(i8);
                }
            }
            objY = objY13;
            objY2 = objY20;
            obj = objY22;
            obj2 = objM5;
            obj3 = objM6;
            objY3 = objY17;
            objY4 = objY24;
            z4 = zN2;
            objY5 = objY14;
            objY6 = objY15;
            objM = objM7;
            objY7 = objY18;
            objM2 = objM8;
            objY8 = objY16;
            objY9 = objY23;
            obj4 = objY21;
            objY10 = objY19;
        }
        int i9 = i4;
        cVarD.c(descriptor2);
        return new SubscriptionInfoResponse(i9, (Date) obj2, (Date) objY9, (Date) objY8, (Store) objM2, z4, (Date) objY5, (Date) objY7, (Date) objY3, (OwnershipType) objM, (PeriodType) obj3, (Date) objY6, (String) objY4, (Date) objY10, (String) objY2, (SubscriptionInfoResponse.PriceResponse) obj4, (String) obj, (String) objY, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, SubscriptionInfoResponse value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        SubscriptionInfoResponse.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
