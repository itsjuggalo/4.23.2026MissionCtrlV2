package com.revenuecat.purchases.hybridcommon;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.Purchases;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0010$\n\u0002\b\f\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0017\u0010\u0005\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\u0006\u001a\u0017\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u0006\u001a\u0017\u0010\f\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\u0006\u001a\u0017\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u0006\u001a\u0017\u0010\u0010\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0006\u001a\u0017\u0010\u0012\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0006\u001a\u0017\u0010\u0014\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0014\u0010\u0006\u001a\u0017\u0010\u0016\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0016\u0010\u0006\u001a\u0017\u0010\u0018\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0018\u0010\u0006\u001a\u0017\u0010\u001a\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001a\u0010\u0006\u001a\u0017\u0010\u001c\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001c\u0010\u0006\u001a\u0017\u0010\u001e\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001e\u0010\u0006\u001a\u0017\u0010 \u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b \u0010\u0006\u001a\u0017\u0010\"\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\"\u0010\u0006\u001a\u0017\u0010$\u001a\u00020\u00002\b\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b$\u0010\u0006\u001a\u0017\u0010&\u001a\u00020\u00002\b\u0010%\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b&\u0010\u0006\u001a\u0017\u0010(\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b(\u0010\u0006\u001a\u0017\u0010*\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b*\u0010\u0006\u001a#\u0010-\u001a\u00020\u00002\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030+¢\u0006\u0004\b-\u0010.\u001a\u0017\u00100\u001a\u00020\u00002\b\u0010/\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b0\u0010\u0006\u001a\u0017\u00102\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b2\u0010\u0006\u001a\u0017\u00104\u001a\u00020\u00002\b\u00103\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b4\u0010\u0006\u001a\u0017\u00106\u001a\u00020\u00002\b\u00105\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b6\u0010\u0006¨\u00067"}, d2 = {"Lo5/H;", "collectDeviceIdentifiers", "()V", "", "adjustID", "setAdjustID", "(Ljava/lang/String;)V", "appsflyerID", "setAppsflyerID", "fbAnonymousID", "setFBAnonymousID", "mparticleID", "setMparticleID", "cleverTapID", "setCleverTapID", "kochavaDeviceID", "setKochavaDeviceID", "mixpanelDistinctID", "setMixpanelDistinctID", "firebaseAppInstanceID", "setFirebaseAppInstanceID", "tenjinAnalyticsInstallationID", "setTenjinAnalyticsInstallationID", "onesignalID", "setOnesignalID", "onesignalUserID", "setOnesignalUserID", "airshipChannelID", "setAirshipChannelID", "postHogUserID", "setPostHogUserID", "mediaSource", "setMediaSource", FirebaseAnalytics.Param.CAMPAIGN, "setCampaign", "adGroup", "setAdGroup", "ad", "setAd", "keyword", "setKeyword", "creative", "setCreative", "", "attributes", "setAttributes", "(Ljava/util/Map;)V", "email", "setEmail", "phoneNumber", "setPhoneNumber", "displayName", "setDisplayName", "fcmToken", "setPushToken", "hybridcommon_release"}, k = 2, mv = {1, 8, 0})
public final class SubscriberAttributesKt {
    public static final void collectDeviceIdentifiers() {
        Purchases.INSTANCE.getSharedInstance().collectDeviceIdentifiers();
    }

    public static final void setAd(String str) {
        Purchases.INSTANCE.getSharedInstance().setAd(str);
    }

    public static final void setAdGroup(String str) {
        Purchases.INSTANCE.getSharedInstance().setAdGroup(str);
    }

    public static final void setAdjustID(String str) {
        Purchases.INSTANCE.getSharedInstance().setAdjustID(str);
    }

    public static final void setAirshipChannelID(String str) {
        Purchases.INSTANCE.getSharedInstance().setAirshipChannelID(str);
    }

    public static final void setAppsflyerID(String str) {
        Purchases.INSTANCE.getSharedInstance().setAppsflyerID(str);
    }

    public static final void setAttributes(Map<String, String> attributes) {
        AbstractC2304t.f(attributes, "attributes");
        Purchases.INSTANCE.getSharedInstance().setAttributes(attributes);
    }

    public static final void setCampaign(String str) {
        Purchases.INSTANCE.getSharedInstance().setCampaign(str);
    }

    public static final void setCleverTapID(String str) {
        Purchases.INSTANCE.getSharedInstance().setCleverTapID(str);
    }

    public static final void setCreative(String str) {
        Purchases.INSTANCE.getSharedInstance().setCreative(str);
    }

    public static final void setDisplayName(String str) {
        Purchases.INSTANCE.getSharedInstance().setDisplayName(str);
    }

    public static final void setEmail(String str) {
        Purchases.INSTANCE.getSharedInstance().setEmail(str);
    }

    public static final void setFBAnonymousID(String str) {
        Purchases.INSTANCE.getSharedInstance().setFBAnonymousID(str);
    }

    public static final void setFirebaseAppInstanceID(String str) {
        Purchases.INSTANCE.getSharedInstance().setFirebaseAppInstanceID(str);
    }

    public static final void setKeyword(String str) {
        Purchases.INSTANCE.getSharedInstance().setKeyword(str);
    }

    public static final void setKochavaDeviceID(String str) {
        Purchases.INSTANCE.getSharedInstance().setKochavaDeviceID(str);
    }

    public static final void setMediaSource(String str) {
        Purchases.INSTANCE.getSharedInstance().setMediaSource(str);
    }

    public static final void setMixpanelDistinctID(String str) {
        Purchases.INSTANCE.getSharedInstance().setMixpanelDistinctID(str);
    }

    public static final void setMparticleID(String str) {
        Purchases.INSTANCE.getSharedInstance().setMparticleID(str);
    }

    public static final void setOnesignalID(String str) {
        Purchases.INSTANCE.getSharedInstance().setOnesignalID(str);
    }

    public static final void setOnesignalUserID(String str) {
        Purchases.INSTANCE.getSharedInstance().setOnesignalUserID(str);
    }

    public static final void setPhoneNumber(String str) {
        Purchases.INSTANCE.getSharedInstance().setPhoneNumber(str);
    }

    public static final void setPostHogUserID(String str) {
        Purchases.INSTANCE.getSharedInstance().setPostHogUserId(str);
    }

    public static final void setPushToken(String str) {
        Purchases.INSTANCE.getSharedInstance().setPushToken(str);
    }

    public static final void setTenjinAnalyticsInstallationID(String str) {
        Purchases.INSTANCE.getSharedInstance().setTenjinAnalyticsInstallationID(str);
    }
}
