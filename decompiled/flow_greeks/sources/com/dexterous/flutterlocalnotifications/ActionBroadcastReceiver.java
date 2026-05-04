package com.dexterous.flutterlocalnotifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.Keep;
import h0.m;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.plugin.common.EventChannel;
import io.flutter.view.FlutterCallbackInformation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class ActionBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f5310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static FlutterEngine f5311c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e4.a f5312a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements EventChannel.StreamHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f5313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public EventChannel.EventSink f5314b;

        public void a(Map map) {
            EventChannel.EventSink eventSink = this.f5314b;
            if (eventSink != null) {
                eventSink.success(map);
            } else {
                this.f5313a.add(map);
            }
        }

        @Override // io.flutter.plugin.common.EventChannel.StreamHandler
        public void onCancel(Object obj) {
            this.f5314b = null;
        }

        @Override // io.flutter.plugin.common.EventChannel.StreamHandler
        public void onListen(Object obj, EventChannel.EventSink eventSink) {
            Iterator it = this.f5313a.iterator();
            while (it.hasNext()) {
                eventSink.success((Map) it.next());
            }
            this.f5313a.clear();
            this.f5314b = eventSink;
        }

        public a() {
            this.f5313a = new ArrayList();
        }
    }

    @Keep
    public ActionBroadcastReceiver() {
    }

    public final void a(DartExecutor dartExecutor) {
        new EventChannel(dartExecutor.getBinaryMessenger(), "dexterous.com/flutter/local_notifications/actions").setStreamHandler(f5310b);
    }

    public final void b(Context context) {
        if (f5311c != null) {
            Log.e("ActionBroadcastReceiver", "Engine is already initialised");
            return;
        }
        FlutterLoader flutterLoader = FlutterInjector.instance().flutterLoader();
        flutterLoader.startInitialization(context);
        flutterLoader.ensureInitializationComplete(context, null);
        f5311c = new FlutterEngine(context);
        FlutterCallbackInformation flutterCallbackInformationD = this.f5312a.d();
        if (flutterCallbackInformationD == null) {
            Log.w("ActionBroadcastReceiver", "Callback information could not be retrieved");
            return;
        }
        DartExecutor dartExecutor = f5311c.getDartExecutor();
        a(dartExecutor);
        dartExecutor.executeDartCallback(new DartExecutor.DartCallback(context.getAssets(), flutterLoader.findAppBundlePath(), flutterCallbackInformationD));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("com.dexterous.flutterlocalnotifications.ActionBroadcastReceiver.ACTION_TAPPED".equalsIgnoreCase(intent.getAction())) {
            e4.a aVar = this.f5312a;
            if (aVar == null) {
                aVar = new e4.a(context);
            }
            this.f5312a = aVar;
            Map<String, Object> mapExtractNotificationResponseMap = FlutterLocalNotificationsPlugin.extractNotificationResponseMap(intent);
            if (intent.getBooleanExtra("cancelNotification", false)) {
                int iIntValue = ((Integer) mapExtractNotificationResponseMap.get("notificationId")).intValue();
                Object obj = mapExtractNotificationResponseMap.get("notificationTag");
                if (obj instanceof String) {
                    m.e(context).c((String) obj, iIntValue);
                } else {
                    m.e(context).b(iIntValue);
                }
            }
            if (f5310b == null) {
                f5310b = new a();
            }
            f5310b.a(mapExtractNotificationResponseMap);
            b(context);
        }
    }
}
