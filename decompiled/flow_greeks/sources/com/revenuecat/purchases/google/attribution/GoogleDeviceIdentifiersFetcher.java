package com.revenuecat.purchases.google.attribution;

import android.app.Application;
import cd.w;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher;
import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import dd.o0;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import m5.g;
import m5.h;
import pd.k;
import x4.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ7\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u001e\u0010\u000e\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\f\u0012\u0004\u0012\u00020\r0\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/google/attribution/GoogleDeviceIdentifiersFetcher;", "Lcom/revenuecat/purchases/common/subscriberattributes/DeviceIdentifiersFetcher;", "Lcom/revenuecat/purchases/common/Dispatcher;", "dispatcher", "<init>", "(Lcom/revenuecat/purchases/common/Dispatcher;)V", "Landroid/app/Application;", "applicationContext", "", "getAdvertisingID", "(Landroid/app/Application;)Ljava/lang/String;", "Lkotlin/Function1;", "", "Lcd/h0;", "completion", "getDeviceIdentifiers", "(Landroid/app/Application;Lpd/k;)V", "Lcom/revenuecat/purchases/common/Dispatcher;", "noPermissionAdvertisingIdValue", "Ljava/lang/String;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GoogleDeviceIdentifiersFetcher implements DeviceIdentifiersFetcher {
    private final Dispatcher dispatcher;
    private final String noPermissionAdvertisingIdValue;

    public GoogleDeviceIdentifiersFetcher(Dispatcher dispatcher) {
        t.f(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.noPermissionAdvertisingIdValue = "00000000-0000-0000-0000-000000000000";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final String getAdvertisingID(Application applicationContext) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        try {
            a.C0423a c0423aA = x4.a.a(applicationContext);
            if (!c0423aA.b()) {
                if (!t.b(c0423aA.a(), this.noPermissionAdvertisingIdValue)) {
                    return c0423aA.a();
                }
                LogIntent logIntent = LogIntent.WARNING;
                GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$1 googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$1 = new GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$1(logIntent);
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            str = "[Purchases] - " + logLevel.name();
                            str2 = (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$1.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$1.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$1.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            str = "[Purchases] - " + logLevel4.name();
                            str2 = (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$1.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$1.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            str = "[Purchases] - " + logLevel6.name();
                            str2 = (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            str = "[Purchases] - " + logLevel7.name();
                            str2 = (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$1.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$1.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$1.invoke(), null);
                        break;
                }
            }
        } catch (IOException e10) {
            LogIntent logIntent2 = LogIntent.GOOGLE_ERROR;
            GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$5 googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$5 = new GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$5(logIntent2, e10);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                case 1:
                    LogLevel logLevel10 = LogLevel.DEBUG;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler7.d("[Purchases] - " + logLevel10.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$5.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$5.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel11 = LogLevel.WARN;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                        currentLogHandler8.w("[Purchases] - " + logLevel11.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$5.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel12 = LogLevel.INFO;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                        currentLogHandler9.i("[Purchases] - " + logLevel12.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$5.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel13 = LogLevel.DEBUG;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                        currentLogHandler10.d("[Purchases] - " + logLevel13.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$5.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$5.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel14 = LogLevel.INFO;
                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                        currentLogHandler11.i("[Purchases] - " + logLevel14.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$5.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel15 = LogLevel.DEBUG;
                    LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                        currentLogHandler12.d("[Purchases] - " + logLevel15.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$5.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel16 = LogLevel.DEBUG;
                    LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                        currentLogHandler13.d("[Purchases] - " + logLevel16.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$5.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel17 = LogLevel.WARN;
                    LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                        currentLogHandler14.w("[Purchases] - " + logLevel17.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$5.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel18 = LogLevel.WARN;
                    LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                        currentLogHandler15.w("[Purchases] - " + logLevel18.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$5.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$5.invoke(), null);
                    break;
            }
        } catch (NoSuchMethodError unused) {
            LogIntent logIntent3 = LogIntent.GOOGLE_ERROR;
            GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$7 googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$7 = new GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$7(logIntent3);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent3.ordinal()]) {
                case 1:
                    LogLevel logLevel19 = LogLevel.DEBUG;
                    LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                        currentLogHandler16.d("[Purchases] - " + logLevel19.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$7.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$7.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel20 = LogLevel.WARN;
                    LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                        currentLogHandler17.w("[Purchases] - " + logLevel20.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$7.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel21 = LogLevel.INFO;
                    LogHandler currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                        currentLogHandler18.i("[Purchases] - " + logLevel21.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$7.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel22 = LogLevel.DEBUG;
                    LogHandler currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                        currentLogHandler19.d("[Purchases] - " + logLevel22.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$7.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$7.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel23 = LogLevel.INFO;
                    LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                        currentLogHandler20.i("[Purchases] - " + logLevel23.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$7.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel24 = LogLevel.DEBUG;
                    LogHandler currentLogHandler21 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                        currentLogHandler21.d("[Purchases] - " + logLevel24.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$7.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel25 = LogLevel.DEBUG;
                    LogHandler currentLogHandler22 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                        currentLogHandler22.d("[Purchases] - " + logLevel25.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$7.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel26 = LogLevel.WARN;
                    LogHandler currentLogHandler23 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                        currentLogHandler23.w("[Purchases] - " + logLevel26.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$7.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel27 = LogLevel.WARN;
                    LogHandler currentLogHandler24 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                        currentLogHandler24.w("[Purchases] - " + logLevel27.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$7.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$7.invoke(), null);
                    break;
            }
        } catch (NullPointerException e11) {
            LogIntent logIntent4 = LogIntent.GOOGLE_ERROR;
            GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$6 googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$6 = new GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$6(logIntent4, e11);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent4.ordinal()]) {
                case 1:
                    LogLevel logLevel28 = LogLevel.DEBUG;
                    LogHandler currentLogHandler25 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel28) <= 0) {
                        currentLogHandler25.d("[Purchases] - " + logLevel28.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$6.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$6.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel29 = LogLevel.WARN;
                    LogHandler currentLogHandler26 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel29) <= 0) {
                        currentLogHandler26.w("[Purchases] - " + logLevel29.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$6.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel30 = LogLevel.INFO;
                    LogHandler currentLogHandler27 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel30) <= 0) {
                        currentLogHandler27.i("[Purchases] - " + logLevel30.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$6.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel31 = LogLevel.DEBUG;
                    LogHandler currentLogHandler28 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel31) <= 0) {
                        currentLogHandler28.d("[Purchases] - " + logLevel31.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$6.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$6.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel32 = LogLevel.INFO;
                    LogHandler currentLogHandler29 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel32) <= 0) {
                        currentLogHandler29.i("[Purchases] - " + logLevel32.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$6.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel33 = LogLevel.DEBUG;
                    LogHandler currentLogHandler30 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel33) <= 0) {
                        currentLogHandler30.d("[Purchases] - " + logLevel33.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$6.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel34 = LogLevel.DEBUG;
                    LogHandler currentLogHandler31 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel34) <= 0) {
                        currentLogHandler31.d("[Purchases] - " + logLevel34.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$6.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel35 = LogLevel.WARN;
                    LogHandler currentLogHandler32 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel35) <= 0) {
                        currentLogHandler32.w("[Purchases] - " + logLevel35.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$6.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel36 = LogLevel.WARN;
                    LogHandler currentLogHandler33 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel36) <= 0) {
                        currentLogHandler33.w("[Purchases] - " + logLevel36.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$6.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$6.invoke(), null);
                    break;
            }
        } catch (TimeoutException e12) {
            LogIntent logIntent5 = LogIntent.GOOGLE_ERROR;
            GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$4 googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$4 = new GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$4(logIntent5, e12);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent5.ordinal()]) {
                case 1:
                    LogLevel logLevel37 = LogLevel.DEBUG;
                    LogHandler currentLogHandler34 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel37) <= 0) {
                        currentLogHandler34.d("[Purchases] - " + logLevel37.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$4.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$4.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel38 = LogLevel.WARN;
                    LogHandler currentLogHandler35 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel38) <= 0) {
                        currentLogHandler35.w("[Purchases] - " + logLevel38.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$4.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel39 = LogLevel.INFO;
                    LogHandler currentLogHandler36 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel39) <= 0) {
                        currentLogHandler36.i("[Purchases] - " + logLevel39.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$4.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel40 = LogLevel.DEBUG;
                    LogHandler currentLogHandler37 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel40) <= 0) {
                        currentLogHandler37.d("[Purchases] - " + logLevel40.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$4.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$4.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel41 = LogLevel.INFO;
                    LogHandler currentLogHandler38 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel41) <= 0) {
                        currentLogHandler38.i("[Purchases] - " + logLevel41.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$4.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel42 = LogLevel.DEBUG;
                    LogHandler currentLogHandler39 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel42) <= 0) {
                        currentLogHandler39.d("[Purchases] - " + logLevel42.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$4.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel43 = LogLevel.DEBUG;
                    LogHandler currentLogHandler40 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel43) <= 0) {
                        currentLogHandler40.d("[Purchases] - " + logLevel43.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$4.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel44 = LogLevel.WARN;
                    LogHandler currentLogHandler41 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel44) <= 0) {
                        currentLogHandler41.w("[Purchases] - " + logLevel44.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$4.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel45 = LogLevel.WARN;
                    LogHandler currentLogHandler42 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel45) <= 0) {
                        currentLogHandler42.w("[Purchases] - " + logLevel45.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$4.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$4.invoke(), null);
                    break;
            }
        } catch (g e13) {
            LogIntent logIntent6 = LogIntent.GOOGLE_ERROR;
            GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$2 googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$2 = new GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$2(logIntent6, e13);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent6.ordinal()]) {
                case 1:
                    LogLevel logLevel46 = LogLevel.DEBUG;
                    LogHandler currentLogHandler43 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel46) <= 0) {
                        currentLogHandler43.d("[Purchases] - " + logLevel46.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$2.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$2.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel47 = LogLevel.WARN;
                    LogHandler currentLogHandler44 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel47) <= 0) {
                        currentLogHandler44.w("[Purchases] - " + logLevel47.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$2.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel48 = LogLevel.INFO;
                    LogHandler currentLogHandler45 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel48) <= 0) {
                        currentLogHandler45.i("[Purchases] - " + logLevel48.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$2.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel49 = LogLevel.DEBUG;
                    LogHandler currentLogHandler46 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel49) <= 0) {
                        currentLogHandler46.d("[Purchases] - " + logLevel49.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$2.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$2.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel50 = LogLevel.INFO;
                    LogHandler currentLogHandler47 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel50) <= 0) {
                        currentLogHandler47.i("[Purchases] - " + logLevel50.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$2.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel51 = LogLevel.DEBUG;
                    LogHandler currentLogHandler48 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel51) <= 0) {
                        currentLogHandler48.d("[Purchases] - " + logLevel51.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$2.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel52 = LogLevel.DEBUG;
                    LogHandler currentLogHandler49 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel52) <= 0) {
                        currentLogHandler49.d("[Purchases] - " + logLevel52.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$2.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel53 = LogLevel.WARN;
                    LogHandler currentLogHandler50 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel53) <= 0) {
                        currentLogHandler50.w("[Purchases] - " + logLevel53.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$2.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel54 = LogLevel.WARN;
                    LogHandler currentLogHandler51 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel54) <= 0) {
                        currentLogHandler51.w("[Purchases] - " + logLevel54.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$2.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$2.invoke(), null);
                    break;
            }
        } catch (h e14) {
            LogIntent logIntent7 = LogIntent.GOOGLE_ERROR;
            GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$3 googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$3 = new GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$3(logIntent7, e14);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent7.ordinal()]) {
                case 1:
                    LogLevel logLevel55 = LogLevel.DEBUG;
                    LogHandler currentLogHandler52 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel55) <= 0) {
                        currentLogHandler52.d("[Purchases] - " + logLevel55.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$3.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$3.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel56 = LogLevel.WARN;
                    LogHandler currentLogHandler53 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel56) <= 0) {
                        currentLogHandler53.w("[Purchases] - " + logLevel56.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$3.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel57 = LogLevel.INFO;
                    LogHandler currentLogHandler54 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel57) <= 0) {
                        currentLogHandler54.i("[Purchases] - " + logLevel57.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$3.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel58 = LogLevel.DEBUG;
                    LogHandler currentLogHandler55 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel58) <= 0) {
                        currentLogHandler55.d("[Purchases] - " + logLevel58.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$3.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$3.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel59 = LogLevel.INFO;
                    LogHandler currentLogHandler56 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel59) <= 0) {
                        currentLogHandler56.i("[Purchases] - " + logLevel59.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$3.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel60 = LogLevel.DEBUG;
                    LogHandler currentLogHandler57 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel60) <= 0) {
                        currentLogHandler57.d("[Purchases] - " + logLevel60.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$3.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel61 = LogLevel.DEBUG;
                    LogHandler currentLogHandler58 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel61) <= 0) {
                        currentLogHandler58.d("[Purchases] - " + logLevel61.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$3.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel62 = LogLevel.WARN;
                    LogHandler currentLogHandler59 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel62) <= 0) {
                        currentLogHandler59.w("[Purchases] - " + logLevel62.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$3.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel63 = LogLevel.WARN;
                    LogHandler currentLogHandler60 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel63) <= 0) {
                        currentLogHandler60.w("[Purchases] - " + logLevel63.name(), (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$3.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) googleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$3.invoke(), null);
                    break;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDeviceIdentifiers$lambda$0(GoogleDeviceIdentifiersFetcher googleDeviceIdentifiersFetcher, Application application, k kVar) {
        kVar.invoke(MapExtensionsKt.filterNotNullValues(o0.l(w.a(SubscriberAttributeKey.DeviceIdentifiers.GPSAdID.INSTANCE.getBackendKey(), googleDeviceIdentifiersFetcher.getAdvertisingID(application)), w.a(SubscriberAttributeKey.DeviceIdentifiers.IP.INSTANCE.getBackendKey(), b.f4545af), w.a(SubscriberAttributeKey.DeviceIdentifiers.DeviceVersion.INSTANCE.getBackendKey(), b.f4545af))));
    }

    @Override // com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher
    public void getDeviceIdentifiers(final Application applicationContext, final k completion) {
        t.f(applicationContext, "applicationContext");
        t.f(completion, "completion");
        Dispatcher.enqueue$default(this.dispatcher, new Runnable() { // from class: com.revenuecat.purchases.google.attribution.a
            @Override // java.lang.Runnable
            public final void run() {
                GoogleDeviceIdentifiersFetcher.getDeviceIdentifiers$lambda$0(this.f7333a, applicationContext, completion);
            }
        }, null, 2, null);
    }
}
