package com.revenuecat.purchases.amazon.attribution;

import B5.k;
import D3.m;
import android.app.Application;
import android.content.ContentResolver;
import android.provider.Settings;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher;
import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import o5.w;
import p5.M;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u001e\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/revenuecat/purchases/amazon/attribution/AmazonDeviceIdentifiersFetcher;", "Lcom/revenuecat/purchases/common/subscriberattributes/DeviceIdentifiersFetcher;", "<init>", "()V", "Landroid/app/Application;", "applicationContext", "Lkotlin/Function1;", "", "", "Lo5/H;", "completion", "getDeviceIdentifiers", "(Landroid/app/Application;LB5/k;)V", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public final class AmazonDeviceIdentifiersFetcher implements DeviceIdentifiersFetcher {
    @Override // com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher
    public void getDeviceIdentifiers(Application applicationContext, k completion) {
        LogLevel logLevel;
        LogHandler currentLogHandler;
        StringBuilder sb;
        LogLevel logLevel2;
        LogHandler currentLogHandler2;
        StringBuilder sb2;
        LogLevel logLevel3;
        LogHandler currentLogHandler3;
        StringBuilder sb3;
        AbstractC2304t.f(applicationContext, "applicationContext");
        AbstractC2304t.f(completion, "completion");
        String string = null;
        try {
            ContentResolver contentResolver = applicationContext.getContentResolver();
            if (Settings.Secure.getInt(contentResolver, "limit_ad_tracking") == 0) {
                string = Settings.Secure.getString(contentResolver, "advertising_id");
            }
        } catch (Settings.SettingNotFoundException e8) {
            LogIntent logIntent = LogIntent.AMAZON_ERROR;
            AmazonDeviceIdentifiersFetcher$getDeviceIdentifiers$$inlined$log$1 amazonDeviceIdentifiersFetcher$getDeviceIdentifiers$$inlined$log$1 = new AmazonDeviceIdentifiersFetcher$getDeviceIdentifiers$$inlined$log$1(logIntent, e8);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        sb = new StringBuilder();
                        sb.append("[Purchases] - ");
                        sb.append(logLevel.name());
                        currentLogHandler.d(sb.toString(), (String) amazonDeviceIdentifiersFetcher$getDeviceIdentifiers$$inlined$log$1.invoke());
                    }
                    break;
                case 2:
                case 6:
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) amazonDeviceIdentifiersFetcher$getDeviceIdentifiers$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    logLevel2 = LogLevel.WARN;
                    currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        sb2 = new StringBuilder();
                        sb2.append("[Purchases] - ");
                        sb2.append(logLevel2.name());
                        currentLogHandler2.w(sb2.toString(), (String) amazonDeviceIdentifiersFetcher$getDeviceIdentifiers$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    logLevel3 = LogLevel.INFO;
                    currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        sb3 = new StringBuilder();
                        sb3.append("[Purchases] - ");
                        sb3.append(logLevel3.name());
                        currentLogHandler3.i(sb3.toString(), (String) amazonDeviceIdentifiersFetcher$getDeviceIdentifiers$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        sb = new StringBuilder();
                        sb.append("[Purchases] - ");
                        sb.append(logLevel.name());
                        currentLogHandler.d(sb.toString(), (String) amazonDeviceIdentifiersFetcher$getDeviceIdentifiers$$inlined$log$1.invoke());
                    }
                    break;
                case 7:
                    logLevel3 = LogLevel.INFO;
                    currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        sb3 = new StringBuilder();
                        sb3.append("[Purchases] - ");
                        sb3.append(logLevel3.name());
                        currentLogHandler3.i(sb3.toString(), (String) amazonDeviceIdentifiersFetcher$getDeviceIdentifiers$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        sb = new StringBuilder();
                        sb.append("[Purchases] - ");
                        sb.append(logLevel.name());
                        currentLogHandler.d(sb.toString(), (String) amazonDeviceIdentifiersFetcher$getDeviceIdentifiers$$inlined$log$1.invoke());
                    }
                    break;
                case 9:
                    logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        sb = new StringBuilder();
                        sb.append("[Purchases] - ");
                        sb.append(logLevel.name());
                        currentLogHandler.d(sb.toString(), (String) amazonDeviceIdentifiersFetcher$getDeviceIdentifiers$$inlined$log$1.invoke());
                    }
                    break;
                case 10:
                    logLevel2 = LogLevel.WARN;
                    currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        sb2 = new StringBuilder();
                        sb2.append("[Purchases] - ");
                        sb2.append(logLevel2.name());
                        currentLogHandler2.w(sb2.toString(), (String) amazonDeviceIdentifiersFetcher$getDeviceIdentifiers$$inlined$log$1.invoke());
                    }
                    break;
                case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                    logLevel2 = LogLevel.WARN;
                    currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        sb2 = new StringBuilder();
                        sb2.append("[Purchases] - ");
                        sb2.append(logLevel2.name());
                        currentLogHandler2.w(sb2.toString(), (String) amazonDeviceIdentifiersFetcher$getDeviceIdentifiers$$inlined$log$1.invoke());
                    }
                    break;
            }
        }
        completion.invoke(MapExtensionsKt.filterNotNullValues(M.k(w.a(SubscriberAttributeKey.DeviceIdentifiers.AmazonAdID.INSTANCE.getBackendKey(), string), w.a(SubscriberAttributeKey.DeviceIdentifiers.IP.INSTANCE.getBackendKey(), b.af), w.a(SubscriberAttributeKey.DeviceIdentifiers.DeviceVersion.INSTANCE.getBackendKey(), b.af))));
    }
}
