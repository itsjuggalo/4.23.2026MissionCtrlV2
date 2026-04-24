package com.revenuecat.purchases.common.events;

import W2.m;
import com.revenuecat.purchases.common.events.BackendEvent;
import com.revenuecat.purchases.common.events.BackendStoredEvent;
import com.revenuecat.purchases.customercenter.events.CustomerCenterImpressionEvent;
import com.revenuecat.purchases.customercenter.events.CustomerCenterSurveyOptionChosenEvent;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class BackendStoredEventKt {
    public static final BackendEvent toBackendEvent(BackendStoredEvent backendStoredEvent) {
        r.f(backendStoredEvent, "<this>");
        if (backendStoredEvent instanceof BackendStoredEvent.Paywalls) {
            return ((BackendStoredEvent.Paywalls) backendStoredEvent).getEvent();
        }
        if (backendStoredEvent instanceof BackendStoredEvent.CustomerCenter) {
            return ((BackendStoredEvent.CustomerCenter) backendStoredEvent).getEvent();
        }
        throw new m();
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(PaywallEvent paywallEvent, String appUserID) {
        r.f(paywallEvent, "<this>");
        r.f(appUserID, "appUserID");
        String string = paywallEvent.getCreationData().getId().toString();
        r.e(string, "creationData.id.toString()");
        String value = paywallEvent.getType().getValue();
        String string2 = paywallEvent.getData().getSessionIdentifier().toString();
        r.e(string2, "data.sessionIdentifier.toString()");
        return new BackendStoredEvent.Paywalls(new BackendEvent.Paywalls(string, 1, value, appUserID, string2, paywallEvent.getData().getOfferingIdentifier(), paywallEvent.getData().getPaywallRevision(), paywallEvent.getCreationData().getDate().getTime(), paywallEvent.getData().getDisplayMode(), paywallEvent.getData().getDarkMode(), paywallEvent.getData().getLocaleIdentifier()));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(CustomerCenterImpressionEvent customerCenterImpressionEvent, String appUserID, String appSessionID) {
        r.f(customerCenterImpressionEvent, "<this>");
        r.f(appUserID, "appUserID");
        r.f(appSessionID, "appSessionID");
        String string = customerCenterImpressionEvent.getCreationData().getId().toString();
        r.e(string, "creationData.id.toString()");
        return new BackendStoredEvent.CustomerCenter(new BackendEvent.CustomerCenter(string, customerCenterImpressionEvent.getData().getRevisionID(), customerCenterImpressionEvent.getData().getType(), appUserID, appSessionID, customerCenterImpressionEvent.getData().getTimestamp().getTime(), customerCenterImpressionEvent.getData().getDarkMode(), customerCenterImpressionEvent.getData().getLocale(), customerCenterImpressionEvent.getData().getDisplayMode(), null, null, null));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(CustomerCenterSurveyOptionChosenEvent customerCenterSurveyOptionChosenEvent, String appUserID, String appSessionID) {
        r.f(customerCenterSurveyOptionChosenEvent, "<this>");
        r.f(appUserID, "appUserID");
        r.f(appSessionID, "appSessionID");
        String string = customerCenterSurveyOptionChosenEvent.getCreationData().getId().toString();
        r.e(string, "creationData.id.toString()");
        return new BackendStoredEvent.CustomerCenter(new BackendEvent.CustomerCenter(string, customerCenterSurveyOptionChosenEvent.getData().getRevisionID(), customerCenterSurveyOptionChosenEvent.getData().getType(), appUserID, appSessionID, customerCenterSurveyOptionChosenEvent.getData().getTimestamp().getTime(), customerCenterSurveyOptionChosenEvent.getData().getDarkMode(), customerCenterSurveyOptionChosenEvent.getData().getLocale(), customerCenterSurveyOptionChosenEvent.getData().getDisplayMode(), customerCenterSurveyOptionChosenEvent.getData().getPath(), customerCenterSurveyOptionChosenEvent.getData().getUrl(), customerCenterSurveyOptionChosenEvent.getData().getSurveyOptionID()));
    }
}
