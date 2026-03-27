package com.dexterous.flutterlocalnotifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
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

/* JADX INFO: loaded from: classes.dex */
public class ActionBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f9523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static FlutterEngine f9524c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public J0.a f9525a;

    public static class a implements EventChannel.StreamHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f9526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public EventChannel.EventSink f9527b;

        public void a(Map map) {
            EventChannel.EventSink eventSink = this.f9527b;
            if (eventSink != null) {
                eventSink.success(map);
            } else {
                this.f9526a.add(map);
            }
        }

        @Override // io.flutter.plugin.common.EventChannel.StreamHandler
        public void onCancel(Object obj) {
            this.f9527b = null;
        }

        @Override // io.flutter.plugin.common.EventChannel.StreamHandler
        public void onListen(Object obj, EventChannel.EventSink eventSink) {
            Iterator it = this.f9526a.iterator();
            while (it.hasNext()) {
                eventSink.success((Map) it.next());
            }
            this.f9526a.clear();
            this.f9527b = eventSink;
        }

        public a() {
            this.f9526a = new ArrayList();
        }
    }

    public final void a(DartExecutor dartExecutor) {
        new EventChannel(dartExecutor.getBinaryMessenger(), "dexterous.com/flutter/local_notifications/actions").setStreamHandler(f9523b);
    }

    public final void b(Context context) {
        if (f9524c != null) {
            Log.e("ActionBroadcastReceiver", "Engine is already initialised");
            return;
        }
        FlutterLoader flutterLoader = FlutterInjector.instance().flutterLoader();
        flutterLoader.startInitialization(context);
        flutterLoader.ensureInitializationComplete(context, null);
        f9524c = new FlutterEngine(context);
        FlutterCallbackInformation flutterCallbackInformationD = this.f9525a.d();
        if (flutterCallbackInformationD == null) {
            Log.w("ActionBroadcastReceiver", "Callback information could not be retrieved");
            return;
        }
        DartExecutor dartExecutor = f9524c.getDartExecutor();
        a(dartExecutor);
        dartExecutor.executeDartCallback(new DartExecutor.DartCallback(context.getAssets(), flutterLoader.findAppBundlePath(), flutterCallbackInformationD));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("com.dexterous.flutterlocalnotifications.ActionBroadcastReceiver.ACTION_TAPPED".equalsIgnoreCase(intent.getAction())) {
            J0.a aVar = this.f9525a;
            if (aVar == null) {
                aVar = new J0.a(context);
            }
            this.f9525a = aVar;
            Map<String, Object> mapExtractNotificationResponseMap = FlutterLocalNotificationsPlugin.extractNotificationResponseMap(intent);
            if (intent.getBooleanExtra("cancelNotification", false)) {
                int iIntValue = ((Integer) mapExtractNotificationResponseMap.get("notificationId")).intValue();
                Object obj = mapExtractNotificationResponseMap.get("notificationTag");
                if (obj instanceof String) {
                    w.p.e(context).c((String) obj, iIntValue);
                } else {
                    w.p.e(context).b(iIntValue);
                }
            }
            if (f9523b == null) {
                f9523b = new a();
            }
            f9523b.a(mapExtractNotificationResponseMap);
            b(context);
        }
    }
}
