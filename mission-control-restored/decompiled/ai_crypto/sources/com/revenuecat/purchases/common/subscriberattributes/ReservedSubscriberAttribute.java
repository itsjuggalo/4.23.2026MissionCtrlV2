package com.revenuecat.purchases.common.subscriberattributes;

/* JADX INFO: loaded from: classes2.dex */
public enum ReservedSubscriberAttribute {
    EMAIL("$email"),
    DISPLAY_NAME("$displayName"),
    PHONE_NUMBER("$phoneNumber"),
    FCM_TOKENS("$fcmTokens"),
    IDFA("$idfa"),
    IDFV("$idfv"),
    IP("$ip"),
    DEVICE_VERSION("$deviceVersion"),
    GPS_AD_ID("$gpsAdId"),
    AMAZON_AD_ID("$amazonAdId"),
    ADJUST_ID("$adjustId"),
    APPSFLYER_ID("$appsflyerId"),
    FB_ANON_ID("$fbAnonId"),
    MPARTICLE_ID("$mparticleId"),
    ONESIGNAL_ID("$onesignalId"),
    ONESIGNAL_USER_ID("$onesignalUserId"),
    AIRSHIP_CHANNEL_ID("$airshipChannelId"),
    CLEVER_TAP_ID("$clevertapId"),
    KOCHAVA_DEVICE_ID("$kochavaDeviceId"),
    MIXPANEL_DISTINCT_ID("$mixpanelDistinctId"),
    FIREBASE_APP_INSTANCE_ID("$firebaseAppInstanceId"),
    TENJIN_ANALYTICS_INSTALLATION_ID("$tenjinId"),
    MEDIA_SOURCE("$mediaSource"),
    CAMPAIGN("$campaign"),
    AD_GROUP("$adGroup"),
    AD("$ad"),
    KEYWORD("$keyword"),
    CREATIVE("$creative");

    private final String value;

    ReservedSubscriberAttribute(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
