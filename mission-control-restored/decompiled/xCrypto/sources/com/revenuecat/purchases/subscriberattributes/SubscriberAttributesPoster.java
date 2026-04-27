package com.revenuecat.purchases.subscriberattributes;

import W2.E;
import W2.t;
import X2.AbstractC0769p;
import X2.K;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.BackendHelper;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.SubscriberAttributeError;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import i3.k;
import i3.p;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscriberAttributesPoster {
    private final BackendHelper backendHelper;

    /* JADX INFO: renamed from: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesPoster$postSubscriberAttributes$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        final /* synthetic */ p $onErrorHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(p pVar) {
            super(1);
            this.$onErrorHandler = pVar;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError error) {
            r.f(error, "error");
            this.$onErrorHandler.invoke(error, Boolean.FALSE, AbstractC0769p.g());
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesPoster$postSubscriberAttributes$2, reason: invalid class name */
    public static final class AnonymousClass2 extends s implements p {
        final /* synthetic */ p $onErrorHandler;
        final /* synthetic */ Function0 $onSuccessHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function0 function0, p pVar) {
            super(3);
            this.$onSuccessHandler = function0;
            this.$onErrorHandler = pVar;
        }

        @Override // i3.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) throws JSONException {
            invoke((PurchasesError) obj, ((Number) obj2).intValue(), (JSONObject) obj3);
            return E.f5463a;
        }

        public final void invoke(PurchasesError purchasesError, int i4, JSONObject body) throws JSONException {
            E e4;
            r.f(body, "body");
            if (purchasesError != null) {
                p pVar = this.$onErrorHandler;
                boolean zIsServerError = RCHTTPStatusCodes.INSTANCE.isServerError(i4);
                boolean z4 = false;
                boolean z5 = i4 == 404;
                if (!zIsServerError && !z5) {
                    z4 = true;
                }
                List<SubscriberAttributeError> listG = AbstractC0769p.g();
                if (purchasesError.getCode() == PurchasesErrorCode.InvalidSubscriberAttributesError) {
                    listG = BackendHelpersKt.getAttributeErrors(body);
                }
                pVar.invoke(purchasesError, Boolean.valueOf(z4), listG);
                e4 = E.f5463a;
            } else {
                e4 = null;
            }
            if (e4 == null) {
                this.$onSuccessHandler.invoke();
            }
        }
    }

    public SubscriberAttributesPoster(BackendHelper backendHelper) {
        r.f(backendHelper, "backendHelper");
        this.backendHelper = backendHelper;
    }

    public final void postSubscriberAttributes(Map<String, ? extends Map<String, ? extends Object>> attributes, String appUserID, Function0 onSuccessHandler, p onErrorHandler) {
        r.f(attributes, "attributes");
        r.f(appUserID, "appUserID");
        r.f(onSuccessHandler, "onSuccessHandler");
        r.f(onErrorHandler, "onErrorHandler");
        this.backendHelper.performRequest(new Endpoint.PostAttributes(appUserID), K.c(t.a("attributes", attributes)), null, Delay.DEFAULT, new AnonymousClass1(onErrorHandler), new AnonymousClass2(onSuccessHandler, onErrorHandler));
    }
}
