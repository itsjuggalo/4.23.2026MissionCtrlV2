package com.revenuecat.purchases.amazon.attribution;

import E5.t;
import F5.J;
import Q5.k;
import android.app.Application;
import android.content.ContentResolver;
import android.provider.Settings;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher;
import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import com.revenuecat.purchases.strings.AttributionStrings;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.util.Arrays;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class AmazonDeviceIdentifiersFetcher implements DeviceIdentifiersFetcher {
    @Override // com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher
    public void getDeviceIdentifiers(Application applicationContext, k completion) {
        ContentResolver contentResolver;
        r.f(applicationContext, "applicationContext");
        r.f(completion, "completion");
        try {
            contentResolver = applicationContext.getContentResolver();
        } catch (Settings.SettingNotFoundException e7) {
            LogIntent logIntent = LogIntent.AMAZON_ERROR;
            String str = String.format(AttributionStrings.AMAZON_COULD_NOT_GET_ADID, Arrays.copyOf(new Object[]{e7.getLocalizedMessage()}, 1));
            r.e(str, "format(this, *args)");
            LogWrapperKt.log(logIntent, str);
        }
        String string = Settings.Secure.getInt(contentResolver, "limit_ad_tracking") == 0 ? Settings.Secure.getString(contentResolver, "advertising_id") : null;
        completion.invoke(MapExtensionsKt.filterNotNullValues(J.g(t.a(SubscriberAttributeKey.DeviceIdentifiers.AmazonAdID.INSTANCE.getBackendKey(), string), t.a(SubscriberAttributeKey.DeviceIdentifiers.IP.INSTANCE.getBackendKey(), b.af), t.a(SubscriberAttributeKey.DeviceIdentifiers.DeviceVersion.INSTANCE.getBackendKey(), b.af))));
    }
}
